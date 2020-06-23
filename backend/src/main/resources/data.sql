/* 

insert into wb_category(id,name,active,description,menu_order,category_unit) VALUES(1,'Milk',0,'this is milk',1,'L');

insert into wb_sub_category(id,name,active,description,category_id,menu_order) VALUES(1,'FAT_FREE_MILK',0,'this is milk',1,1);
insert into wb_sub_category(id,name,active,description,category_id,menu_order) VALUES(2,'ORGANIC_MILK',0,'this is milk',1,2);
insert into wb_sub_category(id,name,active,description,category_id,menu_order) VALUES(3,'LACTOSE_FREE_MILK',0,'this is milk',1,3);
insert into wb_sub_category(id,name,active,description,category_id,menu_order) VALUES(4,'REDUCED_FAT_MILK',0,'this is milk',1,4);
insert into wb_sub_category(id,name,active,description,category_id,menu_order) VALUES(5,'CONDENSED_MILK',0,'this is milk',1,5);



INSERT INTO `wb_role` VALUES (1,'role for normal user','ROLE_SUPPLIER'),(2,'this role is for supplier','ROLE_USER'),(3,'role for normal admin','ROLE_ADMIN');
INSERT INTO `wb_address` VALUES (1,NULL,NULL,'new','34.55,45.66','323443',NULL),(4,NULL,NULL,'new colony','34.55,45.44','343443',NULL),(7,NULL,NULL,'new colony','45.55,65.55','453441',NULL);
INSERT INTO `wb_user` VALUES (6,_binary '\0',_binary '','rajak','rajak','4343454345','$2a$10$TGnucstNgC3fknXcMAoDIuPOZxOSnjY.vOi1Zlxh.u/3v7FGAh3Gu','rajak',_binary '\0',4,NULL,5),(9,_binary '\0',_binary '\0','psankhle','psankhle','5456545654','$2a$10$aSbqovlhdDIEn2OoC.RvdefIJZTddLxset2exvaWj52mf.NZMV3oS','psankhle',_binary '\0',7,NULL,8);
INSERT INTO `wb_user_preference` VALUES (2,'',NULL),(5,'us_EN',NULL),(8,'us_EN',NULL);
INSERT INTO `user_role` VALUES (6,2),(9,3);

*/

INSERT INTO `wb_role` VALUES (1,'role for normal user','ROLE_SUPPLIER'),(2,'this role is for supplier','ROLE_USER'),(3,'role for normal admin','ROLE_ADMIN');
INSERT INTO `wb_address` VALUES (1,NULL,NULL,'new','34.55,45.66','323443',NULL),(4,NULL,NULL,'new colony','34.55,45.44','343443',NULL),(7,NULL,NULL,'new colony','45.55,65.55','453441',NULL);
INSERT INTO `wb_user` VALUES (6,_binary '\0',_binary '','rajak','rajak','4343454345','$2a$10$TGnucstNgC3fknXcMAoDIuPOZxOSnjY.vOi1Zlxh.u/3v7FGAh3Gu','rajak',_binary '\0',4,NULL,5),(9,_binary '\0',_binary '\0','psankhle','psankhle','5456545654','$2a$10$aSbqovlhdDIEn2OoC.RvdefIJZTddLxset2exvaWj52mf.NZMV3oS','psankhle',_binary '\0',7,NULL,8);
INSERT INTO `wb_user_preference` VALUES (2,'',NULL),(5,'us_EN',NULL),(8,'us_EN',NULL);
INSERT INTO `user_role` VALUES (6,2),(9,3);