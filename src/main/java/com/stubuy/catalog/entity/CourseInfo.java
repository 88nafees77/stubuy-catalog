package com.stubuy.catalog.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "course_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer courseId;

  private String courseName;

  @ManyToOne
  @JoinColumn(name = "university_id",
              nullable = false)
  private UniversityEntity universityEntity;

  @OneToMany(mappedBy = "courseInfo")
  private List<BranchInfo> branchInfos;

}
