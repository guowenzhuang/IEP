/*
 Navicat Premium Data Transfer

 Source Server         : cdb-8umc2fk3.gz.tencentcdb.com
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-8umc2fk3.gz.tencentcdb.com:10020
 Source Schema         : iep-permission

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 01/08/2019 11:33:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `departmentDB_departmentId` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_codeasdasdzxc`(`code`) USING BTREE,
  INDEX `FKjddrpcokx8dw6n928mlm1ax5r`(`departmentDB_departmentId`) USING BTREE,
  CONSTRAINT `FKjddrpcokx8dw6n928mlm1ax5r` FOREIGN KEY (`departmentDB_departmentId`) REFERENCES `department` (`departmentId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('4028fc8167fcd56c0167fd1498fa0000', '1601', '9567593e-02dc-47ab-b304-820e3511a578');
INSERT INTO `classes` VALUES ('4028fc8167fd1c390167fd1f5f8f0000', '1602', '9567593e-02dc-47ab-b304-820e3511a579');
INSERT INTO `classes` VALUES ('4028fc8167fd1c390167fd1f79c70001', '1603', '9457593e-02dc-47ab-b304-820e3511a897');
INSERT INTO `classes` VALUES ('4028fc8167fd1c390167fd212b370002', '1604', '9457593e-02dc-47ab-b304-820e3511a897');
INSERT INTO `classes` VALUES ('4028fc8167fd1c390167fd213f1b0003', '1605', '9567593e-02dc-47ab-b304-820e3511a579');
INSERT INTO `classes` VALUES ('4028fc8167fd1c390167fd2158180004', '1606', '9357593e-02dc-47ab-b304-910e3511a897');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `departmentId` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`departmentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('9357593e-02dc-47ab-b304-910e3511a897', '计算机', 10);
INSERT INTO `department` VALUES ('9457593e-02dc-47ab-b304-810e3511a897', '经济管理', 8);
INSERT INTO `department` VALUES ('9457593e-02dc-47ab-b304-820e3511a897', '外语', 77);
INSERT INTO `department` VALUES ('9557593e-02dc-47ab-b304-820e3511a897', '文学历史', 50);
INSERT INTO `department` VALUES ('9567593e-02dc-47ab-b304-820e3511a577', '工学', 30);
INSERT INTO `department` VALUES ('9567593e-02dc-47ab-b304-820e3511a578', '理学', 78);
INSERT INTO `department` VALUES ('9567593e-02dc-47ab-b304-820e3511a579', '医药卫生', 60);
INSERT INTO `department` VALUES ('9567593e-02dc-47ab-b304-820e3511a897', '艺术设计', 40);

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
  `profileUrl` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
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
INSERT INTO `iep_userconnection` VALUES ('c04cdacd-a17b-4cd2-a2f4-80356078026d', 'qq', 'AA0347F6E3BD77713867DDC84D9703A9', 1, 'test', '{\"openId\":\"AA0347F6E3BD77713867DDC84D9703A9\",\"ret\":\"0\",\"msg\":\"\",\"is_lost\":\"0\",\"nickname\":\"test\",\"province\":\"河南\",\"city\":\"商丘\",\"constellation\":\"\",\"year\":\"1994\",\"figureurl\":\"http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/30\",\"figureurl_1\":\"http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/50\",\"figureurl_2\":\"http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/100\",\"figureurl_qq_1\":\"http://thirdqq.qlogo.cn/qqapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/40\",\"figureurl_qq_2\":\"http://thirdqq.qlogo.cn/qqapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/100\",\"gender\":\"男\",\"is_yellow_vip\":\"0\",\"vip\":\"0\",\"yellow_vip_level\":\"0\",\"level\":\"0\",\"is_yellow_year_vip\":\"0\"}', 'http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/30', 'EC298B6BCB9E971E993E7ED8FAEFCCF6', NULL, '371C5888409D6A5AC18732B66E3A8272', 1551713980429);

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
  `status` int(255) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FKkwsyo9be4dfh3t7cn2ahv6nor`(`ParentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of modules
-- ----------------------------
INSERT INTO `modules` VALUES (1, '资源管理', 4, '/teacher/resources.html', 8, NULL, NULL, NULL, 1);
INSERT INTO `modules` VALUES (2, '考试管理', 4, '/exam/testpaperAdmin.html', 9, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (3, '课程管理', 4, '/teacher/course.html', 11, 'el-icon-time', NULL, NULL, 0);
INSERT INTO `modules` VALUES (4, '老师管理', 0, NULL, 20, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (5, '题库管理', 4, '/exam/question.html', NULL, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (6, '系统管理', 0, NULL, 50, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (7, '用户管理', 6, '/admin/yh.html', 30, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (8, '角色管理', 6, '/admin/role.html', 30, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (9, '模块管理', 6, '/admin/module.html', 20, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (10, '权限管理', 6, '/admin/permission.html', 30, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (11, '课程管理', 0, NULL, 52, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (12, '课程推荐', 11, '/admin/kc/tj.html', 80, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (16, 'asd', 1, 'asd', 5, NULL, NULL, NULL, 1);
INSERT INTO `modules` VALUES (17, 'asdjjzz', 4, 'asdjjkkzz', 5, NULL, NULL, NULL, 1);
INSERT INTO `modules` VALUES (18, 'sdfz', 17, 'czxc', 1, NULL, NULL, NULL, 1);
INSERT INTO `modules` VALUES (19, 'asd', 17, 'wqe', 1, NULL, NULL, NULL, 1);
INSERT INTO `modules` VALUES (20, 'qwe', 18, 'wqe', 1, NULL, NULL, NULL, 1);
INSERT INTO `modules` VALUES (21, 'ss', 0, 'ss', 1, NULL, NULL, NULL, 1);
INSERT INTO `modules` VALUES (23, '贴吧管理', 0, ' /bbs/Backstage/index.html', 1, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (24, '机构管理', 0, '', 4, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (25, '院系管理', 24, '/admin/department.html', 3, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (26, '班级管理', 24, '/admin/classes.html', 1, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (27, '老师管理', 24, '/admin/teacher.html', 1, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (28, '学生管理', 24, '/admin/students.html', 1, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (29, '帖子分类管理', 0, '/bbs/Backstage/Hreply.html', 1, NULL, NULL, NULL, 0);
INSERT INTO `modules` VALUES (30, '教室管理', 4, '/exam/testpaperAdmin.html', 10, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permissionId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `permissionValue` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `typeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `methodName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permissionLastUpdateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`permissionId`) USING BTREE,
  UNIQUE INDEX `permissionValueUnique`(`permissionValue`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('297e95d26813afd0016813b05c770000', 'user:exports', '用户', '用户导出', '2019-01-03 20:29:13');
INSERT INTO `permission` VALUES ('297e95d26813afd0016813b05ec20001', 'user:import', '用户', '用户导入', '2019-01-03 20:29:13');
INSERT INTO `permission` VALUES ('297e95d26818639a016818679cac0000', 'post:stickPost', '帖子', '置顶帖子', '2019-01-04 18:27:50');
INSERT INTO `permission` VALUES ('297e95d26818639a016818679e370001', 'post:cancelStick', '帖子', '取消帖子置顶', '2019-01-04 18:27:50');
INSERT INTO `permission` VALUES ('297e95d26818639a016818679f9e0002', 'reply:upReplyIsDel', '回复', '软删除操作', '2019-01-04 18:27:50');
INSERT INTO `permission` VALUES ('297e95d26818639a01681867a1260003', 'reply:upReplyIsDelO', '回复', '还原操作', '2019-01-04 18:27:51');
INSERT INTO `permission` VALUES ('297e95d26818639a01681867a3820004', 'course:updateCourse', '课程', '修改课程', '2019-01-04 18:27:51');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4024b810001', 'user:add', '用户', '新增用户', '2018-12-19 09:09:06');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4024e300002', 'user:update', '用户', '用户修改', '2018-12-19 09:09:07');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c40250c10003', 'user:delete', '用户', '用户删除', '2018-12-19 09:09:07');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c402538e0004', 'user:query', '用户', '查询', '2018-12-19 09:09:08');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c402563f0005', 'module:add', '模块', '模块新增', '2018-12-19 09:09:09');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c402590b0006', 'module:getParentId', '模块', '根据id查询所有的父级id', '2018-12-19 09:09:09');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4025bbb0007', 'module:update', '模块', '模块修改', '2018-12-19 09:09:10');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4025ea20008', 'module:get', '模块', '模块查询', '2018-12-19 09:09:11');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c40261ac0009', 'module:del', '模块', '模块删除', '2018-12-19 09:09:12');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4026479000a', 'role:add', '角色', '角色新增', '2018-12-19 09:09:12');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4026715000b', 'role:delete', '角色', '角色删除', '2018-12-19 09:09:13');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c40269ec000c', 'role:setPermission', '角色', '设置权限', '2018-12-19 09:09:14');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4026cba000d', 'role:query', '角色', '角色查询', '2018-12-19 09:09:15');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c4026f78000e', 'role:setModule', '角色', '设置模块', '2018-12-19 09:09:15');
INSERT INTO `permission` VALUES ('4028fc8167c402030167c402729c000f', 'role:queryUnAndNoqueryUn', '角色', '查询属于用户的角色和不属于用户的角色', '2018-12-19 09:09:16');
INSERT INTO `permission` VALUES ('4028fc8167c40aae0167c40bfb120000', 'module:getAllCheckRole', '模块', '模块查询选中角色拥有', '2018-12-19 09:19:41');
INSERT INTO `permission` VALUES ('4028fc8167c40d640167c40dab570000', 'module:getToCascader', '模块', '模块查询级联框', '2018-12-19 09:21:32');
INSERT INTO `permission` VALUES ('4028fc8167c40d640167c40dc17e0001', 'user:setRole', '用户', '设置角色', '2018-12-19 09:21:37');
INSERT INTO `permission` VALUES ('4028fc8167c40d640167c40dc44b0002', 'user:updateUserField', '用户', '修改某一字段', '2018-12-19 09:21:38');
INSERT INTO `permission` VALUES ('4028fc816817b340016817cd7c0c0001', 'sectionparper:deletesectionparper', '章节测试试卷', '删除章节测试试卷', '2019-01-04 15:39:29');
INSERT INTO `permission` VALUES ('ff80808168229fef016822a0d6f00000', 'cource:query', '课程', '课程查询', '2019-01-06 18:06:32');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_used` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `nums` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('9357593e-02dc-47ab-b304-910f3511a897', '001', '首页轮播图', 2);
INSERT INTO `position` VALUES ('9357593e-02dc-47ab-b304-910f3521a897', '002', '首页推荐', 5);

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `coursetId` int(11) NULL DEFAULT NULL,
  `positionId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `courpostIndex`(`coursetId`, `positionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('297e95d267dbacf90167dbafc9cd0000', 3, '9357593e-02dc-47ab-b304-910f3511a897', 1);
INSERT INTO `recommend` VALUES ('297e95d267dbb5270167dbb5c5b10000', 4, '9357593e-02dc-47ab-b304-910f3521a897', 1);
INSERT INTO `recommend` VALUES ('297e95d267dbb5270167dbb5d0cd0001', 10, '9357593e-02dc-47ab-b304-910f3521a897', 1);
INSERT INTO `recommend` VALUES ('4028fc8167f257230167f25b0c6d0000', 1, '9357593e-02dc-47ab-b304-910f3521a897', 99);
INSERT INTO `recommend` VALUES ('9357593e-02dc-47ab-b304-810f3511a897', 2, '9357593e-02dc-47ab-b304-910f3511a897', 50);
INSERT INTO `recommend` VALUES ('9357593e-02dc-57ab-b304-910f3511a897', 5, '9357593e-02dc-47ab-b304-910f3521a897', 70);
INSERT INTO `recommend` VALUES ('9357593e-03dc-47ab-b304-910f3521a897', 6, '9357593e-02dc-47ab-b304-910f3521a897', 80);
INSERT INTO `recommend` VALUES ('9457593e-02dc-47ab-b304-910f3521a897', 7, '9357593e-02dc-47ab-b304-910f3521a897', 50);

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
  CONSTRAINT `FK_RoleModules_Modules_ModuleId` FOREIGN KEY (`ModuleId`) REFERENCES `modules` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_RoleModules_Roles_RoleId` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rolemodules
-- ----------------------------
INSERT INTO `rolemodules` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', 1);
INSERT INTO `rolemodules` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', 2);
INSERT INTO `rolemodules` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', 3);
INSERT INTO `rolemodules` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', 4);
INSERT INTO `rolemodules` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', 5);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 6);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 7);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 8);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 9);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 10);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 11);
INSERT INTO `rolemodules` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', 11);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 12);
INSERT INTO `rolemodules` VALUES ('297e95d267f758800167f971f2ea0000', 23);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 24);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 25);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 26);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 27);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 28);
INSERT INTO `rolemodules` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 29);
INSERT INTO `rolemodules` VALUES ('297e95d267f758800167f971f2ea0000', 29);

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission`  (
  `roleId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permissionId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rolePermissionLastUpdateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`roleId`, `permissionId`) USING BTREE,
  UNIQUE INDEX `roleperm`(`roleId`, `permissionId`) USING BTREE,
  INDEX `fk_rolepermission_permission`(`permissionId`) USING BTREE,
  CONSTRAINT `fk_rolepermission_permission` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`permissionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_rolepermission_role` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '297e95d26813afd0016813b05c770000', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '297e95d26813afd0016813b05ec20001', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '297e95d26818639a016818679cac0000', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '297e95d26818639a016818679e370001', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '297e95d26818639a016818679f9e0002', '2019-01-06 23:15:10');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '297e95d26818639a01681867a1260003', '2019-01-06 23:15:10');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '297e95d26818639a01681867a3820004', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4024b810001', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4024e300002', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c40250c10003', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c402538e0004', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c402563f0005', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c402590b0006', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4025bbb0007', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4025ea20008', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c40261ac0009', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4026479000a', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4026715000b', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c40269ec000c', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4026cba000d', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c4026f78000e', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c402030167c402729c000f', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c40aae0167c40bfb120000', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c40d640167c40dab570000', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c40d640167c40dc17e0001', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc8167c40d640167c40dc44b0002', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '4028fc816817b340016817cd7c0c0001', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', 'ff80808168229fef016822a0d6f00000', '2019-01-06 23:15:11');
INSERT INTO `rolepermission` VALUES ('297e95d267f758800167f971f2ea0000', '297e95d26818639a016818679cac0000', '2019-01-04 19:17:04');
INSERT INTO `rolepermission` VALUES ('297e95d267f758800167f971f2ea0000', '297e95d26818639a016818679e370001', '2019-01-04 19:17:04');
INSERT INTO `rolepermission` VALUES ('297e95d267f758800167f971f2ea0000', '297e95d26818639a016818679f9e0002', '2019-01-04 19:17:03');
INSERT INTO `rolepermission` VALUES ('297e95d267f758800167f971f2ea0000', '297e95d26818639a01681867a1260003', '2019-01-04 19:17:04');
INSERT INTO `rolepermission` VALUES ('c7751731-abcf-4aba-aeae-ae11451d97a7', '297e95d26818639a01681867a3820004', '2019-01-10 10:59:16');
INSERT INTO `rolepermission` VALUES ('c7751731-abcf-4aba-aeae-ae11451d97a7', 'ff80808168229fef016822a0d6f00000', '2019-01-10 10:59:16');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', '297e95d26818639a01681867a3820004', '2019-01-04 19:07:36');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', '4028fc816817b340016817cd7c0c0001', '2019-01-04 19:07:36');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c4024b810001', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c4024e300002', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c40250c10003', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c402538e0004', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c402563f0005', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c402590b0006', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c4025bbb0007', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c4025ea20008', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c402030167c40261ac0009', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c40aae0167c40bfb120000', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c40d640167c40dab570000', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c40d640167c40dc17e0001', '2018-12-19 15:50:46');
INSERT INTO `rolepermission` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '4028fc8167c40d640167c40dc44b0002', '2018-12-19 15:50:46');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `Id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户组编号',
  `Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色(用户组)名称',
  `Int0` int(11) NULL DEFAULT NULL COMMENT '预留Int',
  `String0` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预留字符串',
  `status` int(255) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IndexUnique_Name`(`Name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1b063868-1374-47ad-8460-1441c1e6ec36', '管理员', NULL, NULL, 0);
INSERT INTO `roles` VALUES ('297e95d267f758800167f971f2ea0000', '贴吧管理员', NULL, NULL, 0);
INSERT INTO `roles` VALUES ('c7751731-abcf-4aba-aeae-ae11451d97a7', '学生', NULL, NULL, 0);
INSERT INTO `roles` VALUES ('c846926d-0aec-11e7-9a05-408d5cd46d51', '老师', NULL, NULL, 0);
INSERT INTO `roles` VALUES ('c846926d-0aec-11e7-9a05-508d5cd46d51', '测试角色', NULL, NULL, 0);

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
  CONSTRAINT `FK1rk3k7s93i8tjpe51jvvpdx5d` FOREIGN KEY (`UserId`) REFERENCES `users` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FKsgfyl133v06wg5rjs9awdrjns` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userroles
-- ----------------------------
INSERT INTO `userroles` VALUES ('24d21f62-fd0f-46c6-972d-3d85fadabfdc', '1b063868-1374-47ad-8460-1441c1e6ec36');
INSERT INTO `userroles` VALUES ('5b080312-f4c2-49f2-a6a0-d42fe78af4e1', '1b063868-1374-47ad-8460-1441c1e6ec36');
INSERT INTO `userroles` VALUES ('297e95d267f758800167f973e7fe0001', '297e95d267f758800167f971f2ea0000');
INSERT INTO `userroles` VALUES ('27a1026f-be4d-4651-9245-578e31d1728a', 'c7751731-abcf-4aba-aeae-ae11451d97a7');
INSERT INTO `userroles` VALUES ('2bd926cd-9ce5-4adc-9ee3-15c756cb0c93', 'c7751731-abcf-4aba-aeae-ae11451d97a7');
INSERT INTO `userroles` VALUES ('4028ab626826ffb50168273d71c30000', 'c7751731-abcf-4aba-aeae-ae11451d97a7');
INSERT INTO `userroles` VALUES ('4028fc8167abccdd0167abd3ed6c0001', 'c7751731-abcf-4aba-aeae-ae11451d97a7');
INSERT INTO `userroles` VALUES ('72f0f0d4-8ee0-4409-b921-c01d27869de8', 'c7751731-abcf-4aba-aeae-ae11451d97a7');
INSERT INTO `userroles` VALUES ('9357593e-02dc-47ab-b304-910e3411a897', 'c7751731-abcf-4aba-aeae-ae11451d97a7');
INSERT INTO `userroles` VALUES ('4028822568368c84016836931c300000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('4028ab9b6826fda00168270314230000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('4028ab9b6826fda0016827872dab0001', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('4028abeb67ffec9f0167fffd95c30000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('4028abeb67ffffe8016800024d2d0000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('4028fc8167b0f1110167b0f2176d0000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('4028fc8167b16b040167b16dc9460000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('4028fc8167b16b040167b16e9f6c0001', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('8a8a80f167ff9c2e0167ffa1e2970000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('8a8a80f167ff9c2e0167ffad382d0002', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('8a8a80f167ff9c2e0167ffbe5d610003', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('8a8a80f167ff9c2e0167ffd6384d0004', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('8a8a80f1680220430168022e5be00001', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('8a8a80f1680236a3016802393e0f0000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('8a8a80f16802cae5016802d27a020000', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('92dd88b1-9157-46de-bfee-51c6b1d17229', 'c846926d-0aec-11e7-9a05-408d5cd46d51');
INSERT INTO `userroles` VALUES ('a804fd2f-e269-4380-bc8d-205a30136713', 'c846926d-0aec-11e7-9a05-408d5cd46d51');

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
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '账户创立时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IndexUnique_LoginName`(`loginName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('24d21f62-fd0f-46c6-972d-3d85fadabfdc', '夫子', '$2a$10$Y/WK3R8K8zB50zXdlijvIu8MZP2yazW6AqoADZlUBHGkMPJUdDj/2', '否', '2019-07-27 10:59:37', 0, NULL, '80795289@qq.com', '15238311713', '2018-12-12 21:51:57', 0);
INSERT INTO `users` VALUES ('27a1026f-be4d-4651-9245-578e31d1728a', '桑桑', '$2a$10$zL8jDu/eLQ3UlbEvBkb4ce8gL6HsqRGyz3sQHf6iLuovPVR9X36a2', '否', '2019-07-27 12:26:02', 0, NULL, '807952791@qq.com', '15238311713', '2018-12-12 21:52:20', 0);
INSERT INTO `users` VALUES ('297e95d267f758800167f973e7fe0001', '孟大侠', '$2a$10$efAC4bLH4ZSTgoxHMkndS.mkzeawM8V8A6UswO8.G5yE9sqy/Dm8u', '否', '2019-01-07 16:14:54', 0, NULL, '45465213@qq.com', '15238311713', '2018-12-29 18:13:04', 0);
INSERT INTO `users` VALUES ('2bd926cd-9ce5-4adc-9ee3-15c756cb0c93', '观主2', '$2a$10$tDjFPuLdTJsbu/rlCXZbxuz4ECo88HrgZUfX4m248fWKKmLQLA3QK', '否', '2019-01-04 16:57:44', 0, NULL, '80795289@qq.com', '15238311712', '2018-12-12 21:51:51', 1);
INSERT INTO `users` VALUES ('4028813568235d570168260459410002', '阿萨德', '$2a$10$gkeftD7H7wxjWGcSZ/4feufEAuzCfD5ZNfN/uNQW.ePgF5EN1IBsu', '否', NULL, 0, NULL, '阿萨德', '阿萨德', '2019-01-07 09:54:05', 1);
INSERT INTO `users` VALUES ('4028813568235d57016835b05f8e0003', '达到三千', '$2a$10$EQu8.dGXRt8V78j6DoYmWOHZYYWx1gz6TF7rJRCHUEQkqRKDgNlFq', '否', NULL, 0, NULL, '22125123@qq.com', '15638808780', '2019-01-10 10:56:17', 1);
INSERT INTO `users` VALUES ('4028822568368c84016836931c300000', '老师1', '$2a$10$b3geETE7qg3uRpgIdTjoVOT.FGdbDoiC/jpKfL1Ug0atce.PgIkXm', '否', '2019-01-10 15:05:10', 0, NULL, '1360921327@qq.com', '18790943013', '2019-01-10 15:03:55', 0);
INSERT INTO `users` VALUES ('4028ab626826ffb50168273d71c30000', '明兰', '$2a$10$vAPGuvKDY2AP1/7KiYfuuenI3W8wnF3xBiBIdtk9jY8OD1THP0NES', '否', '2019-01-07 15:39:18', 0, NULL, '159888588@163.com', '13589895656', '2019-01-07 15:36:05', 0);
INSERT INTO `users` VALUES ('4028ab9b67b9a18c0167ba617ddc0001', '郭傻蛋3', '$2a$10$lASNHcWjYcDHpJ2VI3CtUOrXuVZ2B3zi4u7nn3Hwf8HG/Xq0V8RoW', '否', '2019-01-07 15:34:46', 0, NULL, 'sb@qq.com', '15238311712', '2018-12-17 12:16:51', 0);
INSERT INTO `users` VALUES ('4028ab9b6826fda00168270314230000', '白婷婷1', '$2a$10$N4/YHDRlFjgZ2o4Wa4xbz.Rgqeqv1.r8eueavguH0D1urrqDlg43S', '否', NULL, 0, NULL, 'bai@q.com', '15238311712', '2019-01-07 14:32:19', 0);
INSERT INTO `users` VALUES ('4028ab9b6826fda0016827872dab0001', '白婷婷2', '$2a$10$UuoBYRFKdJ75aUrOTdkYBOosewsSHArFpjjN2iGEAJx6W8eacSEAm', '否', NULL, 0, NULL, 'bai@q.com', '15238311712', '2019-01-07 16:56:37', 0);
INSERT INTO `users` VALUES ('4028abeb67ffec9f0167fffd95c30000', '小张', '$2a$10$q3qkm2d7VVX7Hr3vXdEpZ.4c8w0YsZOXMepsO6iytjcE7crX5NvWm', '否', NULL, 0, NULL, '123@qq.com', '1372862194', '2018-12-31 00:41:09', 0);
INSERT INTO `users` VALUES ('4028abeb67ffffe8016800024d2d0000', '大刘', '$2a$10$stUNfHPKzRKuxaDhbFddxu/OvffRHK.uNMe4/PEp9m5Vo3KuMdtGC', '否', '2019-01-04 20:47:18', 0, NULL, '123@qq.com', '13456234521', '2018-12-31 00:46:18', 0);
INSERT INTO `users` VALUES ('4028fc8167abccdd0167abcf8d580000', '盛广杰', '$2a$10$lfQBjSO6v8.I/fqrWO.LiuMg7EjYHK4g4p6wj6VDI9yzUrMIGhWVy', '否', NULL, 0, NULL, '80795289@qq.com', '1261231444', '2018-12-14 16:22:45', 0);
INSERT INTO `users` VALUES ('4028fc8167abccdd0167abd3ed6c0001', '隆庆', '$2a$10$WTTNvX06DGnbpIW/3hdgFuFSQ9uncavmenE9zcInFoeKmeXRoqqXe', '否', NULL, 0, NULL, 'assad@qq.com', '1523831151', '2018-12-14 16:27:32', 0);
INSERT INTO `users` VALUES ('4028fc8167abccdd0167abd525560002', '屠夫', '$2a$10$c3/.vpdbcsKPf9x.p7EhYuu7MiGzH2Y2cIR01fBEVjTPbSNvba6XK', '否', NULL, 0, NULL, '112@qq.com', '152383115', '2018-12-14 16:28:51', 0);
INSERT INTO `users` VALUES ('4028fc8167b0f1110167b0f2176d0000', '白婷婷', '$2a$10$9Dy0yhKQXa9EyrkmhK9kweTWZEDTOo/Q3Uox0.grI69SOW5cN1dIC', '否', NULL, 0, NULL, '71512121@qq.com', '15238311712', '2018-12-15 16:18:37', 0);
INSERT INTO `users` VALUES ('4028fc8167b16b040167b16dc9460000', '秦老师', '$2a$10$zR6ropsp8/dLouWZL/68zuRAB5zVMslpANWhWXA9XxTLLouD3ErhW', '否', NULL, 0, NULL, 'asdasd@qq.com', '15238311712', '2018-12-15 18:33:43', 0);
INSERT INTO `users` VALUES ('4028fc8167b16b040167b16e9f6c0001', '叶红鱼', '$2a$10$J7.kZXAwv7Ytr6Madyp99efXSH80Xy9D6vxQ10kpR6dMfHZ7fWp0y', '否', NULL, 0, NULL, 'asdad@qq.com', '15238121212', '2018-12-15 18:34:38', 0);
INSERT INTO `users` VALUES ('4028fc81681677660168169624560000', 'ms1', '$2a$10$cFCWqeeInRV4yvrrYpeu0umTDdmZdA7ELwARFnOstoT.Mde.chD36', '否', NULL, 0, NULL, '151@qq.com', '152384211', '2019-01-04 09:59:29', 0);
INSERT INTO `users` VALUES ('4c4db031-9636-463e-849a-26d9743117aa', '狗蛋', '$2a$10$.SZuWFCckO2XY5p.uIRBMO7PtY5KZ9xf7cTzVsfO9fK.NiT2.rTUa', '是', NULL, 0, '2018-12-12 21:59:14', '80795289@qq.com', '15238311712', '2018-12-12 21:50:16', 0);
INSERT INTO `users` VALUES ('582e20f5-b689-42d1-9967-97093b1d127b', '梦梦', '$2a$10$T5kAeIl96NOvQO3j/molb.ZWWbpcr/rR6a3JoShnZmh1DbL4txR9K', '否', NULL, 0, NULL, '80795289@qq.com', '15238311712', '2018-12-12 21:51:09', 0);
INSERT INTO `users` VALUES ('5b080312-f4c2-49f2-a6a0-d42fe78af4e1', '李四', '$2a$10$Z11mEZPdtTwJWqqIQFyBYO1HV6tW4XKc1lFLuc0l2Zj/GrzTJlQJ.', '否', NULL, 0, NULL, '80795289@qq.com', '15238311712', '2018-12-07 17:23:52', 0);
INSERT INTO `users` VALUES ('72f0f0d4-8ee0-4409-b921-c01d27869de8', '君陌邪4', '$2a$10$OelBPO2njUCdACDHjH0fP.9BmVjQb60Kj.QQ57K7Zilb2E7fU3z.y', '否', NULL, 0, NULL, '80795289@qq.com', '15238311712', '2018-12-12 21:51:18', 0);
INSERT INTO `users` VALUES ('85f6e8ab-3719-491f-b3d7-b88600ab1edb', '麻子', '$2a$10$qCQpFBHIjlfU/7BQBa2XQOjc.MbT8jZkKK03SnfknqudqDpwOlXgu', '否', NULL, 0, NULL, '80795289@qq.com', '15238311712', '2018-12-12 21:50:28', 0);
INSERT INTO `users` VALUES ('8a8a80f167ff31f70167ff556c730001', '娜娜', '$2a$10$JmC6t/c15Wt61D6ciPS7feUUUcLLtroGo0zHANrb8Wqw3kXtTLkNC', '否', NULL, 0, NULL, NULL, NULL, '2018-12-30 21:37:28', 0);
INSERT INTO `users` VALUES ('8a8a80f167ff9c2e0167ffa1e2970000', '悦悦', '$2a$10$GZrD8dueNweWWL5D29OnRei/jpvN59abFQSFC4wJLXxMN4u3OdEby', '否', NULL, 0, NULL, '13728928102@163.com', '13728928102', '2018-12-30 23:00:59', 0);
INSERT INTO `users` VALUES ('8a8a80f167ff9c2e0167ffad382d0002', '关谷', '$2a$10$yssZXmTtVoy04Dj7nzdzguNM6WEaKhTtLWUbXPsTDNf5HHNFgEjDq', '否', NULL, 0, NULL, '123@163.com', '13826718632', '2018-12-30 23:13:22', 0);
INSERT INTO `users` VALUES ('8a8a80f167ff9c2e0167ffbe5d610003', 'AA', '$2a$10$IAhF9OEPViLOUVE1rwen.ut039PxfbGFhEBnEQRdfAfxfNLKWQbfy', '否', '2019-01-06 22:53:10', 0, NULL, '13728937821@qq.com', '13728937821', '2018-12-30 23:32:06', 0);
INSERT INTO `users` VALUES ('8a8a80f167ff9c2e0167ffd6384d0004', '张张', '$2a$10$kj8TxaKQNK0YGbxelFGc0uLXckBxtaaEu8Qm0yYYdd/Q6T4tqZbK2', '否', NULL, 0, NULL, '123@qq.com', '13726463821', '2018-12-30 23:58:09', 0);
INSERT INTO `users` VALUES ('8a8a80f1680220430168022e5be00001', '小王', '$2a$10$PflgZRc5OGo3qpx8abs3qeeO63IfOfyWmMzvOJ0knZXLtXCYVUG5G', '否', NULL, 0, NULL, '111@qq.com', '13728261941', '2018-12-31 10:53:39', 0);
INSERT INTO `users` VALUES ('8a8a80f1680236a3016802393e0f0000', '张张1', '$2a$10$10Qnak9HnAhSXqcZ4LULLup.LvlFtdal2uDd3GmQldYhXosMNZRrG', '否', NULL, 0, NULL, '11@qq.com', '13526472831', '2018-12-31 11:05:33', 0);
INSERT INTO `users` VALUES ('8a8a80f16802cae5016802d27a020000', '莉莉', '$2a$10$MhX9NMWIdeurr5Hckz854.d.ddIt18UaTVm.eNbuwXLIYu6CtPFYG', '否', NULL, 0, NULL, '123456@qq.com', '13268792013', '2018-12-31 13:52:55', 0);
INSERT INTO `users` VALUES ('92dd88b1-9157-46de-bfee-51c6b1d17229', '宁缺', '$2a$10$n8RglkN3fBXNEDGNNWiyMuvcNRGXcSy/j9D7Y3RA87wPH0yXKLSYC', '否', '2019-07-27 11:07:57', 0, NULL, '80795288@qq.com', '15238311713', '2018-12-12 21:51:26', 0);
INSERT INTO `users` VALUES ('9357593e-02dc-47ab-b304-910e3411a897', '张三', '$2a$10$qAFHTTgjj5Mza2YsSEhI4O/PvkEDwu5Czt8CZRupLbBUHhAbyS9pW', '否', '2019-01-03 19:21:36', 0, NULL, '80795289@qq.com', '15238311712', '2018-12-04 12:52:50', 0);
INSERT INTO `users` VALUES ('a804fd2f-e269-4380-bc8d-205a30136713', '王五', '$2a$10$7zwEzBtzlaepTpb14SXYvuCw17VdmBnNESzkjCmX4KzFPzVWlQQX6', '否', '2019-01-06 19:54:31', 0, NULL, '80795289@qq.com', '15238311712', '2018-12-07 20:46:18', 0);
INSERT INTO `users` VALUES ('b81441c6-8bb1-4d08-ab10-8776850053c0', '沙雕', '$2a$10$b.LC5zGM3Fa.4UZZso1APu7LEC/cE8bJirfM4x0xOg0h9vQVxhSta', '是', NULL, 0, '2018-12-12 21:58:52', '80795289@qq.com', '15238311712', '2018-12-12 21:50:42', 0);
INSERT INTO `users` VALUES ('c8de251e-523c-4479-a7dd-688cda70b47d', '昊天', '$2a$10$jKqgGZW1v2o74VhdaHuixOm4jsPFiasG8PiUVS33nQo2dj32MkPEK', '否', NULL, 0, NULL, '80795289@qq.com', '15238311712', '2018-12-12 21:51:30', 0);

SET FOREIGN_KEY_CHECKS = 1;
