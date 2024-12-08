CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    account_non_locked BOOLEAN NOT NULL
);

-- Create Households Table
CREATE TABLE households (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    eircode VARCHAR(255) NOT NULL,
    number_of_occupants INT NOT NULL,
    max_occupants INT NOT NULL,
    owner_occupied BOOLEAN NOT NULL
);

-- Create Pets Table with Foreign Key to Households
CREATE TABLE pets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    animal_type VARCHAR(255) NOT NULL,
    breed VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    household_id BIGINT NOT NULL,
    CONSTRAINT fk_households FOREIGN KEY (household_id) REFERENCES households(id) ON DELETE CASCADE
);