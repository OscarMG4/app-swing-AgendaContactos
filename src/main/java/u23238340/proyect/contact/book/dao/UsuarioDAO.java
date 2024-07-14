package u23238340.proyect.contact.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import u23238340.proyect.contact.book.database.ConexionDB;
import u23238340.proyect.contact.book.model.Usuario;

public class UsuarioDAO {

    private final ConexionDB conexionDB;

    public UsuarioDAO() {
        this.conexionDB = new ConexionDB();
    }

    public void agregarUsuario(Usuario usuario) {
        String sqlInsert = "INSERT INTO usuarios (nombre_usuario, contrasena) VALUES (?, ?)";
        executeUpdate(sqlInsert, usuario.getNombreUsuario(), usuario.getContrasena());
    }

    public void actualizarUsuario(Usuario usuario) {
        String sqlUpdate = "UPDATE usuarios SET nombre_usuario = ?, contrasena = ? WHERE id_usuario = ?";
        executeUpdate(sqlUpdate, usuario.getNombreUsuario(), usuario.getContrasena(), usuario.getIdUsuario());
    }

    public void eliminarUsuario(int idUsuario) {
        String sqlDelete = "DELETE FROM usuarios WHERE id_usuario = ?";
        executeUpdate(sqlDelete, idUsuario);
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) {
        String sqlSelect = "SELECT * FROM usuarios WHERE id_usuario = ?";
        return executeQueryForSingleUsuario(sqlSelect, idUsuario);
    }

    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        String sqlSelect = "SELECT * FROM usuarios WHERE nombre_usuario = ?";
        return executeQueryForSingleUsuario(sqlSelect, nombreUsuario);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        String sqlSelect = "SELECT * FROM usuarios";
        return executeQueryForMultipleUsuarios(sqlSelect);
    }

    private void executeUpdate(String sql, Object... params) {
        try (
                Connection conn = conexionDB.establecerConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setParams(pstmt, params);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Operación realizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros para actualizar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la operación: " + e.getMessage());
        }
    }

    private Usuario executeQueryForSingleUsuario(String sql, Object... params) {
        try (
                Connection conn = conexionDB.establecerConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setParams(pstmt, params);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre_usuario"),
                        rs.getString("contrasena")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el usuario: " + e.getMessage());
        }
        return null;
    }

    private List<Usuario> executeQueryForMultipleUsuarios(String sql, Object... params) {
        List<Usuario> usuarios = new ArrayList<>();
        try (
                Connection conn = conexionDB.establecerConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setParams(pstmt, params);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre_usuario"),
                        rs.getString("contrasena")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    private void setParams(PreparedStatement pstmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
    }
}
