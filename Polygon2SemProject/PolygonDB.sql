
-- Host: 127.0.0.1    Database: polygonDb
-- ------------------------------------------------------
-- Server version	5.5.47
DROP DATABASE IF EXISTS polygonDb;
CREATE DATABASE polygonDb;
USE polygonDb;

DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Building;
DROP TABLE IF EXISTS Report;
DROP TABLE IF EXISTS Room;

CREATE TABLE user (
  name varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  userId int(11) NOT NULL,
  userType varchar(45) NOT NULL,
  companyName varchar(45) NOT NULL,
  tlfNr int(11) NOT NULL,
  contactNr int(11) NOT NULL,
  emailAddress varchar(45) NOT NULL
  );
  

CREATE TABLE building (
  buildingId int(11) NOT NULL,
  buildingName varchar(50) NOT NULL,
  adresse varchar(50) DEFAULT NULL,
  buildingCondition varchar(45) DEFAULT NULL,
  parcelNr int(11) DEFAULT NULL,
  size int(11) DEFAULT NULL,
  zipcode int(11) DEFAULT NULL,
  PRIMARY KEY (userId),
  FOREIGN KEY (userId) 
		REFERENCES User(userId)
);


CREATE TABLE report (
  reportId int(11) NOT NULL,
  reportNr int(11) NOT NULL,
  nameOfBuilding varchar(45) NOT NULL,
  rDate varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  zipCode varchar(45) NOT NULL,
  yearBuild varchar(45) DEFAULT NULL,
  buildingSizeInSquareMetres int(11) DEFAULT NULL,
  buildingPurpose varchar(45) DEFAULT NULL,
  roofNoticeBoolean bit(1) NOT NULL,
  roofPictureBoolean bit(1) NOT NULL,
  roofNotice varchar(45) NOT NULL,
  wallNoticeBoolean bit(1) NOT NULL,
  wallPictureBoolean bit(1) NOT NULL,
  wallNotice varchar(45) NOT NULL,
  roomId int(11) NOT NULL,
  writer varchar(45) NOT NULL,
  coWriter varchar(45) DEFAULT NULL,
  buildingCondition int(11) NOT NULL,
  buildingId int(11) NOT NULL,
  PRIMARY KEY (reportId),
  FOREIGN KEY(buildingId)
		REFERENCES Room(roomId)
);


CREATE TABLE room (
	  roomId int(11) NOT NULL,
	  roomName varchar(45) NOT NULL,
	  notices bit(1) DEFAULT NULL,
	  damagedRoom bit(1) NOT NULL,
	  dateOfDamage varchar(45) DEFAULT NULL,
	  descriptionOfLocation varchar(45) DEFAULT NULL,
	  explanationOfDamage varchar(45) DEFAULT NULL,
	  repairs varchar(45) DEFAULT NULL,
	  moisture bit(1) DEFAULT NULL,
	  sponge bit(1) DEFAULT NULL,
	  mold bit(1) DEFAULT NULL,
	  fire bit(1) DEFAULT NULL,
	  otherDamage bit(1) DEFAULT NULL,
	  moistureDescription varchar(45) DEFAULT NULL,
	  spongeDescription varchar(45) DEFAULT NULL,
	  moldDescription varchar(45) DEFAULT NULL,
	  fireDescription varchar(45) DEFAULT NULL,
	  otherDamageDescription varchar(45) DEFAULT NULL,
	  reportId int(11) NOT NULL,
	  PRIMARY KEY (roomId),
	  FOREIGN KEY (reportId) 
			REFERENCES Report(reportId)
);
