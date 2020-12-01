
-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;

CREATE TABLE `class`(
   `cid` INT(0) NOT NULL AUTO_INCREMENT COMMENT '班级id',
   `cgrade` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级号',
   `cclass` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班号',
   `ccollege` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级所在学院',
   `cnum` INT NOT NULL COMMENT '班级人数',
    PRIMARY KEY(`cid`)
)ENGINE=INNODB AUTO_INCREMENT =1 DEFAULT CHARSET = utf8;
