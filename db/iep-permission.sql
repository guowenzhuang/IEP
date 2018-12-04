/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : iep-permission

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 04/12/2018 18:57:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for iep_userconnection
-- ----------------------------
DROP TABLE IF EXISTS `iep_userconnection`;
CREATE TABLE `iep_userconnection`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `providerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `providerUserId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `profileUrl` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `imageUrl` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `accessToken` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `secret` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `refreshToken` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `expireTime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`, `providerId`, `providerUserId`) USING BTREE,
  UNIQUE INDEX `UserConnectionRank`(`userId`, `providerId`, `rank`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of iep_userconnection
-- ----------------------------
INSERT INTO `iep_userconnection` VALUES ('test', 'qq', 'AA0347F6E3BD77713867DDC84D9703A9', 1, 'test', NULL, 'http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/30', 'EC298B6BCB9E971E993E7ED8FAEFCCF6', NULL, '371C5888409D6A5AC18732B66E3A8272', 1551520282475);

-- ----------------------------
-- Table structure for modules
-- ----------------------------
DROP TABLE IF EXISTS `modules`;
CREATE TABLE `modules`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块名称',
  `ParentId` int(11) NULL DEFAULT 0 COMMENT '父模块编号',
  `Path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块路径',
  `Weight` int(11) NULL DEFAULT NULL COMMENT '权重',
  `icon_class` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Ops` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预留字符串字段',
  `Int0` int(11) NULL DEFAULT NULL COMMENT '预留整数字段',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FKkwsyo9be4dfh3t7cn2ahv6nor`(`ParentId`) USING BTREE,
  CONSTRAINT `FKkwsyo9be4dfh3t7cn2ahv6nor` FOREIGN KEY (`ParentId`) REFERENCES `modules` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1198 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of modules
-- ----------------------------
INSERT INTO `modules` VALUES (4, '系统管理', NULL, '', 99, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (5, '用户管理', 4, 'sys/yh.jsp', 99, 'person-stalker', NULL, NULL);
INSERT INTO `modules` VALUES (6, '角色管理', 4, 'sys/jdgl.jsp', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (8, '模块管理', 4, 'syss/moudules.jsp', 96, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (12, '字典类型', 4, 'sys/zdlx.html', 95, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (13, '数据字典', 4, 'sys/sjzd.html', 94, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (16, '课程资源', NULL, '', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (24, '课程管理', 16, 'dev/kcgl.html', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (25, '章节开发', 16, 'dev/zjka.html', 95, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (27, '单词管理', 16, 'dev/dcgl.html', 91, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (34, '学期管理', 16, 'dev/xqgl.html', 99, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (35, '理论试卷库', 16, 'dev/llsjk.html', 89, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (36, '客观题库', 16, 'dev/kgtk.html', 90, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (37, '快捷服务', NULL, '', 91, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (39, '学生管理', NULL, '', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (40, '新生报到', 39, 'stu/xsbd.html', 99, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (41, '学籍管理', 39, 'stu/xjgl.html', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (42, '班级管理', 39, 'stu/bjgl.html', 95, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (78, '登记新员工', 4, 'emp/djxyg.html', 60, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (79, '员工管理', 4, 'emp/yggl.html', 86, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (80, '学生学习', NULL, '', 96, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (81, '登记出勤', 39, 'stu/cqdj.html', 88, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (82, '请假管理', 39, 'stu/qjgl.html', 90, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (83, '学籍异动', 39, 'stu/xjyd.html', 92, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (84, '班级学习跟踪', 80, 'stuLearn/bjxxgz.html', 78, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (85, '班级评优', 80, 'stuLearn/bjpy.html', 89, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (86, '课表管理', 80, 'stu/kbgl.html', 99, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (87, '学生学习跟踪', 80, 'stuLearn/xsxxgz.html', 79, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (88, '登记上机', 80, 'stuLearn/djsj.html', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (89, '登记任务单', 80, 'stuLearn/djrwd.html', 96, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (90, '登记作业', 80, 'stuLearn/djzy.html', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (91, '积分与Z币', NULL, '', 95, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (92, '学生规则', 91, 'marks/xsgz.html', 99, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (93, '班级规则', 91, 'marks/bjgz.html', 94, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (94, '学生积分管理', 91, 'marks/xsjfgl.html', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (95, '班级积分管理', 91, 'marks/bjjfgl.html', 93, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (96, '学生考试', NULL, '', 94, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (97, '考试管理', 96, 'exam/ksgl.html', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (99, '发起考试', 96, 'exam/fqks.html', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (102, '公告管理', 37, 'sys/gggl.html', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (104, '课程授权', 16, 'dev/kcsq.html', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (105, '学生信息', 39, 'stu/xsxx.html', 93, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (106, '登记请假', 39, 'stu/djqj.html', 91, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (116, '登记职务', 39, 'stu/djzw.html', 79, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (117, '职务管理', 39, 'stu/zwgl.html', 78, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (119, '主观题库', 16, 'dev/zgtk.html', 87, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (120, 'Z币发放', 91, 'marks/zbff.html', 89, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (121, 'Z币查看', 91, 'marks/zbck.html', 88, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (122, '我的授课', 37, 'sys/wdsk.html', 93, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (123, '课表查询', 37, 'stu/kbcx.html', 92, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (124, '通讯录', 37, 'emp/txl.html', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (131, '阶段简报', 80, 'stuLearn/jdjb.html', 88, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (132, '学生打分', 91, 'marks/xsdf.html', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (133, '班级打分', 91, 'marks/bjdf.html', 92, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (134, '学生积分查看', 91, 'marks/xsjfck.html', 96, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (135, '班级积分查看', 91, 'marks/bjjfck.html', 91, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (136, '课程章节', 16, 'dev/kczj.html', 85, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (137, '教学日历', 16, 'dev/jxrl.html', 84, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (139, '出勤管理', 39, 'stu/cqgl.html', 87, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (140, '作业查询', 80, 'stuLearn/zycx.html', 95, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (141, '上机查询', 80, 'stuLearn/sjcx.html', 94, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (142, '单词管理', 80, 'stuLearn/dcgl.html', 84, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (143, '任务单查询', 80, 'stuLearn/rwdcx.html', 93, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (144, '登记单词', 80, 'stuLearn/djdc.html', 85, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (145, '课时管理', 37, 'sys/ksgl.html', 91, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (146, '课时统计', 37, 'sys/kstj.html', 90, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (147, '单词测试', 96, 'exam/dccs.html', 94, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (148, '指定试卷', 96, 'exam/zdsj.html', 94, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (149, '分派批改任务', 96, 'exam/fppgrw.html', 93, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (150, '批改登记', 96, 'exam/pgdj.html', 92, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (157, '成绩查询', 80, 'stuLearn/cjcx.html', 92, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (170, '课程资源', 16, 'dev/kczy.html ', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (171, '网络档案', NULL, NULL, 90, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (172, '网络学生', 171, 'netFile/netStu.jsp', 99, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (173, '网络跟踪', 171, 'netFile/netFollow.jsp', 98, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (174, '分量设置', 171, 'netFile/weightSet.jsp', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (175, '我的学生', 171, 'netFile/myStu.jsp', 96, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (176, '员工签到', 4, 'sysM/empCheckIn.jsp', 99, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (177, '调整分量顺序', 4, 'sysM/setEmpWeight.jsp', 89, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (178, '修改密码', 4, 'sysM/setPassword.jsp', 87, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (179, '权限管理', NULL, NULL, 89, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (180, '用户管理', 179, 'sys/yh.jsp', 99, 'person-stalker', NULL, NULL);
INSERT INTO `modules` VALUES (182, '角色管理', 179, 'sys/jdgl.jsp', 97, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (183, '模块管理', 179, 'syss/moudules.jsp', 96, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (184, '网络学生_12', 171, 'netFile/netStu_1.jsp', 12, '1', NULL, NULL);
INSERT INTO `modules` VALUES (185, '我的学生_1', 171, 'netFile/myStu_1.jsp', 90, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (186, '网络跟踪_1', 171, 'netFile/netFollow_1.jsp', 88, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (187, '权限管理', 179, 'sys/qx.html', 7, '', NULL, NULL);
INSERT INTO `modules` VALUES (188, '统计', 4, 'sys/chart.html', 5, NULL, NULL, NULL);
INSERT INTO `modules` VALUES (1194, '回收站', 4, 'sys/recycling.html', 7, '', NULL, NULL);
INSERT INTO `modules` VALUES (1197, '权限日志', 4, 'sys/loggin.html', 0, '', NULL, NULL);
INSERT INTO `modules` VALUES (1198, '选择题管理', 80, 'study/stuSubject.html', 0, '', NULL, NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permissionId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `permissionValue` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `permissionModule` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限模块',
  `permissionName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `permissionLastUpdateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`permissionId`) USING BTREE,
  UNIQUE INDEX `permissionValueUnique`(`permissionValue`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('9357593e-02dc-47ab-b304-910e3411a897', '测试权限', '测试', '权限测试', '2018-12-04 14:21:20');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_used` timestamp(0) NOT NULL,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rolemodules
-- ----------------------------
DROP TABLE IF EXISTS `rolemodules`;
CREATE TABLE `rolemodules`  (
  `RoleId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ModuleId` int(11) NOT NULL,
  PRIMARY KEY (`RoleId`, `ModuleId`) USING BTREE,
  UNIQUE INDEX `rolemod`(`RoleId`, `ModuleId`) USING BTREE,
  INDEX `FK_RoleModules_Modules_ModuleId`(`ModuleId`) USING BTREE,
  INDEX `FK_RoleModules_Roles_RoleId`(`RoleId`) USING BTREE,
  CONSTRAINT `FK555vuvbw5bjqso1407n903icm` FOREIGN KEY (`ModuleId`) REFERENCES `modules` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_RoleModules_Modules_ModuleId` FOREIGN KEY (`ModuleId`) REFERENCES `modules` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_RoleModules_Roles_RoleId` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKa1pfdf8pjfbag6e4cfj0isjuh` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission`  (
  `roleId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permissionId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rolePermissionLastUpdateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`roleId`, `permissionId`) USING BTREE,
  UNIQUE INDEX `roleperm`(`roleId`, `permissionId`) USING BTREE,
  INDEX `fk_rolepermission_permission`(`permissionId`) USING BTREE,
  CONSTRAINT `fk_rolepermission_permission` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`permissionid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_rolepermission_role` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('c7751731-abcf-4aba-aeae-ae11451d97a7', '9357593e-02dc-47ab-b304-910e3411a897', '2018-12-04 14:21:41');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `Id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户组编号',
  `Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色(用户组)名称',
  `Int0` int(11) NULL DEFAULT NULL COMMENT '预留Int',
  `String0` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预留字符串',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IndexUnique_Name`(`Name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '管理员', NULL, NULL);
INSERT INTO `roles` VALUES ('c7751731-abcf-4aba-aeae-ae11451d97a7', '学生', NULL, NULL);
INSERT INTO `roles` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', '老师', NULL, NULL);

-- ----------------------------
-- Table structure for userroles
-- ----------------------------
DROP TABLE IF EXISTS `userroles`;
CREATE TABLE `userroles`  (
  `UserId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RoleId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`UserId`, `RoleId`) USING BTREE,
  UNIQUE INDEX `roleperm`(`RoleId`, `UserId`) USING BTREE,
  INDEX `FK_UserRoles_Roles_RoleId`(`RoleId`) USING BTREE,
  INDEX `FK_UserRoles_Users_UserId`(`UserId`) USING BTREE,
  CONSTRAINT `FK1rk3k7s93i8tjpe51jvvpdx5d` FOREIGN KEY (`UserId`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_UserRoles_Roles_RoleId` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_UserRoles_Users_UserId` FOREIGN KEY (`UserId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKsgfyl133v06wg5rjs9awdrjns` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userroles
-- ----------------------------
INSERT INTO `userroles` VALUES ('9357593e-02dc-47ab-b304-910e3411a897', 'c7751731-abcf-4aba-aeae-ae11451d97a7');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `Id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `loginName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `isLockout` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '否' COMMENT '是否锁定',
  `lastLoginTime` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `psdWrongTime` int(11) NULL DEFAULT 0 COMMENT '密码错误次数',
  `lockTime` timestamp(0) NULL DEFAULT NULL COMMENT '被锁定时间',
  `protectEMail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密保邮箱',
  `protectMTel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密保手机号',
  `createTime` timestamp(0) NULL DEFAULT NULL COMMENT '账户创立时间',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IndexUnique_LoginName`(`loginName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('7db9bda0-d98f-40d7-ae56-f63f9dd7c1e6', 'zzz', '$2a$10$yYBQ1GVYS9wYY6Y5QuVuveKY7k9aHxOe.VtbkXP1yJnUpwWSxxDYS', '否', NULL, 0, NULL, '80795289@qq.com', '15238311712', '2018-12-04 18:48:01');
INSERT INTO `users` VALUES ('9357593e-02dc-47ab-b304-910e3411a897', '张三', '$2a$10$qAFHTTgjj5Mza2YsSEhI4O/PvkEDwu5Czt8CZRupLbBUHhAbyS9pW', '否', NULL, 0, NULL, '80795289@qq.com', '15238311712', '2018-12-04 12:52:50');

SET FOREIGN_KEY_CHECKS = 1;
