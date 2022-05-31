
package src.edd;
import java.util.Observable;
import java.util.Observer;

/**
 * Hilo para mostrar la ventana de apuesta de carreras
 * @author meli
 */
public class HiloVentanaCarreras extends Thread implements Observer{
    static Jugador jugador;//el jugador con el que estamos trabajando
    static Lista<Candidato> competidores;//los competidores de la carrera
    static ApostarCarrera ventana; //la ventana para apostar en la carrera
    
    /**
     * Constructor
     * @param jugador
     * @param competidores 
     */
    public HiloVentanaCarreras(Jugador jugador, Lista<Candidato> competidores){
        this.jugador=jugador;
        this.competidores=competidores;
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        //abrimos la ventana
        ApostarCarrera a=new ApostarCarrera(jugador, competidores);
        ventana=a;
        a.setVisible(true);
    }//FIN DE RUN
    
    @Override public void update(Observable o, Object arg){
        String c="";
        if(arg.getClass().equals(c.getClass())){
            String s=(String)arg;
            System.out.println(s);
            //cerramos la ventana
            ventana.dispose();
            this.interrupt();
        }else{
            Integer n=(Integer)arg;
            ventana.getSegundos().setText(""+n);
        }
        
    }//FIN DE UPDATE
}
