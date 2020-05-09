package com.weather.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Forecast {

    @JacksonXmlProperty
    private String date;
    @JacksonXmlProperty
    private DailyForecast night;
    @JacksonXmlProperty
    private DailyForecast day;


}
