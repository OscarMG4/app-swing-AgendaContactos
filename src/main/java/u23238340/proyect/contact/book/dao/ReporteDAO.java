package u23238340.proyect.contact.book.dao;

import u23238340.proyect.contact.book.model.Reporte;
import u23238340.proyect.contact.book.database.ConexionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    private Connection connection;

    public ReporteDAO() {
        ConexionDB conexionDB = new ConexionDB();
        connection = conexionDB.establecerConexion();
    }

    public void agregarReporte(Reporte reporte) {
        String sqlInsert = "INSERT INTO reportes (id_usuario, num_contactos_total, num_contactos_editados, num_contactos_eliminados, num_contactos_agregados) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            pstmt.setInt(1, reporte.getIdUsuario());
            pstmt.setInt(2, reporte.getNumTotalContactos());
            pstmt.setInt(3, reporte.getNumContactosEditados());
            pstmt.setInt(4, reporte.getNumContactosEliminados());
            pstmt.setInt(5, reporte.getNumContactosAgregados());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reporte agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el reporte: " + e.getMessage());
        }
    }

    public List<Reporte> obtenerReportesPorUsuario(int idUsuario) {
        List<Reporte> reportes = new ArrayList<>();
        String sqlSelect = "SELECT * FROM reportes WHERE id_usuario = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlSelect)) {
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idReporte = rs.getInt("id_reporte");
                int numContactosTotal = rs.getInt("num_total_contactos");
                int numContactosEditados = rs.getInt("num_contactos_editados");
                int numContactosEliminados = rs.getInt("num_contactos_eliminados");
                int numContactosAgregados = rs.getInt("num_contactos_agregados");
                Timestamp fechaGenerado = rs.getTimestamp("fecha_generado");

                Reporte reporte = new Reporte(idReporte, idUsuario, numContactosTotal, numContactosEditados, numContactosEliminados, numContactosAgregados, fechaGenerado);
                reportes.add(reporte);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los reportes: " + e.getMessage());
        }

        return reportes;
    }

    private int obtenerNumeroContactosAgregadosEditadosEliminados(int idUsuario, String columna) {
        int total = 0;
        String sqlSelect = "SELECT SUM(" + columna + ") AS total FROM reportes WHERE id_usuario = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlSelect)) {
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el número total de contactos: " + e.getMessage());
        }

        return total;
    }

    public int obtenerNumeroContactosTotales(int idUsuario) {
        return obtenerNumeroContactosAgregadosEditadosEliminados(idUsuario, "num_contactos_total");
    }

    public int obtenerNumeroContactosEditados(int idUsuario) {
        return obtenerNumeroContactosAgregadosEditadosEliminados(idUsuario, "num_contactos_editados");
    }

    public int obtenerNumeroContactosEliminados(int idUsuario) {
        return obtenerNumeroContactosAgregadosEditadosEliminados(idUsuario, "num_contactos_eliminados");
    }

    public int obtenerNumeroContactosAgregados(int idUsuario) {
        return obtenerNumeroContactosAgregadosEditadosEliminados(idUsuario, "num_contactos_agregados");
    }

    public void eliminarReporte(int idReporte) {
        String sqlDelete = "DELETE FROM reportes WHERE id_reporte = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlDelete)) {
            pstmt.setInt(1, idReporte);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Reporte eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el reporte con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el reporte: " + e.getMessage());
        }
    }

}
