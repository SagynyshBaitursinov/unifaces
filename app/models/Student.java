package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import play.db.jpa.GenericModel;

@Entity
@Table(name = "student_")
public class Student extends GenericModel {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	public Integer id;
	
	public String email;
	
	@Column(name="ismale")
	public boolean isMale;
	
	public String school;
	
    @OneToOne(mappedBy = "student")
    @PrimaryKeyJoinColumn
    public LocalUser localUser;
    
    public String nuid;
    
    public String name;
}
