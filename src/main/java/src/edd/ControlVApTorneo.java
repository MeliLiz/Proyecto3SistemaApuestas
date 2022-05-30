
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author meli
 */
public class ControlVApTorneo implements Observer{
    Jugador jugador;
    Juego juego;
    
    public ControlVApTorneo(Jugador jugador, Juego juego){
        this.jugador=jugador;
        this.juego=juego;
    }
    
    @Override public void update(Observable o, Object obj){
        if(obj!=null){
            Cola<Integer> cola=new Cola<>();
            if(obj.getClass().equals(cola.getClass())){
                Cronometro cronometro=new Cronometro(20000);
                HiloVentanaApuestaTorneo ap=new HiloVentanaApuestaTorneo(jugador, juego);
                cronometro.addObserver(ap);
                ap.start();
                cronometro.start();
            }
        }
    }
}
