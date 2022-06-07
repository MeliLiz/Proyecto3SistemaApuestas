
package src.edd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Clase que simula una cuenta de dinero
 * @author meli
 */
public class Cuenta implements Serializable{
    private double saldoDisponible;//Saldo disponible
    Lista<String[]> movimientos;//Historial de movimientos
    Lista<String[]> apuestasGanadas;//Apuestas que se han ganado
    Lista<String[]> apuestasPerdidas;//Apuestas que se han perdido

    /**
     * Constructor de una cuenta
     */
    public Cuenta(){
        saldoDisponible=0;//Saldo inicial 0
        movimientos=new Lista<>();//creamos lista de historial
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String[] arr={"Creacion de cuenta","-", dtf.format(LocalDateTime.now())};//registramos el movimiento en el historial
        movimientos.add(arr);//agregamos la creacion de la cuenta al historial
        apuestasGanadas=new Lista<>();//Creamos la lista de apuestas ganadas
        apuestasPerdidas=new Lista<>();//Creamos la lista de apuestas perdidas
    }//FIN DE CONSTRUCTOR 1

    /**
     * Metodo para depositar dinero a la cuenta
     * @param n
     * @return boolean false si no se pudo hacer el deposito, true si se realizó existosamente
     */
    public boolean depositar(double n){
        if(n<0){//No se puede depositar saldo negativo
            return false;
        }else{
            saldoDisponible+=n;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            DecimalFormat df =  new DecimalFormat("#.##");
            String[] arr={"Deposito",""+df.format(n), dtf.format(LocalDateTime.now())};
            movimientos.add(arr);//registramos el movimiento en el historial
            return true;
        }
    }//FIN DE DEPOSITAR

    /**
     * Metodo para retirar dinero de la cuenta
     * @param n
     * @return boolean true si se realizó exitosamente, false si no se pudo
     */
    public boolean retirar(double n){
        if(n<0||n>saldoDisponible){//Si el numero es negativo o el saldo disponible no alcanza
            return false;
        }else{
            saldoDisponible-=n;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            DecimalFormat df =  new DecimalFormat("#.##");
            String[] arr={"Retiro",""+df.format(n), dtf.format(LocalDateTime.now())};
            movimientos.add(arr);//registramos el movimiento en el historial
            return true;
        }
    }//FIN DE RETIRAR

    /**
     * Metodo para apostar. Similar a retirar pero el historial se registra diferente
     * @param n
     * @return
     */
    public boolean apostar(double n){
        if(n<0||n>saldoDisponible){
            return false;
        }else{
            saldoDisponible-=n;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            DecimalFormat df =  new DecimalFormat("#.##");
            String[] arr={"Apuesta",""+df.format(n), dtf.format(LocalDateTime.now())};
            movimientos.add(arr);//registramos el movimiento en el historial
            return true;
        }
    }// FIN DE APOSTAR

    /**
     * Metodo para consultar el saldo disponible
     * @return
     */
    public double consultarSaldo(){
        return saldoDisponible;
    }//FIN DE CONSULTAR SALDO

    /**
     * Metodo para depositar el dinero ganado de la carrera
     * @param ganado
     * @param apostado
     */
    public void agregarGanada(double ganado, double apostado){
        depositar(ganado);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        DecimalFormat df =  new DecimalFormat("#.##");
        String[] arr={""+apostado,""+df.format(ganado), dtf.format(LocalDateTime.now())};//registramos el movimiento en el historial
        apuestasGanadas.add(arr);
    }// FIN DE AGREGAR GANADA

    /**
     * Metodo para registrar la perdida de la carrera
     * @param perdido
     */
    public void agregarPerdida(double perdido){
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         DecimalFormat df =  new DecimalFormat("#.##");
        String[] arr={""+df.format(perdido), dtf.format(LocalDateTime.now())};//registramos el movimiento en el historial
        apuestasPerdidas.add(arr);
    }//FIN DE AGREGAR PERDIDA
}

