package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import play.db.jpa.GenericModel;

@Entity
@Table(name = "localuser_")
public class LocalUser extends GenericModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
	
    @OneToOne
    @JoinColumn(name="student")
	public Student student;
	
    public int points;
    
    @OneToOne
    @JoinColumn(name="lastQuestion_")
    public Question lastQuestion;
}