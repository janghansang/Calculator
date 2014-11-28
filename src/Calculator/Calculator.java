package Calculator;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JButton;

public class Calculator extends Frame {
	
	TextField tf;
	JButton bNum[] = new JButton[10]; // getText() 쓰기위해서 JButton 썼어요
	JButton bOp[]= new JButton[7];    
	String title[]={"+","-","*","/","C","bs","="};
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
		add(tf= new TextField("0"), BorderLayout.NORTH);
		Panel p = new Panel(new GridLayout(4, 5, 2, 2));
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
		add(p, BorderLayout.CENTER);
		setVisible(true);
	}

	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand(); 
			if (inputValue == null) inputValue = new String(); 		
			inputValue += s;
			tf.setText(inputValue); 
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
				case '+':  result += value;  break;
				case '-':  result -= value;  break;
				case '*':  result *= value;  break;
				case '/':  result /= value;  break;
				default:   result = value;   break;
				}
				tf.setText(Integer.toString(result));
			}
			inputValue = null;
			lastOp = source.getText().charAt(0);
		}
	}
}

