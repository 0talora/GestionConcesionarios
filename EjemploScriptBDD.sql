-- Tabla: modelo
CREATE TABLE modelo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    puertas INT CHECK (puertas IN (2, 3, 4, 5)),
    anio_lanzamiento YEAR NOT NULL,
    anio_cese YEAR
);

-- Tabla: concesionario
CREATE TABLE concesionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    calle VARCHAR(100) NOT NULL,
    numero INT NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    cp INT NOT NULL,
    telefono INT NOT NULL
);

-- Tabla: inventario con nuevas columnas precio_compra y precio_venta
CREATE TABLE inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo_id INT NOT NULL,
    color VARCHAR(30) NOT NULL,
    anio YEAR NOT NULL,
    kilometraje INT NOT NULL,
    caballos INT NOT NULL,
    combustible ENUM('Gasolina','Diésel','Eléctrico','Híbrido','GNC','GLP','Hidrógeno') NOT NULL,
    cubicaje DECIMAL(3,1) NOT NULL,
    concesionario_id INT NOT NULL,
    estado ENUM('Disponible','Reservado','Revisión','Vendido') NOT NULL,
    duenos_previos INT NOT NULL,
    version VARCHAR(20),
    matricula VARCHAR(15) NOT NULL UNIQUE,
    pais_origen VARCHAR(50) NOT NULL,
    precio_compra DECIMAL(10,2) NOT NULL DEFAULT 0,
    precio_venta DECIMAL(10,2) NOT NULL DEFAULT 0,
    FOREIGN KEY (modelo_id) REFERENCES modelo(id),
    FOREIGN KEY (concesionario_id) REFERENCES concesionario(id)
);

-- Insertar concesionarios
INSERT INTO concesionario (nombre, calle, numero, ciudad, provincia, cp, telefono) VALUES
('Alfa Romeo Stellantis & You - Madrid Esquerdo', 'Dr. Esquerdo', 62, 'Madrid', 'Madrid', 28007, 915851050),
('Más Automóviles - Alfa Romeo Leganés (Madrid)', 'Av. Carlos Sáinz', 2, 'Leganés', 'Madrid', 28914, 910000000),
('Audi Motor Pacífico - Madrid', 'Luis Mitjans', 2, 'Madrid', 'Madrid', 28007, 916480251),
('Automóviles Argüelles - Madrid Centro', 'Galileo', 5, 'Madrid', 'Madrid', 28015, 914447888),
('Motor Pacífico Premium (Audi) - Madrid Centro', 'Independencia', 4, 'Madrid', 'Madrid', 28013, 914330330);


-- Insertar modelos
INSERT INTO modelo (nombre, marca, puertas, anio_lanzamiento, anio_cese) VALUES
('Giulia','Alfa Romeo',4,2015,NULL),
('Stelvio','Alfa Romeo',4,2016,NULL),
('Tonale','Alfa Romeo',5,2022,NULL),
('A3','Audi',5,2012,NULL),
('A4','Audi',4,2007,NULL),
('A5','Audi',2,2016,NULL),
('A6','Audi',4,2011,NULL),
('A7','Audi',5,2017,NULL),
('A8','Audi',4,2010,NULL),
('Q3','Audi',5,2011,NULL),
('Q5','Audi',5,2008,NULL),
('Q7','Audi',5,2005,NULL),
('Q8','Audi',5,2018,NULL),
('RS3','Audi',5,2011,NULL),
('RS6','Audi',5,2008,NULL),
('RS e-tron GT','Audi',4,2021,NULL),
('Serie 1','BMW',5,2004,NULL),
('Serie 3','BMW',4,1975,NULL),
('Serie 5','BMW',4,1972,NULL),
('X3','BMW',5,2003,NULL),
('X5','BMW',5,1999,NULL),
('M3','BMW',4,1986,NULL),
('Clase A','Mercedes-Benz',5,1997,NULL),
('Clase C','Mercedes-Benz',4,1993,NULL),
('Clase E','Mercedes-Benz',4,1996,NULL),
('GLE','Mercedes-Benz',5,2015,NULL),
('GLC','Mercedes-Benz',5,2015,NULL),
('Seat Ibiza','Seat',5,1984,NULL),
('Seat Leon','Seat',5,1999,NULL),
('Peugeot 308','Peugeot',5,2007,NULL),
('Peugeot 3008','Peugeot',5,2008,NULL),
('Peugeot 208','Peugeot',5,2012,NULL);

-- Procedimiento para insertar 100 coches aleatorios con precios
DELIMITER //
CREATE PROCEDURE poblar_inventario()
BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE mat VARCHAR(15);

  WHILE i <= 100 DO
    -- Generar matrícula aleatoria única con formato AAA000X
    SET mat = CONCAT(
      CHAR(FLOOR(65 + RAND()*26)),
      CHAR(FLOOR(65 + RAND()*26)),
      CHAR(FLOOR(65 + RAND()*26)),
      LPAD(FLOOR(RAND()*1000), 3, '0'),
      CHAR(FLOOR(65 + RAND()*26))
    );

    BEGIN
      DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN END;

      INSERT INTO inventario (
        modelo_id, color, anio, kilometraje, caballos, combustible,
        cubicaje, concesionario_id, estado, duenos_previos,
        version, matricula, pais_origen,
        precio_compra, precio_venta
      )
      VALUES (
        FLOOR(1 + RAND()*31),
        ELT(FLOOR(1 + RAND()*6),'Blanco','Negro','Rojo','Azul','Gris','Verde'),
        FLOOR(2005 + RAND()*21),
        FLOOR(RAND()*200000),
        FLOOR(70 + RAND()*250),
        ELT(FLOOR(1 + RAND()*7),'Gasolina','Diésel','Eléctrico','Híbrido','GNC','GLP','Hidrógeno'),
        ROUND(0.8 + RAND()*3.2,1),
        FLOOR(1 + RAND()*5),
        ELT(FLOOR(1 + RAND()*4),'Disponible','Reservado','Revisión','Vendido'),
        FLOOR(RAND()*5),
        ELT(FLOOR(1 + RAND()*5),'E30','F10','G20','W204',''),
        mat,
        ELT(FLOOR(1 + RAND()*6),'España','Alemania','Italia','Francia','EEUU','Japón'),
        ROUND(5000 + RAND()*35000, 2),
        ROUND(6000 + RAND()*45000, 2)
      );

      SET i = i + 1;
    END;
  END WHILE;
END //
DELIMITER ;

-- Llamar al procedimiento para poblar inventario
CALL poblar_inventario();
