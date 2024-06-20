package u23238340.proyect.contact.book.dao;

import u23238340.proyect.contact.book.database.ConexionDB;
import u23238340.proyect.contact.book.model.Direccion;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {

    private Connection connection;

    public DireccionDAO() {
        ConexionDB conexionDB = new ConexionDB();
        connection = conexionDB.establecerConexion();
    }

    public void agregarDireccion(Direccion direccion) {
        String sqlInsert = "INSERT INTO direcciones (id_contacto, calle, ciudad, pais, tipo_direccion) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            pstmt.setInt(1, direccion.getIdContacto());
            pstmt.setString(2, direccion.getCalle());
            pstmt.setString(3, direccion.getCiudad());
            pstmt.setString(4, direccion.getPais());
            pstmt.setString(5, direccion.getTipoDireccion());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dirección agregada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la dirección: " + e.getMessage());
        }
    }

    public void actualizarDireccion(Direccion direccion) {
        String sqlUpdate = "UPDATE direcciones SET calle = ?, ciudad = ?, pais = ?, tipo_direccion = ? WHERE id_direccion = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, direccion.getCalle());
            pstmt.setString(2, direccion.getCiudad());
            pstmt.setString(3, direccion.getPais());
            pstmt.setString(4, direccion.getTipoDireccion());
            pstmt.setInt(5, direccion.getIdDireccion());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Dirección actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la dirección con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la dirección: " + e.getMessage());
        }
    }

    public void eliminarDireccion(int idDireccion) {
        String sqlDelete = "DELETE FROM direcciones WHERE id_direccion = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlDelete)) {
            pstmt.setInt(1, idDireccion);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Dirección eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la dirección con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la dirección: " + e.getMessage());
        }
    }

    public List<Direccion> obtenerDireccionesPorContacto(int idContacto) {
        List<Direccion> direcciones = new ArrayList<>();
        String sqlSelect = "SELECT * FROM direcciones WHERE id_contacto = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlSelect)) {
            pstmt.setInt(1, idContacto);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idDireccion = rs.getInt("id_direccion");
                String calle = rs.getString("calle");
                String ciudad = rs.getString("ciudad");
                String pais = rs.getString("pais");
                String tipoDireccion = rs.getString("tipo_direccion");

                Direccion direccion = new Direccion(idDireccion, idContacto, calle, ciudad, pais, tipoDireccion);
                direcciones.add(direccion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las direcciones: " + e.getMessage());
        }

        return direcciones;
    }
}
