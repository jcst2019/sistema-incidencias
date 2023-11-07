CREATE SCHEMA IF NOT EXISTS bdIncidencias;

USE bdIncidencias;

CREATE TABLE usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(8),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    usuario VARCHAR(50),
    contrasenha VARCHAR(50),
    correo VARCHAR(100),
    estado CHAR(1)
);

CREATE TABLE servicios (
    idServicio INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

CREATE TABLE subcategorias (
    idSubcategoria INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

CREATE TABLE impactos (
    idImpacto INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

CREATE TABLE urgencias (
    idUrgencia INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

CREATE TABLE incidencias (
    idIncidencia INT AUTO_INCREMENT PRIMARY KEY,
    idServicio INT ,
    idSubcategoria INT ,
    idImpacto INT ,
    idUrgencia INT ,
    asunto VARCHAR(100),
    descripcion VARCHAR(500),
    fechaRegistro DATETIME,
    idUsuarioRegistra INT,
    idUsuarioAsignado INT,
    estado CHAR(1)
);

-- Relación foránea entre incidencias y usuarios
ALTER TABLE incidencias
ADD CONSTRAINT fk_incidencias_usuarios
FOREIGN KEY (idUsuarioAsignado) REFERENCES usuarios(idUsuario);

-- Relación foránea entre incidencias y urgencias
ALTER TABLE incidencias
ADD CONSTRAINT fk_incidencias_urgencias
FOREIGN KEY (idUrgencia) REFERENCES urgencias(idUrgencia);

-- Relación foránea entre incidencias y impactos
ALTER TABLE incidencias
ADD CONSTRAINT fk_incidencias_impactos
FOREIGN KEY (idImpacto) REFERENCES impactos(idImpacto);

-- Relación foránea entre incidencias y subcategorias
ALTER TABLE incidencias
ADD CONSTRAINT fk_incidencias_subcategorias
FOREIGN KEY (idSubcategoria) REFERENCES subcategorias(idSubcategoria);

-- Relación foránea entre incidencias y servicios
ALTER TABLE incidencias
ADD CONSTRAINT fk_incidencias_servicios
FOREIGN KEY (idServicio) REFERENCES servicios(idServicio);