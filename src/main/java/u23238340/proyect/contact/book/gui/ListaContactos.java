package u23238340.proyect.contact.book.gui;

import java.text.SimpleDateFormat;
import u23238340.proyect.contact.book.dao.ContactoDAO;
import u23238340.proyect.contact.book.model.Contacto;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import u23238340.proyect.contact.book.model.Usuario;

public class ListaContactos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    private static ListaContactos instance = null;
    private ContactoDAO contactoDAO;
    private Usuario usuario;

    public ListaContactos(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        jTListContac.setModel(modelo);

        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);
        ocultarJLabels();
        contactoDAO = new ContactoDAO(); // Inicializar ContactoDAO
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
        jLabelDetalle = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabelDirec = new javax.swing.JLabel();
        jLabelCumpleanios = new javax.swing.JLabel();
        jLabelNota = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelNum = new javax.swing.JLabel();
        jLabel11Correo = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelCumple = new javax.swing.JLabel();
        jLabelNotas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListContac = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTitulo.setText("- Lista de contactos -");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVolver.setText("volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabelDetalle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelDetalle.setText("Detalle:");

        jLabelNom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNom.setText("Nombre:");

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNumero.setText("Número:");

        jLabelCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCorreo.setText("Correo:");

        jLabelDirec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDirec.setText("Dirección:");

        jLabelCumpleanios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCumpleanios.setText("Cumpleaños:");

        jLabelNota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNota.setText("Notas:");

        jLabelNombre.setText("jLabelNombre");

        jLabelNum.setText("jLabelNum");

        jLabel11Correo.setText("jLabel11Correo");

        jLabelDireccion.setText("jLabelDireccion");

        jLabelCumple.setText("jLabelCumple");

        jLabelNotas.setText("jLabelNotas");

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

        btnListar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnListar)))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDetalle)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabelNom))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabelNumero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabelCorreo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelDirec))
                            .addComponent(jLabelCumpleanios)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabelNota)))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEditar)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelNum)
                            .addComponent(jLabel11Correo)
                            .addComponent(jLabelDireccion)
                            .addComponent(jLabelCumple)
                            .addComponent(jLabelNotas))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(btnListar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabelDetalle)
                        .addGap(28, 28, 28)
                        .addComponent(jLabelNom)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNumero)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCorreo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDirec)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCumpleanios)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNota))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabelNombre)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelNum)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11Correo)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelDireccion)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelCumple)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelNotas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver)
                    .addComponent(btnEditar))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTListContac.getModel();
        model.setRowCount(0);

        ocultarJLabels();

        // Obtener lista de contactos del usuario actual
        List<Contacto> listaContactos = contactoDAO.obtenerContactosPorUsuario(usuario.getIdUsuario());

        for (Contacto contacto : listaContactos) {
            Object[] rowData = {contacto.getIdContacto(), contacto.getNombre()};
            model.addRow(rowData);
        }
    }//GEN-LAST:event_btnListarActionPerformed

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

            // Obtener el contacto por ID desde el DAO
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

    private void jTListContacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListContacMouseClicked
        int selectedRow = jTListContac.getSelectedRow();

        if (selectedRow != -1) {
            Object idObject = jTListContac.getValueAt(selectedRow, 0);

            // Asegurarse de que el idObject es de tipo Integer
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

            // Obtener el contacto por ID
            Contacto contactoSeleccionado = contactoDAO.obtenerContactoPorId(idContacto);

            if (contactoSeleccionado != null) {
                // Mostrar detalle del contacto seleccionado en la interfaz
                mostrarDetalleContacto(contactoSeleccionado);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el contacto en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTListContacMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnVolver;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTListContac;
    // End of variables declaration//GEN-END:variables
}
