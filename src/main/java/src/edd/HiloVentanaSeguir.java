
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author meli
 */
public class HiloVentanaSeguir extends Thread implements Observer {
    HiloInicio h;
    VentanaSeguir ventana;
    
    public HiloVentanaSeguir(HiloInicio h){
        this.h=h;
    }
    
    @Override public void run(){
        VentanaSeguir seguir = new VentanaSeguir(h);
        ventana=seguir;
        seguir.setVisible(true);
    }
    
    @Override public void update(Observable o, Object obj){
        ventana.dispose();
    }
}
