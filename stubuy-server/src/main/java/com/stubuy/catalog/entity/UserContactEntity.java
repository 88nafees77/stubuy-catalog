package com.stubuy.catalog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "user_contact_info")
@Getter
@Setter
@Builder
public class UserContactEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer contactID;

  private String firstName;

  private String lastName;

  @Column(name = "createOn")
  private Timestamp time;

  private Integer Zipcode;

  private String AddressLine1;

  private String AddressLine2;

  private String CityName;

  private String State;

  @ManyToOne
  private UserEntity userEntity;

}
