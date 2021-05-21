package day3;

public class StudentManager extends UserManager {

	public void viewInstructor(Instructor instructor) {
		
		System.out.println(instructor.getFirstName()+" adlý eðitmenden dersi alýyorsunuz. ");
		
	}
	
	public void information(Student student) {
		
		System.out.println(student.getFirstName()+" "+student.getLastName()+" aldýðýnýz ders: "+student.getTakeLesson());
		
		
	}
	
}
