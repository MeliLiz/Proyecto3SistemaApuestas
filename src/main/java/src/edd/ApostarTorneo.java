
package src.edd;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import static src.edd.MovimientosCuenta.mov;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JLabel;

/**
 * Ventana para apostar en el torneo
 * @author meli
 */
public class ApostarTorneo extends javax.swing.JFrame {

    static Jugador jugador;
    static Juego juego;
    
    /**
     * Constructor de la ventana
     */
    public ApostarTorneo(Jugador jugador, Juego juego) {
        initComponents();
        this.jugador=jugador;
        this.juego=juego;
        setModelo();
        setDatos();
        DecimalFormat df =  new DecimalFormat("#.##");
        Saldo.setText(""+df.format(jugador.cuenta.consultarSaldo()));
        this.setResizable(false);
    }
    
    //Para cambiar el diseño de la tabla
    DefaultTableModel modelo =new DefaultTableModel();
    
    //Metodo para poner el titulo de las secciones de la tabla
    private void setModelo(){
        String[] cabecera={"Candidato","Cuota","Historial de Posiciones"};
        modelo.setColumnIdentifiers(cabecera);
        tablaCompetidores.setModel(modelo);
    }
    
    //Metodo para poner los datos en la tabla
    private void setDatos(){
        //Calculamos la probabilidad y cuota de los candidatos
        Iterator<Candidato> it=juego.candidatos.iterator();
        //Calculamos la probabilidad de cada jugador y su cuota
        for(int i=0;i<juego.candidatos.size();i++){
            Candidato actual=it.next();
            actual.probabilidadTorneo=actual.habilidad/juego.sumaHabilidades;//calculamos probabilidad de ganar la carrera
            actual.cuotaTorneo=1/actual.probabilidadTorneo;//calculamos la cuota decimal
        }
        it=juego.candidatos.iterator();
        
        //Ponemos los datos en un arreglo para agregarlos a la tabla
        for(int i=0;i<juego.candidatos.size();i++){
            Candidato actual=it.next();
            String[] arr=new String[3];
            arr[0]=""+actual.num;
            DecimalFormat decimalFormat =  new DecimalFormat("#.##");
            arr[1]=""+decimalFormat.format(actual.cuotaTorneo);
            arr[2]=actual.historialPosiciones.toString();
            
            modelo.addRow(arr);
            tablaCompetidores.setModel(modelo);
        }
        
    }

    /**
     * Metodo para inicializar la ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Saldo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompetidores = new javax.swing.JTable();
        Seleccion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Apuesta = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        segundos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Apuesta del torneo");

        jLabel2.setText("Saldo disponible: ");

        Saldo.setText("Saldo");

        tablaCompetidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCompetidores);

        Seleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));
        Seleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecciona el competidor a apostar");

        jLabel4.setText("Ingresa la cantidad a apostar");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel5.setText("El torneo comenzará en ");

        jLabel6.setText("segundos");

        segundos.setText("20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Saldo))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(Seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Apuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnAceptar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(segundos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(segundos))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Saldo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(Apuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptar)
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionActionPerformed
        
    }//GEN-LAST:event_SeleccionActionPerformed

    /**
     * Matodo que indica la accion a realizar al presionar el boton Aceptar
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //verificar que la cantidad ingresada sea correcta y coincida con el saldo
        String c=Apuesta.getText().trim();
        try{
            double n=Double.parseDouble(c);
            if(!jugador.cuenta.apostar(n)){
                JOptionPane.showMessageDialog(null,"No puedes apostar dicha cantidad. Ingresa una cantidad valida.");
            }else{
                //poner los datos del candidato apostado
                int opcion=Seleccion.getSelectedIndex()+1;
                Iterator<Candidato> it=juego.candidatos.iterator();
                Candidato actual=it.next();
                while(actual.num!=opcion){
                    actual=it.next();
                }
                jugador.cuotaAp=actual.cuotaTorneo;
                jugador.numJugadorApostado=actual.num;
                jugador.cantidadApostada=n;
                JOptionPane.showMessageDialog(null,"Apostaste $"+n+".Espera a que inicie el torneo");
                this.dispose();
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No ingresaste un numero");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * Metodo principal
     * @param args 
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApostarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApostarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApostarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApostarTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApostarTorneo(jugador, juego).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apuesta;
    private javax.swing.JLabel Saldo;
    private javax.swing.JComboBox<String> Seleccion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel segundos;
    private javax.swing.JTable tablaCompetidores;
    // End of variables declaration//GEN-END:variables

    public JLabel getSegundos(){
        return segundos;
    }

}
