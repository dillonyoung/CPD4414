CREATE TABLE tracare_accounts (
    id INT NOT NULL IDENTITY, 
    PRIMARY KEY (id), 
    first_name VARCHAR(100) NOT NULL, 
    last_name VARCHAR(100) NOT NULL, 
    gender INT NOT NULL, 
    weight FLOAT NOT NULL, 
    height FLOAT NOT NULL, 
    email VARCHAR(100) NOT NULL, 
    password VARCHAR(100) NOT NULL);
CREATE TABLE tracare_symptomtypes (
    id INT NOT NULL IDENTITY, 
    PRIMARY KEY (id), 
    description VARCHAR(200) NOT NULL);
CREATE TABLE tracare_preferences (
    userid INT NOT NULL, 
    PRIMARY KEY (userid), 
    FOREIGN KEY (userid) REFERENCES tracare_accounts(id), 
    track_weight BIT NOT NULL, 
    track_sleep BIT NOT NULL, 
    track_blood_pressure BIT NOT NULL, 
    track_energy_level BIT NOT NULL, 
    track_quality_of_sleep BIT NOT NULL, 
    track_fitness BIT NOT NULL, 
    track_nutrition BIT NOT NULL,
	track_symptom BIT NOT NULL,
	track_location BIT NOT NULL);
CREATE TABLE tracare_locations (
    id INT NOT NULL IDENTITY,
    PRIMARY KEY (id),
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL);
CREATE TABLE tracare_entries (
    id INT NOT NULL IDENTITY,
    PRIMARY KEY (id),
    userid INT NOT NULL,
	FOREIGN KEY (userid) REFERENCES tracare_accounts(id),
    datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    weight FLOAT,
    hours_slept FLOAT,
    blood_pressure FLOAT,
    energy_level INT,
    quality_of_sleep INT,
    fitness VARCHAR(MAX),
    nutrition VARCHAR(MAX),
    symptom INT,
    symptom_description VARCHAR(MAX),
	location_latitude FLOAT,
	location_longitude FLOAT);