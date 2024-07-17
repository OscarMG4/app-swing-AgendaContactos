package u23238340.proyect.contact.book.dao;

import u23238340.proyect.contact.book.database.ConexionDB;
import u23238340.proyect.contact.book.model.Contacto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    private final Connection connection;

    public ContactoDAO() {
        this.connection = new ConexionDB().establecerConexion();
    }

    public void insertarContacto(Contacto contacto, String calle, String ciudad, String pais, String telefono, String tipoTelefono) {
        String sql = "{CALL insertarContacto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, contacto.getIdUsuario());
            stmt.setString(2, contacto.getNombre());
            stmt.setString(3, contacto.getEmail());
            stmt.setDate(4, new java.sql.Date(contacto.getCumpleanios().getTime()));
            stmt.setBytes(5, contacto.getFoto());
            stmt.setString(6, contacto.getNota());
            stmt.setString(7, calle);
            stmt.setString(8, ciudad);
            stmt.setString(9, pais);
            stmt.setString(10, telefono);
            stmt.setString(11, tipoTelefono);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la operación: " + e.getMessage());
        }
    }

    public void actualizarContacto(Contacto contacto) {
        String sqlUpdate = "{CALL actualizarContactoDetallado(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        executeUpdate(sqlUpdate, contacto.getIdContacto(), contacto.getIdUsuario(), contacto.getNombre(), contacto.getEmail(),
                contacto.getFoto(), contacto.getNota(), new java.sql.Date(contacto.getCumpleanios().getTime()),
                contacto.getDireccion(), contacto.getTelefonos());
    }

    public boolean eliminarContacto(int idContacto) {
        String sqlDelete = "{CALL eliminarContacto(?)}";
        try (CallableStatement stmt = connection.prepareCall(sqlDelete)) {
            stmt.setInt(1, idContacto);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el contacto: " + e.getMessage());
            return false;
        }
    }

    public Contacto obtenerContactoPorId(int idContacto) {
        String sqlSelect = "{CALL obtenerContactoPorId(?)}";
        try (CallableStatement stmt = connection.prepareCall(sqlSelect)) {
            stmt.setInt(1, idContacto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractContactoFromResultSet(rs);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el contacto en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el contacto: " + e.getMessage());
        }
        return null;
    }

    public List<Contacto> obtenerContactosDetallados() {
        String sqlSelect = "{CALL obtenerContactosDetallados()}";
        return executeQueryForMultipleContactos(sqlSelect);
    }

    public List<Contacto> obtenerContactosPorUsuario(int idUsuario) {
        String sqlSelect = "{CALL obtenerContactosPorUsuario(?)}";
        return executeQueryForMultipleContactos(sqlSelect, idUsuario);
    }

    private int executeUpdate(String sql, Object... params) {
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            setParams(stmt, params);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la operación: " + e.getMessage());
            return 0;
        }
    }

    private List<Contacto> executeQueryForMultipleContactos(String sql, Object... params) {
        List<Contacto> contactos = new ArrayList<>();
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            setParams(stmt, params);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Contacto contacto = extractContactoFromResultSet(rs);
                    contactos.add(contacto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los contactos: " + e.getMessage());
        }
        return contactos;
    }

    private Contacto extractContactoFromResultSet(ResultSet rs) throws SQLException {
        int idContacto = rs.getInt("id_contacto");
        String nombre = rs.getString("nombre");
        String email = rs.getString("email");
        Date cumpleanios = rs.getDate("cumpleanios");
        byte[] foto = rs.getBytes("foto");
        String nota = rs.getString("nota");

        String direccion = obtenerDireccion(idContacto);

        String telefonos = obtenerTelefono(idContacto);

        return new Contacto(idContacto, nombre, email, cumpleanios, foto, nota, direccion, telefonos);
    }

    private int insertarDireccion(int idContacto, String calle, String ciudad, String pais) {
        String sqlInsert = "INSERT INTO direcciones (id_contacto, calle, ciudad, pais) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idContacto);
            stmt.setString(2, calle);
            stmt.setString(3, ciudad);
            stmt.setString(4, pais);
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID generado para la dirección.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar dirección: " + e.getMessage());
            return 0;
        }
    }

    private String obtenerTelefono(int idContacto) throws SQLException {
        StringBuilder telefonos = new StringBuilder();
        String sql = "SELECT telefono FROM telefonos WHERE id_contacto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idContacto);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    if (telefonos.length() > 0) {
                        telefonos.append(", ");
                    }
                    telefonos.append(rs.getString("telefono"));
                }
            }
        }
        return telefonos.toString();
    }

    private String obtenerDireccion(int idContacto) throws SQLException {
        String sql = "SELECT calle, ciudad, pais FROM direcciones WHERE id_contacto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idContacto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String calle = rs.getString("calle");
                    String ciudad = rs.getString("ciudad");
                    String pais = rs.getString("pais");
                    return String.format("%s, %s, %s", calle, ciudad, pais);
                }
            }
        }
        return null;
    }

    private void setParams(PreparedStatement pstmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
    }
}
