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
public class Wind {

    @JacksonXmlProperty
    private String direction;
    @JacksonXmlProperty(localName = "speedmin")
    private Integer speedMin;
    @JacksonXmlProperty(localName = "speedmax")
    private Integer speedMax;

}
