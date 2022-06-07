
package src.edd;
import java.util.Iterator;
import java.util.Observer;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;
import java.util.Random;

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
    DefaultTableModel[] modelos;//arreglo de los modelos para las tablas de la ventana sesion
    javax.swing.JTable[] tablas;//arreglo de las tablas de la ventana de la ventana sesion
    javax.swing.JLabel[] tiempos;//arreglo de las etiquetas de tiempo de la ventana sesion
    
    /**
     * Constructor
     * @param juego
     * @param jugador
     * @param sesion La ventana sesion que llama a este hilo
     */
    public HiloInicio(Juego juego, Jugador jugador, Sesion sesion){
        this.juego=juego;//El juego con el que estamos trabajando
        hilo=new Thread(this);//Este hilo
        this.jugador=jugador;//El jugador con el que estamos trabajando
        seguir=true;//para seguir con los torneos
        padre=sesion;//la sesion que llamo a este hilo
        tablas=new javax.swing.JTable[8];//el arreglo de tablas de la ventana sesion para modificarlas
        tiempos=new javax.swing.JLabel[9];//el arreglo de etiqutas de tiempo de la ventana sesion para modificarlas
        //Obtenemos todas las etiquetas de tiempo
        for(int i=0;i<9;i++){
            tiempos[i]=padre.getTiempo(i+1);
        }
        //Obtenemos todas las tablas
        for(int i=0;i<8;i++){
            tablas[i]=padre.getTabla(i+1);
        }
        //Creamos el arreglo de modelos de las tablas
        modelos=new DefaultTableModel[8];
        hacerModelos();
    }//FIN DE CONSTRUCTOR
    
    @Override public void run(){
        while(seguir){//Ejecutamos tantas veces como quiera el usuario
            
            //Ponemos valores del jugador del torneo en 0
            jugador.numJugadorApostado=0;
            jugador.cantidadApostada=0;
            jugador.cuotaAp=0;
            
            //Quitamos los valores anteriores de las etiquetas de tiempo
            /*for(int i=0;i<9;i++){
                tiempos[i].setText("");
            }*/
            
            //quitamos los valores anteriores de las tablas
            for(int i=0;i<8;i++){
                if (tablas[i].getColumnCount()>0) {
                    modelos[i].setColumnCount(0);
                    modelos[i].setRowCount(0);
                }
            }
            
            /*Iterator it=juego.candidatos.iterator();
            for(int i=0;i<16;i++){
                System.out.println(it.next());
            }*/
            
            //Quitamos el texto de la ventana sesion
            for(int i=0;i<4;i++){
                padre.getCarrera(i+1).setText("");
            }
            padre.getTorneo(1).setText("");
            padre.getTorneo(2).setText("");
            
            //System.out.println("Ejecutandose hiloInicio");
            //Hacemos el arreglo de los lugares en los que quedaran los candidatos en el torneo
            Candidato[] lugares=new Candidato[16];

            //Copiamos la lista de candidatos del juego
            Lista<Candidato> candidatos=juego.candidatos.clone();//lista de los candidatos para el torneo
            candidatos.shuffle();
            
            //Avisamos a los observadores de la ventana para apostar en el torneo que ya se puede abrir
            this.setChanged();
            this.notifyObservers(new Cola<Integer>());
            
            padre.getTorneo(1).setText("El torneo comienza en");
            //Dormimos el hilo 20 segundos en lo que el usuario hace su apuesta
            dormir(20, 0);
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

            padre.getCarrera(1).setText("Carrera 1 comienza en");
            //Dormimos el hilo en lo que el usuario hace su apuesta
            dormir(20,1);            
            //Ponemos en la ventana sesion que la carrera esta en progreso
            padre.getCarrera(1).setText("Carrera 1 en progreso");
            
            setModelo(padre.getTabla(1),1);
            setDatos(competidores1,tablas[0],1);
            
            //Tomamos los competidores que ganan
            Lista<Candidato> pasantes1=pasantes(competidores1,3);
            int ganador1=pasantes1.peekCabeza().num;//obtenemos al ganador de la carrera
            
            //Esperamos el tiempo que debe durar la carrera
            dormir(10,2);
            
            //Ponemos el la ventana de sesion que la carrera 1 finalizo
            padre.getCarrera(1).setText("Carrera 1 finalizada");

            //Notificamos a los observadores de mensajes de ganadores
            this.setChanged();
            this.notifyObservers(ganador1);
            
            setModelo2(padre.getTabla(2),2);
            setDatos(pasantes1,tablas[1],2);
        
            //damos tiempo para la notificacion del ganador
            dormir(3,-1);

            //Carrera 2

            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(candidatos);//los candidatos que competiran son los que no compitieron en la carrera anterior

            padre.getCarrera(2).setText("Carrera 2 comienza en");
            //Dormimos el hilo en lo que el usuario hace su apuesta
            dormir(20,3);
            //Ponemos en la ventana de sesion que la carrera 2 comenzo
            padre.getCarrera(2).setText("Carrera 2 en progreso");
            
            
            setModelo(padre.getTabla(3),3);
            setDatos(candidatos,tablas[2],3);
            

            //Tomamos a los que ganaron la carrera
            Lista<Candidato> pasantes2=pasantes(candidatos,3);
            int ganador2=pasantes2.peekCabeza().num;//obtenemos al ganador

            //Esperamos el tiempo que debe durar la carrera
            dormir(10,4);

            //Notificamos a los observadores de mensajes para que avisen quien gana y si la apuesta del usuario fue acertada
            this.setChanged();
            this.notifyObservers(ganador2);
            
            
            setModelo2(padre.getTabla(4),4);
            setDatos(pasantes2,tablas[3],4);
            
            //Ponemos en la ventana de sesion que la carrera 2 finalizo
            padre.getCarrera(2).setText("Carrera 2 finalizada");

            //damos tiempo para la notificacion del ganador
            dormir(3,-1);
            
            //Carrera 3
            
            //Carrera de los que no pasaron a la carrera final para asignarles su lugar
            competidores1.append(candidatos);
            //System.out.println(competidores1);
         
            //notificamos a los observadores que abren la ventana para apostar en la carrera
            this.setChanged();
            this.notifyObservers(competidores1);
            
            padre.getCarrera(3).setText("Carrera 3 comienza en");
            //Dormimos el hilo en lo que el jugador apuesta
            dormir(20,5);
            //ponemos en la ventana de sesion que la carrera 3 comienza
            padre.getCarrera(3).setText("Carrera 3 en progreso");
            
            setModelo(padre.getTabla(5),5);
            setDatos(competidores1,tablas[4],5);

            //Tomamos los competidores en el orden
            Lista<Candidato> l=pasantes(competidores1,10);
            Candidato sexto=l.peekCabeza();//el ganador de la carrera que quedara en septimo lugar del torneo
            int k=0;
            for(int i=6;i<16;i++){
                lugares[i]=l.elementoEnPos(k);//Asignamos el lugar de cada competidor
                k+=1;
            }
            
            //Esperamos el tiempo que debe durar la carrera
            dormir(10,6);

            //Notificamos a los observadores de mensajes del ganador
            this.setChanged();
            this.notifyObservers(sexto.num);
            
            setModelo2(padre.getTabla(6),6);
            setDatos(l,tablas[5],6);
            
            //Ponemos en la ventana de sesion que la carrera 3 finalizo
            padre.getCarrera(3).setText("Carrera 3 finalizada");
            
            //damos tiempo para la notificacion del ganador
            dormir(3,-1);
            
            //Carrera 4

            //Hacemos la lista de los competidores de la ronda final (los que pasaron la carrera 1 y 2)
            pasantes1.append(pasantes2);

            //notificamos a los observadores que abren la ventana para apostar
            this.setChanged();
            this.notifyObservers(pasantes1);

            padre.getCarrera(4).setText("Carrera 4 comienza en");
            //dormimos el hilo en lo que el usuario apuesta
            dormir(20,7);
            //Ponemos en la ventana de sesion que la carrera 4 comenzo
            padre.getCarrera(4).setText("Carrera 4 en progreso");
            
            setModelo(padre.getTabla(7),7);
            setDatos(pasantes1,tablas[6],7);

            //Tomamos los el lugar de cada candidato en la competencia
            Lista<Candidato> ganadores=pasantes(pasantes1,6);
            int ganador=ganadores.peekCabeza().num;//obtenemos al ganador
            
            //Ponemos a los candidatos en el lugar correspondiente del arreglo de lugares
            for(int i=0;i<6;i++){
                lugares[i]=ganadores.elementoEnPos(i);
            }

            //Esperamos el tiempo que debe durar la carrera
            dormir(10,8);
            
            //Notificamos a los observadores de mensajes del ganandor
            this.setChanged();
            this.notifyObservers(ganador);
            
            setModelo2(padre.getTabla(8),8);
            setDatos(ganadores,tablas[7],8);
            
            //Ponemos en la ventana de sesion que la carrera 4 finalizo
            padre.getCarrera(4).setText("Carrera 4 finalizada");

            //damos tiempo para la notificacion del ganador de la carrera 4
            dormir(3,-1);

            //Notificamos a los observadores de mensajes del ganador del torneo
            this.setChanged();
            this.notifyObservers(ganadores.peekCabeza());
            
            //Ponemos en la ventana de sesion el ganador del torneo
            padre.getTorneo(2).setText("Ganador del torneo: Competidor "+ganador);

            //damos tiempo para la notificacion del ganador del torneo
            dormir(3,-1);

            //notificamos a los observadores para abrir la ventana de seguir
            this.setChanged();
            this.notifyObservers(null);

            //damos tiempo para saber si se ejecutara de nuevo
            dormir(6,-1);
        
            //Cambiar la ultima posicion de cada jugador por la que les corresponde
            for(int i=0;i<lugares.length;i++){
                lugares[i].historialPosiciones.add(i+1);//Agregaamos la posicion en la que quedo el competidor en su historial
                lugares[i].historialPosiciones.eliminaEnPos(0);//quitamos la primera posicion ed su historial
            }
        }
        //quitamos los valores anteriores de las tablas
        for(int i=0;i<8;i++){
            if (tablas[i].getColumnCount()>0) {
                modelos[i].setColumnCount(0);
                modelos[i].setRowCount(0);
            }
        }
        for(int i=0;i<4;i++){
            padre.getCarrera(i+1).setText("");
        }
        padre.getTorneo(1).setText("");
        padre.getTorneo(2).setText("");
    }//FIN DE RUN
    
    //Metodo para llenar el arreglo de modelos de las tablas
    private void hacerModelos(){
        for(int i=0;i<8;i++){
            DefaultTableModel modelo =new DefaultTableModel();
            modelos[i]=modelo;
        }
    }//FIN DE HACERMODELOS
    
    //Metodo para poner el encabezado de las tablas de competidores
    private void setModelo(javax.swing.JTable tabla, int n){
        String[] cabecera={"Jugadores compitiendo"};
        modelos[n-1].setColumnIdentifiers(cabecera);
        tabla.setModel(modelos[n-1]);
    }//FIN DE SETMODELO
    
    //Metodo para poner el encabezado de las otras tabals
    private void setModelo2(javax.swing.JTable tabla, int n){
        String[] cabecera=new String[1];
        if(n==6){
            cabecera[0]="Lugares 7-16";
        }else if(n==8){
            cabecera[0]="Lugares 1-6";
        }else{
            cabecera[0]="Primeros lugares";
        }
        
        modelos[n-1].setColumnIdentifiers(cabecera);
        tabla.setModel(modelos[n-1]);
    }//FIN DE SETMODELO2
    
    //Metodo para poner los datos en las tablas
    private void setDatos(Lista<Candidato> competidores, javax.swing.JTable tabla, int n){
        Iterator<Candidato> it=competidores.iterator();
        for(int i=0;i<competidores.size();i++){
            Integer[] arr=new Integer[1];
            arr[0]=it.next().num;
            modelos[n-1].addRow(arr);
            tabla.setModel(modelos[n-1]);
        }
    }//FIN DE SETDATOS
    
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
    
    /**
     * Metodo para dormir el hilo poniendo un contador
     * @param segundos el numero de segundos a dormir
     * @param tabla el numero de tabla menos 1
     */
    private void dormir(int segundos, int tabla){
        for(int i=segundos;i>0;i--){
            try{
                Thread.sleep(1000);//Tiempo para apostar por la primera carrera
                if(tabla!=-1){
                    tiempos[tabla].setText(""+(i-1));
                }
            }catch(InterruptedException e){
                System.out.println("Fallo al dormir el hilo");
            }
        }
        if(tabla!=-1){
            tiempos[tabla].setText("");
        }
    }
    
    
    
    
    //metodo para obtener a los competidores de los primeros lugares
    //competidores lista de competidores de la cual obtendremos a los primeros lugares
    //n el numero de primeros lugares que queremos
    private Lista<Candidato> pasantes(Lista<Candidato> competidores, int n){
        Lista<Candidato> regreso=new Lista<>();
        //System.out.println("Tamaño: "+competidores.size());
        for(int i=0;i<n;i++){
            //Hacemos el dado con base en la probabilidad de ganar de cada jugador
            Lista<Candidato> dado=Dado(competidores);
            Candidato g=escogerGanador(dado);
            regreso.add(g);
            competidores.delete(g);
        }
        //System.out.println(competidores);
        return regreso;
    }//FIN DE PASANTES
    
    //Metodo para escoger al ganador dada una lista
    private Candidato escogerGanador(Lista<Candidato> dado){
        //lanzamos el dado
        dado.shuffle();
        //escogemos al ganador
        Random random=new Random();
        int n=random.nextInt(dado.size()-1);
        Candidato ganador=dado.elementoEnPos(n);
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
        dado.shuffle();
        return dado;
    }// FIN DE DADO
}
