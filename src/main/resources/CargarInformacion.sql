
-- Cargar la informacion

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
('12345679', 'Juan', 'Solar', 'jsolart', 'p', 'juan@example.com', 'A');

-- =====================================

INSERT INTO servicios (descripcion, estado)
VALUES 
 ('SOFTWARE', 'A'),
 ('HARDWARE', 'A'),
 ('TELECOMUNICACIONES', 'A');

-- =====================================

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
 ('ESCRITORIO VIRTUA', 'A'),
 ('VIDEO CONFERENCIA', 'A'),
 ('CONEXIÓN WIFI', 'A'),
 ('PUERTO DE RED', 'A'),
 ('CABLEADO', 'A');
 
-- =====================================

INSERT INTO impactos (descripcion, estado)
VALUES 
 ('Un  Departamento', 'A'),
 ('Una  Servicio', 'A'),
 ('Una Persona', 'A');
 
-- =====================================

INSERT INTO urgencias (descripcion, estado)
VALUES 
 ('Crítica', 'A'),
 ('Alta', 'A'),
 ('Media','A'),
 ('Baja', 'A');


-- =====================================

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

