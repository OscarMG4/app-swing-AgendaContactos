package u23238340.proyect.contact.book.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import u23238340.proyect.contact.book.dao.ContactoDAO;
import u23238340.proyect.contact.book.model.Contacto;
import u23238340.proyect.contact.book.model.Usuario;

public class EditarContacto extends javax.swing.JFrame {

    private Contacto contacto;
    private Usuario usuario;
    private ContactoDAO contactoDAO;

    public EditarContacto(Contacto contacto, Usuario usuario) {
        this.contacto = contacto;
        this.usuario = usuario;
        this.contactoDAO = new ContactoDAO();
        initComponents();
        configurarComponentes();
        llenarDatosContacto();
        configurarEventos();
    }

    private void configurarComponentes() {
        transparenciabtn();
        
        JTCorreo.setBackground(new java.awt.Color(0, 0, 0, 1));
        JTDireccion.setBackground(new java.awt.Color(0, 0, 0, 1));
        JTNombre.setBackground(new java.awt.Color(0, 0, 0, 1));
        JTNota.setBackground(new java.awt.Color(0, 0, 0, 1));
        JTNumero.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTCumpleanios.setBackground(new java.awt.Color(0, 0, 0, 1));
        
        ImageIcon originalIcon = (ImageIcon) jLabel1.getIcon();
        Image scaledImage = originalIcon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(scaledImage));
        
        this.getContentPane().setBackground(new Color(0x00, 0x9C, 0xB8));
        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);
    }

    private void llenarDatosContacto() {
        JTNombre.setText(contacto.getNombre());
        JTNumero.setText(contacto.getTelefonos());
        JTCorreo.setText(contacto.getEmail());
        JTDireccion.setText(contacto.getDireccion());
        jTCumpleanios.setText(contacto.getCumpleanios().toString());
        JTNota.setText(contacto.getNota());
    }

    private void configurarEventos() {
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

    EditarContacto(Contacto contactoSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTNombre = new javax.swing.JTextField();
        JTNumero = new javax.swing.JTextField();
        JTDireccion = new javax.swing.JTextField();
        JTCorreo = new javax.swing.JTextField();
        JTNota = new javax.swing.JTextField();
        jTCumpleanios = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelCumple = new javax.swing.JLabel();
        jLabelNota = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 154, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTNombre.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        JTNombre.setForeground(new java.awt.Color(255, 255, 255));
        JTNombre.setBorder(null);
        jPanel1.add(JTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 235, 30));

        JTNumero.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        JTNumero.setForeground(new java.awt.Color(255, 255, 255));
        JTNumero.setBorder(null);
        jPanel1.add(JTNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 235, 30));

        JTDireccion.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        JTDireccion.setForeground(new java.awt.Color(255, 255, 255));
        JTDireccion.setBorder(null);
        jPanel1.add(JTDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 235, 30));

        JTCorreo.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        JTCorreo.setForeground(new java.awt.Color(255, 255, 255));
        JTCorreo.setBorder(null);
        jPanel1.add(JTCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 235, 30));

        JTNota.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        JTNota.setForeground(new java.awt.Color(255, 255, 255));
        JTNota.setBorder(null);
        jPanel1.add(JTNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 235, 30));

        jTCumpleanios.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jTCumpleanios.setForeground(new java.awt.Color(255, 255, 255));
        jTCumpleanios.setBorder(null);
        jTCumpleanios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCumpleaniosActionPerformed(evt);
            }
        });
        jPanel1.add(jTCumpleanios, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 235, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 42, 48));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 42, 48));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/volver.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 32, 32));

        jLabelNombre.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabelNumero.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número:");
        jPanel1.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabelCorreo.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setText("Correo:");
        jPanel1.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabelDireccion.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDireccion.setText("Dirección:");
        jPanel1.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabelCumple.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelCumple.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCumple.setText("Cumpleaños:");
        jPanel1.add(jLabelCumple, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 30));

        jLabelNota.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelNota.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNota.setText("Nota:");
        jPanel1.add(jLabelNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("____________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 290, 39));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("____________________________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 290, 39));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("____________________________________");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 290, 39));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("____________________________________");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 290, 39));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("____________________________________");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 290, 39));

        jLabelTitulo.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Editar Contacto");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 230, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("____________________________________");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 290, 39));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
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
        if (validarCampos()) {
            Contacto contacto = obtenerContactoParaEdicion(this.contacto.getIdContacto());

            if (contacto == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el contacto con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            contacto.setNombre(JTNombre.getText());
            contacto.setEmail(JTCorreo.getText());
            contacto.setNota(JTNota.getText());
            contacto.setDireccion(JTDireccion.getText());
            contacto.setCumpleanios(obtenerFechaCumpleanios());

            contacto.setIdUsuario(usuario.getIdUsuario());

            contactoDAO.actualizarContacto(contacto);

            JOptionPane.showMessageDialog(this, "Contacto actualizado exitosamente.");
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
            dispose(); // Cerrar la ventana de edición después de guardar
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jTCumpleaniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCumpleaniosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCumpleaniosActionPerformed

    public Contacto obtenerContactoParaEdicion(int idContacto) {
        return contactoDAO.obtenerContactoPorId(idContacto);
    }

    private Date obtenerFechaCumpleanios() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaCumpleanios = null;
        try {
            fechaCumpleanios = new Date(sdf.parse(jTCumpleanios.getText()).getTime());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fechaCumpleanios;
    }

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
            java.util.logging.Logger.getLogger(EditarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Contacto contacto = new Contacto();
                new EditarContacto(contacto).setVisible(true);
            }
        });
    }
    
    public void transparenciabtn(){
        btnCancelar.setOpaque(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorderPainted(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTCorreo;
    private javax.swing.JTextField JTDireccion;
    private javax.swing.JTextField JTNombre;
    private javax.swing.JTextField JTNota;
    private javax.swing.JTextField JTNumero;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelCumple;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNota;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTCumpleanios;
    // End of variables declaration//GEN-END:variables
}
