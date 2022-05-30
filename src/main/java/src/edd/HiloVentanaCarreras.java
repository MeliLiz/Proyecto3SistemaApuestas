
package src.edd;
import java.util.Observable;
import java.util.Observer;

/**
 * Hilo para mostrar la ventana de apuesta de carreras
 * @author meli
 */
public class HiloVentanaCarreras extends Thread implements Observer{
    static Jugador jugador;
    static Lista<Candidato> competidores;
    static ApostarCarrera ventana;
    
    public HiloVentanaCarreras(Jugador jugador, Lista<Candidato> competidores){
        this.jugador=jugador;
        this.competidores=competidores;
    }
    
    @Override public void run(){
        ApostarCarrera a=new ApostarCarrera(jugador, competidores);
        ventana=a;
        a.setVisible(true);
        
    }
    
    @Override public void update(Observable o, Object arg){
        String s=(String)arg;
        System.out.println(s);
        ventana.dispose();
        this.interrupt();
    }
}
