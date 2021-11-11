DROP DATABASE module3;

CREATE DATABASE IF NOT EXISTS module3;

USE module3;

-- -----------------------------------------------------
-- Table module3.tags
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tags
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table module3.tags_aud
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tags_aud
(
    rev     BIGINT NOT NULL,
    revtype TINYINT DEFAULT NULL,
    id      BIGINT UNSIGNED,
    name    VARCHAR(20),
    PRIMARY KEY (id, rev)
);

-- -----------------------------------------------------
-- Table module3.gift_certificates
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
-- Table module3.gift_certificates_aud
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_certificates_aud
(
    rev              BIGINT NOT NULL,
    revtype          TINYINT DEFAULT NULL,
    id               BIGINT UNSIGNED,
    name             VARCHAR(45),
    description      TEXT(300),
    price            DECIMAL(8, 2) UNSIGNED,
    duration         SMALLINT UNSIGNED,
    create_date      DATETIME,
    last_update_date DATETIME,
    PRIMARY KEY (id, rev)
);

-- -----------------------------------------------------
-- Table module3.gift_certificates_tags
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
-- Table module3.gift_certificates_has_tags_aud
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_certificates_has_tags_aud
(
    rev                 BIGINT NOT NULL,
    revtype             TINYINT DEFAULT NULL,
    gift_certificate_id BIGINT UNSIGNED,
    tag_id              BIGINT UNSIGNED,
    PRIMARY KEY (rev)
);

-- -----------------------------------------------------
-- Table module3.users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS users
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table module3.users_aud
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS users_aud
(
    rev     BIGINT NOT NULL,
    revtype TINYINT DEFAULT NULL,
    id      BIGINT UNSIGNED,
    name    VARCHAR(100),
    PRIMARY KEY (id, rev)
);

-- -----------------------------------------------------
-- Table module3.orders
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

-- -----------------------------------------------------
-- Table module3.orders_aud
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS orders_aud
(
    rev                 BIGINT NOT NULL,
    revtype             TINYINT DEFAULT NULL,
    id                  BIGINT UNSIGNED,
    price               DECIMAL(8, 2) UNSIGNED,
    purchase_time       DATETIME,
    user_id             BIGINT UNSIGNED,
    gift_certificate_id BIGINT UNSIGNED,
    PRIMARY KEY (id, rev)
);

-- -----------------------------------------------------
-- Table module3.revinfo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS revinfo
(
    rev      BIGINT NOT NULL AUTO_INCREMENT,
    revtstmp BIGINT,
    PRIMARY KEY (rev)
);