DROP TABLE IF EXISTS Pet CASCADE;
DROP TABLE IF EXISTS Breed CASCADE;
DROP TABLE IF EXISTS UserDefinition CASCADE;
DROP TABLE IF EXISTS PetUserMapping CASCADE;


CREATE TABLE Breed (
    breedId varchar(64) NOT NULL,
    breedName varchar(64) NOT NULL,
    apartmentFriendly boolean,
    familyFriendly boolean,
    sheddingLevel VARCHAR(64),
    createdOn TIMESTAMP NOT NULL,
    createdBy VARCHAR(64) NOT NULL,
    lastUpdatedOn TIMESTAMP,
    lastUpdatedBy VARCHAR(64),
    PRIMARY KEY (breedId)
);

CREATE TABLE UserDefinition (
    userId varchar(64) NOT NULL,
    firstName varchar(256) NOT NULL,
    middleName varchar(256),
    lastName varchar(256) NOT NULL,
    phoneNumber varchar(256) NOT NULL,
    emailAddress varchar(256) NOT NULL,
    gender varchar(64),
    dateOfBirth TIMESTAMP,
    address1 varchar(1024) NOT NULL,
    address2 varchar(1024),
    city varchar(256),
    state varchar(256),
    country varchar(256),
    zipCode varchar(64),
    createdOn TIMESTAMP NOT NULL,
    createdBy VARCHAR(64) NOT NULL,
    lastUpdatedOn TIMESTAMP,
    lastUpdatedBy VARCHAR(64),
    UNIQUE(emailAddress),
    PRIMARY KEY(userId)
);

CREATE TABLE Pet (
    petId varchar(64) NOT NULL,
    name varchar(256) NOT NULL,
    petType varchar(64) NOT NULL,
    breedId varchar(64) NOT NULL,
    age integer,
    createdOn TIMESTAMP NOT NULL,
    createdBy varchar(64) NOT NULL,
    lastUpdatedBy varchar(64),
    lastUpdatedOn TIMESTAMP,
    PRIMARY KEY (petId),
    FOREIGN KEY (breedId) REFERENCES Breed(breedId)
);

CREATE TABLE PetUserMapping(
    petId varchar(64),
    userId varchar(64),
    PRIMARY KEY (petId, userId),
    FOREIGN KEY (petId) REFERENCES Pet (petId),
    FOREIGN KEY (userId) REFERENCES UserDefinition (userId)
);