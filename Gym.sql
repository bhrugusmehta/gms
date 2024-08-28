CREATE DATABASE gym_management;

USE gym_management;

CREATE TABLE batch (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    time_of_day ENUM('morning', 'evening') NOT NULL
);

CREATE TABLE participant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    batch_id INT,
    FOREIGN KEY (batch_id) REFERENCES batch(id)
);

ALTER TABLE participant
DROP FOREIGN KEY participant_ibfk_1;

ALTER TABLE participant
ADD CONSTRAINT participant_ibfk_1
FOREIGN KEY (batch_id) REFERENCES batch (id)
ON DELETE CASCADE
ON UPDATE CASCADE;
