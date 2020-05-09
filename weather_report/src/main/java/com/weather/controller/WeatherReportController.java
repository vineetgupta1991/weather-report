package com.weather.controller;

import com.weather.model.dto.WeatherResponseDto;
import com.weather.service.WeatherReportService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Weather")
@RestController
@RequestMapping("v1/weather")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @ApiOperation(value = "Get weather forecast")
    @ApiImplicitParam(name = "language", required = true, dataType = "string", paramType = "header", value = "", defaultValue = "eng")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Validation Failed"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/report")
    public List<WeatherResponseDto> findWeatherReport(@RequestHeader String language) {
        return weatherReportService.findWeatherReport(language);
    }

}
