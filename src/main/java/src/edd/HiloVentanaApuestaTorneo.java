
package src.edd;
import java.util.Observer;
import java.util.Observable;


/**
 * Hilo de la ventana para apostar en el torneo
 * @author meli
 */
public class HiloVentanaApuestaTorneo extends Thread implements Observer{
    static Jugador jugador;//el jugador con el que estamos trabajando
    static Juego juego;//el juego con el que estamos trabajando
    static ApostarTorneo ventana;//la ventana para apostar por el torneo
    
    /**
     * Constructor
     * @param jugador
     * @param juego 
     */
    public HiloVentanaApuestaTorneo(Jugador jugador, Juego juego){
        this.jugador=jugador;
        this.juego=juego;
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        //Abrimos la ventana
        ApostarTorneo apTorneo=new ApostarTorneo(jugador,juego);
        ventana=apTorneo;
        apTorneo.setVisible(true);
    }//FIN DE RUN
    
    @Override public void update(Observable o, Object arg){
        String c="";
        if(arg.getClass().equals(c.getClass())){
            //cerramos la ventana
            String s=(String)arg;
            System.out.println(s);
            ventana.dispose();
            this.interrupt();
        }else{
            Integer n=(Integer)arg;
            ventana.getSegundos().setText(""+n);
        }
        
        
    }//FIN DE UPDATE
    
    
}
