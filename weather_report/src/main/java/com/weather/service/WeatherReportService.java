package com.weather.service;

import com.weather.client.WeatherReportClient;
import com.weather.mapper.WeatherReportMapper;
import com.weather.model.dto.WeatherResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherReportService {

    @Autowired
    private WeatherReportClient weatherReportClient;

    @Autowired
    private WeatherReportMapper weatherReportMapper;

    public List<WeatherResponseDto> findWeatherReport(String language) {
        return weatherReportMapper.weatherForcastDaoToWeatherResponseDto(weatherReportClient.getWeatherForecast(language));
    }
}
