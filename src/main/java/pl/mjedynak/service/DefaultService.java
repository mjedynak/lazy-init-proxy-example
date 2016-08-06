package pl.mjedynak.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class DefaultService implements Service {

    private static final Logger logger = LoggerFactory.getLogger(DefaultService.class.getName());

    public DefaultService() {
        logger.debug("Initializing service");
    }

    @Override
    public LocalDateTime getTime() {
        return now();
    }
}
