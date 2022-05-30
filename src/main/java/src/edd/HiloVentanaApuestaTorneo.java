
package src.edd;
import java.util.Observer;
import java.util.Observable;


/**
 *
 * @author meli
 */
public class HiloVentanaApuestaTorneo extends Thread implements Observer{
    static Jugador jugador;
    static Juego juego;
    static ApostarTorneo ventana;
    
    public HiloVentanaApuestaTorneo(Jugador jugador, Juego juego){
        this.jugador=jugador;
        this.juego=juego;
    }
    
    @Override public void run(){
        ApostarTorneo apTorneo=new ApostarTorneo(jugador,juego);
        ventana=apTorneo;
        apTorneo.setVisible(true);
    }
    
    @Override public void update(Observable o, Object arg){
        String s=(String)arg;
        System.out.println(s);
        ventana.dispose();
        this.interrupt();
    }
    
    
}
