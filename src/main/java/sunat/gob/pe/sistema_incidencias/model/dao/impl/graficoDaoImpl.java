package sunat.gob.pe.sistema_incidencias.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sunat.gob.pe.sistema_incidencias.model.dao.Igrafico;
import sunat.gob.pe.sistema_incidencias.model.entities.barra;
import sunat.gob.pe.sistema_incidencias.model.util.Conexion;

public class graficoDaoImpl implements Igrafico {

      private List<barra> listaBarra = new ArrayList<>();
      private PreparedStatement pstmt = null;
      private ResultSet rs = null;
      
    @Override
    public List<barra> grafico1() {
      Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
      
          try {

             String sql = "SELECT\r\n"
             		+ " s.descripcion AS tipo_incidencia,\r\n"
             		+ " COUNT(*) AS total\r\n"
             		+ " FROM incidencias i\r\n"
             		+ " JOIN subcategorias s ON i.idSubcategoria = s.idSubcategoria\r\n"
             		+ " GROUP BY tipo_incidencia\r\n"
             		+ " ORDER BY total DESC\r\n"
             		+ "  ";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                listaBarra.add(new barra(rs.getString(1), rs.getInt(2) ));
                    System.out.println("Incidencias:" + rs.getString(1)+ ": " + rs.getInt(2));
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
        return listaBarra;
        
    }

	@Override
	public String obtenerTotalIncidencias() {
	     Conexion conexion = new Conexion();
	        Connection conn = conexion.getConexion();
	        PreparedStatement pstmt = null;
	        String totalIncidencia = null;
	      
	          try {

	             String sql = "SELECT COUNT(*) AS total_incidencias FROM incidencias";

	            pstmt = conn.prepareStatement(sql);

	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	totalIncidencia = rs.getString(1);
	                System.out.println("obtenerTotalIncidencias:" + rs.getString(1));
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
	        return totalIncidencia;
	}

	@Override
	public String obtenerTotalUsuarios() {
	     Conexion conexion = new Conexion();
	        Connection conn = conexion.getConexion();
	        PreparedStatement pstmt = null;
	        String totalUsuarios = null;
	      
	          try {

	             String sql = "SELECT COUNT(*) AS total_usuarios FROM usuarios";

	            pstmt = conn.prepareStatement(sql);

	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	totalUsuarios = rs.getString(1);
	                System.out.println("obtenerTotalUsuarios:" + rs.getString(1));
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
	        return totalUsuarios;
	}

	@Override
	public String obtenerTotalUrgencias() {
	     Conexion conexion = new Conexion();
	        Connection conn = conexion.getConexion();
	        PreparedStatement pstmt = null;
	        String totalUsuarios = null;
	      
	          try {

	             String sql = "SELECT COUNT(*) FROM subcategorias";

	            pstmt = conn.prepareStatement(sql);

	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	totalUsuarios = rs.getString(1);
	                System.out.println("obtenerTotalUsuarios:" + rs.getString(1));
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
	        return totalUsuarios;
	}

	@Override
	public String obtenerIncidenciaMaxima() {
	     Conexion conexion = new Conexion();
	        Connection conn = conexion.getConexion();
	        PreparedStatement pstmt = null;
	        String incidenciaMax = null;
	      
	          try {

	             String sql = " SELECT\r\n"
	             		+ "    s.descripcion AS tipo_incidencia,\r\n"
	             		+ "    COUNT(*) AS total\r\n"
	             		+ "    FROM incidencias i\r\n"
	             		+ "    JOIN subcategorias s ON i.idSubcategoria = s.idSubcategoria\r\n"
	             		+ "    GROUP BY tipo_incidencia\r\n"
	             		+ "    ORDER BY total DESC\r\n"
	             		+ "    LIMIT 1";

	            pstmt = conn.prepareStatement(sql);

	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	incidenciaMax = rs.getString(1);
	                System.out.println("obtenerTotalUsuarios:" + rs.getString(1));
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
	        return incidenciaMax;
	}
    
}
