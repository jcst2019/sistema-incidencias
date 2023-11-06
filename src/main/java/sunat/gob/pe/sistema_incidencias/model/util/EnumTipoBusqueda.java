package sunat.gob.pe.sistema_incidencias.model.util;

public enum EnumTipoBusqueda {
	
    TODOS(1),
    USUARIO_REGISTRA(2),
    NUMERO_INCIDENCIA(3);

    private final int id;

    EnumTipoBusqueda(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
