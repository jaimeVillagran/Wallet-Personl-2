-- Crear la base de datos (si aún no existe)
CREATE DATABASE IF NOT EXISTS WalletPersonal2;
USE WalletPersonal2;

-- Crear la tabla 'cuentas'
CREATE TABLE cuentas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    saldo DECIMAL(10, 2) NOT NULL DEFAULT 0.00
);

-- Crear la tabla 'transacciones'
CREATE TABLE transacciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cuentaId INT NOT NULL,
    tipo ENUM('deposito', 'retiro') NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cuentaId) REFERENCES cuentas(id) ON DELETE CASCADE
);

-- Opcional: Insertar una cuenta inicial
INSERT INTO cuentas (saldo) VALUES (1000.00);
