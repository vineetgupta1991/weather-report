package com.weather.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {

    @JacksonXmlProperty
    private String text;
    @JacksonXmlProperty
    private String phenomenon;
    @JacksonXmlProperty(localName = "tempmin")
    private Integer minTemperature;

    @JacksonXmlProperty(localName = "tempmax")
    private Integer maxTemperature;
    @JacksonXmlProperty(localName = "place")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Place> place;
    @JacksonXmlProperty(localName = "wind")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Wind> wind;
}
