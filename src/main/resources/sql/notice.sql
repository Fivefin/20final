/*==============================================================*/
/* Table: notice  */
/*==============================================================*/
DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice`
(
   `title`  varchar(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
   `ntype`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
   `person`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
   `ntime`  datetime(0) NULL DEFAULT NULL,
   `ncollege` varchar(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
   `ncontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
   PRIMARY KEY (`title`) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO notice VALUES ('2020年四川师范大学四、六级报考通知','教务处',
'王五','2020.10.11','计算机科学学院','关于2020年四川师范大学四、六级报考通知如下：');
