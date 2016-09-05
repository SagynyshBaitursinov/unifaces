package models;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import play.db.jpa.GenericModel;

@Entity
@Table(name = "question_")
public class Question extends GenericModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
	
	public boolean answered;
	
	public int rightAnswer;
	
	@ManyToOne
	@JoinColumn(name="localuser_")
	public LocalUser localUser;
	
	@Transient
	public Student first;
	
	@Transient
	public Student second;
	
	public Date createdDate;
	
	@Transient
	public Student third;
	
	@Transient
	public Student fourth;
	
	public Question(Student rightAnswer, Student second, Student third, Student fourth, LocalUser localUser) {
		this.rightAnswer = rightAnswer.id;
		this.answered = false;
		this.first = rightAnswer;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.localUser = localUser;
		this.createdDate = new Date();
		Student dub;
		switch (new Random().nextInt(4)) {
			case 1:
				dub = this.first;
				this.first = this.second;
				this.second = dub;
				break;
			case 2:
				dub = this.first;
				this.first = this.third;
				this.third = dub;
				break;
			case 3:
				dub = this.first;
				this.first = this.fourth;
				this.fourth = dub;
				break;
			default:
				break;
		}
	}
	
	public String toJson() {
		return "{\"id\": \"" + id + "\", \"name1\": \"" + first.name + "\", \"name2\": \"" + second.name + "\", \"name3\": \"" + third.name + "\", \"name4\": \"" + fourth.name + "\", \"id1\": \"" + first.id + "\", \"id2\": \"" + second.id + "\", \"id3\": \"" + third.id + "\", \"id4\": \"" + fourth.id + "\"}";
	}
}
