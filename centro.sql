-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2024 at 09:45 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `centro`
--

-- --------------------------------------------------------

--
-- Table structure for table `alumnos`
--

CREATE TABLE `alumnos` (
  `ID_Alumnos` int(11) NOT NULL,
  `Nombre_Alumnos` varchar(20) NOT NULL,
  `Apellido_Alumnos` text NOT NULL,
  `DNI_Alumnos` varchar(9) NOT NULL,
  `Telefono_Alumnos` int(9) NOT NULL,
  `ID_Centro` int(11) NOT NULL,
  `ID_Ciclo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `alumnos`
--

INSERT INTO `alumnos` (`ID_Alumnos`, `Nombre_Alumnos`, `Apellido_Alumnos`, `DNI_Alumnos`, `Telefono_Alumnos`, `ID_Centro`, `ID_Ciclo`) VALUES
(1, 'Joel ', 'Exposito Coutinho', '12345678A', 111111111, 1, 1),
(2, 'Diego', 'Casal Carballal', '12345678A', 222222222, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `asignaturas`
--

CREATE TABLE `asignaturas` (
  `ID_Asginaturas` int(11) NOT NULL,
  `Nombre_Asignaturas` varchar(50) NOT NULL,
  `NumeroHoras_Asignaturas` int(11) NOT NULL,
  `Descripcion_Asignaturas` varchar(3000) NOT NULL,
  `ID_Ciclo` int(11) NOT NULL,
  `ID_Docente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `asignaturas`
--

INSERT INTO `asignaturas` (`ID_Asginaturas`, `Nombre_Asignaturas`, `NumeroHoras_Asignaturas`, `Descripcion_Asignaturas`, `ID_Ciclo`, `ID_Docente`) VALUES
(1, 'Acceso a datos ', 200, 'Descripcion acceso a datos ', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `centro`
--

CREATE TABLE `centro` (
  `ID_Centro` int(11) NOT NULL,
  `Nombre_Centro` varchar(50) NOT NULL,
  `Telefono_Centro` int(9) NOT NULL,
  `Descripcion_Centro` varchar(2000) NOT NULL,
  `Direccion_Centro` varchar(100) NOT NULL,
  `ID_Ciclo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `centro`
--

INSERT INTO `centro` (`ID_Centro`, `Nombre_Centro`, `Telefono_Centro`, `Descripcion_Centro`, `Direccion_Centro`, `ID_Ciclo`) VALUES
(1, 'Campus Politecnico Aceimar', 986251511, 'Descipcion Campus Politecnico Aceimar', 'Av. da Ponte, 80, Cabral, 36318 Vigo, Pontevedra', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ciclos`
--

CREATE TABLE `ciclos` (
  `ID_Ciclos` int(11) NOT NULL,
  `Nombre_Ciclo` varchar(50) NOT NULL,
  `NumeroHoras_Ciclo` int(11) NOT NULL,
  `Descripcion_Ciclo` varchar(2000) NOT NULL,
  `ID_Centro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ciclos`
--

INSERT INTO `ciclos` (`ID_Ciclos`, `Nombre_Ciclo`, `NumeroHoras_Ciclo`, `Descripcion_Ciclo`, `ID_Centro`) VALUES
(1, 'Desarrollo de aplicaciones mutiplataforma DAM', 2000, 'Descripcion Desarrollo de aplicaciones mutiplataforma DAM', 1);

-- --------------------------------------------------------

--
-- Table structure for table `docentes`
--

CREATE TABLE `docentes` (
  `ID_Docentes` int(11) NOT NULL,
  `Nombre_Docentes` varchar(20) NOT NULL,
  `Apellido_Docentes` varchar(50) NOT NULL,
  `DNI_Docentes` varchar(9) NOT NULL,
  `Telefono_Docentes` int(9) NOT NULL,
  `ID_Centro` int(11) NOT NULL,
  `ID_Ciclo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `docentes`
--

INSERT INTO `docentes` (`ID_Docentes`, `Nombre_Docentes`, `Apellido_Docentes`, `DNI_Docentes`, `Telefono_Docentes`, `ID_Centro`, `ID_Ciclo`) VALUES
(1, 'Carlos', 'Comesaña', '12345678C', 333333333, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ID_Alumnos`),
  ADD KEY `ID_Centro` (`ID_Centro`),
  ADD KEY `ID_Ciclo` (`ID_Ciclo`);

--
-- Indexes for table `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`ID_Asginaturas`),
  ADD KEY `ID_Ciclo` (`ID_Ciclo`),
  ADD KEY `ID_Docente` (`ID_Docente`);

--
-- Indexes for table `centro`
--
ALTER TABLE `centro`
  ADD PRIMARY KEY (`ID_Centro`),
  ADD KEY `ID_Ciclo` (`ID_Ciclo`);

--
-- Indexes for table `ciclos`
--
ALTER TABLE `ciclos`
  ADD PRIMARY KEY (`ID_Ciclos`),
  ADD KEY `ID_Centro` (`ID_Centro`);

--
-- Indexes for table `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`ID_Docentes`),
  ADD KEY `ID_Centro` (`ID_Centro`),
  ADD KEY `ID_Ciclos` (`ID_Ciclo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `ID_Alumnos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `ID_Asginaturas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `centro`
--
ALTER TABLE `centro`
  MODIFY `ID_Centro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `ciclos`
--
ALTER TABLE `ciclos`
  MODIFY `ID_Ciclos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `docentes`
--
ALTER TABLE `docentes`
  MODIFY `ID_Docentes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
