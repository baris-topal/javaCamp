package day3;

public class InstructorManager  extends UserManager  {

	public void viewStudent(Student student) {
		
		System.out.println("Dersi alan ��renci: " + student.getFirstName());
		
	}
	
public void information(Instructor instructor) {
		
		System.out.println(instructor.getFirstName()+" "+instructor.getLastName()+" verdi�iniz ders: "+instructor.getGiveLesson());
		
		
	}
}
