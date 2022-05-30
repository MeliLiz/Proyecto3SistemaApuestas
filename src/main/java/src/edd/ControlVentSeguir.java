
package src.edd;
import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author meli
 */
public class ControlVentSeguir implements Observer{
    HiloInicio h;
    public ControlVentSeguir(HiloInicio h){
        this.h=h;
    }
    
    @Override public void update(Observable o, Object obj){
        if(obj==null){
            Cronometro cr=new Cronometro(5000);
            HiloVentanaSeguir hilo1=new HiloVentanaSeguir(h);
            cr.addObserver(hilo1);
            hilo1.start();
            cr.start();
        }
    }
}
