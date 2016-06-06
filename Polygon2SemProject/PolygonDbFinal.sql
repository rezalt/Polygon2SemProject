DROP DATABASE IF EXISTS polygonDb;
CREATE DATABASE polygonDb;
USE polygonDb;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS building;
DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS room;

CREATE TABLE user (
	  userId int(11) NOT NULL AUTO_INCREMENT,
	  name varchar(45) NOT NULL,
	  password varchar(45) NOT NULL,
	  companyName varchar(45) NOT NULL,
	  companyAddress varchar(45) NOT NULL,
	  zip int(45) NOT NULL,
	  userType varchar(45) NOT NULL DEFAULT 0,
	  tlfNr int(11),
	  contactNr int(11),
	  emailAddress varchar(45),
	  PRIMARY KEY (userId)
  );
  

CREATE TABLE building (
	  buildingId int(11) NOT NULL AUTO_INCREMENT,
	  buildingName varchar(50) NOT NULL,
	  adresse varchar(50) DEFAULT NULL,
	  buildingCondition varchar(45) DEFAULT NULL,
	  buildingCompany varchar(45) DEFAULT NULL,
	  parcelNr int(11) DEFAULT NULL,
	  size int(11) DEFAULT NULL,
	  zipcode int(11) DEFAULT NULL,
	  PRIMARY KEY (buildingId)
);


CREATE TABLE report (
	  reportNr int(11) NOT NULL AUTO_INCREMENT,
	  nameOfBuilding varchar(45) NOT NULL,
	  rDate varchar(45) NOT NULL,
	  address varchar(45) NOT NULL,
	  zipCode varchar(45) NOT NULL,
	  yearBuild varchar(45) DEFAULT NULL,
	  buildingSizeInSquareMeters int(11) DEFAULT NULL,
	  buildingPurpose varchar(45) DEFAULT NULL,
	  roofNoticeBoolean bit(1) NOT NULL,
	  roofPictureBoolean bit(1) NOT NULL,
	  roofNotice varchar(45),
	  wallNoticeBoolean bit(1) NOT NULL,
	  wallPictureBoolean bit(1) NOT NULL,
	  wallNotice varchar(45),
	  roomId int(11) DEFAULT NULL,
	  writer varchar(45) NOT NULL,
	  coWriter varchar(45) DEFAULT NULL,
	  buildingCondition int(11) NOT NULL,
	  roofPicture MEDIUMBLOB,
	  wallPicture MEDIUMBLOB,
	  userId int(11) NOT NULL,
	  buildingId int(11) NOT NULL,
	  PRIMARY KEY (reportNr),
	  FOREIGN KEY(userId )
			REFERENCES user(userId ),
	  FOREIGN KEY(buildingID)
	  		REFERENCES building(buildingID)
	
);


CREATE TABLE room (
	  roomId int(11) NOT NULL AUTO_INCREMENT,
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
	  roomPicture MEDIUMBLOB,
	  reportNr int(11) NOT NULL,
	  PRIMARY KEY (roomId),
	  FOREIGN KEY (reportNr) 
			REFERENCES Report(reportNr)
);


INSERT INTO user ( name, password, companyName, companyAddress, zip, userType )
VALUES ( 'Admin', 1234, 'Polygon', 'atPolygon', 2610, 2 )
