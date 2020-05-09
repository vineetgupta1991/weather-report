package com.weather.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {
    @JacksonXmlProperty
    private String name;
    @JacksonXmlProperty
    private String phenomenon;
    @JacksonXmlProperty(localName = "tempmin")
    private Integer minTemperature;
    @JacksonXmlProperty(localName = "tempmax")
    private Integer maxTemperature;
}
