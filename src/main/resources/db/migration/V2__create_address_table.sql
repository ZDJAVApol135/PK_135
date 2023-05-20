CREATE TABLE IF NOT EXISTS addresses
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    city     VARCHAR(55) NOT NULL,
    street   VARCHAR(55) NOT NULL,
    postcode VARCHAR(10) NOT NULL
)