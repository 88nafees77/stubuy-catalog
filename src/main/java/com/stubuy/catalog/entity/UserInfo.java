package com.stubuy.catalog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "user_info")
@Getter
@Setter
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer user_id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "userInfo")
  @Column
  @Cascade(CascadeType.ALL)
  private List<BooksInfo> booksInfo;
}
