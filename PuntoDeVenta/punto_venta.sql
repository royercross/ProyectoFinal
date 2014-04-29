-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-04-2014 a las 19:37:05
-- Versión del servidor: 5.5.34
-- Versión de PHP: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `punto_venta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id_detalle_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `total` double NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_detalle_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `existencia` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `descripcion`, `precio`, `existencia`, `status`) VALUES
(1, 'laptop', 10000, 5, 1),
(2, 'pizarron', 200, 100, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `fecha_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modicado` datetime NOT NULL,
  PRIMARY KEY (`id_usuario`),
  FULLTEXT KEY `nombre_completo` (`nombre`,`apellido_paterno`,`apellido_materno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `apellido_paterno`, `apellido_materno`, `email`, `usuario`, `contrasena`, `status`, `fecha_alta`, `fecha_modicado`) VALUES
(1, 'Rogelio Alfonso', 'Noris', 'Covarrubias', 'rogelio.norisc@gmail.com', 'rogelio', 'rogelio', 1, '2014-02-18 17:12:41', '0000-00-00 00:00:00'),
(2, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:44', '0000-00-00 00:00:00'),
(3, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:57', '0000-00-00 00:00:00'),
(4, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:58', '0000-00-00 00:00:00'),
(5, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:58', '0000-00-00 00:00:00'),
(6, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:58', '0000-00-00 00:00:00'),
(7, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:59', '0000-00-00 00:00:00'),
(8, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:59', '0000-00-00 00:00:00'),
(9, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:59', '0000-00-00 00:00:00'),
(10, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:20:59', '0000-00-00 00:00:00'),
(11, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:21:00', '0000-00-00 00:00:00'),
(12, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:21:00', '0000-00-00 00:00:00'),
(13, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:21:00', '0000-00-00 00:00:00'),
(14, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:21:00', '0000-00-00 00:00:00'),
(15, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:21:00', '0000-00-00 00:00:00'),
(16, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:21:07', '0000-00-00 00:00:00'),
(17, '1', '2', '3', '4', '5', '6', 1, '2014-03-11 17:21:10', '0000-00-00 00:00:00'),
(18, '1', '1', '1', '1', '1', '1', 1, '2014-03-11 17:24:52', '0000-00-00 00:00:00'),
(19, '', '', '', '', '', '', 2, '2014-03-11 17:25:07', '0000-00-00 00:00:00'),
(20, '', '', '', '', '', '', 2, '2014-03-11 17:25:07', '0000-00-00 00:00:00'),
(21, '', '', '', '', '', '', 2, '2014-03-11 17:25:08', '0000-00-00 00:00:00'),
(22, '', '', '', '', '', '', 2, '2014-03-11 17:25:08', '0000-00-00 00:00:00'),
(23, '', '', '', '', '', '', 2, '2014-03-11 17:25:08', '0000-00-00 00:00:00'),
(24, '', '', '', '', '', '', 2, '2014-03-11 17:25:08', '0000-00-00 00:00:00'),
(25, '', '', '', '', '', '', 2, '2014-03-11 17:25:08', '0000-00-00 00:00:00'),
(26, '', '', '', '', '', '', 1, '2014-03-11 17:25:12', '0000-00-00 00:00:00'),
(27, '', '', '', '', '', '', 1, '2014-03-11 17:25:12', '0000-00-00 00:00:00'),
(28, '', '', '', '', '', '', 2, '2014-03-11 17:25:13', '0000-00-00 00:00:00'),
(29, '', '', '', '', '', '', 1, '2014-03-11 17:25:13', '0000-00-00 00:00:00'),
(30, '', '', '', '', '', '', 1, '2014-03-11 17:25:13', '0000-00-00 00:00:00'),
(31, '1', '1', '1', '1', '1', '1', 1, '2014-03-11 17:28:20', '0000-00-00 00:00:00'),
(32, 'alfonso', '2', '2', '2', '2', '2', 1, '2014-03-25 17:22:05', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
