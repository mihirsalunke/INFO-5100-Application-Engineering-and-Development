package studentInformationSystem;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentApplicationInterface extends JFrame{

	static JTextField firstNameTextField;
	static JTextField lastNameTextField;
	static JTextField studentIDTextField;

	private JLabel enterDetails; 
	private JLabel firstName;
	private JLabel lastName; 
	private JLabel studentID; 
	private JLabel genderLabel;

	private JButton addStudent;
	private JButton viewStudents;

	private static JRadioButton maleRB;
	private static JRadioButton femaleRB;

	private Font font1, font2, font3;

	private static String fName;
	private static String lName;
	private static String gender;
	private static String sID;

	private static JFrame frame;
	private static Container c;
	private static Students s;

	private static boolean First = true;

	public StudentApplicationInterface() {

		frame = new JFrame("Northeastern University, Seattle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = frame.getContentPane();

		createComponents();
		setLayout();
		addComponents();

		maleRB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gender = "Male";
			}
		});

		femaleRB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gender = "Female";
			}
		});
		AddStudentClicked asc = new AddStudentClicked();
		addStudent.addActionListener(asc);

		ViewStudentsClicked vsc = new ViewStudentsClicked();
		viewStudents.addActionListener(vsc);

		frame.setSize(400, 400);
		frame.setVisible(true);	
	}	

	private void createComponents() {
		font1 = new Font("MS UI Gothic", Font.BOLD, 15);
		font2 = new Font("MS UI Gothic", Font.PLAIN, 15);
		font3 = new Font("MS UI Gothic", Font.BOLD, 25);

		firstNameTextField = new JTextField(20);
		firstNameTextField.setFont(font2);
		lastNameTextField = new JTextField(20);
		lastNameTextField.setFont(font2);
		studentIDTextField = new JTextField(20);
		studentIDTextField.setFont(font2);

		enterDetails = new JLabel("Enter Student Details");
		enterDetails.setFont(font3);
		firstName = new JLabel("First Name");
		firstName.setFont(font1);
		lastName = new JLabel("Last Name");
		lastName.setFont(font1);
		studentID = new JLabel("Student ID");
		studentID.setFont(font1);
		genderLabel = new JLabel("Select Gender");
		genderLabel.setFont(font1);

		maleRB = new JRadioButton("Male");
		maleRB.setFont(font1);
		femaleRB = new JRadioButton("Female");
		femaleRB.setFont(font1);

		addStudent = new JButton("Add Student");
		addStudent.setFont(font1);
		viewStudents = new JButton("View Students List");
		viewStudents.setFont(font1);
	}

	private void setLayout() {
		GridLayout gl = new GridLayout(7, 1);
		Container c = frame.getContentPane();
		c.setLayout(gl);

	}

	private void addComponents() {

		JPanel p1 =  new JPanel();
		p1.add(enterDetails);
		c.add(p1);

		JPanel p2 = new JPanel();
		p2.add(firstName);
		p2.add(firstNameTextField);
		c.add(p2);

		JPanel p3 = new JPanel();
		p3.add(lastName);
		p3.add(lastNameTextField);
		c.add(p3);

		JPanel p4 = new JPanel();
		p4.add(studentID);
		p4.add(studentIDTextField);
		c.add(p4);

		JPanel p5 = new JPanel();
		p5.add(genderLabel);
		p5.add(maleRB);
		p5.add(femaleRB);
		c.add(p5);

		JPanel p6 = new JPanel();
		p6.add(addStudent);
		c.add(p6);

		JPanel p7 = new JPanel();
		p7.add(viewStudents);
		c.add(p7);		
	}

	public static void main(String[] args) {

		s = new Students();
		new StudentApplicationInterface();	

	}

	static class AddStudentClicked implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(frame.getComponent(0), "Student Added");

			fName = firstNameTextField.getText();
			lName = lastNameTextField.getText();
			sID = studentIDTextField.getText();

			s.addStudent(new Student(fName, lName, sID, gender));

			fName = "";
			lName = "";
			sID = "";
			gender = "";

			firstNameTextField.setText("");
			lastNameTextField.setText("");
			studentIDTextField.setText("");

			new StudentApplicationInterface();
		}		
	}

	static class ViewStudentsClicked implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			new StudentsApplication(s);

		}
	}
}

class Students {

	Collection<Student> students = new ArrayList<Student>();

	public Collection<Student> getStudents() {
		return students;

	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public int getNumberOfStudents() {
		return getStudents().size();
	}
}

class Student {
	String first;
	String last;
	String sID;
	String gender;

	public Student(String first, String last, String sID, String gender) {
		this.first = first;
		this.last = last;
		this.sID = sID;
		this.gender = gender;
	}
}


