-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-05-2024 a las 01:44:38
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bank`
--
CREATE DATABASE IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `bank`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE `contacto` (
  `id` int(11) NOT NULL,
  `correo_electronico` varchar(100) NOT NULL,
  `mensaje` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`id`, `correo_electronico`, `mensaje`) VALUES
(10, 'alfonsitoamor@gmail.com', 'Quiero trabajar con vosotros'),
(11, 'juanca.jcglp26@gmail.com', 'quiero comprar esta empresa'),
(12, 'alfonsitoamor@gmail.com', 'hola me llamo juanca'),
(13, 'lm715692@gmail.com', 'Hola necesito ayuda para pasar bizum ya que no me deja.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `numero_cuenta` bigint(20) NOT NULL,
  `dinero_disponible` decimal(15,2) NOT NULL DEFAULT 0.00,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`numero_cuenta`, `dinero_disponible`, `usuario_id`) VALUES
(5169924165, 514.00, 1),
(7893799256, 200.00, 5),
(8375528305, 0.00, 6),
(9445883102, 1386.00, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `numero_telefono` varchar(20) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`dni`, `nombre`, `apellido1`, `apellido2`, `numero_telefono`, `usuario_id`) VALUES
('52145362L', 'Marcos', 'Blazquez', 'Cano', '633213205', 5),
('54332992T', 'Laura', 'Moreno', 'Parralejo', '684220577', 6),
('80239635H', 'Juan Carlos', 'Gonzalez', 'Pino', '691667626', 1),
('90876354L', 'Maria Isabel', 'Pino', 'Tejeda', '691691543', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `id` int(11) NOT NULL,
  `telefono_envio` varchar(20) NOT NULL,
  `telefono_destino` varchar(20) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `cantidad` decimal(15,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`id`, `telefono_envio`, `telefono_destino`, `fecha_hora`, `cantidad`) VALUES
(8, '691667626', '691691543', '2024-05-28 20:36:09', 1.00),
(9, '691667626', '691691543', '2024-05-28 23:47:46', 1.00),
(10, '684220577', '691667626', '2024-05-28 23:53:05', 250.00),
(11, '684220577', '691667626', '2024-05-28 23:53:57', 250.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `contrasena`) VALUES
(1, 'juancaaa11', 'juancaaa'),
(4, 'isabel', 'isabel'),
(5, 'maarkitos', 'marcos'),
(6, 'lauramoreno', 'laurita');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`numero_cuenta`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`dni`),
  ADD UNIQUE KEY `uk_numero_telefono` (`numero_telefono`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contacto`
--
ALTER TABLE `contacto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `numero_cuenta` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9445883103;

--
-- AUTO_INCREMENT de la tabla `registro`
--
ALTER TABLE `registro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

CREATE USER IF NOT EXISTS 'user'@'localhost' IDENTIFIED BY 'userbank';


GRANT SELECT, INSERT ON `bank`.* TO `user`@`localhost`;

GRANT INSERT ON `bank`.`contacto` TO `user`@`localhost`;

GRANT INSERT ON `bank`.`registro` TO `user`@`localhost`;

GRANT UPDATE (`dinero_disponible`) ON `bank`.`cuenta` TO `user`@`localhost`;

GRANT UPDATE, UPDATE (`numero_telefono`) ON `bank`.`personas` TO `user`@`localhost`;

GRANT UPDATE, UPDATE (`usuario`) ON `bank`.`usuarios` TO `user`@`localhost`;