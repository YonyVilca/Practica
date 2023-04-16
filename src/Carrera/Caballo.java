package Carrera;
import javax.swing.JProgressBar;
public class Caballo extends Thread {
	JProgressBar jpb_01;
	public Caballo(JProgressBar jpb) {
		this.jpb_01 = jpb;
		
	}
	public void run()
	{
		this.jpb_01.setValue(0);
		for(int i=1;i<=100;i++)
		{
			this.jpb_01.setValue((int)this.jpb_01.getValue()+1);
			try {
				sleep((int)(Math.random()*2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}
}