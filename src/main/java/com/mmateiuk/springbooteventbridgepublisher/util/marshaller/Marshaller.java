package com.mmateiuk.springbooteventbridgepublisher.util.marshaller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Marshaller {

  private static final ObjectMapper MAPPER = createObjectMapper();

  public static <T> String marshal(T value) throws IOException {
    return MAPPER.writeValueAsString(value);
  }

  private static ObjectMapper createObjectMapper() {
    return new ObjectMapper()
            .findAndRegisterModules()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
  }
}
