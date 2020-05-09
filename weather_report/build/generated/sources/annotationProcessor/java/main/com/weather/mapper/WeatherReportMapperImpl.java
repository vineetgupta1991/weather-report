package com.weather.mapper;

import com.weather.model.dao.DailyForecast;
import com.weather.model.dao.Forecast;
import com.weather.model.dao.Place;
import com.weather.model.dao.Wind;
import com.weather.model.dto.PlacesDto;
import com.weather.model.dto.WeatherResponseDto;
import com.weather.model.dto.WindDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-09T00:31:57+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class WeatherReportMapperImpl implements WeatherReportMapper {

    @Override
    public WeatherResponseDto weatherForcastDaoToWeatherResponseDto(Forecast weatherForcast) {
        if ( weatherForcast == null ) {
            return null;
        }

        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();

        Integer maxTemperature = weatherForcastDayMaxTemperature( weatherForcast );
        if ( maxTemperature != null ) {
            weatherResponseDto.setMaxTemperature( maxTemperature );
        }
        List<Place> place = weatherForcastNightPlace( weatherForcast );
        weatherResponseDto.setPlaces( placeListToPlacesDtoList( place ) );
        weatherResponseDto.setPhenomenon( weatherForcastDayPhenomenon( weatherForcast ) );
        Integer minTemperature = weatherForcastNightMinTemperature( weatherForcast );
        if ( minTemperature != null ) {
            weatherResponseDto.setMinTemperature( minTemperature );
        }
        List<Wind> wind = weatherForcastDayWind( weatherForcast );
        weatherResponseDto.setWind( windListToWindDtoList( wind ) );
        weatherResponseDto.setDate( weatherForcast.getDate() );

        return weatherResponseDto;
    }

    private Integer weatherForcastDayMaxTemperature(Forecast forecast) {
        if ( forecast == null ) {
            return null;
        }
        DailyForecast day = forecast.getDay();
        if ( day == null ) {
            return null;
        }
        Integer maxTemperature = day.getMaxTemperature();
        if ( maxTemperature == null ) {
            return null;
        }
        return maxTemperature;
    }

    private List<Place> weatherForcastNightPlace(Forecast forecast) {
        if ( forecast == null ) {
            return null;
        }
        DailyForecast night = forecast.getNight();
        if ( night == null ) {
            return null;
        }
        List<Place> place = night.getPlace();
        if ( place == null ) {
            return null;
        }
        return place;
    }

    protected PlacesDto placeToPlacesDto(Place place) {
        if ( place == null ) {
            return null;
        }

        PlacesDto placesDto = new PlacesDto();

        placesDto.setName( place.getName() );
        placesDto.setPhenomenon( place.getPhenomenon() );
        placesDto.setMinTemperature( place.getMinTemperature() );

        return placesDto;
    }

    protected List<PlacesDto> placeListToPlacesDtoList(List<Place> list) {
        if ( list == null ) {
            return null;
        }

        List<PlacesDto> list1 = new ArrayList<PlacesDto>( list.size() );
        for ( Place place : list ) {
            list1.add( placeToPlacesDto( place ) );
        }

        return list1;
    }

    private String weatherForcastDayPhenomenon(Forecast forecast) {
        if ( forecast == null ) {
            return null;
        }
        DailyForecast day = forecast.getDay();
        if ( day == null ) {
            return null;
        }
        String phenomenon = day.getPhenomenon();
        if ( phenomenon == null ) {
            return null;
        }
        return phenomenon;
    }

    private Integer weatherForcastNightMinTemperature(Forecast forecast) {
        if ( forecast == null ) {
            return null;
        }
        DailyForecast night = forecast.getNight();
        if ( night == null ) {
            return null;
        }
        Integer minTemperature = night.getMinTemperature();
        if ( minTemperature == null ) {
            return null;
        }
        return minTemperature;
    }

    private List<Wind> weatherForcastDayWind(Forecast forecast) {
        if ( forecast == null ) {
            return null;
        }
        DailyForecast day = forecast.getDay();
        if ( day == null ) {
            return null;
        }
        List<Wind> wind = day.getWind();
        if ( wind == null ) {
            return null;
        }
        return wind;
    }

    protected WindDto windToWindDto(Wind wind) {
        if ( wind == null ) {
            return null;
        }

        WindDto windDto = new WindDto();

        windDto.setDirection( wind.getDirection() );
        windDto.setSpeedMax( wind.getSpeedMax() );
        windDto.setSpeedMin( wind.getSpeedMin() );

        return windDto;
    }

    protected List<WindDto> windListToWindDtoList(List<Wind> list) {
        if ( list == null ) {
            return null;
        }

        List<WindDto> list1 = new ArrayList<WindDto>( list.size() );
        for ( Wind wind : list ) {
            list1.add( windToWindDto( wind ) );
        }

        return list1;
    }
}
