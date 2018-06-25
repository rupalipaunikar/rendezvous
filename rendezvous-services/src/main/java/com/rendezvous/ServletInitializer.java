package com.rendezvous;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ServletInitializer to enable to REST API exposure.
 *
 * @author Rupali Paunikar
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Method to configure application.
     *
     * @param application the application.
     * @return SpringApplicationBuilder.
     */
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(RendezvousApplication.class);
    }
}
