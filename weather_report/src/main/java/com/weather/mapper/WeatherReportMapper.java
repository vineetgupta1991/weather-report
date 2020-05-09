package com.weather.mapper;

import com.weather.model.dao.Forecast;
import com.weather.model.dto.WeatherResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WeatherReportMapper {

    @Mapping(target = "maxTemperature", source = "day.maxTemperature")
    @Mapping(target = "minTemperature", source = "night.minTemperature")
    @Mapping(target = "wind", source = "day.wind")
    @Mapping(target = "places", source = "night.place")
    @Mapping(target = "phenomenon", source = "day.phenomenon")
    WeatherResponseDto weatherForcastDaoToWeatherResponseDto(Forecast weatherForcast);


    default List<WeatherResponseDto> weatherForcastDaoToWeatherResponseDto(List<Forecast> weatherForcast) {
        return weatherForcast.stream()
                .map(this::weatherForcastDaoToWeatherResponseDto)
                .collect(Collectors.toList());

    }

}
