package Calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator extends JFrame {
	JLabel label;
	JButton bNum[] = new JButton[10]; 
	JButton plus, minus, multi, div, equal, clear; 
	String inputValue; 
	int result; 
	char lastOp;

	public static void main(String[] args) {
		new Calculator();
	}

	public Calculator() {
		super("계산기");
		setBounds(200, 200, 300, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("0", JLabel.RIGHT);

		add(label, BorderLayout.NORTH);

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

		p.add(bNum[7]);
		p.add(bNum[8]);
		p.add(bNum[9]);
		p.add(plus);
		p.add(bNum[4]);
		p.add(bNum[5]);
		p.add(bNum[6]);
		p.add(minus);
		p.add(bNum[1]);
		p.add(bNum[2]);
		p.add(bNum[3]);
		p.add(multi);
		p.add(bNum[0]);
		p.add(equal);
		p.add(clear);
		p.add(div);

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
			String s = e.getActionCommand(); // 클릭한 버튼의 레이블
			inputValue = new String(); // 첫 자리이면 String 객체 생성
			
			if (inputValue.length() >= 9)
				return; // 9자리 넘으면 무시
			inputValue += s; // 두번째 이후이면 누른 숫자 덧붙이기
			label.setText(inputValue); // 현재 숫자 화면에 표시
		}
	}

	class CalcHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int value;

			if (source == clear) {
				label.setText("0"); 
				inputValue = null; 
				lastOp = 0; 
				result = 0; 
				return;
			}
			// 기타 계산 +,-,*,/
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
				label.setText(Integer.toString(result));
			}
			inputValue = null;
			lastOp = source.getText().charAt(0);
		}
	}
}

