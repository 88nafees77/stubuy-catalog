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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "university_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer university_id;

  @Column(name = "university_name")
  private String universityName;

  @Cascade(CascadeType.ALL)
  @OneToMany(mappedBy = "universityEntity")
  private List<UniversityAddressEntity> addressInfo;

  @Cascade(CascadeType.ALL)
  @OneToMany(mappedBy = "universityEntity")
  private List<CourseEntity> courseEntities;


}
