package u23238340.proyect.contact.book.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import u23238340.proyect.contact.book.dao.UsuarioDAO;
import u23238340.proyect.contact.book.exception.CredencialesIncorrectasException;
import u23238340.proyect.contact.book.model.Usuario;
import java.util.prefs.Preferences;

public class Login extends javax.swing.JFrame {

    private Usuario usuarioLogueado;
    private Preferences prefs;

    public Login() {
        initComponents();
        transparenciabtn();

        ImageIcon originalIcon = (ImageIcon) jLabel1.getIcon();
        Image scaledImage = originalIcon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(scaledImage));

        txtUsuario.setBackground(new java.awt.Color(0, 0, 0, 1));
        password.setBackground(new java.awt.Color(0, 0, 0, 1));

        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);

        txtUsuario.addActionListener(new ActionListener() { //focus
            @Override
            public void actionPerformed(ActionEvent e) {
                password.requestFocusInWindow();
            }
        });
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresar.doClick();
            }
        });

        prefs = Preferences.userRoot().node(this.getClass().getName());
        String savedUsername = prefs.get("username", "");
        String savedPassword = prefs.get("password", "");
        boolean rememberMe = prefs.getBoolean("rememberMe", false);

        txtUsuario.setText(savedUsername);
        password.setText(savedPassword);
        CheckBoxRecordar.setSelected(rememberMe);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JToggleButton();
        btnRegistrar = new javax.swing.JToggleButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        invisible = new javax.swing.JLabel();
        ver = new javax.swing.JLabel();
        CheckBoxRecordar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 154, 233));
        jPanel1.setForeground(new java.awt.Color(0, 156, 184));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 236, 35));

        password.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 236, 35));

        btnIngresar.setBackground(new java.awt.Color(0, 42, 48));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/enter.png"))); // NOI18N
        btnIngresar.setBorder(null);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 64, 64));

        btnRegistrar.setBackground(new java.awt.Color(0, 42, 48));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/register.png"))); // NOI18N
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 64, 64));

        jLabelTitulo.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("INICIAR SESION");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 380, -1));

        jLabelUsuario.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario :");
        jPanel1.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("____________________________________");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 290, 39));

        jLabelPassword.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Contraseña :");
        jPanel1.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("____________________________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 290, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_user_20px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 40, 40));

        invisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_invisible_20px_1.png"))); // NOI18N
        invisible.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invisibleMouseClicked(evt);
            }
        });
        jPanel1.add(invisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 40, 40));

        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_eye_20px_1.png"))); // NOI18N
        ver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMouseClicked(evt);
            }
        });
        jPanel1.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 40, 40));

        CheckBoxRecordar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CheckBoxRecordar.setForeground(new java.awt.Color(199, 226, 255));
        CheckBoxRecordar.setText("Recordar Contraseña");
        jPanel1.add(CheckBoxRecordar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 280, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
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
                new Login().setVisible(true);
            }
        });
    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usuarioIngresado = txtUsuario.getText();
        String contraseniaIngresada = new String(password.getPassword());

        if (usuarioIngresado.isEmpty() && contraseniaIngresada.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese usuario y contraseña.");
        } else if (usuarioIngresado.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese usuario.");
        } else if (contraseniaIngresada.isEmpty()) {
            mostrarMensajeError("Por favor, ingrese contraseña.");
        } else {
            try {
                usuarioLogueado = validarCredenciales(usuarioIngresado, contraseniaIngresada);
                mostrarVentanaPrincipal();
                dispose();

                if (CheckBoxRecordar.isSelected()) {
                    prefs.put("username", usuarioIngresado);
                    prefs.put("password", contraseniaIngresada);
                    prefs.putBoolean("rememberMe", true);
                } else {
                    prefs.remove("username");
                    prefs.remove("password");
                    prefs.putBoolean("rememberMe", false);
                }
            } catch (CredencialesIncorrectasException ex) {
                mostrarMensajeError("Usuario o contraseña incorrectos. Por favor, inténtalo de nuevo.");
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        RegistrarUsuario registrar = new RegistrarUsuario();
        registrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void invisibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invisibleMouseClicked
        password.setEchoChar((char) 0);
        invisible.setVisible(false);
        invisible.setEnabled(false);
        ver.setEnabled(true);
        ver.setEnabled(true);
    }//GEN-LAST:event_invisibleMouseClicked

    private void verMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMouseClicked
        password.setEchoChar((char) 8226);
        invisible.setVisible(true);
        invisible.setEnabled(true);
        ver.setEnabled(false);
        ver.setEnabled(false);
    }//GEN-LAST:event_verMouseClicked

    private Usuario validarCredenciales(String usuario, String contrasenia) throws CredencialesIncorrectasException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioEncontrado = usuarioDAO.obtenerUsuarioPorNombre(usuario);

        if (usuarioEncontrado == null || !usuarioEncontrado.getContrasena().equals(contrasenia)) {
            throw new CredencialesIncorrectasException("Usuario o contraseña incorrectos. Por favor, inténtalo de nuevo.");
        }

        return usuarioEncontrado;
    }

    private void mostrarVentanaPrincipal() {
        Principal principal = new Principal(usuarioLogueado);
        principal.setVisible(true);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void transparenciabtn() {
        btnIngresar.setOpaque(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setBorderPainted(false);
        btnRegistrar.setOpaque(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setBorderPainted(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxRecordar;
    private javax.swing.JToggleButton btnIngresar;
    private javax.swing.JToggleButton btnRegistrar;
    private javax.swing.JLabel invisible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel ver;
    // End of variables declaration//GEN-END:variables
}
