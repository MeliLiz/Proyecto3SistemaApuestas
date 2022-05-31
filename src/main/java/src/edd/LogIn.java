
package src.edd;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;

/**
 *Ventana para crear cuenta o ingresar a la cuenta
 */
public class LogIn extends javax.swing.JFrame {
    
    static Juego juego;//El juego con el que trabajaremos

    /**
     * Constructor de LogIn
     */
    public LogIn(Juego juego) {
        initComponents();
        this.juego=juego;
        this.setLocationRelativeTo(null);
    }

    /**
     * Crear la ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCrearcuenta = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        btnExplicacion = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenid@ al sistema de apuestas");

        btnCrearcuenta.setText("Crear cuenta");
        btnCrearcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearcuentaActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnExplicacion.setText("¿Qué es esto?");
        btnExplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplicacionActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearcuenta)
                    .addComponent(btnIngresar))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExplicacion)
                    .addComponent(salir))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo de acciones del boton Crear cuenta
     * @param evt 
     */
    private void btnCrearcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearcuentaActionPerformed
        //Mostramos la ventana de registro
        Registro ventanaRegistro=new Registro(juego);
        ventanaRegistro.setVisible(true);
    }//GEN-LAST:event_btnCrearcuentaActionPerformed

    /**
     * Metodo de acciones del boton Que es esto?
     * @param evt 
     */
    private void btnExplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExplicacionActionPerformed
        //Abrir la ventana de instrucciones 
        Instrucciones ins=new Instrucciones();
         ins.setVisible(true);
    }//GEN-LAST:event_btnExplicacionActionPerformed

    /**
     * Metodo de acciones del boton Ingresar
     * @param evt 
     */
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //Abrir la ventana de ingresar
        Ingresar ingresar=new Ingresar(juego,this);
        ingresar.setVisible(true);
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        ObjectOutputStream escritor=null;
        try{
            escritor=new ObjectOutputStream(new FileOutputStream("archivo.obj"));
            escritor.writeObject(juego);
        }catch(NotSerializableException e){
            System.out.println("Error en la grabación: "+e+". Objeto no serializable");
        }catch(IOException e){
            System.out.println("Error en la grabación: "+e);
        }finally{
            if(escritor!=null){
                System.out.println("Cerrando el archivo");
                try{
                    escritor.close();
                }catch(IOException e){}
            }else{
                System.out.println("No se abrió ningún archivo");
            }
        }
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Crear y mostrar la ventana */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn(juego).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearcuenta;
    private javax.swing.JButton btnExplicacion;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
