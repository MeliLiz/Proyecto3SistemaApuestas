
package src.edd;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 * Hilo observador del resultado del torneo
 * @author meli
 */
public class ObservadorResultadoTorneo implements Runnable,Observer{
    Jugador jugador;//El jugador con el que estamos trabajando
    Thread hilo;//Este hilo
    Integer n;//numero del competidor ganador
    
    /**
     * Constructor
     * @param jugador 
     */
    public ObservadorResultadoTorneo(Jugador jugador){
        this.jugador=jugador;
        hilo=new Thread(this);
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        if(jugador.numJugadorApostado==0){//si el usuario no aposto
                JOptionPane.showMessageDialog(null,"Torneo ganado por el competidor "+n);
        }else if(jugador.numJugadorApostado==n){//si el jugador apostado gana
            DecimalFormat df =  new DecimalFormat("#.##");
            double ganado=jugador.cantidadApostada*jugador.cuotaAp;//calculamos lo ganado
            jugador.cuenta.agregarGanada(ganado, jugador.cantidadApostada);//agregamos la ganada al registro(incluye el deposito)
            JOptionPane.showMessageDialog(null,"Felicidades! ganó el competidor "+n+" en este torneo. Ganaste $"+df.format(ganado));//Avisamos
        }else{//di el jugador apostado pierde
            jugador.cuenta.agregarPerdida(jugador.cantidadApostada);//agregamos la perdida al registro
            DecimalFormat df =  new DecimalFormat("#.##");
            JOptionPane.showMessageDialog(null,"Ganó el competidor "+n+" en este torneo. Perdiste $"+df.format(jugador.cantidadApostada));//Avisamos
        }
    }//FIN DE RUN
    
    @Override public void update(Observable o, Object ganador){
        if(ganador!=null){
            Candidato a=new Candidato(0,0);
            if(ganador.getClass().equals(a.getClass())){//si el objeto recibido es un candidato
                //lo tomamos e iniciamos ente hilo
                Candidato g=(Candidato)ganador;
                n=g.num;
                hilo=new Thread(this);
                hilo.start();   
            }
        }  
    }//FIN DE UPDATE
}
