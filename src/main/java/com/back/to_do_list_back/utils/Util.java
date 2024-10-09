package com.back.to_do_list_back.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
    /**
   * Function that transforms an object into a character string in JSON format.
   *
   * @param obj Object to transform.
   * @return String in JSON format to return.
   */
  public static String asJsonString(final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      final String jsonContent = mapper.writeValueAsString(obj);
      return jsonContent;
    } catch (Exception e) {
      throw new RuntimeException(e.toString());
    }
  }
}
