CREATE DATABASE RegistroUsuarios;

USE RegistroUsuarios;

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    email VARCHAR(20) NOT NULL
);

INSERT INTO Usuario (nombre, email) VALUES
('Rodolfo Suarez', 'rodolfo@example.com'),
('Juana Brunello', 'juana@example.com'),
('María Andrade', 'maria@example.com'),
('José Hernández', 'jose@example.com'),
('Thomas Rinhe', 'thomas@example.com'),
('Susana Diaz', 'susana@example.com'),
('Juan Peréz', 'juan@example.com'),
('Elsa Enrique', 'elsa@example.com'),
('Lia Maldonado', 'lia@example.com'),
('Carlos Manuel', 'carlos@example.com');
