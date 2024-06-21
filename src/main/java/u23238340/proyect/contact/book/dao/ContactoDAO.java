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

    public void insertarContacto(Contacto contacto, String calle, String ciudad, String pais, String telefono, String tipoTelefono) {
        String sqlInsert = "{CALL insertarContacto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement pstmt = connection.prepareCall(sqlInsert)) {
            pstmt.setInt(1, contacto.getIdUsuario());
            pstmt.setString(2, contacto.getNombre());
            pstmt.setString(3, contacto.getEmail());
            pstmt.setBytes(4, contacto.getFoto());
            pstmt.setString(5, contacto.getNota());

            // Convertir la fecha de cumpleanios a java.sql.Date
            pstmt.setDate(6, new java.sql.Date(contacto.getCumpleanios().getTime()));

            pstmt.setString(7, calle);
            pstmt.setString(8, ciudad);
            pstmt.setString(9, pais);
            pstmt.setString(10, telefono);
            pstmt.setString(11, tipoTelefono);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contacto insertado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el contacto: " + e.getMessage());
        }
    }

    public void actualizarContacto(Contacto contacto) {
        String sqlUpdate = "{CALL actualizarContactoDetallado(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement pstmt = connection.prepareCall(sqlUpdate)) {
            pstmt.setInt(1, contacto.getIdContacto());
            pstmt.setInt(2, contacto.getIdUsuario());
            pstmt.setString(3, contacto.getNombre());
            pstmt.setString(4, contacto.getEmail());
            pstmt.setBytes(5, contacto.getFoto());
            pstmt.setString(6, contacto.getNota());
            pstmt.setDate(7, new java.sql.Date(contacto.getCumpleanios().getTime()));
            pstmt.setString(8, contacto.getDireccion()); // Se pasa la dirección directamente
            pstmt.setString(9, contacto.getTelefonos()); // Se pasa el string formateado de teléfonos

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

    public boolean eliminarContacto(int idContacto) {
        try (CallableStatement stmt = connection.prepareCall("{CALL eliminarContacto(?)}")) {
            stmt.setInt(1, idContacto);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Contacto obtenerContactoPorId(int idContacto) {
        Contacto contacto = null;
        String query = "{CALL obtenerContactoPorId(?)}";

        try (CallableStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, idContacto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre_contacto");
                    String email = rs.getString("email");
                    Date cumpleanios = rs.getDate("cumpleanios");
                    byte[] foto = rs.getBytes("foto");
                    String nota = rs.getString("nota");
                    String direccion = rs.getString("direccion");
                    String telefonos = rs.getString("telefonos");

                    // Crear el objeto Contacto con todos los datos, incluyendo el ID
                    contacto = new Contacto(idContacto, nombre, email, cumpleanios, foto, nota, direccion, telefonos);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el contacto por ID: " + e.getMessage());
        }

        return contacto;
    }

    public List<Contacto> obtenerContactosDetallados() {
        List<Contacto> contactos = new ArrayList<>();
        String query = "{CALL obtenerContactosDetallados()}";

        try (CallableStatement stmt = connection.prepareCall(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idContacto = rs.getInt("id_contacto"); // Obtener el ID del contacto
                String nombre = rs.getString("nombre_contacto");
                String email = rs.getString("email");
                Date cumpleanios = rs.getDate("cumpleanios");
                byte[] foto = rs.getBytes("foto");
                String nota = rs.getString("nota");
                String direccion = rs.getString("direccion");
                String telefonos = rs.getString("telefonos");

                Contacto contacto = new Contacto(idContacto, nombre, email, cumpleanios, foto, nota, direccion, telefonos);
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los contactos detallados: " + e.getMessage());
        }

        return contactos;
    }

}
