package Carrera;
import javax.swing.JProgressBar;
public class Caballo extends Thread {
	JProgressBar jpb_01;
	public long recorrido;
	public long descanso;
	
	public Caballo(JProgressBar jpb) {
		this.jpb_01 = jpb;
		
	}
	public void run()
	{
		 long start = System.nanoTime(); // tiempo de inicio
		this.jpb_01.setValue(0);
		for(int i=1;i<=100;i++)
		{
			this.jpb_01.setValue((int)this.jpb_01.getValue()+1);
			try {
				
				long start1 = System.nanoTime(); // tiempo de inicio
				sleep((int)(Math.random()*2000));
				long end1 = System.nanoTime(); // tiempo de finalización
				descanso = end1-start1;
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
			 long end = System.nanoTime(); // tiempo de finalización
			 recorrido = (end-start)-descanso;
			  System.out.println("\n"+"Tiempo de ejecución: " + (end-start)+ " nanosegundos.");
			  System.out.println("tiempo de descanso:"+ descanso );
			  System.out.println(this.getName()+"tiempo de recorrido:"+ recorrido );
	}
}
}
