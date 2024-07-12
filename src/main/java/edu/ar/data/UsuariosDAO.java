package edu.ar.data;

import static edu.ar.data.Conexion.close;
import static edu.ar.data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*import java.sql.SQLException;*/
import java.util.ArrayList;
import java.util.List;
import edu.ar.model.Usuario;

public class UsuariosDAO {

  private static final String SQL_SELECT = "SELECT id, nombre, email FROM usuario";
  
  // Método para obtener la lista de usuarios
  public static List<Usuario> obtener() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Usuario usuario = null;
    List<Usuario> usuarios = new ArrayList<>();
  
    // Bloque try-catch-finally para manejar recursos
    try {
      // Obtener la conexión a la base de datos
      conn = getConexion();
      
      // Preparar la consulta SQL
      ps = conn.prepareStatement(SQL_SELECT);
      
      // Ejecutar la consulta y obtener el resultado
      rs = ps.executeQuery();
      
      // Iterar sobre los resultados devueltos por el select
      while (rs.next()) {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String email = rs.getString("email");

        // Crear una instancia de Usuario y agregarla a la lista
        usuario = new Usuario(id, nombre, email);
        usuarios.add(usuario);
      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    } finally {
      try {
        // Cerrar el ResultSet, PreparedStatement y Connection
        close(rs);
        close(ps);
        close(conn);
      } catch (Exception e) {
        e.printStackTrace(System.out);
      }
    }
    return usuarios;
  }
}
