CREATE TABLE Hotel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    total_habitaciones INT NOT NULL,
    avaluo FLOAT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);
