package sunat.gob.pe.sistema_incidencias.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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
            String sql = "INSERT INTO incidencias (idServicio, idSubcategoria, idImpacto, idUrgencia, asunto, descripcion, fechaRegistro, idUsuarioRegistra, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, incidencia.getIdServicio().get());
            pstmt.setInt(2, incidencia.getIdSubcategoria().get());
            pstmt.setInt(3, incidencia.getIdImpacto().get());
            pstmt.setInt(4, incidencia.getIdUrgencia().get());
            pstmt.setString(5, incidencia.getAsunto().get());
            pstmt.setString(6, incidencia.getDescripcion().get());
            pstmt.setObject(7, incidencia.getFechaRegistro().get());
            pstmt.setInt(8, incidencia.getIdUsuarioRegistra().get());
            pstmt.setString(9, incidencia.getEstado().get());

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

	@Override
	public List<Incidencia> busquedaTotalIncidencias() {
    	boolean exito = false;
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        List<Incidencia> listaIncicencias = new ArrayList<>();
        ResultSet rs = null;

        try {

            String sql = "Select idIncidencia, idServicio, idSubcategoria, idImpacto, idUrgencia, asunto, descripcion,fechaRegistro, idUsuarioRegistra, estado from incidencias";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Incidencia incidencia = new Incidencia(
                        new SimpleObjectProperty<>(rs.getInt(1)),
                        new SimpleObjectProperty<>(rs.getInt(2)),
                        new SimpleObjectProperty<>(rs.getInt(3)),
                        new SimpleObjectProperty<>(rs.getInt(4)),
                        new SimpleObjectProperty<>(rs.getInt(5)),
                        new SimpleStringProperty(rs.getString(6)),
                        new SimpleStringProperty(rs.getString(7)),
                        new SimpleObjectProperty<>(rs.getTimestamp(8).toLocalDateTime()),
                        new SimpleObjectProperty<>(rs.getInt(9)),
                        new SimpleStringProperty(rs.getString(10))
                    );
                listaIncicencias.add(incidencia);
                System.out.println("Incidencia:" + incidencia.toString());
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

        return listaIncicencias;
    }
}
