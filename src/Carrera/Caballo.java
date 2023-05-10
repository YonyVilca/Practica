package Carrera;
import javax.swing.JProgressBar;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Caballo extends Thread {
    JProgressBar jpb_01;
    public long carrera;
    public long descanso;
    public String nombre;
    private FileWriter fw;
    private BufferedWriter bw;

    public Caballo(JProgressBar jpb, String nombre) {
        this.jpb_01 = jpb;
        this.nombre = nombre;

        // Crear el archivo y el escritor de archivo
        try {
            fw = new FileWriter("datos_carrera.txt", true);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long start = System.nanoTime(); // tiempo de inicio de la carrera
        this.jpb_01.setValue(0);
        for(int i = 1; i <= 100; i++) {
            this.jpb_01.setValue((int)this.jpb_01.getValue() + 1);
            try {
                long start1 = System.nanoTime(); // tiempo de inicio del descanso
                sleep((int)(Math.random() * 2000));
                long end1 = System.nanoTime(); // tiempo de finalización del descanso
                descanso += end1 - start1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.nanoTime(); // tiempo de finalización del recorrido
            carrera += end - start - descanso;
            System.out.println("\n"+this.nombre + " tiempo de carrera individual: " + carrera + " nanosegundos.");
            System.out.println("\n"+this.nombre + " tiempo de descanso individual: " + descanso + " nanosegundos.");

            // Escribir los datos de carrera y descanso en el archivo
            try {
                bw.write(this.nombre + " tiempo de carrera individual: " + carrera + " nanosegundos.");
                bw.newLine();
                bw.write(this.nombre + " tiempo de descanso individual: " + descanso + " nanosegundos.");
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Cerrar el escritor de archivo
        try {
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
