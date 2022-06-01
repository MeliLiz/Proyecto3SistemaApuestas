
package src.edd;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 *Clase para hacer depositos y retiros de la cuenta
 * @see Cuenta
 */
public class DepositarRetirar extends javax.swing.JFrame {
    static Jugador jugador;//el jugador con el que estamos trabajando
    static Cuenta cuenta;//el juego con el que estamos trabajando
    
    /**
     * Constructor
     */
    public DepositarRetirar(Jugador jugador) {
        initComponents();
        this.jugador=jugador;
        this.cuenta=jugador.cuenta;
        DecimalFormat df =  new DecimalFormat("#.##");
        Saldo.setText("$ "+String.valueOf(df.format(cuenta.consultarSaldo())));
        this.setResizable(false);
    }//FIN DEL CONSTRUCTOR

    /**
     * Inicializar ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        OpcionSel = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Saldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 191, 155));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Depositar / Retirar");

        OpcionSel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Depositar", "Retirar" }));
        OpcionSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionSelActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingresa la cantidad: ");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Saldo actual:");

        Saldo.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(OpcionSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(44, 44, 44)
                                .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Saldo))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saldo))
                .addGap(18, 18, 18)
                .addComponent(OpcionSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo de la seleccion de opcion
     * @param evt 
     */
    private void OpcionSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionSelActionPerformed
        //No hacemos nada
    }//GEN-LAST:event_OpcionSelActionPerformed
     //FIN DE OPCIONSELACTIONPERFORMED
    
    /**
     * Metodo de acciones del boton Aceptar
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String c=Cantidad.getText().trim();//leemos lo ingresado en el text field
        try{
            double n=Double.parseDouble(c);//convertimos lo ingresado a un numero entero
            int opcion=OpcionSel.getSelectedIndex()+1;//obtenemos el indice de seleccion del usuario (Depositar 1, Retirar 2)
            if(opcion==2){//Opcion retirar
                if(!cuenta.retirar(n)){//tratar de retirar de la cuenta
                    JOptionPane.showMessageDialog(null,"No se puede retirar dicha cantidad");//si no se puede mandamos mensaje
                }else{//si el retiro se hace exitosamente
                    JOptionPane.showMessageDialog(null,"Retiro exitoso");//Mensaje de exito
                    this.dispose();//cerramos la ventana
                }
            }else{//Opcion depositar
                if(!cuenta.depositar(n)){//Si no se pudo depositar
                    JOptionPane.showMessageDialog(null,"No se puede depositar dicha cantidad");//Mandamos mensaje de error
                }else{//se pudo depositar
                    JOptionPane.showMessageDialog(null,"Deposito exitoso");//Mensaje de exito
                    this.dispose();//cerramos la ventana
                }
            }
        }catch(Exception e){//Si no se ingreso un numero entero
            JOptionPane.showMessageDialog(null,"No ingresaste un numero");//mensaje de error
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
     //FIN DE JBUTTONACTIONPERFORMED
    
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
            java.util.logging.Logger.getLogger(DepositarRetirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepositarRetirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepositarRetirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepositarRetirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepositarRetirar(jugador).setVisible(true);
            }
        });
    }//FIN DEL MAIN

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad;
    private javax.swing.JComboBox<String> OpcionSel;
    private javax.swing.JLabel Saldo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables



}
