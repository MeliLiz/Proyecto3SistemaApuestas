
package src.edd;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 *
 * @author meli
 */
public class ObservadorResultadoTorneo implements Runnable,Observer{
    Jugador jugador;
    Thread hilo;
    Integer n;//numero del competidor ganador
    
    public ObservadorResultadoTorneo(Jugador jugador){
        this.jugador=jugador;
        hilo=new Thread(this);
    }
    
    @Override public void run(){
        if(jugador.numJugadorApostado==0){
                JOptionPane.showMessageDialog(null,"Torneo ganado por el competidor "+n);
            }else if(jugador.numJugadorApostado==n){
                DecimalFormat df =  new DecimalFormat("#.##");
                double ganado=jugador.cantidadApostada*jugador.cuotaAp;
                jugador.cuenta.agregarGanada(ganado, jugador.cantidadApostada);
                JOptionPane.showMessageDialog(null,"Felicidades! ganó el competidor "+n+" en este torneo. Ganaste $"+df.format(ganado));
            }else{
                jugador.cuenta.agregarPerdida(jugador.cantidadApostada);
                DecimalFormat df =  new DecimalFormat("#.##");
                JOptionPane.showMessageDialog(null,"Ganó el competidor "+n+" en este torneo. Perdiste $"+df.format(jugador.cantidadApostada));
            }
    }
    
    @Override public void update(Observable o, Object ganador){
        if(ganador!=null){
            Candidato a=new Candidato(0,0);
            if(ganador.getClass().equals(a.getClass())){
                Candidato g=(Candidato)ganador;
                n=g.num;
                hilo=new Thread(this);
                hilo.start();   
            }
        }
        
    }
}
