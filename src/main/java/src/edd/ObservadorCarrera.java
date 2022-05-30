
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 *Clase para abrir la ventana para apostar en la carrera en el momento correcto
 */
public class ObservadorCarrera implements Observer {
    static Jugador jugador;
    
    public ObservadorCarrera(Jugador jugador){
        this.jugador=jugador;
    }
    
    
    //Debe recibir la lista de competidores
    @Override public void update(Observable o, Object lista){
        if(lista!=null){
            if(lista.getClass().equals(new Lista<Candidato>().getClass())){
                jugador.cantidadApostadaCarrera=0;
                jugador.cuotaApCarrera=0;
                jugador.numJugadorApostadoCarrera=0;
            
                Lista<Candidato> competidores=(Lista<Candidato>)lista;
                HiloVentanaCarreras hilo1=new HiloVentanaCarreras(jugador, competidores);
                Cronometro cronometro=new Cronometro(20000);
                cronometro.addObserver(hilo1);
                hilo1.start();
                cronometro.start();
            }
        }
        
        
        
    }
}
