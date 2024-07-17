/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u23238340.proyect.contact.book.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class ConexionDB {

    private Connection conectar = null;

    private final String usuario = "root";
    private final String contrasena = "";
    private final String bd = "db_agenda_contactos";
    private final String ip = "localhost";
    private final String puerto = "3306";

    private final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd + "?useSSL=false&serverTimezone=UTC";

    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            System.out.println("Conexión Exitosa!");
            //JOptionPane.showMessageDialog(null, "Conexión Exitosa!");
        } catch (ClassNotFoundException e) {
            System.out.println("Fallo en la carga del driver: " + e.toString());
            //JOptionPane.showMessageDialog(null, "Fallo en la carga del driver: " + e.toString());
        } catch (SQLException e) {
            System.out.println("Fallo en la conexión: " + e.toString());
            //JOptionPane.showMessageDialog(null, "Fallo en la conexión: " + e.toString());
        }
        return conectar;
    }

}
