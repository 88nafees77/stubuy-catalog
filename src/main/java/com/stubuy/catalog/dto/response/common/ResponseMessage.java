package com.stubuy.catalog.dto.response.common;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {

  private HttpStatus responseCode;

  private String responseMessage;

}
