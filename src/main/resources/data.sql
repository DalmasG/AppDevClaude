INSERT INTO users (username, password, role, account_non_locked)
VALUES ('admin', '$2a$10$D9yZfOgEh9R9E1Mtp9aSSuWn5nsyY00u4T5/dp.qMfNzU50Ig6H2K', 'ADMIN', true);

INSERT INTO households (eircode, number_of_occupants, max_occupants, owner_occupied) VALUES 
('D02 AB12', 2, 4, true),
('D04 CD34', 0, 3, false),
('D06 EF56', 3, 3, true),
('D08 GH78', 1, 2, true),
('D10 IJ90', 0, 4, false);

INSERT INTO pets (name, animal_type, breed, age, household_id) VALUES 
('Buddy', 'Dog', 'Golden Retriever', 3, 1),
('Mittens', 'Cat', 'Siamese', 2, 2),
('Charlie', 'Dog', 'Beagle', 4, 3),
('Whiskers', 'Cat', 'Persian', 5, 1),
('Coco', 'Rabbit', 'Holland Lop', 1, 2),
('Goldie', 'Fish', 'Goldfish', 1, 3),
('Polly', 'Bird', 'Parakeet', 2, 1),
('Max', 'Dog', 'German Shepherd', 5, 2),
('Luna', 'Cat', 'Maine Coon', 3, 3),
('Nibbles', 'Hamster', 'Syrian Hamster', 1, 1);


