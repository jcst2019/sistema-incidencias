package sunat.gob.pe.sistema_incidencias.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sunat.gob.pe.sistema_incidencias.model.dao.IItem;
import sunat.gob.pe.sistema_incidencias.model.entities.Item;
import sunat.gob.pe.sistema_incidencias.model.util.Conexion;
import sunat.gob.pe.sistema_incidencias.model.util.EnumTipoItem;

public class ItemDaoImpl implements IItem  {


	
    @Override
	public List<Item> obtenerListaItem(EnumTipoItem tipo) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        List<Item> listaItem = new ArrayList<>();
        ResultSet rs = null;

        try {
            System.out.println("ItemDaoImpl obtenerListaItem inicio");
            //String sql = "select idServicios,descripcion, estado from servicios";
            String sql = "";
            switch(tipo) {
            case SERVICIO:
                sql = "select idServicio,descripcion, estado from servicios";
                break;
            case SUBCATEGORIA:
                sql = "select idSubcategoria,descripcion, estado from subcategorias";
                break;
            case IMPACTO:
                sql = "select idImpacto,descripcion, estado from impactos";
                break;
            case URGENCIA:
                sql = "select idUrgencia,descripcion, estado from urgencias";
                break;
            default:
                throw new IllegalArgumentException("Tipo de item no válido: " + tipo);
        }
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ItemDaoImpl obtenerListaItem hay resultados 1"+rs.getInt(1));
                System.out.println("ItemDaoImpl obtenerListaItem hay resultados 2"+rs.getString(2));
                System.out.println("ItemDaoImpl obtenerListaItem hay resultados 3"+rs.getString(3));
                listaItem.add(new Item(
                        rs.getInt(1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                ));
                
            }
            System.out.println("ItemDaoImpl obtenerListaItem fin");
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

        return listaItem;
    }
}
