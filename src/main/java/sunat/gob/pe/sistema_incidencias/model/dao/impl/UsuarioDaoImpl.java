package sunat.gob.pe.sistema_incidencias.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import sunat.gob.pe.sistema_incidencias.model.dao.IUsuarioDao;
import sunat.gob.pe.sistema_incidencias.model.entities.Usuario;
import sunat.gob.pe.sistema_incidencias.model.util.Conexion;

public class UsuarioDaoImpl implements IUsuarioDao{

    @Override
    public Map<Integer, Object> validarUsuario(String user, String clave) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        Usuario usuario;
        ResultSet rs = null;
        Map<Integer, Object> respuesta = null;
        try {
            String sql = "SELECT idUsuario, dni, nombre ,Nombre, apellido, usuario, contrasenha, correo,estado FROM usuarios WHERE usuario = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            
            rs = pstmt.executeQuery();
            
            respuesta = new HashMap<>();

            if (rs.next()) {
                if(rs.getString(7).equals(clave)){
                	 usuario=new Usuario(rs.getInt(1),
                			  rs.getString(2),
                			  rs.getString(3),
                              rs.getString(4),
                              rs.getString(5),
                              rs.getString(6),
                              rs.getString(7),
                              rs.getString(8));
                        respuesta.put(4, usuario);
                }else{
                    System.out.println("Clave incorrecta");
                    respuesta.put(2, "Clave incorrecta.");
                }
            }else{
                System.out.println("Usuario no existe");
                respuesta.put(3, "Usuario no existe.");
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }
        }

        return respuesta;
    }
    
}
