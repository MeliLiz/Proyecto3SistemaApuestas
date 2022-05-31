
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 * Clase para controlar el momento en que se debe abrir y cerrar la ventana para apostar en el torneo
 * @author meli
 */
public class ControlVApTorneo implements Observer{
    Jugador jugador;//El jugador con el que estamos trabajando
    Juego juego;//El juego con el que estamos trabajando
    
    /**
     * Cosntructor 
     * @param jugador
     * @param juego 
     */
    public ControlVApTorneo(Jugador jugador, Juego juego){
        this.jugador=jugador;
        this.juego=juego;
    }
    
    @Override public void update(Observable o, Object obj){
        if(obj!=null){
            Cola<Integer> cola=new Cola<>();
            if(obj.getClass().equals(cola.getClass())){
                Cronometro cronometro=new Cronometro(20000);//Hacemos un cronometro de 20 segundos
                Segundero segundero=new Segundero();
                HiloVentanaApuestaTorneo ap=new HiloVentanaApuestaTorneo(jugador, juego);//Hacemos el hilo de la ventana para apostar en el torneo
                cronometro.addObserver(ap);//ponemos un observador del cronometro
                segundero.addObserver(ap);
                //Empezamos los hilos
                ap.start();
                segundero.start();
                cronometro.start();
            }
        }
    }
}
