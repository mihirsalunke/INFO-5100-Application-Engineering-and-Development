package Assignment_3_part_1;

class Student{

	private String studentName;
	private int studentId;

	Student(String studentName, int studentId){
		this.studentName = studentName;
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getStudentId() {
		return studentId;
	}
}

class Course {
	private String courseName;
	private int numberOfStudents;
	Student[] students;

	Course(String courseName){
		this.courseName = courseName;
		this.students = new Student[10];
		this.numberOfStudents = 0;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public Student[] getStudents(String courseName) {
		return students;
	}

	public boolean isFull(String courseName) {
		return numberOfStudents >= 10; 
	}

	public void registerStudent(Student student) {
		if (isFull(courseName)) {
			System.out.println("Course is full");
		} else {
			students[this.numberOfStudents] = student;
			++this.numberOfStudents;
		}	 	
	}

}

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student("Mihir", 100);
		Student s2 = new Student("Kria", 101);
		Student s3 = new Student("Kinsh", 102);
		Student s4 = new Student("Apar", 103);
		Student s5 = new Student("Sid", 104);
		Student s6 = new Student("Aditya", 105);
		Student s7 = new Student("Surbhi", 106);
		Student s8 = new Student("Ankur", 107);
		Student s9 = new Student("Aniket", 108);
		Student s10 = new Student("Bidisha", 109);
		Student s11 = new Student("Nikhil", 110);
		Student s12 = new Student("Shiv", 111);

		Course aed = new Course("Application Engineering and Development");
		Course algo = new Course("Data Structurs and Algorithm");
		aed.registerStudent(s1);
		aed.registerStudent(s2);
		aed.registerStudent(s3);
		aed.registerStudent(s4);
		aed.registerStudent(s5);
		aed.registerStudent(s6);
		aed.registerStudent(s7);
		aed.registerStudent(s8);
		aed.registerStudent(s9);
		aed.registerStudent(s10);
		algo.registerStudent(s2);
		algo.registerStudent(s11);
		algo.registerStudent(s12);

		Student[] students = aed.getStudents(aed.getCourseName());
		for(Student student: students) {
			System.out.println(student.getStudentName());
		}
		s1.getStudentId();
		s1.getStudentId();
		aed.getCourseName();
		aed.getNumberOfStudents();
		System.out.println(aed.isFull(aed.getCourseName()));
	}
}
