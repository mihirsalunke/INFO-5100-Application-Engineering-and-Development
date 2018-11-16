package calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULUS
}

public class Calculator extends JFrame{

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
	}

	private JTextField resultTextField;
	private JButton add, subtract, multiply, divide, compute, modulus, clear, decimal;
	private JButton[] numbers;
	static JFrame frame;
	Container c;

	private static final String ZERO = "0", ONE = "1", TWO = "2", THREE = "3", FOUR = "4", FIVE = "5", SIX = "6", SEVEN = "7", EIGHT = "8", NINE = "9";
	private String num;
	private String temp;
	private String sign;
	private float first, second;

	private boolean firstNumber = true;
	private boolean setFirst = true;
	private boolean setSecond = false;

	Operation o;

	Font f = new Font("MS UI Gothic", Font.BOLD, 40);


	public Calculator() {
		createContainer();
		createComponents();
		setLayout();
		addComponents();
		addNumberBehaviors();
		addOperationBehavior();
		addComputeBehavior();
		addClearBehavior();
		display();
	}


	private void createContainer() {
		frame = new JFrame("My Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void createComponents() {

		resultTextField = new JTextField(10);
		resultTextField.setFont(f);
		resultTextField.setHorizontalAlignment(JTextField.RIGHT);

		add = new JButton("+");
		add.setBackground(Color.DARK_GRAY);
		add.setOpaque(true);

		subtract = new JButton("-");
		subtract.setBackground(Color.DARK_GRAY);
		subtract.setOpaque(true);

		multiply = new JButton("x");
		multiply.setBackground(Color.DARK_GRAY);
		multiply.setOpaque(true);

		divide = new JButton("/");
		divide.setBackground(Color.DARK_GRAY);
		divide.setOpaque(true);

		compute = new JButton("=");
		compute.setBackground(Color.DARK_GRAY);
		compute.setOpaque(true);
		compute.setForeground(Color.GREEN);

		modulus = new JButton("%");
		modulus.setBackground(Color.DARK_GRAY);
		modulus.setOpaque(true);

		clear = new JButton("Clear");
		clear.setBackground(Color.DARK_GRAY);
		clear.setOpaque(true);

		decimal = new JButton(".");
		decimal.setBackground(Color.DARK_GRAY);
		decimal.setOpaque(true);

		numbers = new JButton[10];

		for (int i = 0; i < 10; i++) {
			numbers[i] = new JButton(i + "");
			numbers[i].setBackground(Color.DARK_GRAY);
			numbers[i].setOpaque(true);
		}
	}

	private void setLayout() {
		frame.setSize(400, 300);
		frame.setBackground(Color.DARK_GRAY);
		GridBagLayout gbl = new GridBagLayout();
		c = this.getContentPane();
		c.setBackground(Color.DARK_GRAY);
		c.setLayout(gbl);	
	}

	private void addComponents() {
		c = getContentPane();
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 70;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = 4;
		c.add(resultTextField,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipady = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 2;
		c.add(clear,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		c.add(modulus,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 1;
		c.add(divide,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		c.add(numbers[7],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 2;
		c.add(numbers[8],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 2;
		c.add(numbers[9],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 2;
		c.add(multiply,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 3;
		c.add(numbers[4],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 3;
		c.add(numbers[5],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 3;
		c.add(numbers[6],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 3;
		c.add(subtract,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 4;
		c.add(numbers[1],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 4;
		c.add(numbers[2],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 4;
		c.add(numbers[3],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 4;
		c.add(add,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.gridwidth = 2;
		c.add(numbers[0],gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		c.add(decimal,gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 5;
		c.add(compute,gbc);

		frame.add(c);
	}

	private void addNumberBehaviors() {
		NumberListener nl = new NumberListener();
		numbers[0].addActionListener(nl);
		numbers[1].addActionListener(nl);
		numbers[2].addActionListener(nl);
		numbers[3].addActionListener(nl);
		numbers[4].addActionListener(nl);
		numbers[5].addActionListener(nl);
		numbers[6].addActionListener(nl);
		numbers[7].addActionListener(nl);
		numbers[8].addActionListener(nl);
		numbers[9].addActionListener(nl);
	}

	private void addOperationBehavior() {
		OperationListener ol = new OperationListener();
		add.addActionListener(ol);
		subtract.addActionListener(ol);
		multiply.addActionListener(ol);
		divide.addActionListener(ol);
		modulus.addActionListener(ol);
	}

	private void addComputeBehavior() {
		ComputeListener cl = new ComputeListener();
		compute.addActionListener(cl);
	}

	private void addClearBehavior() {
		ClearListener clr = new ClearListener();
		clear.addActionListener(clr);
		display();
	}

	private void display() {
		frame.setVisible(true);
	}

	public class NumberListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == numbers[0]) {
				num = ZERO;
			} else if(e.getSource() == numbers[1]) {
				num = ONE;
			} else if(e.getSource() == numbers[2]) {
				num = TWO;
			} else if(e.getSource() == numbers[3]) {
				num = THREE;
			} else if(e.getSource() == numbers[4]) {
				num = FOUR;
			}else if(e.getSource() == numbers[5]) {
				num = FIVE;
			} else if(e.getSource() == numbers[6]) {
				num = SIX;
			} else if(e.getSource() == numbers[7]) {
				num = SEVEN;
			} else if(e.getSource() == numbers[8]) {
				num = EIGHT;
			} else if(e.getSource() == numbers[9]) {
				num = NINE;
			}
			if(setFirst)
			{
				setFirstNum();
			}
			if(setSecond)
			{
				setSecondNum();
			}

		}
	}	

	private void setFirstNum() {
		if(firstNumber == true) {
			resultTextField.setText(num);
			temp = num;
			firstNumber = false;
			first = Integer.parseInt(temp);
		} else {
			resultTextField.setText(temp + num);
			temp = temp+num;
			first = Integer.parseInt(temp);
		}
	}

	private void setSecondNum() {
		if(firstNumber == true) {
			resultTextField.setText(num);
			temp = num;
			firstNumber = false;
			second = Integer.parseInt(temp);
		} else {
			resultTextField.setText(temp + num);
			temp = temp+num;
			second = Integer.parseInt(temp);
		}
	}

	public class OperationListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == add) {
				o = Operation.ADD;
				sign = "+";
			}
			if (e.getSource() == subtract) {
				o = Operation.SUBTRACT;
				sign = "-";
			}
			if (e.getSource() == multiply) {
				o = Operation.MULTIPLY;
				sign = "x";
			}
			if (e.getSource() == divide) {
				o = Operation.DIVIDE;
				sign = "/";
			}
			if (e.getSource() == modulus) {
				o = Operation.MODULUS;
				sign = "%";
			}
			resultTextField.setText(sign);
			firstNumber = true;
			temp ="";
			num = "";
			setFirst = false;
			setSecond = true;
		}
	}
	public class ComputeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			float result = 0;
			if(e.getSource() == compute) {
				if (o == Operation.ADD) {
					result = first + second;
				}
				if (o == Operation.SUBTRACT) {
					result = first - second;
				}
				if (o == Operation.DIVIDE) {
					result = first / second;
				}
				if (o == Operation.MULTIPLY) {
					result = first * second;
				}
				if (o == Operation.MODULUS) {
					result = first % second;
				}
			}
			resultTextField.setText(result + "");

		}

	}

	public class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			resultTextField.setText("  ");
			first = 0;
			second = 0;
			firstNumber = true;
			setFirst = true;
			setSecond = false;
			temp ="";
			num = "";
		}
	}
}

