package Calculator;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class Calculator extends Frame{
    public Calculator(){
        super("계산기");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){//e 가 아니라 다른거 써도 됨
				System.exit(0);
			}
		});
        this.setSize(300, 300);
        this.setLocation(500, 200);
        this.setVisible(true);
        
        
		TextField tf = new TextField("0");
		this.add("North",tf);
		
		Panel numPanel=new Panel();
        GridLayout gl = new GridLayout(4, 5, 5, 5);
    	numPanel.setLayout(gl);
        String btTitle[] = { "1","2","3","4","5",
        		             "6","7","8","9","0",
        		             "+","-","*","/","<",
        		              "c", "=", "=", "=", "="};
        Button num[][] = new Button[4][5];
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<5 ; j++){
                num[i][j] = new Button(String.valueOf(btTitle[j+i*5]));
            }
        }
       for(int i=0 ; i<4 ; i++)
            for(int j=0 ; j<5 ; j++)
                numPanel.add(num[i][j]);
		this.add("Center",numPanel);
        
    }

}
