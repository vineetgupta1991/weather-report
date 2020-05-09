package com.weather.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponseDto {

    private String date;
    private int maxTemperature;
    private int minTemperature;
    private String phenomenon;
    private List<PlacesDto> places;
    private List<WindDto> wind;


}
