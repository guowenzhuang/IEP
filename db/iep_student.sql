/*
 Navicat Premium Data Transfer

 Source Server         : cdb-8umc2fk3.gz.tencentcdb.com
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-8umc2fk3.gz.tencentcdb.com:10020
 Source Schema         : iep_student

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 01/08/2019 11:32:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for commentlog
-- ----------------------------
DROP TABLE IF EXISTS `commentlog`;
CREATE TABLE `commentlog`  (
  `comment_log_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  `mid` int(11) NULL DEFAULT NULL,
  `sid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:用户id',
  PRIMARY KEY (`comment_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commentlog
-- ----------------------------
INSERT INTO `commentlog` VALUES (50, 59, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (54, 3, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (55, 3, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (82, 27, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (92, 29, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (96, 31, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (101, 33, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (102, 30, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (103, 75, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commentlog` VALUES (104, 73, '27a1026f-be4d-4651-9245-578e31d1728a');

-- ----------------------------
-- Table structure for commenttb
-- ----------------------------
DROP TABLE IF EXISTS `commenttb`;
CREATE TABLE `commenttb`  (
  `mid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:评价表主键',
  `cid` int(11) NOT NULL COMMENT '备注:课程id',
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:评价内容',
  `ext1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注：预留字段',
  `mtime` datetime(0) NULL DEFAULT NULL COMMENT '备注:评价时间',
  `praise` int(11) NULL DEFAULT 0 COMMENT '备注:点赞数',
  `sid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:学生id',
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commenttb
-- ----------------------------
INSERT INTO `commenttb` VALUES (28, 2, '头像', NULL, '2018-12-14 17:52:07', 4, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (29, 2, '1大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 6, '2bd926cd-9ce5-4adc-9ee3-15c756cb0c93');
INSERT INTO `commenttb` VALUES (30, 2, '2大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 9, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (31, 2, '3大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 6, '72f0f0d4-8ee0-4409-b921-c01d27869de8');
INSERT INTO `commenttb` VALUES (32, 2, '4大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 5, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (33, 2, '5大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 6, '4028fc8167abccdd0167abd3ed6c0001');
INSERT INTO `commenttb` VALUES (34, 2, '6大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 5, '4028fc8167abccdd0167abd3ed6c0001');
INSERT INTO `commenttb` VALUES (35, 2, '7大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 5, '72f0f0d4-8ee0-4409-b921-c01d27869de8');
INSERT INTO `commenttb` VALUES (36, 2, '8大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 5, '4028fc8167abccdd0167abd3ed6c0001');
INSERT INTO `commenttb` VALUES (37, 2, '9大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 5, '4028fc8167abccdd0167abd3ed6c0001');
INSERT INTO `commenttb` VALUES (38, 2, '10大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 5, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (39, 2, '11大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 9, '4028fc8167abccdd0167abd3ed6c0001');
INSERT INTO `commenttb` VALUES (40, 2, '12大学计算机这门课程好的很！！！', NULL, '2018-12-14 17:52:07', 5, '4028fc8167abccdd0167abd3ed6c0001');
INSERT INTO `commenttb` VALUES (56, 1, '111\n', NULL, '2018-12-27 22:21:34', 0, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (57, 1, '222', NULL, '2018-12-27 22:29:51', 0, '2bd926cd-9ce5-4adc-9ee3-15c756cb0c93');
INSERT INTO `commenttb` VALUES (58, 1, '测试', NULL, '2018-12-27 22:32:36', 0, '4028fc8167abccdd0167abd3ed6c0001');
INSERT INTO `commenttb` VALUES (59, 1, '测试', NULL, '2018-12-27 22:33:29', 0, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (63, 2, '测试评价', NULL, '2019-01-02 09:55:21', 0, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (64, 2, 'kkjjk', NULL, '2019-01-02 09:57:39', 0, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (67, 1, '333', NULL, NULL, 0, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (68, 1, '444', NULL, NULL, 0, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (69, 1, '555', NULL, NULL, 0, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (70, 1, '666', NULL, NULL, 0, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (71, 1, '777', NULL, NULL, 0, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (72, 1, '999', NULL, NULL, 0, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (73, 1, '101', NULL, NULL, 1, '9357593e-02dc-47ab-b304-910e3411a897');
INSERT INTO `commenttb` VALUES (74, 1, '1222', NULL, NULL, 0, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (75, 1, '22222121', NULL, NULL, 1, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (76, 1, '很开心，见到大家', NULL, '2019-01-07 16:44:31', NULL, '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `commenttb` VALUES (77, 1, '该课程很不错', NULL, '2019-01-10 15:45:54', NULL, '27a1026f-be4d-4651-9245-578e31d1728a');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (106);

-- ----------------------------
-- Table structure for studentparttb
-- ----------------------------
DROP TABLE IF EXISTS `studentparttb`;
CREATE TABLE `studentparttb`  (
  `spid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:报名表增长主键',
  `cid` int(11) NOT NULL COMMENT '备注:课程id',
  `parttime` datetime(0) NOT NULL COMMENT '备注:报名时间',
  `sid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:学生id',
  PRIMARY KEY (`spid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentparttb
-- ----------------------------
INSERT INTO `studentparttb` VALUES (29, 2, '2018-12-19 15:45:41', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (116, 3, '2019-01-04 11:29:54', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (121, 5, '2019-01-06 22:59:29', '8a8a80f167ff9c2e0167ffbe5d610003');
INSERT INTO `studentparttb` VALUES (122, 6, '2019-01-07 09:31:52', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (123, 2, '2019-01-07 14:20:23', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (125, 70, '2019-01-07 14:25:23', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (127, 3, '2019-01-07 14:35:31', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (128, 3, '2019-01-07 14:35:32', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (129, 290, '2019-01-07 14:41:32', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (130, 61, '2019-01-07 14:42:49', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (131, 6, '2019-01-07 14:43:43', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (132, 4, '2019-01-07 14:50:50', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (135, 1, '2019-01-07 16:40:05', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `studentparttb` VALUES (136, 3, '2019-07-27 12:27:48', '27a1026f-be4d-4651-9245-578e31d1728a');

-- ----------------------------
-- Table structure for studentrecordtb
-- ----------------------------
DROP TABLE IF EXISTS `studentrecordtb`;
CREATE TABLE `studentrecordtb`  (
  `rid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:学习记录表主键',
  `chaid` int(11) NOT NULL COMMENT '备注:章节id',
  `cid` int(11) NOT NULL COMMENT '备注:课程id',
  `credits` int(11) NULL DEFAULT NULL COMMENT '备注:学生学分',
  `ext1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注：预留字段',
  `sid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:学生id',
  `starttime` datetime(0) NULL DEFAULT NULL COMMENT '备注:学习开始的时间',
  `watchtime` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注:视频观看时间',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentrecordtb
-- ----------------------------
INSERT INTO `studentrecordtb` VALUES (30, 38, 1, NULL, NULL, '27a1026f-be4d-4651-9245-578e31d1728a', '2019-01-07 16:43:39', '28.0');
INSERT INTO `studentrecordtb` VALUES (31, 77, 6, NULL, NULL, '27a1026f-be4d-4651-9245-578e31d1728a', '2019-07-27 12:26:19', '0.0');
INSERT INTO `studentrecordtb` VALUES (32, 78, 6, NULL, NULL, '27a1026f-be4d-4651-9245-578e31d1728a', '2019-07-27 12:26:26', '0.0');
INSERT INTO `studentrecordtb` VALUES (33, 83, 6, NULL, NULL, '27a1026f-be4d-4651-9245-578e31d1728a', '2019-07-27 12:26:37', '0.0');

-- ----------------------------
-- Table structure for studenttb
-- ----------------------------
DROP TABLE IF EXISTS `studenttb`;
CREATE TABLE `studenttb`  (
  `sid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:学生表主键',
  `card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注:学生身份证号',
  `cid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注:所属班级id',
  `photo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注:学生头像',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注:学生性别',
  `credits` int(11) NULL DEFAULT 0 COMMENT '备注:学分',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studenttb
-- ----------------------------
INSERT INTO `studenttb` VALUES ('27a1026f-be4d-4651-9245-578e31d1728a', '411425199608011', NULL, 'http://iep-oss.oss-cn-beijing.aliyuncs.com/stuHead/15466009219472.jpg', '保密', 6);
INSERT INTO `studenttb` VALUES ('2bd926cd-9ce5-4adc-9ee3-15c756cb0c93', NULL, '观主2', 'http://iep-oss.oss-cn-beijing.aliyuncs.com/courPicurl/1546335650783320062_300.jpg', '男', 0);
INSERT INTO `studenttb` VALUES ('4028ab626826ffb50168273d71c30000', '412828199810254562', '4028fc8167fd1c390167fd213f1b0003', NULL, '女', NULL);
INSERT INTO `studenttb` VALUES ('4028fc8167abccdd0167abd3ed6c0001', NULL, '郭傻蛋3', 'http://iep-oss.oss-cn-beijing.aliyuncs.com/courPicurl/1545745457804323732.jpg', '女', 0);
INSERT INTO `studenttb` VALUES ('72f0f0d4-8ee0-4409-b921-c01d27869de8', NULL, '君陌邪4', 'http://iep-oss.oss-cn-beijing.aliyuncs.com/courPicurl/1545745576018323152.jpg', '男', 0);
INSERT INTO `studenttb` VALUES ('9357593e-02dc-47ab-b304-910e3411a897', NULL, '张三5', 'http://iep-oss.oss-cn-beijing.aliyuncs.com/courPicurl/1545745603810323431.jpg', '女', 0);

SET FOREIGN_KEY_CHECKS = 1;
