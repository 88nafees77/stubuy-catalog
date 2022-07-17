package com.stubuy.catalog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UniversityRegisterResponse {

  private Integer responseCode;
  private String responseMessage;

  public static UniversityRegisterResponseBuilder builder() {
    return new UniversityRegisterResponseBuilder();
  }

  static class UniversityRegisterResponseBuilder {
    private Integer responseCode;
    private String responseMessage;

    public UniversityRegisterResponseBuilder setResponseCode(Integer responseCode) {
      this.responseCode = responseCode;
      return this;
    }

    public UniversityRegisterResponseBuilder setResponseMessage(String responseMessage) {
      this.responseMessage = responseMessage;
      return this;
    }

    public UniversityRegisterResponse build() {
      return new UniversityRegisterResponse(responseCode, responseMessage);
    }
  }
}
