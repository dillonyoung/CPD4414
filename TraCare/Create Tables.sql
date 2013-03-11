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
    track_frequency INT NOT NULL, 
    track_weight BIT NOT NULL, 
    track_sleep BIT NOT NULL, 
    track_blood_pressure BIT NOT NULL, 
    track_energy_level BIT NOT NULL, 
    track_quality_of_sleep BIT NOT NULL, 
    track_fitness BIT NOT NULL, 
    track_nutrition BIT NOT NULL);
CREATE TABLE tracare_locations (
    id INT NOT NULL IDENTITY,
    PRIMARY KEY (id),
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL);
CREATE TABLE tracare_entries (
    id INT NOT NULL IDENTITY,
    PRIMARY KEY (id),
    note VARCHAR(MAX) NOT NULL,
    datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    location INT,
    FOREIGN KEY (location) REFERENCES tracare_locations(id),
    weight FLOAT,
    hours_slept FLOAT,
    blood_pressure FLOAT,
    energy_level INT,
    quality_of_sleep INT,
    fitness VARCHAR(MAX),
    nutrition VARCHAR(MAX),
    symptom INT,
    FOREIGN KEY (symptom) REFERENCES tracare_symptomtypes(id),
    symptom_intensity INT,
    symptom_description VARCHAR(MAX));