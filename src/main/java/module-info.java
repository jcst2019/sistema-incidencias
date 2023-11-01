module sunat.gob.pe.sistema_incidencias {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens sunat.gob.pe.sistema_incidencias;
    opens sunat.gob.pe.sistema_incidencias.controller;
    exports sunat.gob.pe.sistema_incidencias;
    exports sunat.gob.pe.sistema_incidencias.controller;
}
