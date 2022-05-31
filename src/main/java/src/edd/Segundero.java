
package src.edd;
import java.util.Observable;

/**
 * Clase para contar 20 segundos
 * @author meli
 */
public class Segundero extends Observable implements Runnable{
    Thread hilo;//este hilo
    
    /**
     * Constructor
     */
    public Segundero(){
        hilo=new Thread(this);
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        for(int i=19;i>0;i--){
            try{
                Thread.sleep(1000);
                this.setChanged();
                this.notifyObservers(i);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo segundero");
            }
            
        }
    }//FIN DE RUN
    
    /**
     * Metodo para comenzar este hilo
     */
    public void start(){
        hilo.start();
    }//FIN DE START
}
