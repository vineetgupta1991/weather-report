package com.weather.client;

import com.weather.model.dao.Forecast;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "weather-report", path = "ilma_andmed/xml", url = "${weather-report.api}")
public interface WeatherReportClient {

    @GetMapping(value = "/forecast.php")
    List<Forecast> getWeatherForecast(@RequestParam String lang);
}
