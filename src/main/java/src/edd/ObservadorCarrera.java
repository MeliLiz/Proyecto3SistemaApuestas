
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 *Clase para abrir la ventana para apostar en la carrera en el momento correcto
 * @author meli
 */
public class ObservadorCarrera implements Observer {
    static Jugador jugador;//El jugador con el que estamos trabajando
    
    /**
     * Constructor
     * @param jugador 
     */
    public ObservadorCarrera(Jugador jugador){
        this.jugador=jugador;
    }//FIN DE CONSTRUCTOR
    
    
    //Debe recibir la lista de competidores
    @Override public void update(Observable o, Object lista){
        if(lista!=null){
            if(lista.getClass().equals(new Lista<Candidato>().getClass())){
                //Ponemos los valores de la carrera del jugador en 0
                jugador.cantidadApostadaCarrera=0;
                jugador.cuotaApCarrera=0;
                jugador.numJugadorApostadoCarrera=0;
            
                Lista<Candidato> competidores=(Lista<Candidato>)lista;
                HiloVentanaCarreras hilo1=new HiloVentanaCarreras(jugador, competidores);
                Segundero segundero=new Segundero();
                Cronometro cronometro=new Cronometro(20000);
                cronometro.addObserver(hilo1);
                segundero.addObserver(hilo1);
                hilo1.start();
                segundero.start();
                cronometro.start();
            }
        }  
    }//FIN DE UPDATE
}
