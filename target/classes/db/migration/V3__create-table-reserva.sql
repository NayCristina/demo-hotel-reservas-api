CREATE TABLE reserva (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         check_in DATE NOT NULL,
                         check_out DATE NOT NULL,
                         quarto_id INT,
                         hotel_id INT,
                         status VARCHAR(50) NOT NULL,
                         FOREIGN KEY (quarto_id) REFERENCES quarto(id),
                         FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);