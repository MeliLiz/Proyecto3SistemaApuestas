
package src.edd;
import java.util.Iterator;
import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author meli
 */
public class HiloInicio extends Observable implements Runnable,Observer{
    Juego juego;
    Jugador jugador;
    Thread hilo;
    boolean seguir;
    Sesion padre;
            
    public HiloInicio(Juego juego, Jugador jugador, Sesion sesion){
        this.juego=juego;
        hilo=new Thread(this);
        this.jugador=jugador;
        seguir=true;
        padre=sesion;
    }
    
    @Override public void run(){
        
        while(seguir){
            //Ponemos valores del jugador en 0
            jugador.numJugadorApostado=0;
            jugador.cantidadApostada=0;
            jugador.cuotaAp=0;
            
            for(int i=0;i<4;i++){
                padre.getCarrera(i+1).setText("");
            }
            padre.getTorneo(1).setText("");
            padre.getTorneo(2).setText("");
            
            System.out.println("Ejecutandose hiloInicio");
            Candidato[] lugares=new Candidato[16];

            Lista<Candidato> candidatos=juego.candidatos.clone();//lista de los candidatos para el torneo
            candidatos.shuffle();
            
            this.setChanged();
            this.notifyObservers(new Cola<Integer>());
            
            try{
                Thread.sleep(20000);//Tiempo para apostar por el torneo
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo");
            }
            
            padre.getTorneo(1).setText("Inicio del torneo");
            //Primera carrera

            Lista<Candidato> competidores1=new Lista<>();//lista de los candidatos para la primera carrera
            for(int i=0;i<8;i++){//Primera carrera de 8 competidores
                competidores1.add(candidatos.pop());
            }

            //Lista<Candidato> dado=Dado(competidores1);

            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(competidores1);

            try{
                Thread.sleep(20000);//Tiempo para apostar por la primera carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo");
            }

            padre.getCarrera(1).setText("Carrera 1 en progreso");
            //Tomamos los competidores que competiran de nuevo
            Lista<Candidato> pasantes1=pasantes(competidores1,3);
            int ganador1=pasantes1.peekCabeza().num;//obtenemos al ganador
            

            //Esperamos el tiempo que debe durar la carrera
            try{
                Thread.sleep(20000);//esperamos a que se termine el tiempo de corrida
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 2");
            }

            //Notificamos al usuario si gano o no
            //Hacer un hilo
            //Con notificacion del ganador de la carrera y si su apuesta fue acertada o no
            
            padre.getCarrera(1).setText("Carrera 1 finalizada");

            //Notificamos a los observadores de mensajes
            this.setChanged();
            this.notifyObservers(ganador1);
            

            //damos tiempo para la notificacion del ganador
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 3");
            }

            //Carrera 2

            //hacemos el dado con los candidatos que no han competido
            //dado=Dado(candidatos);
            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(candidatos);

            try{
                Thread.sleep(20000);//esperamos el tiempo para apostar por la segunda carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 4");
            }
            
            padre.getCarrera(2).setText("Carrera 2 en progreso");

            //Tomamos los competidores que competiran de nuevo
            Lista<Candidato> pasantes2=pasantes(candidatos,3);
            int ganador2=pasantes2.peekCabeza().num;//obtenemos al ganador

            //Esperamos el tiempo que debe durar la carrera
            try{
                Thread.sleep(20000);//esperamos a que se termine el tiempo de corrida
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 5");
            }

            //Notificamos al usuario si gano o no
            //Hacer un hilo
            //Con notificacion del ganador de la carrera y si su apuesta fue acertada o no

            //Notificamos a los observadores de mensajes
            this.setChanged();
            this.notifyObservers(ganador2);
            
            padre.getCarrera(2).setText("Carrera 2 finalizada");

            //damos tiempo para la notificacion del ganador
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 6");
            }
            
            //Carrera 3
            //Carrera de los que no pasaron para asignarles su lugar
            competidores1.append(candidatos);
            System.out.println(competidores1);
            //dado=Dado(competidores1);
            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(competidores1);
            
            try{
                Thread.sleep(20000);//esperamos el tiempo para apostar por la tercera carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 4");
            }
            
            padre.getCarrera(3).setText("Carrera 3 en progreso");

            //Tomamos los competidores en el orden
            Lista<Candidato> l=pasantes(competidores1,10);
            Candidato sexto=l.peekCabeza();
            int k=0;
            for(int i=6;i<16;i++){
                lugares[i]=l.elementoEnPos(k);//Asignamos el lugar de cada competidor
                k+=1;
            }
            
            //Esperamos el tiempo que debe durar la carrera
            try{
                Thread.sleep(20000);//esperamos a que se termine el tiempo de corrida
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 5");
            }


            //Notificamos a los observadores de mensajes
            this.setChanged();
            this.notifyObservers(sexto.num);
            
            padre.getCarrera(3).setText("Carrera 3 finalizada");
            
            
            //damos tiempo para la notificacion del ganador
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 6");
            }
            
            
            //Carrera 4

            //Hacemos la lista de los competidores de la ronda final
            pasantes1.append(pasantes2);

            //hacemos el dado con los candidatos que no han competido
            //dado=Dado(pasantes1);
            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(pasantes1);

            try{
                Thread.sleep(20000);//esperamos el tiempo para apostar por la tercera carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 7");
            }

            padre.getCarrera(4).setText("Carrera 4 en progreso");

            //Tomamos los el lugar de cada candidato en la competencia
            Lista<Candidato> ganadores=pasantes(pasantes1,6);
            int ganador=ganadores.peekCabeza().num;//obtenemos al ganador
            
            //Ponemos a los candidatos en el lugar correspondiente del arreglo de lugares
            for(int i=0;i<6;i++){
                lugares[i]=ganadores.elementoEnPos(i);
            }

            //Esperamos el tiempo que debe durar la carrera
            try{
                Thread.sleep(20000);//esperamos a que se termine el tiempo de corrida
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 8");
            }


            //Notificamos a los observadores de mensajes
            this.setChanged();
            this.notifyObservers(ganador);
            
            padre.getCarrera(4).setText("Carrera 4 finalizada");

            //damos tiempo para la notificacion del ganador de la carrera 4
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 9");
            }

            //Notificamos a los observadores de mensajes de torneo
            this.setChanged();
            this.notifyObservers(ganadores.peekCabeza());
            
            padre.getTorneo(2).setText("Ganador del torneo: Competidor "+ganador);

            //damos tiempo para la notificacion del ganador del torneo
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 10");
            }

            //notificamos a los observadores para abrir la ventana de seguir
            this.setChanged();
            this.notifyObservers(null);

            //damos tiempo para saber si se ejecutara de nuevo
            try{
                Thread.sleep(6000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 11");
            }
        
            //Cambiar la ultima posicion de cada jugador por la que les corresponde
            for(int i=0;i<lugares.length;i++){
                lugares[i].historialPosiciones.add(i+1);
                lugares[i].historialPosiciones.eliminaEnPos(0);
            }
        }
    }
    
    //En el momento en que reciba la señal del cronometro, empezara su ejecucion
    @Override public void update(Observable o, Object args){
        hilo.start();
    }
    
    public void start(){
        hilo.start();
    }
    
    private Lista<Candidato> pasantes(Lista<Candidato> competidores, int n){
        Lista<Candidato> regreso=new Lista<>();
        System.out.println("Tamaño: "+competidores.size());
        for(int i=0;i<n;i++){
            System.out.println("i="+i);
            Lista<Candidato> dado=Dado(competidores);
            Candidato g=escogerGanador(dado);
            regreso.add(g);
            competidores.delete(g);
        }
        System.out.println(competidores);
        return regreso;
    }
    
    private Candidato escogerGanador(Lista<Candidato> dado){
        //lanzamos el dado
        dado.shuffle();
        //escogemos al ganador
        Candidato ganador=dado.pop();
        return ganador;
    }
    
    /**
     * Metodo para obtener el dado cargado y calcular la probabilidad y cuota del candidato
     * @param competidores
     * @return 
     */
    private Lista<Candidato> Dado(Lista<Candidato> competidores){
        
        //Calculamos la probabilidad y cuota de cada competidor de la carrera
        Iterator<Candidato> iterador=competidores.iterator();
        int suma=0;
            //sumamos las habilidades de los candidatos
        for(int i=0;i<competidores.size();i++){
            suma+=iterador.next().habilidad;
        }
        //hacemos el dado cargado
        Lista<Candidato> dado=new Lista<>();
            //Calculamos la probabilidad de ganar el torneo de cada candidato
        iterador=competidores.iterator();
        for(int i=0;i<competidores.size();i++){
            Candidato actual=iterador.next();
            actual.probabilidadCarrera=actual.habilidad/suma;//calculamos probabilidad de ganar la carrera
            actual.cuotaCarrera=1/actual.probabilidadCarrera;//calculamos la cuota decimal
            //Hacemos el dado cargado dependiendo con la probabilidad de ganar
            double p=Math.round(actual.probabilidadCarrera*100);
            for(int j=0;j<p;j++){
                dado.add(actual);
            }
        }
        return dado;
    }
}
