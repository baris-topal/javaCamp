package day3;

public class UserManager {

	public void  add(Student student) {
		
		System.out.println(student.getFirstName()+" adlı öğrenci eklendi.");
		
	}

	public void  add(Instructor instructor) {
		
		System.out.println(instructor.getFirstName()+ " adlı eğitmen eklendi.");
		
	}
	
	
}
