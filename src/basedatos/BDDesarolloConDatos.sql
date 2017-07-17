-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: desarrollo
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `codigoEstado` int(11) NOT NULL,
  `codigoProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(50) NOT NULL,
  PRIMARY KEY (`codigoEstado`,`codigoProyecto`),
  UNIQUE KEY `codigoProyecto_UNIQUE` (`codigoProyecto`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  CONSTRAINT `codigoEstadoAgenda` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProyectoAgenda` FOREIGN KEY (`codigoProyecto`) REFERENCES `proyectos` (`codigoProyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `codigoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `codigoIdentificacion` int(11) NOT NULL,
  `identificacionCliente` varchar(50) NOT NULL,
  `nombreCliente` varchar(45) NOT NULL,
  `apellidoCliente` varchar(45) NOT NULL,
  `telefonoCliente` varchar(45) NOT NULL,
  `direccionCliente` varchar(100) NOT NULL,
  `correoCliente` varchar(45) NOT NULL,
  `codigoEstado` int(11) NOT NULL,
  PRIMARY KEY (`codigoCliente`),
  UNIQUE KEY `codigoCliente_UNIQUE` (`codigoCliente`),
  UNIQUE KEY `identificacionCliente_UNIQUE` (`identificacionCliente`),
  KEY `codigoEstadoCliente_idx` (`codigoEstado`),
  KEY `codigoIdentificacionCliente` (`codigoIdentificacion`),
  CONSTRAINT `codigoEstadoCliente` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoIdentificacionCliente` FOREIGN KEY (`codigoIdentificacion`) REFERENCES `identificaciones` (`codigoIdentificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,1,'2345678909','Dilcia','Cruz','34567890','Col. 3 de Mayo','drosycruz@gmail.com',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotizaciones`
--

DROP TABLE IF EXISTS `cotizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotizaciones` (
  `codigoCotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaEmisionCotizacion` date NOT NULL,
  `impuesto` float NOT NULL,
  `fechaVigencia` date NOT NULL,
  `codigoEstado` int(11) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `codigoEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`codigoCotizacion`),
  UNIQUE KEY `codigoCotizacion_UNIQUE` (`codigoCotizacion`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  KEY `codigoCliente_idx` (`codigoCliente`),
  KEY `codigoEmpleadoCotizaciones_idx` (`codigoEmpleado`),
  CONSTRAINT `codigoClienteCotizaciones` FOREIGN KEY (`codigoCliente`) REFERENCES `clientes` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoEmpleadoCotizaciones` FOREIGN KEY (`codigoEmpleado`) REFERENCES `empleados` (`codigoEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoEstadoCotizaciones` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizaciones`
--

LOCK TABLES `cotizaciones` WRITE;
/*!40000 ALTER TABLE `cotizaciones` DISABLE KEYS */;
INSERT INTO `cotizaciones` VALUES (1,'2017-04-07',0.15,'2017-04-22',6,1,1),(2,'2017-04-07',0.15,'2017-04-22',6,1,1),(3,'2017-04-07',0.15,'2017-04-22',6,1,1),(4,'2017-04-07',0.15,'2017-04-22',6,1,1),(5,'2017-04-07',0.15,'2017-04-22',6,1,1),(6,'2017-04-07',0.15,'2017-04-22',6,1,1),(7,'2017-04-07',0.15,'2017-04-22',6,1,1),(8,'2017-04-07',0.15,'2017-04-22',6,1,1),(9,'2017-04-07',0.15,'2017-04-22',6,1,1),(10,'2017-04-07',0.15,'2017-04-22',6,1,1),(11,'2017-07-16',0.15,'2017-07-31',5,1,1);
/*!40000 ALTER TABLE `cotizaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecotizaciones`
--

DROP TABLE IF EXISTS `detallecotizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecotizaciones` (
  `codigoCotizacion` int(11) NOT NULL,
  `codigoProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL,
  `descripcionDetalle` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoCotizacion`,`codigoProducto`),
  KEY `codigoProducto_idx` (`codigoProducto`),
  CONSTRAINT `codigoCotizacionDetalleCotizaciones` FOREIGN KEY (`codigoCotizacion`) REFERENCES `cotizaciones` (`codigoCotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProductoDetalleCotizaciones` FOREIGN KEY (`codigoProducto`) REFERENCES `productos` (`codigoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecotizaciones`
--

LOCK TABLES `detallecotizaciones` WRITE;
/*!40000 ALTER TABLE `detallecotizaciones` DISABLE KEYS */;
INSERT INTO `detallecotizaciones` VALUES (1,1,5,6,'Sillas moradas'),(2,3,4,200,'4 modulos rojos	'),(3,1,6,7,'dfvdf	'),(4,1,2,200,'hh'),(5,1,4,4,'Sillas amarillas	'),(6,1,3,3,'Sillas amarillas	'),(7,1,3,3,'dfgfdg	'),(8,1,23,2,'sdfsdf	'),(9,1,2,2,'dfsgdsgsd	'),(10,1,34,3,'fgfdg	'),(11,1,45,2,'Bancas');
/*!40000 ALTER TABLE `detallecotizaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallefactura` (
  `codigoFactura` int(11) NOT NULL,
  `codigoEstado` int(11) NOT NULL,
  `codigoProducto` int(11) NOT NULL,
  `anticipoProyecto` float NOT NULL,
  `precioUnitario` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoFactura`),
  UNIQUE KEY `codigoFactura_UNIQUE` (`codigoFactura`),
  UNIQUE KEY `codigoEstado_UNIQUE` (`codigoEstado`),
  UNIQUE KEY `codigoProducto_UNIQUE` (`codigoProducto`),
  CONSTRAINT `codigoEstadoDetalleFactura` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoFacturaDetalleFactura` FOREIGN KEY (`codigoFactura`) REFERENCES `facturas` (`codigoFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProductoDetalleFactura` FOREIGN KEY (`codigoProducto`) REFERENCES `productos` (`codigoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallefactura`
--

LOCK TABLES `detallefactura` WRITE;
/*!40000 ALTER TABLE `detallefactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallefactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleordencompra`
--

DROP TABLE IF EXISTS `detalleordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleordencompra` (
  `codigoOrdenCompra` int(11) NOT NULL,
  `codigoMaterial` int(11) NOT NULL,
  `cantidadMaterial` int(11) NOT NULL,
  PRIMARY KEY (`codigoOrdenCompra`,`codigoMaterial`),
  KEY `codigoMaterial_idx` (`codigoMaterial`),
  CONSTRAINT `codigoMaterialDetalleOrdenCompra` FOREIGN KEY (`codigoMaterial`) REFERENCES `materiales` (`codigoMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoOrdenCompraDetalleOrdenCompra` FOREIGN KEY (`codigoOrdenCompra`) REFERENCES `ordencompras` (`codigoOrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleordencompra`
--

LOCK TABLES `detalleordencompra` WRITE;
/*!40000 ALTER TABLE `detalleordencompra` DISABLE KEYS */;
INSERT INTO `detalleordencompra` VALUES (1,1,22),(2,1,2);
/*!40000 ALTER TABLE `detalleordencompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleproyecto`
--

DROP TABLE IF EXISTS `detalleproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleproyecto` (
  `codigoProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEstado` int(11) NOT NULL,
  `codigoProducto` int(11) NOT NULL,
  `precioUnitario` float NOT NULL,
  `planos` blob,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoProyecto`),
  UNIQUE KEY `codigoProyecto_UNIQUE` (`codigoProyecto`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  KEY `codigoProducto_idx` (`codigoProducto`),
  CONSTRAINT `codigoEstadoDetalleProyectos` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProductoDetalleProyectos` FOREIGN KEY (`codigoProducto`) REFERENCES `productos` (`codigoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProyectoDetalleProyectos` FOREIGN KEY (`codigoProyecto`) REFERENCES `proyectos` (`codigoProyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleproyecto`
--

LOCK TABLES `detalleproyecto` WRITE;
/*!40000 ALTER TABLE `detalleproyecto` DISABLE KEYS */;
INSERT INTO `detalleproyecto` VALUES (1,6,1,6,NULL,5,'Sillas moradas'),(2,6,3,200,NULL,4,'4 modulos rojos	'),(3,6,1,7,NULL,6,'dfvdf	'),(4,6,1,200,NULL,2,'hh'),(5,6,1,4,NULL,4,'Sillas amarillas	'),(6,6,1,3,NULL,3,'Sillas amarillas	'),(7,6,1,3,NULL,3,'dfgfdg	'),(8,6,1,2,NULL,23,'sdfsdf	'),(9,6,1,2,NULL,2,'dfsgdsgsd	'),(10,6,1,3,NULL,34,'fgfdg	');
/*!40000 ALTER TABLE `detalleproyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `codigoEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(45) NOT NULL,
  `nombreEmpleado` varchar(45) NOT NULL,
  `apellidosEmpleado` varchar(45) NOT NULL,
  `telefonoEmpleado` varchar(15) NOT NULL,
  `correoElectronico` varchar(45) NOT NULL,
  `direccionEmpleado` varchar(150) NOT NULL,
  `nombreUsuario` varchar(45) NOT NULL,
  `claveUsuario` varchar(45) NOT NULL,
  `codigoPuesto` int(11) NOT NULL,
  `codigoEstado` int(11) NOT NULL,
  `intentos` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigoEmpleado`),
  UNIQUE KEY `codigoEmpleado_UNIQUE` (`codigoEmpleado`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  KEY `codigoPuesto_idx` (`codigoPuesto`),
  CONSTRAINT `codigoEstadoEmpleados` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoPuestoEmpleados` FOREIGN KEY (`codigoPuesto`) REFERENCES `puestos` (`codigoPuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'0801199601477','Dilcia','Cruz','32456789','drosycruz@gmail.com','Col. 3 de Mayo','admin','25f9e794323b453885f5181f1b624db',1,1,0);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `codigoEstado` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionEstado` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoEstado`),
  UNIQUE KEY `codigoEstado_UNIQUE` (`codigoEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Habilitado'),(2,'Bloqueado'),(3,'Primer Login'),(4,'Inhabilitado'),(5,'En Proceso'),(6,'Aceptado'),(7,'Rechazado'),(8,'Terminado'),(9,'Entregado'),(10,'Existente'),(11,'No Existente'),(12,'Reservado'),(13,'Medicion'),(14,'Inicio'),(15,'Terminacion'),(16,'Saldo Anticipo'),(17,'Pago Canccelado');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturas` (
  `codigoFactura` int(11) NOT NULL AUTO_INCREMENT,
  `fechaEmisionFactura` date DEFAULT NULL,
  `impuesto` float DEFAULT NULL,
  `codigoTipoPago` int(11) DEFAULT NULL,
  `codigoEmpleado` int(11) DEFAULT NULL,
  `codigoEstado` int(11) DEFAULT NULL,
  `codigoCliente` int(11) NOT NULL,
  PRIMARY KEY (`codigoFactura`),
  UNIQUE KEY `codigoFactura_UNIQUE` (`codigoFactura`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  KEY `codigoTipoPago_idx` (`codigoTipoPago`),
  KEY `codigoCliente_idx` (`codigoCliente`),
  KEY `codigoEmpleadoFactura_idx` (`codigoEmpleado`),
  CONSTRAINT `codigoClienteFactura` FOREIGN KEY (`codigoCliente`) REFERENCES `clientes` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoEmpleadoFactura` FOREIGN KEY (`codigoEmpleado`) REFERENCES `empleados` (`codigoEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoEstadoFactura` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoTipoPagoFactura` FOREIGN KEY (`codigoTipoPago`) REFERENCES `tipopagos` (`codigoTipoPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,NULL,NULL,NULL,NULL,NULL,1),(2,NULL,NULL,NULL,NULL,NULL,1),(3,NULL,NULL,NULL,NULL,NULL,1),(4,NULL,NULL,NULL,NULL,NULL,1),(5,NULL,NULL,NULL,NULL,NULL,1),(6,NULL,NULL,NULL,NULL,NULL,1),(7,NULL,NULL,NULL,NULL,NULL,1),(8,NULL,NULL,NULL,NULL,NULL,1),(9,NULL,NULL,NULL,NULL,NULL,1),(10,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identificaciones`
--

DROP TABLE IF EXISTS `identificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identificaciones` (
  `codigoIdentificacion` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEstado` int(11) NOT NULL,
  `descripcionIdentificacion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoIdentificacion`),
  UNIQUE KEY `codigoIdentificacion_UNIQUE` (`codigoIdentificacion`),
  KEY `codigoEstadoIdentificaciones` (`codigoEstado`),
  CONSTRAINT `codigoEstadoIdentificaciones` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identificaciones`
--

LOCK TABLES `identificaciones` WRITE;
/*!40000 ALTER TABLE `identificaciones` DISABLE KEYS */;
INSERT INTO `identificaciones` VALUES (1,1,'Identidad'),(2,1,'Pasaporte'),(3,1,'RTN');
/*!40000 ALTER TABLE `identificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `codigoMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fechaMovimiento` datetime NOT NULL,
  `cantidad` int(11) NOT NULL,
  `codigoProyecto` int(11) DEFAULT NULL,
  `codigoTipoMovimiento` int(11) NOT NULL,
  `codigoMaterial` int(11) NOT NULL,
  PRIMARY KEY (`codigoMovimiento`),
  KEY `codigoProyecto_idx` (`codigoProyecto`),
  KEY `codigoTipoMovimiento_idx` (`codigoTipoMovimiento`),
  KEY `codigoMaterialInventario_idx` (`codigoMaterial`),
  CONSTRAINT `codigoMaterialInventario` FOREIGN KEY (`codigoMaterial`) REFERENCES `materiales` (`codigoMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProyectoInventario` FOREIGN KEY (`codigoProyecto`) REFERENCES `proyectos` (`codigoProyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoTipoMovimientoInventario` FOREIGN KEY (`codigoTipoMovimiento`) REFERENCES `tipomovimientos` (`codigoTipoMovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiales` (
  `codigoMaterial` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEstado` int(11) NOT NULL,
  `descripcionMaterial` varchar(45) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `reOrden` int(11) NOT NULL,
  PRIMARY KEY (`codigoMaterial`),
  UNIQUE KEY `codigoInventario_UNIQUE` (`codigoMaterial`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  CONSTRAINT `codigoEstadoMateriales` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiales`
--

LOCK TABLES `materiales` WRITE;
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` VALUES (1,10,'Clavos',20,5),(2,11,'Clavos',-1,15);
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mueblesmateriales`
--

DROP TABLE IF EXISTS `mueblesmateriales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mueblesmateriales` (
  `codigoProyecto` int(11) NOT NULL,
  `codigoMaterial` int(11) NOT NULL,
  `codigoProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigoProyecto`,`codigoMaterial`,`codigoProducto`),
  KEY `codigoProducto_idx` (`codigoProducto`),
  KEY `codigoMaterial_idx` (`codigoMaterial`),
  CONSTRAINT `codigoMaterialMueblesMateriales` FOREIGN KEY (`codigoMaterial`) REFERENCES `materiales` (`codigoMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProductoMueblesMateriales` FOREIGN KEY (`codigoProducto`) REFERENCES `productos` (`codigoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProyectoMueblesMateriales` FOREIGN KEY (`codigoProyecto`) REFERENCES `proyectos` (`codigoProyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mueblesmateriales`
--

LOCK TABLES `mueblesmateriales` WRITE;
/*!40000 ALTER TABLE `mueblesmateriales` DISABLE KEYS */;
INSERT INTO `mueblesmateriales` VALUES (1,1,1,10),(1,1,2,3),(2,1,2,45),(3,1,2,56),(4,1,2,5),(5,1,2,56),(6,1,1,56),(7,1,1,6),(8,1,1,45),(9,1,1,56),(10,1,1,1000);
/*!40000 ALTER TABLE `mueblesmateriales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordencompras`
--

DROP TABLE IF EXISTS `ordencompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordencompras` (
  `codigoOrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `fechaEmisionOrdenCompra` date NOT NULL,
  `codigoProveedor` int(11) NOT NULL,
  `codigoEmpleado` int(11) NOT NULL,
  `codigoEstado` int(11) NOT NULL,
  PRIMARY KEY (`codigoOrdenCompra`),
  UNIQUE KEY `codigoOrdenCompra_UNIQUE` (`codigoOrdenCompra`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  KEY `codigoProveedor_idx` (`codigoProveedor`),
  KEY `codigoEmpleadoOrdenCompra_idx` (`codigoEmpleado`),
  CONSTRAINT `codigoEmpleadoOrdenCompra` FOREIGN KEY (`codigoEmpleado`) REFERENCES `empleados` (`codigoEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoEstadoOrdenCompra` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoProveedorOrdenCompra` FOREIGN KEY (`codigoProveedor`) REFERENCES `proveedores` (`codigoProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompras`
--

LOCK TABLES `ordencompras` WRITE;
/*!40000 ALTER TABLE `ordencompras` DISABLE KEYS */;
INSERT INTO `ordencompras` VALUES (1,'2017-04-08',1,1,5),(2,'2017-05-15',1,1,5);
/*!40000 ALTER TABLE `ordencompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros` (
  `codigoParametro` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionParametro` varchar(45) NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`codigoParametro`),
  UNIQUE KEY `codigoParametro_UNIQUE` (`codigoParametro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` VALUES (1,'Impuesto sobre ventas',0.15),(2,'Vigencia cotizacion',15);
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `codigoProducto` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEstado` int(11) NOT NULL,
  `descripcionProducto` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoProducto`),
  UNIQUE KEY `codigoProducto_UNIQUE` (`codigoProducto`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  CONSTRAINT `codigoEstadoProductos` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,12,'Sillas'),(2,11,'Mesas'),(3,10,'Modulos'),(4,10,'Sillas');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `codigoProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombreProveedor` varchar(45) NOT NULL,
  `codigoEstado` int(11) NOT NULL,
  PRIMARY KEY (`codigoProveedor`),
  UNIQUE KEY `codigoProveedor_UNIQUE` (`codigoProveedor`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  CONSTRAINT `codigoEstadoProveedores` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Larach & Cia',1),(2,'Multipaneles',1),(3,'La Mundial',1);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyectos` (
  `codigoProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `codigoCliente` int(11) NOT NULL,
  `codigoEstado` int(11) DEFAULT '6',
  `descripcionProyecto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigoProyecto`),
  UNIQUE KEY `codigoProyecto_UNIQUE` (`codigoProyecto`),
  KEY `codigoCliente_idx` (`codigoCliente`),
  KEY `codigoEstado_idx` (`codigoEstado`),
  CONSTRAINT `codigoClienteProyectos` FOREIGN KEY (`codigoCliente`) REFERENCES `clientes` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoEstadoProyectos` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,1,6,NULL),(2,1,6,NULL),(3,1,6,NULL),(4,1,6,NULL),(5,1,6,NULL),(6,1,6,NULL),(7,1,6,NULL),(8,1,6,NULL),(9,1,6,NULL),(10,1,6,NULL);
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puestos`
--

DROP TABLE IF EXISTS `puestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puestos` (
  `codigoPuesto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionPuesto` varchar(45) NOT NULL,
  `codigoEstado` int(11) NOT NULL,
  PRIMARY KEY (`codigoPuesto`),
  UNIQUE KEY `codigoPuesto_UNIQUE` (`codigoPuesto`),
  KEY `codigoEstadoPuestos_idx` (`codigoEstado`),
  CONSTRAINT `codigoEstadoPuestos` FOREIGN KEY (`codigoEstado`) REFERENCES `estados` (`codigoEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puestos`
--

LOCK TABLES `puestos` WRITE;
/*!40000 ALTER TABLE `puestos` DISABLE KEYS */;
INSERT INTO `puestos` VALUES (1,'Administrador',1),(2,'Vendedor',1),(3,'Encargado de Bodega',1);
/*!40000 ALTER TABLE `puestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomovimientos`
--

DROP TABLE IF EXISTS `tipomovimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipomovimientos` (
  `codigoTipoMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionMovimiento` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoTipoMovimiento`),
  UNIQUE KEY `codigoTipoMovimiento_UNIQUE` (`codigoTipoMovimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomovimientos`
--

LOCK TABLES `tipomovimientos` WRITE;
/*!40000 ALTER TABLE `tipomovimientos` DISABLE KEYS */;
INSERT INTO `tipomovimientos` VALUES (1,'Nuevo'),(2,'Entrada'),(3,'Salida');
/*!40000 ALTER TABLE `tipomovimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopagos`
--

DROP TABLE IF EXISTS `tipopagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopagos` (
  `codigoTipoPago` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionTipoPago` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoTipoPago`),
  UNIQUE KEY `codigoTipoPago_UNIQUE` (`codigoTipoPago`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopagos`
--

LOCK TABLES `tipopagos` WRITE;
/*!40000 ALTER TABLE `tipopagos` DISABLE KEYS */;
INSERT INTO `tipopagos` VALUES (1,'Tarjeta Credito'),(2,'Efectivo');
/*!40000 ALTER TABLE `tipopagos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-17 15:36:21
