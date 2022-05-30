
package src.edd;
import java.util.Observable;

/**
 *
 * @author meli
 */
public class Cronometro extends Observable implements Runnable{
    static Thread hilo;
    int tiempo;
    
    public Cronometro(int n){
        hilo=new Thread(this);
        tiempo=n;
    }
    
    @Override public void run(){
        try{
            Thread.sleep(tiempo);
        }catch(InterruptedException e){
            System.out.println("Fallo al dormir cronometro");
        }
        this.setChanged();
        this.notifyObservers("Ya");
    }
    
    public void start(){
        hilo.start();
    }
}
