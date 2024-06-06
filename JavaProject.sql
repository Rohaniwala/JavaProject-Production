-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 06, 2024 at 08:01 PM
-- Server version: 10.6.16-MariaDB-0ubuntu0.22.04.1
-- PHP Version: 8.1.2-1ubuntu2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `JavaProject`
--

-- --------------------------------------------------------

--
-- Table structure for table `BillingTB`
--

CREATE TABLE `BillingTB` (
  `BillID` int(11) NOT NULL,
  `OrderID` int(11) NOT NULL,
  `BillDate` varchar(255) NOT NULL,
  `DeliveryDate` varchar(255) NOT NULL,
  `TotalPrice` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `BillingTB`
--

INSERT INTO `BillingTB` (`BillID`, `OrderID`, `BillDate`, `DeliveryDate`, `TotalPrice`) VALUES
(1, 2, '18/04/2024 22:23:44', '18/04/2024 22:23:44', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `CartTB`
--

CREATE TABLE `CartTB` (
  `CartID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `CompanyTB`
--

CREATE TABLE `CompanyTB` (
  `CompanyID` int(11) NOT NULL,
  `Companyname` varchar(255) NOT NULL,
  `Companydescription` varchar(255) NOT NULL,
  `Contactno` varchar(255) NOT NULL,
  `Companyemail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `CompanyTB`
--

INSERT INTO `CompanyTB` (`CompanyID`, `Companyname`, `Companydescription`, `Contactno`, `Companyemail`) VALUES
(1, 'RV', 'for clothing', '9685456985', 'rv@gmail.com'),
(2, 'srushti', 'srushti ni company', '7894563152', 's@gmail.com'),
(8, 'SR', 'Sagar Rajesh', '9988774455', 'sgr@gmail.com'),
(18, 'Binal', 'For Phones', '8852634178', 'abcd@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `ImagemasterTB`
--

CREATE TABLE `ImagemasterTB` (
  `ImageID` int(11) NOT NULL,
  `Imageurl` varchar(255) NOT NULL,
  `ReferenceID` int(11) NOT NULL,
  `Referencename` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `OrderDetailsTB`
--

CREATE TABLE `OrderDetailsTB` (
  `OdetailsID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `OrderID` int(11) NOT NULL,
  `CustomizeImage` varchar(255) NOT NULL,
  `Customizetext` varchar(255) NOT NULL,
  `Orderdate` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `OrderTB`
--

CREATE TABLE `OrderTB` (
  `OrderID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `OrderStatus` varchar(255) NOT NULL,
  `Orderdate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `OrderTB`
--

INSERT INTO `OrderTB` (`OrderID`, `UserID`, `OrderStatus`, `Orderdate`) VALUES
(2, 1, 'Canceled', '2024-04-18T16:49:35.057277'),
(3, 1, 'Ordered', '18/04/2024 16:55:18'),
(4, 1, 'Ordered', '18/04/2024 20:52:32');

-- --------------------------------------------------------

--
-- Table structure for table `OrderTrackingTB`
--

CREATE TABLE `OrderTrackingTB` (
  `OrdertrackID` int(11) NOT NULL,
  `OrderdetailsID` int(11) NOT NULL,
  `StageID` int(11) NOT NULL,
  `Place` varchar(255) NOT NULL,
  `StartingDate` varchar(255) NOT NULL,
  `EndingDate` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ProductCategoryTB`
--

CREATE TABLE `ProductCategoryTB` (
  `PcatID` int(11) NOT NULL,
  `Pcatname` varchar(255) NOT NULL,
  `Pcatdescription` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ProductCategoryTB`
--

INSERT INTO `ProductCategoryTB` (`PcatID`, `Pcatname`, `Pcatdescription`) VALUES
(1, 'Cloths', 'For men and women'),
(2, 'Electronic', 'forgenraluse');

-- --------------------------------------------------------

--
-- Table structure for table `productTB`
--

CREATE TABLE `productTB` (
  `productID` int(11) NOT NULL,
  `productname` varchar(255) NOT NULL,
  `pcatID` int(11) NOT NULL,
  `productdescription` varchar(255) NOT NULL,
  `productprice` float NOT NULL,
  `productimage` varchar(255) NOT NULL,
  `isimageinclude` tinyint(1) NOT NULL,
  `istextinclude` tinyint(1) NOT NULL,
  `companyID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `productTB`
--

INSERT INTO `productTB` (`productID`, `productname`, `pcatID`, `productdescription`, `productprice`, `productimage`, `isimageinclude`, `istextinclude`, `companyID`, `quantity`) VALUES
(39, 'T-shirt', 1, 'for Men', 4000, '7.jpg', 0, 0, 1, 40),
(40, 'jeans', 1, 'For men', 8000, '8.jpg', 1, 1, 2, 10),
(44, 'Kurta', 1, 'For Men', 5000, '15.jpg', 0, 0, 1, 4),
(45, 'sari', 1, 'foe women', 7000, '17.jpg', 1, 0, 2, 10),
(47, 'galaxy', 1, 'samsung phone', 1000000, '17.jpg', 0, 0, 1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `RelationTB`
--

CREATE TABLE `RelationTB` (
  `RelationID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `CompanyID` int(11) NOT NULL,
  `RoleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `RoleTB`
--

CREATE TABLE `RoleTB` (
  `RoleID` int(11) NOT NULL,
  `Rolename` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `RoleTB`
--

INSERT INTO `RoleTB` (`RoleID`, `Rolename`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `StagemasterTB`
--

CREATE TABLE `StagemasterTB` (
  `StageID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Stagename` varchar(255) NOT NULL,
  `Stagedescription` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `UserTB`
--

CREATE TABLE `UserTB` (
  `UserID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Useremail` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `RoleID` int(11) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `DOB` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Mobileno` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `UserTB`
--

INSERT INTO `UserTB` (`UserID`, `Username`, `Useremail`, `Password`, `RoleID`, `Gender`, `DOB`, `Address`, `Mobileno`) VALUES
(1, 'abxcd', 'sgcv@gmail.com', 'PBKDF2WithHmacSHA256:2048:b0TrD9Q5w7ILPf+Rq6lbNrlKSJhEFRRgdTe7v/WMDRM=:F32keogVMe4BFkYPTK77gSLpzQvdu08CdJ46EXRI6XE=', 2, 'Male', '2-12-2000', 'surat', '7894561235'),
(2, 'rohan', 'rohan123@gmail.com', 'PBKDF2WithHmacSHA256:2048:b0TrD9Q5w7ILPf+Rq6lbNrlKSJhEFRRgdTe7v/WMDRM=:F32keogVMe4BFkYPTK77gSLpzQvdu08CdJ46EXRI6XE=', 2, 'Male', '3-11-2002', 'udhana', '7894561235'),
(3, 'admin', 'admin@123@gmail.com', 'PBKDF2WithHmacSHA256:2048:Cu/0JpeS+yt/VrytKeGHYIuutHqgeFzUWTEU3tb82bQ=:jq+fWURHTWz21P6eOeG2wwKI3aeJHRWD4qRdxjOk8hM=', 1, 'Male', '7-8-1999', 'Daman', '1234569875'),
(4, 'yug', 'yug@123@gmail.com', 'PBKDF2WithHmacSHA256:2048:w1PXVAw8bbVk2Lu3UqSwcUAAynyXwQQeYHPzxSYUhNk=:IWzHVuO8sOQ7f8/mhFAfdbtvIT3fBbTrfeSmpOqTMg4=', 2, 'Male', '7-12-2003', 'Adajan', '4569871235'),
(5, 'znj', 'x ', 'PBKDF2WithHmacSHA256:2048:I/Q2VPZuxChsZ/UyqV9cwuOel1Wu8dQ/IJqj2xqRUGE=:hpQ9Ua8VE8tBkJ4O+eE2iuPLn8G4B4fZpodfrpkQhGI=', 2, 'b', 'n ', 'hnb', '656'),
(6, 'sa', 'sac', 'PBKDF2WithHmacSHA256:2048:0eGbypq4yOLidiUtFPcffYWcuTVA5mY5Ctwr3edWZaw=:W7mdsjJlrROOxwa3T/ddwMSFaYzlsnytwEnPFUboAAM=', 2, 'sa', 'sa', 'sa', '854'),
(7, 'vikas', 'vikas@gmail.com', 'PBKDF2WithHmacSHA256:2048:k8SONl870LlC7qIWviDD3uXEGswLWTzqMBCCQmtlNIs=:vS+A9epRx0T+BP7cWr/82bfFnw7xK6EF1vEogjbjhwA=', 2, 'Male', '7-8-9000', 'kat', '1256348975'),
(8, 'sakshi', 'sakshi@gmail.com', 'PBKDF2WithHmacSHA256:2048:KQLAmmZtZnVicDzhoyWoBvUyqXlxOIuDzMGi6KWYkoE=:b+QbDzaqX/vYQ0jZlUeM+BWMGj9ONlIQ8QnU1C+axwo=', 2, 'Female', '2024-05-08', 'adajan', '1236547895');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `BillingTB`
--
ALTER TABLE `BillingTB`
  ADD PRIMARY KEY (`BillID`),
  ADD KEY `fkorder1` (`OrderID`);

--
-- Indexes for table `CartTB`
--
ALTER TABLE `CartTB`
  ADD PRIMARY KEY (`CartID`),
  ADD KEY `fkuser` (`UserID`),
  ADD KEY `fkproduct` (`ProductID`);

--
-- Indexes for table `CompanyTB`
--
ALTER TABLE `CompanyTB`
  ADD PRIMARY KEY (`CompanyID`);

--
-- Indexes for table `ImagemasterTB`
--
ALTER TABLE `ImagemasterTB`
  ADD PRIMARY KEY (`ImageID`);

--
-- Indexes for table `OrderDetailsTB`
--
ALTER TABLE `OrderDetailsTB`
  ADD PRIMARY KEY (`OdetailsID`),
  ADD KEY `fkprod1` (`ProductID`),
  ADD KEY `fkordertrack` (`OrderID`);

--
-- Indexes for table `OrderTB`
--
ALTER TABLE `OrderTB`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `fkuser1` (`UserID`);

--
-- Indexes for table `OrderTrackingTB`
--
ALTER TABLE `OrderTrackingTB`
  ADD PRIMARY KEY (`OrdertrackID`),
  ADD KEY `fkstage` (`StageID`),
  ADD KEY `fkorderdetails` (`OrderdetailsID`);

--
-- Indexes for table `ProductCategoryTB`
--
ALTER TABLE `ProductCategoryTB`
  ADD PRIMARY KEY (`PcatID`);

--
-- Indexes for table `productTB`
--
ALTER TABLE `productTB`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `fkcomproduct` (`companyID`),
  ADD KEY `fkcatprod` (`pcatID`);

--
-- Indexes for table `RelationTB`
--
ALTER TABLE `RelationTB`
  ADD PRIMARY KEY (`RelationID`),
  ADD KEY `fkuserid` (`UserID`),
  ADD KEY `fkcompany` (`CompanyID`),
  ADD KEY `fkrolerel` (`RoleID`);

--
-- Indexes for table `RoleTB`
--
ALTER TABLE `RoleTB`
  ADD PRIMARY KEY (`RoleID`);

--
-- Indexes for table `StagemasterTB`
--
ALTER TABLE `StagemasterTB`
  ADD PRIMARY KEY (`StageID`),
  ADD KEY `fkprod` (`ProductID`);

--
-- Indexes for table `UserTB`
--
ALTER TABLE `UserTB`
  ADD PRIMARY KEY (`UserID`),
  ADD KEY `fkrole` (`RoleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `BillingTB`
--
ALTER TABLE `BillingTB`
  MODIFY `BillID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `CartTB`
--
ALTER TABLE `CartTB`
  MODIFY `CartID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `CompanyTB`
--
ALTER TABLE `CompanyTB`
  MODIFY `CompanyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `ImagemasterTB`
--
ALTER TABLE `ImagemasterTB`
  MODIFY `ImageID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `OrderDetailsTB`
--
ALTER TABLE `OrderDetailsTB`
  MODIFY `OdetailsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `OrderTB`
--
ALTER TABLE `OrderTB`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `OrderTrackingTB`
--
ALTER TABLE `OrderTrackingTB`
  MODIFY `OrdertrackID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `ProductCategoryTB`
--
ALTER TABLE `ProductCategoryTB`
  MODIFY `PcatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `productTB`
--
ALTER TABLE `productTB`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `RelationTB`
--
ALTER TABLE `RelationTB`
  MODIFY `RelationID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `RoleTB`
--
ALTER TABLE `RoleTB`
  MODIFY `RoleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `StagemasterTB`
--
ALTER TABLE `StagemasterTB`
  MODIFY `StageID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `UserTB`
--
ALTER TABLE `UserTB`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `BillingTB`
--
ALTER TABLE `BillingTB`
  ADD CONSTRAINT `fkorder1` FOREIGN KEY (`OrderID`) REFERENCES `OrderTB` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `CartTB`
--
ALTER TABLE `CartTB`
  ADD CONSTRAINT `fkproduct` FOREIGN KEY (`ProductID`) REFERENCES `productTB` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkuser` FOREIGN KEY (`UserID`) REFERENCES `UserTB` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `OrderDetailsTB`
--
ALTER TABLE `OrderDetailsTB`
  ADD CONSTRAINT `fkordertrack` FOREIGN KEY (`OrderID`) REFERENCES `OrderTB` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkprod1` FOREIGN KEY (`ProductID`) REFERENCES `productTB` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `OrderTB`
--
ALTER TABLE `OrderTB`
  ADD CONSTRAINT `fkuser1` FOREIGN KEY (`UserID`) REFERENCES `UserTB` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `OrderTrackingTB`
--
ALTER TABLE `OrderTrackingTB`
  ADD CONSTRAINT `fkorderdetails` FOREIGN KEY (`OrderdetailsID`) REFERENCES `OrderDetailsTB` (`OdetailsID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkstage` FOREIGN KEY (`StageID`) REFERENCES `StagemasterTB` (`StageID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productTB`
--
ALTER TABLE `productTB`
  ADD CONSTRAINT `fkcatprod` FOREIGN KEY (`pcatID`) REFERENCES `ProductCategoryTB` (`PcatID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkcomproduct` FOREIGN KEY (`companyID`) REFERENCES `CompanyTB` (`CompanyID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `RelationTB`
--
ALTER TABLE `RelationTB`
  ADD CONSTRAINT `fkcompany` FOREIGN KEY (`CompanyID`) REFERENCES `CompanyTB` (`CompanyID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkrolerel` FOREIGN KEY (`RoleID`) REFERENCES `RoleTB` (`RoleID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkuserid` FOREIGN KEY (`UserID`) REFERENCES `UserTB` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `StagemasterTB`
--
ALTER TABLE `StagemasterTB`
  ADD CONSTRAINT `fkprod` FOREIGN KEY (`ProductID`) REFERENCES `productTB` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `UserTB`
--
ALTER TABLE `UserTB`
  ADD CONSTRAINT `fkrole` FOREIGN KEY (`RoleID`) REFERENCES `RoleTB` (`RoleID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
