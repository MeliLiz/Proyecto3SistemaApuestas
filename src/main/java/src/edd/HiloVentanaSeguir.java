
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 * Hilo de la ventana seguir
 * @author meli
 */
public class HiloVentanaSeguir extends Thread implements Observer {
    HiloInicio h;//El hilo para la ventana seguir
    VentanaSeguir ventana;//La ventana seguir
    
    /**
     * Constructor
     * @param h 
     */
    public HiloVentanaSeguir(HiloInicio h){
        this.h=h;
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        //abrimos la ventana
        VentanaSeguir seguir = new VentanaSeguir(h);
        ventana=seguir;
        seguir.setVisible(true);
    }//FIN DE RUN
    
    @Override public void update(Observable o, Object obj){
        //cerramos la ventana
        ventana.dispose();
    }//FIN DE UPDATE
}
