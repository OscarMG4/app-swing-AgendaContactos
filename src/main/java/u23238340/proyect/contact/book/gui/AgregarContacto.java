package u23238340.proyect.contact.book.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import u23238340.proyect.contact.book.dao.ContactoDAO;
import u23238340.proyect.contact.book.model.Contacto;
import u23238340.proyect.contact.book.model.Usuario;

public class AgregarContacto extends javax.swing.JFrame {

    private Usuario usuario;
    private ContactoDAO contactoDAO;

    public AgregarContacto(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.getContentPane().setBackground(new Color(0x00, 0x9C, 0xB8));
        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);
        contactoDAO = new ContactoDAO();

        JTNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume(); //no es una letra o espacio en blanco
                }
            }
        });

        JTNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); //no es un dígito
                }
            }
        });

        JTCorreo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '_' && c != '-' && c != '+' && c != '%') {
                    e.consume(); //si el carácter no es válido
                }
            }
        });

        JTNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTNumero.requestFocus(); //focus
                }
            }
        });

        JTNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTCorreo.requestFocus();
                }
            }
        });

        JTCorreo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTDireccion.requestFocus();
                }
            }
        });

        JTDireccion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTCumpleanios.requestFocus();
                }
            }
        });

        jTCumpleanios.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTNota.requestFocus();
                }
            }
        });

        JTNota.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnGuardar.requestFocus();
                }
            }
        });

        btnGuardar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnGuardar.doClick(); // Simula un clic en el botón "Guardar"
                }
            }
        });

    }

    private AgregarContacto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelCumple = new javax.swing.JLabel();
        jLabelNota = new javax.swing.JLabel();
        JTNombre = new javax.swing.JTextField();
        JTNumero = new javax.swing.JTextField();
        JTDireccion = new javax.swing.JTextField();
        JTCorreo = new javax.swing.JTextField();
        JTNota = new javax.swing.JTextField();
        jTCumpleanios = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 156, 184));
        setForeground(new java.awt.Color(0, 156, 184));
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Añadir Contacto");

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número:");

        jLabelCorreo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setText("Correo:");

        jLabelDireccion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDireccion.setText("Dirección:");

        jLabelCumple.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelCumple.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCumple.setText("Cumpleaños:");

        jLabelNota.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelNota.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNota.setText("Nota:");

        btnGuardar.setBackground(new java.awt.Color(0, 42, 48));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 42, 48));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombre)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelNumero)
                                        .addComponent(jLabelCorreo))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelNota)
                                    .addComponent(jLabelCumple)
                                    .addComponent(jLabelDireccion))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTNota, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCumpleanios, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabelTitulo)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(JTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(JTNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCorreo)
                    .addComponent(JTCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(JTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCumple)
                    .addComponent(jTCumpleanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTNota, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Realmente desea cancelar el guardado?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            limpiar();
            //temporizador
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Principal principal = new Principal(usuario);
                    principal.setVisible(true);
                    dispose();
                }
            });

            timer.setRepeats(false);
            timer.start();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void limpiar() {
        JTNombre.setText("");
        JTNumero.setText("");
        JTCorreo.setText("");
        JTDireccion.setText("");
        jTCumpleanios.setText("");
        JTNota.setText("");
    }

    private boolean validarCorreo(String correo) {
        return correo.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!validarCampos()) {
            return;
        }

        java.sql.Date cumpleaniosDate = null;
        try {
            cumpleaniosDate = new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(jTCumpleanios.getText()).getTime());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Por favor, use el formato dd-MM-yyyy.");
            return;
        }

        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setNombre(JTNombre.getText());
        nuevoContacto.setEmail(JTCorreo.getText());
        nuevoContacto.setCumpleanios(cumpleaniosDate);
        nuevoContacto.setNota(JTNota.getText());
        nuevoContacto.setDireccion(JTDireccion.getText());
        nuevoContacto.setIdUsuario(usuario.getIdUsuario());

        contactoDAO.insertarContacto(nuevoContacto, JTDireccion.getText(), "", "", JTNumero.getText(), "");

        JOptionPane.showMessageDialog(this, "Contacto guardado exitosamente en la base de datos.");
        limpiar();

        new Principal(usuario).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private boolean validarCampos() {
        StringBuilder mensaje = new StringBuilder("Por favor, complete los siguientes campos:\n");
        boolean camposVacios = false;

        if (JTNombre.getText().isEmpty()) {
            mensaje.append("- Nombre válido (solo letras)\n");
            camposVacios = true;
        }
        if (JTNumero.getText().isEmpty()) {
            mensaje.append("- Número válido (solo números)\n");
            camposVacios = true;
        }
        if (JTCorreo.getText().isEmpty() || !validarCorreo(JTCorreo.getText())) {
            mensaje.append("- Correo válido\n");
            camposVacios = true;
        }

        if (camposVacios) {
            JOptionPane.showMessageDialog(this, mensaje.toString(), "Campos obligatorios vacíos", JOptionPane.WARNING_MESSAGE);
        }

        return !camposVacios;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarContacto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTCorreo;
    private javax.swing.JTextField JTDireccion;
    private javax.swing.JTextField JTNombre;
    private javax.swing.JTextField JTNota;
    private javax.swing.JTextField JTNumero;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelCumple;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNota;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTCumpleanios;
    // End of variables declaration//GEN-END:variables
}
