
package src.edd;
import java.util.Iterator;
import java.util.Observer;
import java.util.Observable;

/**
 * hilo para iniciar los torneos
 * @author meli
 */
public class HiloInicio extends Observable implements Runnable,Observer{
    Juego juego;//El juego con el que estamos trabajando
    Jugador jugador;//El jugador con el que estamos trabajando
    Thread hilo;//Este hilo
    boolean seguir;//Para saber si seguir los torneos o no
    Sesion padre; //La ventana sesion que llama a este hilo
    
    /**
     * Constructor
     * @param juego
     * @param jugador
     * @param sesion La ventana sesion que llama a este hilo
     */
    public HiloInicio(Juego juego, Jugador jugador, Sesion sesion){
        this.juego=juego;
        hilo=new Thread(this);
        this.jugador=jugador;
        seguir=true;
        padre=sesion;
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        
        while(seguir){//Ejecutamos tantas veces como quiera el usuario
            
            //Ponemos valores del jugador en 0
            jugador.numJugadorApostado=0;
            jugador.cantidadApostada=0;
            jugador.cuotaAp=0;
            
            Iterator it=juego.candidatos.iterator();
            for(int i=0;i<16;i++){
                System.out.println(it.next());
            }
            
            //Quitamos el texto de la ventana sesion
            for(int i=0;i<4;i++){
                padre.getCarrera(i+1).setText("");
            }
            padre.getTorneo(1).setText("");
            padre.getTorneo(2).setText("");
            
            System.out.println("Ejecutandose hiloInicio");
            //Hacemos el arreglo de los lugares en los que quedaran los candidatos en el torneo
            Candidato[] lugares=new Candidato[16];

            //Copiamos la lista de candidatos del juego
            Lista<Candidato> candidatos=juego.candidatos.clone();//lista de los candidatos para el torneo
            candidatos.shuffle();
            
            //Avisamos a los observadores de la ventana para apostar en el torneo que ya se puede abrir
            this.setChanged();
            this.notifyObservers(new Cola<Integer>());
            
            //Dormimos el hilo 20 segundos en lo que el usuario hace su apuesta
            try{
                Thread.sleep(20000);//Tiempo para apostar por el torneo
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo");
            }
            
            //Ponemos en la ventana de sesion que el torneo comienza
            padre.getTorneo(1).setText("Inicio del torneo");
            
            
            //Primera carrera

            //Hacemos la lista de los candidatos que competiran en la primera carrera
            Lista<Candidato> competidores1=new Lista<>();
            for(int i=0;i<8;i++){
                competidores1.add(candidatos.pop());
            }

            //notificamos a los observadores que abren la ventana para apostar en la carrera
            this.setChanged();
            this.notifyObservers(competidores1);

            //Dormimos el hilo en lo que el usuario hace su apuesta
            try{
                Thread.sleep(20000);//Tiempo para apostar por la primera carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo");
            }

            //Ponemos en la ventana sesion que la carrera esta en progreso
            padre.getCarrera(1).setText("Carrera 1 en progreso");
            //Tomamos los competidores que ganan
            Lista<Candidato> pasantes1=pasantes(competidores1,3);
            int ganador1=pasantes1.peekCabeza().num;//obtenemos al ganador de la carrera
            
            //Esperamos el tiempo que debe durar la carrera
            try{
                Thread.sleep(20000);//esperamos a que se termine el tiempo de corrida
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 2");
            }
            
            //Ponemos el la ventana de sesion que la carrera 1 finalizo
            padre.getCarrera(1).setText("Carrera 1 finalizada");

            //Notificamos a los observadores de mensajes de ganadores
            this.setChanged();
            this.notifyObservers(ganador1);
        
            //damos tiempo para la notificacion del ganador
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 3");
            }

            //Carrera 2

            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(candidatos);//los candidatos que competiran son los que no compitieron en la carrera anterior

            //Dormimos el hilo en lo que el usuario hace su apuesta
            try{
                Thread.sleep(20000);//esperamos el tiempo para apostar por la segunda carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 4");
            }
            
            //Ponemos en la ventana de sesion que la carrera 2 comenzo
            padre.getCarrera(2).setText("Carrera 2 en progreso");

            //Tomamos a los que ganaron la carrera
            Lista<Candidato> pasantes2=pasantes(candidatos,3);
            int ganador2=pasantes2.peekCabeza().num;//obtenemos al ganador

            //Esperamos el tiempo que debe durar la carrera
            try{
                Thread.sleep(20000);//esperamos a que se termine el tiempo de corrida
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 5");
            }

            //Notificamos a los observadores de mensajes para que avisen quien gana y si la apuesta del usuario fue acertada
            this.setChanged();
            this.notifyObservers(ganador2);
            
            //Ponemos en la ventana de sesion que la carrera 2 finalizo
            padre.getCarrera(2).setText("Carrera 2 finalizada");

            //damos tiempo para la notificacion del ganador
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 6");
            }
            
            //Carrera 3
            
            //Carrera de los que no pasaron a la carrera final para asignarles su lugar
            competidores1.append(candidatos);
            System.out.println(competidores1);
         
            //notificamos a los observadores que abren la ventana para apostar en la carrera
            this.setChanged();
            this.notifyObservers(competidores1);
            
            //Dormimos el hilo en lo que el jugador apuesta
            try{
                Thread.sleep(20000);//esperamos el tiempo para apostar por la tercera carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 4");
            }
            
            //ponemos en la ventana de sesion que la carrera 3 comienza
            padre.getCarrera(3).setText("Carrera 3 en progreso");

            //Tomamos los competidores en el orden
            Lista<Candidato> l=pasantes(competidores1,10);
            Candidato sexto=l.peekCabeza();//el ganador de la carrera que quedara en septimo lugar del torneo
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

            //Notificamos a los observadores de mensajes del ganador
            this.setChanged();
            this.notifyObservers(sexto.num);
            
            //Ponemos en la ventana de sesion que la carrera 3 finalizo
            padre.getCarrera(3).setText("Carrera 3 finalizada");
            
            //damos tiempo para la notificacion del ganador
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 6");
            }
            
            //Carrera 4

            //Hacemos la lista de los competidores de la ronda final (los que pasaron la carrera 1 y 2)
            pasantes1.append(pasantes2);

            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(pasantes1);

            //dormimos el hilo en lo que el usuario apuesta
            try{
                Thread.sleep(20000);//esperamos el tiempo para apostar por la tercera carrera
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 7");
            }

            //Ponemos en la ventana de sesion que la carrera 4 comenzo
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
            
            //Notificamos a los observadores de mensajes del ganandor
            this.setChanged();
            this.notifyObservers(ganador);
            
            //Ponemos en la ventana de sesion que la carrera 4 finalizo
            padre.getCarrera(4).setText("Carrera 4 finalizada");

            //damos tiempo para la notificacion del ganador de la carrera 4
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo 9");
            }

            //Notificamos a los observadores de mensajes del ganador del torneo
            this.setChanged();
            this.notifyObservers(ganadores.peekCabeza());
            
            //Ponemos en la ventana de sesion el ganador del torneo
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
                lugares[i].historialPosiciones.add(i+1);//Agregaamos la posicion en la que quedo el competidor en su historial
                lugares[i].historialPosiciones.eliminaEnPos(0);//quitamos la primera posicion ed su historial
            }
        }
    }//FIN DE RUN
    
    //En el momento en que reciba la señal del cronometro, empezara su ejecucion
    @Override public void update(Observable o, Object args){
        hilo.start();
    }//FIN DE UPDATE
    
    /**
     * Metodo para comenzar este hilo
     */
    public void start(){
        hilo.start();
    }//FIN DE START
    
    //metodo para obtener a los competidores de los primeros lugares
    //competidores lista de competidores de la cual obtendremos a los primeros lugares
    //n el numero de primeros lugares que queremos
    private Lista<Candidato> pasantes(Lista<Candidato> competidores, int n){
        Lista<Candidato> regreso=new Lista<>();
        System.out.println("Tamaño: "+competidores.size());
        for(int i=0;i<n;i++){
            System.out.println("i="+i);
            //Hacemos el dado con base en la probabilidad de ganar de cada jugador
            Lista<Candidato> dado=Dado(competidores);
            Candidato g=escogerGanador(dado);
            regreso.add(g);
            competidores.delete(g);
        }
        System.out.println(competidores);
        return regreso;
    }//FIN DE PASANTES
    
    //Metodo para escoger al ganador dada una lista
    private Candidato escogerGanador(Lista<Candidato> dado){
        //lanzamos el dado
        dado.shuffle();
        //escogemos al ganador
        Candidato ganador=dado.pop();
        return ganador;
    }//FIN DE ESCOGERGANADOR
    
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
    }// FIN DE DADO
}
