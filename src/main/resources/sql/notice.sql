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

