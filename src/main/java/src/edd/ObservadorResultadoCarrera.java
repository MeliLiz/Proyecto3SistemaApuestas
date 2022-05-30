
package src.edd;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 *
 * @author meli
 */
public class ObservadorResultadoCarrera implements Runnable,Observer{
    Jugador jugador;
    Integer result;
    Thread hilo;
    
    public ObservadorResultadoCarrera(Jugador jugador){
        this.jugador=jugador;
        hilo=new Thread(this);
    }
    
    @Override public void run(){
        if(jugador.numJugadorApostadoCarrera==0){
                JOptionPane.showMessageDialog(null,"Ganó el jugador "+result);
            }else{
                DecimalFormat df =  new DecimalFormat("#.##");
                if(jugador.numJugadorApostadoCarrera==result){
                    double ganado=jugador.cantidadApostadaCarrera*jugador.cuotaApCarrera;
                    jugador.cuenta.agregarGanada(ganado, jugador.cantidadApostadaCarrera);
                    JOptionPane.showMessageDialog(null,"Felicidades!, ganó el jugador "+result+". Ganaste $"+df.format(ganado));
                }else{
                    jugador.cuenta.agregarPerdida(jugador.cantidadApostadaCarrera);
                    JOptionPane.showMessageDialog(null,"Ganó el jugador "+result+". Perdiste $"+jugador.cantidadApostadaCarrera);
                }
            }
    }
    
    @Override public void update(Observable o, Object num){
        if(num!=null){
            Integer n=0;
            if(num.getClass().equals(n.getClass())){
                Integer resultado=(Integer)num;
                result=resultado;
                hilo=new Thread(this);
                hilo.start();  
            }
        }
        
    }
}
