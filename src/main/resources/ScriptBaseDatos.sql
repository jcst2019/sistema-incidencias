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
 ('Servicio 1', 'A'),
 ('Servicio 2', 'A'),
 ('Servicio 3', 'A'),
 ('Servicio 4', 'A'),
 ('Servicio 5', 'A');

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
 ('Subcategoria 1', 'A'),
 ('Subcategoria 2', 'A'),
 ('Subcategoria 3', 'A'),
 ('Subcategoria 4', 'A'),
 ('Subcategoria 5', 'A');
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
 ('Una  Persona', 'A'),
 ('Una UUOO', 'A');
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
    estado CHAR(1)
);

INSERT INTO incidencias (idServicio,idSubcategoria,idImpacto,idUrgencia, asunto, descripcion,fechaRegistro, idUsuarioRegistra, estado)
VALUES 
 (1,1,1,1,'Asunto 1','Descripcion 1',NOW(),11, 'A'),
 (2,1,1,1,'Asunto 2','Descripcion 1',NOW(),11, 'A'),
 (3,3,3,1,'Asunto 3','Descripcion 1',NOW(),11, 'A'),
 (4,1,2,1,'Asunto 4','Descripcion 1',NOW(),11, 'A'),
 (5,3,2,1,'Asunto 5','Descripcion 1',NOW(),11, 'A');


