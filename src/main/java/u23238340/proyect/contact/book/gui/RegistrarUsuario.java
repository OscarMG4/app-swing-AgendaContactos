package u23238340.proyect.contact.book.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import u23238340.proyect.contact.book.dao.UsuarioDAO;
import u23238340.proyect.contact.book.model.Usuario;

public class RegistrarUsuario extends javax.swing.JFrame {

    public RegistrarUsuario() {
        initComponents();
        transparenciabtn();
        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);
        
        ImageIcon originalIcon = (ImageIcon) jLabel1.getIcon();
        Image scaledImage = originalIcon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(scaledImage));
        
        txtUsuario.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtPass.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtPass2.setBackground(new java.awt.Color(0, 0, 0, 1));

        txtUsuario.addActionListener(new ActionListener() { //focus
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPass.requestFocusInWindow();
            }
        });

        txtPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPass2.requestFocusInWindow();
            }
        });

        txtPass2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresar.doClick();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JToggleButton();
        txtPass = new javax.swing.JTextField();
        txtPass2 = new javax.swing.JTextField();
        txtCancelar = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelPassword1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 154, 233));
        jPanel1.setForeground(new java.awt.Color(0, 156, 184));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 290, 35));

        btnIngresar.setBackground(new java.awt.Color(0, 42, 48));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/enter.png"))); // NOI18N
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 64, 64));

        txtPass.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(null);
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 290, 35));

        txtPass2.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        txtPass2.setForeground(new java.awt.Color(255, 255, 255));
        txtPass2.setBorder(null);
        jPanel1.add(txtPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 290, 35));

        txtCancelar.setBackground(new java.awt.Color(0, 42, 48));
        txtCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCancelar.setForeground(new java.awt.Color(255, 255, 255));
        txtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/volver.png"))); // NOI18N
        txtCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(txtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 32, 32));

        jLabelUsuario.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("USUARIO:");
        jPanel1.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 85, 16));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("____________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 290, 39));

        jLabelPassword.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("CONTRASEÑA:");
        jPanel1.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("____________________________________");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 290, 39));

        jLabelPassword1.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        jLabelPassword1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword1.setText("REPITA SU CONTRASEÑA:");
        jPanel1.add(jLabelPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("____________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 290, 39));

        jLabelTitulo.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Registrar Usuario");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 320, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUsuario().setVisible(true);
            }
        });
    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usuarioIngresado = txtUsuario.getText();
        String contraseniaIngresada = txtPass.getText();
        String contraseniaConfirmada = txtPass2.getText();

        if (usuarioIngresado.isEmpty() && contraseniaIngresada.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese usuario y contraseña.");
        } else if (usuarioIngresado.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese usuario.");
        } else if (contraseniaIngresada.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese contraseña.");
        } else if (!contraseniaIngresada.equals(contraseniaConfirmada)) {
            mostrarMensajeError("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
        } else {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombreUsuario(usuarioIngresado);
            nuevoUsuario.setContrasena(contraseniaIngresada);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean registroExitoso = usuarioDAO.agregarUsuario(nuevoUsuario);

            if (registroExitoso) {
                JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtUsuario.setText("");
                txtPass.setText("");
                txtPass2.setText("");
                mostrarVentanaPrincipal();
                dispose();
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancelarActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_txtCancelarActionPerformed

    private void mostrarVentanaPrincipal() {
        Login login = new Login();
        login.setVisible(true);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void transparenciabtn(){
        btnIngresar.setOpaque(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setBorderPainted(false);
        txtCancelar.setOpaque(false);
        txtCancelar.setContentAreaFilled(false);
        txtCancelar.setBorderPainted(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton txtCancelar;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtPass2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
