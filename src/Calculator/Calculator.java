package Calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator extends JFrame {
//	JLabel label;
	TextField tf;
	JButton bNum[] = new JButton[10]; 
	JButton plus, minus, multi, div, equal, clear; 
	String inputValue; 
	int result; 
	char lastOp;

	public Calculator() {
		super("����");
		setSize(300,400);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		tf = new TextField("0");
		add(tf, BorderLayout.NORTH);

		JPanel p = new JPanel(new GridLayout(4, 4, 2, 2));
		add(p, BorderLayout.CENTER);

		plus = new JButton("+");
		minus = new JButton("-");
		multi = new JButton("*");
		div = new JButton("/");
		equal = new JButton("=");
		clear = new JButton("C");

		int i;
		for (i = 0; i < bNum.length; i++) {
			bNum[i] = new JButton(Integer.toString(i));
		}
		p.add(bNum[7]);p.add(bNum[8]);p.add(bNum[9]);p.add(plus);
		p.add(bNum[4]);p.add(bNum[5]);p.add(bNum[6]);p.add(minus);
		p.add(bNum[1]);p.add(bNum[2]);p.add(bNum[3]);p.add(multi);
		p.add(bNum[0]);p.add(equal);  p.add(clear);  p.add(div);

		NumberHandler nh = new NumberHandler();
		for (i = 0; i < bNum.length; i++) {
			bNum[i].addActionListener(nh);
		}

		CalcHandler ch = new CalcHandler();
		plus.addActionListener(ch);
		minus.addActionListener(ch);
		multi.addActionListener(ch);
		div.addActionListener(ch);
		equal.addActionListener(ch);
		clear.addActionListener(ch);
		setVisible(true);
	}

	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand(); // Ŭ���� ��ư�� ���̺�
			if (inputValue == null) {
				if (s.equals("0"))
					return; 
				else
					inputValue = new String(); // ù �ڸ��̸� String ��ü ����
			}
			if (inputValue.length() >= 9)
				return; // 9�ڸ� ������ ����
			inputValue += s; // �ι�° �����̸� ���� ���� �����̱�
			tf.setText(inputValue); // ���� ���� ȭ�鿡 ǥ��
		}
	}

	class CalcHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int value;
			if (source == clear) {
				tf.setText("0"); 
				inputValue = null; 
				lastOp = 0; 
				result = 0; 
				return;
			}
			if (inputValue != null) {
				value = Integer.parseInt(inputValue);
				switch (lastOp) {
				case '+':
					result += value;
					break;
				case '-':
					result -= value;
					break;
				case '*':
					result *= value;
					break;
				case '/':
					result /= value;
					break;
				default:
					result = value;
					break;
				}
				tf.setText(Integer.toString(result));
			}
			inputValue = null;
			lastOp = source.getText().charAt(0);
		}
	}
}

