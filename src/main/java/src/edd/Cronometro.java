
package src.edd;
import java.util.Observable;

/**
 * Hilo para contar tiempo
 * @author meli
 */
public class Cronometro extends Observable implements Runnable{
    static Thread hilo;//este hilo
    int tiempo;//el tiempo a contar
    
    /**
     * Constructor
     * @param n Los milisegundos a contar
     */
    public Cronometro(int n){
        hilo=new Thread(this);
        tiempo=n;
    }
    
    @Override public void run(){
        try{//dormimos el hilo por el tiempo determinado
            Thread.sleep(tiempo);
        }catch(InterruptedException e){
            System.out.println("Fallo al dormir cronometro");
        }
        //Notificamos a los observadores que ya se acabo el tiempo
        this.setChanged();
        this.notifyObservers("Ya");
    }
    
    /**
     * Metodo para comenzar a correr el hilo
     */
    public void start(){
        hilo.start();
    }
}
