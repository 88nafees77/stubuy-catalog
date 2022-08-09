package com.stubuy.catalog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "user_info")
@Getter
@Setter
@Builder
public class UserEntity {

  @Id
  @Column(name = "email")
  private String email;

  private String mobileNumber;

  @Column(name = "password")
  private String password;

  @Column(name = "isActive")
  private boolean isActive;

  @Cascade(CascadeType.ALL)
  @OneToMany(mappedBy = "userEntity")
  private List<UserContactEntity> contactEntities;

  @Cascade(CascadeType.ALL)
  @OneToMany(mappedBy = "userEntity")
  private List<BooksEntity> booksEntity;

}
