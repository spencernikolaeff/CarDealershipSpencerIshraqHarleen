DROP DATABASE IF EXISTS CarDealership;

CREATE DATABASE CarDealership;

USE CarDealership;

CREATE TABLE Vehicle(
	vehicleId INT NOT NULL,
    make VARCHAR(25) NOT NULL,
    model VARCHAR(10) NOT NULL,
    isUsed BOOL NOT NULL,
    body VARCHAR(10) NOT NULL,
    vehicleYear TINYINT(4) NOT NULL,
    isManual BOOL NOT NULL,
    exteriorColor VARCHAR(12) NOT NULL,
    interiorColor VARCHAR(12) NOT NULL,
    mileage INT NOT NULL,
    vin VARCHAR(25) NOT NULL,
    msrp DECIMAL(9,2) NOT NULL,
    price DECIMAL(9,2) NOT NULL,
    vehicleDescription VARCHAR(200) NOT NULL,
    icon_url VARCHAR(200),
    inStock BOOL NOT NULL,
    PRIMARY KEY(vehicleId)
);

CREATE TABLE UserAccount (
	userId INT NOT NULL,
    firstName TEXT(25) NOT NULL,
    lastName TEXT(25) NOT NULL,
    email VARCHAR(60) NOT NULL,
    userPassword VARCHAR(25) NOT NULL,
    isAdmin BOOL NOT NULL,
    PRIMARY KEY(userId)
);

CREATE TABLE SalesAccount (
	salesId INT NOT NULL,
    totalSales DECIMAL(11,2) NOT NULL,
    totalVehiclesSold TINYINT NOT NULL,
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES UserAccount(userId),
    PRIMARY KEY (salesId)
);

CREATE TABLE CustomerAccount (
	customerId INT NOT NULL,
    phoneNumber VARCHAR(12) NOT NULL,
    street1 VARCHAR(30) NOT NULL,
    street2 VARCHAR(30),
    city VARCHAR(20) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zipcode INT(5) NOT NULL,
    userId INT NOT NULL,
    FOREIGN KEY(userId) REFERENCES UserAccount(userId),
    PRIMARY KEY (customerId)
);

CREATE TABLE SalesLog (
	salesLogId INT NOT NULL,
    dateSold DATETIME NOT NULL,
    priceSoldFor DECIMAL(9,2) NOT NULL,
    customerId INT NOT NULL,
    salesId INT NOT NULL,
    vehicleId INT NOT NULL,
    FOREIGN KEY(customerId) REFERENCES CustomerAccount(customerId),
    FOREIGN KEY(salesId) REFERENCES SalesAccount(salesId),
    FOREIGN KEY(vehicleId) REFERENCES Vehicle(vehicleId),
    PRIMARY KEY(salesLogId)
);



