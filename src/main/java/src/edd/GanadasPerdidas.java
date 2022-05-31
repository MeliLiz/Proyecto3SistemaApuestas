
package src.edd;

import javax.swing.table.DefaultTableModel;
import java.util.Iterator;

/**
 * Ventana para mostrar las apuestas ganadas y las perdidas
 * @author meli
 */
public class GanadasPerdidas extends javax.swing.JFrame {
    static Jugador jugador;//El jugador con el que estamos trabajando
    Lista<String[]> ganadas;//la lista de ganadas del jugador
    Lista<String[]> perdidas;//la lista de perdidas del jugador
    
    /**
     * Constructor
     */
    public GanadasPerdidas(Jugador jugador) {
        initComponents();
        this.jugador=jugador;
        ganadas=jugador.cuenta.apuestasGanadas;
        perdidas=jugador.cuenta.apuestasPerdidas;
        setModeloGanadas();
        setModeloPerdidas();
        setDatosGanadas();
        setDatosPerdidas();
    }//FIN DEL CONSTRUCTOR
    
    //Para cambiar el diseño de la tabla de ganadas y de perdidas
    DefaultTableModel modelo =new DefaultTableModel();
    DefaultTableModel modelo1 =new DefaultTableModel();
    
    //Metodo para poner la cabecera de la tabla de ganadas
    private void setModeloGanadas(){
        String[] cabecera={"Apostado","Ganado","Fecha y Hora"};
        modelo.setColumnIdentifiers(cabecera);
        tablaGanadas.setModel(modelo);
    }
    
    //Metodo para poner la cabecera de la tabla de perdidas
    private void setModeloPerdidas(){
        String[] cabecera={"Perdido","Fecha y Hora"};
        modelo1.setColumnIdentifiers(cabecera);
        tablaPerdidas.setModel(modelo1);
    }
    
    //Metodo para poner los datos tomados de la lista de ganadas en la tabla
    private void setDatosGanadas(){
        Iterator<String[]> it=ganadas.iterator();
        for(int i=0;i<ganadas.size();i++){
            String[] arr=it.next();
            modelo.addRow(arr);
            tablaGanadas.setModel(modelo);
        }
    }
    
    //Metodo para poner los datos de la lista de perdidas en la tabla
    private void setDatosPerdidas(){
        Iterator<String[]> it=perdidas.iterator();
        for(int i=0;i<perdidas.size();i++){
            String[] arr=it.next();
            modelo1.addRow(arr);
            tablaPerdidas.setModel(modelo1);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPerdidas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGanadas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Historial de ganadas");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Historial de perdidas");

        tablaPerdidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaPerdidas);

        tablaGanadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaGanadas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GanadasPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GanadasPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GanadasPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GanadasPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Creamos y mostramos la ventana
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GanadasPerdidas(jugador).setVisible(true);
            }
        });
    }//FIN DEL MAIN

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaGanadas;
    private javax.swing.JTable tablaPerdidas;
    // End of variables declaration//GEN-END:variables
}
