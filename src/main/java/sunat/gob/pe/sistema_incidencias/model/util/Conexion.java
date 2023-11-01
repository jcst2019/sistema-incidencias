package sunat.gob.pe.sistema_incidencias.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
    private Connection conn;

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdIncidencias", "root", "solaris");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
