use bdIncidencias;

select * from usuarios

drop table usuarios

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




INSERT INTO usuarios (dni, nombre, apellido, usuario, contrasenha, correo, estado)
VALUES 
('12345678', 'Juan', 'Pérez', 'juanperez', 'clave123', 'juan@example.com', 'A'),
('98765432', 'María', 'López', 'marialopez', 'password456', 'maria@example.com', 'A'),
('45678901', 'Carlos', 'González', 'carlosg', 'mipass123', 'carlos@example.com', 'A'),
('78901234', 'Laura', 'Martínez', 'lauram', 'segura456', 'laura@example.com', 'A'),
('23456789', 'Pedro', 'Sánchez', 'pedros', 'miclave123', 'pedro@example.com', 'A'),
('67890123', 'Ana', 'Rodríguez', 'anarod', 'mipassword', 'ana@example.com', 'A'),
('34567890', 'Sofía', 'Gómez', 'sofiag', 'pass123', 'sofia@example.com', 'A'),
('90123456', 'Miguel', 'Díaz', 'migueld', 'micontra', 'miguel@example.com', 'A'),
('56789012', 'Elena', 'García', 'elenag', 'mipass', 'elena@example.com', 'A'),
('12345678', 'Javier', 'Fernández', 'javierf', 'password', 'javier@example.com', 'A'),
('12345679', 'Juan', 'Prueba', 's', 's', 'juan@example.com', 'A');


INSERT INTO usuarios (dni, nombre, apellido, usuario, contrasenha, correo, estado)
VALUES 
('1234567890', 'Juan', 'Pérez', 's', 's', 'juan@example.com', true);

select * from usuarios

-- =====================================

select * from servicios

drop table servicios

CREATE TABLE servicios (
    idServicio INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

INSERT INTO servicios (descripcion, estado)
VALUES 
 ('SOFTWARE', 'A'),
 ('HARDWARE', 'A'),
 ('TELECOMUNICACIONES', 'A');

-- =====================================

select * from subcategorias

drop table subcategorias

CREATE TABLE subcategorias (
    idSubcategoria INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

INSERT INTO subcategorias (descripcion, estado)
VALUES 
 ('OFFICE 365', 'A'),
 ('SOFTWARE BASE', 'A'),
 ('SOFTWARE COMERCIAL', 'A'),
 ('CERTIFICADO DIGITAL', 'A'),
 ('EQUIPAMIENTO INFORMATICO', 'A'),
 ('SERVICIO DE IMPRESIÓN', 'A'),
 ('TELEFONIA IP', 'A'),
 ('CONEXIÓN VPN', 'A'),
 ('ESCRITORIO VIRTUAL', 'A'),
 ('VIDEO CONFERENCIA', 'A'),
 ('CONEXIÓN WIFI', 'A'),
 ('PUERTO DE RED', 'A'),
 ('CABLEADO', 'A');
-- =====================================

select * from impactos

drop table impactos

CREATE TABLE impactos (
    idImpacto INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

INSERT INTO impactos (descripcion, estado)
VALUES 
 ('Un  Departamento', 'A'),
 ('Una  Servicio', 'A'),
 ('Una Persona', 'A');
-- =====================================

select * from urgencias

drop table urgencias

CREATE TABLE urgencias (
    idUrgencia INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    estado CHAR(1)
);

INSERT INTO urgencias (descripcion, estado)
VALUES 
 ('Crítica', 'A'),
 ('Alta', 'A'),
 ('Media','A'),
 ('Baja', 'A');


-- =====================================

select * from incidencias

drop table incidencias

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

ALTER TABLE incidencias
ADD CONSTRAINT fk_incidencias_usuarios
FOREIGN KEY (idUsuarioAsignado) REFERENCES usuarios(idUsuario);


INSERT INTO incidencias (idServicio,idSubcategoria,idImpacto,idUrgencia, asunto, descripcion,fechaRegistro, idUsuarioRegistra,idUsuarioAsignado, estado)
VALUES 
 (1,1,1,1,'Asunto 1','Descripcion 1',NOW(),11,null, 'A'),
 (2,1,1,1,'Asunto 2','Descripcion 1',NOW(),11,null, 'A'),
 (3,3,3,1,'Asunto 3','Descripcion 1',NOW(),11,null, 'A'),
 (1,1,2,1,'Asunto 4','Descripcion 1',NOW(),11,null, 'A'),
 (2,3,2,1,'Asunto 5','Descripcion 1',NOW(),11,null, 'A');


INSERT INTO incidencias (idServicio, idSubcategoria, idImpacto, idUrgencia, asunto, descripcion, fechaRegistro, idUsuarioRegistra, estado)
VALUES 
(1, 1, 1, 1, 'Incidencia 1', 'Descripción de la incidencia 1', NOW(), 1, 'A'),
(2, 2, 2, 2, 'Incidencia 2', 'Descripción de la incidencia 2', NOW(), 2, 'A'),
(3, 3, 3, 3, 'Incidencia 3', 'Descripción de la incidencia 3', NOW(), 3, 'A'),
(1, 4, 1, 4, 'Incidencia 4', 'Descripción de la incidencia 4', NOW(), 4, 'A'),
(2, 5, 2, 1, 'Incidencia 5', 'Descripción de la incidencia 5', NOW(), 5, 'A'),
(3, 6, 3, 2, 'Incidencia 6', 'Descripción de la incidencia 6', NOW(), 6, 'A'),
(1, 7, 1, 3, 'Incidencia 7', 'Descripción de la incidencia 7', NOW(), 7, 'A'),
(2, 8, 2, 4, 'Incidencia 8', 'Descripción de la incidencia 8', NOW(), 8, 'A'),
(3, 9, 3, 1, 'Incidencia 9', 'Descripción de la incidencia 9', NOW(), 9, 'A'),
(1, 10, 1, 2, 'Incidencia 10', 'Descripción de la incidencia 10', NOW(), 10, 'A'),
(2, 11, 2, 3, 'Incidencia 11', 'Descripción de la incidencia 11', NOW(), 11, 'A'),
(3, 12, 3, 4, 'Incidencia 12', 'Descripción de la incidencia 12', NOW(), 1, 'A'),
(1, 1, 1, 1, 'Incidencia 13', 'Descripción de la incidencia 13', NOW(), 2, 'A'),
(2, 2, 2, 2, 'Incidencia 14', 'Descripción de la incidencia 14', NOW(), 3, 'A'),
(3, 3, 3, 3, 'Incidencia 15', 'Descripción de la incidencia 15', NOW(), 4, 'A');


DELIMITER //

CREATE PROCEDURE dashboard_info()
BEGIN
    -- Total de incidencias
    SELECT COUNT(*) AS total_incidencias FROM incidencias;

    -- Total de usuarios
    SELECT COUNT(*) AS total_usuarios FROM usuarios;

    -- Incidencias por día, por mes y por año
    SELECT 
        DATE(fechaRegistro) AS dia,
        MONTH(fechaRegistro) AS mes,
        YEAR(fechaRegistro) AS anio,
        COUNT(*) AS total_incidencias
    FROM incidencias
    GROUP BY dia, mes, anio;

    -- Tipo de incidencia más repetitiva
    SELECT
        s.descripcion AS tipo_incidencia,
        COUNT(*) AS total
    FROM incidencias i
    JOIN subcategorias s ON i.idSubcategoria = s.idSubcategoria
    GROUP BY tipo_incidencia
    ORDER BY total DESC
    LIMIT 1;
END//

DELIMITER ;

CALL dashboard_info();

    SELECT 
        DATE(fechaRegistro) AS dia,
        MONTH(fechaRegistro) AS mes,
        YEAR(fechaRegistro) AS anio,
        COUNT(*) AS total_incidencias
    FROM incidencias
    GROUP BY dia, mes, anio;

    SELECT
        s.descripcion AS tipo_incidencia,
        COUNT(*) AS total
    FROM incidencias i
    JOIN subcategorias s ON i.idSubcategoria = s.idSubcategoria
    GROUP BY tipo_incidencia
    ORDER BY total DESC


