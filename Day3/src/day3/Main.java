package day3;

public class Main {

	public static void main(String[] args) {
		
		Student student = new Student();
		
		student.setId(1);
		student.setFirstName("baris");
		student.setLastName("topal");
		student.setTakeLesson("java");

		Instructor instructor = new Instructor();
		
		instructor.setId(1);
		instructor.setFirstName("engin");
		instructor.setLastName("demiroğ");
		instructor.setGiveLesson("java");
		
	
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor);
		instructorManager.information(instructor);
		

		StudentManager studentManager = new StudentManager();
		studentManager.add(student);
		studentManager.information(student);

		
		
		
	}

}
