package com.stubuy.catalog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "university_address")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniversityAddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer addressId;

  private Integer Zipcode;

  private String AddressLine1;

  private String AddressLine2;

  private String CityName;

  private String State;

  @ManyToOne
  @Cascade(CascadeType.ALL)
  private UniversityEntity universityEntity;


}
