package day3;

public class StudentManager extends UserManager {

	public void viewInstructor(Instructor instructor) {
		
		System.out.println(instructor.getFirstName()+" adl� e�itmenden dersi al�yorsunuz. ");
		
	}
	
	public void information(Student student) {
		
		System.out.println(student.getFirstName()+" "+student.getLastName()+" ald���n�z ders: "+student.getTakeLesson());
		
		
	}
	
}
