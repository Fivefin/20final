
/*==============================================================*/
/* Table: drom */
/*==============================================================*/
DROP TABLE IF EXISTS `drom`;
CREATE TABLE `drom`(
   `did` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍id',
   `dblock` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '幢',
   `dflor` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼层',
   `dunit` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '室',
   `dbed` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '床位',
   `dstate` INT COMMENT '状态',
   PRIMARY KEY (`did`) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

