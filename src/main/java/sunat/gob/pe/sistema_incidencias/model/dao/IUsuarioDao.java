package sunat.gob.pe.sistema_incidencias.model.dao;

import java.util.Map;

public interface IUsuarioDao {
    Map<Integer,Object> validarUsuario(String correo,String contrasenha);
}
