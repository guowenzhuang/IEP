/*
 Navicat Premium Data Transfer

 Source Server         : cdb-8umc2fk3.gz.tencentcdb.com
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-8umc2fk3.gz.tencentcdb.com:10020
 Source Schema         : iep_exam

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 01/08/2019 11:32:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer_tb
-- ----------------------------
DROP TABLE IF EXISTS `answer_tb`;
CREATE TABLE `answer_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `optiones` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer_rubric_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKj4ydsv3l15qkju6q3183oe8gp`(`answer_rubric_id`) USING BTREE,
  CONSTRAINT `FKj4ydsv3l15qkju6q3183oe8gp` FOREIGN KEY (`answer_rubric_id`) REFERENCES `rubric_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer_tb
-- ----------------------------
INSERT INTO `answer_tb` VALUES ('000778266669498daf56cf289b36b705', '抽象类中可以包含静态方法', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('000a2a54e3184961903da7195317a7e0', '手动阀', 'B', '59ee1e459b754300bd11855cb62ffe6f');
INSERT INTO `answer_tb` VALUES ('02af2ddbbe444e599d51aa8582b62347', 'ContextLoaderServlet', 'A', 'dfa6b4880aa54876b900878be19b8d08');
INSERT INTO `answer_tb` VALUES ('03e9067fa1a44490b477197e29289216', '采用Spring2.0的语法更简单', 'D', '485749f02ccc4597968f6f59cf663b45');
INSERT INTO `answer_tb` VALUES ('0569b09bed9445c2ad8f88d9c6f281c1', '在LIMIT子句中使用RAND()函数指定行数，并用ORDER BY子句定义一个排序规则', 'A', 'a080e837f75f4485a99f4886ee99ff19');
INSERT INTO `answer_tb` VALUES ('06d6a8616a1b4e8fafccd4105e6c2122', '打撒发', 'A', '59ee1e459b754300bd11855cb62ffe6f');
INSERT INTO `answer_tb` VALUES ('07ce9cef82c5456f8f657c02cb4ce096', 'JdbcDaoSupport', 'B', '7dc83a074a8443cf99f5e3eea203a1f0');
INSERT INTO `answer_tb` VALUES ('0858600098c24321bd82fb8c48e306ca', '创建唯一的索引，允许空值', 'A', '9059c72c51604f6aa14ab09447638c98');
INSERT INTO `answer_tb` VALUES ('095ab209798843869455f073fd9d27e6', 'ARCHIVE', 'D', '2f3a97fa23d146d0b3104fe0583c0637');
INSERT INTO `answer_tb` VALUES ('0abdd2cbb3614046899dcb6fce084c41', '顶顶顶顶顶顶顶顶顶顶顶顶', 'A', '4f7830365f5b406db5b6bf4eb229afb4');
INSERT INTO `answer_tb` VALUES ('0b3efe8b43ef48a7a80f09ccc4150e03', '是豆腐干山豆根', 'B', 'ba706533f90741aca42872dab0385ef6');
INSERT INTO `answer_tb` VALUES ('0b8a53d8ed6f4963af8de2538da22bca', '1231321', 'A', '254498176e7748899a1b0b1eb4ef13b7');
INSERT INTO `answer_tb` VALUES ('0bc57b3ad79b4357ab36257806e63daa', '45454', 'D', 'd2876869659f4965bc0100d474b590f2');
INSERT INTO `answer_tb` VALUES ('0c2ec6579f3449059b626e0e1d4400a1', '备份与恢复', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('0c644de6ecbe4771bf42130e88ae2e53', 'Spring DAO 需要注入DataSource', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('0c71843cdb8e4cd7b041f99a5be8e3c3', '踩踩踩', 'D', '7acb4b1ade75456e9feae1309994fda8');
INSERT INTO `answer_tb` VALUES ('0cb86765d89c499bb04cf38dfa956dd2', '7777777777777', 'B', '42760c1909594f919f38c768807634b7');
INSERT INTO `answer_tb` VALUES ('0e11eccdfad34c2095142fc29a4d6db9', '3', 'C', '02355ba2dc2f49de803e291c5079dc37');
INSERT INTO `answer_tb` VALUES ('0e7571273610438f874231275583a2ec', '是否更换', 'D', '91c6dddbdffd4eec8d894853c072feea');
INSERT INTO `answer_tb` VALUES ('0f5c9366b9c647d5b22bcdc7a0e96b02', 'f', 'B', 'a2ba5ee9c4dc4027beb886beea78a2c3');
INSERT INTO `answer_tb` VALUES ('0f8f02a817ae4635a113b0f5ca7dcf5e', '是法国大使馆', 'D', 'ba706533f90741aca42872dab0385ef6');
INSERT INTO `answer_tb` VALUES ('0fad03ce3ca04fddbd6addf8902cdf69', 'ee', 'B', '3c3e033b7481482ea6722fc72069aa32');
INSERT INTO `answer_tb` VALUES ('0fc651ccbfcc46b5aedb194abc74f24e', '1231231321', 'C', '254498176e7748899a1b0b1eb4ef13b7');
INSERT INTO `answer_tb` VALUES ('0fc8571966294d29a7000f04cb2d049a', '以上都对', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('1004a306767e4a1bb3aeb900cec8e130', '广泛的的', 'B', '91c6dddbdffd4eec8d894853c072feea');
INSERT INTO `answer_tb` VALUES ('1007a31602834b7c9615e4591c7e14bd', 'sdf', 'D', '81b5e3a72368420eaa65231467955773');
INSERT INTO `answer_tb` VALUES ('102baa71fff0475981b10a02b2a6c744', '使用Spring2.0的方式配置声明式事务无需定义事务管理器;', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('107567a532194d6b822a5aa0d9c42f6b', '踩踩踩', 'C', 'd4d28e096e294418b68d003cc685ac15');
INSERT INTO `answer_tb` VALUES ('11c5545bc7e545a6befeb59e7c8bb6ca', '环绕通知', 'C', 'de4ae93ca27743f6a1c9d5b40aa8e740');
INSERT INTO `answer_tb` VALUES ('120bfbff16a3406e9eec44fefd165d5b', '每个表只能建立1个主键', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('12a6bd6a101a44d894985490e6fb072f', '121212', 'C', '0df24612f265482d8b318ba9e64fcc55');
INSERT INTO `answer_tb` VALUES ('1311f58f1c764a1eac59c34fa08a82bb', '撒地方', 'B', 'b6e43f85fd1a44188ef6ee606aaa868d');
INSERT INTO `answer_tb` VALUES ('1348673c7e6e4202ae189d15b5f4c32f', 'nnnnnnnnnnnnnnnnnnn', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('13cf85684fba40adb7e3215332fd8d1d', '1', 'A', '02355ba2dc2f49de803e291c5079dc37');
INSERT INTO `answer_tb` VALUES ('14431609d8fe43f98a9d7d01598c547b', 'CVB', 'B', '9681d35f4cae4e0cb680fcfcee39e73f');
INSERT INTO `answer_tb` VALUES ('144e51b2ecba4acc93f1f6522750e84b', '啊', 'D', 'cd883c3caa704f0cacffe7e08f81c6f7');
INSERT INTO `answer_tb` VALUES ('1471d077dfb14e95918b41e074eb4b7b', 'MapperConfigurer', 'B', '40a4d0fbdc4a470a992073fde694f70f');
INSERT INTO `answer_tb` VALUES ('163017124f5843289e4f5e87a8caf9e5', 'NamedParameterJdbcTemplate', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('172322eee73c4e8d931cad9bb1f18e30', '将程序中涉及的公共问题集中解决', 'C', 'c519171747404fe496228f7ee9b12114');
INSERT INTO `answer_tb` VALUES ('17decdfaa02a4edc9bec90da20aac946', '两者的存储方式不一样，对于跨时区的业务，TIMESTAMP更为合适', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('1816821b569e44af84371e5c1ad7cdef', '12', 'D', '41cc71e09b064220a89b557a08868471');
INSERT INTO `answer_tb` VALUES ('1a1c8129e79840b5abe472406249f16b', '<aop:after-returning  pointcut-ref=\"p1\" />', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('1ac651a506ac48a793722fd468196746', 'bb', 'B', '5a1647ca5ea04ddaa05fa9f4a33e652e');
INSERT INTO `answer_tb` VALUES ('1ba3632b901a489f95a94aa309cc25dc', '121', 'B', 'f13dfb4f72874182bd884be97da7868b');
INSERT INTO `answer_tb` VALUES ('1bbb7641a9f54ddc9cbb3e5d6afa27e5', '@AfterThorwing', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('1c0e47a33c804b13a8c5092e4fceb80a', '啊', 'A', '42af75326dc44d7f80b4b993241279ef');
INSERT INTO `answer_tb` VALUES ('1c90ceaf7f0b441e9609869c364456c9', '1', 'D', 'ec29a46a156b45beadbd8b01ad9cb2f4');
INSERT INTO `answer_tb` VALUES ('1daf00c585514474a52cddf2adacde05', '撒地方', 'D', 'cb1c9a87df79402da5fdfe023ecb449b');
INSERT INTO `answer_tb` VALUES ('1ec5a0563cdc49d5b653e162f378e036', '121212', 'A', 'd2876869659f4965bc0100d474b590f2');
INSERT INTO `answer_tb` VALUES ('1fe1015c5d8a4061a5fdee0da6d3bd04', '12121', 'C', 'fd6e3f3027644007aa5b8b3d049860a4');
INSERT INTO `answer_tb` VALUES ('205a7b64c040439aafd6e12b50f2b1c7', 'dfs挂号费的规划', 'B', '9be3dfd9d53d4be5be77f46253d5417d');
INSERT INTO `answer_tb` VALUES ('205fa3edfa38407a9eeac3687a5eecc8', ' 的', 'D', 'f1f2e8faef9e4a4aa6da12b77c37217d');
INSERT INTO `answer_tb` VALUES ('21b37964b34e4aa1b553fafc2aaff49d', '士大夫', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('222b392b7eb84cfc8853edac8547debc', '1231321', 'B', '254498176e7748899a1b0b1eb4ef13b7');
INSERT INTO `answer_tb` VALUES ('2338da22890346c78e755c797558ce34', '<aop:around method=\"before\" pointcut-ref=\"p1\" />', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('249111b64d334812856803f5414a74ef', '的的', 'C', 'f1f2e8faef9e4a4aa6da12b77c37217d');
INSERT INTO `answer_tb` VALUES ('2495c2b15fb240c4a39c9d6f8fb6c061', '是阿道夫', 'C', '2d6e87af1bb140f4bbace58799220a1d');
INSERT INTO `answer_tb` VALUES ('25e2c5c935214654b51d2f9166734501', 'sdf', 'D', '75e93e57f4b04f3ab6a83d33b339ffd2');
INSERT INTO `answer_tb` VALUES ('26c405ce48b6423f84d88e8092a7280a', 'SimpleJdbcTemplate', 'C', '7dc83a074a8443cf99f5e3eea203a1f0');
INSERT INTO `answer_tb` VALUES ('26d0839424fb451a8ebe065b0c64d068', '1212', 'B', '21f77485fcc642e99f060c554996c11a');
INSERT INTO `answer_tb` VALUES ('26da990326644ce8be487ba662665e40', '11', 'C', '63b24f080f28428a9b7dfe341c773220');
INSERT INTO `answer_tb` VALUES ('26ee81a30e2a4e758abd2f0bd51849d4', 'db', 'D', '5a1647ca5ea04ddaa05fa9f4a33e652e');
INSERT INTO `answer_tb` VALUES ('2708ef7c72a9476ca7a8b595b004ceec', '12', 'A', '41cc71e09b064220a89b557a08868471');
INSERT INTO `answer_tb` VALUES ('286e517a48f44a14a6061363dab1f990', '2121', 'D', 'e172ca9e88544e6e9d448f466717e946');
INSERT INTO `answer_tb` VALUES ('2877eef23cfe4fe886fe2e29879dc978', '啊发顺丰', 'B', '3a92867b637044feba215def83937274');
INSERT INTO `answer_tb` VALUES ('29be8f1810ad4f359e79440bb57b5f2b', '1', 'B', 'ec29a46a156b45beadbd8b01ad9cb2f4');
INSERT INTO `answer_tb` VALUES ('29c68f05d9c4421597c8396e0ba0c5ae', 'sdaf', 'D', 'cc3166f3f57b4367b35029beff5b96c8');
INSERT INTO `answer_tb` VALUES ('2a7e6e9b55b541da994dc95c154be714', '12', 'A', 'f13dfb4f72874182bd884be97da7868b');
INSERT INTO `answer_tb` VALUES ('2bf20d4e8c9f4e54896e5a6fbc7c24a6', '111111111111111111', 'B', 'f968c8d4bdd240db82f55c2d0cdb061c');
INSERT INTO `answer_tb` VALUES ('2c080e47f1b94e68845f8b1879ab5947', 'ORDER BY CLASSES', 'A', '8407a759e3b6413d8f78e505272da3f6');
INSERT INTO `answer_tb` VALUES ('2d1c2bdd61034589b8e263416884cd36', '1', 'C', 'ec29a46a156b45beadbd8b01ad9cb2f4');
INSERT INTO `answer_tb` VALUES ('2d99964a612a4c8abe618fc9b44ff719', 'JdbcTemplate', 'A', '7dc83a074a8443cf99f5e3eea203a1f0');
INSERT INTO `answer_tb` VALUES ('2e18a9b0bf0d4ed6bb31224b5172c373', '啊啊啊啊啊啊啊啊啊', 'C', 'd3892a2dbf8c4666b0e3914d162528e2');
INSERT INTO `answer_tb` VALUES ('2e196ba9e1e44d0d951547a90c6abfe5', 'vvvvv', 'A', 'f68b2133215947c0b80e33e4e94af782');
INSERT INTO `answer_tb` VALUES ('2e7d7cd997474b40be951b7e0369b90b', '可以通过Web服务调用', 'D', 'c519171747404fe496228f7ee9b12114');
INSERT INTO `answer_tb` VALUES ('2ee2b8d2f3394af3bab338b952479a89', '顶顶顶顶顶顶顶顶顶顶顶', 'A', '014592a37a544fd8991f069dda8d3433');
INSERT INTO `answer_tb` VALUES ('2f1389aba86e4970a5091e8a41bb58f0', '121', 'D', '83772e81135546768ec1370e72b79723');
INSERT INTO `answer_tb` VALUES ('2f7529d3330e4abd8e7996fe812e08a8', 'TOP', 'A', 'bcc10a19f6544e01a99070fea998b2d9');
INSERT INTO `answer_tb` VALUES ('2fa0e8472f6c430790b23361dd6964c3', '12', 'A', '982cd7a8c1404813b9dd24bf405021db');
INSERT INTO `answer_tb` VALUES ('2ff0d22b06e34ee9b44cf80c8c0621e0', '士大夫撒', 'D', '031406d2139c4edf862f65c81dcaaa4d');
INSERT INTO `answer_tb` VALUES ('306b3052ffc448d8bf23bd211f3186a9', '踩踩踩', 'D', 'd4d28e096e294418b68d003cc685ac15');
INSERT INTO `answer_tb` VALUES ('30a6a91060b64ec7ab4b0e0f16501a21', '基于连接池的JNDI数据源', 'B', 'b8ac6fbdfa404ad3a081e59a2618a925');
INSERT INTO `answer_tb` VALUES ('30d9165e1035460f8e8954a2791fb99b', '你就是!!!', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('30dd023d22a44059910338ed56172286', 'dfdf', 'A', '5b2590de04eb42979453fc22a2082290');
INSERT INTO `answer_tb` VALUES ('30e4d05cba3c4e5888e2d9ac925dc482', '撒旦撒旦', 'B', 'f268f977d3054f0f9f4bb8a5a5dc7ebc');
INSERT INTO `answer_tb` VALUES ('320cef30103e4ac485eb1010af472e2e', '1212', 'D', '21f77485fcc642e99f060c554996c11a');
INSERT INTO `answer_tb` VALUES ('32399128d86046d98fbc0fea03aa57f9', '豆腐干地方是', 'C', '4827b6bb388b4c3b932599a03df36175');
INSERT INTO `answer_tb` VALUES ('32b16e869b174a66b959be3f8702aa08', '1212121212', 'D', '754ac78e8a8f44c2bf8fd5d589550d7b');
INSERT INTO `answer_tb` VALUES ('32edc906db1c4ae3a9022ba7f8eda746', '222', 'C', '5bcc41ca2cef43c7844a60168cd42656');
INSERT INTO `answer_tb` VALUES ('333fc618230847b89f115f1383c75df1', '在ORDER BY子句中使用RAND()函数，并用LIMIT子句定义行数', 'D', 'a080e837f75f4485a99f4886ee99ff19');
INSERT INTO `answer_tb` VALUES ('3356b329bc1640ac8eacb8a79a2e7b0f', 'ff', 'A', 'a2ba5ee9c4dc4027beb886beea78a2c3');
INSERT INTO `answer_tb` VALUES ('33b706a2ab9646a393733dfcc7dba4e0', '1212121', 'D', '0df24612f265482d8b318ba9e64fcc55');
INSERT INTO `answer_tb` VALUES ('33c7ca753f524cab865507a0361f06da', 'ab', 'A', '5a1647ca5ea04ddaa05fa9f4a33e652e');
INSERT INTO `answer_tb` VALUES ('33fce074ced840bda622f617ababd8a4', '121212121212212', 'C', '754ac78e8a8f44c2bf8fd5d589550d7b');
INSERT INTO `answer_tb` VALUES ('3465cb9e715d45f6a176f70c39c782b8', '5555555', 'B', 'dc8a5fe1553c4a1c83209dc7a5121982');
INSERT INTO `answer_tb` VALUES ('349411007bb74ba1a2b1b7316de8b1d1', '111111111111111', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('34d3cb69c7444100bbca0dea258e593e', '声音', 'C', 'fb0962da9c194eb49a5e0a07be776750');
INSERT INTO `answer_tb` VALUES ('34f7bc6d098e436e877379a17f1be4bc', '使用Spring进行声明式事务管理，无需编写程序代码，只需在配置文件中声明即可;', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('350c1238ffc240a68e9a688a58fb20a4', '啊', 'A', 'cd883c3caa704f0cacffe7e08f81c6f7');
INSERT INTO `answer_tb` VALUES ('35a67ce9e35c4eac9bbb5a25ce6e755d', 'df', 'B', '1ce0d7b4a9e2426eb71d450d36b56062');
INSERT INTO `answer_tb` VALUES ('35d8f860e1414d1f8d016dc310f14798', 'ccccccccccc', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('35f7b67e5f4645dbac5cdbc40c4b0dc4', '文字', 'A', 'fb0962da9c194eb49a5e0a07be776750');
INSERT INTO `answer_tb` VALUES ('360cbf5bda524ee5b6a61a9061609517', 'fghjv', 'C', '65b62a4a578e4db5b456f4226b4b538e');
INSERT INTO `answer_tb` VALUES ('36d031421fc34cf6971e3a7f8df42760', 'sdfa', 'D', 'ff585cb24a044775aad1ee145f1c6811');
INSERT INTO `answer_tb` VALUES ('36d1eb62db4443e1958e5b9de5691c80', '33333', 'A', '9ba068ddc72e474090f9b774a330f75b');
INSERT INTO `answer_tb` VALUES ('37e47e81674948d09d98fec4a3fd60f8', '根深蒂固', 'D', '2b958279e88f4d6e8e65815dddf2176e');
INSERT INTO `answer_tb` VALUES ('3852c3614e014a8ebb31585ca1fec11a', 'HENAI', 'C', 'a1b089a053224d009872d717137c2e1a');
INSERT INTO `answer_tb` VALUES ('389db1822b4640d5a0251d16b329e0e3', 'sdfa', 'B', 'b4920096b925466284c762b21070a39c');
INSERT INTO `answer_tb` VALUES ('398f56180246447f801a1b6c8f021dd2', '切入点表达式必须包含方法参数模式', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('3a0224b9556a42329b734f3f2aba1f7a', 'DATETIME的默认值为null；', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('3af14309d7e345f99c8e8c13dad011bd', 'df', 'C', 'b616fadf12a343048f86bada78526ebc');
INSERT INTO `answer_tb` VALUES ('3b14c73a57934142b5580bb1e364c539', '踩踩踩踩踩踩踩踩踩踩踩踩', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('3b37dd2e895047ba8aa6310434ddd453', '成功的法国', 'C', '3fb962320f204d95b8c54fbab63d286e');
INSERT INTO `answer_tb` VALUES ('3b380202aabe49219033d28c1c1e4eb6', 'ds', 'B', '6c1a34a6f69b4802ac2b8d4960f48379');
INSERT INTO `answer_tb` VALUES ('3b787578d76b4c39a5fb1e127db14592', '4', 'D', '02355ba2dc2f49de803e291c5079dc37');
INSERT INTO `answer_tb` VALUES ('3c7a64c423ee4a4a8769cfe33951ebcc', 'c', 'B', 'da1f8aaac8db4b0f963cebedaf5ead91');
INSERT INTO `answer_tb` VALUES ('3d136cdba9294125ba4cd6c968ac1f68', 'df', 'B', 'f9659c72a6c84d208475a2616f194d07');
INSERT INTO `answer_tb` VALUES ('3d67def8fe92411599c306dab288df09', '踩踩踩踩踩踩踩踩', 'B', '7acb4b1ade75456e9feae1309994fda8');
INSERT INTO `answer_tb` VALUES ('3d793929b9bc4e35a6211b73db942724', 'df', 'C', '5b2590de04eb42979453fc22a2082290');
INSERT INTO `answer_tb` VALUES ('3df47f88584e49edb799ccc0907a83e0', '撒旦发射点', 'C', '031406d2139c4edf862f65c81dcaaa4d');
INSERT INTO `answer_tb` VALUES ('3e9acb56147f4226a447725d36541e4a', '两者所能存储的时间范围不一样', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('4048d4e498554bc28b6cd525749d96ec', '是大大撒大撒', 'A', 'f268f977d3054f0f9f4bb8a5a5dc7ebc');
INSERT INTO `answer_tb` VALUES ('4062a3e4e1f14c9b83de81ced11c7ae6', '888888888888888', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('40fcbe812f20488d82e7206e12ac7874', '99999999999', 'A', 'db60e6f84c9d482f90bcfc2450310ed5');
INSERT INTO `answer_tb` VALUES ('410ee5b4c4b749889397db9dc0658346', '对方是个', 'D', '9be3dfd9d53d4be5be77f46253d5417d');
INSERT INTO `answer_tb` VALUES ('422284df0b724f53be519967371c38d7', 'GROUP BY CLASSES', 'C', '8407a759e3b6413d8f78e505272da3f6');
INSERT INTO `answer_tb` VALUES ('424ff92e82ad4ccf88c16050169e4333', 'j', 'D', '410a61e5d00f42a6a6dee7ce08f9b01b');
INSERT INTO `answer_tb` VALUES ('42fd4bcd385e42ccb3bc50af97e76c12', 'sdf', 'A', '81b5e3a72368420eaa65231467955773');
INSERT INTO `answer_tb` VALUES ('44682b70ee86468996ecd835703e6eed', '1212', 'B', '62651268aeba4418a1f2ab5ec82c098a');
INSERT INTO `answer_tb` VALUES ('44ee670e87d7425a959addea17c6383e', 'JKLKJHGF', 'D', 'adf7294c718a4c0eb07fbc83272b4923');
INSERT INTO `answer_tb` VALUES ('468f4fd7534c4d6b87848f9e0a9c9168', 'MybatisMapperConfigurer', 'D', '40a4d0fbdc4a470a992073fde694f70f');
INSERT INTO `answer_tb` VALUES ('46b174e94e6f4d5299c88f5e8b4dfe0f', '顶顶顶顶顶顶顶顶顶顶顶', 'C', '014592a37a544fd8991f069dda8d3433');
INSERT INTO `answer_tb` VALUES ('472ebce46709488a834a35d824cb981f', '999999999999', 'C', 'db60e6f84c9d482f90bcfc2450310ed5');
INSERT INTO `answer_tb` VALUES ('47ce48bba8e54b0e95ecaac2afcab954', '在 ORDER BY 子句中使用 RAND() 函数，并用 LIMIT 子句定义行数', 'D', '90ef01d897c143258ec473387f400abc');
INSERT INTO `answer_tb` VALUES ('4823bda5d93f4ce28f23e6b36073f7d3', 'sdaf', 'D', '500ef279d748478cbbb4e00a81bf3fd2');
INSERT INTO `answer_tb` VALUES ('483c6d07a76b4ce3af2d98b3843ba9df', '12121', 'B', '83772e81135546768ec1370e72b79723');
INSERT INTO `answer_tb` VALUES ('48979df174e44215a1391db1fffb94fa', 'sd发s', 'C', '59ee1e459b754300bd11855cb62ffe6f');
INSERT INTO `answer_tb` VALUES ('4953a656b4c64c589d22b0af20de15f3', 'v', 'D', 'f68b2133215947c0b80e33e4e94af782');
INSERT INTO `answer_tb` VALUES ('49a2fe1f1e934b6886067ff42e9e28e3', 'n', 'C', '410a61e5d00f42a6a6dee7ce08f9b01b');
INSERT INTO `answer_tb` VALUES ('49e998f4ed394e83ba8b7515680f78bf', 'dsf', 'D', '639d45ec2bed4b71b729f81c5810e763');
INSERT INTO `answer_tb` VALUES ('4a9d003d1d2a4a93a40eb6cc5214befa', '设置主键约束，Create index', 'C', '9629eeedc8de4b1fab6c2dbd6b9fd70c');
INSERT INTO `answer_tb` VALUES ('4acff669f9584528ab840ad06331a6ee', '踩踩踩踩踩踩踩踩踩踩踩', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('4c0bc2fa3b4d47eca92a37671c3b54cc', '应急与风险分析', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('4c1f397f8dfd4f3eaf05b0b36f9b75af', 'gh', 'A', '65b62a4a578e4db5b456f4226b4b538e');
INSERT INTO `answer_tb` VALUES ('4d7639daaa904596919bc5a09e8302d3', '1010010100', 'A', '45df7d20236c4b449aade442e63db16f');
INSERT INTO `answer_tb` VALUES ('4d93bc5ebd174075987e63097459e02b', '执行后效果不相同', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('4dc95704dc834e5382e4547948d51d4e', 'g', 'C', 'da1f8aaac8db4b0f963cebedaf5ead91');
INSERT INTO `answer_tb` VALUES ('4e3d3e5b30394f6dbaa746c2c9d03d0f', 'WERTYUI', 'C', 'adf7294c718a4c0eb07fbc83272b4923');
INSERT INTO `answer_tb` VALUES ('4eb624c25dc64d0b9538efa6310a3081', '只要使用LIMIT子句定义指定的行数即可，不使用ORDER BY子句', 'B', 'a080e837f75f4485a99f4886ee99ff19');
INSERT INTO `answer_tb` VALUES ('4ee7e36a55a543848117add51a9eed9e', 'query', 'D', 'f9dd75197c3a407695ef93b2af2104fc');
INSERT INTO `answer_tb` VALUES ('4f55a721ba644507ab171fa51854acc4', '草草草草草草草草草草', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('4f91f19391eb4d3ab1c4d42f7ebfbde3', '212121', 'C', '62651268aeba4418a1f2ab5ec82c098a');
INSERT INTO `answer_tb` VALUES ('4fbcfcce44c24d83931ef5fcc4440575', '是法国三国', 'C', 'ba706533f90741aca42872dab0385ef6');
INSERT INTO `answer_tb` VALUES ('506d869240e5409c96d7b20983d2b061', '萨芬', 'C', '1dc33991cd3f4b9a8e26eec450ab3012');
INSERT INTO `answer_tb` VALUES ('5171b29531b04dcfb2821e80cfc3263b', 'df', 'C', '1ce0d7b4a9e2426eb71d450d36b56062');
INSERT INTO `answer_tb` VALUES ('51843acdf4ab44b48ce4a1273ea9880b', '1111111111111111111111111', 'C', 'f968c8d4bdd240db82f55c2d0cdb061c');
INSERT INTO `answer_tb` VALUES ('51b73de306f74557a73390462dc9f3a5', 'ccc', 'C', '9fca289732664501921d05d0110a3071');
INSERT INTO `answer_tb` VALUES ('51e699cb1f3046769487bdee6163444d', '77777777777', 'A', '42760c1909594f919f38c768807634b7');
INSERT INTO `answer_tb` VALUES ('52b21bc69ed64da3ab546372e3edaf06', '是个特殊广泛的', 'B', '2b958279e88f4d6e8e65815dddf2176e');
INSERT INTO `answer_tb` VALUES ('530e8d29cf33410495369854b14de5f2', 'ccccccccccc', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('539f67a73c0544449e9d37c475f30552', 'ContextListener', 'D', 'dfa6b4880aa54876b900878be19b8d08');
INSERT INTO `answer_tb` VALUES ('54d8afdf9c6d495f995fd840ab97c93b', 'FHJ', 'C', '9681d35f4cae4e0cb680fcfcee39e73f');
INSERT INTO `answer_tb` VALUES ('54dbf1856afe4d06a523bc68af80c757', 'nnnnnnnnnnnnnn', 'D', 'c4f2574e39994e068fdf80347bebe2a9');
INSERT INTO `answer_tb` VALUES ('556c24391bae4ea195b73fffec83d093', 'sdaf', 'C', '0dc10ce59d8d43c7b2003e9999b34307');
INSERT INTO `answer_tb` VALUES ('55ed62ea8e594a3aaf5af6807072201a', 'sheng', 'C', '6ffc4f78a0f2412b8e9b47ca392cb8b5');
INSERT INTO `answer_tb` VALUES ('56182ca199f7453a94579b09ac3a4f5a', 'ccccccccccc', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('56738ab64f9d4b17a61eedd44f033fb9', '      顶顶顶顶顶顶顶顶顶顶顶顶顶', 'B', '4f7830365f5b406db5b6bf4eb229afb4');
INSERT INTO `answer_tb` VALUES ('56f2aa2cce594633934c665dd338b7d0', 'f', 'D', 'a2ba5ee9c4dc4027beb886beea78a2c3');
INSERT INTO `answer_tb` VALUES ('579d00d025b14f47b4d10d6c274650ed', 'MapperScannerConfigurer', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('57a505ce705e44c1a6ade563992de784', '121', 'D', '982cd7a8c1404813b9dd24bf405021db');
INSERT INTO `answer_tb` VALUES ('57c780f9724c47f09be4f63297dca0fb', '士大夫', 'A', '6c1a34a6f69b4802ac2b8d4960f48379');
INSERT INTO `answer_tb` VALUES ('58a55fc314654dfabe18cb044c01705d', '踩踩踩', 'B', 'd4d28e096e294418b68d003cc685ac15');
INSERT INTO `answer_tb` VALUES ('58bef392c85a482c8c99fa2ab261c4c0', 'dddddddd', 'C', '3e8b2838a43f47feb2be194640af78b5');
INSERT INTO `answer_tb` VALUES ('59303c3972df444cbd10f8f90c1403e8', '自增值是可以作为主键的', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('593ce62c76274da59e70605b3368cf6b', '广泛广泛的', 'B', '4827b6bb388b4c3b932599a03df36175');
INSERT INTO `answer_tb` VALUES ('59fceb3aa5d54abaa6b1bc739bae5285', '@Qualifier', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('5a17ac090f0f4251a1ef530ed8983ddf', '士大夫', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('5afbb5950dff4d83961ca1adc9932758', '图形', 'B', 'fb0962da9c194eb49a5e0a07be776750');
INSERT INTO `answer_tb` VALUES ('5b5d9e157758409d83ad88328bc796dc', 'gu', 'B', '6ffc4f78a0f2412b8e9b47ca392cb8b5');
INSERT INTO `answer_tb` VALUES ('5b7d32b7ce134ef8b39c0611250d14e4', '11', 'B', '63b24f080f28428a9b7dfe341c773220');
INSERT INTO `answer_tb` VALUES ('5cc9e692f35e4a7095dd9ed5d14001ae', '12', 'B', '982cd7a8c1404813b9dd24bf405021db');
INSERT INTO `answer_tb` VALUES ('5cd8cf8fbedd4d4d9034ce9c897aaa9e', 'select sal*10,deptno*10 from emp; ', 'D', '3f72176bf27945109780d023045cc4f2');
INSERT INTO `answer_tb` VALUES ('5d3623c65eef4f97b1d34778b8d21cc5', '在业务逻辑层进行事务控制是较为得体的做法', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('5da73b2fc1c248479c2a3e096f33e5e4', '777777777777777', 'D', '42760c1909594f919f38c768807634b7');
INSERT INTO `answer_tb` VALUES ('5e9fbaf716264b46b79971ce0d8621e2', 'df给对方换个地方', 'C', 'd542e33557e044b7950252fdeea569cb');
INSERT INTO `answer_tb` VALUES ('5eec4ca981444d179aaddd62038d30a1', '后置通知', 'B', 'de4ae93ca27743f6a1c9d5b40aa8e740');
INSERT INTO `answer_tb` VALUES ('5f0a0195987f47c595be2bfca6231892', '基于webservice技术的远程数据源', 'C', 'b8ac6fbdfa404ad3a081e59a2618a925');
INSERT INTO `answer_tb` VALUES ('5f355b85c77a4e4db622429c5c76ebf6', 'DataSource需要注入SessionFactory', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('5f6a5b9b1b74449fb44457d3490c4139', 'df', 'D', 'b616fadf12a343048f86bada78526ebc');
INSERT INTO `answer_tb` VALUES ('600a536e55334d31ac054fdddb0c675b', '12', 'C', '982cd7a8c1404813b9dd24bf405021db');
INSERT INTO `answer_tb` VALUES ('612f5bb5c3684d72aaa1cf65eea02a25', 'sdf', 'D', '6c1a34a6f69b4802ac2b8d4960f48379');
INSERT INTO `answer_tb` VALUES ('62397fbec9be4d42bb44169c3683b1be', '44444444444', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('624e3e87d64f4a53b4ed0f5e079b7128', '啊啊啊啊啊啊啊啊', 'A', 'd3892a2dbf8c4666b0e3914d162528e2');
INSERT INTO `answer_tb` VALUES ('62872ea639a24be8b4ae954ef8ddab9d', '抽象类中可以定义构造器', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('62e1e98679164713aa2df5e8db0657d7', '撒打发士大夫', 'A', '031406d2139c4edf862f65c81dcaaa4d');
INSERT INTO `answer_tb` VALUES ('6318ad70506e478c9ec959d107b2113d', '啊', 'C', '42af75326dc44d7f80b4b993241279ef');
INSERT INTO `answer_tb` VALUES ('637c629c9c2a44749ad94f019e4eae44', '2222222', 'B', 'c2aaa86e25ce4373ad3253f3933b02e0');
INSERT INTO `answer_tb` VALUES ('653f181bc1e14c99b2b83cdc66e5b300', 'sdf', 'B', '81b5e3a72368420eaa65231467955773');
INSERT INTO `answer_tb` VALUES ('655292d53df942b38c44d5f5c7a23b3b', '11111111111111111111111111111111', 'D', 'f968c8d4bdd240db82f55c2d0cdb061c');
INSERT INTO `answer_tb` VALUES ('65e156de24cd410db8ed73009a314660', '33333333333', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('65ec8c44f3ab4c19a1e8e88524fd23d8', 'JdbcDaoSupport', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('65f529c9306b4f9ebb82fb79dcb229d7', 'select sal+1 from emp;', 'A', '3f72176bf27945109780d023045cc4f2');
INSERT INTO `answer_tb` VALUES ('668e5b2100d240e496e6923ee993b6cd', '的说法是', 'A', '3fb962320f204d95b8c54fbab63d286e');
INSERT INTO `answer_tb` VALUES ('6722cadc023140748a1d3218d88473d2', '只要使用 LIMIT 子句定义指定的行数即可，不使用 ORDER BY 子句', 'B', '90ef01d897c143258ec473387f400abc');
INSERT INTO `answer_tb` VALUES ('67d02a65744140f382485c1c9ce6132f', 'sdf', 'B', '75e93e57f4b04f3ab6a83d33b339ffd2');
INSERT INTO `answer_tb` VALUES ('6852487ad403482cb1f53f73d419d880', '88888888888', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('6903d13af6c045feba5424ac89ade52f', 'cccccccc', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('6981e830e3884448989ab50272a1db7c', '121', 'C', 'e172ca9e88544e6e9d448f466717e946');
INSERT INTO `answer_tb` VALUES ('6a4205cee63b4497981c3797638ca59a', '前置通知', 'A', 'de4ae93ca27743f6a1c9d5b40aa8e740');
INSERT INTO `answer_tb` VALUES ('6a7cfc5438f44ad0bc441a313066eef2', '十大盛大的', 'D', 'f268f977d3054f0f9f4bb8a5a5dc7ebc');
INSERT INTO `answer_tb` VALUES ('6ab39419afbd493092371480a0e3ccbb', '允许有多个主键', 'C', '9059c72c51604f6aa14ab09447638c98');
INSERT INTO `answer_tb` VALUES ('6b202e0096a945a58d7aa5f6d8ee3a15', '12', 'B', '84ada2c55efc4030a7f5392ab3c7cb6b');
INSERT INTO `answer_tb` VALUES ('6b92971f681b471bb9e57493415be48a', 'j', 'D', 'da1f8aaac8db4b0f963cebedaf5ead91');
INSERT INTO `answer_tb` VALUES ('6bf1122f8928499da9461321d04e0287', 'cccccc', 'C', 'e0ed24fda2a9475fa6821fd22cc9dbc4');
INSERT INTO `answer_tb` VALUES ('6c387b64be944a759395ac43161866c9', 'tt', 'D', '3c3e033b7481482ea6722fc72069aa32');
INSERT INTO `answer_tb` VALUES ('6d13e566f5a2463fbbd4bdd868e06818', '的发挥', 'D', '7ba5d89c01104b1381456ebc135d8e28');
INSERT INTO `answer_tb` VALUES ('6d8bcd6337f74c95ae700086f7aa12f1', 's', 'A', 'f7061a223dd5447c9a8bdd4215e76753');
INSERT INTO `answer_tb` VALUES ('6d976baec29b40a8bb233432f461df2d', 'dfs给', 'C', '9be3dfd9d53d4be5be77f46253d5417d');
INSERT INTO `answer_tb` VALUES ('71546a671c404534ab50ec191ad470bf', '飞洒地方', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('7158d31eefb444238b2b7146eb52182d', 'dsfsd', 'B', '639d45ec2bed4b71b729f81c5810e763');
INSERT INTO `answer_tb` VALUES ('71b7944a67014bb4b9191c8efede208e', '<bean>节点的abstract属性表示不可以获得其实例', 'C', '485749f02ccc4597968f6f59cf663b45');
INSERT INTO `answer_tb` VALUES ('71e13192df4b4980bc601e610d15b031', '对方是否', 'A', '3a92867b637044feba215def83937274');
INSERT INTO `answer_tb` VALUES ('7248e6404c2a4090bfaf834c160cc486', 'sadf', 'A', '0dc10ce59d8d43c7b2003e9999b34307');
INSERT INTO `answer_tb` VALUES ('728087e977f043bdba4543fb6ff5c4bd', 's', 'B', 'f7061a223dd5447c9a8bdd4215e76753');
INSERT INTO `answer_tb` VALUES ('7399b077f2e4437ebfe02b8ea097dffa', '调度', 'D', '3a415b5710ba4446ba5004032e5350bd');
INSERT INTO `answer_tb` VALUES ('73df8d38345d4c10b9cb9bbba52bc8ca', '33333333', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('74122c19760349c08b13d25cf4bf85da', '依赖注入的目标是在代码之外管理程序组件间的依赖关系', 'A', '3ee3c349f6e7475493163220592c3b41');
INSERT INTO `answer_tb` VALUES ('746b377cf1034ca2b2af1cbe7a77752e', 'eeeeeeee', 'B', '83101d78a98d40c48cbd90409faa65d0');
INSERT INTO `answer_tb` VALUES ('74be3eb3a78a4a788fbabdc55d37ca50', '广泛的', 'A', '91c6dddbdffd4eec8d894853c072feea');
INSERT INTO `answer_tb` VALUES ('759891b7ce47450f97ffacc0fe33d1ba', '111111111111', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('763e269d544042febdef3949f50e5499', '你是!!!', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('765186df2cb64bd3815af46b8f651810', '1212', 'C', '21f77485fcc642e99f060c554996c11a');
INSERT INTO `answer_tb` VALUES ('76600bc1f8594fc7b91587d35b2f571c', '国防经费', 'B', 'bb48dafd6ede404b81561eb9fdae3fef');
INSERT INTO `answer_tb` VALUES ('76623ca0690048ba83c891c858186b20', '干活', 'C', '91c6dddbdffd4eec8d894853c072feea');
INSERT INTO `answer_tb` VALUES ('767e050f19934ad2977eb7c01a2218a0', '以上都可以', 'D', 'fb0962da9c194eb49a5e0a07be776750');
INSERT INTO `answer_tb` VALUES ('7692f376b13d47ab9bac675bd1a4f4cb', 'sadf', 'B', 'cc3166f3f57b4367b35029beff5b96c8');
INSERT INTO `answer_tb` VALUES ('7706bfd19d47409a965276a603c92aec', '高房价和', 'C', 'bb48dafd6ede404b81561eb9fdae3fef');
INSERT INTO `answer_tb` VALUES ('773c0275577746f5865b1693adc05591', 'nnnnnnnnnnn', 'B', 'c4f2574e39994e068fdf80347bebe2a9');
INSERT INTO `answer_tb` VALUES ('774e3b65c27348059bceb5387253f61c', '1212121212121212', 'B', '754ac78e8a8f44c2bf8fd5d589550d7b');
INSERT INTO `answer_tb` VALUES ('781b2c29068a4078ab69dae159c98659', '5555555555', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('78838a082a374ff48d8e8d35e0412635', 'nnnnnnnnnnn', 'A', 'c4f2574e39994e068fdf80347bebe2a9');
INSERT INTO `answer_tb` VALUES ('78e88c5e26ff421a95ecf7056f8642e9', '啊啊啊啊啊啊啊啊', 'B', 'd3892a2dbf8c4666b0e3914d162528e2');
INSERT INTO `answer_tb` VALUES ('78f5bf3096bc4965913253d3da976eb2', '000000000000', 'C', '45df7d20236c4b449aade442e63db16f');
INSERT INTO `answer_tb` VALUES ('78f61b37acaa4dc9b9733de471d70134', '士大夫', 'D', '59ee1e459b754300bd11855cb62ffe6f');
INSERT INTO `answer_tb` VALUES ('7a84b36bec784337be5b8217a34755d3', 's\'da\'f', 'B', 'cb1c9a87df79402da5fdfe023ecb449b');
INSERT INTO `answer_tb` VALUES ('7b1a9fcf7ebe4cf2802ce4ca81d0fb4e', '啊啊', 'B', '5e99816699024f68b6cb2c3795676ab2');
INSERT INTO `answer_tb` VALUES ('7b1c8143e43e491daf7c7d9ecbaf7d73', '草草草草', 'A', 'd4d28e096e294418b68d003cc685ac15');
INSERT INTO `answer_tb` VALUES ('7c7702a1fcef46cba0c85968e274b41c', '接口中可以定义构造器', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('7c8847b617e44bebaab0137e0443f775', '萨芬', 'D', 'b6e43f85fd1a44188ef6ee606aaa868d');
INSERT INTO `answer_tb` VALUES ('7cba0f8d55604e0b90906e933a35c15b', 'ccccccccccccccc', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('7d3207bc334b4fdaad0ef75efc171de7', '实现了业务逻辑层与持久层的分离', 'B', 'd18dade15e174531bce42f5c0fe64ab1');
INSERT INTO `answer_tb` VALUES ('7d42e22d77244cc8b4bcd57690bbc87d', '@Before', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('7d8d14494d79466691375524d5d1bc9a', '打撒发2', 'A', '0df24612f265482d8b318ba9e64fcc55');
INSERT INTO `answer_tb` VALUES ('7f065e93b0e14fff9a6e0c2e41b53976', '有替他一', 'B', '30bc29e0ca38499aaab39578657fa367');
INSERT INTO `answer_tb` VALUES ('7f79e318d57a4993ad94313bdb4542c0', '在视图上定义新的表', 'D', '8ec766327e334c11bdc3e7ddda2e4df9');
INSERT INTO `answer_tb` VALUES ('8012024af0b84358b3e60c14652d26e7', '22', 'D', '5bcc41ca2cef43c7844a60168cd42656');
INSERT INTO `answer_tb` VALUES ('804492056faf4ff586ab3df6a686b773', 's', 'A', 'da1f8aaac8db4b0f963cebedaf5ead91');
INSERT INTO `answer_tb` VALUES ('808b13ae075448cf99a27f1ec3db1d9b', '1212', 'D', '62651268aeba4418a1f2ab5ec82c098a');
INSERT INTO `answer_tb` VALUES ('811bc1665cc549bbb3a878a5aa6a663d', 'a\'a\'a', 'A', '9fca289732664501921d05d0110a3071');
INSERT INTO `answer_tb` VALUES ('817ef101f79947da89030458ec264285', '555555', 'D', 'dc8a5fe1553c4a1c83209dc7a5121982');
INSERT INTO `answer_tb` VALUES ('82338d1d8f1e46e496d69d4a148d8f34', 'cb', 'C', '5a1647ca5ea04ddaa05fa9f4a33e652e');
INSERT INTO `answer_tb` VALUES ('826249333ee24aefbd6340b32d41e6d8', '8888888888888888888', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('827c38d404ac44e2bc758a471b174959', 'sdaf十大', 'C', 'cb1c9a87df79402da5fdfe023ecb449b');
INSERT INTO `answer_tb` VALUES ('834e70da8a0742c5a9d334302c2b5ab6', 'update', 'C', 'f9dd75197c3a407695ef93b2af2104fc');
INSERT INTO `answer_tb` VALUES ('838916d914974c0294049c13b3a44376', 'sdaf', 'D', '1eca2542d77d4875979ad068a5ed586f');
INSERT INTO `answer_tb` VALUES ('83df5f8a57ca4e88b18fc61ff5f990a9', '12', 'C', '41cc71e09b064220a89b557a08868471');
INSERT INTO `answer_tb` VALUES ('8401822dc0364b8e99f0bd690951288e', 'select sal*10,sal*deptno from emp;', 'B', '3f72176bf27945109780d023045cc4f2');
INSERT INTO `answer_tb` VALUES ('840585ef7dd843369e23727cbbbbc6b0', 'sdafsdaf', 'A', '1eca2542d77d4875979ad068a5ed586f');
INSERT INTO `answer_tb` VALUES ('848d91f4781c427da18d1753a6394ce7', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', '014592a37a544fd8991f069dda8d3433');
INSERT INTO `answer_tb` VALUES ('8494dbde6e1844839b494102fa023706', '调度', 'C', '3a415b5710ba4446ba5004032e5350bd');
INSERT INTO `answer_tb` VALUES ('84c219f051214963858179f8c1737752', 'ContextLoaderListener', 'B', 'dfa6b4880aa54876b900878be19b8d08');
INSERT INTO `answer_tb` VALUES ('85201f2d41504ee6b8c6773feadcd5d0', '55555555', 'C', 'dc8a5fe1553c4a1c83209dc7a5121982');
INSERT INTO `answer_tb` VALUES ('856c4f001d214ecdae338156e215dd8f', '4444444444', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('8785e950745b4dbaa6e4ace9e21bf0b6', 'd', 'A', '410a61e5d00f42a6a6dee7ce08f9b01b');
INSERT INTO `answer_tb` VALUES ('8802ed6941ef4bfa98d0abd5c412148f', '萨芬', 'B', '1dc33991cd3f4b9a8e26eec450ab3012');
INSERT INTO `answer_tb` VALUES ('885abfcded024e0ca2f991ea679e91b7', 'UNION', 'C', 'bcc10a19f6544e01a99070fea998b2d9');
INSERT INTO `answer_tb` VALUES ('88b982973dc942afb6f36fea4e70b798', '12222', 'A', '8956a2433a4b42ba96d495dff59db9df');
INSERT INTO `answer_tb` VALUES ('899829b55b4442c2bd224708d75595b5', '55555555555', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('89b99cb2ae5942b3bc0612cd3034f27a', 'ddddddd', 'B', '3e8b2838a43f47feb2be194640af78b5');
INSERT INTO `answer_tb` VALUES ('89f854bb128e45cb9db4ab9fc81ff33a', 'Spring的目标是使现有的技术变的更加好用', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('8a7e44c706894058b3632b7761be6a50', 's', 'C', 'f7061a223dd5447c9a8bdd4215e76753');
INSERT INTO `answer_tb` VALUES ('8a7fae2f386e4f3da751501783f941ad', 'ertyu', 'D', '65b62a4a578e4db5b456f4226b4b538e');
INSERT INTO `answer_tb` VALUES ('8a96e8421cd145708378ac1dd9152778', 'nnnnnnnnnnnnnnnnnnn', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('8aa64cf54ff649a5adbec37e344b1c50', '121212', 'C', '84ada2c55efc4030a7f5392ab3c7cb6b');
INSERT INTO `answer_tb` VALUES ('8b83101b35cd452b957af5ad577545c6', 'i', 'D', '6ffc4f78a0f2412b8e9b47ca392cb8b5');
INSERT INTO `answer_tb` VALUES ('8bb12f88d8e341fe8cf0267ac4f54efe', 'cccccc', 'A', 'e0ed24fda2a9475fa6821fd22cc9dbc4');
INSERT INTO `answer_tb` VALUES ('8bb43c0ac8be42e2a7a9a682ca11125d', 'DF', 'A', '9681d35f4cae4e0cb680fcfcee39e73f');
INSERT INTO `answer_tb` VALUES ('8bd63371133c421a9d79ba89d86d17c8', '@Component', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('8cc0581035e649feaea61f6346997842', '00000000000000000', 'D', '45df7d20236c4b449aade442e63db16f');
INSERT INTO `answer_tb` VALUES ('8d33a9bc014749a5bed281c6d8a28452', '为标识表中唯一的实体', 'D', '9059c72c51604f6aa14ab09447638c98');
INSERT INTO `answer_tb` VALUES ('8d519d58802749f8b126913e5248afde', '@Resource', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('8d764dc5ac2441f3a9097c08875d9cf3', '电风扇广泛', 'A', 'ba706533f90741aca42872dab0385ef6');
INSERT INTO `answer_tb` VALUES ('8daaaeeadd5642fe94644e46960afda9', '啊啊啊啊啊啊啊啊啊', 'D', 'd3892a2dbf8c4666b0e3914d162528e2');
INSERT INTO `answer_tb` VALUES ('8dce047c6f484f1e97931c2c43ee8030', '草草草草', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('8e747fbcabe14229beb3bbbcd3d73663', 'Spring提供依赖注入容器、AOP实现、DAO/ORM支持、Web集成等功能', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('90069b4e297340aeb2b8086d2cda9855', '撒打发手动阀手动阀12313', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('90a261b9e5e4478aa8f7c4f7b886291e', '顶顶顶顶顶顶顶顶顶顶', 'D', '014592a37a544fd8991f069dda8d3433');
INSERT INTO `answer_tb` VALUES ('91dcf2fed5714284a5f27066acf6ad29', '的书法国画大师 ', 'A', '9be3dfd9d53d4be5be77f46253d5417d');
INSERT INTO `answer_tb` VALUES ('924f9e7d992d49df9c4fffdccdba9bcd', '77777777777', 'C', '42760c1909594f919f38c768807634b7');
INSERT INTO `answer_tb` VALUES ('92cbf29e70124f4eb55761cbce3716ed', 'tyiu他又', 'D', '30bc29e0ca38499aaab39578657fa367');
INSERT INTO `answer_tb` VALUES ('934df5fc836d4dda9eec9ec7264f60af', '撒地方', 'A', 'b6e43f85fd1a44188ef6ee606aaa868d');
INSERT INTO `answer_tb` VALUES ('939fd373c3884088aa9e185e324b0362', '基于连接池的本地数据源', 'D', 'b8ac6fbdfa404ad3a081e59a2618a925');
INSERT INTO `answer_tb` VALUES ('94353cd644264094a97426cb8398a63f', 'sdaf', 'A', '500ef279d748478cbbb4e00a81bf3fd2');
INSERT INTO `answer_tb` VALUES ('9468dfc9592344728725eb73bbc516b6', '依赖注入是面向对象技术的替代品', 'C', '3ee3c349f6e7475493163220592c3b41');
INSERT INTO `answer_tb` VALUES ('9470bdcb39064724b9089a76171a1674', '11121', 'B', '8956a2433a4b42ba96d495dff59db9df');
INSERT INTO `answer_tb` VALUES ('94c1ee43029949f1b0b23bc10036f823', 'f', 'C', 'a2ba5ee9c4dc4027beb886beea78a2c3');
INSERT INTO `answer_tb` VALUES ('964c7584f7574cb780fe4504e5f6a66e', '1111', 'C', '8956a2433a4b42ba96d495dff59db9df');
INSERT INTO `answer_tb` VALUES ('9715cc1518e8463389da82e6aa303b01', '案说法', 'A', '4827b6bb388b4c3b932599a03df36175');
INSERT INTO `answer_tb` VALUES ('97b38a6d138d43be92533cdac154bbfc', 'dddddddd', 'A', '3e8b2838a43f47feb2be194640af78b5');
INSERT INTO `answer_tb` VALUES ('98792deddfac41d7a6f671545018b2fb', 'def', 'A', '1ce0d7b4a9e2426eb71d450d36b56062');
INSERT INTO `answer_tb` VALUES ('99bfff42f66e47bf975c3e0ac5915c2f', '121212454', 'C', 'd2876869659f4965bc0100d474b590f2');
INSERT INTO `answer_tb` VALUES ('9a441d9ada5642b990664b5c740578ad', '查询 ', 'A', '8ec766327e334c11bdc3e7ddda2e4df9');
INSERT INTO `answer_tb` VALUES ('9aa335f54fba4e2fbf40e281c5844f40', '设置通知', 'D', 'de4ae93ca27743f6a1c9d5b40aa8e740');
INSERT INTO `answer_tb` VALUES ('9aa390ad855d4e51be60266589844f4f', 'dsf', 'C', '6c1a34a6f69b4802ac2b8d4960f48379');
INSERT INTO `answer_tb` VALUES ('9ab2ed891d2746299092838ec766d269', 'sdaf', 'A', 'b4920096b925466284c762b21070a39c');
INSERT INTO `answer_tb` VALUES ('9ab9cf89b88549d28c41928a26052b4a', '的发挥', 'C', '7ba5d89c01104b1381456ebc135d8e28');
INSERT INTO `answer_tb` VALUES ('9afebbf3426a4419be6d88e72b9053b5', 'sdaf', 'B', 'ff585cb24a044775aad1ee145f1c6811');
INSERT INTO `answer_tb` VALUES ('9b54ee2b755d43e28be82ec748704f72', 'BUAI', 'B', 'a1b089a053224d009872d717137c2e1a');
INSERT INTO `answer_tb` VALUES ('9ba9a6443a4948bfbfa1f4223b9fad5b', 'CHAOAI', 'D', 'a1b089a053224d009872d717137c2e1a');
INSERT INTO `answer_tb` VALUES ('9c56c2bb90bc477db66d91af58a0ffa5', '切入点表达式必须包含返回类型模式', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('9c613ba690e04e979b023b7e14baa80d', '法国和', 'D', 'bb48dafd6ede404b81561eb9fdae3fef');
INSERT INTO `answer_tb` VALUES ('9c79346d49954e0b9781d88446a41d5a', 'sdaf', 'C', 'ff585cb24a044775aad1ee145f1c6811');
INSERT INTO `answer_tb` VALUES ('9ca656bbcea44742b180cc17637e5fec', '666', 'D', 'c16a1df2918640658008d75e6204b46a');
INSERT INTO `answer_tb` VALUES ('9d17a633ae574eb38b56e6c8be861ec3', 'MapperConfigurer', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('9d85fcb4e62e4d05ab740a13b670dabe', '12', 'A', '83772e81135546768ec1370e72b79723');
INSERT INTO `answer_tb` VALUES ('9d94b5fe3e9b4f1b80af86367e7fd2b3', '依赖注入会增大程序的规模', 'D', '3ee3c349f6e7475493163220592c3b41');
INSERT INTO `answer_tb` VALUES ('9e1666f6ddf44270aae7e201093b9989', '123132123', 'D', '254498176e7748899a1b0b1eb4ef13b7');
INSERT INTO `answer_tb` VALUES ('9e27903235bf462c9eb5dde6f772418b', 'AI', 'A', 'a1b089a053224d009872d717137c2e1a');
INSERT INTO `answer_tb` VALUES ('9e5297064b3c46b49d632adf6e474639', '45454', 'B', 'd2876869659f4965bc0100d474b590f2');
INSERT INTO `answer_tb` VALUES ('9e86c58b30a44e7198ad5a439ce696a4', 'LIMIT', 'D', 'bcc10a19f6544e01a99070fea998b2d9');
INSERT INTO `answer_tb` VALUES ('9f402273d15b4d0e91d86e9dafac3a46', 'fsdfsdf', 'C', '639d45ec2bed4b71b729f81c5810e763');
INSERT INTO `answer_tb` VALUES ('9f44c050422744c0aef99a0e26e67a14', 'eeeeeeeeee', 'A', '83101d78a98d40c48cbd90409faa65d0');
INSERT INTO `answer_tb` VALUES ('9f749a3201ea46929b9c22cdd54c47e3', '3333', 'B', '9ba068ddc72e474090f9b774a330f75b');
INSERT INTO `answer_tb` VALUES ('9fd32efd69b2496ab9cd18904fd2da7c', 'nnnnnnnnnnnnnnnnnnnnn', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('a139b867734545628d133f080253e43c', 'sdaf', 'A', '67767c2bd6664757af922362b2634868');
INSERT INTO `answer_tb` VALUES ('a1fbbc9f20594809827098cfeceb0483', '士大夫 ', 'D', '2d6e87af1bb140f4bbace58799220a1d');
INSERT INTO `answer_tb` VALUES ('a230ecc245034c468c3a5f81fd62a382', 'NamedParameterJdbcTemplate', 'D', '7dc83a074a8443cf99f5e3eea203a1f0');
INSERT INTO `answer_tb` VALUES ('a2d47747b47d4e6796758077862a3b1b', '11', 'A', '63b24f080f28428a9b7dfe341c773220');
INSERT INTO `answer_tb` VALUES ('a2e0bc0b60984d7e9fd35a340d0c95de', 'sdaf', 'B', '1eca2542d77d4875979ad068a5ed586f');
INSERT INTO `answer_tb` VALUES ('a2f9957348b541c4bff6a5557bd89b51', '而他也 ', 'C', 'adb65d3fd30b4d33a761ad3e3d6b45ed');
INSERT INTO `answer_tb` VALUES ('a3cb9c1f48b641679f0dde14c782d924', '口语哭一哭', 'C', '30bc29e0ca38499aaab39578657fa367');
INSERT INTO `answer_tb` VALUES ('a3d761f2fd2b40809449d60088cc4253', '@After', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('a45461b5931d4290a8e03e26f862263c', '啊', 'B', 'cd883c3caa704f0cacffe7e08f81c6f7');
INSERT INTO `answer_tb` VALUES ('a4e3579fa6414d5a885d4214b5b98c72', '非官方的好的d\'f', 'B', 'd542e33557e044b7950252fdeea569cb');
INSERT INTO `answer_tb` VALUES ('a541c3ac372145e3a18a78fc36c54a96', '333333', 'D', '9ba068ddc72e474090f9b774a330f75b');
INSERT INTO `answer_tb` VALUES ('a60473c604c64d8a84fd7a66188b1f4b', '每个表可以建立多个主键', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('a63130928e634aca876c9f4278d59d9b', '99999999999', 'B', 'db60e6f84c9d482f90bcfc2450310ed5');
INSERT INTO `answer_tb` VALUES ('a6bec4ad24ec420eba9dd9dbce089f55', '草草草草草草草草草草', 'C', '7acb4b1ade75456e9feae1309994fda8');
INSERT INTO `answer_tb` VALUES ('a7337901bc204ce58b30c1a7da3818bd', 'JdbcTemplate', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('a7ebeb4bf0574d5ca3d874ab8ba12d6b', 'df', 'D', 'f9659c72a6c84d208475a2616f194d07');
INSERT INTO `answer_tb` VALUES ('a84384d5e00c47ed98b69a091946cce8', '是法国 ', 'D', '8472fa0598c64437978e6f375b4527c5');
INSERT INTO `answer_tb` VALUES ('a865b6fd62544142aafe36fea1463a62', '提高开发效率', 'C', 'd18dade15e174531bce42f5c0fe64ab1');
INSERT INTO `answer_tb` VALUES ('a9c6dbca9d5840d3aba5b96fa66f21bd', '@Aspect', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('a9e09dcada8d46c388959e5469e06a91', '111111111111', 'A', 'f968c8d4bdd240db82f55c2d0cdb061c');
INSERT INTO `answer_tb` VALUES ('aa2a21fb9cc544baa5543e30dddbecd1', 'c', 'B', '410a61e5d00f42a6a6dee7ce08f9b01b');
INSERT INTO `answer_tb` VALUES ('aacac62fe07c405c9437887abc0bf982', 'sadf', 'C', '1eca2542d77d4875979ad068a5ed586f');
INSERT INTO `answer_tb` VALUES ('aaedfbf577054cc7855ade067084a67c', '在 LIMIT 子句中使用 RAND() 函数指定行数，并用 ORDER BY 子句定义一个排序规则', 'A', '90ef01d897c143258ec473387f400abc');
INSERT INTO `answer_tb` VALUES ('ab00ba1adcca44929d4fce37b5340ae6', '1212', 'B', '0df24612f265482d8b318ba9e64fcc55');
INSERT INTO `answer_tb` VALUES ('ab263aad5a864b948b4c37e77abd26a8', '爱的发声', 'C', '3a92867b637044feba215def83937274');
INSERT INTO `answer_tb` VALUES ('ab55365945b244d094087333d0af8aa7', 'set注入方式依赖对象先注入', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('ac1723710f35439aaeb7021492c4b3ab', '只要在ORDER BY子句中使用RAND()函数，不使用LIMIT子句', 'C', 'a080e837f75f4485a99f4886ee99ff19');
INSERT INTO `answer_tb` VALUES ('ac4cc9c192a54363af88c1ca005fbeb6', '士大夫', 'B', '9123ee4c071a430295a62426b29dff28');
INSERT INTO `answer_tb` VALUES ('ac8a474bd7ad4428b0559fb2b77d7f38', '1212', 'C', 'f13dfb4f72874182bd884be97da7868b');
INSERT INTO `answer_tb` VALUES ('ac8e92b3f89a427db96f302ad48572f3', '只允许以表中第一字段建立', 'B', '9059c72c51604f6aa14ab09447638c98');
INSERT INTO `answer_tb` VALUES ('ace1d54e4c09415481aaecf87563d63c', 'ALL', 'B', 'bcc10a19f6544e01a99070fea998b2d9');
INSERT INTO `answer_tb` VALUES ('ad110b9821204ce8b1aabebd63bb16a8', '大', 'C', '9123ee4c071a430295a62426b29dff28');
INSERT INTO `answer_tb` VALUES ('ad7320f5e64e42d89567d3d027b8340c', 'v', 'C', 'f68b2133215947c0b80e33e4e94af782');
INSERT INTO `answer_tb` VALUES ('ad7b9d3b080f40ef959ee707d20d4456', '的萨芬', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('adc956b9d61540798b601d4caa8d4886', 'sdaf', 'D', '67767c2bd6664757af922362b2634868');
INSERT INTO `answer_tb` VALUES ('adf412dff4cb46eb89d6f807559777a4', '士大夫', 'B', '2d6e87af1bb140f4bbace58799220a1d');
INSERT INTO `answer_tb` VALUES ('ae1d991b9f2147bf829974f1ed8ad8a6', '十大高手给', 'C', '2b958279e88f4d6e8e65815dddf2176e');
INSERT INTO `answer_tb` VALUES ('ae666cd9cc1e410b8b649d7784f9bad3', '12', 'B', '41cc71e09b064220a89b557a08868471');
INSERT INTO `answer_tb` VALUES ('aea0a2342a1440f7b1727a2a99f6ba1d', '方法全部都是抽象发现', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('aee89bec2f8a4e979be52bf0761a5fc5', '的方法更好地发挥给', 'A', 'd542e33557e044b7950252fdeea569cb');
INSERT INTO `answer_tb` VALUES ('afd01103d89e4f1989877f4121b4c5c6', '11', 'D', '63b24f080f28428a9b7dfe341c773220');
INSERT INTO `answer_tb` VALUES ('aff4756bf75a4f74a5ee9695444adde9', '以上都可以', 'D', '9629eeedc8de4b1fab6c2dbd6b9fd70c');
INSERT INTO `answer_tb` VALUES ('b06658eceae34464b54553fee5aa6706', 'cccccccccc', 'B', 'e0ed24fda2a9475fa6821fd22cc9dbc4');
INSERT INTO `answer_tb` VALUES ('b09bb0e65f574bd4905719a416339401', '实现了视图、控制器与模型的彻底分离', 'A', 'd18dade15e174531bce42f5c0fe64ab1');
INSERT INTO `answer_tb` VALUES ('b0abb9e22950402b87239cb9f8d21ba4', 'MapperScannerConfigurer', 'A', '40a4d0fbdc4a470a992073fde694f70f');
INSERT INTO `answer_tb` VALUES ('b18819b536324194b0b725e0ed09c164', '士大夫', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('b1960fbcaf0a4580a3d79b9b492da30b', 'ContextLoaderAction', 'C', 'dfa6b4880aa54876b900878be19b8d08');
INSERT INTO `answer_tb` VALUES ('b1d7b738a68b47959884b1f5487e11af', 'SimpleJdbcTemplate', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('b2ab38bf2237485eb11a77ee599a8c4c', 'IO', 'D', '9681d35f4cae4e0cb680fcfcee39e73f');
INSERT INTO `answer_tb` VALUES ('b437415c0cdb4299a66953201aeb323d', 'cccccccc', 'D', 'e0ed24fda2a9475fa6821fd22cc9dbc4');
INSERT INTO `answer_tb` VALUES ('b47fad0bfade45e8aad49a6eafb9a265', '1212', 'D', 'fd6e3f3027644007aa5b8b3d049860a4');
INSERT INTO `answer_tb` VALUES ('b5bb5074d6e1427eb3a6cf4f51bce2af', '以上都对', 'D', 'd18dade15e174531bce42f5c0fe64ab1');
INSERT INTO `answer_tb` VALUES ('b61b579bb3484c928121170de6428a1d', '广东佛山', 'B', '8472fa0598c64437978e6f375b4527c5');
INSERT INTO `answer_tb` VALUES ('b6a1c93758a4434c8f1cbc24d9aa8443', '1212', 'D', '84ada2c55efc4030a7f5392ab3c7cb6b');
INSERT INTO `answer_tb` VALUES ('b702df772b54410d858a557cadc701b8', '士大夫', 'A', '2d6e87af1bb140f4bbace58799220a1d');
INSERT INTO `answer_tb` VALUES ('b7df9e9d3a884578a6f2f44e3a75aa4a', '<aop:after method=\"before\" pointcut-ref=\"p1\" />', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('b7eb906533694ebb925d0a594d87fa17', '12', 'B', 'e172ca9e88544e6e9d448f466717e946');
INSERT INTO `answer_tb` VALUES ('b915f3e1dddb421584b4b29f6f083fb1', '的撒', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('b978b082b407431aabae63824d302cbf', '12', 'A', 'e172ca9e88544e6e9d448f466717e946');
INSERT INTO `answer_tb` VALUES ('b97c2d0cde7d44d981d95b157ec9d84f', 'sdaf', 'D', 'b4920096b925466284c762b21070a39c');
INSERT INTO `answer_tb` VALUES ('b9f41e685b1342058fab3fdf0026d781', 'zhu', 'A', '6ffc4f78a0f2412b8e9b47ca392cb8b5');
INSERT INTO `answer_tb` VALUES ('ba47506d59784a7fa54107ac5850ecbd', '888888888888', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('ba803d786895407bab5acd05d4b378c9', 'sdaf', 'B', '67767c2bd6664757af922362b2634868');
INSERT INTO `answer_tb` VALUES ('ba9b97fbef3e483e8a8fcd13eb6144e0', 'GROUP CLASSES ', 'D', '8407a759e3b6413d8f78e505272da3f6');
INSERT INTO `answer_tb` VALUES ('bae7a97b65644ebd9f650eb4387bd1ad', 'df', 'B', '5b2590de04eb42979453fc22a2082290');
INSERT INTO `answer_tb` VALUES ('bb8b7e63ce774e009b083f66b815c985', '士大夫士大夫', 'B', '031406d2139c4edf862f65c81dcaaa4d');
INSERT INTO `answer_tb` VALUES ('bd3689277a0c452d83c93749114761b3', '<aop:after-throwing  pointcut-ref=\"p1\" />', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('bd7b31ff9c444550b6180a18202e065d', '审计跟踪', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('bf118a3c408e4c748d929f9bba0b5be7', '反对共和的', 'A', '7ba5d89c01104b1381456ebc135d8e28');
INSERT INTO `answer_tb` VALUES ('bf5399b7d7c84299b0a9a98c8b3f64e9', 'df', 'D', '1ce0d7b4a9e2426eb71d450d36b56062');
INSERT INTO `answer_tb` VALUES ('c062a5d596914b5397655e54a4f33265', 'sdf', 'C', 'cc3166f3f57b4367b35029beff5b96c8');
INSERT INTO `answer_tb` VALUES ('c0c68f986e1a491591a5cd00bd1e104b', 'eeeeeeee', 'C', '83101d78a98d40c48cbd90409faa65d0');
INSERT INTO `answer_tb` VALUES ('c11f2cb8d5874cfdb0555ed3b966a4ff', 'Spring DAO需要注入SessionFactory', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('c20a5862b3c84506b47469c7d6b99570', '顶顶顶顶顶顶顶顶顶顶顶', 'C', '4f7830365f5b406db5b6bf4eb229afb4');
INSERT INTO `answer_tb` VALUES ('c2104886730e447f8220d38f472d9bcd', 'sdfsdf', 'A', '639d45ec2bed4b71b729f81c5810e763');
INSERT INTO `answer_tb` VALUES ('c31f146ba3ee4d49aa95604b1f911905', '1111', 'D', '8956a2433a4b42ba96d495dff59db9df');
INSERT INTO `answer_tb` VALUES ('c321b617fc8c4b0f92f4e41a86b5ae6f', '1111111111', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('c356bed068864192a5d7c61e23af8eac', '由JDBC驱动程序定义的数据源', 'A', 'b8ac6fbdfa404ad3a081e59a2618a925');
INSERT INTO `answer_tb` VALUES ('c36489bc35a3472ba080e919e90b4dfb', '12', 'A', '21f77485fcc642e99f060c554996c11a');
INSERT INTO `answer_tb` VALUES ('c4d1c29f26704022ac78eb16bf69ee26', '规范化', 'A', 'bb48dafd6ede404b81561eb9fdae3fef');
INSERT INTO `answer_tb` VALUES ('c4dc1fcdef9943c5b7df7d04362e1383', '啊', 'B', '42af75326dc44d7f80b4b993241279ef');
INSERT INTO `answer_tb` VALUES ('c611803e66034a5a8ffecbc996ba359b', 'dddd', 'D', '9fca289732664501921d05d0110a3071');
INSERT INTO `answer_tb` VALUES ('c6e325a1b25544e595132afe78aa2ea4', 'ccccccccccccc', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('c6f4da6001cd4a898109ace585c70a53', '同意一天', 'A', '30bc29e0ca38499aaab39578657fa367');
INSERT INTO `answer_tb` VALUES ('c740943446154664b8b7f275d31c2727', '啊士大夫嘎斯', 'C', '8472fa0598c64437978e6f375b4527c5');
INSERT INTO `answer_tb` VALUES ('c80fc4d5fb43407894653f45ad9987a9', '12', 'A', '62651268aeba4418a1f2ab5ec82c098a');
INSERT INTO `answer_tb` VALUES ('c8304b8f827e436b862c1ae9c41f6396', '5555', 'A', 'dc8a5fe1553c4a1c83209dc7a5121982');
INSERT INTO `answer_tb` VALUES ('c83d7a22f25c4689b8d23236c1d6ca48', '发放 发', 'A', '8472fa0598c64437978e6f375b4527c5');
INSERT INTO `answer_tb` VALUES ('c8c2c26dec0842398a6db976cb810a90', ' 的的', 'B', 'f1f2e8faef9e4a4aa6da12b77c37217d');
INSERT INTO `answer_tb` VALUES ('c9aa4eca3de1492c975eecfee4b46b5e', 'fghj', 'B', '65b62a4a578e4db5b456f4226b4b538e');
INSERT INTO `answer_tb` VALUES ('ca3701c2d7934d6ab86c4d41df281a31', '萨芬sa\'d\'f', 'C', 'b6e43f85fd1a44188ef6ee606aaa868d');
INSERT INTO `answer_tb` VALUES ('cb06707c7d964fbdabfb554c79ca57d8', '打撒发', 'A', '1dc33991cd3f4b9a8e26eec450ab3012');
INSERT INTO `answer_tb` VALUES ('cb66193388d343b7b2f9d1f4c97d38a7', 'sdaf', 'B', '500ef279d748478cbbb4e00a81bf3fd2');
INSERT INTO `answer_tb` VALUES ('cc249df0c82d4668b9b20edbe76a6a85', '时代光华', 'D', '3fb962320f204d95b8c54fbab63d286e');
INSERT INTO `answer_tb` VALUES ('cca5366a84a44fecb9da6994ef674063', '12121', 'B', 'fd6e3f3027644007aa5b8b3d049860a4');
INSERT INTO `answer_tb` VALUES ('ccd61188be414b8b88e9e61982610f50', 'df好的', 'B', '7ba5d89c01104b1381456ebc135d8e28');
INSERT INTO `answer_tb` VALUES ('cd062cfa641941fe8f89a0fc317796c1', '分数', 'B', '3fb962320f204d95b8c54fbab63d286e');
INSERT INTO `answer_tb` VALUES ('cd0cbd9924154411afa85f1ddf5e855f', '222222', 'C', 'c2aaa86e25ce4373ad3253f3933b02e0');
INSERT INTO `answer_tb` VALUES ('cd2c1c6175404869bb0b695ce080b2a8', '在视图上定义新的视图', 'B', '8ec766327e334c11bdc3e7ddda2e4df9');
INSERT INTO `answer_tb` VALUES ('cd55cdef390a44f6969beb5cb3326a0e', '构造注入方式依赖对象先注入', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('cda22d09c16146ffb8cfa48a4bb5edb5', 'df', 'D', '5b2590de04eb42979453fc22a2082290');
INSERT INTO `answer_tb` VALUES ('cdf47337ce7e4890970eea1bb3bccfa1', '呗装了!!!', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('ce9b561ea4264518a6a013b2d257e9d0', '你不是!!!', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('cf012d18e5754a3b9de0f948a3749fee', '而又特意', 'D', 'adb65d3fd30b4d33a761ad3e3d6b45ed');
INSERT INTO `answer_tb` VALUES ('cf111b769a634821ba0af57311a360c5', '@Scope', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('cf5ffa7bacbe4e3c8456d769319f08d3', 'sdaf', 'A', 'cc3166f3f57b4367b35029beff5b96c8');
INSERT INTO `answer_tb` VALUES ('cfbb2bd6c09044b9942a4a6d7f62fd37', '切入点表达式必须包含类型模式', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('d03e0607ef814a8ead58a65528d84ddc', '岁的法国', 'D', '4827b6bb388b4c3b932599a03df36175');
INSERT INTO `answer_tb` VALUES ('d13f73beeb9543d783ac423869103ed4', '而他也人', 'A', 'adb65d3fd30b4d33a761ad3e3d6b45ed');
INSERT INTO `answer_tb` VALUES ('d1d4cbee18a0488781d51917a4131018', '2', 'B', '02355ba2dc2f49de803e291c5079dc37');
INSERT INTO `answer_tb` VALUES ('d244eab26a104b9389eefc0d04df26a9', 'INNODB', 'A', '2f3a97fa23d146d0b3104fe0583c0637');
INSERT INTO `answer_tb` VALUES ('d2d6f441c49448108118390c704662da', '666', 'C', 'c16a1df2918640658008d75e6204b46a');
INSERT INTO `answer_tb` VALUES ('d356eb94c63745cd875bfd8aa0582ee8', '一个类可以继承多个抽象类', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('d40708b5d199411b89fd62b73c715a11', 'ScannerConfigurer', 'C', '40a4d0fbdc4a470a992073fde694f70f');
INSERT INTO `answer_tb` VALUES ('d45a4410adfe41298e2908f21eb09f58', '啊a', 'A', '5e99816699024f68b6cb2c3795676ab2');
INSERT INTO `answer_tb` VALUES ('d4aac93eaf5d4aeab6bd5b53bd326d4c', '1', 'A', 'ec29a46a156b45beadbd8b01ad9cb2f4');
INSERT INTO `answer_tb` VALUES ('d5375b3384a14d8dbb87cd2eeed7db2c', '12', 'A', 'fd6e3f3027644007aa5b8b3d049860a4');
INSERT INTO `answer_tb` VALUES ('d5c123d933744e00ba88cc3ea2ad4886', '两者都是使用8字节的存储空间', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('d5ef129bd0134edfa8b142567e89d999', 'aaab\'b\'b', 'B', '9fca289732664501921d05d0110a3071');
INSERT INTO `answer_tb` VALUES ('d62508560a9a429eb5a104763eb2346d', '2222222', 'D', 'c2aaa86e25ce4373ad3253f3933b02e0');
INSERT INTO `answer_tb` VALUES ('d675de01c3674858878e76be350936c6', '666', 'A', 'c16a1df2918640658008d75e6204b46a');
INSERT INTO `answer_tb` VALUES ('d6bafef673eb48239e69cd907ed7e682', 'sdaf', 'C', 'b4920096b925466284c762b21070a39c');
INSERT INTO `answer_tb` VALUES ('d6d715fe39bb49eb8aabd75b8c0870c1', '踩踩踩踩踩踩踩踩', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('d7c3ee1941a44a5aaf5f14c147c32a34', '22', 'A', '5bcc41ca2cef43c7844a60168cd42656');
INSERT INTO `answer_tb` VALUES ('d8191a62cef64feb82c461a648722064', '是', 'D', '9123ee4c071a430295a62426b29dff28');
INSERT INTO `answer_tb` VALUES ('d86d52fb11c043bf875e8348f042b324', 'dsfsdf', 'A', '75e93e57f4b04f3ab6a83d33b339ffd2');
INSERT INTO `answer_tb` VALUES ('d896df262b82412a9a924413449e914a', 'sdaf', 'A', 'ff585cb24a044775aad1ee145f1c6811');
INSERT INTO `answer_tb` VALUES ('d8ab717d878e4a6d9ca0b4a962e6fa40', '调度', 'A', 'f1f2e8faef9e4a4aa6da12b77c37217d');
INSERT INTO `answer_tb` VALUES ('d8c8fd674caa4fa7acad0f82d7c17084', 'df', 'C', 'f9659c72a6c84d208475a2616f194d07');
INSERT INTO `answer_tb` VALUES ('d976d90a1ee84633b64335e6d8da47fd', '11111111111', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('d978552ec6634efd97b9db7a1e29ca5d', '更新视图', 'C', '8ec766327e334c11bdc3e7ddda2e4df9');
INSERT INTO `answer_tb` VALUES ('da01677a876a41b6aa787c1d69e75019', '类的初始化工作由Spring完成，代码中不需要对其依赖的对象使用new关键词创建', 'B', '485749f02ccc4597968f6f59cf663b45');
INSERT INTO `answer_tb` VALUES ('da0ac1ebf36947f8807ef7b0a537df17', '33333333', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('da1d6b7f3538410e96e398c559790ced', 'ScannerConfigurer', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('da4703a16fe342928b90c2a0b20a5f55', 'sdaf', 'B', '0dc10ce59d8d43c7b2003e9999b34307');
INSERT INTO `answer_tb` VALUES ('da89b70fc31941968d53b23282b0cd85', '调度', 'B', '3a415b5710ba4446ba5004032e5350bd');
INSERT INTO `answer_tb` VALUES ('da9c37d90e5545e4bb201c3b59d8c6d5', 'save', 'A', 'f9dd75197c3a407695ef93b2af2104fc');
INSERT INTO `answer_tb` VALUES ('daa3287f7ca645ef8c3bca894ca4371f', '封装JDBC访问数据库的代码，简化数据访问层的重复性代码', 'B', 'c519171747404fe496228f7ee9b12114');
INSERT INTO `answer_tb` VALUES ('dbc7bf1cf140403ab715e2c8fcacf7ca', 'DORDER CLASSES', 'B', '8407a759e3b6413d8f78e505272da3f6');
INSERT INTO `answer_tb` VALUES ('dc8c9a3944b44ca9804b18bd02ff6800', '的风格和大风', 'D', 'd542e33557e044b7950252fdeea569cb');
INSERT INTO `answer_tb` VALUES ('dcb31a19bc43483697e42119e5c846e3', 'Create table，Create index', 'A', '9629eeedc8de4b1fab6c2dbd6b9fd70c');
INSERT INTO `answer_tb` VALUES ('ddcb4c7ff7964d2eac4f8e9597adfa9a', '阿啊啊', 'C', '5e99816699024f68b6cb2c3795676ab2');
INSERT INTO `answer_tb` VALUES ('de96f4812af044b7b65da943466fd09c', '切入点表达式必须包含方法名称模式', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('df35aafed4814866a7ef7c69573b2b45', 's', 'D', 'f7061a223dd5447c9a8bdd4215e76753');
INSERT INTO `answer_tb` VALUES ('dfc26848248247288bec8f2a4a27aa68', '啊啊啊啊', 'D', '5e99816699024f68b6cb2c3795676ab2');
INSERT INTO `answer_tb` VALUES ('e01851e1fa774099a00b06c6883bca9e', '22', 'B', '5bcc41ca2cef43c7844a60168cd42656');
INSERT INTO `answer_tb` VALUES ('e038152350514264932b94b611564113', 'MERGE', 'C', '2f3a97fa23d146d0b3104fe0583c0637');
INSERT INTO `answer_tb` VALUES ('e04226676f2c4ca9940f58afcd2a6b58', '12121', 'D', 'f13dfb4f72874182bd884be97da7868b');
INSERT INTO `answer_tb` VALUES ('e174f601305c44859d00f96d4633f21e', 'ddddddddddd', 'D', '3e8b2838a43f47feb2be194640af78b5');
INSERT INTO `answer_tb` VALUES ('e284dca5716e402380a00d8f00ddd922', '000000000000000', 'B', '45df7d20236c4b449aade442e63db16f');
INSERT INTO `answer_tb` VALUES ('e2a0685f02524c98bc69dd7ba8e9365d', '121212122212', 'A', '754ac78e8a8f44c2bf8fd5d589550d7b');
INSERT INTO `answer_tb` VALUES ('e2fe657d884046608ad69a9d256d6bb2', 'sdaf', 'C', '67767c2bd6664757af922362b2634868');
INSERT INTO `answer_tb` VALUES ('e30fef6475d24561bf0bbc13833d15cd', 'SDFG', 'A', 'adf7294c718a4c0eb07fbc83272b4923');
INSERT INTO `answer_tb` VALUES ('e37e7633469848a2952ff4305d8de288', 'cccccccccccc', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('e3e31489e02b4718a0db7d27a5739277', 'dfdf', 'A', 'f9659c72a6c84d208475a2616f194d07');
INSERT INTO `answer_tb` VALUES ('e4cfb5898848488fb9f93b44ec194c1d', '3333', 'C', '9ba068ddc72e474090f9b774a330f75b');
INSERT INTO `answer_tb` VALUES ('e62c7dae4f224446a225063e28612ad6', '接口中定义的成员变量实际上都是常量', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('e64bad89571b4507ad6e15fbf2f69e1d', '依赖注入就是“面向切面编程”', 'B', '3ee3c349f6e7475493163220592c3b41');
INSERT INTO `answer_tb` VALUES ('e6e526153a6f42939c876018e6e5b7a1', '4444444444444', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('e6f4759a50974470a225f14104372f5f', '二爷爷 ', 'B', 'adb65d3fd30b4d33a761ad3e3d6b45ed');
INSERT INTO `answer_tb` VALUES ('e6ff4b41fa1943dd86651555c213ae0d', '只要在 ORDER BY 子句中使用 RAND() 函数，不使用 LIMIT 子句', 'C', '90ef01d897c143258ec473387f400abc');
INSERT INTO `answer_tb` VALUES ('e732cc6323dc4c8db32e06b7e78d49bd', '一个类可以继承多个接口', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('e789b4e096de44e78f8f1b5211304043', 'eeeeeee', 'D', '83101d78a98d40c48cbd90409faa65d0');
INSERT INTO `answer_tb` VALUES ('e81b52b036e84df0a76ff1ad79ed43cc', '是通过身体', 'A', '2b958279e88f4d6e8e65815dddf2176e');
INSERT INTO `answer_tb` VALUES ('e8354e2643d54f0bbdc2ae326ebad2b1', '士大夫', 'D', '1dc33991cd3f4b9a8e26eec450ab3012');
INSERT INTO `answer_tb` VALUES ('e865186399ff4854915b2883b3ed3d82', 'sdaf', 'D', '0dc10ce59d8d43c7b2003e9999b34307');
INSERT INTO `answer_tb` VALUES ('e8d6bfafbd0642bca53518067e62b867', '999999999999999', 'D', 'db60e6f84c9d482f90bcfc2450310ed5');
INSERT INTO `answer_tb` VALUES ('e9c79596a3e14cc4a59c16c14976346a', 'sdaf', 'C', '500ef279d748478cbbb4e00a81bf3fd2');
INSERT INTO `answer_tb` VALUES ('ea20de26f3b34735909b89218ead4118', '12', 'A', '84ada2c55efc4030a7f5392ab3c7cb6b');
INSERT INTO `answer_tb` VALUES ('ea3635a04e604cd0957ea4d03856b9a9', 'Spring是一个轻量级框架', 'A', NULL);
INSERT INTO `answer_tb` VALUES ('ebf662a59b07448f9f66d1e72198be8c', 'sdf', 'C', '75e93e57f4b04f3ab6a83d33b339ffd2');
INSERT INTO `answer_tb` VALUES ('ec1aa75125734bea9b3dc8d61ccc459b', '编写程序时无须关注其依赖组件的实现', 'A', 'c519171747404fe496228f7ee9b12114');
INSERT INTO `answer_tb` VALUES ('ec62bfdacf58439ba8ab0131b7891623', '案说法', 'D', '3a92867b637044feba215def83937274');
INSERT INTO `answer_tb` VALUES ('ecc6dbcbdf2b48b3a1421f1eca214829', '不能使用运算符号', 'C', '3f72176bf27945109780d023045cc4f2');
INSERT INTO `answer_tb` VALUES ('ed17b07008054f4989f38aeb66d57bb0', 'dsf', 'B', 'b616fadf12a343048f86bada78526ebc');
INSERT INTO `answer_tb` VALUES ('ed5a9625759f4c84b33816e67deae0e0', 'sdf', 'C', '81b5e3a72368420eaa65231467955773');
INSERT INTO `answer_tb` VALUES ('edb1695d44e346ea9a0cf14b4e170794', ' 顶顶顶顶顶顶顶顶顶顶顶顶顶', 'D', '4f7830365f5b406db5b6bf4eb229afb4');
INSERT INTO `answer_tb` VALUES ('eed876a0291d408f9949f76198f08c23', '主键可以建立在多个列上', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('f141b25590bd4d8fab6607b32d73cfe6', 'XCVBN', 'B', 'adf7294c718a4c0eb07fbc83272b4923');
INSERT INTO `answer_tb` VALUES ('f14802b85c3941a4be14770af4f74dee', '666', 'B', 'c16a1df2918640658008d75e6204b46a');
INSERT INTO `answer_tb` VALUES ('f1916ca88ab449f1957565991e070b00', '踩踩踩踩踩踩踩踩', 'A', '7acb4b1ade75456e9feae1309994fda8');
INSERT INTO `answer_tb` VALUES ('f1ef74bceb634ae2aede73b1d23c49b6', 'Spring主要通过属性注入，所以一般需要在被注入的类中定义好setter方法', 'A', '485749f02ccc4597968f6f59cf663b45');
INSERT INTO `answer_tb` VALUES ('f39fa070b1894f3cb239c16358d31bd1', '撒的撒的', 'C', 'f268f977d3054f0f9f4bb8a5a5dc7ebc');
INSERT INTO `answer_tb` VALUES ('f436edf90ae04bc49217eccf61e9e3af', '事务管理器需要注入sessionFactory属性，因为事务是基于数据库连接的', 'C', NULL);
INSERT INTO `answer_tb` VALUES ('f4a774c4f0a24d169ac281decce99c7f', 'Spring DAO无需注入SessionFactory', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('f4bc9be3e2e848168ce2ea05ed5b107f', 'Spring不支持自动注入', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('f52919b13ff94e6c85f70b2912076fbf', '啊', 'D', '42af75326dc44d7f80b4b993241279ef');
INSERT INTO `answer_tb` VALUES ('f650fdf3fd2148bb97e6ef080ee781a6', '抽象类中可以定义成员变量', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('f6fb628457b8419885a9b64c5051dbe4', 'nnnnnnnnnnnn', 'C', 'c4f2574e39994e068fdf80347bebe2a9');
INSERT INTO `answer_tb` VALUES ('f849763302454e449ddd5030f338fcac', 'rr', 'C', '3c3e033b7481482ea6722fc72069aa32');
INSERT INTO `answer_tb` VALUES ('f89732bea7084c1499787a93349b2153', '打撒发', 'A', 'cb1c9a87df79402da5fdfe023ecb449b');
INSERT INTO `answer_tb` VALUES ('f9c732b1f6eb42acbd58fa39535f2416', 'nnnnnnnnnnnnnnnnnnnnnnnnnnn', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('f9c9d1f0413c4368b72d4e72c2c67d9d', '啊', 'C', 'cd883c3caa704f0cacffe7e08f81c6f7');
INSERT INTO `answer_tb` VALUES ('fa887a63d9bd4af39ee1b2cb63315a0c', '设置主键约束，设置唯一约束', 'B', '9629eeedc8de4b1fab6c2dbd6b9fd70c');
INSERT INTO `answer_tb` VALUES ('faa31e2ddf0440cd9326dd46cce1267c', 'ww', 'A', '3c3e033b7481482ea6722fc72069aa32');
INSERT INTO `answer_tb` VALUES ('fad014e17e3d4ba085549f586af5fadc', '打撒发', 'A', '9123ee4c071a430295a62426b29dff28');
INSERT INTO `answer_tb` VALUES ('fb08a39a47c64e0285276f9f76cfb631', '333333333', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('fb5548a5375e4a70aa6ca58ea24b705f', 'v', 'B', 'f68b2133215947c0b80e33e4e94af782');
INSERT INTO `answer_tb` VALUES ('fc168fba1fd14b42a26c867f0bc9d593', '121261', 'C', '83772e81135546768ec1370e72b79723');
INSERT INTO `answer_tb` VALUES ('fe1ac3b43ef34f57ae83aad89d970c7f', '222222222', 'A', 'c2aaa86e25ce4373ad3253f3933b02e0');
INSERT INTO `answer_tb` VALUES ('fe80e7bbc54b4adaafd27e4b46d7ceef', '调度', 'A', '3a415b5710ba4446ba5004032e5350bd');
INSERT INTO `answer_tb` VALUES ('fe8801858a264ba89f264a94bd0186cb', 'dsaf', 'A', 'b616fadf12a343048f86bada78526ebc');
INSERT INTO `answer_tb` VALUES ('fe968a9f6e6e49b08911353f2bba005f', '注入依赖关系注入时机不同', 'B', NULL);
INSERT INTO `answer_tb` VALUES ('fec554a4ef0b427fa77a00e9a3e8bd2a', 'MybatisMapperConfigurer', 'D', NULL);
INSERT INTO `answer_tb` VALUES ('ff508e46675f4dbb994fe64e71b2ab8e', 'delete', 'B', 'f9dd75197c3a407695ef93b2af2104fc');
INSERT INTO `answer_tb` VALUES ('ffe9d8be81984482bc338d40f8626618', 'MEMORY', 'B', '2f3a97fa23d146d0b3104fe0583c0637');

-- ----------------------------
-- Table structure for examanswer_tb
-- ----------------------------
DROP TABLE IF EXISTS `examanswer_tb`;
CREATE TABLE `examanswer_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `optiones` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examanswer_rubric_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examanswer_examrubric_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKbmrsy8mehp1d3t09ssii1o0da`(`examanswer_rubric_id`) USING BTREE,
  INDEX `FK3eakdnmg9oh88rxic4l8enusi`(`examanswer_examrubric_id`) USING BTREE,
  CONSTRAINT `FK3eakdnmg9oh88rxic4l8enusi` FOREIGN KEY (`examanswer_examrubric_id`) REFERENCES `examrubric_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKbmrsy8mehp1d3t09ssii1o0da` FOREIGN KEY (`examanswer_rubric_id`) REFERENCES `examrubric_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examanswer_tb
-- ----------------------------
INSERT INTO `examanswer_tb` VALUES ('0077962058a1481c91e32a569d534051', '啊a', 'A', NULL, '647524ace08c4d37a376f1dc0f6f0ec7');
INSERT INTO `examanswer_tb` VALUES ('01b85b2bf46e4906be5f01843be56210', 'sdaf', 'A', NULL, 'c452775d8c7b433e9d32b4f1a6a2b5a4');
INSERT INTO `examanswer_tb` VALUES ('022010ad3529440bbf7a28e7b986df00', '222222', 'C', NULL, '08dcecf4591248a4ac75ec8018bf70c0');
INSERT INTO `examanswer_tb` VALUES ('0358fcfbe25243dc93c98a9535c1ca23', 'NamedParameterJdbcTemplate', 'D', NULL, '115e635d66444bd3ba2e85cd693f4b01');
INSERT INTO `examanswer_tb` VALUES ('05872b2f9160462fa5c001479cdbafd7', '1111111111111111111111111', 'C', NULL, 'fcfea5041fb246599065e5b886ca88ef');
INSERT INTO `examanswer_tb` VALUES ('05b9665eab594f41b5d2b1ee2fa338da', '踩踩踩', 'D', NULL, '0e4e34b01f4446ffbe94062615b3dc34');
INSERT INTO `examanswer_tb` VALUES ('09677fc26dcc464cb57d151538d5ce88', '顶顶顶顶顶顶顶顶顶顶', 'D', NULL, '8c68171d11364e1cac181ff77918f878');
INSERT INTO `examanswer_tb` VALUES ('0b4d0a2a2b2f4921a4c63f8d554cf4d6', 'JdbcDaoSupport', 'B', NULL, '22b4de0d0e5f4c72aa5d8edb86d23911');
INSERT INTO `examanswer_tb` VALUES ('0b86fa54f87a46bcb17ca18dd1e184a8', '调度', 'D', NULL, '7b5ddfcbc8a8484f9af655adf8df713d');
INSERT INTO `examanswer_tb` VALUES ('0b8983e6157f4a11ba899eb27a2c90c4', '顶顶顶顶顶顶顶顶顶顶顶', 'A', NULL, '200231502a5f4dbb856d50a8fa002875');
INSERT INTO `examanswer_tb` VALUES ('0bc147a850044e8ca15621cffb26854e', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', NULL, '200231502a5f4dbb856d50a8fa002875');
INSERT INTO `examanswer_tb` VALUES ('0ddeb0f0c6c24f26a653a3fc715e5646', '4', 'D', NULL, '1c4ff60dfdda4253864eec8de34f326f');
INSERT INTO `examanswer_tb` VALUES ('0eb7233f7ed74861947f0177045702ee', '121', 'C', NULL, '7d9ee9d0a1574fa088972e685da4aa2b');
INSERT INTO `examanswer_tb` VALUES ('105ffcb9eb2b43ecb4ec1a39fac0fa45', ' 的的', 'B', NULL, '1641a971b97b49c3b503e69b45cac42a');
INSERT INTO `examanswer_tb` VALUES ('10adca011cb14eeab7eb87650c2ef5b0', '图形', 'B', NULL, 'f508d6bb4d714be4854f8b5d36ab54bd');
INSERT INTO `examanswer_tb` VALUES ('1135dcac7229490a8cc7a727f041560b', '撒旦发射点', 'C', NULL, 'e44e566c79b5407daf90600573eba2b8');
INSERT INTO `examanswer_tb` VALUES ('11e68fec69f64ba588ebfe7478ad083b', 'df', 'C', NULL, 'b47dc484928b4894b817f949db819e3c');
INSERT INTO `examanswer_tb` VALUES ('11ee217d504341bb802bbd9c38080d81', '阿啊啊', 'C', NULL, '647524ace08c4d37a376f1dc0f6f0ec7');
INSERT INTO `examanswer_tb` VALUES ('1212f5a480ec4d4986748f69a4d360ee', '可以通过Web服务调用', 'D', NULL, '7a1eb9a89f4e46ddb29cf86c0c4a07ae');
INSERT INTO `examanswer_tb` VALUES ('1325ee0911274ba29dda0cd73ce88331', '121', 'C', NULL, '0a15289093f148ee8f7a508773685605');
INSERT INTO `examanswer_tb` VALUES ('136668cc7b024aa1abe3ac4244939de0', 'sadf', 'A', NULL, '2f12b1eaec9544ea9d7ef0863b21e089');
INSERT INTO `examanswer_tb` VALUES ('1370a133f81a4f2dae335e6c426ae9ae', 'dfdf', 'A', NULL, 'b35d91523eb54633be2d3f28e60b31a2');
INSERT INTO `examanswer_tb` VALUES ('1383c35cf0c543208fdccce54e6cfda7', 'dsf', 'B', NULL, 'b47dc484928b4894b817f949db819e3c');
INSERT INTO `examanswer_tb` VALUES ('14d1933cdfbc4b1a99f48b19a14f4fbc', '以上都可以', 'D', NULL, 'a5478ce5c8c84688bd5ef380bf433165');
INSERT INTO `examanswer_tb` VALUES ('15efc6cf8b30434d863db64fc227ffbe', '编写程序时无须关注其依赖组件的实现', 'A', NULL, 'a7e2fe497de14a73886b9b3e2ed37773');
INSERT INTO `examanswer_tb` VALUES ('1738d3bbf66e4ccfa9209ae3f7fa0cdc', '编写程序时无须关注其依赖组件的实现', 'A', NULL, '7a1eb9a89f4e46ddb29cf86c0c4a07ae');
INSERT INTO `examanswer_tb` VALUES ('175e42f0b147438fbf729cff3ece729d', 'SimpleJdbcTemplate', 'C', NULL, '115e635d66444bd3ba2e85cd693f4b01');
INSERT INTO `examanswer_tb` VALUES ('18728c2685b94c11b1dc880613dcf530', 'sdaf', 'C', NULL, 'c452775d8c7b433e9d32b4f1a6a2b5a4');
INSERT INTO `examanswer_tb` VALUES ('18db66d1027344beb6b13c1ef1670361', 'TOP', 'A', NULL, '3424f70238634e3fb6e66929c5b87c59');
INSERT INTO `examanswer_tb` VALUES ('18e35056beca455fb54d79450c6d2301', 'df', 'D', NULL, '19968aceb0104808b9ae398db0b4096a');
INSERT INTO `examanswer_tb` VALUES ('1b4706ecb6024c7ebf50ce3f37d65647', '啊啊', 'B', NULL, '89e8a3ad50e54a12949584776801bfdf');
INSERT INTO `examanswer_tb` VALUES ('1f294139220b4f088dda59839ad2ba3f', '1111', 'D', NULL, '9222504f05dd4eb58703a37a5de92c43');
INSERT INTO `examanswer_tb` VALUES ('20d6052750a4445f904e0786cc307fc0', '121212121212212', 'C', NULL, '0ecc4a55186e4ca8af1cb7fcc033f812');
INSERT INTO `examanswer_tb` VALUES ('227f784dd928442b97c2a4f147be4472', '封装JDBC访问数据库的代码，简化数据访问层的重复性代码', 'B', NULL, 'a7e2fe497de14a73886b9b3e2ed37773');
INSERT INTO `examanswer_tb` VALUES ('2288777fec4c4f09b93d5cda7dca9896', '12', 'A', NULL, '7d9ee9d0a1574fa088972e685da4aa2b');
INSERT INTO `examanswer_tb` VALUES ('231bb228344e4e849b848e7cbb3d0851', '啊啊啊啊', 'D', NULL, '89e8a3ad50e54a12949584776801bfdf');
INSERT INTO `examanswer_tb` VALUES ('23241404a9084d4095bbcdf20176a323', 'df', 'C', NULL, 'b35d91523eb54633be2d3f28e60b31a2');
INSERT INTO `examanswer_tb` VALUES ('2361453e2210435ba0d22d06da37d275', 'UNION', 'C', NULL, '3424f70238634e3fb6e66929c5b87c59');
INSERT INTO `examanswer_tb` VALUES ('2568dea228b54e4bbdcaa8dfec5f2790', '将程序中涉及的公共问题集中解决', 'C', NULL, 'a7e2fe497de14a73886b9b3e2ed37773');
INSERT INTO `examanswer_tb` VALUES ('2724c0ecbc984a1a9ad57a57ac90a009', '2', 'B', NULL, '1c4ff60dfdda4253864eec8de34f326f');
INSERT INTO `examanswer_tb` VALUES ('27f331e12be744988637de769c0fe4ae', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', NULL, '3df561f200da400c99765b62a1fb0ba6');
INSERT INTO `examanswer_tb` VALUES ('2850e9956e9a4ce1a9b1fd99a63d0564', '啊a', 'A', NULL, '89e8a3ad50e54a12949584776801bfdf');
INSERT INTO `examanswer_tb` VALUES ('2d2ffb3951884aabb6efd3dc0ab2d739', 'sdaf', 'D', NULL, 'f56c1a778cc2468f813d345dcb51ce53');
INSERT INTO `examanswer_tb` VALUES ('2d63e7e90ee04f8287c76c94126ce722', 'SimpleJdbcTemplate', 'C', NULL, '22b4de0d0e5f4c72aa5d8edb86d23911');
INSERT INTO `examanswer_tb` VALUES ('30401ae3df5b47d98d8bca5d4634f8c4', 'LIMIT', 'D', NULL, 'e37dfdf75fc94769ada1a5871d0a15e7');
INSERT INTO `examanswer_tb` VALUES ('30fd257439c94d858ec5fe25c4bd0d00', '文字', 'A', NULL, 'f508d6bb4d714be4854f8b5d36ab54bd');
INSERT INTO `examanswer_tb` VALUES ('31b8b19c5e3b42338edb4300e4c102a6', '顶顶顶顶顶顶顶顶顶顶顶', 'C', NULL, '8c68171d11364e1cac181ff77918f878');
INSERT INTO `examanswer_tb` VALUES ('36215e2030ed488eaa078b2e768f6d6f', '士大夫撒', 'D', NULL, 'e44e566c79b5407daf90600573eba2b8');
INSERT INTO `examanswer_tb` VALUES ('3cfefe2242b841d4bea40db3248c3dbe', '2222222', 'B', NULL, '6ccdef908e72426aa695953e1d4ce73d');
INSERT INTO `examanswer_tb` VALUES ('3d32c5b7888347c2b9fb79ec1a67e248', '12', 'B', NULL, '7d9ee9d0a1574fa088972e685da4aa2b');
INSERT INTO `examanswer_tb` VALUES ('405f12d799334c758dae79ef7e964f70', ' 的', 'D', NULL, '1641a971b97b49c3b503e69b45cac42a');
INSERT INTO `examanswer_tb` VALUES ('41b69c31bc2149ecaddf9d5f53d0e6aa', '1212121212121212', 'B', NULL, '8306c06b50214e86ba49a187788cb19a');
INSERT INTO `examanswer_tb` VALUES ('42b5a2ee420d40dfb975d318b0df9014', '222222', 'C', NULL, '6ccdef908e72426aa695953e1d4ce73d');
INSERT INTO `examanswer_tb` VALUES ('42ff546c824742a89ef866c1a348173c', '士大夫士大夫', 'B', NULL, 'e44e566c79b5407daf90600573eba2b8');
INSERT INTO `examanswer_tb` VALUES ('46056fe692ad4daea1b0a351ccc02f68', 'df', 'D', NULL, 'b47dc484928b4894b817f949db819e3c');
INSERT INTO `examanswer_tb` VALUES ('474048f9f1e0419a8d34dc0e29f57fc3', '士大夫', 'D', NULL, '41497e1abf994ecf88f777144b3e1def');
INSERT INTO `examanswer_tb` VALUES ('479f724adc1c46918457eaf2f32b19e4', '111111111111111111', 'B', NULL, 'fcfea5041fb246599065e5b886ca88ef');
INSERT INTO `examanswer_tb` VALUES ('4afecfa21f184c258ff0654ce0febfc6', '1212', 'D', NULL, '6b1fb9b076dd4623b1794ef3f41b6320');
INSERT INTO `examanswer_tb` VALUES ('4bbf0728eb9a42d18eaccbe26ff056d9', '顶顶顶顶顶顶顶顶顶顶', 'D', NULL, '3df561f200da400c99765b62a1fb0ba6');
INSERT INTO `examanswer_tb` VALUES ('4dc2d8f508b54ed19c2eb04daf2795ab', '啊', 'B', NULL, 'ef08b34fa9a242e8a9d64b97bd9c43ef');
INSERT INTO `examanswer_tb` VALUES ('505c69a73390415a972ce2f560d2bfe6', 'DORDER CLASSES', 'B', NULL, 'edb60003ed6044238b2b3acd15b00746');
INSERT INTO `examanswer_tb` VALUES ('523322df6e1746a08c816f3f4b81256b', 'dsaf', 'A', NULL, 'b47dc484928b4894b817f949db819e3c');
INSERT INTO `examanswer_tb` VALUES ('54c52f1ff06e4083922315a605abc70e', 'JdbcDaoSupport', 'B', NULL, '115e635d66444bd3ba2e85cd693f4b01');
INSERT INTO `examanswer_tb` VALUES ('560f0f7061d6482aa9672de1dfec24ab', 's', 'A', NULL, '4ba52579f10d480aafa5570919c68c4d');
INSERT INTO `examanswer_tb` VALUES ('5638c28650844992b482023b3c2c7679', 'def', 'A', NULL, '19968aceb0104808b9ae398db0b4096a');
INSERT INTO `examanswer_tb` VALUES ('576a9383bb044dd48f4dab79eff8e68d', '11111111111111111111111111111111', 'D', NULL, 'fcfea5041fb246599065e5b886ca88ef');
INSERT INTO `examanswer_tb` VALUES ('57c68fda58ab43ec9bf5a46b9537a156', 'ALL', 'B', NULL, 'e37dfdf75fc94769ada1a5871d0a15e7');
INSERT INTO `examanswer_tb` VALUES ('58d85362b35b4c08a39b846c600647c2', 'df', 'B', NULL, '19968aceb0104808b9ae398db0b4096a');
INSERT INTO `examanswer_tb` VALUES ('5a3c6645a1ac496a9035875b1dccab82', '12', 'A', NULL, '31a0548ec0d740159b8c805788219b1d');
INSERT INTO `examanswer_tb` VALUES ('5afe98581cf1457099036a7b12a60b98', '踩踩踩踩踩踩踩踩', 'A', NULL, '0e4e34b01f4446ffbe94062615b3dc34');
INSERT INTO `examanswer_tb` VALUES ('5bb427343bb74b608fa8105bb19c5cac', '顶顶顶顶顶顶顶顶顶顶顶', 'A', NULL, '8c68171d11364e1cac181ff77918f878');
INSERT INTO `examanswer_tb` VALUES ('5bf0024b2ca4429bb7398851ca4c017c', 'JdbcDaoSupport', 'B', NULL, 'f6a77de6262644bc9a8cda4650241e4f');
INSERT INTO `examanswer_tb` VALUES ('5dad64fc7707462a81827a45e18b45ce', 'JdbcTemplate', 'A', NULL, '115e635d66444bd3ba2e85cd693f4b01');
INSERT INTO `examanswer_tb` VALUES ('5dd45386b3db428e92ff11265bb2c086', 'j', 'D', NULL, '4ba52579f10d480aafa5570919c68c4d');
INSERT INTO `examanswer_tb` VALUES ('5ea252a122604d9fbe365582e2a6948d', 'df', 'B', NULL, '86e559cafad94913b2614c5028d59f54');
INSERT INTO `examanswer_tb` VALUES ('5fa88039059f4f6e9f7799183133d2f8', 'sdaf', 'D', NULL, '2f12b1eaec9544ea9d7ef0863b21e089');
INSERT INTO `examanswer_tb` VALUES ('605feca034b74ba3a770e1e6095341dc', '封装JDBC访问数据库的代码，简化数据访问层的重复性代码', 'B', NULL, '7a1eb9a89f4e46ddb29cf86c0c4a07ae');
INSERT INTO `examanswer_tb` VALUES ('61774aee4cd74059b68be62ffd407036', '12', 'B', NULL, '0a15289093f148ee8f7a508773685605');
INSERT INTO `examanswer_tb` VALUES ('6193e8e3cada4616a6dfa8ea58997185', '2222222', 'D', NULL, '6ccdef908e72426aa695953e1d4ce73d');
INSERT INTO `examanswer_tb` VALUES ('63aa92d7626943ddbc628c199e8485c8', 'g', 'C', NULL, '4ba52579f10d480aafa5570919c68c4d');
INSERT INTO `examanswer_tb` VALUES ('6464146261434758b9a081874256142b', 'c', 'B', NULL, '4ba52579f10d480aafa5570919c68c4d');
INSERT INTO `examanswer_tb` VALUES ('68419638496d405aaa748483faa36986', '顶顶顶顶顶顶顶顶顶顶顶', 'C', NULL, '7145864ac6514f1eb1bba838ca4d0a23');
INSERT INTO `examanswer_tb` VALUES ('6bde0a422ebf4cd981cd13cf38b4cef5', '顶顶顶顶顶顶顶顶顶顶', 'D', NULL, '7145864ac6514f1eb1bba838ca4d0a23');
INSERT INTO `examanswer_tb` VALUES ('6e8dddc513524ba99842d8927f71c743', '啊', 'C', NULL, 'ef08b34fa9a242e8a9d64b97bd9c43ef');
INSERT INTO `examanswer_tb` VALUES ('710f24f87e554eec822f4cc65795c445', 'LIMIT', 'D', NULL, '3424f70238634e3fb6e66929c5b87c59');
INSERT INTO `examanswer_tb` VALUES ('729b0b8a4d4e4283b3a7d9a8dce7a52d', '顶顶顶顶顶顶顶顶顶顶顶', 'C', NULL, '3df561f200da400c99765b62a1fb0ba6');
INSERT INTO `examanswer_tb` VALUES ('73bd6df3e9a845108aaf4cf27aa5d946', '顶顶顶顶顶顶顶顶顶顶', 'D', NULL, '200231502a5f4dbb856d50a8fa002875');
INSERT INTO `examanswer_tb` VALUES ('73e8c4f17fbf4821b51e55d8629641f6', '1212121212', 'D', NULL, '8306c06b50214e86ba49a187788cb19a');
INSERT INTO `examanswer_tb` VALUES ('7515545ec46941558c9cd3ed474c68d7', 'df', 'C', NULL, 'f0fd2049e59449efbe0ebea114b91bcb');
INSERT INTO `examanswer_tb` VALUES ('7b2cb967ca684f2a96b5af327cf751e2', 'sdaf', 'C', NULL, 'f56c1a778cc2468f813d345dcb51ce53');
INSERT INTO `examanswer_tb` VALUES ('7c8a1b0d596341e1b44c778cc0418f30', '啊', 'A', NULL, 'ef08b34fa9a242e8a9d64b97bd9c43ef');
INSERT INTO `examanswer_tb` VALUES ('7f10e91ba8fb42f78f8bc8269a9f50ca', 'sdaf', 'B', NULL, 'f56c1a778cc2468f813d345dcb51ce53');
INSERT INTO `examanswer_tb` VALUES ('81d089dc7b6b46b3b95b7269adc60013', '踩踩踩踩踩踩踩踩', 'B', NULL, '0e4e34b01f4446ffbe94062615b3dc34');
INSERT INTO `examanswer_tb` VALUES ('82422224569147d28b8e7f002e377d0b', '1', 'A', NULL, '1c4ff60dfdda4253864eec8de34f326f');
INSERT INTO `examanswer_tb` VALUES ('86e966a0209d48a683571ea0262d35bb', '3', 'C', NULL, '1c4ff60dfdda4253864eec8de34f326f');
INSERT INTO `examanswer_tb` VALUES ('874ea57e440848b9ae21ccd86aa1f280', '撒打发士大夫', 'A', NULL, 'e44e566c79b5407daf90600573eba2b8');
INSERT INTO `examanswer_tb` VALUES ('876a0713877d487e8312aa2b4e22c061', '12', 'B', NULL, '6b1fb9b076dd4623b1794ef3f41b6320');
INSERT INTO `examanswer_tb` VALUES ('87bbb03f7af4499c9d3cfb3b8d50704f', 'df', 'B', NULL, 'b35d91523eb54633be2d3f28e60b31a2');
INSERT INTO `examanswer_tb` VALUES ('88c2584ca1c94a14887fd9202390577e', '1212121212', 'D', NULL, '0ecc4a55186e4ca8af1cb7fcc033f812');
INSERT INTO `examanswer_tb` VALUES ('8a30029b5ea44c1b8a071972f6c495d1', '以上都可以', 'D', NULL, 'f508d6bb4d714be4854f8b5d36ab54bd');
INSERT INTO `examanswer_tb` VALUES ('8a3d31b0081641639eebe35f0036112a', '121', 'D', NULL, 'ac2aa63686cc433d9c876372a760795f');
INSERT INTO `examanswer_tb` VALUES ('8bdab608ae754d99931cfb6b990b3bcb', '1111', 'C', NULL, '9222504f05dd4eb58703a37a5de92c43');
INSERT INTO `examanswer_tb` VALUES ('8dcc9f30da574194a1addce5f7b27c1b', '可以通过Web服务调用', 'D', NULL, 'a7e2fe497de14a73886b9b3e2ed37773');
INSERT INTO `examanswer_tb` VALUES ('8e4dd61cc87244019a040a1992f292e0', '121261', 'C', NULL, 'ac2aa63686cc433d9c876372a760795f');
INSERT INTO `examanswer_tb` VALUES ('8f4024f8e86e4c50a66aa3ca1cbb726e', '啊啊', 'B', NULL, '647524ace08c4d37a376f1dc0f6f0ec7');
INSERT INTO `examanswer_tb` VALUES ('8febe853ebc84d96bd5657a5b1973db8', '12121', 'B', NULL, 'ac2aa63686cc433d9c876372a760795f');
INSERT INTO `examanswer_tb` VALUES ('9072f4966fc144dfa8e6d5c07b2210ea', '草草草草草草草草草草', 'C', NULL, '0e4e34b01f4446ffbe94062615b3dc34');
INSERT INTO `examanswer_tb` VALUES ('92c1b86280bf4f8f81748ec34897a6f8', '121212122212', 'A', NULL, '8306c06b50214e86ba49a187788cb19a');
INSERT INTO `examanswer_tb` VALUES ('93087f0bdd154c5ab3b4b17f7d384716', '图形', 'B', NULL, 'a5478ce5c8c84688bd5ef380bf433165');
INSERT INTO `examanswer_tb` VALUES ('9428cbd202cb4250962b2d87bf7979da', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', NULL, '7145864ac6514f1eb1bba838ca4d0a23');
INSERT INTO `examanswer_tb` VALUES ('96ef4f5f5a524fafaf532eeb55b6364e', 'NamedParameterJdbcTemplate', 'D', NULL, '22b4de0d0e5f4c72aa5d8edb86d23911');
INSERT INTO `examanswer_tb` VALUES ('9ceeeb66e66f4deabcbb074126455a46', '调度', 'A', NULL, '1641a971b97b49c3b503e69b45cac42a');
INSERT INTO `examanswer_tb` VALUES ('9d7bc98504d8400998baff357ac4a663', '声音', 'C', NULL, 'a5478ce5c8c84688bd5ef380bf433165');
INSERT INTO `examanswer_tb` VALUES ('9f97ea78f32e4d24a76e1de89f88397f', 'UNION', 'C', NULL, 'e37dfdf75fc94769ada1a5871d0a15e7');
INSERT INTO `examanswer_tb` VALUES ('a0b7c4ae0eb74c6ba6ed106c858235d6', 'GROUP BY CLASSES', 'C', NULL, 'edb60003ed6044238b2b3acd15b00746');
INSERT INTO `examanswer_tb` VALUES ('a58c430935fe4bb6a5702ceeb26bdc48', '声音', 'C', NULL, 'f508d6bb4d714be4854f8b5d36ab54bd');
INSERT INTO `examanswer_tb` VALUES ('a6ecab5f1a804080b858b2ab114480b3', '文字', 'A', NULL, 'a5478ce5c8c84688bd5ef380bf433165');
INSERT INTO `examanswer_tb` VALUES ('a76ff3cf3f7f4621b4ed3dd70640cc4f', 'ORDER BY CLASSES', 'A', NULL, 'edb60003ed6044238b2b3acd15b00746');
INSERT INTO `examanswer_tb` VALUES ('a899a527551e41d694181d5908d438b2', '阿啊啊', 'C', NULL, '89e8a3ad50e54a12949584776801bfdf');
INSERT INTO `examanswer_tb` VALUES ('a9d377b26fb14f908d41d0f63af699f6', 'sdaf', 'D', NULL, 'c452775d8c7b433e9d32b4f1a6a2b5a4');
INSERT INTO `examanswer_tb` VALUES ('ab309b808e5e47d190f8f360e67c47aa', 'df', 'D', NULL, '86e559cafad94913b2614c5028d59f54');
INSERT INTO `examanswer_tb` VALUES ('aee47820e40040188bf55a70e62acc16', 'ALL', 'B', NULL, '3424f70238634e3fb6e66929c5b87c59');
INSERT INTO `examanswer_tb` VALUES ('af5a853ff54b43a3a5c7ff33900a19df', 'NamedParameterJdbcTemplate', 'D', NULL, 'f6a77de6262644bc9a8cda4650241e4f');
INSERT INTO `examanswer_tb` VALUES ('b22b12e9075a43929a6e75d90dea587f', '啊啊啊啊', 'D', NULL, '647524ace08c4d37a376f1dc0f6f0ec7');
INSERT INTO `examanswer_tb` VALUES ('b3acf101a9c747a0886c757540deb50c', '222222222', 'A', NULL, '6ccdef908e72426aa695953e1d4ce73d');
INSERT INTO `examanswer_tb` VALUES ('b54f0b1dce494f6eb2823c978ddc3be9', '2222222', 'D', NULL, 'f5efdc0cd03f488ba9096f35bee39b0c');
INSERT INTO `examanswer_tb` VALUES ('bbedccba351e44c59d5c938863cd7b58', '啊', 'D', NULL, 'ef08b34fa9a242e8a9d64b97bd9c43ef');
INSERT INTO `examanswer_tb` VALUES ('bc6de4a92c4740ca9b8835d43be016a8', '12', 'B', NULL, '31a0548ec0d740159b8c805788219b1d');
INSERT INTO `examanswer_tb` VALUES ('be9571dee74647378ae645e9128391f7', 'df', 'C', NULL, '19968aceb0104808b9ae398db0b4096a');
INSERT INTO `examanswer_tb` VALUES ('beb71408041841ab9a8984c5102d9e77', '1212121212121212', 'B', NULL, '0ecc4a55186e4ca8af1cb7fcc033f812');
INSERT INTO `examanswer_tb` VALUES ('bf401c25976742a6b2276ba45c41109b', 'df', 'D', NULL, 'b35d91523eb54633be2d3f28e60b31a2');
INSERT INTO `examanswer_tb` VALUES ('c08fcd3fe76f4c039a743d09f7475f2e', 'TOP', 'A', NULL, 'e37dfdf75fc94769ada1a5871d0a15e7');
INSERT INTO `examanswer_tb` VALUES ('c0bdcaba262d49c3869c812aa7d44ba6', '调度', 'B', NULL, '7b5ddfcbc8a8484f9af655adf8df713d');
INSERT INTO `examanswer_tb` VALUES ('c5900e0c4afb43acbc2cf4ff4130e792', '2121', 'D', NULL, '31a0548ec0d740159b8c805788219b1d');
INSERT INTO `examanswer_tb` VALUES ('c5df5f40d81846beb5ff90c76d4d80ad', '2121', 'D', NULL, '7d9ee9d0a1574fa088972e685da4aa2b');
INSERT INTO `examanswer_tb` VALUES ('c6c5afa1edc14fe58e346c2ba383c2d0', '将程序中涉及的公共问题集中解决', 'C', NULL, '7a1eb9a89f4e46ddb29cf86c0c4a07ae');
INSERT INTO `examanswer_tb` VALUES ('c74332b0be4a43289f26390b31c0c979', 'JdbcTemplate', 'A', NULL, 'f6a77de6262644bc9a8cda4650241e4f');
INSERT INTO `examanswer_tb` VALUES ('c882bf66fe1a44c1af917da4fcb68fea', '顶顶顶顶顶顶顶顶顶顶顶', 'A', NULL, '7145864ac6514f1eb1bba838ca4d0a23');
INSERT INTO `examanswer_tb` VALUES ('cafc0b28fc7d4a139abd507b09333b84', '121212', 'C', NULL, '6b1fb9b076dd4623b1794ef3f41b6320');
INSERT INTO `examanswer_tb` VALUES ('cb415a660852498884cf43bd502ef2fd', 'sdaf', 'B', NULL, '2f12b1eaec9544ea9d7ef0863b21e089');
INSERT INTO `examanswer_tb` VALUES ('ced11d7c5a0e44ffb927481e85382bfb', '12', 'A', NULL, 'ac2aa63686cc433d9c876372a760795f');
INSERT INTO `examanswer_tb` VALUES ('cf3bec354488418086e4d2a4dd210ca5', '11121', 'B', NULL, '9222504f05dd4eb58703a37a5de92c43');
INSERT INTO `examanswer_tb` VALUES ('d03104a7795b42b38b662e4e7e678682', 'sdaf', 'B', NULL, 'c452775d8c7b433e9d32b4f1a6a2b5a4');
INSERT INTO `examanswer_tb` VALUES ('d1b085498d4f418faea6cccd0a8d7f17', '12', 'A', NULL, '6b1fb9b076dd4623b1794ef3f41b6320');
INSERT INTO `examanswer_tb` VALUES ('d1d0196a16034fbc87996c82f12cd2a6', '萨芬', 'B', NULL, '41497e1abf994ecf88f777144b3e1def');
INSERT INTO `examanswer_tb` VALUES ('d2e29097cf3a4eeb81a54c9c7723a7d5', '121212121212212', 'C', NULL, '8306c06b50214e86ba49a187788cb19a');
INSERT INTO `examanswer_tb` VALUES ('d4c7adf5055c44dda949e14eb6c89288', '222222222', 'A', NULL, '08dcecf4591248a4ac75ec8018bf70c0');
INSERT INTO `examanswer_tb` VALUES ('d5fc4590b9094ee0b2ab9064965c13de', '的的', 'C', NULL, '1641a971b97b49c3b503e69b45cac42a');
INSERT INTO `examanswer_tb` VALUES ('d7f8b3a7553043c8b79b778a7748d948', 'sdaf', 'A', NULL, 'f56c1a778cc2468f813d345dcb51ce53');
INSERT INTO `examanswer_tb` VALUES ('dc24129dffe8421ab4f395bc75390f63', 'df', 'C', NULL, '86e559cafad94913b2614c5028d59f54');
INSERT INTO `examanswer_tb` VALUES ('dc4a1b5bbe2844a2858d65feeaddabf6', '萨芬', 'C', NULL, '41497e1abf994ecf88f777144b3e1def');
INSERT INTO `examanswer_tb` VALUES ('dca4242e0d2640768833b048cacd2f1c', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', NULL, '8c68171d11364e1cac181ff77918f878');
INSERT INTO `examanswer_tb` VALUES ('dd12c477be8c4b679ea5a3730be5aab6', '顶顶顶顶顶顶顶顶顶顶顶', 'C', NULL, '200231502a5f4dbb856d50a8fa002875');
INSERT INTO `examanswer_tb` VALUES ('dd429ee0171b4219b7423b8e9ca75b9f', '2222222', 'B', NULL, '08dcecf4591248a4ac75ec8018bf70c0');
INSERT INTO `examanswer_tb` VALUES ('e1c2d87926de4376b7a1b429a98ab610', '111111111111', 'A', NULL, 'fcfea5041fb246599065e5b886ca88ef');
INSERT INTO `examanswer_tb` VALUES ('e26de030527a42929cb385b51e67a5d7', 'SimpleJdbcTemplate', 'C', NULL, 'f6a77de6262644bc9a8cda4650241e4f');
INSERT INTO `examanswer_tb` VALUES ('e55fac8b7742483b88a5dde54a2809fc', 'JdbcTemplate', 'A', NULL, '22b4de0d0e5f4c72aa5d8edb86d23911');
INSERT INTO `examanswer_tb` VALUES ('e797f6bb80d94c88846ecec6c9bc778e', '121212122212', 'A', NULL, '0ecc4a55186e4ca8af1cb7fcc033f812');
INSERT INTO `examanswer_tb` VALUES ('eb548af1d4f24ae3bb9f588e3ff1cf50', '2222222', 'D', NULL, '08dcecf4591248a4ac75ec8018bf70c0');
INSERT INTO `examanswer_tb` VALUES ('ef946da6431a4568a5f6d8d919275da7', 'GROUP CLASSES ', 'D', NULL, 'edb60003ed6044238b2b3acd15b00746');
INSERT INTO `examanswer_tb` VALUES ('f15aaa461c95458d93102efed37382d3', '12222', 'A', NULL, '9222504f05dd4eb58703a37a5de92c43');
INSERT INTO `examanswer_tb` VALUES ('f230bc6d1e944da2b2f237fd9257cbb3', '打撒发', 'A', NULL, '41497e1abf994ecf88f777144b3e1def');
INSERT INTO `examanswer_tb` VALUES ('f374b891ac8c452985464b2624c7af34', '调度', 'A', NULL, '7b5ddfcbc8a8484f9af655adf8df713d');
INSERT INTO `examanswer_tb` VALUES ('f39ab5d08da94fa98919ff537d0bdc5c', '顶顶顶顶顶顶顶顶顶顶顶', 'A', NULL, '3df561f200da400c99765b62a1fb0ba6');
INSERT INTO `examanswer_tb` VALUES ('f8083f05740e46b2bfabcd0dfbfde44b', '调度', 'C', NULL, '7b5ddfcbc8a8484f9af655adf8df713d');
INSERT INTO `examanswer_tb` VALUES ('fa5616af2622442f8a6eb5607a1a5931', 'sdaf', 'C', NULL, '2f12b1eaec9544ea9d7ef0863b21e089');
INSERT INTO `examanswer_tb` VALUES ('fab04a89ba8f442da2090ec7ea636f2f', 'dfdf', 'A', NULL, '86e559cafad94913b2614c5028d59f54');
INSERT INTO `examanswer_tb` VALUES ('fbb4513d7537408fa3cef438ea46dc5a', '121', 'C', NULL, '31a0548ec0d740159b8c805788219b1d');

-- ----------------------------
-- Table structure for examparper_tb
-- ----------------------------
DROP TABLE IF EXISTS `examparper_tb`;
CREATE TABLE `examparper_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `duration` int(11) NULL DEFAULT NULL,
  `examtime` datetime(0) NULL DEFAULT NULL,
  `fillnum` int(11) NULL DEFAULT NULL,
  `judgenum` int(11) NULL DEFAULT NULL,
  `multiplenum` int(11) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `radionum` int(11) NULL DEFAULT NULL,
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `techer_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total` int(11) NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `examshortesttime` int(11) NOT NULL,
  `passing_score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examparper_tb
-- ----------------------------
INSERT INTO `examparper_tb` VALUES ('175ee309ae194babbbb8a8b0df6beb12', 10, '2019-01-08 08:58:19', 1, 1, 1, 3, 0, '考试结束', '6', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'aaa', 10, NULL, '2019-01-08 08:56:14', 1, NULL);
INSERT INTO `examparper_tb` VALUES ('17ecd5834df74adc8b3d3893e978cc54', 10, '2019-01-08 10:41:04', 0, 2, 2, 4, 0, '考试结束', '1', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'Java', 10, NULL, '2019-01-08 10:37:48', 1, NULL);
INSERT INTO `examparper_tb` VALUES ('18110039e9104663a7b045a5c66dcbf3', 3, '2019-01-07 15:50:00', 4, 4, 3, NULL, 4, '考试结束', '6', '92dd88b1-9157-46de-bfee-51c6b1d17229', '测试品胜', 15, NULL, '2019-01-07 15:41:56', 1, 10);
INSERT INTO `examparper_tb` VALUES ('4855f39a20364d148c6cd0461db5ecbc', 100, '2019-07-27 11:13:00', 5, 10, 3, NULL, 5, '考试结束', '5', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'javaweb第一期期末测试', 100, NULL, '2019-07-27 11:10:01', 10, 60);
INSERT INTO `examparper_tb` VALUES ('6a24ea1d9fcb4dd58dcd64a060bd95b1', 10, NULL, 1, 1, 1, NULL, 1, '未开放', '294', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'a', 100, NULL, '2019-01-10 12:06:01', 1, 60);
INSERT INTO `examparper_tb` VALUES ('7d405e28f5674920913abf4f0dbb10bf', 3, '2019-01-07 14:50:00', 4, 4, 3, NULL, 4, '考试结束', '6', '92dd88b1-9157-46de-bfee-51c6b1d17229', '测试1111', 15, NULL, '2019-01-07 14:49:13', 1, 10);
INSERT INTO `examparper_tb` VALUES ('9a941ddfedae4b6ea0364640df47f67b', 50, NULL, 1, 0, 0, 1, 0, '未开放', '6', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'ddddd1234', 100, NULL, '2019-01-07 15:43:52', 10, 60);
INSERT INTO `examparper_tb` VALUES ('a0aa4d10e6624dc0a6a29a2d88703a90', 10, NULL, 1, 1, 1, NULL, 1, '未开放', '1', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'j', 10, NULL, '2019-01-08 10:42:55', 1, 6);
INSERT INTO `examparper_tb` VALUES ('b085b4f059ac4136aa7fefe9efe800bc', 10, '2019-01-10 12:00:01', NULL, NULL, NULL, NULL, NULL, '考试结束', '1', '92dd88b1-9157-46de-bfee-51c6b1d17229', '十大', 100, NULL, '2019-01-09 12:06:22', 1, NULL);
INSERT INTO `examparper_tb` VALUES ('c8ef8ea13ffa4a4a8de2d721f4b0e824', 10, '2019-01-09 12:08:48', 1, 1, 1, NULL, 1, '考试中', '1', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'Java基础', 100, NULL, '2019-01-09 12:04:04', 1, 60);
INSERT INTO `examparper_tb` VALUES ('d1e17242502642908350cebd0c12df3d', 5, '2019-01-10 15:43:00', 0, 1, 0, 5, 4, '考试结束', '1', '92dd88b1-9157-46de-bfee-51c6b1d17229', '期末考试', 10, NULL, '2019-01-10 15:38:36', 1, 5);
INSERT INTO `examparper_tb` VALUES ('d30143e88f144fba8689b2e9422ae229', 3, '2019-01-07 14:44:00', 4, 4, 3, NULL, 4, '考试结束', '6', '92dd88b1-9157-46de-bfee-51c6b1d17229', '测试', 15, NULL, '2019-01-07 14:42:45', 1, 10);
INSERT INTO `examparper_tb` VALUES ('dd84b7ec40b7413a8a35265f1ca67828', 50, NULL, 3, 1, 1, 5, 0, '未开放', '6', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'ddddd', 100, NULL, '2019-01-07 15:42:46', 10, 60);

-- ----------------------------
-- Table structure for examrubric_tb
-- ----------------------------
DROP TABLE IF EXISTS `examrubric_tb`;
CREATE TABLE `examrubric_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(50) NULL DEFAULT NULL,
  `rubricttype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(11) NOT NULL,
  `section_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trcher_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examrubric_examparper_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examrubric_sectionexamparper_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKbxfnv3kfyynhtvejo2f5xqp7b`(`examrubric_examparper_id`) USING BTREE,
  INDEX `FKi050jejmry0gfps8ulshhj6uk`(`examrubric_sectionexamparper_id`) USING BTREE,
  CONSTRAINT `FKbxfnv3kfyynhtvejo2f5xqp7b` FOREIGN KEY (`examrubric_examparper_id`) REFERENCES `examparper_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKi050jejmry0gfps8ulshhj6uk` FOREIGN KEY (`examrubric_sectionexamparper_id`) REFERENCES `sectionexamparper_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examrubric_tb
-- ----------------------------
INSERT INTO `examrubric_tb` VALUES ('01f51ed15bfb4e4380ef4d76d006ab3e', '错误', 'xccccccccc', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('04d948bbb5a247f28b896b0b1084855d', '正确', '整合Struts2和MyBatis需要注意添加mybatis-config.xml配置文件', 1, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'a0aa4d10e6624dc0a6a29a2d88703a90', NULL);
INSERT INTO `examrubric_tb` VALUES ('08dcecf4591248a4ac75ec8018bf70c0', 'd4c7adf5055c44dda949e14eb6c89288,dd429ee0171b4219b7423b8e9ca75b9f,022010ad3529440bbf7a28e7b986df00', '2222222222', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('0a15289093f148ee8f7a508773685605', '', '12', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('0e4e34b01f4446ffbe94062615b3dc34', '81d089dc7b6b46b3b95b7269adc60013,9072f4966fc144dfa8e6d5c07b2210ea', '的萨芬士大夫', 1, '多选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', NULL);
INSERT INTO `examrubric_tb` VALUES ('0ecc4a55186e4ca8af1cb7fcc033f812', 'e797f6bb80d94c88846ecec6c9bc778e,20d6052750a4445f904e0786cc307fc0,88c2584ca1c94a14887fd9202390577e', '爱新觉罗', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('115e635d66444bd3ba2e85cd693f4b01', '54c52f1ff06e4083922315a605abc70e', 'Spring针对JDBC提供了3个模板类，不包括下面哪一个？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('12d3978ad27548529b60078afa207c0e', '会话缓存、页面缓存、队列、排行榜、发布', 'Redis最适合的场景有___________________?', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('1641a971b97b49c3b503e69b45cac42a', '405f12d799334c758dae79ef7e964f70', '哈哈哈', 5, '单选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('165746a559604d93aa3f63ea18bad2f1', '正确', '在HTML页面中，<th>标记可以为表中的一列指定一个标题', NULL, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '175ee309ae194babbbb8a8b0df6beb12', NULL);
INSERT INTO `examrubric_tb` VALUES ('19968aceb0104808b9ae398db0b4096a', '18e35056beca455fb54d79450c6d2301', 'dsf', NULL, '单选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd1e17242502642908350cebd0c12df3d', NULL);
INSERT INTO `examrubric_tb` VALUES ('1c4ff60dfdda4253864eec8de34f326f', '2724c0ecbc984a1a9ad57a57ac90a009', 'a', 294, '单选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6a24ea1d9fcb4dd58dcd64a060bd95b1', NULL);
INSERT INTO `examrubric_tb` VALUES ('1e2f927a456e4445bd1c7fde269884dc', '虚拟机', '在Java中，负责对字节代码解释执行的是_________________?', 5, '填空题', 5, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('1fb251c25a3741439825a24e4eb1aa38', '啊啊啊', '顶顶顶顶', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('200231502a5f4dbb856d50a8fa002875', 'dd12c477be8c4b679ea5a3730be5aab6,73bd6df3e9a845108aaf4cf27aa5d946', '顶顶顶顶顶顶顶顶顶顶顶', NULL, '多选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'b085b4f059ac4136aa7fefe9efe800bc', NULL);
INSERT INTO `examrubric_tb` VALUES ('22b4de0d0e5f4c72aa5d8edb86d23911', '0b4d0a2a2b2f4921a4c63f8d554cf4d6', 'Spring针对JDBC提供了3个模板类，不包括下面哪一个？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('266968645f9548e7a69f54400645a340', '正确', 'SqlSession接口是数据交互的核心API，它提供了多种方式与数据库进行交互', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('2c4dc51e00c045df8bf7de4769318d0b', '错误', 'SqlSession中通过getMapper方法获得数据访问对象，这种方式需要编程实现Dao接口', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('2db114ac891c465e872d84ce5f09197d', '错误', '在JavaScript中，select()是文本框离开焦点的函数', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('2f12b1eaec9544ea9d7ef0863b21e089', 'cb415a660852498884cf43bd502ef2fd', 'dsaf', NULL, '单选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd1e17242502642908350cebd0c12df3d', NULL);
INSERT INTO `examrubric_tb` VALUES ('31a0548ec0d740159b8c805788219b1d', '5a3c6645a1ac496a9035875b1dccab82,c5900e0c4afb43acbc2cf4ff4130e792', '12', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('3424f70238634e3fb6e66929c5b87c59', '710f24f87e554eec822f4cc65795c445', '在MySQL中，SELECT语句中限制查询结果的显示记录行数，使用什么关键字实现？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('3435de4ce8a44eab9f09bc4219ca1649', '正确', 'adfghj', 294, '判断题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6a24ea1d9fcb4dd58dcd64a060bd95b1', NULL);
INSERT INTO `examrubric_tb` VALUES ('3a508dc06dc54566bb6979b9950fc681', 'cccccccccc', 'ccccccc', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('3df561f200da400c99765b62a1fb0ba6', '729b0b8a4d4e4283b3a7d9a8dce7a52d,4bbf0728eb9a42d18eaccbe26ff056d9', '顶顶顶顶顶顶顶顶顶顶顶', NULL, '多选题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '17ecd5834df74adc8b3d3893e978cc54', NULL);
INSERT INTO `examrubric_tb` VALUES ('3fda8838f0414ba5b08ede1128dc7f7f', '正确', '设置表格背景色的属性是bgcolor', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('41497e1abf994ecf88f777144b3e1def', 'f230bc6d1e944da2b2f237fd9257cbb3', '撒打发士大夫', NULL, '单选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd1e17242502642908350cebd0c12df3d', NULL);
INSERT INTO `examrubric_tb` VALUES ('427f5279df524e25ac7237fc7cd4a9f9', 'slow、normal、fast', 'jQuery中的动画速度可以指定为：_____？', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('45240b1adf124d628b1ca8501ec53f4d', '正确', '在HTML页面中，<th>标记可以为表中的一列指定一个标题', NULL, '判断题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'dd84b7ec40b7413a8a35265f1ca67828', NULL);
INSERT INTO `examrubric_tb` VALUES ('469078636ebd4aeaa6cd1209a38b8fa6', '错误', '在MVC设计模式中，其中模型（Model）是由Servlet来充当', 1, '判断题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', NULL);
INSERT INTO `examrubric_tb` VALUES ('48ab3705e5d34b1ab5e8fee804f2810d', 'rownum', 'Oracle的分页语句关键字为：_____?', NULL, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '9a941ddfedae4b6ea0364640df47f67b', NULL);
INSERT INTO `examrubric_tb` VALUES ('4ba52579f10d480aafa5570919c68c4d', '560f0f7061d6482aa9672de1dfec24ab,6464146261434758b9a081874256142b', 's', 294, '多选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6a24ea1d9fcb4dd58dcd64a060bd95b1', NULL);
INSERT INTO `examrubric_tb` VALUES ('50c85716a6474d3f84a6a3064032c358', '-Xmn50M', '启动Java程序进程时，输入_______参数可以实现年轻代的堆大小为50M', 5, '填空题', 5, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('51708cf984784cbd864ac8155613afea', '错误', '<set>解决了字符串拼接SQL语句做法的诸多问题', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('58451b29c01845689fe88b2b23ce8efe', '禁止访问', '浏览器访问某页面，HTTP协议返回状态码为403时表示：______?', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('6002cea10c314a76bf9b8ee3801dd450', '禁止访问', '浏览器访问某页面，HTTP协议返回状态码为403时表示：______?', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('62b8b74aaa7841f4b778f6fadbb40aae', 'rownum', 'Oracle的分页语句关键字为：_____?', NULL, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'b085b4f059ac4136aa7fefe9efe800bc', NULL);
INSERT INTO `examrubric_tb` VALUES ('62fbde60fff845a8b98cddb96c384314', '-Xmn50M', '启动Java程序进程时，输入_______参数可以实现年轻代的堆大小为50M', 5, '填空题', 5, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('647524ace08c4d37a376f1dc0f6f0ec7', '0077962058a1481c91e32a569d534051,11ee217d504341bb802bbd9c38080d81', '啊啊啊啊啊啊', NULL, '多选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '17ecd5834df74adc8b3d3893e978cc54', NULL);
INSERT INTO `examrubric_tb` VALUES ('6773edadd3bb4b39ab042644ced3d750', '正确', 'SqlSessionFactory类是典型的工厂类', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('67de36f49aed49c4b0b3764c3afb45ab', '错误', '8888', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('67f2b38d00b344978ac867a593f06277', 'ff', 'dfg__', 294, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6a24ea1d9fcb4dd58dcd64a060bd95b1', NULL);
INSERT INTO `examrubric_tb` VALUES ('6b1fb9b076dd4623b1794ef3f41b6320', 'd1b085498d4f418faea6cccd0a8d7f17', '的说法是', 5, '单选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('6ccdef908e72426aa695953e1d4ce73d', 'b3acf101a9c747a0886c757540deb50c,3cfefe2242b841d4bea40db3248c3dbe,42b5a2ee420d40dfb975d318b0df9014', '2222222222', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('6ea624d9b6864fbb88ae4dda6f7faf8c', '全局区', '静态变量通常存储在进程____区？', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('712db910bb95414b8660bbf321696c69', 'slow、normal、fast', 'jQuery中的动画速度可以指定为：_____？', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('7145864ac6514f1eb1bba838ca4d0a23', '68419638496d405aaa748483faa36986,6bde0a422ebf4cd981cd13cf38b4cef5', '顶顶顶顶顶顶顶顶顶顶顶', NULL, '多选题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '175ee309ae194babbbb8a8b0df6beb12', NULL);
INSERT INTO `examrubric_tb` VALUES ('718f6095be8e4955a9ff2e2d695bd77d', '正确', 'EasyUI validatebox 控件，提供了几种默认的验证类型，这些类型包括email', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('72c362044c55400a907f9ab0ed64574e', '错误', 'Redis最基本的数据类型中hmset/hmget：存取散列值', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('75467d1645834d0b83b601b8279f9e0e', '正确', 'Resources是MyBatis的接口或类是', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('79aa30d944da4507bf0b5ac42a997f09', 'ggggggggggggggggsdfaasdf', 'gggggggggggg', 5, '填空题', 5, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('7a146080ba7842218a6a14b546a13676', '错误', '弟弟的', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('7a1eb9a89f4e46ddb29cf86c0c4a07ae', 'c6c5afa1edc14fe58e346c2ba383c2d0', '在 Spring框架中，面向切面编程 (AOP)的目标在于', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('7b5ddfcbc8a8484f9af655adf8df713d', 'f374b891ac8c452985464b2624c7af34,c0bdcaba262d49c3869c812aa7d44ba6,f8083f05740e46b2bfabcd0dfbfde44b', '哈哈哈', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('7ca2ef4d278f4aa99a10076f7f9b1e3a', '查看当前环境下的所有对象', 'sp_tables系统存储过程的含义是：______?', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('7d9ee9d0a1574fa088972e685da4aa2b', '2288777fec4c4f09b93d5cda7dca9896,c5df5f40d81846beb5ff90c76d4d80ad', '12', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('7f083cbfcc4d494db2a4f4e08177a6dc', '正确', '在HTML页面中，<th>标记可以为表中的一列指定一个标题', NULL, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd1e17242502642908350cebd0c12df3d', NULL);
INSERT INTO `examrubric_tb` VALUES ('8306c06b50214e86ba49a187788cb19a', '92c1b86280bf4f8f81748ec34897a6f8,d2e29097cf3a4eeb81a54c9c7723a7d5,73e8c4f17fbf4821b51e55d8629641f6', '爱新觉罗', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('856890702c9c4216a7f59e77fa5f139a', 'asd', 'sad', NULL, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'dd84b7ec40b7413a8a35265f1ca67828', NULL);
INSERT INTO `examrubric_tb` VALUES ('86e559cafad94913b2614c5028d59f54', '5ea252a122604d9fbe365582e2a6948d', 'dsaff', 5, '单选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('8868012db80a460fa2e2dbd73ca9d90a', '预编译语句、mpper方式中的#vvvvvvvv', '防止SQL注入方式为：_________?', 1, '填空题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'a0aa4d10e6624dc0a6a29a2d88703a90', NULL);
INSERT INTO `examrubric_tb` VALUES ('89e8a3ad50e54a12949584776801bfdf', '2850e9956e9a4ce1a9b1fd99a63d0564,a899a527551e41d694181d5908d438b2', '啊啊啊啊啊啊', 1, '多选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'a0aa4d10e6624dc0a6a29a2d88703a90', NULL);
INSERT INTO `examrubric_tb` VALUES ('8c68171d11364e1cac181ff77918f878', '31b8b19c5e3b42338edb4300e4c102a6,09677fc26dcc464cb57d151538d5ce88', '顶顶顶顶顶顶顶顶顶顶顶', NULL, '多选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'dd84b7ec40b7413a8a35265f1ca67828', NULL);
INSERT INTO `examrubric_tb` VALUES ('8f89deda0df2404e85795c683c52a6b5', '正确', '在HTML开发中，制作网站首页时需要考虑两个方面内容，分别是页面内容和页面布局', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('9222504f05dd4eb58703a37a5de92c43', 'f15aaa461c95458d93102efed37382d3,1f294139220b4f088dda59839ad2ba3f', '的萨拉反馈', 5, '多选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('928c388a41574d999399f305e7a64996', '错误', '弟弟的', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('9d6106e99e084b679fa8022139a87240', '正确', 'Resources是MyBatis的接口或类是', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('a04cd6c2a0914254ac4acae16ebc518d', '正确', '3333333333', NULL, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '17ecd5834df74adc8b3d3893e978cc54', NULL);
INSERT INTO `examrubric_tb` VALUES ('a5478ce5c8c84688bd5ef380bf433165', '14d1933cdfbc4b1a99f48b19a14f4fbc', '信息的数据表示形式是？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('a7b76da600394fa791657cc9ee9b2e69', 'group by、order by', '_______和_______子句都不支持算数表达式?', 5, '填空题', 5, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('a7e2fe497de14a73886b9b3e2ed37773', '2568dea228b54e4bbdcaa8dfec5f2790', '在 Spring框架中，面向切面编程 (AOP)的目标在于', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('ac2aa63686cc433d9c876372a760795f', 'ced11d7c5a0e44ffb927481e85382bfb', 'dsf', 5, '单选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('b35d91523eb54633be2d3f28e60b31a2', '87bbb03f7af4499c9d3cfb3b8d50704f', 'dsaff', 5, '单选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('b47dc484928b4894b817f949db819e3c', '523322df6e1746a08c816f3f4b81256b,1383c35cf0c543208fdccce54e6cfda7,46056fe692ad4daea1b0a351ccc02f68', 'dsa', 5, '多选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('bbe505212f2c4e45aa12ef074c64d802', '正确', '设置表格背景色的属性是bgcolor', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('c0587131cae246278fd04388e374b6bf', 'SELECT price FROM book WHERE book_name LIKE ‘计算机%’', '要查询book表中所有书名中以“计算机”开头的书籍的价格，可用（ ）语句？', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('c25226abfbd144eca2128a0ae38b76c5', 'slow、normal、fast', 'jQuery中的动画速度可以指定为：_____？', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('c452775d8c7b433e9d32b4f1a6a2b5a4', 'a9d377b26fb14f908d41d0f63af699f6', 'dsafsaf', 1, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'a0aa4d10e6624dc0a6a29a2d88703a90', NULL);
INSERT INTO `examrubric_tb` VALUES ('c55b3ef2978149b7ae4f5c0851921926', 'rownum', 'Oracle的分页语句关键字为：_____?', NULL, '填空题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '175ee309ae194babbbb8a8b0df6beb12', NULL);
INSERT INTO `examrubric_tb` VALUES ('c62a2cd42ad9479a9317f941b046a441', 'rownum', 'Oracle的分页语句关键字为：_____?', NULL, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'dd84b7ec40b7413a8a35265f1ca67828', NULL);
INSERT INTO `examrubric_tb` VALUES ('c76fe7d5310d44b5bc869e23bbf42650', '正确', '打撒发士大夫', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('d1ef82f4264b42858b1cf91516572560', '错误', 'cccccccc', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('e007bc567cc34ead99330477edaef08c', 'SELECT price FROM book WHERE book_name LIKE ‘计算机%’', '要查询book表中所有书名中以“计算机”开头的书籍的价格，可用（ ）语句？', 6, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('e37dfdf75fc94769ada1a5871d0a15e7', '30401ae3df5b47d98d8bca5d4634f8c4', '在MySQL中，SELECT语句中限制查询结果的显示记录行数，使用什么关键字实现？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('e44e566c79b5407daf90600573eba2b8', '42ff546c824742a89ef866c1a348173c', '撒打发士大夫', NULL, '单选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd1e17242502642908350cebd0c12df3d', NULL);
INSERT INTO `examrubric_tb` VALUES ('e49bcb6016f6420582754cf5e5fce9f6', '正确', '白敬亭', NULL, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '17ecd5834df74adc8b3d3893e978cc54', NULL);
INSERT INTO `examrubric_tb` VALUES ('e921dcfa5008429e90ad6c9249656656', '错误', '<cache>标签属性描述中flushInterval：被缓存对象的清除算法', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('ead20a687bcd42ccb0d9d6af82778946', '正确', '<A href=“mailto:123@abcd.com”>邮箱</A>邮箱</A>链接到电子邮件', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('edb60003ed6044238b2b3acd15b00746', 'a0b7c4ae0eb74c6ba6ed106c858235d6', '以下哪个是按照班级进行分组？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('eee9ee35bf9f4ef5b960d807bdc945f6', '$(\"#fmLogin\").form(\"clear\")', '在EasyUI中，哪段代码可以清除form表单中填写的内容？', 1, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', NULL);
INSERT INTO `examrubric_tb` VALUES ('ef08b34fa9a242e8a9d64b97bd9c43ef', '6e8dddc513524ba99842d8927f71c743', '顶顶顶顶', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('f0fd2049e59449efbe0ebea114b91bcb', '', 'dsa', 5, '多选题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('f4402572bc174e309a7948957481dd23', '正确', '打撒发士大夫', 5, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4855f39a20364d148c6cd0461db5ecbc', NULL);
INSERT INTO `examrubric_tb` VALUES ('f508d6bb4d714be4854f8b5d36ab54bd', '8a30029b5ea44c1b8a071972f6c495d1', '信息的数据表示形式是？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('f56c1a778cc2468f813d345dcb51ce53', '2d2ffb3951884aabb6efd3dc0ab2d739', 'dsafsaf', 1, '单选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', NULL);
INSERT INTO `examrubric_tb` VALUES ('f5efdc0cd03f488ba9096f35bee39b0c', '', '2222222222', 6, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '18110039e9104663a7b045a5c66dcbf3', NULL);
INSERT INTO `examrubric_tb` VALUES ('f6a77de6262644bc9a8cda4650241e4f', '5bf0024b2ca4429bb7398851ca4c017c', 'Spring针对JDBC提供了3个模板类，不包括下面哪一个？', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);
INSERT INTO `examrubric_tb` VALUES ('f965a4de8e4743f0bbd0d7fc6e9100f2', 'rownum', 'Oracle的分页语句关键字为：_____?', NULL, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'dd84b7ec40b7413a8a35265f1ca67828', NULL);
INSERT INTO `examrubric_tb` VALUES ('fcfea5041fb246599065e5b886ca88ef', 'e1c2d87926de4376b7a1b429a98ab610', '11111111111', 6, '单选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd30143e88f144fba8689b2e9422ae229', NULL);
INSERT INTO `examrubric_tb` VALUES ('fee5c07d4bc3472580ba43634ff7f375', '正确', '在Mybatis中ExecutorType.SIMPLE是ExecutorType的值', 6, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '7d405e28f5674920913abf4f0dbb10bf', NULL);

-- ----------------------------
-- Table structure for performance_tb
-- ----------------------------
DROP TABLE IF EXISTS `performance_tb`;
CREATE TABLE `performance_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `total` int(11) NOT NULL,
  `parper_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `isqualified` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of performance_tb
-- ----------------------------
INSERT INTO `performance_tb` VALUES ('1315fe8d28f84fc5be2066e57f685b27', '27a1026f-be4d-4651-9245-578e31d1728a', 3, '346c1695d2f14bdf811f0a9fc6727f34', '2019-07-27 10:46:05', NULL);
INSERT INTO `performance_tb` VALUES ('2ac0d8b452ea43fea4df7eea9a9c4651', '27a1026f-be4d-4651-9245-578e31d1728a', 3, '6c33a488597847119b494a01f64c6b83', '2019-01-07 15:57:28', NULL);
INSERT INTO `performance_tb` VALUES ('2d9924dca2ae4d11a66575c7b1f90b8a', '27a1026f-be4d-4651-9245-578e31d1728a', 6, 'd1e17242502642908350cebd0c12df3d', NULL, '合格');
INSERT INTO `performance_tb` VALUES ('4cc805dbab864b99a86efa7407aa70b0', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 'd30143e88f144fba8689b2e9422ae229', NULL, '不合格');
INSERT INTO `performance_tb` VALUES ('cc1d1b950f744e9ca559d8f413f5c023', '27a1026f-be4d-4651-9245-578e31d1728a', 0, '18110039e9104663a7b045a5c66dcbf3', NULL, '不合格');
INSERT INTO `performance_tb` VALUES ('db25767a7cf9497ba74e8f8138f231d8', '27a1026f-be4d-4651-9245-578e31d1728a', 25, 'c8ef8ea13ffa4a4a8de2d721f4b0e824', NULL, '不合格');
INSERT INTO `performance_tb` VALUES ('e59d71eaf13a4dc2a3f2178fadf476a4', '27a1026f-be4d-4651-9245-578e31d1728a', 0, '6c33a488597847119b494a01f64c6b83', '2019-01-07 15:57:54', NULL);

-- ----------------------------
-- Table structure for rubric_tb
-- ----------------------------
DROP TABLE IF EXISTS `rubric_tb`;
CREATE TABLE `rubric_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(20) UNSIGNED NULL DEFAULT NULL,
  `rubricttype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(30) NULL DEFAULT NULL,
  `section_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trcher_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rubric_tb
-- ----------------------------
INSERT INTO `rubric_tb` VALUES ('0131745faa834132b92b7cdf618b9aaf', 'rownum', 'Oracle的分页语句关键字为：_____?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('014592a37a544fd8991f069dda8d3433', '46b174e94e6f4d5299c88f5e8b4dfe0f,90a261b9e5e4478aa8f7c4f7b886291e', '顶顶顶顶顶顶顶顶顶顶顶', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('016c10a0e8f24555978eccb5494d678c', 'asd', 'sad', 16, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('01f064ac118b41ef9ba1ed99f9432ad8', '正确', '在HTML页面中，<th>标记可以为表中的一列指定一个标题', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('02355ba2dc2f49de803e291c5079dc37', 'd1d4cbee18a0488781d51917a4131018', 'a', 294, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('031406d2139c4edf862f65c81dcaaa4d', 'bb8b7e63ce774e009b083f66b815c985', '撒打发士大夫', 1, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('044cbbe0caf64797af51079a4ffe8e1f', '正确', '白敬亭', 1, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('04f2ee2dc2a84f6bab5e1275d14417d9', '正确', '3333333333', 12, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('05d911c4078748268804864c7369757a', '正确', '8888', 12, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('06d9fd681d0242c9be800ffba1725a94', '预编译语句、mpper方式中的#vvvvvvvv', '防止SQL注入方式为：_________?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('06f91ac9c81246adb161d760ef736afb', '正确', '动态SQL运用最多的地方要算查询条件的产生', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('09a9bef5e277450dabb67f2b2c30432f', '正确', '7777777777', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0a4e310df73e403db0de9aa43a8a43f7', '正确', '一级缓存是跨多个会话的，MyBatis内置了一个二级缓存，可以直接使用', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0a731b461ec246ccb3b91fc0aa536526', '正确', '选项卡控件中tabPosition属性的可取值有center ', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0a943f80899d4525affb56cb41752f29', '错误', 'Java事务的类型有三种：JDBC事务、JTA事务、容器事务', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0abd170b46cb447fbd6e71d613b28a9f', 'ggggggggggggggggsdfaasdf', 'gggggggggggg', 5, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0bf1c2adbaef4e3a9400c66ae97d2899', '打撒发', '打撒发', 11, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0c2c99570bd74c7d9497c5659e89041f', '正确', '<where>元素主要用来简化SQL语句中where条件判断的书写', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0dc10ce59d8d43c7b2003e9999b34307', 'da4703a16fe342928b90c2a0b20a5f55', 'dsaf', 8, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0df24612f265482d8b318ba9e64fcc55', '7d8d14494d79466691375524d5d1bc9a,ab00ba1adcca44929d4fce37b5340ae6,12a6bd6a101a44d894985490e6fb072f', '十大发射点fee', 8, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0e1397b4df784e4cba0843e6e25846cc', '从现有的表格(table)元素创建DataGrid、使用表格(table)元素和easyui代码创建', 'DataGrid的创建有两种方式，分别是____?', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('0e949302e9ea436aa7d5f5d40e1c5251', '正确', 'asdd', 16, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('10c91c036ac24ca48fdcfd4ebc311135', '正确', '踩踩踩踩踩踩踩踩', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1268199585a44c8aa7cdf0d1ffeff2db', '收集信息、标识实体、标识实体的属性、标识实体之间的关系', '设计数据库的四个步骤_______?', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('12a8e8d6dbab482abe734682c95f47d1', '-Xmn50M', '启动Java程序进程时，输入_______参数可以实现年轻代的堆大小为50M', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('139762e8412248b9980c3ffc9da8af44', '<img/>标签和title属性', '在HTML中，显示图片与鼠标移至图片上提示文字分别用什么标签和属性？', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('149322f50b974f9482225a2273df50f7', '正确', 'SqlSessionFactory类是典型的工厂类', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('168040e7beb24d4288dfc166e18a9ce3', '错误', '根据处理用户操作位置的不同，HTML主要分为两大类：服务器端动态页面和客户端动态页面', 8, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('170e650f9b5d402cbc0b19ccd3160af9', '强引用、软引用、弱引用和虚引用', 'Java中对象的引用分为四种级别，这四种级别由高到低依次为_______?', 8, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('17dd662d818448afbf88d6e45879cc09', '士大夫撒地方撒地方撒地方', '士大夫十大发士大夫撒地方', 8, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1906e15d74e74e6cab6df2b04a770b7e', '正确', 'request对象是ServletRequest的一个实例', 8, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('196dcad314134526857ec253dd409d89', 'vvvvvvvvvvv', 'vvvvvvvvvv', 9, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('19952f312e98431a90f5ddd464063cb6', '正确', 'JSP EL 表达式的语法是#{ JSP expression }', 8, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1b3131d035df4dd1a72b38de29714422', 'DELETE、SAVE-UPDATE', 'Hibernate的映射文件中的cascade属性可以取值有_____、_____?', 9, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1c5d20ce19c849bb9269ee6065bc2e95', '正确', 'foreach属性中item:表示集合中每一个元素进行迭代时的别名', 9, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1c8493501b7c44e2b456d41236c9062d', 'DOM、SAX', 'XML常用解析器有两种，分别是______、_______?', 8, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1c865148678e440ab7643c63a967b9e8', '正确', '静态元素和指令元素属于JSP页面组成', 8, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1ce0d7b4a9e2426eb71d450d36b56062', 'bf5399b7d7c84299b0a9a98c8b3f64e9', 'dsf', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1dac899cc87f47a3bce7e5861ddb6fe7', '士大夫', '萨芬', 1, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1dc33991cd3f4b9a8e26eec450ab3012', 'cb06707c7d964fbdabfb554c79ca57d8', '撒打发士大夫', 9, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1e21f946f1ec4444ad7ad2d888738972', '单行注释以\"--\"开头、多行注释以\"/*\"开头，以\"*/\"结束', 'SQL SERVER提供的注释类型有？', 9, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1eca2542d77d4875979ad068a5ed586f', 'a2e0bc0b60984d7e9fd35a340d0c95de,aacac62fe07c405c9437887abc0bf982,838916d914974c0294049c13b3a44376', 'sdafsdaf', 9, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('1efd314cbbe048aaa1387d7e860cd087', '是现实生活中区别于其他的实物、具有自己的属性的对象、抽象的对象', '在数据库设计中：E-R图模型实体的含义是？', 9, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('20ff3c14516c4d859189c0138774174f', '正确', '<properties>用于读取属性文件', 9, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('21f77485fcc642e99f060c554996c11a', '320cef30103e4ac485eb1010af472e2e', '的撒法艰苦拉萨大家发', 9, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('2328e748fcb0458ba89a6ec3f8aeced3', '正确', 'ASDFGHJKL', 2, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('254498176e7748899a1b0b1eb4ef13b7', '0b8a53d8ed6f4963af8de2538da22bca,9e1666f6ddf44270aae7e201093b9989', '的撒发射点发', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('28b6760c3bf2480a88c5fed9c9ddc2d7', 'Png', '当希望使图片的背景是透明的时候，应该使用的图像格式是？', 9, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('2b958279e88f4d6e8e65815dddf2176e', '', '反对他的婚姻', NULL, '单选题', NULL, NULL, '');
INSERT INTO `rubric_tb` VALUES ('2d6e87af1bb140f4bbace58799220a1d', 'b702df772b54410d858a557cadc701b8,a1fbbc9f20594809827098cfeceb0483', '打发士大夫', 12, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('2e7e4f36a5054c97b2702b67afc41c38', 'easyui-lang-zh_CN.js', '在EasyUI中，哪个语言文件代表简体中文？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('2f3a97fa23d146d0b3104fe0583c0637', 'd244eab26a104b9389eefc0d04df26a9', '目前MySQL默认数据存储引擎是？', 12, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('2ffc5f11875d46ec9bacc9afeefc0e5e', '-keep、-p', 'Web service创建客户端代码使用工具wsimport需要的参数是', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('2ffdec4a340043239a943e91f3c16a5d', '错误', '虽然MyBatis的二级缓存是跨会话的，但它对减少数据库的访问压力没有一点作用', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('300cc3438500478583a3e2c7564e463e', '错误', 'xccccccccc', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('30bc29e0ca38499aaab39578657fa367', 'a3cb9c1f48b641679f0dde14c782d924', '而又特意', 8, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3127d0f715ae458e83412c6d552bc175', 'Windows平台', 'Microsoft公司的SQL Server数据库管理系统一般只能运行于_______？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('312aa6b53f4e4968b166d2275853bd46', '错误', 'window控件的属性中closed定义事都可以关闭窗口', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('317b6ecd6b834427b99f270c9ee5c79c', 'icon.css', 'EasyUI中定义图标信息的CSS文件是什么？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('31983496e20b461c949cd58593046bb0', '实体完整性、引用完整性、用户自定义完整', '数据完整性包括？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('319fec070acb4a73ac1d4aa172bdb224', '2', 'String a=new String(\'1\'+\'2\')最终创建______个对象？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('321c4abfb5c54fa1b2e8f674223871fa', '错误', 'Mybatis的优点自动化的ORM框架，便于面向对象开发', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('32a212c1e0044e5ea984a16f71732cb6', '聚集索引、非聚集索引', 'SQL Server中索引的分类主要有_______和______？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('32a444f2bfe4406f8e65c23b633853b7', '正确', '插件中依赖关系为dialog->window->panel', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('332639ff7d7a4bb2a8c0f8948ed84916', '正确', '转发是服务器跳转', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3334668ee946486bab7be582e8840ebf', '正确', 'Redis最基本的数据类型中hdel：删除某个字段', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('34107db561f04279b95e7a1bac2000bc', '正确', '在html表单中，最适合表达“性别”数据的标签是<input type=\"radio\"/>', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3453b9a1d44d4b5b953f15ca50ee39d2', 'FH', 'HJHGFDFFHGH', 2, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('373431ff4d5e481f893d4930ecee0923', 'center ', '选项卡控件中tabPosition属性的可取值不包括？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('374f0d0d5edc45748e9b87b2cef6cc5f', 'truncate  table  tuser;ss', '清空表所有数据的性能最优的语句是：____________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('37db22a03c8b4a21bf7a87673475333b', 'Set注入、构造器注入、静态工厂的方法注入、实例工厂的方法注入', 'Spring提供了多种依赖注入方式，分别是什么_________________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('393631f3cab7430a80bff5142efeb905', '有一个分支不调用自身', '递归函数最终会结束，那么这个函数一定______?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3a415b5710ba4446ba5004032e5350bd', 'fe80e7bbc54b4adaafd27e4b46d7ceef,da89b70fc31941968d53b23282b0cd85', '哈哈哈', 6, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3a92867b637044feba215def83937274', '71e13192df4b4980bc601e610d15b031', '我让他问题', NULL, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3c3e033b7481482ea6722fc72069aa32', '6c387b64be944a759395ac43161866c9', 'wwwww', NULL, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3d53bf781c9b4625aebd8245de8e020d', '大苏打大大大', '的撒发射点', 11, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3e2c92e8ad2944c0aabca90c53709a11', '正确', 'ORM指的是对象关系映射', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3e3dff36cf6c41efb36dbcb1fba9b042', '正确', 'UNDEFINED类型只有一个取值，若变量未被赋值或使用未定义的变量都将产生UNDEFINED', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3e70c2e0576f420696f30880618523f2', '正确', 'ccccc', 9, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3e8b2838a43f47feb2be194640af78b5', '97b38a6d138d43be92533cdac154bbfc', 'ddddddd', NULL, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3ee3c349f6e7475493163220592c3b41', '74122c19760349c08b13d25cf4bf85da', '以下关于依赖注入的选项中，说法正确的是?', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3f72176bf27945109780d023045cc4f2', 'ecc6dbcbdf2b48b3a1421f1eca214829', '以下查询语句错误的是?', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('3fb962320f204d95b8c54fbab63d286e', '', '根深蒂固山豆根', NULL, '单选题', NULL, NULL, '');
INSERT INTO `rubric_tb` VALUES ('3fd18b8978134a8b9a8721ecda599e48', 'icon.css', '图标在EasyUI中，应用非常广泛，请问图标样式被定义哪个文件中？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('40a4d0fbdc4a470a992073fde694f70f', '1471d077dfb14e95918b41e074eb4b7b', '扫描basePackage指定包下的dao接口和映射文件使用那一个类？', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('40b0e32209a34e61bf0242fe05b5f20f', '正确', 'd', 1, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4100fdd5057740329facf791d32fc108', 'url级别权限控制、方法注解权限控制、代码级别权限控制、页面标签权限控制', 'Shiro的四种权限控制方法_________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('410a61e5d00f42a6a6dee7ce08f9b01b', '8785e950745b4dbaa6e4ace9e21bf0b6', 'a', 2, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4119e1a8c93e48bd865ac928ca665e77', '效率低下、更新和检索数据会出现异常', '糟糕的数据库设计有哪些不足？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('41cc71e09b064220a89b557a08868471', '83df5f8a57ca4e88b18fc61ff5f990a9', '娜娜娜娜难难难', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('424b75080bbd4935afa22fea111fe175', '正确', 'ree控件中定义是否在每一个节点之前都显示复选框的属性为checkbox', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('42760c1909594f919f38c768807634b7', '51e699cb1f3046769487bdee6163444d,0cb86765d89c499bb04cf38dfa956dd2,924f9e7d992d49df9c4fffdccdba9bcd,5da73b2fc1c248479c2a3e096f33e5e4', '士大夫撒地方', 12, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('42af75326dc44d7f80b4b993241279ef', '1c0e47a33c804b13a8c5092e4fceb80a,f52919b13ff94e6c85f70b2912076fbf', '顶顶顶顶顶', 6, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('42def2b600344e69b27a2f69cbbf34d4', 'ID选择器', '假如需要选择页面中唯一的一个DOM元素，哪个是最快，最高效的选择器____?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('42f2027509584558863b6a9714058e66', '正确', '数据库维护管理不属于JDBC基本功能', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('431054dc02c04be5a8e933df0fe01cab', 'FTP、TCP', '文件对外共享的协议有：__________________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4341f3985a8a4e8987010358d44db5d2', '正确', '当前主流的关系型数据库有Orcale、DB2、MySQL等', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('43a1f9985f734e78988fa229425a2c41', '正确', 'adfghj', 294, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('44a4e9aad0654b0b92275b36e59a0f12', '2种', '局部变量的赋值方式有几种？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('44fd50470c494d2f9fd2d3d2344d922c', '正确', 'MyBatis框架的核心功能就在与SQL语句的映射', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4520cd7ecaa34ed7b7a6b051d17fdabe', 'ddddd', 'dddddd', 9, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('45971412ba88471aa7e4f1e19f2602d0', '原子性、一致性、隔离性、持久性', '事物的四大特征是什么：__________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('45df7d20236c4b449aade442e63db16f', '8cc0581035e649feaea61f6346997842', '101010101010', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4827b6bb388b4c3b932599a03df36175', '9715cc1518e8463389da82e6aa303b01', '啊沙发上', 9, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('485749f02ccc4597968f6f59cf663b45', '03e9067fa1a44490b477197e29289216', '关于使用Spring组装程序组件，下面说法错误的是?', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('48d08a1847a2461897a0d2c3b656a918', '错误', '网页服务默认的端口号是8080', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('491be7bdde2e4178aae883b78999a06a', '$(\"#fmLogin\").form(\"clear\")', '在EasyUI中，哪段代码可以清除form表单中填写的内容？', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('491e014c92c24d4bb3a6e5e21e2c6e7f', 'AeeayList、LinkedLise、voctor', 'List的三个子类___________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4afc7638b1124d8bbb3ed812d2027454', '正确', '事务的概念是：单个逻辑单元执行的一系列操作，要么完全地执行，要么完全地不执行', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4b993585414949f3a8c3278dd4425e8b', '错误', '使用$.ajax()方法发送Ajax请求，如果响应发生错误，使用success', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4c30b2f3b98143a1bb83a1e035fbedeb', '正确', 'SQL映射语句一般在WHERE子句的条件中，用#{}符号表示，表示一个占位符', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4c50e22fb9ce406ebcfab9ee01e6cfe9', '正确', 'ccccccccccc', 11, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4ebed4fa14e948f991c8fb336164ef74', '$get、$post、$ajax、$getJSON', 'jquery中请求方式有_________？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('4f7830365f5b406db5b6bf4eb229afb4', '0abdd2cbb3614046899dcb6fce084c41', '撒大苏打实打实大苏打飒飒的', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('500ef279d748478cbbb4e00a81bf3fd2', '4823bda5d93f4ce28f23e6b36073f7d3', 'dsafsaf', 1, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('508c0fe6cc0b47388c3392470458fa54', '正确', '表单控件方法submit的参数options的属性不包括ajax', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('50a3cdeb41d6440ea6afb03b6461f6e8', '错误', '在Mybatis中：ExecutorType.REUSER是ExecutorType的值', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('513d0dd49df640608e9f2f6c594f3427', '实现Filter接口', '编写一个Filter，需要________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5586a26b68ff48299c2898221ba79a7f', '错误', 'window控件的属性中shadow设置是否可以改变窗口大小', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('56d5c089f34142c3996beed142c530af', '控制反转、依赖注入、面向切面编程', 'Spring容器的主要核心______、_______、______?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('59ee1e459b754300bd11855cb62ffe6f', '06d6a8616a1b4e8fafccd4105e6c2122', '的撒飞洒地方撒地方', NULL, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5a1647ca5ea04ddaa05fa9f4a33e652e', '33c7ca753f524cab865507a0361f06da', 'BJT', 20, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5ab7148dcffd4b5ab43f71bc322db821', '正确', 'lass=”easyui-combobox”代表的控件是下拉列表控件', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5b1fe683f7f64643a257eca52ae52429', '正确', 'CSS的英文全称是Cascading Style Sheets', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5b2590de04eb42979453fc22a2082290', 'bae7a97b65644ebd9f650eb4387bd1ad', 'dsaff', 5, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5babc3d35cd841fb99250e6094ca4699', '错误', '列表框的默认选择属性符合规范的写法为selected=\"true\"', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5bcc41ca2cef43c7844a60168cd42656', 'd7c3ee1941a44a5aaf5f14c147c32a34,8012024af0b84358b3e60c14652d26e7', '22', 16, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5bf10159a40c4b29a4cdade7532a28c8', '正确', '与数据库建立连接并处理查询结果属于JDBC基本功能', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5e99816699024f68b6cb2c3795676ab2', 'd45a4410adfe41298e2908f21eb09f58,ddcb4c7ff7964d2eac4f8e9597adfa9a', '啊啊啊啊啊啊', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5eaaa6c51351493c8bc85ea781c4dc71', '正确', '<cache>标签属性描述中readOnly：只读缓存', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('5fbe339fa2374bbd80bc67d9d0f19e5f', '错误', ' layout控件中两种数据方式分别是通过方法赋值读取数据和通过html页面直接获取数据', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('60e556d0477f443a9b9de12f1318d990', '错误', '<html><head></head></html>是HTML的基本结构', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6106adc526494744a17cf89564caa80f', 'IterationTag', 'doAfterBody( )方法是在______接口中定义的？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('61ca8921d1a346438b5ba0d4082f2a0f', '加载和实例化、初始化、服务、销毁', 'Servlet声明周期可以分为四个阶段_________________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('62651268aeba4418a1f2ab5ec82c098a', 'c80fc4d5fb43407894653f45ad9987a9,808b13ae075448cf99a27f1ec3db1d9b', '是的的', 12, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('639d45ec2bed4b71b729f81c5810e763', '7158d31eefb444238b2b7146eb52182d', '我已成仙!!!!!!!!', 5, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('63b24f080f28428a9b7dfe341c773220', '5b7d32b7ce134ef8b39c0611250d14e4', '11', 16, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('64347d9d9a8645049c30c28620b50115', '错误', 'JSP的全称JavaServlet Pages', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('65b62a4a578e4db5b456f4226b4b538e', '4c1f397f8dfd4f3eaf05b0b36f9b75af,c9aa4eca3de1492c975eecfee4b46b5e', 'as', 2, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('662e6dbf0aae412faa8c6db41ca64cf6', '安全性考虑、减少内存泄漏、减少程序员工作量', 'Java中为什么会有GC机制_______?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('675c2c0e4a65468d8cae360138bce4cb', '正确', 'EasyUI特点为一些当前用于交互的js应用提供必要的功能', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('67767c2bd6664757af922362b2634868', 'a139b867734545628d133f080253e43c', 'dsaf', 9, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('67ba36a947534acab3ef19b2cfba1ff6', 'toggle()', '在jQuery中，函数_____能够实现元素显示和隐藏的互换?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('687a929ccd014e8ea6a172256f8c65b1', 'drop trigger', '删除触发器的语法是：_____？', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('696f61effbaa42d4844bc0d6ba7b100d', 'cccccccc', 'cccccc', 11, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('69812f98baec41239083fd29f11bc2f4', '%', '、在SELECT语句的WHERE子句的条件表达式中，可以匹配0个到多个字符的通配符是_____?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('698dfda6ceae47619d3ace0ecd420108', '正确', 'clear:none清除表单数据', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6a5b842a91354dd8b7e219b8acf4dfd2', '虚拟机', '在Java中，负责对字节代码解释执行的是_________________?', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6b8815bc13e54752bb246014a0f25f8e', '正确', 'MyBatis中动态SQL标签中<set>用于更新数据的时候，根据数据是否存在动态生成set子句', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6bf765f35f1b4eefa75c24f898d5b15e', '正确', 'choose-when可以很好地解决基于查询条件分类的数据过滤的情景', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6c0e9d322318489595ad677194e13ba0', '||', 'Oracle中字符串用____连接?', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6c1a34a6f69b4802ac2b8d4960f48379', '57c780f9724c47f09be4f63297dca0fb', '双方的哈吉客户', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6c4d09af85b141ff9bf64f84dff0fd1c', '踩踩踩', '踩踩踩', 1, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6ce4aa19ed844beeb377e04eb151f5f3', '正确', 'cccc', 9, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6d7f41b53df548809bea8dd5f00c7420', '错误', 'MyBatis本地缓存分为一级缓存、二级缓存和多级缓存', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6e117009651a4e33ac79305e71ac9f1b', '正确', 'EasyUI validatebox 控件，提供了几种默认的验证类型，这些类型包括email', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6e41156aa4dc468ab450553a05229f37', '士大夫', '打撒发', 1, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6ea1465b610b4250b53867dff3d3cf3c', '正确', '客户端的DHTML技术包括HTML4．0、CSS、DOM和脚本语言', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6f35c1f00ca24e4dbb8741b568c63286', '6fdsfsadf sdaf', '如果某系统15*4=112成立，则系统采用的是_____进制？', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('6ffc4f78a0f2412b8e9b47ca392cb8b5', '8b83101b35cd452b957af5ad577545c6', 'baijingting', NULL, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('72b911f6f8224e289f02dd0f71288ed2', '<input type=\"radio\"/>', '在html表单中，最适合表达“性别”数据的标签是？', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('72f921a74af94c5dba3ed0392b574cbe', 'session.getAttribute(\"userid\");', '_______用于检索session属性userid的值？', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('732015d055634e78aa9311e17c16bcc2', '正确', 'next()用于获取匹配元素后面紧邻的同辈元素', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7508c43ac7174b589752d297eac746a1', 'ccccccc', 'cccc', 5, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('754ac78e8a8f44c2bf8fd5d589550d7b', 'e2a0685f02524c98bc69dd7ba8e9365d,33fce074ced840bda622f617ababd8a4,32b16e869b174a66b959be3f8702aa08', '爱新觉罗', 6, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7557dca2475e4746a98f58671eca695e', '错误', '<cache>标签属性描述中flushInterval：被缓存对象的清除算法', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('75e93e57f4b04f3ab6a83d33b339ffd2', '25e2c5c935214654b51d2f9166734501', 'dsfdsfs', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7612c505ca754461a438ef4e67534062', '错误', 'SqlSession中通过getMapper方法获得数据访问对象，这种方式需要编程实现Dao接口', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7730e22fb43e4e7683270aca8180cdf0', '正确', '打撒发士大夫', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7764153205ec4ff2904b1434e3b7dbe7', '存储过程、数据库日志', '可以监控到数据库变化的机制有：__________________?', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('77a7c6c4599e4e1987e20690ca944ca9', 'fffff', 'ffffff', 9, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('78310617c6174032a14c36f37ad53e21', 'distinct', '____关键字在SELECT语句中表示取消重复行?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('78db2df7d6be4117ae56fc2cb102c079', '错误', '映射要用到的元素有<resultMap>、<id>、<property>', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('79189426911d4ef7a4a4be384c4abf54', '查看当前环境下的所有对象', 'sp_tables系统存储过程的含义是：______?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7a53e1afa5a941498859c7950bb687bc', '错误', '在JavaScript中，select()是文本框离开焦点的函数', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7acb4b1ade75456e9feae1309994fda8', '3d67def8fe92411599c306dab288df09,a6bec4ad24ec420eba9dd9dbce089f55', '的萨芬士大夫', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7ba5d89c01104b1381456ebc135d8e28', 'ccd61188be414b8b88e9e61982610f50', '的风格和大风和', NULL, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7c4d27c3c9d34751afa069eac4d8631f', '正确', '<A href=“mailto:123@abcd.com”>邮箱</A>邮箱</A>链接到电子邮件', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7cbdd2f9a0294429ad922fdd0e6273c0', ':contains()', '如果需要匹配包含文本的元素，用______来实现?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7d173acf58d84a3ea9f4b33743555c23', 'SELECT price FROM book WHERE book_name LIKE ‘计算机%’', '要查询book表中所有书名中以“计算机”开头的书籍的价格，可用（ ）语句？', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7d194b1c6d50483b973d105baf26ae44', '错误', '在SQL映射语句中，想要表示一个占位符，可以用{#}', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7d8f13d0675c4192b75268e18f4020f2', '正确', 'vvvvvvvv', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7d93a529273448d99d84a39056157de8', 'NOT', '在SQL Server 2008中，对IN语句取反的方法是，在IN前面添加____？', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7dc83a074a8443cf99f5e3eea203a1f0', '2d99964a612a4c8abe618fc9b44ff719', 'Spring针对JDBC提供了3个模板类，不包括下面哪？', 6, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7eb231f58ec54929b77f5f6cd80e86b8', '错误', 'substring方法是用来按照指定的分隔符拆分得到数组？', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('7ffa0bac88544b268f9869e2d6105256', '正确', '顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶', 6, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('80333b85018042789e1b656cd6421d4b', 'error>warn>info>debug', 'Long4j的优先级从高到低的排序____________?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8041f7c001e34cbf855d12cc51fabb1c', '正确', 'SqlSession接口是数据交互的核心API，它提供了多种方式与数据库进行交互', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('80aa6c1c02a1406f99ef082994e5242c', '错误', '在选项卡的属性中selected为默认值0的时候，代表什么含义为当前选项卡为可用状态', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('80bdf883a87b45cd8db0c9ce61ab1d47', '封装、继承、多态、抽象', '面向对象的四大特征_______?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('81b5e3a72368420eaa65231467955773', '653f181bc1e14c99b2b83cdc66e5b300,ed5a9625759f4c84b33816e67deae0e0,1007a31602834b7c9615e4591c7e14bd', 'dsf', 11, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('82096d353a4445659b8ce411338cba35', '错误', '8888', 6, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('83101d78a98d40c48cbd90409faa65d0', '9f44c050422744c0aef99a0e26e67a14,746b377cf1034ca2b2af1cbe7a77752e,e789b4e096de44e78f8f1b5211304043', 'eeeeeeeeee', 8, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('83772e81135546768ec1370e72b79723', '9d85fcb4e62e4d05ab740a13b670dabe', 'dsf', 5, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8407a759e3b6413d8f78e505272da3f6', '422284df0b724f53be519967371c38d7', '以下哪个是按照班级进行分组？', 6, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('842da9ceeaef40e8b74ba5d60e8130a8', '正确', 'MyBatis的<if>元素可以有效地解决用字符串拼接SQL语句做法的多种缺点 ', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('843dbc34bae84c30ba41d5adf8857c36', '正确', '在Mybatis中ExecutorType.SIMPLE是ExecutorType的值', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('844471e815ea4893a8b457ff09690461', 'slow、normal、fast', 'jQuery中的动画速度可以指定为：_____？', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8460e9d0e71747a1a5272fc3296f05bb', 'table', '多语句表值函数的返回类型是：_______？', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8472fa0598c64437978e6f375b4527c5', 'a84384d5e00c47ed98b69a091946cce8', '发放', 9, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('84ada2c55efc4030a7f5392ab3c7cb6b', 'ea20de26f3b34735909b89218ead4118', '的说法是', 5, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('84fcebb86e664aa897989774efc3f06d', 'sysobjects', '在创建表时，经常会用if语句判断该表是否存在，如果不存在就创建。经常用于从哪个表中查询表是否存在？', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('852601104a214d4fa951cf1e24673d77', '错误', '字符串能够转成JSON对象', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('854f5e3be697435c9d6008e27e0a8535', '错误', 'Redis最基本的数据类型中hmset/hmget：存取散列值', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('85622eb5c38a43528cd686d412bb9306', '正确', '设置表格背景色的属性是bgcolor', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('865726fbf81b447f923395040cc2cbde', '正确', '正则表达式限定字符 * 表示零次或者多次前面的字表达式', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('88210243baf143e0a2ae10cb33feb56e', '正确', 'foreach属性中index:指定一个名字，用于表示在迭代过程中，每次迭代到的位置', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8917caad5c77494fae617aca58cfb403', '正确', 'collection属性不同值分为三种，分别为List、Array、Map', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8956a2433a4b42ba96d495dff59db9df', '88b982973dc942afb6f36fea4e70b798,c31f146ba3ee4d49aa95604b1f911905', '的萨拉反馈', 5, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('899a3498a0f541a39ee75b68df768f20', '错误', '一个JSP页面由脚本元素、指令元素、属性元素组成', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8b4afdc8f546487bb593def779d5cc59', '正确', 'onsubmit事件用于提交页面表单', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8ce0c78a5b3b455da0fba2232325eb97', '正确', '1111111111', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8d5da42ef17b442c97240c2aea1edda0', '8', 'int类型占用_____个字节？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8d5f017a98544732b62e5bef8a7dd00d', 'insert、update', '触发器中，inserted表只有执行__命令起作用？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8ec766327e334c11bdc3e7ddda2e4df9', '7f79e318d57a4993ad94313bdb4542c0', '在视图上不能完成的操作是？', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8f0a1d2bf48c474aa05b98b4efb8df63', 'getNamedQuery( )', '使用session获取命名查询的方法是_____?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8f41592ca62f4569b672682a0966b01e', '控制反转、继承', '在Spring中_______和_______两种方式访问Hibernate？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8f73d2e4a5c54acf8a9c9c9dbd0e8b01', '正确', '在HTML中，显示图片与鼠标移至图片上提示文字分别用<img/>标签和title属性', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('8fc376a6871e4553bdae41fa77567f97', '正确', 'window控件的属性中draggable定义是否可以拖拽窗口', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('901e1a91076a42269eeccf5ae41d9526', '错误', 'choose-when用于当test指定条件满足是，将when的代码追加到SQL语句中', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9059c72c51604f6aa14ab09447638c98', '8d33a9bc014749a5bed281c6d8a28452', '在数据库中主键是？', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('90b9102693e04b4ba7f53f182ce3b2c5', 'I/O', '不是常见的RPC模型是什么？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('90ef01d897c143258ec473387f400abc', '47ce48bba8e54b0e95ecaac2afcab954', '以下使用SELECT语句随机地从表中挑出指定数量的行，可以使用的方法是？', 12, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9123ee4c071a430295a62426b29dff28', 'fad014e17e3d4ba085549f586af5fadc,d8191a62cef64feb82c461a648722064', '的撒发射点22222222222222', 12, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9130d14b7cde49a3aa8f15c26dad82c4', '正确', 'MySqlSession不是MyBatis的接口或类', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('916a9d9bf37a41fc9c69032ffd63959a', '错误', '当希望使图片的背景是透明的时候，应该使用的图像格式是BMP', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('91843a3d95ad4e3792ca5bbe3ba3cf4a', '正确', 'Redis最基本的数据类型中del key：删除一个键数据', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('91c6dddbdffd4eec8d894853c072feea', '74be3eb3a78a4a788fbabdc55d37ca50,1004a306767e4a1bb3aeb900cec8e130', '很过分的事', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('91f09013249a49ae97ac21a5d122b5e5', 'Int是整型，Interger是int的封装类', 'int和Interger区别是：_____________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('924c76a9800b48bb87d9bcff5ce5eafc', 'BYTYPE、BYNAME', '空格中可以填写的选项有哪些？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('94a8de84c8d9401a9f24386da040ab49', '正确', 'dd', 1, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('95035ebdc5534fa8bb391b7147eebabe', 'OR', '使用___不可以进行模糊查询?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('950c96fab4134312a399db3fd1c0f8c7', '正确', '<where>元素会自动将其后第一个条件的and或or给忽略掉', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9532cfcf2b254a2783c32b747027fb5f', '正确', '关于request对象，getParameterName()方法返回本次请求的参数名字', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('95519b84e34f499488960e94d159371c', '正确', 'DHTML比Html更严格', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('95682ffbb62843f5aca9b9b7853b305f', '错误', 'MyBatis中动态SQL标签中<foreach>标签主要作用是循环查询数据的', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('95f7c2ba0ed0406694d0fe2851c55361', 'dd', 'dd', 1, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9614e5850e244fbb948a4a79c1c8cc32', '一对一、一对多、多对一、多对多', '在数据库的映射基数中都有哪些________？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9629eeedc8de4b1fab6c2dbd6b9fd70c', 'fa887a63d9bd4af39ee1b2cb63315a0c', '可以在创建表时用( )来创建唯一索引，也可以用( )来创建唯一索引？', 12, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9681d35f4cae4e0cb680fcfcee39e73f', '8bb43c0ac8be42e2a7a9a682ca11125d', 'SDFGHJ', 2, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('96bfe1a3d22d42d794fd18911bda6eea', '正确', 'MyBatis中动态SQL标签中<trim>主要作用是往SQL语句中插入一个SQL片段', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('97f7f04469ac43029c98ef919839b48e', '错误', '<properties>用于读取属性文件', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('981acd22d2ec49aeaaf956d735215178', '三大范式', '在数据库设计中：规范设计有几大范式理论________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('982cd7a8c1404813b9dd24bf405021db', '2fa0e8472f6c430790b23361dd6964c3', '的Sapp篇', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('985de4d38d354febbaa6b0a9e66eb8ab', 'cccccccccc', 'ccccccc', 6, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9897adf4368b4c43959bdb25951b919c', '正确', '元素节点属于DOM中节点类型', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('993e662b110c419bbcd2c690289e4d88', '正确', 'EasyUI的渲染方式为$(\'#p\').panel({...})', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('99a849827d78449daef61ddbbc2c0a19', '正确', '布局Layout有自己的属性。而布局的五个区域每个区域都是一个面板（panel）对象', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9a223ef7ca9343918e78156dde052cd9', 'connection.getMetaData().getTables(***);', '可以查询出所有的表和视图的方法：__________________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9a9c7b15772a4ed98ec687604880d4f8', '正确', '在DOM模型中用于添加节点的方法有appendChild', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9ad881ab71c446e4a66bd92fdf7a8055', 'd', 'd', NULL, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9ae000d33d064b4ea80dd242c9a6f2d1', '正确', '重定向是客户端跳转', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9ba068ddc72e474090f9b774a330f75b', '36d1eb62db4443e1958e5b9de5691c80', '33333333333', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9be3dfd9d53d4be5be77f46253d5417d', '205a7b64c040439aafd6e12b50f2b1c7', '大概多少', 9, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9c0daa5cb7254b0cb359df5cefc001ca', '错误', '二级缓存是与SqlSession对象绑定的，会随着会话对象关闭而销毁', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9ca704bef2854cca8b817418b3802df0', '通过ajax读取数据、通过url读取数据。', 'layout控件中两种数据方式分别是____?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9cfe8ed0321c4e94aa8c5210652d025d', '正确', '一个典型的SQL映射语句要有输出值和输入参数', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9d13433fffc74966b71c28fee9e5d6fc', '错误', '<where>元素在内部标签没有返回内容时也会在动态语句上插入where条件语句', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9d7b89d0716546eda2993dea31c31a6b', '正确', '的撒发射点发', 12, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9ded3644575445f7a2fad7de80b5c69d', '正确', '上传文件时，页面不需要进行设置form表单的提交方式设置为get', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9e06e5cb6f5046f689778b227d58d668', '正确', '使用<id>、<result>元素时，MyBatis会使用公有的setter方法赋值给属性', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9e717465a1df4a86a4a433afac140a28', '正确', '33333333', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9ed81370abd141f8ba858999c801b2a2', '错误', '打发十分', 1, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9f60e1b1d634424dba4e109e4618676b', 'pageContext、 request、application', 'JSP四大作用于________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('9fca289732664501921d05d0110a3071', '811bc1665cc549bbb3a878a5aa6a663d', 'bbbbbbbbbb', 1, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a080e837f75f4485a99f4886ee99ff19', '333fc618230847b89f115f1383c75df1', '使用SELECT语句随机地从表中挑出指定数量的行，可以使用的方法是?', 12, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a0d10380401a4784aef8e2d9fc69943d', '查询 3条记录', 'setMaxResults(3)方法中，参数值3是指______?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a1529f75638841b9b62a424c66fcf17c', '错误', 'load：data读取记录填充到表单中。数据参数只能是一个字符串', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a1b089a053224d009872d717137c2e1a', '9e27903235bf462c9eb5dde6f772418b,3852c3614e014a8ebb31585ca1fec11a,9ba9a6443a4948bfbfa1f4223b9fad5b', 'ABJT', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a2ba5ee9c4dc4027beb886beea78a2c3', '56f2aa2cce594633934c665dd338b7d0', 'fffffffffff', 8, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a2db57a7aa834733b061258661ca5ae8', '正确', '打撒发', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a3588635dabc4a19947a9278dec68af9', '错误', 'type=\"image\"表示的不是按钮', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a430d6936a5c4e119756058ee884be22', '五步', '原生jdbc操作数据库流程分为几步______?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a4d53c8d2491477fba60339a695d30c0', '正确', 'ddddddddddddddd', 12, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a4fb8574dadd4efbbcc1e64ddc7c7bdd', '错误', 'border-size=\"10\"设置表格边框宽度的属性为10', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a528d70e65f541c7991d32f96eeaf0c3', 'ccccc', 'cccccccc', 11, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a82fd53406d24753908ae024afbca764', '根类加载器、扩展类加载器、系统类加载器、自定义加载器', 'Java的类加载器的种类有哪___________？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('a8429b0fe4004e499eebc6dbbf7e00eb', 'Required', '表示文本框属性是否为必输项的为？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('aa8f24537e8b4540a49d46f0832fe878', '正确', '在HTML中，<span>标签和<strong>标签是内联元素', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ab18e42aeb8c43c1862331484f1d7b56', '适配器模式、装饰模式、代理模式、外观模式、桥接模式、组合模式、享元模式', '分别写出七种结构型模有哪些_________________________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ad14e638e20d494796077d5778462a90', '正确', '在Mybatis中：ExecutorType.BATCH是ExecutorType的值', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ad7827022c3243a7add3c493a29debbd', '正确', 'items属于foreach标签的属性', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ad7a430f352340628e579c9e4c89083c', 'int、short、int、long、float、double、char、booleam', '八种基本数据类型_________?', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ad93244df1874fa29716160ef4d94da8', 'mount', '在Linux中，可以使用命令______加挂计算机上的非Linux文件系统？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ad998048b7db4ce295dd5b7d1766d8bd', '正确', 'boolean类型只有真和假', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('adb65d3fd30b4d33a761ad3e3d6b45ed', 'cf012d18e5754a3b9de0f948a3749fee', '也有', 8, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('adf7294c718a4c0eb07fbc83272b4923', 'f141b25590bd4d8fab6607b32d73cfe6,4e3d3e5b30394f6dbaa746c2c9d03d0f', 'ASDFGHJ', 2, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ae12b3f5cef34548aa125385c33875b3', '错误', '打撒发', 12, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('af70777dcf8d4739bb8a6ffbf9e1e673', '正确', 'Mybatis容易维护和修改', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('afc9260bb25a448dbbf815ddf1a52afd', '错误', 'document对象的createElement方法是获取指定id的HTML页面元素对象', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('afef704cb45f4c438a964b71c5db8564', '错误', 'cccccccc', 6, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b015801cfb7a4c1ab2b3813c2491b16c', '正确', '事务的ACID原则是：一致性、隔离性、持久性、不可分割性', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b1df73389b83474da5ec1edcd492014f', '错误', 'dataSource的类型是POOLED时method是它的常用属性', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b3352f38716543aeb80bd5612716a521', '正确', '<foreach>标签作用是产生SQL片段，插入到已有SQL语句中', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b46dab1bd89148858b27cbdad8f71fb5', '错误', '动态SQL运用中，<set>标签一般用于添加的SQL语句中', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b4920096b925466284c762b21070a39c', '9ab2ed891d2746299092838ec766d269', 'dsaf', 5, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b49e976521844fa2b1b52d954e90d5c4', '正确', '关于动态SQL运用，使用<where>标签时，是不用再<if>之前加”1=1”判断的', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b4a30e13f5f14a32ac30a7435960d095', '正确', 'session里的数据是存放在服务器端', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b4c8d5a1d1304272bd16f4bc16c2f039', '正确', 'window.open(\"new.html\");此方法用来弹出新窗口', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b4f5e16a790e4a87a169b9687ac8afde', '正确', 'MyBatis的事务管理策略有JDBC、MANAGED', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b52e331cf1ef47bc83ea85f6725334ba', '数据库实施阶段', '设计数据库的步骤分为六个阶段；第五个阶段是：______?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b544d53d928b43e6866d579e0b456d94', '错误', 'JSON字符串能够转换为JAVA 对象数组', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b5d2dd0cda6049149f0ade9a4634e106', 'while', '在SQL-Server中；正确的循环？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b616fadf12a343048f86bada78526ebc', 'fe8801858a264ba89f264a94bd0186cb,ed17b07008054f4989f38aeb66d57bb0,5f6a5b9b1b74449fb44457d3490c4139', 'dsa', 5, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b69d07a86cb545ce8b22bd40d8ff71a9', '序列图', '在UML提供的图中，_____用于按照数据顺序描述对象间的交互？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b6b09c9bf9c34e29991028f798a1f5ea', '正确', 'SqlSessionFactory主要负责就是创建SqlSession对象', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b6e43f85fd1a44188ef6ee606aaa868d', '934df5fc836d4dda9eec9ec7264f60af', '的萨芬士大夫', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b799180468cd4b458de12a0027ce3430', 'Ps', 'Linux下查看进程占用CPU的百分比，使用工具________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b8599634098045d48ef1b6ab3947976d', '11111', '11111111', 5, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b8ac6fbdfa404ad3a081e59a2618a925', '5f0a0195987f47c595be2bfca6231892', 'Spring支持的数据源不包括哪一种？', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b8ca8466124143e98cf9c6965e964dfd', '正确', '使用重定向是通过重新请求新的URL实现，所以页面能够看到地址栏的变化', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b8d8add495244dbd81fd90ee530ef992', '正确', '数字框中分别表示允许最大值和最小值的属性是min、max', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b8e3484478794258a837c0dc14412b32', '错误', '士大夫1111111111111111111111', 12, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('b99a079ccda84075876a11eb6123964c', '正确', '<TITLE>HTML联系</TITLE>将HTML页面的标题设置为“HTML联系”', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ba6672f1e8e8454c8ba8996a217b01ad', '聚集索引', 'Teacher表中有一个索引，该索引的顺序与表中的数据的顺序是一致的，则该索引属于？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ba706533f90741aca42872dab0385ef6', '', '德国大使馆郭德纲s', NULL, '单选题', NULL, NULL, '');
INSERT INTO `rubric_tb` VALUES ('ba94362ca4df4341bae48d59152fa443', '外部样式表', '在HTML中使用<link/>标签链接的样式表是？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bb1d700233954e38868eff74edf84020', '禁止访问', '浏览器访问某页面，HTTP协议返回状态码为403时表示：______?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bb3d445f52c846a3852cff113dade45b', '错误', 'Dom中childNodes的是当前节点所有子节点第一个节点', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bb48dafd6ede404b81561eb9fdae3fef', '7706bfd19d47409a965276a603c92aec', '反对恢复', 6, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bc709c94f0c342e7904994289a526848', '正确', '在HTML开发中，制作网站首页时需要考虑两个方面内容，分别是页面内容和页面布局', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bcacd4d41b9c4895bed98bfe6627b485', 'ff', 'dfg__', 294, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bcc10a19f6544e01a99070fea998b2d9', '9e86c58b30a44e7198ad5a439ce696a4', '在MySQL中，SELECT语句中限制查询结果的显示记录行数，使用什么关键字实现？', 6, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bd5f61c99e084851a463f7ac5cd54c8e', '正确', 'ASDFGHJASDFGHJ', 2, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bdb67e9f82ad4261b876d7e68027cba8', '错误', '在Mybatis中：ExecutorType.EXECUTE是ExecutorType的值', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bf30a8eac91645febbcbae432c2bb276', 'xcv', 'asdfghj', 2, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('bf9a1e52aaaa4e1ab9bfd1bd65598bff', '正确', 'EasyUI提供的资源包中，themes文件夹中存储着主题文件', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c07c47e27a324affab5f7245407e8fcc', 'http：//jqueryui.com/download', 'jquery的UI下载网站是______?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c0d182f3e65c4ee29075521585100f75', '错误', '要在新窗口中打开链接，<a>中需要选用属性target=\"top\"', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c16a1df2918640658008d75e6204b46a', 'd675de01c3674858878e76be350936c6', '的撒', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c2aaa86e25ce4373ad3253f3933b02e0', 'fe1ac3b43ef34f57ae83aad89d970c7f,637c629c9c2a44749ad94f019e4eae44,cd0cbd9924154411afa85f1ddf5e855f', '2222222222', 6, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c2ec82aab0a640489e3f9588243cfb8d', '错误', 'yyyy', 16, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c39c20271bd34a82b6d0ca354ccee9df', '正确', 'MyBatis提供<typeAliases><typeAlias><package>元素类配置别名', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c4e88801c54640a4a95864d603583ad7', '正确', '<cache>标签属性描述中size：缓存大小，任意正整数', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c4f2574e39994e068fdf80347bebe2a9', '773c0275577746f5865b1693adc05591', 'nnnnnnnnnnn', 6, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c519171747404fe496228f7ee9b12114', '172322eee73c4e8d931cad9bb1f18e30', '在 Spring框架中，面向切面编程 (AOP)的目标在于', 6, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c59b560ab10d405ca3bfec5547e0edc9', '正确', 'ddddd', 9, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c63778d61fb848aa8704dda4b396dd4f', '正确', '打撒发', 12, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c6d1a00fefaf4a86b7d1e8e896f87764', '错误', '<properties>元素的resource属性指定的是属性文件所在的位置', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c77cc1e4cc154b5bbac30090e617e267', '正确', '<cache>标签属性描述中type：指定缓存产品', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c7adea623a444e46ad2a2cdba82f9546', '错误', '111111', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c800b93f6f72479ba1f814bf2519cb8c', '错误', 'tomcat安装后修改端口号，可以通过修改tomcat安装目录的/conf下的web.xml进行修改', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('c976ebfe5d3b4ffe9ca59f7f4e5124d9', '正确', 'Redis最基本的数据类型中set key value：添加或替换字符串键值对', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cb1c9a87df79402da5fdfe023ecb449b', 'f89732bea7084c1499787a93349b2153', '撒打发士大夫111111', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cba763fb47244338814ae74371ab9a2c', '正确', '区域面板属性中，表示布局面板位置的是region', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cc3166f3f57b4367b35029beff5b96c8', 'cf5ffa7bacbe4e3c8456d769319f08d3', 'sdaf', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cd0d1513741c4ce9b661247d41d425e5', '222222', '22222', 11, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cd883c3caa704f0cacffe7e08f81c6f7', 'f9c9d1f0413c4368b72d4e72c2c67d9d', '顶顶顶顶', 6, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cdbd030aa4414cf4929661053b4100e2', '定义是否能够拖拽窗口。', 'window控件中draggable属性表示？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cdfb404430264f5aabe3116745e546a4', '正确', '下列布局方法中表示设置布局大小的是resize ', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ce930159317c4f5c8c06e917c1bc22f9', 'Soket、共享内存、消息队列、信号量', 'Unix系统中，_____________可用于进程间的通信？', 12, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cf20c2383131484c8d7c547a5108ec3c', '正确', '<properties>元素的resource属性指定的是属性文件所在的位置', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('cfd767053b5a423cb463453c6e5c7274', '错误', 'foreach属性中separator:表示以什么结束', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d127a9ab9855470f943a7ed2c1c43191', '正确', '选择用户爱好的体育运动，推荐使用复选框', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d18dade15e174531bce42f5c0fe64ab1', 'b5bb5074d6e1427eb3a6cf4f51bce2af', 'SSH整合的优点有?', 12, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d1fc410e0f7546ea9ef60c9d8ebbe392', '正确', 'Java编程领域中，涌现了许多优秀的框架其中MyBatis工作在数据访问层', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d26726c004de42ffa49c0e839e797e4f', '正确', 'html的表格用table,tr,td标签表达。', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d278cd1d73f2421a8a77e24ffe126d95', '正确', 'HashMap：本地缓存', 12, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d2876869659f4965bc0100d474b590f2', '1ec5a0563cdc49d5b653e162f378e036,99bfff42f66e47bf975c3e0ac5915c2f,0bc57b3ad79b4357ab36257806e63daa', '45454', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d3156fb9ade44f75b705e245f55b071a', '正确', '在JSP中，＜%＝”1＋4”%＞将输出1+4', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d347b56a5d9745d58b4d879da5ba86f7', '错误', '在html表单中，最适合表达“性别”数据的标签是<input type=\"checkbox\"/>', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d3892a2dbf8c4666b0e3914d162528e2', '624e3e87d64f4a53b4ed0f5e079b7128,78e88c5e26ff421a95ecf7056f8642e9,2e18a9b0bf0d4ed6bb31224b5172c373', '顶顶顶顶顶顶顶', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d40a4b149dde45d1b7fa9b4749c65056', '正确', '优化SQL语句应该注意统一SQL语句写法', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d4c87f432e6943459681fe4f84647354', '正确', '<where>主要用于动态SQL查询条件添加', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d4d28e096e294418b68d003cc685ac15', '7b1c8143e43e491daf7c7d9ecbaf7d73,58a55fc314654dfabe18cb044c01705d', '萨非广告', 9, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d4da4f86dfe040c691e0691a76eafffc', '错误', '脚本语言只有JavaScript', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d542e33557e044b7950252fdeea569cb', 'dc8c9a3944b44ca9804b18bd02ff6800', '犯规得分和党和国家', 8, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d64e10d4d1ae491789ccaa5319bb3556', '正确', '结果映射就是select语句查询结果与实体对象的映射关系', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d67f19938a304d349ad686e99ed3321d', '正确', '1111111111111111111111111111111111111', 11, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d6dff777afc54d0588f8c598261d03bf', '关系数据模型', '采用二维表格表达实体类型及实体间联系的数据模型是____?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d7201662f60e4d30be54007a142b4105', 'nextAll()', '$(\'prev～div\')选择器与________方法是等价的？', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d7afc6527e47487bbfcc690b0a4cde85', '踩踩踩踩踩踩踩踩踩踩踩踩踩踩踩踩踩', '草草草草草草草草草草', 11, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d8d235aa4a71410993b603ddcacd7cb4', '@RequestMapping、@RequestBody、@ResponseBody', 'SpringMVC常用注解：_______、_______、________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('d940f654fd994e019c4eb6b79dd3dd3c', '正确', 'MyBatis的<if>元素可以有效地解决用字符串拼接SQL语句做法的多种缺点 ', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('da1f8aaac8db4b0f963cebedaf5ead91', '804492056faf4ff586ab3df6a686b773,3c7a64c423ee4a4a8769cfe33951ebcc', 's', 294, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('db60e6f84c9d482f90bcfc2450310ed5', '40fcbe812f20488d82e7206e12ac7874,472ebce46709488a834a35d824cb981f,e8d6bfafbd0642bca53518067e62b867', '99999999999', 11, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('dc8a5fe1553c4a1c83209dc7a5121982', 'c8304b8f827e436b862c1ae9c41f6396,85201f2d41504ee6b8c6773feadcd5d0,817ef101f79947da89030458ec264285', '555555', 5, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('de4ae93ca27743f6a1c9d5b40aa8e740', '9aa335f54fba4e2fbf40e281c5844f40', 'Spring通知不包括？', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('dee05e97379041318f89566e765a7e68', '单例模式、模板方式模式、前端控制器模式、试图帮助、依赖注入、工厂模式', 'Spring中的设计模式;_________________________?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('dee9923bda68468bb566b245017e2d9e', 'cccccccccccc,ddddddddddd', '33333333333_____________', 12, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('dfa6b4880aa54876b900878be19b8d08', '84c219f051214963858179f8c1737752', '在SSH整合中，加载Spring配置文件的组件是?', 11, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e01365142c8044c083c23afaca804fbb', 'north、center', '插件panel中属性region的可取值包括？', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e0ed24fda2a9475fa6821fd22cc9dbc4', '8bb12f88d8e341fe8cf0267ac4f54efe', 'ccccccccc', 12, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e172ca9e88544e6e9d448f466717e946', 'b978b082b407431aabae63824d302cbf,286e517a48f44a14a6061363dab1f990', '12', 6, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e1849cdab99e410ab24da722d9606439', '逆向代码、动态生成类框架、与注解相结合的框架、单纯的反射机制应用框架', '反射机制一般应用在_________场景?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e40f5640a77e4176b6e9bf229e9a77ac', '基于浏览器的瘦客户端应用程序、基于浏览器的穷客户端应用程序', '当前的应用程序开发逐步的呈现了两种迥乎不同的倾向，一种是( ),另一种是( )?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e4421ca9beb641189801f5586159d558', 'fgfg', 'gfgfgfg', 12, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e48b92b773c740abbc8e21b6277873fc', '正确', 'javaScript当中的注释是//和/* */', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e4ca331b2dc546c58d754c820a5d68c9', '程序计算器', 'JVM内存里______区域不可能发生OutOfMerncyError?', 11, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e4f09fbaf87f4ea787effa2081f13dc1', '正确', '动态SQL，更新数据的时候，根据数据是否存在，动态生成set子句也是动态SQL的一种运用', 11, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e51c31a6c0cd4f42882b4c9831eb549a', '实体、属性、关系、映射基数', '在数据库的设计中：E-R图模型主要包括哪些？', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e557780a10e74ca1afa0e1a572734f8e', '错误', '在MVC设计模式中，其中模型（Model）是由Servlet来充当', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e6ce00f072f546379d3bbbfb4f77e313', '错误', 'reset：true重置表单数据', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e872a778365140ce8b10412527a06fee', '正确', '整合Struts2和MyBatis需要注意添加mybatis-config.xml配置文件', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('e8b82b7069cc4ebfaa057273a7ba590d', '正确', 'ccccccccccc', 5, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ea7be74ffb5d4d4a9122d1b9b4d1e126', '错误', 'Oracle提供了列值自动增长列机制', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ea9207f8fb7841369f5a054ca129a994', '正确', '顶顶顶顶顶', 6, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('eb04b15bb7904ca781b15f2d30c87d34', '错误', '弟弟的', 6, '判断题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('eb70da915249421dad2ba2b1abe6005f', '错误', '使用response对象进行页面重定向，使用的方法是forward', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ec2316054ceb4102a28c69a68af152ee', '正确', '上传文件时，页面需要进行设置form表单的提交方式设置为post', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ec29a46a156b45beadbd8b01ad9cb2f4', 'd4aac93eaf5d4aeab6bd5b53bd326d4c', '1111111111111', 12, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ec3e8e9250ad41559111e2db4f52732c', '错误', '插件panel中属性region的可取值包括left', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ecfe09066a074888ba3b8d40f703013c', 'data section、file fd', '同一个进程下的线程可以共享_______?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('edbc881252824f208cec617615ae52a0', '.mdf、.ldf', 'SqlServer数据库包含____和____后缀名的文件?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ee76ce4cf02b49aaaf7ff120ac252f02', '工厂模式、抽象工厂模式、单例模式、原型模式、建造者模式', '分别写出五种创建模式有哪些_______________________?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f0c29ed5fb3748288264cab5239af39c', '会话缓存、页面缓存、队列、排行榜、发布', 'Redis最适合的场景有___________________?', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f0e25774d67a4106886e1d115124b24f', 'bbbbbbbbb', 'aaaaaaa', 1, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f13dfb4f72874182bd884be97da7868b', '2a7e6e9b55b541da994dc95c154be714', '121', 11, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f1619210ac584b0cabf8f8ca904864ab', 'wait、sleep、yield', '_______方法可以使线程从运行状态进入到阻塞状态？', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f1f2e8faef9e4a4aa6da12b77c37217d', '205fa3edfa38407a9eeac3687a5eecc8', '哈哈哈', 5, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f268f977d3054f0f9f4bb8a5a5dc7ebc', '4048d4e498554bc28b6cd525749d96ec', '撒旦撒旦 ', 1, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f2bcd9114d3c45519c13b44c7e1f0d56', '错误', '<set>解决了字符串拼接SQL语句做法的诸多问题', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f3358b40eb7245aeaead58dbfc2e5963', '错误', 'foreach属性描述中separator:表示以什么结束', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f37c48f157a1484cb194a5fa97e7f34d', '正确', '布局可以进行嵌套，用户可以通过组合布局构建复杂的布局结构', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f3fd5e0050b94a12bdc24e6bc2c71e47', '对象', '什么是实体？', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f68b2133215947c0b80e33e4e94af782', '2e196ba9e1e44d0d951547a90c6abfe5,4953a656b4c64c589d22b0af20de15f3', 'ccccc', 11, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f68cfdbb09f64a3cb1b200c1e883eae7', '$(“#dlg”).dialog({closed:true}); ', '关闭dialog的方法的核心代码____？', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f7061a223dd5447c9a8bdd4215e76753', '6d8bcd6337f74c95ae700086f7aa12f1', 'ss', 1, '多选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f7257fa1b19c434a902fe15e1b7f95c0', '啊啊啊', '顶顶顶顶', 6, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f78aeea6544647be97a905ac35174775', '正确', 'Resources是MyBatis的接口或类是', 6, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f9659c72a6c84d208475a2616f194d07', '3d136cdba9294125ba4cd6c968ac1f68', 'dsaff', 5, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f968c8d4bdd240db82f55c2d0cdb061c', 'a9e09dcada8d46c388959e5469e06a91', '11111111111', 6, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('f9dd75197c3a407695ef93b2af2104fc', '834e70da8a0742c5a9d334302c2b5ab6', '使用JdbcTemplate类，删除一条记录使用什么方法？', 6, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fac74766e8894f169f6abcf0f7da0f0e', '全局区', '静态变量通常存储在进程____区？', 6, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fb0962da9c194eb49a5e0a07be776750', '767e050f19934ad2977eb7c01a2218a0', '信息的数据表示形式是？', 6, '单选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fb9d0557b93042d9a4f9f3ea34dd9428', '士大夫', '的萨芬士大夫', 5, '填空题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fc44d3dbf74c415fbb7212c0993f75d8', '错误', 'window控件的属性中collapsible定义事都显示可折叠按钮', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fcd8a57b43db458aa154831e32094b50', 'group by、order by', '_______和_______子句都不支持算数表达式?', 5, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fd6bfa3c7b3842cf89085d3ee97562d0', '正确', 'collection属性是必须指定的', 5, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fd6e3f3027644007aa5b8b3d049860a4', 'd5375b3384a14d8dbb87cd2eeed7db2c', '得瑟得瑟得得得', 11, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fe5da7c3c12e46aa81026715a4d3f847', '正确', 'SqlSessionFactory是MyBatis的接口或类', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('fe6dc14d9b9b404f87d2397941fedb6a', '错误', 'SQL映射语句中必须有输入和输出部分', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ff585cb24a044775aad1ee145f1c6811', 'd896df262b82412a9a924413449e914a', 'sdaf', 11, '单选题', NULL, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');
INSERT INTO `rubric_tb` VALUES ('ffd9880837224d1cbf358468d6a87b93', '正确', 'PerpetualCache：一级缓存、二级缓存', 1, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229');

-- ----------------------------
-- Table structure for sectionexamanswer_tb
-- ----------------------------
DROP TABLE IF EXISTS `sectionexamanswer_tb`;
CREATE TABLE `sectionexamanswer_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `optiones` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sectionexamanswer_sectionexamrubric_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK6v9w070gttgmnsd5hatbujq4m`(`sectionexamanswer_sectionexamrubric_id`) USING BTREE,
  CONSTRAINT `FK6v9w070gttgmnsd5hatbujq4m` FOREIGN KEY (`sectionexamanswer_sectionexamrubric_id`) REFERENCES `sectionexamrubric_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sectionexamanswer_tb
-- ----------------------------
INSERT INTO `sectionexamanswer_tb` VALUES ('01b1a987eb2148ce958a0104293c5186', '22', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('07377448a4354fad94499b06d9289dd2', 'sdf 撒旦的撒', 'B', '4ae800075640401dae5aaf95e9dd9dac');
INSERT INTO `sectionexamanswer_tb` VALUES ('073a2ebfb3184d6a8f762a3a5c0b246b', 'rr', 'B', '967cbb8adbad474289d70f8890f0deba');
INSERT INTO `sectionexamanswer_tb` VALUES ('084dfbeeeb7e4af0ac65e5f3092593ab', '的', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('0a0d45727e364b69a482fe3be025ab54', ' 的d', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('0ba17125ea8e45bfb52d217914fc3b63', '顶顶顶顶顶顶顶顶顶顶顶', 'C', '75ff8453a2614ffd8d90b36cff8a4092');
INSERT INTO `sectionexamanswer_tb` VALUES ('11066efee904439c9145df5d32323c76', ' 的d', 'C', '4ae800075640401dae5aaf95e9dd9dac');
INSERT INTO `sectionexamanswer_tb` VALUES ('11e0342e200b4ba691b31435071f694b', 'r', 'D', '7995dfbb59224285837cf51657c693e1');
INSERT INTO `sectionexamanswer_tb` VALUES ('12f6b06fb439452bad46f3adddb1a72b', '的', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('1417f62929404352b3cee5cf84f7264f', 'sdf 撒旦的撒', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('14fd07f2bf734f2bb1419f47a6f61231', '顶顶顶顶顶顶顶顶顶顶顶', 'C', '15d0adf76e47472991e2466c57f8f6c3');
INSERT INTO `sectionexamanswer_tb` VALUES ('188cfc838487457c9626ba681c94d26a', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', '15d0adf76e47472991e2466c57f8f6c3');
INSERT INTO `sectionexamanswer_tb` VALUES ('19ad4f534bbf4450b078e68dcfb21e8a', 'sdf 撒旦的撒', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('1c5083164fa74f93b78b8c16f6777493', 'r', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('1cff9d49f0cb4c91a7a812e659d84f7b', 's\'d\'f', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('205609b979d1430fb4b561a6ed7655cc', 's\'d\'f', 'A', '6973f25f33714aa3bbb404d7440810af');
INSERT INTO `sectionexamanswer_tb` VALUES ('26558d1b55bb44fdacdf9275b5c8190c', '撒打发士大夫', 'A', '94f4076d609f41f283fc07d5393035d8');
INSERT INTO `sectionexamanswer_tb` VALUES ('273ba48186d0400f99fb010420e85a00', 'rrrr', 'A', '7995dfbb59224285837cf51657c693e1');
INSERT INTO `sectionexamanswer_tb` VALUES ('2b6fa92a9d7145438ea09b27526d8e01', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', '75ff8453a2614ffd8d90b36cff8a4092');
INSERT INTO `sectionexamanswer_tb` VALUES ('2e6664669d5a4f97b629d171a41e6409', 'sdf 撒旦的撒', 'B', '7f0f1a63832b48b980b1973de6ebe68b');
INSERT INTO `sectionexamanswer_tb` VALUES ('309fef81e03941afaf98994ef1950f0c', 'r', 'D', '53c6f771400e43809bd566137d023a39');
INSERT INTO `sectionexamanswer_tb` VALUES ('3144388ea4b94332ae465b0d5c93fad3', 'sdf 撒旦的撒', 'B', '6973f25f33714aa3bbb404d7440810af');
INSERT INTO `sectionexamanswer_tb` VALUES ('3845c6f7ad3048be8b2c22915b93d0df', '顶顶顶顶顶顶顶顶顶顶', 'D', '75ff8453a2614ffd8d90b36cff8a4092');
INSERT INTO `sectionexamanswer_tb` VALUES ('3ad00ca4a170438a8340bed78f261b11', '22', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('3b0049eeb3ae4cfd94572e9075f1321b', '的', 'D', '6973f25f33714aa3bbb404d7440810af');
INSERT INTO `sectionexamanswer_tb` VALUES ('3c70cea4e014421eb6a39c436ecee143', '顶顶顶顶顶顶顶顶顶顶', 'D', '22680936ff5c4cef8282bcf0a8c7dfbd');
INSERT INTO `sectionexamanswer_tb` VALUES ('3d9dbcbe3ba840ff9ea631c2e18bc70d', 'r', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('408461ca5fcb482eb2a57e8708d2fa36', 'rr', 'B', '53c6f771400e43809bd566137d023a39');
INSERT INTO `sectionexamanswer_tb` VALUES ('417f5636cf6f4ec798f3c32f1af7ca87', 'r', 'C', '7995dfbb59224285837cf51657c693e1');
INSERT INTO `sectionexamanswer_tb` VALUES ('4180319566c8468a9c85d7b9846b32d3', '11', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('436b62decdf9438ebd7c79da50d8bd1f', 'r', 'C', '53c6f771400e43809bd566137d023a39');
INSERT INTO `sectionexamanswer_tb` VALUES ('43a690514b15430396d31de8d66ea6f5', 'r', 'D', '967cbb8adbad474289d70f8890f0deba');
INSERT INTO `sectionexamanswer_tb` VALUES ('43b2329082554fb6afd4e7559da1758e', 's\'d\'f', 'A', '7f0f1a63832b48b980b1973de6ebe68b');
INSERT INTO `sectionexamanswer_tb` VALUES ('46db7e99efca4c379b190d3b69245187', ' 的d', 'C', '7f0f1a63832b48b980b1973de6ebe68b');
INSERT INTO `sectionexamanswer_tb` VALUES ('47df179449524076a0334af4438cf7c1', 'rrrr', 'A', '53c6f771400e43809bd566137d023a39');
INSERT INTO `sectionexamanswer_tb` VALUES ('49954b82a3d049d3b96cc56e98361261', 's\'d\'f', 'A', '6fca3b47ddae47c7845e6095cadd94f0');
INSERT INTO `sectionexamanswer_tb` VALUES ('4f94c2444f594e55a9abd165a3cb1836', ' 的d', 'C', '65f15fde988442438d73f921ebab305f');
INSERT INTO `sectionexamanswer_tb` VALUES ('522f7011657143039625b8e748754756', 's\'d\'f', 'A', '47630940b591448bb2ab913280f22798');
INSERT INTO `sectionexamanswer_tb` VALUES ('53da58755a7e4c6781d2c10295d0e24d', '顶顶顶顶顶顶顶顶顶顶', 'D', 'f979163b9daa40c295b7f270b9d014ae');
INSERT INTO `sectionexamanswer_tb` VALUES ('555172acd19447f4869c01487b19ce60', '顶顶顶顶顶顶顶顶顶顶顶', 'C', '22680936ff5c4cef8282bcf0a8c7dfbd');
INSERT INTO `sectionexamanswer_tb` VALUES ('590faa2d5bb54431a167019e62e29005', '顶顶顶顶顶顶顶顶顶顶顶', 'A', '15d0adf76e47472991e2466c57f8f6c3');
INSERT INTO `sectionexamanswer_tb` VALUES ('5c76d8510e6248c0be423878c594f16a', 's\'d\'f', 'A', '4ae800075640401dae5aaf95e9dd9dac');
INSERT INTO `sectionexamanswer_tb` VALUES ('61df9ac1569d4046b64b3b839aba9fd0', '顶顶顶顶顶顶顶顶顶顶顶', 'C', 'f979163b9daa40c295b7f270b9d014ae');
INSERT INTO `sectionexamanswer_tb` VALUES ('663764a620d7420d977031e6057b12da', ' 的d', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('6737fa83fb6e4c39968339efec30bde2', 'sdf 撒旦的撒', 'B', '65f15fde988442438d73f921ebab305f');
INSERT INTO `sectionexamanswer_tb` VALUES ('67fcc35697854b19b31cee258852c5e0', '士大夫撒', 'D', '94f4076d609f41f283fc07d5393035d8');
INSERT INTO `sectionexamanswer_tb` VALUES ('684d514245704e1094dd70a4eb12530b', 'sdf 撒旦的撒', 'B', '6fca3b47ddae47c7845e6095cadd94f0');
INSERT INTO `sectionexamanswer_tb` VALUES ('6a7027b59c854f62b5a14769b869ed24', 'sdf 撒旦的撒', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('6c14687575a240f2871f7129db9269d2', ' 的d', 'C', 'f702d598b8fc4096a66adff8c807567e');
INSERT INTO `sectionexamanswer_tb` VALUES ('6f9bd8660715461aad8c683322780587', 'rrrr', 'A', 'b37f2d4dbab042e2a4ba1d3d29690c8e');
INSERT INTO `sectionexamanswer_tb` VALUES ('70b9d738519a4199b6e86834d31432ea', '的', 'D', '6fca3b47ddae47c7845e6095cadd94f0');
INSERT INTO `sectionexamanswer_tb` VALUES ('7d8bd60241ad48d288ebfe31b26adf99', '的', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('80f771b11117423daffa9a598d0d974a', 'rr', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('87ab3e41f4a640feab79d75f0d00945d', 'rrrr', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('886c2e88b6a4420489f1786ea52050f6', 'r', 'C', 'b37f2d4dbab042e2a4ba1d3d29690c8e');
INSERT INTO `sectionexamanswer_tb` VALUES ('9340bd015f84439a99ba22c877c22695', 'r', 'C', '967cbb8adbad474289d70f8890f0deba');
INSERT INTO `sectionexamanswer_tb` VALUES ('9482237bf3744292b25068142316cddf', 'rr', 'B', 'b37f2d4dbab042e2a4ba1d3d29690c8e');
INSERT INTO `sectionexamanswer_tb` VALUES ('953259d935804090a6f54ba575c75991', 'r', 'D', 'b37f2d4dbab042e2a4ba1d3d29690c8e');
INSERT INTO `sectionexamanswer_tb` VALUES ('959a8fa3b4ab4251963537bf01dfe1f8', '11', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('95f5ac0ca7c34b298fa4706f9eb8c9f0', 'rr', 'B', '7995dfbb59224285837cf51657c693e1');
INSERT INTO `sectionexamanswer_tb` VALUES ('99fe11ac9cd742dc82f6caa681078471', '的', 'D', '4ae800075640401dae5aaf95e9dd9dac');
INSERT INTO `sectionexamanswer_tb` VALUES ('9abea82cb0634a1ba00bb523d3030b06', 's\'d\'f', 'A', '65f15fde988442438d73f921ebab305f');
INSERT INTO `sectionexamanswer_tb` VALUES ('9daaa39e261f4335a515a7d1e476ddb1', 's\'d\'f', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('a1b2d4ad7b6b4ddb8f955d9f34f817d5', 's\'d\'f', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('a2133806b798403fad9084b50aec1059', 'r', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('a3ab9e2d210545d598154e49c1225bdc', '11', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('acc678082d814c77b953a39ef70e6805', 'r', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('ae75472407264e86b555f60b514edf41', 'sdf 撒旦的撒', 'B', '0ed4e2b9ab0a464ca15493bcddd7ca9c');
INSERT INTO `sectionexamanswer_tb` VALUES ('b5ea975443124874a6cbdb808bec7004', '的', 'D', '47630940b591448bb2ab913280f22798');
INSERT INTO `sectionexamanswer_tb` VALUES ('b63eadaa3ecd4f26bc9fb0270344bb8a', 'sdf 撒旦的撒', 'B', '47630940b591448bb2ab913280f22798');
INSERT INTO `sectionexamanswer_tb` VALUES ('ba70554864e24d6099ca482e9d5174b5', 'sdf 撒旦的撒', 'B', 'f702d598b8fc4096a66adff8c807567e');
INSERT INTO `sectionexamanswer_tb` VALUES ('bb54c870b1ea4e5e90a043c9d6d3ec76', 's\'d\'f', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('bb84c328f9e043acbe250146a5c88476', '的', 'D', 'f702d598b8fc4096a66adff8c807567e');
INSERT INTO `sectionexamanswer_tb` VALUES ('bc2786f5fb444560add31971a99f6d56', 's\'d\'f', 'A', 'f702d598b8fc4096a66adff8c807567e');
INSERT INTO `sectionexamanswer_tb` VALUES ('c8a82efbf08f4256b650783e7cf9e744', ' 的d', 'C', '0ed4e2b9ab0a464ca15493bcddd7ca9c');
INSERT INTO `sectionexamanswer_tb` VALUES ('cacd186403a541caa4dc26f6a52defc6', '的', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('cdb0eac710794474b9b0cd90c3b549b6', '222', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('d25f66e473c44c14a8d7535117745a4e', ' 的d', 'C', '6973f25f33714aa3bbb404d7440810af');
INSERT INTO `sectionexamanswer_tb` VALUES ('d57a1012d8e343408f05a49774af2f5d', '士大夫士大夫', 'B', '94f4076d609f41f283fc07d5393035d8');
INSERT INTO `sectionexamanswer_tb` VALUES ('d5ef6e0e408a410383403236fb09b0c3', 'rr', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('d62109c8a2604e6db21b6e3df8e88fe7', '撒旦发射点', 'C', '94f4076d609f41f283fc07d5393035d8');
INSERT INTO `sectionexamanswer_tb` VALUES ('d8dc2925c913479183bcc4b4a615447e', 's\'d\'f', 'A', '0ed4e2b9ab0a464ca15493bcddd7ca9c');
INSERT INTO `sectionexamanswer_tb` VALUES ('ddb24d7c885c42d5b96dfb05e027ab9c', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', 'f979163b9daa40c295b7f270b9d014ae');
INSERT INTO `sectionexamanswer_tb` VALUES ('e27de879ab2e4badbf11a2ac3e505537', 'rrrr', 'A', '967cbb8adbad474289d70f8890f0deba');
INSERT INTO `sectionexamanswer_tb` VALUES ('e326e86dd62e4c859c30862fbc6ddc76', '22', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('e69479fbb5264a22a133cfcea0547de5', '的', 'D', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('ea219dbc240040838f51c0af18aef632', 's\'d\'f', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('eba46e20188b48bda30925851b481bd1', 'rrrr', 'A', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('ecad4daf03784253aab83602e63cb5e7', ' 的d', 'C', '47630940b591448bb2ab913280f22798');
INSERT INTO `sectionexamanswer_tb` VALUES ('ed2ad2727e0c4f0e8b60a011cff0bf81', ' 的d', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('ed3384a9d1dd4ac49d9f034210b82f72', '的', 'D', '7f0f1a63832b48b980b1973de6ebe68b');
INSERT INTO `sectionexamanswer_tb` VALUES ('f0e30f54cef44a7fa3eb52b354f58bd4', '11', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('f12cf0ae18ab42e3ae04a6f6746dfcc7', ' 的d', 'C', '6fca3b47ddae47c7845e6095cadd94f0');
INSERT INTO `sectionexamanswer_tb` VALUES ('f28eabcf03e14eb3a7f55a6e08fa7c53', 'sdf 撒旦的撒', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('f31e5d11a7d64d62a7318a941a8a8310', ' 的d', 'C', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('f4f85d167c4c450c883ecf4faea60416', '顶顶顶顶顶顶顶顶顶顶', 'D', '15d0adf76e47472991e2466c57f8f6c3');
INSERT INTO `sectionexamanswer_tb` VALUES ('f56a55940a534c19aa8ab6fddc580ac9', '顶顶顶顶顶顶顶顶顶顶顶', 'A', '75ff8453a2614ffd8d90b36cff8a4092');
INSERT INTO `sectionexamanswer_tb` VALUES ('f804bf9e125341bc9767d17a0baba8c7', 'sdf 撒旦的撒', 'B', NULL);
INSERT INTO `sectionexamanswer_tb` VALUES ('faf3d5a4668745f7840c5f373400bfb0', '顶顶顶顶顶顶顶顶顶顶顶', 'A', '22680936ff5c4cef8282bcf0a8c7dfbd');
INSERT INTO `sectionexamanswer_tb` VALUES ('fb06f4fb97da475fb6d1a29b4f3acd96', '的', 'D', '65f15fde988442438d73f921ebab305f');
INSERT INTO `sectionexamanswer_tb` VALUES ('fb7835c1bcb848429c250ec2d6866684', '的', 'D', '0ed4e2b9ab0a464ca15493bcddd7ca9c');
INSERT INTO `sectionexamanswer_tb` VALUES ('fc1c42b2338f4765be9632aa6b4d6c80', '顶顶顶顶顶顶顶顶顶顶地对地导弹弟弟的', 'B', '22680936ff5c4cef8282bcf0a8c7dfbd');
INSERT INTO `sectionexamanswer_tb` VALUES ('fda62db2b97d426babaeacc8e279308d', '顶顶顶顶顶顶顶顶顶顶顶', 'A', 'f979163b9daa40c295b7f270b9d014ae');
INSERT INTO `sectionexamanswer_tb` VALUES ('feee9a88fcc140d1a70e06229f0fd853', ' 的d', 'C', NULL);

-- ----------------------------
-- Table structure for sectionexamlog_tb
-- ----------------------------
DROP TABLE IF EXISTS `sectionexamlog_tb`;
CREATE TABLE `sectionexamlog_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  `performance` int(50) NOT NULL,
  `sectionexamparper_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sectionexamrubric_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `section_id` int(11) NOT NULL,
  `select_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sectionexamlog_tb
-- ----------------------------
INSERT INTO `sectionexamlog_tb` VALUES ('0e2496d093194528937a14223d431413', 6, 0, 'd3965f90353148cdaa3abb6079b74a67', '22680936ff5c4cef8282bcf0a8c7dfbd', 32, 'faf3d5a4668745f7840c5f373400bfb0,555172acd19447f4869c01487b19ce60', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `sectionexamlog_tb` VALUES ('20975b26d3c54d4cbdd0aa19dadab825', 6, 0, 'd3965f90353148cdaa3abb6079b74a67', '967cbb8adbad474289d70f8890f0deba', 32, '9340bd015f84439a99ba22c877c22695', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `sectionexamlog_tb` VALUES ('222c0ca75af34a06af73799f648dee35', 6, 0, 'd3965f90353148cdaa3abb6079b74a67', '967cbb8adbad474289d70f8890f0deba', 32, '073a2ebfb3184d6a8f762a3a5c0b246b', '27a1026f-be4d-4651-9245-578e31d1728a');
INSERT INTO `sectionexamlog_tb` VALUES ('857a1c4377324002959dfe043fc2fe07', 6, 0, 'd3965f90353148cdaa3abb6079b74a67', '22680936ff5c4cef8282bcf0a8c7dfbd', 32, 'faf3d5a4668745f7840c5f373400bfb0', '27a1026f-be4d-4651-9245-578e31d1728a');

-- ----------------------------
-- Table structure for sectionexamparper_tb
-- ----------------------------
DROP TABLE IF EXISTS `sectionexamparper_tb`;
CREATE TABLE `sectionexamparper_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `section_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sectionexamparper_tb
-- ----------------------------
INSERT INTO `sectionexamparper_tb` VALUES ('00492897cc8149a9b3fa5da31048ea1f', '15', '35', '2019-01-01 16:29:40', 'sad', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('0a5f5222c0594388955188a580852de7', '1', '10', '2019-01-02 12:29:06', 'hh', 21);
INSERT INTO `sectionexamparper_tb` VALUES ('102b2598b7b74dd8bec72a6d278c6f0b', '15', '36', '2018-12-31 18:11:20', '订单', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('1a207bfb3a044e799e3210fe7ac1e878', '2', '25', '2019-01-02 10:39:52', 'xx', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('238be320d87e419bb52b5b475652c9c2', '1', '12', '2019-01-02 12:26:21', 'dsdf', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('27eb5980adc84a50aa247eb5eab479af', '2', '25', '2019-01-02 08:52:29', 'popopopo', 7);
INSERT INTO `sectionexamparper_tb` VALUES ('2830d4f3783840bc8cbbdb0400ad2820', '15', '36', '2019-01-01 16:37:27', 's', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('306399a36bd34b20a26f2f4227991e6f', '1', '10', '2019-01-02 09:43:03', '1', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('346c1695d2f14bdf811f0a9fc6727f34', '6', '76', '2019-01-07 09:32:40', '第二章测试', 15);
INSERT INTO `sectionexamparper_tb` VALUES ('3857d79247bb419a99951574aaed7bda', '2', '25', '2019-01-01 17:50:27', 'ddddd', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('3c894727d97b4dba9cb8644514538795', '16', '42', '2018-12-30 11:40:39', 'dd', 0);
INSERT INTO `sectionexamparper_tb` VALUES ('4123a607d4d944aa934d1b4a65258696', '16', '42', '2018-12-30 21:47:26', 'iii', 0);
INSERT INTO `sectionexamparper_tb` VALUES ('45531b5791b34a6286d6e5c98f93678e', '15', '36', '2018-12-30 11:48:28', 'dddddd', 0);
INSERT INTO `sectionexamparper_tb` VALUES ('4eda6b9f623841fe92b86a984fff1111', '15', '36', '2019-01-01 16:34:06', 's', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('52ac8b87d7d64cee9942cec2fe1186e6', '15', '35', '2018-12-31 17:43:37', 'yyyyyyyy', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('573f3df2ca374f37b7c4097db3a15808', '16', '41', '2019-01-01 16:06:35', 'yyyyyyy', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('64674fc3b5df4622990922fd68cbf0a4', '2', '25', '2019-01-02 09:16:45', 'ddd', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('6896ea3d3a674422bb09b950826d2b8a', '2', '25', '2019-01-02 08:55:28', '她她她', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('6c33a488597847119b494a01f64c6b83', '6', '32', '2019-01-07 15:51:58', '品很', 12);
INSERT INTO `sectionexamparper_tb` VALUES ('70613f1f5ddd4f078fe85615d9a79664', '6', '32', '2019-01-02 09:19:27', '哈哈哈', 6);
INSERT INTO `sectionexamparper_tb` VALUES ('78dcc459ed3a48cc93504683d606e0fe', '1', '35', '2019-01-07 09:31:38', '', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('866111b239ee463b8f05bb2e0a26ee26', '16', '42', '2019-01-01 15:58:02', 'oooo', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('8cf35325b96d4060a25bba589f0a7d07', '2', '25', '2019-01-02 08:54:10', '哈哈哈哈', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('a17aa4da3fe843dc9ce5543ea0d049dc', '2', '25', '2019-01-02 08:54:48', '呃呃呃呃呃', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('a6268a81f88042f09382c41adb5f2e71', '6', '32', '2019-01-07 15:53:13', '品很666', 3);
INSERT INTO `sectionexamparper_tb` VALUES ('a934625e9b934e3cb8267d7f0c2ef50a', '15', '37', '2018-12-30 11:34:54', 'ddd', 0);
INSERT INTO `sectionexamparper_tb` VALUES ('aefd0338d9844a9d98e7513d2b6f1c77', '2', '25', '2019-01-02 09:16:12', 'kk', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('c124d3344f714de0a69d2e897a276c3c', '2', '25', '2019-01-02 08:57:19', '呃呃呃', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('cf79bcfbf56e4590aaa68a67fe4032bb', '2', '25', '2019-01-02 08:44:32', 'gggggggggggggggggggg', 3);
INSERT INTO `sectionexamparper_tb` VALUES ('d3589d9cd8904908b494de184397bdad', '1', '10', '2019-01-01 17:52:23', '1', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('d35c8e0fbfe6486789895dfe34eb12e5', '2', '25', '2019-01-02 10:53:36', 'dsahah', 4);
INSERT INTO `sectionexamparper_tb` VALUES ('d3965f90353148cdaa3abb6079b74a67', '6', '32', '2019-01-06 21:39:16', '测试2', 50);
INSERT INTO `sectionexamparper_tb` VALUES ('d418ff4abaca4969829d13495428fbbe', '15', '36', '2019-01-01 16:36:44', 'k', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('d5376cb1089e49f08f715d671cb5da14', '2', '23', '2019-01-01 18:00:51', '订单', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('d619f05964ec4fa9b59346fbede0c7aa', '15', '36', '2019-01-01 16:32:54', 's', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('d7c7b38ba36e445c81e81074b6a6b6e9', '2', '25', '2019-01-01 17:51:43', '涛涛涛涛', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('ddc074de00464858a73060690a7f1951', '1', '10', '2019-01-02 09:38:03', 'm', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('e506050f3ab84874a03d90a63908dea2', '15', '35', '2018-12-30 11:38:31', 'dd', 0);
INSERT INTO `sectionexamparper_tb` VALUES ('ebc0a3e7c7c4444499cdc9e7d078256b', '6', '32', '2019-01-06 23:27:39', '顶顶顶顶顶顶顶顶', 100);
INSERT INTO `sectionexamparper_tb` VALUES ('f42f83e80c7a4a8b8ff8abda899c247b', '1', '10', '2019-01-02 09:42:32', ',', NULL);
INSERT INTO `sectionexamparper_tb` VALUES ('f624e91cb0694095be83387392627f5d', '15', '35', '2018-12-31 18:06:02', '哈哈哈哈哈哈哈', NULL);

-- ----------------------------
-- Table structure for sectionexamrubric_tb
-- ----------------------------
DROP TABLE IF EXISTS `sectionexamrubric_tb`;
CREATE TABLE `sectionexamrubric_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(50) NULL DEFAULT NULL,
  `rubricttype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(11) NOT NULL,
  `section_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trcher_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sectionexamrubric_sectionexamparper_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK9kk01njqqctqnawc7efrb6anv`(`sectionexamrubric_sectionexamparper_id`) USING BTREE,
  CONSTRAINT `FK9kk01njqqctqnawc7efrb6anv` FOREIGN KEY (`sectionexamrubric_sectionexamparper_id`) REFERENCES `sectionexamparper_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sectionexamrubric_tb
-- ----------------------------
INSERT INTO `sectionexamrubric_tb` VALUES ('036587429c8d456ea121e6794545ee0c', 'rownum', 'Oracle的分页语句关键字为：_____?', 15, '填空题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('0512768c6fd04653b9d6752c77df3689', 'asd', 'sad', 15, '填空题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('09de4744a7d44b2896c3f7307fa6ea5a', 'D B ', '发士大夫', 16, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('0ed4e2b9ab0a464ca15493bcddd7ca9c', 'ae75472407264e86b555f60b514edf41,fb7835c1bcb848429c250ec2d6866684', '发士大夫', 1, '多选题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '0a5f5222c0594388955188a580852de7');
INSERT INTO `sectionexamrubric_tb` VALUES ('0f975f4d5ab44368a44e37463ab16d4f', '01b1a987eb2148ce958a0104293c5186,e326e86dd62e4c859c30862fbc6ddc76', '22', 16, '多选题', 2, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('104c981efde64a0ba7678e93caef0b2b', '错误', 'yyyy', 16, '判断题', 5, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '866111b239ee463b8f05bb2e0a26ee26');
INSERT INTO `sectionexamrubric_tb` VALUES ('15d0adf76e47472991e2466c57f8f6c3', '14fd07f2bf734f2bb1419f47a6f61231,f4f85d167c4c450c883ecf4faea60416', '顶顶顶顶顶顶顶顶顶顶顶', 6, '多选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '346c1695d2f14bdf811f0a9fc6727f34');
INSERT INTO `sectionexamrubric_tb` VALUES ('22680936ff5c4cef8282bcf0a8c7dfbd', '555172acd19447f4869c01487b19ce60,3c70cea4e014421eb6a39c436ecee143', '顶顶顶顶顶顶顶顶顶顶顶', 6, '多选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd3965f90353148cdaa3abb6079b74a67');
INSERT INTO `sectionexamrubric_tb` VALUES ('3411a5b27a064f7ebf28f279c2338ff5', 'A', 'rrrrrrrrr', 15, '单选题', 2, '36', '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('35816dd6a67c48ed88b4b61bfc73652a', 'asd', 'sad', 6, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'ebc0a3e7c7c4444499cdc9e7d078256b');
INSERT INTO `sectionexamrubric_tb` VALUES ('36cac698704744d2ae60c788b3b3ed42', '正确', 'asdd', 16, '判断题', 1, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('376e46e2fb154c0bb07f12fdaf0c3464', '19ad4f534bbf4450b078e68dcfb21e8a,12f6b06fb439452bad46f3adddb1a72b', '发士大夫', 16, '多选题', 1, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('3e7292d4e916484fbddf581d1c7285ab', 'rownum', 'Oracle的分页语句关键字为：_____?', 16, '填空题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4123a607d4d944aa934d1b4a65258696');
INSERT INTO `sectionexamrubric_tb` VALUES ('47630940b591448bb2ab913280f22798', 'b63eadaa3ecd4f26bc9fb0270344bb8a,b5ea975443124874a6cbdb808bec7004', '发士大夫', 16, '多选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4123a607d4d944aa934d1b4a65258696');
INSERT INTO `sectionexamrubric_tb` VALUES ('4ae800075640401dae5aaf95e9dd9dac', '07377448a4354fad94499b06d9289dd2,99fe11ac9cd742dc82f6caa681078471', '发士大夫', 15, '多选题', 2, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('537c3d868fe04f398c2d850502f321cf', 'asd', 'sad', 16, '填空题', 2, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('53c6f771400e43809bd566137d023a39', '47df179449524076a0334af4438cf7c1', 'rrrrrrrrr', 1, '单选题', 4, '10', '92dd88b1-9157-46de-bfee-51c6b1d17229', '0a5f5222c0594388955188a580852de7');
INSERT INTO `sectionexamrubric_tb` VALUES ('6153c7e31503437c8b35b6075123fbec', 'rownum', 'Oracle的分页语句关键字为：_____?', 6, '填空题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'ebc0a3e7c7c4444499cdc9e7d078256b');
INSERT INTO `sectionexamrubric_tb` VALUES ('65f15fde988442438d73f921ebab305f', '6737fa83fb6e4c39968339efec30bde2,fb06f4fb97da475fb6d1a29b4f3acd96', '发士大夫', 6, '多选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '70613f1f5ddd4f078fe85615d9a79664');
INSERT INTO `sectionexamrubric_tb` VALUES ('6973f25f33714aa3bbb404d7440810af', '3144388ea4b94332ae465b0d5c93fad3,3b0049eeb3ae4cfd94572e9075f1321b', '发士大夫', 2, '多选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd35c8e0fbfe6486789895dfe34eb12e5');
INSERT INTO `sectionexamrubric_tb` VALUES ('69c1e4e12b4646a2a375a1f58ae1315d', 'asd', 'sad', 15, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '52ac8b87d7d64cee9942cec2fe1186e6');
INSERT INTO `sectionexamrubric_tb` VALUES ('6ad8c5431d5d4f5c85acd30ec3ca860d', '从现有的表格(table)元素创建DataGrid、使用表格(table)元素和easyui代码创建', 'DataGrid的创建有两种方式，分别是____?', 15, '填空题', 2, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'e506050f3ab84874a03d90a63908dea2');
INSERT INTO `sectionexamrubric_tb` VALUES ('6fca3b47ddae47c7845e6095cadd94f0', '684d514245704e1094dd70a4eb12530b,70b9d738519a4199b6e86834d31432ea', '发士大夫', 1, '多选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '238be320d87e419bb52b5b475652c9c2');
INSERT INTO `sectionexamrubric_tb` VALUES ('71b5dba108694a4b9c3cbb8993f02d51', '正确', '白敬亭', 6, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '346c1695d2f14bdf811f0a9fc6727f34');
INSERT INTO `sectionexamrubric_tb` VALUES ('75ff8453a2614ffd8d90b36cff8a4092', '0ba17125ea8e45bfb52d217914fc3b63,3845c6f7ad3048be8b2c22915b93d0df', '顶顶顶顶顶顶顶顶顶顶顶', 6, '多选题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'ebc0a3e7c7c4444499cdc9e7d078256b');
INSERT INTO `sectionexamrubric_tb` VALUES ('78a1963b30ed4b4ca0855a48859a8810', 'rownum', 'Oracle的分页语句关键字为：_____?', 2, '填空题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd35c8e0fbfe6486789895dfe34eb12e5');
INSERT INTO `sectionexamrubric_tb` VALUES ('7995dfbb59224285837cf51657c693e1', '273ba48186d0400f99fb010420e85a00', 'rrrrrrrrr', 15, '单选题', 4, '35', '92dd88b1-9157-46de-bfee-51c6b1d17229', '52ac8b87d7d64cee9942cec2fe1186e6');
INSERT INTO `sectionexamrubric_tb` VALUES ('7b9ba7f4a4374bb595291d6d68839e47', '正确', '在HTML页面中，<th>标记可以为表中的一列指定一个标题', 1, '判断题', 9, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '0a5f5222c0594388955188a580852de7');
INSERT INTO `sectionexamrubric_tb` VALUES ('7e45b18a428240d98ac00b6a00cb346c', '', '3333333333', 16, '判断题', 6, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '866111b239ee463b8f05bb2e0a26ee26');
INSERT INTO `sectionexamrubric_tb` VALUES ('7f0f1a63832b48b980b1973de6ebe68b', '2e6664669d5a4f97b629d171a41e6409,ed3384a9d1dd4ac49d9f034210b82f72', '发士大夫', 2, '多选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '27eb5980adc84a50aa247eb5eab479af');
INSERT INTO `sectionexamrubric_tb` VALUES ('84b53669337b47e0b3c9261b30392b25', '正确', '在HTML页面中，<th>标记可以为表中的一列指定一个标题', 16, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('8877b38d166d412084460d814390933c', '错误', 'Mybatis的优点自动化的ORM框架，便于面向对象开发', 16, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '573f3df2ca374f37b7c4097db3a15808');
INSERT INTO `sectionexamrubric_tb` VALUES ('8c6710f69ed5481b80bf1ec5a49dd2a2', 'asd', 'sad', 6, '填空题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6c33a488597847119b494a01f64c6b83');
INSERT INTO `sectionexamrubric_tb` VALUES ('8cddf9b0c40d4b73bc6339d7d5e691d5', '预编译语句、mpper方式中的#vvvvvvvv', '防止SQL注入方式为：_________?', 6, '填空题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '70613f1f5ddd4f078fe85615d9a79664');
INSERT INTO `sectionexamrubric_tb` VALUES ('94f4076d609f41f283fc07d5393035d8', 'd57a1012d8e343408f05a49774af2f5d', '撒打发士大夫', 2, '单选题', 4, '25', '92dd88b1-9157-46de-bfee-51c6b1d17229', '27eb5980adc84a50aa247eb5eab479af');
INSERT INTO `sectionexamrubric_tb` VALUES ('967cbb8adbad474289d70f8890f0deba', 'e27de879ab2e4badbf11a2ac3e505537', 'rrrrrrrrr', 6, '单选题', 25, '32', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'd3965f90353148cdaa3abb6079b74a67');
INSERT INTO `sectionexamrubric_tb` VALUES ('969c686af5cd4bda9e8a9f891bd470da', 'rownum', 'Oracle的分页语句关键字为：_____?', 6, '填空题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6c33a488597847119b494a01f64c6b83');
INSERT INTO `sectionexamrubric_tb` VALUES ('973926cdf5574bbc8c550a4d822f9411', '1417f62929404352b3cee5cf84f7264f,cacd186403a541caa4dc26f6a52defc6', '发士大夫', 15, '多选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('97553a16324245a885a2d23ad787d5af', '6a7027b59c854f62b5a14769b869ed24,7d8bd60241ad48d288ebfe31b26adf99', '发士大夫', 15, '多选题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('98a7343884d7435fb3c406e2f881416f', 'A', 'rrrrrrrrr', 16, '单选题', 1, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('9c518f3bc9ff4451a2c57eb8ca618af1', '预编译语句、mpper方式中的#vvvvvvvv', '防止SQL注入方式为：_________?', 15, '填空题', 1, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '45531b5791b34a6286d6e5c98f93678e');
INSERT INTO `sectionexamrubric_tb` VALUES ('a35b1d8c48514189abe4895efd6e0241', 'rownum', 'Oracle的分页语句关键字为：_____?', 15, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '52ac8b87d7d64cee9942cec2fe1186e6');
INSERT INTO `sectionexamrubric_tb` VALUES ('a83db9920d7a4a089f0c2e1c4c13561d', '正确', '动态SQL运用最多的地方要算查询条件的产生', 16, '判断题', 1, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('b0bccf693be243ea8a6a0219613758de', 'rownum', 'Oracle的分页语句关键字为：_____?', 6, '填空题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '346c1695d2f14bdf811f0a9fc6727f34');
INSERT INTO `sectionexamrubric_tb` VALUES ('b37f2d4dbab042e2a4ba1d3d29690c8e', '6f9bd8660715461aad8c683322780587', 'rrrrrrrrr', 6, '单选题', 2, '32', '92dd88b1-9157-46de-bfee-51c6b1d17229', '70613f1f5ddd4f078fe85615d9a79664');
INSERT INTO `sectionexamrubric_tb` VALUES ('bac296e970994ce1a770f871c58185ba', '正确', '白敬亭', 6, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6c33a488597847119b494a01f64c6b83');
INSERT INTO `sectionexamrubric_tb` VALUES ('bcd0b5054db347e281f63e3091c71a85', '预编译语句、mpper方式中的#vvvvvvvv', '防止SQL注入方式为：_________?', 16, '填空题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '4123a607d4d944aa934d1b4a65258696');
INSERT INTO `sectionexamrubric_tb` VALUES ('c188fe3ffdfa4b29b34d295f6bdc7628', '正确', '3333333333', 6, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '346c1695d2f14bdf811f0a9fc6727f34');
INSERT INTO `sectionexamrubric_tb` VALUES ('d45894d6a41c42928a8ca03aa0b5dbc0', 'asd', 'sad', 6, '填空题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '346c1695d2f14bdf811f0a9fc6727f34');
INSERT INTO `sectionexamrubric_tb` VALUES ('d4aecb823a7f407f889164b739669895', 'f804bf9e125341bc9767d17a0baba8c7,e69479fbb5264a22a133cfcea0547de5', '发士大夫', 16, '多选题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('d6bfedc2259f40f1b5346dc498bbd064', 'rownum', 'Oracle的分页语句关键字为：_____?', 6, '填空题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'a6268a81f88042f09382c41adb5f2e71');
INSERT INTO `sectionexamrubric_tb` VALUES ('de9691ce77514f3083185ba1cef2e31c', 'rownum', 'Oracle的分页语句关键字为：_____?', 1, '填空题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '0a5f5222c0594388955188a580852de7');
INSERT INTO `sectionexamrubric_tb` VALUES ('e02692d7e1244b53a9972e1513064921', '', '8888', 16, '判断题', 7, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '866111b239ee463b8f05bb2e0a26ee26');
INSERT INTO `sectionexamrubric_tb` VALUES ('e644efdb76854eb1b8392835913e0b48', 'asd', 'sad', 15, '填空题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('e67368ffc04844e79eff998a20679fbe', '正确', '3333333333', 15, '判断题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '52ac8b87d7d64cee9942cec2fe1186e6');
INSERT INTO `sectionexamrubric_tb` VALUES ('e7d055362e5d4bb28d6cbd2dab0a72b9', '正确', '8888', 15, '判断题', 2, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('ea6ca1b8ac5d4a7f8baba0d0356c59b1', '预编译语句、mpper方式中的#vvvvvvvv', '防止SQL注入方式为：_________?', 16, '填空题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('ecefb6ae17244bf6b064a3e74ee3c10b', '正确', '在HTML页面中，<th>标记可以为表中的一列指定一个标题', 6, '判断题', 25, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'ebc0a3e7c7c4444499cdc9e7d078256b');
INSERT INTO `sectionexamrubric_tb` VALUES ('ed783e6b34af45179bf6118401fa2bb1', '预编译语句、mpper方式中的#vvvvvvvv', '防止SQL注入方式为：_________?', 15, '填空题', 2, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', 'a934625e9b934e3cb8267d7f0c2ef50a');
INSERT INTO `sectionexamrubric_tb` VALUES ('f2877db21b8f41509d8eb7878908cc66', 'B', '11', 16, '单选题', 1, '42', '92dd88b1-9157-46de-bfee-51c6b1d17229', '3c894727d97b4dba9cb8644514538795');
INSERT INTO `sectionexamrubric_tb` VALUES ('f702d598b8fc4096a66adff8c807567e', 'ba70554864e24d6099ca482e9d5174b5,bb84c328f9e043acbe250146a5c88476', '发士大夫', 15, '多选题', 4, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '52ac8b87d7d64cee9942cec2fe1186e6');
INSERT INTO `sectionexamrubric_tb` VALUES ('f71ad9438a1748c1934a2bb606316162', '正确', '8888', 16, '判断题', 1, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', NULL);
INSERT INTO `sectionexamrubric_tb` VALUES ('f7cdad3262334bb5ad743928d2c6af6a', '正确', '8888', 2, '判断题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', 'cf79bcfbf56e4590aaa68a67fe4032bb');
INSERT INTO `sectionexamrubric_tb` VALUES ('f979163b9daa40c295b7f270b9d014ae', '61df9ac1569d4046b64b3b839aba9fd0,53da58755a7e4c6781d2c10295d0e24d', '顶顶顶顶顶顶顶顶顶顶顶', 6, '多选题', 3, NULL, '92dd88b1-9157-46de-bfee-51c6b1d17229', '6c33a488597847119b494a01f64c6b83');

-- ----------------------------
-- Table structure for studentexamlog_tb
-- ----------------------------
DROP TABLE IF EXISTS `studentexamlog_tb`;
CREATE TABLE `studentexamlog_tb`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examparper_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examrubric_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `select_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `performance` int(20) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentexamlog_tb
-- ----------------------------
INSERT INTO `studentexamlog_tb` VALUES ('01df510cfe8f420fb09f3b1bf1671b24', '18110039e9104663a7b045a5c66dcbf3', 'a5478ce5c8c84688bd5ef380bf433165', 'a6ecab5f1a804080b858b2ab114480b3', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('02e22fda90854b2db5202d610a0ce4b9', '17ecd5834df74adc8b3d3893e978cc54', '647524ace08c4d37a376f1dc0f6f0ec7', '0077962058a1481c91e32a569d534051,8f4024f8e86e4c50a66aa3ca1cbb726e', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('098b6566d9994116b0018ef5ee83c803', '18110039e9104663a7b045a5c66dcbf3', 'f508d6bb4d714be4854f8b5d36ab54bd', '30fd257439c94d858ec5fe25c4bd0d00', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('19823e3d41ba4ee3a16e1a2e7e403f6c', 'd1e17242502642908350cebd0c12df3d', '2f12b1eaec9544ea9d7ef0863b21e089', 'cb415a660852498884cf43bd502ef2fd', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 1);
INSERT INTO `studentexamlog_tb` VALUES ('21df45a9d8024997a910a24848741f0b', 'd1e17242502642908350cebd0c12df3d', '41497e1abf994ecf88f777144b3e1def', 'd1d0196a16034fbc87996c82f12cd2a6', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('36c23856453c49fcb62d9e16653fae16', '18110039e9104663a7b045a5c66dcbf3', '7a1eb9a89f4e46ddb29cf86c0c4a07ae', '1738d3bbf66e4ccfa9209ae3f7fa0cdc', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('371b3c60749e43c2a44428c6049a6ecb', '17ecd5834df74adc8b3d3893e978cc54', 'a04cd6c2a0914254ac4acae16ebc518d', '正确', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 1);
INSERT INTO `studentexamlog_tb` VALUES ('507dae22539540289243b50d3f6f5207', 'd30143e88f144fba8689b2e9422ae229', 'fcfea5041fb246599065e5b886ca88ef', 'e1c2d87926de4376b7a1b429a98ab610', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 6);
INSERT INTO `studentexamlog_tb` VALUES ('68fbd69011864ee6b890881dd69ac634', 'd30143e88f144fba8689b2e9422ae229', '22b4de0d0e5f4c72aa5d8edb86d23911', 'e55fac8b7742483b88a5dde54a2809fc', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('6946cbda063445549510c01de359fd6d', 'd30143e88f144fba8689b2e9422ae229', '0a15289093f148ee8f7a508773685605', '61774aee4cd74059b68be62ffd407036,1325ee0911274ba29dda0cd73ce88331', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('7f0922d5db44457bbc21bf1ce2438d6d', 'd1e17242502642908350cebd0c12df3d', '7f083cbfcc4d494db2a4f4e08177a6dc', '正确', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 1);
INSERT INTO `studentexamlog_tb` VALUES ('813c528bdd294d5083baa0aa8272ba3a', '17ecd5834df74adc8b3d3893e978cc54', '3df561f200da400c99765b62a1fb0ba6', '27f331e12be744988637de769c0fe4ae,4bbf0728eb9a42d18eaccbe26ff056d9', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('87ab143557584190a1ceab18a35ec646', 'b085b4f059ac4136aa7fefe9efe800bc', '200231502a5f4dbb856d50a8fa002875', '0b8983e6157f4a11ba899eb27a2c90c4,0bc147a850044e8ca15621cffb26854e', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('89bddb35f29c46419830c38d6e94c207', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', '469078636ebd4aeaa6cd1209a38b8fa6', '正确', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('9a69f08bce9845509feef5280790d338', 'd1e17242502642908350cebd0c12df3d', 'e44e566c79b5407daf90600573eba2b8', '42ff546c824742a89ef866c1a348173c', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 1);
INSERT INTO `studentexamlog_tb` VALUES ('a35df7d935ee430f9873eedae6cc18ee', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', '0e4e34b01f4446ffbe94062615b3dc34', '05b9665eab594f41b5d2b1ee2fa338da', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('a6c36f934cf447c2872d0d3a6e8d01e2', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', 'eee9ee35bf9f4ef5b960d807bdc945f6', '脚后跟范德萨', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('ac671bad1a0348e9ac4a7d1698784f62', '18110039e9104663a7b045a5c66dcbf3', '08dcecf4591248a4ac75ec8018bf70c0', 'd4c7adf5055c44dda949e14eb6c89288,dd429ee0171b4219b7423b8e9ca75b9f', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('afe727fcc1a4491faaac672e67c60f1a', '17ecd5834df74adc8b3d3893e978cc54', 'e49bcb6016f6420582754cf5e5fce9f6', '错误', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('b64f8c143b774b13bfb419e3f7b52040', '17ecd5834df74adc8b3d3893e978cc54', '647524ace08c4d37a376f1dc0f6f0ec7', '0077962058a1481c91e32a569d534051', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('c009fc82f00242438763fd02d9de1f27', '17ecd5834df74adc8b3d3893e978cc54', '3df561f200da400c99765b62a1fb0ba6', '27f331e12be744988637de769c0fe4ae', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('d204f17adfe546499f081c00d18d3fcb', 'd1e17242502642908350cebd0c12df3d', '19968aceb0104808b9ae398db0b4096a', '58d85362b35b4c08a39b846c600647c2', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('d2c5ec6d94274d5b9fcb24c4a813fc9f', '18110039e9104663a7b045a5c66dcbf3', 'edb60003ed6044238b2b3acd15b00746', 'a76ff3cf3f7f4621b4ed3dd70640cc4f', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('d5e3bacf269445c88e88f5dd22b9cc54', 'b085b4f059ac4136aa7fefe9efe800bc', '62b8b74aaa7841f4b778f6fadbb40aae', 'sdfg', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 1);
INSERT INTO `studentexamlog_tb` VALUES ('de0b52b12e1f4d5287e381fd5e34c219', 'c8ef8ea13ffa4a4a8de2d721f4b0e824', 'f56c1a778cc2468f813d345dcb51ce53', '2d2ffb3951884aabb6efd3dc0ab2d739', '27a1026f-be4d-4651-9245-578e31d1728a', 25, 1);
INSERT INTO `studentexamlog_tb` VALUES ('fa773f42221b4ff0b71d463de659b23c', 'd30143e88f144fba8689b2e9422ae229', '31a0548ec0d740159b8c805788219b1d', 'fbb4513d7537408fa3cef438ea46dc5a,bc6de4a92c4740ca9b8835d43be016a8', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);
INSERT INTO `studentexamlog_tb` VALUES ('fec03f778a3940769c48a87cded54ad2', 'd30143e88f144fba8689b2e9422ae229', 'e37dfdf75fc94769ada1a5871d0a15e7', '57c68fda58ab43ec9bf5a46b9537a156', '27a1026f-be4d-4651-9245-578e31d1728a', 0, 6);

SET FOREIGN_KEY_CHECKS = 1;
