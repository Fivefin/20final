
/*==============================================================*/
/* Table: feeinfo */
/*==============================================================*/
DROP TABLE IF EXISTS `feeinfo`;
CREATE TABLE `feeinfo`(
	`sid`  INT(0) NOT NULL COMMENT '学生id',
	`schoolfee` INT(0)  COMMENT '学费',
	`dromfee` INT(0)   COMMENT '住宿费',
	`insurance` INT(0)  COMMENT '保险费',
	`sundryfee` INT(0)  COMMENT '学杂费',
	`hadpay` INT(0)  COMMENT '应缴费用',
	`payedfee` INT(0)  COMMENT '已交费用',
   PRIMARY KEY (`sid`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT =1 DEFAULT CHARSET = utf8;

INSERT INTO `feeinfo`(sid) VALUES(1);

