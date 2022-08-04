package com.stubuy.catalog.dto.request;


import lombok.Getter;

@Getter
public class UniversityRegisterRequest {

  private String universityName;
  private AddressRequest universityAddress;

  private UniversityRegisterRequest(String universityName, AddressRequest universityAddress) {
    this.universityName = universityName;
    this.universityAddress = universityAddress;
  }

  @Override
  public String toString() {
    return "UniversityRegisterRequest{" + "universityName='" + universityName + '\''
        + ", universityAddress=" + universityAddress + '}';
  }

  public static UniversityRegisterRequestBuilder builder() {
    return new UniversityRegisterRequestBuilder();
  }

  static class UniversityRegisterRequestBuilder {
    private String universityName;
    private AddressRequest universityAddress;


    public UniversityRegisterRequestBuilder setUniversityName(String universityName) {
      this.universityName = universityName;
      return this;
    }

    public UniversityRegisterRequestBuilder setUniversityAddress(
        AddressRequest universityAddress) {
      this.universityAddress = universityAddress;
      return this;
    }

    public UniversityRegisterRequest build() {
      return new UniversityRegisterRequest(universityName, universityAddress);
    }

  }


}


