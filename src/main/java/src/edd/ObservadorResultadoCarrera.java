
package src.edd;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 * Hilo observador del resultado de cada carrera
 * @author meli
 */
public class ObservadorResultadoCarrera implements Runnable,Observer{
    Jugador jugador;//El jugador con el que estamos trabajando
    Integer result;//El numero de jugador que gana la carrera
    Thread hilo;//este hilo
    
    /**
     * Constructor
     * @param jugador 
     */
    public ObservadorResultadoCarrera(Jugador jugador){
        this.jugador=jugador;
        hilo=new Thread(this);
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        if(jugador.numJugadorApostadoCarrera==0){//si no se aposto por ningun jugador
                JOptionPane.showMessageDialog(null,"Ganó el jugador "+result);
            }else{//si se aposto por algun jugador
                DecimalFormat df =  new DecimalFormat("#.##");
                if(jugador.numJugadorApostadoCarrera==result){//y ese jugador gana
                    double ganado=jugador.cantidadApostadaCarrera*jugador.cuotaApCarrera;//calculamos la cantidad ganada
                    jugador.cuenta.agregarGanada(ganado, jugador.cantidadApostadaCarrera);//agregamos la ganada al registro(incluye el deposito)
                    JOptionPane.showMessageDialog(null,"Felicidades!, ganó el jugador "+result+". Ganaste $"+df.format(ganado));//Avisamos
                }else{//si el jugador no gana
                    jugador.cuenta.agregarPerdida(jugador.cantidadApostadaCarrera);//agregamos la perdida al registro
                    JOptionPane.showMessageDialog(null,"Ganó el jugador "+result+". Perdiste $"+jugador.cantidadApostadaCarrera);//Avisamos
                }
            }
    }//FIN DE RUN
    
    @Override public void update(Observable o, Object num){
        if(num!=null){
            Integer n=0;
            if(num.getClass().equals(n.getClass())){//si el objeto recibido es un entero
                Integer resultado=(Integer)num;//recibimos el numero
                result=resultado;
                //Iniciamos este hilo
                hilo=new Thread(this);
                hilo.start();  
            }
        }
        
    }//FIN DE UPDATE
}
