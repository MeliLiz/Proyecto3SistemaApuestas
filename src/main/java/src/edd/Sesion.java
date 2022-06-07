
package src.edd;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;


/**
 *Clase de la ventana de la sesion del usuario
 * @author meli
 */
public class Sesion extends javax.swing.JFrame {
    
    static Jugador jugador;//El jugador con el que trabajaremos
    static Cuenta cuenta;//La cuenta del jugador
    static Juego juego;//El juego con el que estamos trabajando
    static LogIn login;//La ventana de logIn que abre esta ventana

    /**
     * Constructor
     * @param jugador
     * @param juego
     */
    public Sesion(Jugador jugador, Juego juego,LogIn login) {
        initComponents();
        this.jugador=jugador;
        this.cuenta=jugador.cuenta;
        Nombre.setText(jugador.nombreUsuario);
        this.juego=juego;
        this.setLocationRelativeTo(null);
        this.login=login;
        this.setResizable(false);
    }//FIN DE CONSTRUCTOR

    /**
     * Inicializar ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla4 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla6 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabla7 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabla5 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabla8 = new javax.swing.JTable();
        tiempo5 = new javax.swing.JLabel();
        tiempo7 = new javax.swing.JLabel();
        tiempo3 = new javax.swing.JLabel();
        tiempo9 = new javax.swing.JLabel();
        tiempo1 = new javax.swing.JLabel();
        tiempo2 = new javax.swing.JLabel();
        tiempo4 = new javax.swing.JLabel();
        tiempo6 = new javax.swing.JLabel();
        tiempo8 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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

        Torneo.setText(".");

        carrera1.setText("---");

        carrera3.setText("---");

        carrera4.setText("---");

        carrera2.setText("---");

        ganadorTorneo.setText("---");

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla2);

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tabla1);

        tabla4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tabla4);

        tabla6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tabla6);

        tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tabla3);

        tabla7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tabla7);

        tabla5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(tabla5);

        tabla8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(tabla8);

        tiempo5.setText("--");

        tiempo7.setText("--");

        tiempo3.setText("--");

        tiempo9.setText("--");

        tiempo1.setText(".");

        tiempo2.setText("--");

        tiempo4.setText("--");

        tiempo6.setText("--");

        tiempo8.setText("--");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ganadorTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame2Layout.createSequentialGroup()
                                    .addComponent(Torneo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tiempo1)
                                    .addGap(10, 10, 10))
                                .addComponent(carrera4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(carrera3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(carrera2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(carrera1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tiempo2)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tiempo4))
                                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                                    .addGap(199, 199, 199)
                                                    .addComponent(tiempo3))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(tiempo5)
                                                    .addGap(8, 8, 8))))
                                        .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tiempo6)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                                                    .addComponent(tiempo7)
                                                    .addGap(8, 8, 8))))
                                        .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tiempo8)
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                                                    .addComponent(tiempo9)
                                                    .addGap(8, 8, 8))))))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Torneo)
                    .addComponent(tiempo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carrera1)
                    .addComponent(tiempo3)
                    .addComponent(tiempo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carrera2)
                    .addComponent(tiempo5)
                    .addComponent(tiempo4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carrera3)
                    .addComponent(tiempo7)
                    .addComponent(tiempo6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carrera4)
                    .addComponent(tiempo8)
                    .addComponent(tiempo9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ganadorTorneo)
                .addGap(12, 12, 12))
        );

        btnCerrar.setText("Cerrar sesión");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnApostar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnCerrar)))
                        .addGap(18, 18, 18)
                        .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nombre)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnApostar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)
                        .addGap(51, 51, 51))))
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

        //Hacemos observadores 
        hilo2.addObserver(observadorHilo2);
        hilo2.addObserver(observadorResultadoC);
        hilo2.addObserver(obt);
        hilo2.addObserver(controlSeguir);
        hilo2.addObserver(apTorneo);

        hilo2.start();
        
    }//GEN-LAST:event_btnApostarActionPerformed
     //FIN DE BTNAPOSTARACTIONPERFORMED
    
    /**
     * Metodo de acciones del boton Movimientos de la Cuenta
     * @param evt 
     */
    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        //Abrimos la ventana de movimientos de cuenta
        MovimientosCuenta mov=new MovimientosCuenta(jugador);
        mov.setVisible(true);
    }//GEN-LAST:event_btnMovimientosActionPerformed
     //FIN DE BTNMOVIMIENTOSACTIONPERFORMED
    
    /**
     * Metodo de acciones del boton Saldo
     * @param evt 
     */
    private void btnSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoActionPerformed
        //Mostrar mensaje con el saldo
        DecimalFormat df =  new DecimalFormat("#.##");
        JOptionPane.showMessageDialog(null,"Tu saldo actual es de "+df.format(cuenta.consultarSaldo()));
    }//GEN-LAST:event_btnSaldoActionPerformed
     //FIN DE BTNSALDOACTIONPERFORMED
    
    /**
     * Metodo de acciones del boton Depositar/ Retirar
     * @param evt 
     */
    private void btnDepRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepRetActionPerformed
        //Abrir ventana para depositar o retirar
        DepositarRetirar a=new DepositarRetirar(jugador);
        a.setVisible(true);
    }//GEN-LAST:event_btnDepRetActionPerformed
     //FIN DE BTNDEPRETACTIONPERFORMED
    
    /**
     * Metodo del boton Historial de ganadas/perdidas
     * @param evt 
     */
    private void btnGanadasPerdidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanadasPerdidasActionPerformed
        //Abrimos ventana para mostrar el historial de ganadas y perdidas
        GanadasPerdidas hist=new GanadasPerdidas(jugador);
        hist.setVisible(true);
    }//GEN-LAST:event_btnGanadasPerdidasActionPerformed
     //FIN DE BTNGANADASPERDIDASACTIONPERFORMED
    
    //Metodo del boton para salir de la sesion
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        login.setVisible(true);//hacemos visible la ventana de login que abrio esta ventana
        this.dispose();//cerramos esta ventana
    }//GEN-LAST:event_btnCerrarActionPerformed
     //FIN DE BTNCERRARACTIONPERFORMED
    
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
                new Sesion(jugador, juego,login).setVisible(true);
            }
        });
    }//FIN DEL MAIN

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Torneo;
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnCerrar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    private javax.swing.JTable tabla3;
    private javax.swing.JTable tabla4;
    private javax.swing.JTable tabla5;
    private javax.swing.JTable tabla6;
    private javax.swing.JTable tabla7;
    private javax.swing.JTable tabla8;
    private javax.swing.JLabel tiempo1;
    private javax.swing.JLabel tiempo2;
    private javax.swing.JLabel tiempo3;
    private javax.swing.JLabel tiempo4;
    private javax.swing.JLabel tiempo5;
    private javax.swing.JLabel tiempo6;
    private javax.swing.JLabel tiempo7;
    private javax.swing.JLabel tiempo8;
    private javax.swing.JLabel tiempo9;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para obtener las etiquetas del torneo
     * @param n 1 si es la primera etiqueta, 2 si es la etiqueta del ganador
     * @return 
     */
    public javax.swing.JLabel getTorneo(int n){
        if(n==1){
            return Torneo;
        }else{
            return ganadorTorneo;
        }
    }//FIN DE GETTORNEO
    
    /**
     * Metodo para obtener las etiquetas de las carreras
     * @param n El numero de carrera de la etiqueta
     * @return 
     */
    public javax.swing.JLabel getCarrera(int n){
        switch(n){
            case 1: return carrera1;
            case 2: return carrera2;
            case 3: return carrera3;
            case 4: return carrera4;
            default: return null;
        }
    }//FIN DE GETCARRERA

    /**
     * Metodo para obtener las tablas
     * @param n El numero de tabla
     * @return 
     */
    public javax.swing.JTable getTabla(int n){
        switch(n){
            case 1: return tabla1;
            case 2: return tabla2;
            case 3: return tabla3;
            case 4: return tabla4;
            case 5: return tabla5;
            case 6: return tabla6;
            case 7: return tabla7;
            case 8: return tabla8;
            default: return null;
        }
    }//FIN DE GETtABLA

    /**
     * Metodo para obtener las etiquetas del tiempo
     * @param n el numero de etiqueta
     * @return 
     */
    public javax.swing.JLabel getTiempo(int n){
        switch(n){
            case 1:return tiempo1;
            case 2: return tiempo2;
            case 3: return tiempo3;
            case 4: return tiempo4;
            case 5: return tiempo5;
            case 6: return tiempo6;
            case 7: return tiempo7;
            case 8: return tiempo8;
            case 9: return tiempo9;
            default: return null;
        }
    }//FIN DE GETTIEMPO
}
