
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 * Clase para controlar el momento para abrir y cerrar la ventana para seguir en el torneo o no
 * @author meli
 */
public class ControlVentSeguir implements Observer{
    HiloInicio h;//El hilo necesario para la ventana seguir
    /**
     * Constructor
     * @param h 
     */
    public ControlVentSeguir(HiloInicio h){
        this.h=h;
    }
    
    @Override public void update(Observable o, Object obj){
        //Si el objeto que recibimos es null, abrimos la ventana de seguir
        if(obj==null){
            Cronometro cr=new Cronometro(5000);//Hacemos cronometro
            HiloVentanaSeguir hilo1=new HiloVentanaSeguir(h);//Hacemos el hilo de la ventana
            cr.addObserver(hilo1);//ponemos un observador al cronometro
            //Comenzamos los hilos
            hilo1.start();
            cr.start();
        }
    }
}
