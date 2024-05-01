package u23238340.proyect.contact.book.gui;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import u23238340.proyect.contact.book.data.Contacto;
import u23238340.proyect.contact.book.data.ContactosData;

public class ListaContactos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    //ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();

    public ListaContactos() {
        initComponents();
        modelo.addColumn("Seleccione");
        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        this.setLocationRelativeTo(null);
        inicializarContactos();
        ocultarJLabels();
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
        jLabelNum.setText(contacto.getNumero());
        jLabel11Correo.setText(contacto.getCorreo());
        jLabelDireccion.setText(contacto.getDireccion());
        jLabelCumple.setText(contacto.getCumpleanios());
        jLabelNotas.setText(contacto.getNotas());

        jLabelNombre.setVisible(true);
        jLabelNum.setVisible(true);
        jLabel11Correo.setVisible(true);
        jLabelDireccion.setVisible(true);
        jLabelCumple.setVisible(true);
        jLabelNotas.setVisible(true);
    }

    private void inicializarContactos() {
        ContactosData contactosData = new ContactosData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Editar");

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
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelNum)
                            .addComponent(jLabel11Correo)
                            .addComponent(jLabelDireccion)
                            .addComponent(jLabelCumple)
                            .addComponent(jLabelNotas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(btnEliminar)
                        .addGap(39, 39, 39)))
                .addComponent(btnVolver)
                .addGap(42, 42, 42))
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
                    .addComponent(jButton1))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTListContac.getModel(); //limpiar la tabla
        model.setRowCount(0);

        ocultarJLabels();

        List<Contacto> listaOrdenada = new ArrayList<>(ContactosData.listaContactos);

        Collections.sort(listaOrdenada, new Comparator<Contacto>() {
            @Override
            public int compare(Contacto c1, Contacto c2) {
                return c1.getNombre().compareToIgnoreCase(c2.getNombre());
            }
        });

        for (Contacto contacto : listaOrdenada) {
            Object[] rowData = {contacto.getNombre()};
            model.addRow(rowData);
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = jTListContac.getSelectedRow();

        if (selectedRow != -1) {
            String nombreContacto = (String) jTListContac.getValueAt(selectedRow, 0);

            int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar a " + nombreContacto + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                for (Contacto contacto : ContactosData.listaContactos) {
                    if (contacto.getNombre().equals(nombreContacto)) {
                        ContactosData.listaContactos.remove(contacto);
                        break;
                    }
                }

                DefaultTableModel model = (DefaultTableModel) jTListContac.getModel();
                model.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un contacto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTListContacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListContacMouseClicked
        int selectedRow = jTListContac.getSelectedRow();

        if (selectedRow != -1) {
            String nombreContacto = (String) jTListContac.getValueAt(selectedRow, 0);

            for (Contacto contacto : ContactosData.listaContactos) {
                if (contacto.getNombre().equals(nombreContacto)) {
                    mostrarDetalleContacto(contacto); // Mostrar los datos del contacto seleccionado
                    break;
                }
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
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
