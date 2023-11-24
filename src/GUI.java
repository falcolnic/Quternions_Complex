import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GUI {
	private JFrame frame;
	private JLabel Quaternion_1, ComplexLabel;
	private JLabel Symbol_1, Quaternion_i, Complex_i, Label_j, Label_k;
	private JTextField RealNumber, Input_i, Input_j, Input_k;
	private JLabel QuaternionLabel2, ComplexLabel2;
	private JLabel Symbol_2, Quaternion_i2, Complex_i2, Label_j2, Label_k2;
	private JTextField RealNumber_2, Input_i2, Input_j2, Input_k2;
	private JRadioButton add, subtract, multiply, divide;
	private ComplexNumber complexNumber;
	private ButtonGroup group;
	private JButton calc;
	private JButton complexButton;
	private boolean complexMode = false;
	private Quaternion z1, z2;
	private ComplexNumber ComplexResult1, ComplexResult2;
	private boolean twoInputs;
	private boolean oneInput;
	private String output;
	public GUI() {
		initialize();
		complexNumber = new ComplexNumber(0, 0);
	}

	private void initialize() {
		// Рамка
		frame = new JFrame("Калькулятор :)");
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Встановити тему системи
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Перше поле (надпис z1)
		Quaternion_1 = new JLabel("Кватерніон z1:");
		Quaternion_1.setBounds(10, 11, 86, 14);
		frame.getContentPane().add(Quaternion_1);

		ComplexLabel = new JLabel("Комплексне число z1:");
		ComplexLabel.setBounds(10, 11, 115, 14);
		frame.getContentPane().add(ComplexLabel);



		// Справжнє Число z1
		RealNumber = new JTextField();
		RealNumber.setBounds(10, 33, 86, 20);
		frame.getContentPane().add(RealNumber);
		RealNumber.setColumns(10);

		// Надпис для z1
		Symbol_1 = new JLabel("    +");
		Symbol_1.setBounds(100, 36, 27, 14);
		frame.getContentPane().add(Symbol_1);

		// Ввід данних для i
		Input_i = new JTextField();
		Input_i.setColumns(10);
		Input_i.setBounds(137, 33, 86, 20);
		frame.getContentPane().add(Input_i);

		
		// Надпис для z1
		Quaternion_i = new JLabel("i     +");
		Quaternion_i.setBounds(227, 36, 35, 14);
		frame.getContentPane().add(Quaternion_i);
		
		Complex_i = new JLabel("i");
		Complex_i.setBounds(227, 36, 35, 14);
		frame.getContentPane().add(Complex_i);
		
		
		// Ввід даних для j
		Input_j = new JTextField();
		Input_j.setColumns(10);
		Input_j.setBounds(272, 33, 86, 20);
		frame.getContentPane().add(Input_j);

		// Надпис для z1
		Label_j = new JLabel("j     +");
		Label_j.setBounds(362, 36, 35, 14);
		frame.getContentPane().add(Label_j);

		// Ввід даних для k
		Input_k = new JTextField();
		Input_k.setColumns(10);
		Input_k.setBounds(407, 33, 86, 20);
		frame.getContentPane().add(Input_k);

		// Надпис для z1
		Label_k = new JLabel("k");
		Label_k.setBounds(497, 36, 35, 14);
		frame.getContentPane().add(Label_k);

		// Друге поле (надпис z2)
		QuaternionLabel2 = new JLabel("Кватерніон z2:");
		QuaternionLabel2.setBounds(10, 64, 86, 14);
		frame.getContentPane().add(QuaternionLabel2);

		ComplexLabel2 = new JLabel("Комплексне число z2:");
		ComplexLabel2.setBounds(10, 64, 115, 14);
		frame.getContentPane().add(ComplexLabel2);

		// Справжнє Число z2
		RealNumber_2 = new JTextField();
		RealNumber_2.setColumns(10);
		RealNumber_2.setBounds(10, 86, 86, 20);
		frame.getContentPane().add(RealNumber_2);

		// Надпис для z2
		Symbol_2 = new JLabel("    +");
		Symbol_2.setBounds(100, 89, 27, 14);
		frame.getContentPane().add(Symbol_2);

		// Ввід даних для i
		Input_i2 = new JTextField();
		Input_i2.setColumns(10);
		Input_i2.setBounds(137, 86, 86, 20);
		frame.getContentPane().add(Input_i2);

		// Надпис для z2
		Quaternion_i2 = new JLabel("i     +");
		Quaternion_i2.setBounds(227, 89, 35, 14);
		frame.getContentPane().add(Quaternion_i2);

		Complex_i2 = new JLabel("i");
		Complex_i2.setBounds(227, 89, 35, 14);
		frame.getContentPane().add(Complex_i2);

		// Ввід даних для j
		Input_j2 = new JTextField();
		Input_j2.setColumns(10);
		Input_j2.setBounds(272, 86, 86, 20);
		frame.getContentPane().add(Input_j2);

		// Надпис для z2
		Label_j2 = new JLabel("j     +");
		Label_j2.setBounds(362, 89, 35, 14);
		frame.getContentPane().add(Label_j2);

		// Ввід даних для k
		Input_k2 = new JTextField();
		Input_k2.setColumns(10);
		Input_k2.setBounds(407, 86, 86, 20);
		frame.getContentPane().add(Input_k2);

		// Надпис для z2
		Label_k2 = new JLabel("k");
		Label_k2.setBounds(497, 89, 35, 14);
		frame.getContentPane().add(Label_k2);

		// Вибір операції
		
		add = new JRadioButton("Додавання");
		add.setBounds(10, 124, 85, 23);
		frame.getContentPane().add(add);

		subtract = new JRadioButton("Віднімання");
		subtract.setBounds(10, 150, 85, 23);
		frame.getContentPane().add(subtract);

		multiply = new JRadioButton("Множення");
		multiply.setBounds(10, 176, 77, 23);
		frame.getContentPane().add(multiply);

		divide = new JRadioButton("Ділення");
		divide.setBounds(10, 202, 77, 23);
		frame.getContentPane().add(divide);

		group = new ButtonGroup();
		group.add(add);
		group.add(subtract);
		group.add(multiply);
		group.add(divide);

		// Кнопка Результат
		calc = new JButton("Порахувати");
		calc.addActionListener(new ButtonHandler());
		calc.setBounds(10, 232, 99, 23);
		frame.getContentPane().add(calc);

		// Кнопка Комплексне
		complexButton = new JButton("Комплексне");
		complexButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				complexMode = !complexMode;
				updateInputFields();
			}
		});
		complexButton.setBounds(407, 202, 99, 23);
		frame.getContentPane().add(complexButton);

		ComplexLabel.setVisible(false);
		ComplexLabel2.setVisible(false);
		frame.setVisible(true);

	}
	// Метод для оновлення відображення введення даних
	private void updateInputFields() {
		if (complexMode) {
			// Якщо включений режим комплексного вводу, приховати поля для j та k
			ComplexLabel.setVisible(true);
			ComplexLabel2.setVisible(true);
			Quaternion_1.setVisible(false);
			QuaternionLabel2.setVisible(false);
			Complex_i.setVisible(true);
			Complex_i2.setVisible(true);
			Label_j.setVisible(false);
			Quaternion_i.setVisible(false);
			Input_j.setVisible(false);
			Label_j2.setVisible(false);
			Quaternion_i2.setVisible(false);
			Input_j2.setVisible(false);
			Label_k.setVisible(false);
			Label_k2.setVisible(false);
			Input_k.setVisible(false);
			Input_k2.setVisible(false);
		} else {
			// Якщо вимкнений режим комплексного вводу, показати поля для j та k
			ComplexLabel.setVisible(false);
			ComplexLabel2.setVisible(false);
			Quaternion_1.setVisible(true);
			QuaternionLabel2.setVisible(true);
			Label_j.setVisible(true);
			Quaternion_i.setVisible(true);
			Input_j.setVisible(true);
			Label_j2.setVisible(true);
			Quaternion_i2.setVisible(true);
			Input_j2.setVisible(true);
			Label_k.setVisible(true);
			Label_k2.setVisible(true);
			Input_k.setVisible(true);
			Input_k2.setVisible(true);
			Complex_i.setVisible(false);
			Complex_i2.setVisible(false);
		}
	}


	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(!complexMode){
				// Провірити чи ввів користувач два кватерніони
				try {
					double z = Double.parseDouble(RealNumber_2.getText()) + Double.parseDouble(Input_i2.getText())
							+ Double.parseDouble(Input_j2.getText()) + Double.parseDouble(Input_k2.getText());
					twoInputs = true;
				} catch (Exception e) {
					twoInputs = false;
				}

				if (twoInputs) {
					if (add.isSelected()) {
						try {
							double Value1_Quat1 = Double.parseDouble(RealNumber.getText());
							double Value2_Quat1 = Double.parseDouble(Input_i.getText());
							double Value3_Quat1 = Double.parseDouble(Input_j.getText());
							double Value4_Quat1 = Double.parseDouble(Input_k.getText());
							z1 = new Quaternion(Value1_Quat1, Value2_Quat1, Value3_Quat1, Value4_Quat1);

							double Value1_Quat2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Quat2 = Double.parseDouble(Input_i2.getText());
							double Value3_Quat2 = Double.parseDouble(Input_j2.getText());
							double Value4_Quat2 = Double.parseDouble(Input_k2.getText());
							z2 = new Quaternion(Value1_Quat2, Value2_Quat2, Value3_Quat2, Value4_Quat2);

							output = "z1 + z2 = \r\n\r\n" + z1.add(z2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть два дійсні кватерніони.");
						}
					} else if (subtract.isSelected()) {
						try {
							double Value1_Quat1 = Double.parseDouble(RealNumber.getText());
							double Value2_Quat1 = Double.parseDouble(Input_i.getText());
							double Value3_Quat1 = Double.parseDouble(Input_j.getText());
							double Value4_Quat1 = Double.parseDouble(Input_k.getText());
							z1 = new Quaternion(Value1_Quat1, Value2_Quat1, Value3_Quat1, Value4_Quat1);

							double Value1_Quat2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Quat2 = Double.parseDouble(Input_i2.getText());
							double Value3_Quat2 = Double.parseDouble(Input_j2.getText());
							double Value4_Quat2 = Double.parseDouble(Input_k2.getText());
							z2 = new Quaternion(Value1_Quat2, Value2_Quat2, Value3_Quat2, Value4_Quat2);

							output = "z1 - z2 = \r\n\r\n" + z1.subtract(z2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть два дійсні кватерніони.");
						}
					} else if (multiply.isSelected()) {
						try {
							double Value1_Quat1 = Double.parseDouble(RealNumber.getText());
							double Value2_Quat1 = Double.parseDouble(Input_i.getText());
							double Value3_Quat1 = Double.parseDouble(Input_j.getText());
							double Value4_Quat1 = Double.parseDouble(Input_k.getText());
							z1 = new Quaternion(Value1_Quat1, Value2_Quat1, Value3_Quat1, Value4_Quat1);

							double Value1_Quat2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Quat2 = Double.parseDouble(Input_i2.getText());
							double Value3_Quat2 = Double.parseDouble(Input_j2.getText());
							double Value4_Quat2 = Double.parseDouble(Input_k2.getText());
							z2 = new Quaternion(Value1_Quat2, Value2_Quat2, Value3_Quat2, Value4_Quat2);

							output = "z1 * z2 = \r\n\r\n" + z1.multiply(z2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть два дійсні кватерніони.");
						}
					} else if (divide.isSelected()) {
						try {
							double Value1_Quat1 = Double.parseDouble(RealNumber.getText());
							double Value2_Quat1 = Double.parseDouble(Input_i.getText());
							double Value3_Quat1 = Double.parseDouble(Input_j.getText());
							double Value4_Quat1 = Double.parseDouble(Input_k.getText());
							z1 = new Quaternion(Value1_Quat1, Value2_Quat1, Value3_Quat1, Value4_Quat1);

							double Value1_Quat2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Quat2 = Double.parseDouble(Input_i2.getText());
							double Value3_Quat2 = Double.parseDouble(Input_j2.getText());
							double Value4_Quat2 = Double.parseDouble(Input_k2.getText());
							z2 = new Quaternion(Value1_Quat2, Value2_Quat2, Value3_Quat2, Value4_Quat2);

							output = "z1 / z2 = \r\n\r\n" + z1.divide(z2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть два дійсні кватерніони.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Введіть два дійсні кватерніони.");
					}
				} else {
					try {
						double aVal = Double.parseDouble(RealNumber.getText());
						double bVal = Double.parseDouble(Input_i.getText());
						double cVal = Double.parseDouble(Input_j.getText());
						double dVal = Double.parseDouble(Input_k.getText());
						z1 = new Quaternion(aVal, bVal, cVal, dVal);

						output = "Сполучення: \r\n" + z1.getConjugate() + "\r\n\r\nОбернення: \r\n" + z1.getInverseFraction()
								+ "\r\n" + z1.getInverse() + "\r\n\r\nНормальне: \r\n" + z1.getNormRadical() + "\r\n"
								+ z1.getNorm();
						JOptionPane.showMessageDialog(null, output);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Введіть два дійсні кватерніони.");
					}
				}
			}
			else if (complexMode){
				try {
					double z = Double.parseDouble(RealNumber_2.getText()) + Double.parseDouble(Input_i2.getText());
					oneInput = true;
				} catch (Exception e) {
					oneInput = false;
				}

				if (oneInput) {
					if (add.isSelected()) {
						try {
							double Value1_Comp1 = Double.parseDouble(RealNumber.getText());
							double Value2_Comp1 = Double.parseDouble(Input_i.getText());

							ComplexResult1 = new ComplexNumber(Value1_Comp1, Value2_Comp1);

							double Value1_Comp2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Comp2 = Double.parseDouble(Input_i2.getText());

							ComplexResult2 = new ComplexNumber(Value1_Comp2, Value2_Comp2);

							output = "z1 + z2 = \r\n\r\n" + ComplexResult1.add(ComplexResult2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть дійсне Комплексне число.");
						}
					} else if (subtract.isSelected()) {
						try {
							double Value1_Comp1 = Double.parseDouble(RealNumber.getText());
							double Value2_Comp1 = Double.parseDouble(Input_i.getText());

							ComplexResult1 = new ComplexNumber(Value1_Comp1, Value2_Comp1);

							double Value1_Comp2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Comp2 = Double.parseDouble(Input_i2.getText());
							
							ComplexResult2 = new ComplexNumber(Value1_Comp2, Value2_Comp2);

							output = "z1 - z2 = \r\n\r\n" + ComplexResult1.subtract(ComplexResult2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть дійсне Комплексне число.");
						}
					} else if (multiply.isSelected()) {
						try {
							double Value1_Comp1 = Double.parseDouble(RealNumber.getText());
							double Value2_Comp1 = Double.parseDouble(Input_i.getText());
							
							ComplexResult1 = new ComplexNumber(Value1_Comp1, Value2_Comp1);

							double Value1_Comp2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Comp2 = Double.parseDouble(Input_i2.getText());
							ComplexResult2 = new ComplexNumber(Value1_Comp2, Value2_Comp2);

							output = "z1 * z2 = \r\n\r\n" + ComplexResult1.multiply(ComplexResult2);
							
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть дійсне Комплексне число.");
						}
					} else if (divide.isSelected()) {
						try {
							double Value1_Comp1 = Double.parseDouble(RealNumber.getText());
							double Value2_Comp1 = Double.parseDouble(Input_i.getText());
							
							ComplexResult1 = new ComplexNumber(Value1_Comp1, Value2_Comp1);

							double Value1_Comp2 = Double.parseDouble(RealNumber_2.getText());
							double Value2_Comp2 = Double.parseDouble(Input_i2.getText());
							ComplexResult2 = new ComplexNumber(Value1_Comp2, Value2_Comp2);

							output = "z1 / z2 = \r\n\r\n" + ComplexResult1.divide(ComplexResult2);
							JOptionPane.showMessageDialog(null, output);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Введіть дійсне Комплексне число.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Введіть дійсне Комплексне число.");
					}
				}

			}
		}
	}

}
