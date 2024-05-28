# Wallet Personal-2

## Descripción

"Wallet Personal-2" es una aplicación de billetera digital que permite a los usuarios gestionar sus fondos mediante depósitos, retiros y consultas de saldo. La aplicación sigue el patrón de diseño MVC (Modelo-Vista-Controlador) y está desarrollada en Java utilizando JSP para la interfaz de usuario.

## Características

- **Gestión de fondos:** Los usuarios pueden depositar y retirar dinero.
- **Consulta de saldo:** Los usuarios pueden consultar su saldo y ver un historial de transacciones.
- **Arquitectura MVC:** La aplicación sigue el patrón de diseño MVC para separar la lógica de negocio, la lógica de presentación y el acceso a los datos.
- **Inyección de dependencias:** Configuración centralizada de dependencias para facilitar el mantenimiento y las pruebas.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:


## Requisitos del Sistema

- Java JDK 11 o superior
- Apache Tomcat 9 o superior
- MySQL 5.7 o superior
- Maven 3.6 o superior

## Configuración

### Base de Datos

1. Crear una base de datos MySQL llamada `wallet_personal`.
2. Ejecutar el script SQL para crear las tablas `user` y `transactions`.

```sql
CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL DEFAULT 0
);

CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    amount DOUBLE NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);
```

## Aplicación
1. Clonar el repositorio del proyecto.
2. Configurar el archivo ConnectionDB.java con los detalles de la conexión a tu base de datos MySQL.
3. Compilar y empaquetar la aplicación utilizando Maven
4. Desplegar el archivo WAR generado en Apache Tomcat.
5. Acceder a la aplicación en tu navegador web en http://localhost:8080/wallet.


## Pruebas Unitarias
El proyecto utiliza JUnit 5 y Mockito para las pruebas unitarias. Las pruebas se encuentran en el directorio src/test/java.

# Autor
Jaime Villagrán


