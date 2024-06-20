package u23238340.proyect.contact.book.dao;

import u23238340.proyect.contact.book.database.ConexionDB;
import u23238340.proyect.contact.book.model.Contacto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    private Connection connection; 

    public ContactoDAO() {
        ConexionDB conexionDB = new ConexionDB();
        connection = conexionDB.establecerConexion();
    }

    public void agregarContacto(Contacto contacto) {
        String sqlInsert = "INSERT INTO contactos (id_usuario, nombre, email, foto, nota) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            pstmt.setInt(1, contacto.getIdUsuario());
            pstmt.setString(2, contacto.getNombre());
            pstmt.setString(3, contacto.getEmail());
            pstmt.setBytes(4, contacto.getFoto());
            pstmt.setString(5, contacto.getNota());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contacto agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el contacto: " + e.getMessage());
        }
    }

    public void actualizarContacto(Contacto contacto) {
        String sqlUpdate = "UPDATE contactos SET nombre = ?, email = ?, foto = ?, nota = ? WHERE id_contacto = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getEmail());
            pstmt.setBytes(3, contacto.getFoto());
            pstmt.setString(4, contacto.getNota());
            pstmt.setInt(5, contacto.getIdContacto());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Contacto actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el contacto con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el contacto: " + e.getMessage());
        }
    }

    public void eliminarContacto(int idContacto) {
        String sqlDelete = "DELETE FROM contactos WHERE id_contacto = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlDelete)) {
            pstmt.setInt(1, idContacto);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Contacto eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el contacto con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el contacto: " + e.getMessage());
        }
    }

    public List<Contacto> obtenerContactos() {
        List<Contacto> contactos = new ArrayList<>();
        String sqlSelect = "SELECT * FROM contactos";

        try (PreparedStatement pstmt = connection.prepareStatement(sqlSelect); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int idContacto = rs.getInt("id_contacto");
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                byte[] foto = rs.getBytes("foto");
                String nota = rs.getString("nota");

                Contacto contacto = new Contacto(idContacto, idUsuario, nombre, email, null, foto, nota, null, null);
                contactos.add(contacto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los contactos: " + e.getMessage());
        }

        return contactos;
    }

    public List<Contacto> obtenerContactosDetallados() {
        List<Contacto> contactos = new ArrayList<>();
        String query = "{CALL obtenerContactosDetallados()}";

        try (CallableStatement stmt = connection.prepareCall(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idContacto = rs.getInt("id_contacto");
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre_contacto");
                String email = rs.getString("email");
                byte[] foto = rs.getBytes("foto");
                String nota = rs.getString("nota");
                String cumpleanios = rs.getString("cumpleanios");
                String direccion = rs.getString("direccion");
                String telefonos = rs.getString("telefonos");

                Contacto contacto = new Contacto(idContacto, idUsuario, nombre, email, cumpleanios, foto, nota, direccion, telefonos);
                contactos.add(contacto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los contactos detallados: " + e.getMessage());
        }

        return contactos;
    }
}
