-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2021 a las 03:31:17
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `actividadcodoacodo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codoacodo`
--

CREATE TABLE `codoacodo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `edad` tinyint(2) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `provincia` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `codoacodo`
--

INSERT INTO `codoacodo` (`id`, `nombre`, `apellido`, `edad`, `fecha`, `provincia`) VALUES
(1, 'Jose', 'Perales', 48, '2021-10-25 01:12:35', 'Córdoba'),
(2, 'Maria Antonieta', 'Reyes', 21, '2015-10-09 01:12:35', 'Buenos Aires'),
(3, 'Miguel', 'Portal', 32, '2001-11-24 23:25:05', 'Córdoba'),
(4, 'Julieta', 'Venegas', 37, '2010-12-08 15:12:35', 'Rosario'),
(5, 'Manuel', 'Casas', 50, '1981-10-01 16:26:59', 'Santa Cruz');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `codoacodo`
--
ALTER TABLE `codoacodo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `codoacodo`
--
ALTER TABLE `codoacodo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
