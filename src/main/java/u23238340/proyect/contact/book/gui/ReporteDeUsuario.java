package u23238340.proyect.contact.book.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import u23238340.proyect.contact.book.dao.ReporteDAO;
import u23238340.proyect.contact.book.model.Usuario;
import u23238340.proyect.contact.book.model.Reporte;

public class ReporteDeUsuario extends javax.swing.JFrame {

    private ReporteDAO reporteDAO;
    private Usuario usuario;

    public ReporteDeUsuario(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.setTitle("AGENDA DE CONTACTOS PERSONALES");
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Descripción");
        modelo.addColumn("Valor");
        jTListContac.setModel(modelo);
        this.setLocationRelativeTo(null);
        reporteDAO = new ReporteDAO();
        cargarDatosReporte();
        crearGraficoCircular();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListContac = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 156, 184));
        setForeground(new java.awt.Color(0, 156, 184));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 156, 184));
        jPanel1.setForeground(new java.awt.Color(0, 156, 184));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("- Reportes -");

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
        jScrollPane1.setViewportView(jTListContac);

        btnRegresar.setBackground(new java.awt.Color(0, 42, 48));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("<=");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(jLabelTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelTitulo)
                .addGap(123, 123, 123)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Principal principal = new Principal(usuario);
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cargarDatosReporte() {
        List<Reporte> reportes = reporteDAO.obtenerReportesPorUsuario(usuario.getIdUsuario());
        if (!reportes.isEmpty()) {
            Reporte ultimoReporte = reportes.get(reportes.size() - 1);
            DefaultTableModel model = (DefaultTableModel) jTListContac.getModel();
            model.setRowCount(0);
            model.addRow(new Object[]{"Total de contactos", ultimoReporte.getNumTotalContactos()});
            model.addRow(new Object[]{"Contactos editados", ultimoReporte.getNumContactosEditados()});
            model.addRow(new Object[]{"Contactos eliminados", ultimoReporte.getNumContactosEliminados()});
            model.addRow(new Object[]{"Contactos agregados", ultimoReporte.getNumContactosAgregados()});
        }
    }

    private void crearGraficoCircular() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        List<Reporte> reportes = reporteDAO.obtenerReportesPorUsuario(usuario.getIdUsuario());
        if (!reportes.isEmpty()) {
            Reporte ultimoReporte = reportes.get(reportes.size() - 1);
            dataset.setValue("Editados", ultimoReporte.getNumContactosEditados());
            dataset.setValue("Eliminados", ultimoReporte.getNumContactosEliminados());
            dataset.setValue("Agregados", ultimoReporte.getNumContactosAgregados());
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Distribución de Contactos",
                dataset,
                true,
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        Color azul1 = new Color(0, 100, 255);
        Color azul2 = new Color(0, 50, 200);
        Color azul3 = new Color(0, 0, 150);
        
        plot.setSectionPaint("Editados", azul2);
        plot.setSectionPaint("Eliminados", azul3);
        plot.setSectionPaint("Agregados", azul1);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300, 300));
        jPanel1.add(chartPanel);
        chartPanel.setBounds(500, 100, 300, 300);
        chartPanel.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTListContac;
    // End of variables declaration//GEN-END:variables
}
