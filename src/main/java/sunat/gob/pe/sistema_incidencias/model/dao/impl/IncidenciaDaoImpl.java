package sunat.gob.pe.sistema_incidencias.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sunat.gob.pe.sistema_incidencias.model.dao.IIncidencia;
import sunat.gob.pe.sistema_incidencias.model.entities.Incidencia;
import sunat.gob.pe.sistema_incidencias.model.util.Conexion;

public class IncidenciaDaoImpl implements IIncidencia {

    @Override
    public boolean guardarIncidencia(Incidencia incidencia) {
    	
    	boolean exito = false;
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO incidencias (idServicio, idSubcategoria, idImpacto, idUrgencia, asunto, descripcion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, incidencia.getIdServicio().get());
            pstmt.setInt(2, incidencia.getIdSubcategoria().get());
            pstmt.setInt(3, incidencia.getIdImpacto().get());
            pstmt.setInt(4, incidencia.getIdUrgencia().get());
            pstmt.setString(5, incidencia.getAsunto().get());
            pstmt.setString(6, incidencia.getDescripcion().get());
            pstmt.setString(7, incidencia.getEstado().get());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
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
            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }
        }
        return exito;
    }
}
