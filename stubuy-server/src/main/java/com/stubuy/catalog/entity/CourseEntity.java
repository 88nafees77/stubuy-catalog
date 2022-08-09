package com.stubuy.catalog.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "course_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer courseId;

  private String courseName;

  @ManyToOne
  private UniversityEntity universityEntity;

  @Cascade(CascadeType.ALL)
  @OneToMany(mappedBy = "courseEntity")
  private List<BranchEntity> branchEntity;

}
