package u23238340.proyect.contact.book.gui;

import javax.swing.JOptionPane;
import u23238340.proyect.contact.book.model.Usuario;

public class Principal extends javax.swing.JFrame {

    private Usuario usuarioLogueado;

    public Principal(Usuario usuarioLogueado) {
        initComponents();
        transparenciabtn();
        this.usuarioLogueado = usuarioLogueado;
        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);
    }

    private Principal() {  
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnListContac = new javax.swing.JButton();
        btnAniadirContacto = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 154, 233));
        jPanel1.setForeground(new java.awt.Color(0, 156, 184));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnListContac.setBackground(new java.awt.Color(0, 42, 48));
        btnListContac.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnListContac.setForeground(new java.awt.Color(255, 255, 255));
        btnListContac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_user_20px_1.png"))); // NOI18N
        btnListContac.setText("Lista de Contactos");
        btnListContac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListContac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListContacActionPerformed(evt);
            }
        });
        jPanel1.add(btnListContac, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 200, 30));

        btnAniadirContacto.setBackground(new java.awt.Color(0, 42, 48));
        btnAniadirContacto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAniadirContacto.setForeground(new java.awt.Color(255, 255, 255));
        btnAniadirContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/añadir.png"))); // NOI18N
        btnAniadirContacto.setText("Añadir Contacto");
        btnAniadirContacto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAniadirContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirContactoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAniadirContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 190, 30));

        btnCerrarSesion.setBackground(new java.awt.Color(0, 42, 48));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/volver.png"))); // NOI18N
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 32, 32));

        btnReporte.setBackground(new java.awt.Color(0, 42, 48));
        btnReporte.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reporte.png"))); // NOI18N
        btnReporte.setText("Reportes");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 150, 30));

        jLabelTitulo.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("GESTOR DE CONTACTOS");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sms.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 64, 64));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListContacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListContacActionPerformed
        ListaContactos listaContactos = new ListaContactos(usuarioLogueado);
        listaContactos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListContacActionPerformed

    private void btnAniadirContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirContactoActionPerformed
        AgregarContacto agregarContacto = new AgregarContacto(usuarioLogueado);
        agregarContacto.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAniadirContactoActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cerrar sesión?", "Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ReporteDeUsuario reporte = new ReporteDeUsuario(usuarioLogueado);
        reporte.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnReporteActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    public void transparenciabtn(){
        btnCerrarSesion.setOpaque(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setBorderPainted(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirContacto;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnListContac;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
