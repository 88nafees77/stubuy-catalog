package com.stubuy.catalog.dto.response;

import java.util.List;

import com.stubuy.catalog.dto.request.UniversityAddress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUniversityResponse {

  private Integer universityId;

  private String universityName;

  private List<UniversityAddress> universityAddress;

  public static GetAllUniversityResponseBuilder builder() {
    return new GetAllUniversityResponseBuilder();
  }

  static class GetAllUniversityResponseBuilder {
    private Integer universityId;

    private String universityName;

    private List<UniversityAddress> universityAddress;

    public GetAllUniversityResponseBuilder setUniversityId(Integer universityId) {
      this.universityId = universityId;
      return this;
    }

    public GetAllUniversityResponseBuilder setUniversityName(String universityName) {
      this.universityName = universityName;
      return this;
    }

    public GetAllUniversityResponseBuilder setUniversityAddress(
        List<UniversityAddress> universityAddress) {
      this.universityAddress = universityAddress;
      return this;
    }

    public GetAllUniversityResponse build() {
      return new GetAllUniversityResponse(universityId, universityName, universityAddress);
    }
  }


}
