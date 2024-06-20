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

    public void agregarUsuario(Usuario usuario) {
        ConexionDB conexionDB = new ConexionDB();
        Connection conn = null;

        String sqlInsert = "INSERT INTO usuarios (nombre_usuario, contrasena) VALUES (?, ?)";

        try {
            conn = conexionDB.establecerConexion();
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContrasena());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el usuario: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        ConexionDB conexionDB = new ConexionDB();
        Connection conn = null;

        String sqlUpdate = "UPDATE usuarios SET nombre_usuario = ?, contrasena = ? WHERE id_usuario = ?";

        try {
            conn = conexionDB.establecerConexion();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContrasena());
            pstmt.setInt(3, usuario.getIdUsuario());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public void eliminarUsuario(int idUsuario) {
        ConexionDB conexionDB = new ConexionDB();
        Connection conn = null;

        String sqlDelete = "DELETE FROM usuarios WHERE id_usuario = ?";

        try {
            conn = conexionDB.establecerConexion();
            PreparedStatement pstmt = conn.prepareStatement(sqlDelete);
            pstmt.setInt(1, idUsuario);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario con el ID especificado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) {
        ConexionDB conexionDB = new ConexionDB();
        Connection conn = null;
        Usuario usuario = null;

        String sqlSelect = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try {
            conn = conexionDB.establecerConexion();
            PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombreUsuario = rs.getString("nombre_usuario");
                String contrasena = rs.getString("contrasena");

                usuario = new Usuario(idUsuario, nombreUsuario, contrasena);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el usuario: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

        return usuario;
    }

    public List<Usuario> obtenerTodosUsuarios() {
        ConexionDB conexionDB = new ConexionDB();
        Connection conn = null;
        List<Usuario> usuarios = new ArrayList<>();

        String sqlSelect = "SELECT * FROM usuarios";

        try {
            conn = conexionDB.establecerConexion();
            PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombreUsuario = rs.getString("nombre_usuario");
                String contrasena = rs.getString("contrasena");

                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contrasena);
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los usuarios: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

        return usuarios;
    }
}
