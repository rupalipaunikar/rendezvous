package com.rendezvous.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Serializer to serialize date in a specific format.
 *
 * @author Rupali Paunikar
 */
public class JsonDateSerializer extends JsonSerializer<Date> {

    /**
     * Method to serialize date in a specific format.
     *
     * @param date               the date.
     * @param jsonGenerator      the jsonGenerator.
     * @param serializerProvider the serializerProvider.
     * @throws IOException the {@link IOException}.
     */
    @Override
    public void serialize(final Date date, final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider) throws IOException {

        final SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        final String formattedDate = formatter.format(date);
        jsonGenerator.writeString(formattedDate);
    }
}

