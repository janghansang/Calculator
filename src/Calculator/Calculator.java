package Calculator;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Calculator extends Frame{
    public Calculator(){
        super("계산기");
        init();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){//e 가 아니라 다른거 써도 됨
				System.exit(0);
			}
		});//아답터를 사용하면 전부다 정의 필요X
        this.setSize(300, 300);
        this.setLocation(500, 200);
        this.setVisible(true);
    }

	private void init() {
		TextField tf = new TextField("0");
		this.add("North",tf);
	}
}