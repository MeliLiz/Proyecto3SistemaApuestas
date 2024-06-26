
package src.edd;
import java.text.DecimalFormat;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

/**
 * Clase de la ventana para apostar en la carrera
 * @author meli
 */
public class ApostarCarrera extends javax.swing.JFrame {

    static Jugador jugador;
    static Lista<Candidato> competidores;
    
    /**
     * Constructor de la ventana
     */
    public ApostarCarrera(Jugador jugador, Lista<Candidato> competidores) {
        initComponents();
        this.jugador=jugador;
        this.competidores=competidores;
        setModelo();
        setDatos();
        DecimalFormat df =  new DecimalFormat("#.##");
        Saldo.setText(""+df.format(jugador.cuenta.consultarSaldo()));
        for(int i=0;i<competidores.size();i++){
            opcion.addItem(""+(i+1));
        }
        this.setResizable(false);
    }
    
    //Para modificar ls tabla
    DefaultTableModel modelo =new DefaultTableModel();
    
    //Metodo para poner el titulo de las secciones de la table
    private void setModelo(){
        String[] cabecera={"identificador","Candidato","Cuota","Historial de Posiciones"};
        modelo.setColumnIdentifiers(cabecera);
        tabla.setModel(modelo);
    }
    
    //Metodo para poner los datos en la tabla
    private void setDatos(){
        //Calculamos la probabilidad y cuota de los candidatos
        Iterator<Candidato> it=competidores.iterator();
        //Suma de habilidades
        int suma=0;
        for(int i=0;i<competidores.size();i++){
            suma+=it.next().habilidad;
        }
        it=competidores.iterator();
        
        //Calculamos la probabilidad de cada jugador y su cuota
        for(int i=0;i<competidores.size();i++){
            Candidato actual=it.next();
            actual.probabilidadCarrera=actual.habilidad/suma;//calculamos probabilidad de ganar la carrera
            actual.cuotaCarrera=1/actual.probabilidadCarrera;//calculamos la cuota decimal
        }
        it=competidores.iterator();
        for(int i=0;i<competidores.size();i++){
            Candidato actual=it.next();
            String[] arr=new String[4];
            arr[0]=""+(i+1);
            arr[1]=""+actual.num;
            DecimalFormat decimalFormat =  new DecimalFormat("#.##");
            arr[2]=""+decimalFormat.format(actual.cuotaCarrera);
            arr[3]=actual.historialPosiciones.toString();
            
            modelo.addRow(arr);
            tabla.setModel(modelo);
        }
        
    }

    /**
     * Metodo para inicializar la ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        opcion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Saldo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Apuesta = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        segundos = new javax.swing.JLabel();
        Saldo2 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Apuesta de la carrera");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla);

        jLabel5.setText("Saldo disponible: ");

        Saldo.setText("Saldo");

        jLabel3.setText("Selecciona el identificador del competidor a apostar");

        jLabel4.setText("Ingresa la cantidad a apostar");

        Apuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApuestaActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel6.setText("La carrera comenzará en");

        segundos.setText("20");

        Saldo2.setText("segundos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(243, 243, 243))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(segundos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Saldo2)
                .addGap(149, 149, 149))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Apuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Saldo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(segundos)
                    .addComponent(Saldo2))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Saldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo de accion del boton aceptar
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //verificar que la cantidad ingresada sea correcta y coincida con el saldo
        String c=Apuesta.getText().trim();
        try{
            double n=Double.parseDouble(c);
            if(!jugador.cuenta.apostar(n)){
                JOptionPane.showMessageDialog(null,"No puedes apostar dicha cantidad. Ingresa una cantidad valida.");
            }else{
                //poner los datos del candidato apostado
                int r=opcion.getSelectedIndex();
                Candidato eleccion=competidores.elementoEnPos(r);
                jugador.cuotaApCarrera=eleccion.cuotaCarrera;
                jugador.numJugadorApostadoCarrera=eleccion.num;
                jugador.cantidadApostadaCarrera=n;
                JOptionPane.showMessageDialog(null,"Apostaste $"+n+" por el jugador "+ jugador.numJugadorApostadoCarrera+".Espera a que inicie la carrera");
                this.dispose();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No ingresaste un numero");
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void ApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApuestaActionPerformed
        
    }//GEN-LAST:event_ApuestaActionPerformed

    /**
     * Metodo principal
     * @param args
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApostarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApostarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApostarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApostarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApostarCarrera(jugador, competidores).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apuesta;
    private javax.swing.JLabel Saldo;
    private javax.swing.JLabel Saldo2;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> opcion;
    private javax.swing.JLabel segundos;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    public JLabel getSegundos(){
        return segundos;
    }

}
