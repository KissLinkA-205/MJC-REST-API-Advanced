-- -----------------------------------------------------
-- Table module3test.tags
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tags
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table module3test.gift_certificates
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_certificates
(
    id               BIGINT UNSIGNED AUTO_INCREMENT,
    name             VARCHAR(45) UNIQUE     NOT NULL,
    description      TEXT(300),
    price            DECIMAL(8, 2) UNSIGNED NOT NULL,
    duration         SMALLINT UNSIGNED      NOT NULL,
    create_date      DATETIME               NOT NULL,
    last_update_date DATETIME               NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table module3test.gift_certificates_tags
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_certificates_has_tags
(
    id                  BIGINT UNSIGNED AUTO_INCREMENT,
    gift_certificate_id BIGINT UNSIGNED,
    tag_id              BIGINT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (gift_certificate_id) REFERENCES gift_certificates (id),
    FOREIGN KEY (tag_id) REFERENCES tags (id)
);

-- -----------------------------------------------------
-- Table module3test.users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS users
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table module3test.orders
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS orders
(
    id                  BIGINT UNSIGNED AUTO_INCREMENT,
    price               DECIMAL(8, 2) UNSIGNED NOT NULL,
    purchase_time       DATETIME               NOT NULL,
    user_id             BIGINT UNSIGNED,
    gift_certificate_id BIGINT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (gift_certificate_id) REFERENCES gift_certificates (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);