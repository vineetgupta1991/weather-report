package com.weather.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpLogWriter;
import org.zalando.logbook.Precorrelation;

import java.io.IOException;

@Configuration
public class LogInterceptor implements HttpLogWriter {
    private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public void writeRequest(Precorrelation<String> precorrelation) throws IOException {
        logger.info("Request uri = {}", precorrelation.getOriginalRequest().getRequestUri());
        logger.debug("Request body = {}", precorrelation.getOriginalRequest().getBodyAsString());
        logger.info("Request Headers = {}", precorrelation.getOriginalRequest().getHeaders().toString());
        logger.info("Request method = {}", precorrelation.getOriginalRequest().getMethod());
        logger.info("Correlation ID request = {}", precorrelation.getId());
    }

    @Override
    public void writeResponse(Correlation<String, String> correlation) throws IOException {
        logger.debug("Response body = {}", correlation.getOriginalResponse().getBodyAsString());
        logger.info("Response Status = {}", correlation.getOriginalResponse().getStatus());
        logger.info("Response Headers = {}", correlation.getOriginalResponse().getHeaders().toString());
        logger.info("Correlation ID response = {}", correlation.getId());
    }

}
