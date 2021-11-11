/* --------------filling in the table "tags"---------------------*/
INSERT INTO tags (name)
VALUES ('tagName1');

INSERT INTO tags (name)
VALUES ('tagName3');

INSERT INTO tags (name)
VALUES ('tagName5');

INSERT INTO tags (name)
VALUES ('tagName4');

INSERT INTO tags (name)
VALUES ('tagName2');

/* --------------filling in the table "gift_certificates"---------------------*/
INSERT INTO gift_certificates (name, description, price, duration, create_date, last_update_date)
VALUES ('giftCertificate1', 'description1', 10.1, 1, '2020-08-29T06:12:15', '2020-08-29T06:12:15');

INSERT INTO gift_certificates (name, description, price, duration, create_date, last_update_date)
VALUES ('giftCertificate3', 'description3', 30.3, 3, '2019-08-29T06:12:15', '2019-08-29T06:12:15');

INSERT INTO gift_certificates (name, description, price, duration, create_date, last_update_date)
VALUES ('giftCertificate2', 'description2', 20.2, 2, '2018-08-29T06:12:15', '2018-08-29T06:12:15');

/* --------------filling in the table "gift_certificates_has_tags"---------------------*/
INSERT INTO gift_certificates_has_tags (gift_certificate_id, tag_id)
VALUES (1, 2);

INSERT INTO gift_certificates_has_tags (gift_certificate_id, tag_id)
VALUES (1, 5);

INSERT INTO gift_certificates_has_tags (gift_certificate_id, tag_id)
VALUES (2, 2);

INSERT INTO gift_certificates_has_tags (gift_certificate_id, tag_id)
VALUES (3, 3);

/* --------------filling in the table "users"---------------------*/
INSERT INTO users(name)
VALUES ('name1');

INSERT INTO users(name)
VALUES ('name2');

/* --------------filling in the table "orders"---------------------*/
INSERT INTO orders(price, purchase_time, user_id, gift_certificate_id)
VALUES (10.1, '2018-08-29T06:12:15', 1, 1);

INSERT INTO orders(price, purchase_time, user_id, gift_certificate_id)
VALUES (30.3, '2018-08-29T06:12:15', 1, 2);

INSERT INTO orders(price, purchase_time, user_id, gift_certificate_id)
VALUES (20.2, '2018-08-29T06:12:15', 2, 3);