package Calculator;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Calculator extends Frame{
    public Calculator(){
        super("����");
        init();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){//e �� �ƴ϶� �ٸ��� �ᵵ ��
				System.exit(0);
			}
		});//�ƴ��͸� ����ϸ� ���δ� ���� �ʿ�X
        this.setSize(300, 300);
        this.setLocation(500, 200);
        this.setVisible(true);
    }

	private void init() {
		TextField tf = new TextField("0");
		this.add("North",tf);
	}
}