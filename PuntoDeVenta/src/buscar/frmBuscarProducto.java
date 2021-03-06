/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FIMAZ
 */
public class frmBuscarProducto extends javax.swing.JFrame {
    
    Connection conexion;
    JTextField txtIdProducto;
    /**
     * Creates new form frmBuscarProducto
     */
    public frmBuscarProducto() {
        initComponents();
        inicializaBaseDeDatos();
        llenaTablaUsuarios();
    }

    public frmBuscarProducto(JTextField txtIdProducto) {
        initComponents();
        inicializaBaseDeDatos();
        llenaTablaUsuarios();
        this.txtIdProducto=txtIdProducto;
    }
    
    public void inicializaBaseDeDatos(){
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conexion = DriverManager.
                    getConnection("jdbc:mysql://"
                    + "localhost/punto_venta","root","");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
        
    public void llenaTablaUsuarios(){
        try{            
            DefaultTableModel model = new DefaultTableModel();
            tablaProductos.setModel(model);
            
            PreparedStatement consulta = conexion.prepareStatement(""
                    + "SELECT id_producto, descripcion "
                    + " FROM productos WHERE status=1");                  
            ResultSet rs = consulta.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();            
            for(int i = 1; i <= cantidadColumnas; i++){
                model.addColumn(rsMd.getColumnLabel(i));
            }
            
            
            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for(int j=1; j <= cantidadColumnas; j++){
                    fila[j-1] = rs.getObject(j);
                }                
                
                model.addRow(fila);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
                    
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionar)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        try{
            DefaultTableModel model = new DefaultTableModel();
            tablaProductos.setModel(model);

            /*
            PreparedStatement consulta = conexion.prepareStatement(""
                + "SELECT * FROM usuarios WHERE status=1 AND nombre LIKE ?");
            consulta.setString( 1, "%"+txtBuscar.getText()+"%");
            */
            PreparedStatement consulta = conexion.prepareStatement(""
                + "SELECT id_producto, descripcion FROM productos WHERE status=1 AND descripcion LIKE ?");
            consulta.setString( 1,"'"+txtBuscar.getText()+"'");
            ResultSet rs = consulta.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for(int i = 1; i <= cantidadColumnas; i++){
                model.addColumn(rsMd.getColumnLabel(i));
            }

            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for(int j=1; j <= cantidadColumnas; j++){
                    fila[j-1] = rs.getObject(j);
                }

                model.addRow(fila);
            }

        }catch(Exception e){
            e.printStackTrace();

        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int id = (int) tablaProductos.getValueAt(tablaProductos.getSelectedRow() , 0);
        txtIdProducto.setText(""+id);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscarProducto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
