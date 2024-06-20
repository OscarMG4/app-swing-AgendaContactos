package u23238340.proyect.contact.book.dao;

import u23238340.proyect.contact.book.model.Telefono;
import u23238340.proyect.contact.book.database.ConexionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefonoDAO {

    private Connection connection;

    public TelefonoDAO() {
        ConexionDB conexionDB = new ConexionDB();
        connection = conexionDB.establecerConexion();
    }

    public void agregarTelefono(Telefono telefono) {
        String sqlInsert = "INSERT INTO telefonos (id_contacto, telefono, tipo_telefono) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            pstmt.setInt(1, telefono.getIdContacto());
            pstmt.setString(2, telefono.getTelefono());
            pstmt.setString(3, telefono.getTipoTelefono());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Teléfono agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el teléfono: " + e.getMessage());
        }
    }

    public void actualizarTelefono(Telefono telefono) {
        String sqlUpdate = "UPDATE telefonos SET telefono = ?, tipo_telefono = ? WHERE id_telefono = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, telefono.getTelefono());
            pstmt.setString(2, telefono.getTipoTelefono());
            pstmt.setInt(3, telefono.getIdTelefono());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Teléfono actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el teléfono con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el teléfono: " + e.getMessage());
        }
    }

    public void eliminarTelefono(int idTelefono) {
        String sqlDelete = "DELETE FROM telefonos WHERE id_telefono = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlDelete)) {
            pstmt.setInt(1, idTelefono);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Teléfono eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el teléfono con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el teléfono: " + e.getMessage());
        }
    }

    public List<Telefono> obtenerTelefonosPorContacto(int idContacto) {
        List<Telefono> telefonos = new ArrayList<>();
        String sqlSelect = "SELECT * FROM telefonos WHERE id_contacto = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlSelect)) {
            pstmt.setInt(1, idContacto);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idTelefono = rs.getInt("id_telefono");
                String telefono = rs.getString("telefono");
                String tipoTelefono = rs.getString("tipo_telefono");

                Telefono tel = new Telefono(idTelefono, idContacto, telefono, tipoTelefono);
                telefonos.add(tel);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los teléfonos: " + e.getMessage());
        }

        return telefonos;
    }

    public void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
