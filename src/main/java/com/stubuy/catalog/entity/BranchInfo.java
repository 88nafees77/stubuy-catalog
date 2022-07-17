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
@Table(name = "branch_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BranchInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer branch_id;

  @Column(name = "branch_name")
  private String branch_Name;

  @ManyToOne
  private CourseEntity courseEntity;

}
