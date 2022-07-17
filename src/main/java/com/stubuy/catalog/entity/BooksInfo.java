package com.stubuy.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "book_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BooksInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer book_id;

  @Column(name = "book_name")
  private String books_name;

  @Column(name = "book_status")
  private boolean book_status;

  @Column(name = "book_price")
  private float book_price;

  @ManyToOne
  private CourseEntity courseEntity;

  @ManyToOne
  private UserInfo userInfo;

}
