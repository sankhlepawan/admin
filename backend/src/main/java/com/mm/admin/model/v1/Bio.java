package com.mm.admin.model.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQueries({
	@NamedQuery(name="findByBioId",query="select b from Bio b where b.id= :bioId"),
})

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wb_bio")
public class Bio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private long id;
	   
	   @Column(name = "name")
	   private String name;
	   
	   @Column(name = "gender")
	   @Enumerated(EnumType.STRING)
	   private GenderType gender;
	   
	   @Column(name = "dob")
	   private Date dob;
	   
	   @Column(name = "birth_place")
	   private String birthPlace;
	   
	   @Enumerated(EnumType.STRING)
	   @Column(name = "eating_habits")
	   private EatingHabitsType eatingHabits;
	   
	   
	   @Column
	   private String height;
	   private String weight;
	   private String complextion;
	   private String qualification;
	   private String occupation;
	   private String birthTime;
	   private String salary;
	   private boolean working;
	   private boolean petlover;
	   private String currentWorkLocation;
	   private String motherName;
	   private String fathername;
	   private String fatherOccupation;
	   private String motherOccupation;
	   private String city;
	   private String country;
	   private String state;
	   private String gotra;
	   private String fullAddress;
	   private String primaryContactNumber;
	   private String secondaryContactNumber;
	   private String siblings;	
	   private String profilePic;
	   
	   @Column(name = "eating_habits")
	   @OneToMany(cascade=CascadeType.ALL)
	   @JoinColumn(name="file_id")
	   private List<FileUpload> files;
	   
}
