package jobs;

import java.util.List;

import models.Student;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class StudentLoader extends Job {

    public static List<Student> students;
    
    public void doJob() {
    	students = Student.findAll();
    }
}
