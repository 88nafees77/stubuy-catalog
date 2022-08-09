package com.stubuy.catalog.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "branch_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BranchEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer branchId;

  private String branch_Name;

  @ManyToOne
  private CourseEntity courseEntity;

  @OneToMany(mappedBy = "branchEntity")
  private List<BooksEntity> entityList;

}
