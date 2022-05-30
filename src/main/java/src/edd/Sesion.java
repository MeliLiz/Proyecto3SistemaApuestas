
package src.edd;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JLabel;


/**
 *
 * Clase de la ventana de la sesion del usuario
 */
public class Sesion extends javax.swing.JFrame {
    
    static Jugador jugador;
    static Cuenta cuenta;
    static Juego juego;

    /**
     * Creates new form Sesion
     * @param jugador
     * @param juego
     */
    public Sesion(Jugador jugador, Juego juego) {
        initComponents();
        this.jugador=jugador;
        this.cuenta=jugador.cuenta;
        Nombre.setText(jugador.nombreUsuario);
        this.juego=juego;
        this.setLocationRelativeTo(null);
    }

    /**
     * Inicializar ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        btnApostar = new javax.swing.JButton();
        Nombre = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        btnSaldo = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        btnGanadasPerdidas = new javax.swing.JButton();
        btnDepRet = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        Torneo = new javax.swing.JLabel();
        carrera1 = new javax.swing.JLabel();
        carrera3 = new javax.swing.JLabel();
        carrera4 = new javax.swing.JLabel();
        carrera2 = new javax.swing.JLabel();
        ganadorTorneo = new javax.swing.JLabel();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenid@ a tu sesión");

        btnApostar.setText("Comenzar a apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        Nombre.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        Nombre.setText("Nombre");

        jInternalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajustes de cuenta"));
        jInternalFrame1.setVisible(true);

        btnSaldo.setText("Saldo");
        btnSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoActionPerformed(evt);
            }
        });

        btnMovimientos.setText("Historial de movimientos");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        btnGanadasPerdidas.setText("Historial de ganadas y perdidas");
        btnGanadasPerdidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanadasPerdidasActionPerformed(evt);
            }
        });

        btnDepRet.setText("Depositar / Retirar");
        btnDepRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepRetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGanadasPerdidas)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(btnSaldo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDepRet))))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnMovimientos)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaldo)
                    .addComponent(btnDepRet))
                .addGap(29, 29, 29)
                .addComponent(btnGanadasPerdidas)
                .addGap(26, 26, 26)
                .addComponent(btnMovimientos)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jInternalFrame2.setVisible(true);

        Torneo.setText("jLabel2");

        carrera1.setText("Carrera 1");

        carrera3.setText("jLabel2");

        carrera4.setText("jLabel2");

        carrera2.setText("jLabel2");

        ganadorTorneo.setText("jLabel2");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ganadorTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carrera2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carrera4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carrera3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carrera1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Torneo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Torneo)
                .addGap(24, 24, 24)
                .addComponent(carrera1)
                .addGap(50, 50, 50)
                .addComponent(carrera2)
                .addGap(47, 47, 47)
                .addComponent(carrera3)
                .addGap(52, 52, 52)
                .addComponent(carrera4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(ganadorTorneo)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btnApostar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nombre)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nombre))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnApostar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo de acciones del boton Apostar
     * @param evt 
     */
    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        
        
        //Ponemos valores del jugador en 0
        jugador.numJugadorApostado=0;
        jugador.cantidadApostada=0;
        jugador.cuotaAp=0;

        //Se abre la ventana de apuestas para el torneo. Una vez que el cronometro termina, la ventana se cierra y se abre la ventana para apostar carreras

        //Observadores
        //HiloVentanaApuestaTorneo hilo1=new HiloVentanaApuestaTorneo(jugador, juego);//hilo para mostrar la ventana de apuestas del torneo
        ControlVApTorneo apTorneo=new ControlVApTorneo(jugador, juego);
        HiloInicio hilo2=new HiloInicio(juego, jugador, this);//hilo del torneo y las carreras
        ObservadorCarrera observadorHilo2=new ObservadorCarrera(jugador);//hilo para saber el momento para abrir la ventana de carreras y cerrarla
        ObservadorResultadoCarrera observadorResultadoC = new ObservadorResultadoCarrera(jugador);
        ObservadorResultadoTorneo obt=new ObservadorResultadoTorneo(jugador);
        ControlVentSeguir controlSeguir=new ControlVentSeguir(hilo2);

        //Observable
        //Cronometro cronometro=new Cronometro(20000);

        //Hacemos observadores en hilo 1 e hilo 2
        //cronometro.addObserver(hilo1);//para saber cuando cerrar la ventana de apuesta del torneo
        //cronometro.addObserver(hilo2);//para saber cuando iniciar el torneo
        hilo2.addObserver(observadorHilo2);
        hilo2.addObserver(observadorResultadoC);
        hilo2.addObserver(obt);
        hilo2.addObserver(controlSeguir);
        hilo2.addObserver(apTorneo);

        //hilo1.start();
        //hilo2.start();
        //cronometro.start();
        hilo2.start();
        
    }//GEN-LAST:event_btnApostarActionPerformed

    /**
     * Metodo de acciones del boton Movimientos de la Cuenta
     * @param evt 
     */
    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        //Abrimos la ventana de movimientos de cuenta
        MovimientosCuenta mov=new MovimientosCuenta(jugador);
        mov.setVisible(true);
    }//GEN-LAST:event_btnMovimientosActionPerformed

    /**
     * Metodo de acciones del boton Saldo
     * @param evt 
     */
    private void btnSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoActionPerformed
        //Mostrar mensaje con el saldo
        DecimalFormat df =  new DecimalFormat("#.##");
        JOptionPane.showMessageDialog(null,"Tu saldo actual es de "+df.format(cuenta.consultarSaldo()));
    }//GEN-LAST:event_btnSaldoActionPerformed

    /**
     * Metodo de acciones del boton Depositar/ Retirar
     * @param evt 
     */
    private void btnDepRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepRetActionPerformed
        //Abrir ventana para depositar o retirar
        DepositarRetirar a=new DepositarRetirar(jugador);
        a.setVisible(true);
    }//GEN-LAST:event_btnDepRetActionPerformed

    /**
     * Metodo del boton Historial de ganadas/perdidas
     * @param evt 
     */
    private void btnGanadasPerdidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanadasPerdidasActionPerformed
        //Abrimos ventana para mostrar el historial de ganadas y perdidas
        GanadasPerdidas hist=new GanadasPerdidas(jugador);
        hist.setVisible(true);
    }//GEN-LAST:event_btnGanadasPerdidasActionPerformed

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
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Crear y mostrar ventana
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sesion(jugador, juego).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Torneo;
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnDepRet;
    private javax.swing.JButton btnGanadasPerdidas;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnSaldo;
    private javax.swing.JLabel carrera1;
    private javax.swing.JLabel carrera2;
    private javax.swing.JLabel carrera3;
    private javax.swing.JLabel carrera4;
    private javax.swing.JLabel ganadorTorneo;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables

    public JLabel getTorneo(int n){
        if(n==1){
            return Torneo;
        }else{
            return ganadorTorneo;
        }
    }
    
    public JLabel getCarrera(int n){
        switch(n){
            case 1: return carrera1;
            case 2: return carrera2;
            case 3: return carrera3;
            case 4: return carrera4;
            default: return null;
        }
    }



}
