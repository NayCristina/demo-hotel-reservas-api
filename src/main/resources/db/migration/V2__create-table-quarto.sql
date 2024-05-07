CREATE TABLE quarto (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        nome VARCHAR(255) NOT NULL,
                        hotel_id INT,
                        FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);

