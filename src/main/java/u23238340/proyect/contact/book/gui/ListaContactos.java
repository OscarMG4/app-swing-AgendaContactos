package u23238340.proyect.contact.book.gui;

import java.awt.Image;
import java.text.SimpleDateFormat;
import u23238340.proyect.contact.book.dao.ContactoDAO;
import u23238340.proyect.contact.book.model.Contacto;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.ImageIcon;
import u23238340.proyect.contact.book.model.Usuario;

public class ListaContactos extends javax.swing.JFrame {

    private ContactoDAO contactoDAO;
    private Usuario usuario;

    public ListaContactos(Usuario usuario) {
        initComponents();
        transparenciabtn();
        
        ImageIcon originalIcon = (ImageIcon) jLabel1.getIcon();
        Image scaledImage = originalIcon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(scaledImage));
        
        this.usuario = usuario;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        jTListContac.setModel(modelo);

        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);
        ocultarJLabels();
        contactoDAO = new ContactoDAO();
    }

    private ListaContactos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void ocultarJLabels() {
        jLabelNombre.setVisible(false);
        jLabelNum.setVisible(false);
        jLabel11Correo.setVisible(false);
        jLabelDireccion.setVisible(false);
        jLabelCumple.setVisible(false);
        jLabelNotas.setVisible(false);
    }

    private void mostrarDetalleContacto(Contacto contacto) {
        jLabelNombre.setText(contacto.getNombre());
        jLabelNum.setText(contacto.getTelefonos());
        jLabel11Correo.setText(contacto.getEmail());
        jLabelDireccion.setText(contacto.getDireccion());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaCumpleanios = dateFormat.format(contacto.getCumpleanios());
        jLabelCumple.setText(fechaCumpleanios);
        jLabelNotas.setText(contacto.getNota());

        jLabelNombre.setVisible(true);
        jLabelNum.setVisible(true);
        jLabel11Correo.setVisible(true);
        jLabelDireccion.setVisible(true);
        jLabelCumple.setVisible(true);
        jLabelNotas.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListContac = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelDetalle = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelNum = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabel11Correo = new javax.swing.JLabel();
        jLabelDirec = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelCumpleanios = new javax.swing.JLabel();
        jLabelCumple = new javax.swing.JLabel();
        jLabelNota = new javax.swing.JLabel();
        jLabelNotas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 156, 184));
        setForeground(new java.awt.Color(0, 156, 184));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 154, 233));
        jPanel1.setForeground(new java.awt.Color(0, 156, 184));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("- Lista de contactos -");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        btnEditar.setBackground(new java.awt.Color(0, 42, 48));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(0, 42, 48));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 470, -1, -1));

        btnVolver.setBackground(new java.awt.Color(0, 42, 48));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/volver.png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 32, 32));

        jTListContac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Selecciona"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListContac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListContacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTListContac);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 360, 381));

        btnListar.setBackground(new java.awt.Color(0, 42, 48));
        btnListar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("Listar");
        btnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jPanel1.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 80, 70));

        jPanel2.setBackground(new java.awt.Color(27, 130, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDetalle.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabelDetalle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDetalle.setText("Detalles");
        jPanel2.add(jLabelDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabelNom.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelNom.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNom.setText("Nombre:");
        jPanel2.add(jLabelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabelNombre.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("LabelNombre");
        jPanel2.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabelNumero.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número:");
        jPanel2.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabelNum.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelNum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNum.setText("LabelNumero");
        jPanel2.add(jLabelNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabelCorreo.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setText("Correo:");
        jPanel2.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel11Correo.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel11Correo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11Correo.setText("LabelCorreo");
        jPanel2.add(jLabel11Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jLabelDirec.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelDirec.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDirec.setText("Dirección:");
        jPanel2.add(jLabelDirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabelDireccion.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDireccion.setText("LabelDireccion");
        jPanel2.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jLabelCumpleanios.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelCumpleanios.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCumpleanios.setText("Cumpleaños:");
        jPanel2.add(jLabelCumpleanios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabelCumple.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelCumple.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCumple.setText("LabelCumple");
        jPanel2.add(jLabelCumple, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jLabelNota.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelNota.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNota.setText("Notas:");
        jPanel2.add(jLabelNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabelNotas.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelNotas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNotas.setText("LabelNotas");
        jPanel2.add(jLabelNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 360, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTListContac.getModel();
        model.setRowCount(0);

        ocultarJLabels();

        List<Contacto> listaContactos = contactoDAO.obtenerContactosPorUsuario(usuario.getIdUsuario());

        for (Contacto contacto : listaContactos) {
            Object[] rowData = {contacto.getIdContacto(), contacto.getNombre()};
            model.addRow(rowData);
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void jTListContacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListContacMouseClicked
        int selectedRow = jTListContac.getSelectedRow();

        if (selectedRow != -1) {
            Object idObject = jTListContac.getValueAt(selectedRow, 0);

            int idContacto = 0;
            if (idObject instanceof Integer) {
                idContacto = (Integer) idObject;
            } else {
                try {
                    idContacto = Integer.parseInt(idObject.toString());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID de contacto no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            Contacto contactoSeleccionado = contactoDAO.obtenerContactoPorId(idContacto);

            if (contactoSeleccionado != null) {
                mostrarDetalleContacto(contactoSeleccionado);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el contacto en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTListContacMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal principal = new Principal(usuario);
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = jTListContac.getSelectedRow();

        if (selectedRow != -1) {
            Object idObject = jTListContac.getValueAt(selectedRow, 0);

            int idContacto = (Integer) idObject;
            int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este contacto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                boolean eliminado = contactoDAO.eliminarContacto(idContacto);
                if (eliminado) {
                    DefaultTableModel model = (DefaultTableModel) jTListContac.getModel();
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Contacto y relaciones eliminados exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un contacto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = jTListContac.getSelectedRow();

        if (selectedRow != -1) {

            Object idObject = jTListContac.getValueAt(selectedRow, 0);

            int idContacto = (Integer) idObject;

            Contacto contactoSeleccionado = contactoDAO.obtenerContactoPorId(idContacto);

            if (contactoSeleccionado != null) {
                EditarContacto editarContacto = new EditarContacto(contactoSeleccionado, usuario);
                editarContacto.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el contacto seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un contacto para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaContactos().setVisible(true);
            }
        });
    }
    
    public void transparenciabtn(){
        btnVolver.setOpaque(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11Correo;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelCumple;
    private javax.swing.JLabel jLabelCumpleanios;
    private javax.swing.JLabel jLabelDetalle;
    private javax.swing.JLabel jLabelDirec;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNota;
    private javax.swing.JLabel jLabelNotas;
    private javax.swing.JLabel jLabelNum;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTListContac;
    // End of variables declaration//GEN-END:variables
}
