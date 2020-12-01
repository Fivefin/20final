
/*==============================================================*/
/* Table: student */
/*==============================================================*/
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
     `sid`  INT(0) NOT NULL AUTO_INCREMENT COMMENT '主键 学生id',
     `uid` INT(0) NOT NULL COMMENT '用户id',
     `cid` INT(0) NOT NULL COMMENT '班级id',
     `sexamid` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考生号',
     `did` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍id',
     `colloge` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名',
     `political` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '政治面貌',
     `pid` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
	`ssex`  VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, 
	`sage`  INT(0), 
	`sname`  VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, 
	`sadress`   VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '地址', 
	`sphone` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '电话', 
	`semail` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱', 
	`spname` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生家长名',
	`spphone` VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生家长电话',
	`stype`   VARCHAR(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缴费状态',
   PRIMARY KEY (`sid`) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


