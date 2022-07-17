package com.stubuy.catalog.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniversityAddress {

  @JsonProperty("AddressLine1")
  private String AddressLine1;
  @JsonProperty("AddressLine2")
  private String AddressLine2;
  @JsonProperty("CityName")
  private String CityName;
  @JsonProperty("State")
  private String State;
  @JsonProperty("Zipcode")
  private Integer Zipcode;



  @Override
  public String toString() {
    return "UniversityAddress{" + "AddressLine1='" + AddressLine1 + '\'' + ", AddressLine2='"
        + AddressLine2 + '\'' + ", CityName='" + CityName + '\'' + ", State='" + State + '\''
        + ", Zipcode=" + Zipcode + '}';
  }

  public static UniversityAddressBuilder builder() {
    return new UniversityAddressBuilder();
  }


  public static class UniversityAddressBuilder {
    private String AddressLine1;
    private String AddressLine2;
    private String CityName;
    private String State;
    private Integer Zipcode;


    public UniversityAddressBuilder setAddressLine1(String addressLine1) {
      AddressLine1 = addressLine1;
      return this;
    }

    public UniversityAddressBuilder setAddressLine2(String addressLine2) {
      AddressLine2 = addressLine2;
      return this;
    }

    public UniversityAddressBuilder setCityName(String cityName) {
      CityName = cityName;
      return this;
    }

    public UniversityAddressBuilder setState(String state) {
      State = state;
      return this;
    }

    public UniversityAddressBuilder setZipcode(Integer zipcode) {
      Zipcode = zipcode;
      return this;
    }

    public UniversityAddress build() {
      return new UniversityAddress(AddressLine1, AddressLine2, CityName, State, Zipcode);
    }
  }

}
