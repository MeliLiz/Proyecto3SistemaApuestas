
package src.edd;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Clase de candidatos a jugadores
 * @author meli
 */
public class Candidato implements Serializable {

    int num;//El numero de candidato
    double habilidad;//La habilidad del candidato
    //double cuota;//La cuota por apostar por este candidato
    double probabilidadTorneo;//La probabilidad del torneo
    double probabilidadCarrera;//La probabilidad del torneo
    double cuotaTorneo;
    double cuotaCarrera;
    Lista<Integer> historialPosiciones;//el historial de posiciones
    
    
    /**
     * Constructor del candidato
     * @param numCandidato
     * @param habilidad
     */
    public Candidato(int numCandidato, int habilidad){
        historialPosiciones=new Lista<Integer>();
        //cuota=0;
        num=numCandidato;
        this.habilidad=habilidad;
    }
    
    /**
     * Metodo para calcular la probabilidad de ganar del jugador en todo el torneo
     * @param lista
     * @return 
     */
    public double calcularProbabilidadTorneo(Lista<Candidato> lista){
        Iterator<Candidato> iterador=lista.iterator();
        int suma=0;
        //sumamos las habilidades de los candidatos
        for(int i=0;i<lista.size();i++){
            suma+=iterador.next().habilidad;
        }
        //Calculamos la probabilidad de ganar el torneo del jugador
        probabilidadTorneo=habilidad/suma;
        return probabilidadTorneo;
    }
    
    /**
     * Metodo para calcular la probabilidad de ganar del jugador en la carrera
     * @param lista
     * @return 
     */
    public double calcularProbabilidadCarrera(Lista<Candidato> lista){
        Iterator<Candidato> iterador=lista.iterator();
        int suma=0;
        //sumamos las habilidades de los candidatos
        for(int i=0;i<lista.size();i++){
            suma+=iterador.next().habilidad;
        }
        //Calculamos la probabilidad de ganar la carrera del jugador
        probabilidadCarrera=habilidad/suma;
        return probabilidadCarrera;
    }

    /**
     * Metodo para calcular la cuota del torneo
     * @return
     */
    public double calcularCuotaTorneo(){
        cuotaTorneo=1/probabilidadTorneo;
        return cuotaTorneo;
    }

    /**
     * Metodo para calcular la cuota de la carrera
     * @return
     */
    public double calcularCuotaCarrera(){
        cuotaCarrera=1/probabilidadCarrera;
        return cuotaCarrera;
    }

    @Override
    public String toString(){
        return ""+num;
    }
    
    @Override public boolean equals(Object o){
        if(!o.getClass().equals(this.getClass())){
            throw new IllegalArgumentException();
        }
        Candidato c=(Candidato)o;
        if(c.num==this.num){
            return true;
        }
        return false;
    }
}

