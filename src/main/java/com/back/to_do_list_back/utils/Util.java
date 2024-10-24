package com.back.to_do_list_back.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Util {
    /**
   * Function that transforms an object into a character string in JSON format.
   *
   * @param obj Object to transform.
   * @return String in JSON format to return.
   */
    public static String asJsonString(final Object obj) {
      try {
        // Create an ObjectMapper and register the JavaTimeModule to manage LocalDate.
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Registers the JavaTime module.
        // Converts object to JSON string.
        final String jsonContent = mapper.writeValueAsString(obj);
        return jsonContent;
      } catch (Exception e) {
        throw new RuntimeException(e.toString());
      }
    }
}
