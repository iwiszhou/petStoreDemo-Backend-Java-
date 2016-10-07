CREATE DATABASE  IF NOT EXISTS `petStore`;
USE `petStore`;

DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category`
(
  `id` INT(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Tag`;
CREATE TABLE `Tag`
(
  `id` INT(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Pet`;
CREATE TABLE `Pet`
(
  `id` INT(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  `category_id` INT(10) unsigned DEFAULT NULL,
  `status` ENUM('available', 'pending', 'sold'),
  CONSTRAINT `fk_pet_category` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Pet_Image`;
CREATE TABLE `Pet_Image`
(
  `id` INT(10) unsigned NOT NULL AUTO_INCREMENT,
  `url` TEXT DEFAULT NULL,
  `pet_id` INT(10) unsigned NOT NULL,
  CONSTRAINT `fk_petimage_petid` FOREIGN KEY (`pet_id`) REFERENCES `Pet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Pet_Tag_Ref`;
CREATE TABLE `Pet_Tag_Ref`
(
  `pet_id` INT(10) unsigned NOT NULL,
  `tag_id` INT(10) unsigned NOT NULL,
  PRIMARY KEY (`pet_id`,`tag_id`),
  CONSTRAINT `fk_pettagref_pet` FOREIGN KEY (`pet_id`) REFERENCES `Pet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pettagref_tag` FOREIGN KEY (`tag_id`) REFERENCES `Tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO Category (name) VALUES ('C-1');
SET @category_id = LAST_INSERT_ID();

INSERT INTO Tag (name) VALUES ('Tag-1');
SET @tag_id = LAST_INSERT_ID();


INSERT INTO Pet (name,category_id,status) VALUES ("LOOPER", @category_id, 'available');
SET @pet_id = LAST_INSERT_ID();

INSERT INTO Pet_Image (url, pet_id) VALUES ("pet001.jpg", @pet_id);
INSERT INTO Pet_Image (url, pet_id) VALUES ("pet002.jpg", @pet_id);
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);


INSERT INTO Category (name) VALUES ('C-2');
SET @category_id = LAST_INSERT_ID();

INSERT INTO Tag (name) VALUES ('Tag-2');
SET @tag_id = LAST_INSERT_ID();


INSERT INTO Pet (name,category_id,status) VALUES ("Bibi", @category_id, 'available');
SET @pet_id = LAST_INSERT_ID();

INSERT INTO Pet_Image (url, pet_id) VALUES ("pet003.jpg", @pet_id);
INSERT INTO Pet_Image (url, pet_id) VALUES ("pet004.jpg", @pet_id);
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Tag (name) VALUES ('Tag-2-1');
SET @tag_id = LAST_INSERT_ID();
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);


INSERT INTO Category (name) VALUES ('C-3-Dog');
SET @category_id = LAST_INSERT_ID();

INSERT INTO Tag (name) VALUES ('Tag-3');
SET @tag_id = LAST_INSERT_ID();


INSERT INTO Pet (name,category_id,status) VALUES ("Tar", @category_id, 'available');
SET @pet_id = LAST_INSERT_ID();

INSERT INTO Pet_Image (url, pet_id) VALUES ("pet005.jpg", @pet_id);

INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Tag (name) VALUES ('Tag-3-1');
SET @tag_id = LAST_INSERT_ID();
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);


INSERT INTO Category (name) VALUES ('C-4-Dog');
SET @category_id = LAST_INSERT_ID();

INSERT INTO Tag (name) VALUES ('Tag-4');
SET @tag_id = LAST_INSERT_ID();


INSERT INTO Pet (name,category_id,status) VALUES ("Marli", @category_id, 'available');
SET @pet_id = LAST_INSERT_ID();

INSERT INTO Pet_Image (url, pet_id) VALUES ("pet006.jpg", @pet_id);

INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Tag (name) VALUES ('Tag-4-1');
SET @tag_id = LAST_INSERT_ID();
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Category (name) VALUES ('C-5-Dog');
SET @category_id = LAST_INSERT_ID();

INSERT INTO Tag (name) VALUES ('Tag-5');
SET @tag_id = LAST_INSERT_ID();


INSERT INTO Pet (name,category_id,status) VALUES ("Coco", @category_id, 'available');
SET @pet_id = LAST_INSERT_ID();

INSERT INTO Pet_Image (url, pet_id) VALUES ("pet007.jpg", @pet_id);

INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Tag (name) VALUES ('Tag-5-1');
SET @tag_id = LAST_INSERT_ID();
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);


INSERT INTO Category (name) VALUES ('C-6-Dog');
SET @category_id = LAST_INSERT_ID();

INSERT INTO Tag (name) VALUES ('Tag-6');
SET @tag_id = LAST_INSERT_ID();


INSERT INTO Pet (name,category_id,status) VALUES ("Koo", @category_id, 'available');
SET @pet_id = LAST_INSERT_ID();

INSERT INTO Pet_Image (url, pet_id) VALUES ("pet008.jpg", @pet_id);

INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Tag (name) VALUES ('Tag-6-1');
SET @tag_id = LAST_INSERT_ID();
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Category (name) VALUES ('C-7-Dog');
SET @category_id = LAST_INSERT_ID();

INSERT INTO Tag (name) VALUES ('Tag-7');
SET @tag_id = LAST_INSERT_ID();


INSERT INTO Pet (name,category_id,status) VALUES ("Coco", @category_id, 'available');
SET @pet_id = LAST_INSERT_ID();

INSERT INTO Pet_Image (url, pet_id) VALUES ("pet009.jpg", @pet_id);

INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);

INSERT INTO Tag (name) VALUES ('Tag-7-1');
SET @tag_id = LAST_INSERT_ID();
INSERT INTO Pet_Tag_Ref (pet_id, tag_id) VALUES (@pet_id, @tag_id);