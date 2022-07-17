package com.stubuy.catalog.dto.response;

import java.util.List;

import com.stubuy.catalog.dto.request.UniversityAddress;
import com.stubuy.catalog.dto.response.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UniversityResponse extends ResponseMessage {

  private Integer universityId;

  private String universityName;

  private List<UniversityAddress> universityAddress;

  public static UniversityResponseBuilder builder() {
    return new UniversityResponseBuilder();
  }

  public static class UniversityResponseBuilder {
    private Integer universityId;

    private String universityName;

    private List<UniversityAddress> universityAddress;

    public UniversityResponseBuilder setUniversityId(Integer universityId) {
      this.universityId = universityId;
      return this;
    }

    public UniversityResponseBuilder setUniversityName(String universityName) {
      this.universityName = universityName;
      return this;
    }

    public UniversityResponseBuilder setUniversityAddress(
        List<UniversityAddress> universityAddress) {
      this.universityAddress = universityAddress;
      return this;
    }

    public UniversityResponse build() {
      return new UniversityResponse(universityId, universityName, universityAddress);
    }
  }


}
