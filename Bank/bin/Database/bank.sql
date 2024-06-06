-- Base de datos: `bank`
CREATE DATABASE IF NOT EXISTS `bank`;
USE `bank`;

-- Estructura de tabla para la tabla `contacto`
CREATE TABLE `contacto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo_electronico` varchar(100) NOT NULL,
  `mensaje` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Estructura de tabla para la tabla `cuenta`
CREATE TABLE `cuenta` (
  `numero_cuenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `dinero_disponible` decimal(15,2) NOT NULL DEFAULT 0.00,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero_cuenta`),
  KEY `usuario_id` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Estructura de tabla para la tabla `personas`
CREATE TABLE `personas` (
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `numero_telefono` varchar(20) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `uk_numero_telefono` (`numero_telefono`),
  KEY `usuario_id` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Estructura de tabla para la tabla `registro`
CREATE TABLE `registro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `telefono_envio` varchar(20) NOT NULL,
  `telefono_destino` varchar(20) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `cantidad` decimal(15,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Estructura de tabla para la tabla `usuarios`
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Restricciones para la tabla `cuenta`
ALTER TABLE `cuenta`
  ADD CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

-- Restricciones para la tabla `personas`
ALTER TABLE `personas`
  ADD CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);


CREATE USER IF NOT EXISTS 'user'@'localhost' IDENTIFIED BY 'userbank';


GRANT SELECT, INSERT ON `bank`.* TO `user`@`localhost`;

GRANT INSERT ON `bank`.`contacto` TO `user`@`localhost`;

GRANT INSERT ON `bank`.`registro` TO `user`@`localhost`;

GRANT UPDATE (`dinero_disponible`) ON `bank`.`cuenta` TO `user`@`localhost`;

GRANT UPDATE, UPDATE (`numero_telefono`) ON `bank`.`personas` TO `user`@`localhost`;

GRANT UPDATE, UPDATE (`usuario`) ON `bank`.`usuarios` TO `user`@`localhost`;