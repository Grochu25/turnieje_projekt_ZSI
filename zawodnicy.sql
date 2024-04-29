-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 04 Sty 2024, 21:46
-- Wersja serwera: 10.4.8-MariaDB
-- Wersja PHP: 7.2.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `zawodnicy`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zawodnicy`
--

CREATE TABLE `zawodnicy` (
  `ID` int(11) NOT NULL,
  `Imie` varchar(30) DEFAULT NULL,
  `Nazwisko` varchar(40) DEFAULT NULL,
  `DataUr` date DEFAULT NULL,
  `Plec` varchar(10) DEFAULT NULL,
  `Waga` int(11) DEFAULT NULL,
  `Punkty` int(11) DEFAULT NULL,
  `Kategoria` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `zawodnicy`
--

INSERT INTO `zawodnicy` (`ID`, `Imie`, `Nazwisko`, `DataUr`, `Plec`, `Waga`, `Punkty`, `Kategoria`) VALUES
(1, 'Malwina', 'Kaznowski', '1997-01-24', 'K', 99, 15, 'SNR'),
(2, 'Sara', 'Fikus', '1999-12-21', 'K', 70, 21, 'U21'),
(3, 'Jakub', 'Konieczko', '1996-12-19', 'M', 93, 10, 'SNR'),
(4, 'Elżbieta', 'Damboń', '1998-06-02', 'K', 89, 21, 'SNR'),
(5, 'Sofia', 'Semik', '2001-08-14', 'K', 82, 3, 'SNR'),
(6, 'Karina', 'Imieliński', '1997-01-10', 'K', 67, 29, 'U21'),
(7, 'Natasza', 'Walicki', '2002-12-19', 'K', 46, 9, 'SNR'),
(8, 'Dagmara', 'Mioduszewski', '2000-11-26', 'K', 77, 6, 'SNR'),
(9, 'Mieszko', 'Sembratowicz', '2001-06-28', 'M', 86, 14, 'U21'),
(10, 'Gracjan', 'Ochab', '1994-07-25', 'M', 64, 1, 'SNR'),
(11, 'Władysław', 'Szulc', '1990-10-15', 'M', 94, 8, 'SNR'),
(12, 'Katarzyna', 'Strzoda', '2008-01-01', 'K', 62, 9, 'SNR'),
(13, 'Nataniel', 'Markiewicz', '2007-05-18', 'M', 81, 17, 'SNR'),
(14, 'Jaśmina', 'Jabłoński', '1993-11-01', 'K', 49, 24, 'U21'),
(15, 'Martyna', 'Mąkosza', '1994-04-14', 'K', 75, 14, 'U21'),
(16, 'Adrianna', 'Bieliński', '2000-09-06', 'K', 97, 7, 'U21'),
(17, 'Patryk', 'Białek', '1996-07-09', 'M', 93, 20, 'SNR'),
(18, 'Vanessa', 'Gombrowicz', '2001-10-25', 'K', 70, 8, 'SNR'),
(19, 'Natasza', 'Sembratowicz', '1990-08-19', 'K', 98, 19, 'U21'),
(20, 'Grzegorz', 'Klimek', '2000-09-30', 'M', 62, 10, 'SNR'),
(21, 'Feliks', 'Kot', '1990-04-07', 'M', 72, 17, 'SNR'),
(22, 'Nela', 'Abramczyk', '1991-01-12', 'K', 47, 9, 'SNR'),
(23, 'Władysław', 'Krasiński', '2005-05-05', 'M', 73, 3, 'U21'),
(24, 'Oskar', 'Paziński', '1991-03-16', 'M', 57, 15, 'SNR'),
(25, 'Bartłomiej', 'Bury', '2007-05-04', 'M', 75, 25, 'U21'),
(26, 'Paweł', 'Grochowiak', '2006-10-29', 'M', 91, 6, 'U21'),
(27, 'Norbert', 'Pietsch', '2004-05-30', 'M', 59, 0, 'U21'),
(28, 'Gracjan', 'Siciński', '2005-02-28', 'M', 98, 17, 'U21'),
(29, 'Krystian', 'Wójcicki', '2003-09-04', 'M', 81, 14, 'SNR'),
(30, 'Patryk', 'Paszewski', '2005-07-22', 'M', 64, 8, 'U21'),
(31, 'Tomasz', 'Rafalski', '1996-10-18', 'M', 98, 8, 'U21'),
(32, 'Martyna', 'Frątczak', '2000-02-03', 'K', 53, 18, 'SNR'),
(33, 'Wojciech', 'Betlej', '1992-07-20', 'M', 70, 17, 'SNR'),
(34, 'Grzegorz', 'Przewalski', '1999-07-19', 'M', 49, 28, 'SNR'),
(35, 'Nataniel', 'Glinka', '1996-03-01', 'M', 53, 23, 'U21'),
(36, 'Mateusz', 'Rączkowski', '1995-07-26', 'M', 72, 5, 'SNR'),
(37, 'Arkadiusz', 'Kaczmarek', '2004-08-11', 'M', 75, 11, 'SNR'),
(38, 'Cezary', 'Adamowski', '2001-07-10', 'M', 68, 6, 'U21'),
(39, 'Jędrzej', 'Musiał', '1999-04-06', 'M', 66, 12, 'U21'),
(40, 'Marianna', 'Breza', '2007-09-08', 'K', 50, 20, 'U21'),
(41, 'Roksana', 'Łuczak', '2002-03-28', 'K', 69, 16, 'U21'),
(42, 'Melania', 'Rudnicki', '1994-09-20', 'K', 90, 24, 'SNR'),
(43, 'Lilia', 'Hrycyk', '1998-10-13', 'K', 88, 21, 'SNR'),
(44, 'Wiktor', 'Paszkiewicz', '1997-12-17', 'M', 79, 14, 'SNR'),
(45, 'Kamil', 'Antos', '2006-03-31', 'M', 90, 29, 'U21'),
(46, 'Antonina', 'Sikora', '2008-01-01', 'K', 87, 7, 'SNR'),
(47, 'Alina', 'Chudziński', '1996-07-12', 'K', 71, 1, 'U21'),
(48, 'Emilia', 'Ryś', '2006-01-26', 'K', 88, 10, 'U21'),
(49, 'Stefania', 'Zawiślak', '2004-06-26', 'K', 66, 0, 'U21'),
(50, 'Adrianna', 'Zarzecki', '1993-07-22', 'K', 47, 14, 'U21'),
(51, 'Ludwik', 'Pohorecki', '1992-12-19', 'M', 82, 23, 'SNR'),
(52, 'Józef', 'Giedroyć', '2007-07-25', 'M', 45, 25, 'U21'),
(53, 'Władysław', 'Paluszkiewicz', '1996-08-13', 'M', 67, 16, 'SNR'),
(54, 'Aleks', 'Siatkowski', '1999-07-09', 'M', 55, 10, 'SNR'),
(55, 'Witold', 'Kaczor', '1990-06-13', 'M', 87, 25, 'U21'),
(56, 'Eryk', 'Andrzejewski', '1995-06-10', 'M', 50, 4, 'SNR'),
(57, 'Franciszek', 'Obrębscy', '2006-11-02', 'M', 87, 20, 'SNR'),
(58, 'Łucja', 'Siciński', '1991-02-26', 'K', 57, 3, 'SNR'),
(59, 'Natan', 'Rutowicz', '1995-04-04', 'M', 78, 14, 'U21'),
(60, 'Stefan', 'Komornicki', '1999-06-25', 'M', 51, 1, 'SNR'),
(61, 'Feliks', 'Kaznowski', '1994-04-03', 'M', 67, 14, 'U21'),
(62, 'Alan', 'Knothe', '2004-08-24', 'M', 50, 17, 'SNR'),
(63, 'Emil', 'Stachyra', '1996-10-31', 'M', 98, 6, 'U21'),
(64, 'Tymoteusz', 'Drzewiecki', '2002-03-04', 'M', 84, 12, 'SNR'),
(65, 'Kalina', 'Romanowicz', '2008-01-01', 'K', 45, 24, 'U21'),
(66, 'Rafał', 'Popkiewicz', '1995-01-10', 'M', 82, 23, 'SNR'),
(67, 'Marlena', 'Dyrczowie', '2006-08-15', 'K', 50, 5, 'SNR'),
(68, 'Barbara', 'Smolarek', '2004-05-30', 'K', 99, 17, 'SNR'),
(69, 'Lidia', 'Dołęga-Zakrzewski', '1995-06-16', 'K', 78, 7, 'U21'),
(70, 'Nela', 'Grądzki', '1999-10-09', 'K', 96, 11, 'U21'),
(71, 'Marlena', 'Olechnowicz', '2001-11-27', 'K', 71, 15, 'SNR'),
(72, 'Emil', 'Sytek', '1996-01-11', 'M', 87, 1, 'U21'),
(73, 'Daniel', 'Grocholski', '2000-10-15', 'M', 54, 24, 'SNR'),
(74, 'Bartosz', 'Kirchner', '2004-01-30', 'M', 51, 4, 'SNR'),
(75, 'Brajan', 'Garbowski', '2007-05-12', 'M', 85, 24, 'U21'),
(76, 'Laura', 'Janiszewski', '2008-01-01', 'K', 82, 12, 'U21'),
(77, 'Adam', 'Sopoćko', '2004-04-02', 'M', 74, 19, 'SNR'),
(78, 'Gabriel', 'Murawski', '1999-04-07', 'M', 47, 5, 'U21'),
(79, 'Konstanty', 'Baj', '2005-08-01', 'M', 81, 2, 'U21'),
(80, 'Antonina', 'Giedroyć', '2001-07-12', 'K', 47, 9, 'SNR'),
(81, 'Mia', 'Ignatowicz', '2004-08-17', 'K', 57, 27, 'SNR'),
(82, 'Ignacy', 'Imieliński', '1994-06-12', 'M', 82, 26, 'U21'),
(83, 'Jagna', 'Marcol', '1997-03-28', 'K', 80, 24, 'SNR'),
(84, 'Stanisław', 'Gogolewski', '1991-06-20', 'M', 87, 5, 'SNR'),
(85, 'Melania', 'Gryga', '1993-10-06', 'K', 46, 12, 'SNR'),
(86, 'Leonard', 'Gołębiewski', '1992-07-20', 'M', 54, 24, 'SNR'),
(87, 'Artur', 'Kaczor', '2007-02-09', 'M', 90, 3, 'U21'),
(88, 'Kacper', 'Dołęga-Zakrzewski', '2007-06-30', 'M', 67, 18, 'SNR'),
(89, 'Agata', 'Knothe', '2002-03-21', 'K', 48, 22, 'U21'),
(90, 'Liliana', 'Alexandrowicz', '2001-07-12', 'K', 84, 17, 'U21'),
(91, 'Inga', 'Janicki', '2003-01-13', 'K', 90, 18, 'SNR'),
(92, 'Norbert', 'Korczyński', '2008-01-01', 'M', 96, 22, 'U21'),
(93, 'Robert', 'Grocholski', '1992-06-22', 'M', 59, 23, 'SNR'),
(94, 'Ignacy', 'Wachowicz', '1998-06-06', 'M', 75, 16, 'U21'),
(95, 'Marek', 'Kiełbasa', '1998-08-28', 'M', 62, 7, 'SNR'),
(96, 'Emma', 'Aleksandrowicz', '2004-02-08', 'K', 75, 16, 'U21'),
(97, 'Gracjan', 'Szczytko', '1996-06-22', 'M', 50, 22, 'SNR'),
(98, 'Nina', 'Lewandowski', '2003-05-22', 'K', 75, 14, 'U21'),
(99, 'Maria', 'Grocholski', '2006-03-29', 'K', 98, 6, 'SNR'),
(100, 'Alex', 'Damboń', '1998-06-02', 'M', 53, 29, 'U21');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `zawodnicy`
--
ALTER TABLE `zawodnicy`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `zawodnicy`
--
ALTER TABLE `zawodnicy`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
