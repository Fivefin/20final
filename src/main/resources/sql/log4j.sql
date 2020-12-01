
-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `log4j`;

CREATE TABLE `log4j`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `actionDate` VARCHAR(255) DEFAULT NULL,
    `actionClassName` VARCHAR(1024) DEFAULT NULL,
    `actionThreadName` VARCHAR(1024) DEFAULT NULL,
    `level` VARCHAR(10) DEFAULT NULL,
    `loggerName` VARCHAR(255) DEFAULT NULL,
    `message` VARCHAR(4096) DEFAULT NULL,
    PRIMARY KEY(`id`)
)ENGINE=INNODB AUTO_INCREMENT =1 DEFAULT CHARSET = utf8;