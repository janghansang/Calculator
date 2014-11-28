package Calculator;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JButton;

public class Calculator extends Frame {
	
	TextField tf;
	JButton bNum[] = new JButton[10]; 
	String title[]={"+","-","*","/","C","bs","="};
	JButton bOp[]= new JButton[7];
	String inputValue; 
	int i;
	int result; 
	char lastOp;

	public Calculator() {
		super("계산기");
		setSize(300,400);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		tf = new TextField("0");
		add(tf, BorderLayout.NORTH);
		Panel p = new Panel(new GridLayout(4, 5, 2, 2));
		add(p, BorderLayout.CENTER);

		for (i = 0; i < bNum.length; i++) {
			bNum[i] = new JButton(Integer.toString(i));
			bNum[i].addActionListener(new NumberHandler());
			p.add(bNum[i]);
		}		
		
		for(i=0; i<title.length; i++){
			bOp[i]=new JButton(title[i]);
			bOp[i].addActionListener(new CalcHandler());
			p.add(bOp[i]);		
		}
		
		setVisible(true);
	}

	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand(); 
			if (inputValue == null) {
				if (s.equals("0"))
					return; 
				else
					inputValue = new String(); 
			}			
			inputValue += s; // 두번째 이후이면 누른 숫자 덧붙이기
			tf.setText(inputValue); // 현재 숫자 화면에 표시
		}
	}

	class CalcHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int value;
			if (source == bOp[4]) {
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

