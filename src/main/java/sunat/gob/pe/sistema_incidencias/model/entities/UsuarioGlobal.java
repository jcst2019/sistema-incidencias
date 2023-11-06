package sunat.gob.pe.sistema_incidencias.model.entities;

public class UsuarioGlobal {
	
    private static Integer idUsuario;

    public static Integer getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(Integer idUsuario) {
        UsuarioGlobal.idUsuario = idUsuario;
    }
}
