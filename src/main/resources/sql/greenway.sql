
/*==============================================================*/
/* Table: greenway */
/*==============================================================*/
DROP TABLE IF EXISTS `greenway`;
CREATE TABLE `greenway`(
	`gid` INT(0) NOT NULL AUTO_INCREMENT COMMENT '绿色通道id',
	`sid`  INT(0) NOT NULL COMMENT '学生id',
	`asseyear` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT '评定学年',
	`feekind` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT '缴费类别',
	`returncode` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT '回执码',
	`bank` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT '贷款银行',
	`branch` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT '支行名称',
	`year` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT '贷款年限',
	`money` INT(0) COMMENT '贷款额度',
   PRIMARY KEY (`gid`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT =1 DEFAULT CHARSET = utf8;

INSERT INTO `greenway`(gid,sid) VALUES(1,1);
