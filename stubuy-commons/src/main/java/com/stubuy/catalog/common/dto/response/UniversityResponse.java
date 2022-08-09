package com.stubuy.catalog.common.dto.response;

import java.util.List;

import com.stubuy.catalog.common.dto.response.common.ResponseMessage;
import com.stubuy.catalog.common.dto.request.AddressRequest;

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

  private List<AddressRequest> universityAddress;


  @Override
  public String toString() {
    return "UniversityResponse{" + "universityId=" + universityId + ", universityName='"
        + universityName + '\'' + ", universityAddress=" + universityAddress + '}';
  }

  public static UniversityResponseBuilder builder() {
    return new UniversityResponseBuilder();
  }

  public static class UniversityResponseBuilder {
    private Integer universityId;

    private String universityName;

    private List<AddressRequest> universityAddress;

    public UniversityResponseBuilder setUniversityId(Integer universityId) {
      this.universityId = universityId;
      return this;
    }

    public UniversityResponseBuilder setUniversityName(String universityName) {
      this.universityName = universityName;
      return this;
    }

    public UniversityResponseBuilder setUniversityAddress(
        List<AddressRequest> universityAddress) {
      this.universityAddress = universityAddress;
      return this;
    }

    public UniversityResponse build() {
      return new UniversityResponse(universityId, universityName, universityAddress);
    }
  }


}
