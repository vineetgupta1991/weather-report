package com.weather.controller;

import com.weather.client.WeatherReportClient;
import com.weather.model.dao.DailyForecast;
import com.weather.model.dao.Forecast;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@SpringJUnitConfig
@ActiveProfiles("TEST")
public class WeatherReportControllerTest {
    private static final String RAW_URL = "/v1/weather/";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WeatherReportClient weatherReportClient;

    @Before
    public void initSetup() {
        Forecast forecast = Forecast.builder()
                .date("2020-05-09")
                .day(new DailyForecast("Sunny", "Clear", null, 6,null,null))
                .night(new DailyForecast("rainy", "Clear", null,0,null,null))
                .build();
        when(weatherReportClient.getWeatherForecast(anyString())).thenReturn(Arrays.asList(forecast));
    }

    @Test
    public void shouldFindWeatherReport() throws Exception {
        mockMvc.perform(get(RAW_URL + "report")
                .header("language","eng"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    public void shouldNotExecuteWithMissingHeader() throws Exception {
        mockMvc.perform(get(RAW_URL + "report"))
                .andExpect(status().isBadRequest());
    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowExceptionOnClientFailure() throws Exception {
        when(weatherReportClient.getWeatherForecast(anyString())).thenThrow(new InternalError("Internal Server error occurred"));
        mockMvc.perform(get(RAW_URL + "report")
                .header("language","eng"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void shouldThrowNotFoundExceptionOnWrongUrl() throws Exception {
        mockMvc.perform(get(RAW_URL + "test-report")
                .header("language","eng"))
                .andExpect(status().isNotFound());
    }

}
