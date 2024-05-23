-- Crear la base de datos (si aún no existe)
CREATE DATABASE IF NOT EXISTS wallet_personal;
USE wallet_personal;

-- Crear la tabla 'cuentas'
CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    firstname varchar(25) NOT NULL,
    lastname varchar (35) NOT NULL,
	email varchar (59) NOT NULL,
	password varchar(25),
	balance double NOT NULL DEFAULT 0.00
);


-- Crear la tabla 'transacciones'
CREATE TABLE transacciones (
    transaction_Id INT auto_increment primary key,     
	amount DOUBLE NOT NULL,
    transactionType varchar(10) NOT NULL,
    transactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_user INT NOT NULL,
	FOREIGN KEY (id_user) REFERENCES user(user_id) ON DELETE CASCADE
);

SELECT * FROM USER;

INSERT INTO user (firstname, lastname, email, password)
VALUES ("Jaime", "Villagran", "jvillagran@mail.com", "12345");

START TRANSACTION;
Update user set balance = balance + 5000; 
INSERT INTO transacciones (amount, transactionType, transactionDate, id_user)
VALUES ( 5000, "deposito", Now(), 1);
COMMIT;

SELECT * FROM transacciones



