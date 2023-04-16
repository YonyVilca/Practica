package Test;
import javax.swing.JTextArea; 
public class Demonio4 extends Thread{
	public JTextArea textA;
	public Demonio4 (JTextArea jt) {
		this.textA = jt;
	}
	public Demonio4(String algo) {
		super(algo);
	}
	public void run() {
		for(;;) {
			System.out.println(this.getName() + ":Hola mundo");
			this.textA.setText( this.getName() + ":Hola mundo");
			try {
				sleep( (int) (Math.random()*2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

