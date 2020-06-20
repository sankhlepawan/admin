package com.mm.admin.model.v1;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQueries({
	@NamedQuery(name="findByFileName",query="select f from FileUpload f where f.name= :name"),
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wb_file")
public class FileUpload implements Serializable{
		   
		   private static final long serialVersionUID = 1L;

		   @Id
		   @GeneratedValue(strategy = GenerationType.AUTO)
		   private int id;
		   
		   @Column(name="path")
		   private String path;
		   
		   @Column(name="name")
		   private String name;
		   
		   @Column(name="size")
		   private long size;
		   
		   @Column(name="type")
		   private String fileType;
		   
		   @Column(name = "bio_id")
		   private int bioId;
		   
		   
}
