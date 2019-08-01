/*
 Navicat Premium Data Transfer

 Source Server         : cdb-8umc2fk3.gz.tencentcdb.com
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-8umc2fk3.gz.tencentcdb.com:10020
 Source Schema         : iep_bbs

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 01/08/2019 11:31:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courseliketb
-- ----------------------------
DROP TABLE IF EXISTS `courseliketb`;
CREATE TABLE `courseliketb`  (
  `like_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:用户id',
  `reply_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`like_id`) USING BTREE,
  INDEX `FKlyoq57sqjd4u1ovrystwsy0nd`(`reply_id`) USING BTREE,
  CONSTRAINT `FKlyoq57sqjd4u1ovrystwsy0nd` FOREIGN KEY (`reply_id`) REFERENCES `coursereplytb` (`reply_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseliketb
-- ----------------------------
INSERT INTO `courseliketb` VALUES (4, '27a1026f-be4d-4651-9245-578e31d1728a', 1);
INSERT INTO `courseliketb` VALUES (5, '27a1026f-be4d-4651-9245-578e31d1728a', 2);
INSERT INTO `courseliketb` VALUES (6, '27a1026f-be4d-4651-9245-578e31d1728a', 3);
INSERT INTO `courseliketb` VALUES (7, '27a1026f-be4d-4651-9245-578e31d1728a', 4);
INSERT INTO `courseliketb` VALUES (10, '27a1026f-be4d-4651-9245-578e31d1728a', 5);
INSERT INTO `courseliketb` VALUES (11, '27a1026f-be4d-4651-9245-578e31d1728a', 6);
INSERT INTO `courseliketb` VALUES (12, '27a1026f-be4d-4651-9245-578e31d1728a', 7);
INSERT INTO `courseliketb` VALUES (13, '27a1026f-be4d-4651-9245-578e31d1728a', 8);
INSERT INTO `courseliketb` VALUES (30, 'null', 54);
INSERT INTO `courseliketb` VALUES (32, 'null', 51);
INSERT INTO `courseliketb` VALUES (33, '27a1026f-be4d-4651-9245-578e31d1728a', 85);

-- ----------------------------
-- Table structure for courseposttb
-- ----------------------------
DROP TABLE IF EXISTS `courseposttb`;
CREATE TABLE `courseposttb`  (
  `post_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `post_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:帖子标题',
  `reply_num` int(11) NULL DEFAULT 0 COMMENT '备注:回复数',
  `post_isstick` tinyint(1) NOT NULL DEFAULT 0 COMMENT '备注:是否置顶',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseposttb
-- ----------------------------
INSERT INTO `courseposttb` VALUES (1, '细读张爱玲——她比烟花寂寞 ', 7, 0);
INSERT INTO `courseposttb` VALUES (2, '大学英语（口语）', 4, 0);
INSERT INTO `courseposttb` VALUES (3, '编程课程', 3, 0);
INSERT INTO `courseposttb` VALUES (4, '大爱即仙骨 真情乃道心——中国传统建筑艺术课程', 0, 0);
INSERT INTO `courseposttb` VALUES (5, '走向自然——植物学课程随想', 5, 0);
INSERT INTO `courseposttb` VALUES (6, '偶然的发现，意外的惊喜-----天文漫谈 ', 3, 0);
INSERT INTO `courseposttb` VALUES (7, '“拈花惹草”有学问', 0, 0);
INSERT INTO `courseposttb` VALUES (8, '我愿走向充满诗意的远方 ', 0, 0);
INSERT INTO `courseposttb` VALUES (9, '学而时习之 ', 2, 0);
INSERT INTO `courseposttb` VALUES (10, '依稀往梦似曾见', 0, 0);
INSERT INTO `courseposttb` VALUES (11, '认识中国文明从文字开始——《说文解字》与上古社会 ', 5, 0);
INSERT INTO `courseposttb` VALUES (12, '软笔书法学习的心得体会', 3, 0);
INSERT INTO `courseposttb` VALUES (13, '手把手教你心理咨询：谈话的艺术', 3, 0);
INSERT INTO `courseposttb` VALUES (14, '你想拥有一个“经济学”的思维方式吗？ ', 7, 0);
INSERT INTO `courseposttb` VALUES (45, '世界互联网如何联通', 0, 0);
INSERT INTO `courseposttb` VALUES (46, '三网融合是指 电信网 电话网 互联网 共用一种传输介质吗？', 0, 0);
INSERT INTO `courseposttb` VALUES (47, '如何快速掌握计电脑', 0, 0);

-- ----------------------------
-- Table structure for courseposttypetb
-- ----------------------------
DROP TABLE IF EXISTS `courseposttypetb`;
CREATE TABLE `courseposttypetb`  (
  `pt_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `post_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  `type_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`pt_id`) USING BTREE,
  INDEX `FKryog6y5csrfpxeyia7752ndfg`(`post_id`) USING BTREE,
  INDEX `FKa7vcsy9nnm51lu6p5lmdwpn7i`(`type_id`) USING BTREE,
  CONSTRAINT `FKa7vcsy9nnm51lu6p5lmdwpn7i` FOREIGN KEY (`type_id`) REFERENCES `coursetypetb` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKryog6y5csrfpxeyia7752ndfg` FOREIGN KEY (`post_id`) REFERENCES `courseposttb` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseposttypetb
-- ----------------------------
INSERT INTO `courseposttypetb` VALUES (1, 1, 2);
INSERT INTO `courseposttypetb` VALUES (3, 3, 1);
INSERT INTO `courseposttypetb` VALUES (4, 4, 3);
INSERT INTO `courseposttypetb` VALUES (5, 5, 1);
INSERT INTO `courseposttypetb` VALUES (6, 6, 2);
INSERT INTO `courseposttypetb` VALUES (7, 7, 3);
INSERT INTO `courseposttypetb` VALUES (8, 8, 1);
INSERT INTO `courseposttypetb` VALUES (9, 9, 2);
INSERT INTO `courseposttypetb` VALUES (10, 10, 3);
INSERT INTO `courseposttypetb` VALUES (11, 11, 2);
INSERT INTO `courseposttypetb` VALUES (12, 12, 3);
INSERT INTO `courseposttypetb` VALUES (13, 13, 1);
INSERT INTO `courseposttypetb` VALUES (14, 14, 2);
INSERT INTO `courseposttypetb` VALUES (15, 1, 1);

-- ----------------------------
-- Table structure for coursereplytb
-- ----------------------------
DROP TABLE IF EXISTS `coursereplytb`;
CREATE TABLE `coursereplytb`  (
  `reply_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `course_id` int(11) NOT NULL COMMENT '备注:课程id',
  `reply_browse` int(11) NOT NULL DEFAULT 0 COMMENT '备注:浏览数',
  `reply_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:回复内容',
  `reply_likenum` int(11) NULL DEFAULT 0 COMMENT '备注:点赞数',
  `reply_parentid` int(11) NOT NULL COMMENT '备注:回复的评论id',
  `reply_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:回复人id',
  `post_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  `reply_reportnum` int(11) NULL DEFAULT 0 COMMENT '备注:举报数',
  PRIMARY KEY (`reply_id`) USING BTREE,
  INDEX `FKnkrmwdxcde4nv4ygpb3il8ay7`(`post_id`) USING BTREE,
  CONSTRAINT `FKnkrmwdxcde4nv4ygpb3il8ay7` FOREIGN KEY (`post_id`) REFERENCES `courseposttb` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coursereplytb
-- ----------------------------
INSERT INTO `coursereplytb` VALUES (1, 33, 2, '作为李鸿章的曾外孙女，她算是世家子弟，而在民国的乱世，上海，香港几处颠沛流离中，要靠一枝笔养活自己何其不容易，而她做到了。她在《花凋》里说“笑，全世界便与你同声笑；哭，你便独自哭。”深刻的知道怎么才是过活，没人会对你的一颦一笑有兴趣，只有自己把自己做成品牌了，才有人会听你发声。所以她说出名要趁早，也因为这句被抨击过很多。这话并没有错，只有她直截了当的说出来，是个真性情的。而拍旗袍装的美图，也不过是为了多卖几本书，和现如今的所谓美女作家一样，销量而已，很务实，并不做作。原来我错怪她了，她并不矫情，她是真性情。她只是个有才华很聪明又想活得好一点的女人而已，懂得乱世中的生存之道，也知道她的读者喜欢的是什么，所以她讲上海的故事，讲香港的浮华与迷乱，讲众生那些不堪的丑态，讲爱情的物化，讲婚姻的算计，讲小人物的麻木，讲连环的因果。总之，你想知道那个年代的故事，都写给你看。她并不想做什么历史的考据派，写作也是有任性的成分，但好在她懂得写作技巧，有好文字流传。是个好作家， 不是个玩弄文字的嘚瑟小女人。', 1, 0, '2018-12-24 18:35:38', '9357593e-02dc-47ab-b304-910e3411a897', 1, 0);
INSERT INTO `coursereplytb` VALUES (2, 33, 0, '大爱悲惨张爱铃', 4, 1, '2018-12-24 18:36:25', '9357593e-02dc-47ab-b304-910e3411a897', 1, 0);
INSERT INTO `coursereplytb` VALUES (3, 33, 0, '说的很好，一门好课，可以打开一扇认知的窗户', 3, 1, '2018-12-24 18:37:24', '9357593e-02dc-47ab-b304-910e3411a897', 1, 0);
INSERT INTO `coursereplytb` VALUES (4, 33, 0, '首先我真的也是很喜欢张爱玲，高中转学跟闺蜜分开，她送了我一本张爱玲自传，每次想她的时候，我就看那本书，真的对这个人爱得很。然后，MOOC真的是一个特别好的平台。能让人收获很多。不止框在我们自己的专业领域', 2, 2, '2018-12-24 18:37:38', '9357593e-02dc-47ab-b304-910e3411a897', 1, 0);
INSERT INTO `coursereplytb` VALUES (5, 33, 0, '在文学中活出自己，活的精彩', 0, 3, '2018-12-24 18:38:19', '9357593e-02dc-47ab-b304-910e3411a897', 1, 0);
INSERT INTO `coursereplytb` VALUES (6, 34, 0, '今天真的要推荐这门课程，这门课程的老师在讲授课程的时候口语说的非常慢，并且非常的标准，发音特别的好，听起来非常的棒，大家要知道说英语，说好口语是多么的重要，而这个问题，我相信在这个课程中应该是会为你解决的，再也不是哑巴英语，而且这个课程开了多次，事实证明，时间证明它真的是一个非常优秀的课程。', 1, 0, '2018-12-24 19:28:44', '9357593e-02dc-47ab-b304-910e3411a897', 2, 0);
INSERT INTO `coursereplytb` VALUES (7, 34, 0, '语言的学习中，掌握规律都是 听——说——读——写。\r\n\r\n良好的口语必须在听力上也要下功夫', 0, 6, '2018-12-24 19:28:45', '9357593e-02dc-47ab-b304-910e3411a897', 2, 0);
INSERT INTO `coursereplytb` VALUES (8, 34, 0, '需不需要基础，要考四级了，心里很着急，希望可以帮到自己', 0, 6, '2018-12-24 19:28:47', '9357593e-02dc-47ab-b304-910e3411a897', 2, 0);
INSERT INTO `coursereplytb` VALUES (9, 34, 0, '我也选了这门课，老师的发音很清晰，值得推荐。', 0, 8, '2018-12-24 19:28:49', '9357593e-02dc-47ab-b304-910e3411a897', 2, 0);
INSERT INTO `coursereplytb` VALUES (10, 34, 0, '这门课程是需要高中和大学英语基础的，要求能大概听懂对话。针对的英语有点基础的人，你上过高中应该没问题', 0, 8, '2018-12-24 19:28:51', '9357593e-02dc-47ab-b304-910e3411a897', 2, 0);
INSERT INTO `coursereplytb` VALUES (11, 34, 0, '浙江大学翁恺老师的编程课程真的很不错，很容易听懂，无论是JAVA还是C语言，最好的一点就是会带着大家一边打代码一边学，更有利于同学们的理解，而不只是按照PPT的内容说而没有具体的时间。', 0, 0, '2018-12-24 19:28:57', '9357593e-02dc-47ab-b304-910e3411a897', 3, 0);
INSERT INTO `coursereplytb` VALUES (12, 34, 0, '重新建立这种学习能力，需要比你所想象的更多的努力。', 0, 11, '2018-12-24 19:28:59', '9357593e-02dc-47ab-b304-910e3411a897', 3, 0);
INSERT INTO `coursereplytb` VALUES (13, 34, 0, '需要一段时间的学习和练习', 0, 11, '2018-12-24 19:29:00', '9357593e-02dc-47ab-b304-910e3411a897', 3, 0);
INSERT INTO `coursereplytb` VALUES (14, 34, 0, '确实，我觉得这个需要自己努力', 0, 13, '2018-12-24 19:29:02', '9357593e-02dc-47ab-b304-910e3411a897', 3, 0);
INSERT INTO `coursereplytb` VALUES (15, 57, 0, '听完最后一节《古建筑的保护》，心情久久不能平静。到慕课的学习群里去和同学们讨论：柳老爷子的课不是这样就结束了吧？突然觉得依依难舍，突然想写点什么，向柳老爷子表达一个素不相识的学生的最崇高的敬意。\r\n\r\n　　也许是因为中国MOOC刚刚起步的原因，这里当然有很多精彩的课程，但也会有一些老师，平铺直叙，让人兴味索然，同学们也就难免私下里各种吐槽。实话实说，柳老爷子也一度成为大家吐槽的对象，因为在各门MOOC课程里，柳老的视频长度可以算是最长的，每周需要几乎整整一个晚上来听课。最开始的时候一度觉得很累，然而越听到最后，就越觉其短。和同学们再聊天的时候，我说：柳老爷子的课充分证明了一个真理：有爱才能生动，因情才能精彩。', 0, 0, '2018-12-24 19:32:36', '9357593e-02dc-47ab-b304-910e3411a897', 4, 0);
INSERT INTO `coursereplytb` VALUES (16, 57, 0, '先生的一段话，先生说：从古至今，建筑从来就是单纯的一栋房子，而是艺术的一种形式。\r\n\r\n\r\n深受触动', 0, 15, '2018-12-24 19:29:04', '9357593e-02dc-47ab-b304-910e3411a897', 4, 0);
INSERT INTO `coursereplytb` VALUES (17, 57, 0, '\r\n\r\n好有感情的课程推荐，楼主文笔也好。\r\n\r\n这次选课太多了都要顾不过来，这门课记下来这轮完了学~\r\n', 0, 16, '2018-12-24 19:29:08', '9357593e-02dc-47ab-b304-910e3411a897', 4, 0);
INSERT INTO `coursereplytb` VALUES (18, 57, 0, '我很喜欢中国的古建筑！', 0, 15, '2018-12-24 19:29:10', '9357593e-02dc-47ab-b304-910e3411a897', 4, 0);
INSERT INTO `coursereplytb` VALUES (19, 57, 0, '真的很棒的！', 0, 18, '2018-12-24 19:29:12', '9357593e-02dc-47ab-b304-910e3411a897', 4, 0);
INSERT INTO `coursereplytb` VALUES (20, 57, 0, '我非常喜欢', 0, 18, '2018-12-24 19:29:16', '9357593e-02dc-47ab-b304-910e3411a897', 4, 0);
INSERT INTO `coursereplytb` VALUES (21, 58, 0, '作为跨界闯入生命世界的我，几乎每天都被感动着。从校园里的银杏，到滇池畔的海鸥。从组培室的拟南芥，到大棚边的紫罗兰。我从暴土扬长的工科现场，一路蹒跚走来，眼前的点点滴滴都宛若仙境。', 0, 0, '2018-12-24 19:29:20', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0);
INSERT INTO `coursereplytb` VALUES (22, 58, 0, '自然界真的很奇妙，我国庆才去了滇池，不过没见到海鸥 ', 0, 21, '2018-12-24 19:29:25', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0);
INSERT INTO `coursereplytb` VALUES (23, 58, 0, '\r\n\r\n有感恩之心，棒棒哒。\r\n\r\n国庆去了云南，滇池那天好大雾，但是对云南留下了很好的印象。\r\n', 0, 21, '2018-12-24 19:29:26', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0);
INSERT INTO `coursereplytb` VALUES (24, 58, 0, '恩恩，一般而言要十一以后了，他们超级聪明，都不上岸，无论怎么用食物诱惑O(∩_∩)O哈哈~', 0, 22, '2018-12-24 19:29:29', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0);
INSERT INTO `coursereplytb` VALUES (25, 58, 0, '云南真的是野生生物资源的宝库，希望今后政府能够下决心改善云南的生态，而不是一味地发展高污染的矿物工业~~~', 0, 24, '2018-12-24 19:29:31', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0);
INSERT INTO `coursereplytb` VALUES (26, 58, 0, '点赞《植物学》，加油！', 0, 21, '2018-12-24 19:29:35', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0);
INSERT INTO `coursereplytb` VALUES (27, 60, 1, '  时至岁末，孩子放假，借此机会，让孩子了解些课本外的知识，于是我又来到慕课，《天文漫谈》刚好开课，怀着好奇之心，我打开了课件。那唯美的画面呈现在眼前，配以优美的诗篇、轻柔缥缈的背景音乐、还有徐老师那如诗般的语言，我被惊呆了！我打开的是一个课件吗？我在怀疑自己，我打开的是一个未知的、神奇又美丽的世界，如童话般美好、又如神话般久远...... 我想搜索更好的词句描绘这美好的景象，可是所有的语言都显的那么拙劣。我静静的欣赏着眼前的美景，时而屏息凝视、时而想欢呼呐喊，我想拿起笔做笔记，唯恐错过了眼前的画面，如果知识点与这画面分开，就没有了这种美感、这种体验，索性还是不做笔记了。我想留住这份美好、定格这美好的瞬间，于是我就开始截屏，哪怕花的时间长些。说到这，你是否也很好奇？那就跟着我一起走进那浩瀚无际、神秘、古老而又绚丽多彩的天文世界吧！', 0, 0, '2018-12-24 19:29:40', '9357593e-02dc-47ab-b304-910e3411a897', 6, 0);
INSERT INTO `coursereplytb` VALUES (28, 60, 0, '徐老师的课很有魔力，第一堂课就美呆了哈！', 0, 27, '2018-12-24 19:29:43', '9357593e-02dc-47ab-b304-910e3411a897', 6, 0);
INSERT INTO `coursereplytb` VALUES (29, 60, 0, '师相当的幽默风趣，在论坛相当活跃，而且测试题设置的也相当具有特色', 0, 27, '2018-12-24 19:29:41', '9357593e-02dc-47ab-b304-910e3411a897', 6, 0);
INSERT INTO `coursereplytb` VALUES (30, 60, 0, '讲解生动、有趣。\r\n', 0, 27, '2018-12-24 19:29:47', '9357593e-02dc-47ab-b304-910e3411a897', 6, 0);
INSERT INTO `coursereplytb` VALUES (31, 61, 0, '  随着生活水平的提高，越来越多的人喜爱花花草草。老舍《养花》一文这样表达养花乐趣：“有喜有乐、有笑有泪、有花有果、有香有色”。是的，绿色植物是大自然对人类的馈赠，我国地大物博，高天厚土也格外垂爱：中国裸子植物资源和栽培（野生）果树种类世界第一，种子植物种类世界第三。', 0, 0, '2018-12-24 19:29:49', '9357593e-02dc-47ab-b304-910e3411a897', 7, 0);
INSERT INTO `coursereplytb` VALUES (32, 61, 0, ' 参加慕课学习，有不少讲授诗歌的课程。四川大学王红老师的《中国诗歌艺术》和浙江大学胡可先老师的《唐诗经典》等课程就很受欢迎。王红老师说：“人活在世上，追求的不仅是肉体的温饱，还需要精神有所寄托，心灵有所安顿。而诗歌正是人类精神寄托，心灵安顿的方式之一。古今凡能被称为“诗”者，无不是心灵与心灵的碰撞，生命与生命之间的交流，是一种高贵的精神生活方式。”然而，在强烈呼吁追求生活品质的当下，诗歌却在我们的生活中悄无声息地退到了幕后。', 0, 0, '2018-12-24 19:29:54', '9357593e-02dc-47ab-b304-910e3411a897', 8, 0);
INSERT INTO `coursereplytb` VALUES (33, 61, 0, ' 应该说，人们对于诗词的喜爱，从来没有间断过。不过，诗歌是慢下来以后的艺术，如果人全是焦虑，全是得失间的苦恼，眼前明明是风淡云轻，偏觉得风云滚滚，这就失却了欣赏与创作诗的心境。《中国诗词大会》评委说的好：“中国人的诗心一直在，但需要被激活”。是的，我们需要文化自信，更需要文化自觉。希望慕课中出现更多“诗歌艺术”类课程，呼唤更多的童鞋加入到课程中来，学会欣赏和创作诗歌，使自己心中的“诗和远方”都不再遥远。', 0, 32, '2018-12-24 19:29:57', '9357593e-02dc-47ab-b304-910e3411a897', 8, 0);
INSERT INTO `coursereplytb` VALUES (34, 61, 0, '第二届了，依然很有感觉，我也要学诗歌。', 0, 33, '2018-12-24 19:29:56', '9357593e-02dc-47ab-b304-910e3411a897', 8, 0);
INSERT INTO `coursereplytb` VALUES (35, 61, 0, '我也喜欢看中国诗词大会！很涨姿势！', 0, 32, '2018-12-24 19:30:00', '9357593e-02dc-47ab-b304-910e3411a897', 8, 0);
INSERT INTO `coursereplytb` VALUES (36, 61, 0, '诗情画意的人生才能称得上完美人生。', 0, 35, '2018-12-24 19:29:58', '9357593e-02dc-47ab-b304-910e3411a897', 8, 0);
INSERT INTO `coursereplytb` VALUES (37, 89, 0, '混慕课有8个月了，收获很多，学完了近10个不同的课程，收获很多。确实像有些朋友说的，学了《方言》，感觉别人说的方言更亲切了，也会尝试去猜测对方哪里人。\r\n\r\n学了《插花》，每周在家里插一次花，学了《茶艺》，虽然没有全套工具，但品茶时会懂得闻香以及选择适当的投放方法了。学了《经典文学导读》开始敏锐自己的感官，开始尝试写些东西。学了《世界历史》，看着地图更有感情了，哪里曾有过辉煌，发生过生么事，涌现过什么人，当我有机会去旅行，研究攻略，觉得地名不单单是一个名字了，变得更加丰富了。 学了《人文视野中的生态学》，更加环保了，更加爱动物和这个世界。\r\n\r\n正在学《道德经》，感觉世界在我心里更加融会贯通了。正在学《调酒》，买了调酒器具，准备开始自己调酒。还有很多其他，不多做赘述了。\r\n\r\n\r\n我想每件事对于每个人，想法看法感受都是不同的，有没有可能组建一些慕课学习小组，大家多交流，互通有无，共同进步。:-) \r\n\r\n\r\n', 0, 0, '2018-12-24 19:30:03', '9357593e-02dc-47ab-b304-910e3411a897', 9, 0);
INSERT INTO `coursereplytb` VALUES (38, 89, 0, '细读张爱玲这门课不错哒~台湾教授观点新颖，对张爱玲很多的解释让我对这个作家有了更全面地认识~', 0, 37, '2018-12-24 19:30:06', '9357593e-02dc-47ab-b304-910e3411a897', 9, 0);
INSERT INTO `coursereplytb` VALUES (39, 89, 0, '哈哈知音', 0, 38, '2018-12-24 19:30:10', '9357593e-02dc-47ab-b304-910e3411a897', 9, 0);
INSERT INTO `coursereplytb` VALUES (40, 90, 0, ' 三十年前怀揣金庸小说到校园，还是一件提心吊胆的事。若被发现，书要没收，人即“罚”办，不少“淘气”学生为此吃过苦头。不想今天在课堂上，可以跟随赵老师一起欣赏、分析华文经典名著。不过却因过去读之不精，若从文化内涵和审美价值方面分析侠客形象，又觉得力不从心。\r\n\r\n   武汉大学赵小琪老师开设的《世界华文经典欣赏》课，依据艺术开掘上的独创性，风格流派上的代表性，艺术影响上的广泛性三个标准，对在华人文化圈中产生极大影响的世界华文文学经典，进行了系统整体性的评价。听来既亲切熟悉，又别开生面，引人入胜。', 0, 0, '2018-12-24 19:30:12', '9357593e-02dc-47ab-b304-910e3411a897', 10, 0);
INSERT INTO `coursereplytb` VALUES (41, 91, 0, '并不是中国的汉字记录了中国历史，其演化的过程本身就是一部历史！\r\n\r\n\r\n这是最触动自己的一句话，当老师在讲授中国文字的诞生与演化，讲授如何通过对文字的解读来重新认识中华文明，一股热情从心底升起！很多我们自以为是的当代解读，实际上都是对文字的不敬，要深入了解中国的文明，失去文字的辅助几乎是不可能！所以，我向大家推荐这门课程，万老师的讲课风格非常风趣幽默，举例内涵丰富，引人入胜！', 0, 0, '2018-12-24 19:30:14', '9357593e-02dc-47ab-b304-910e3411a897', 11, 0);
INSERT INTO `coursereplytb` VALUES (42, 91, 0, '一直对古文字感兴趣，今年我也学学', 0, 41, '2018-12-24 19:30:17', '9357593e-02dc-47ab-b304-910e3411a897', 11, 0);
INSERT INTO `coursereplytb` VALUES (43, 91, 0, '上次报的科目太多，学不过来，又退了，下期开始学习。', 0, 41, '2018-12-24 19:30:19', '9357593e-02dc-47ab-b304-910e3411a897', 11, 0);
INSERT INTO `coursereplytb` VALUES (44, 91, 0, '这门课非常不错！极力推荐！', 0, 41, '2018-12-24 19:30:20', '9357593e-02dc-47ab-b304-910e3411a897', 11, 0);
INSERT INTO `coursereplytb` VALUES (45, 91, 0, '很精彩的课，拿到了这门课的优秀证书，但是感觉学的太肤浅，有时间再重学一遍。 ', 0, 41, '2018-12-24 19:30:22', '9357593e-02dc-47ab-b304-910e3411a897', 11, 0);
INSERT INTO `coursereplytb` VALUES (46, 91, 0, '正在学，感觉万老师讲的非常好。', 0, 41, '2018-12-24 19:30:29', '9357593e-02dc-47ab-b304-910e3411a897', 11, 0);
INSERT INTO `coursereplytb` VALUES (47, 89, 0, '练习软笔书法已经半年了，在控笔上有了长进，其他还有待进步。软笔书法本来也不是一朝一夕能够练好的，所以并不气馁。最初临习的是颜真卿的《多宝塔碑》，一段时间后有点厌烦，在网上看到田英章讲解的楷书视频，非常喜欢，虽然一开始直觉并不喜欢欧体字，但是看到田英章视频后，觉得欧体字很漂亮。陆续又看了些田蕴章的《每日一题每日一字》，其中有一段提到，要不要跟从现代人练习书法，他说自己开始学习书法的时候，也是临习父亲的字两年，然后才临习碑帖。相当于打基础，有了基础再临习碑帖会更好。我也因此买了田英章的软笔书法基础教程，跟着临习了两个月，期间也临习颜真卿的《多宝塔碑》。近期，听了慕课《中国书法》的课程，觉得自己走偏了，还是摒弃了田英章的现代教材（当然以后如果临习欧体也还会参考，教材中讲解的基本笔法很不错），专心练习颜体，经过一位书法老师的指导，我原来买的《多宝塔碑》碑帖版本并不太好，他给我推荐了另外一本，买来用了几天果然感觉不同。结合慕课《中国书法》的课程的学习，我还打算临摹《石鼓文》，这样稳稳的走下去，不再走弯路。大家都来讨论一下学习体会和经验吧，互相交流，才有进步！', 0, 0, '2018-12-24 19:30:25', '9357593e-02dc-47ab-b304-910e3411a897', 12, 0);
INSERT INTO `coursereplytb` VALUES (48, 89, 0, '我很喜欢书法，可是自己的字却写的不好，心血来潮时，也会猛练一通，可是缺乏长久的坚持，以后得抽时间练， 很羡慕写是一手漂亮字的人，打算也报这门课。', 0, 47, '2018-12-24 19:33:04', '9357593e-02dc-47ab-b304-910e3411a897', 12, 0);
INSERT INTO `coursereplytb` VALUES (49, 89, 0, '我们最近在练小篆硬笔', 0, 47, '2018-12-24 19:33:05', '9357593e-02dc-47ab-b304-910e3411a897', 12, 0);
INSERT INTO `coursereplytb` VALUES (50, 89, 0, '何为小篆硬笔？', 0, 49, '2018-12-24 19:33:06', '9357593e-02dc-47ab-b304-910e3411a897', 12, 0);
INSERT INTO `coursereplytb` VALUES (51, 1, 3, '心理咨询似乎很神秘，我们常常想靠近它，但又害怕靠近它！所以这门课要帮助你了解心理咨询、懂得心理咨询。 我并不是要教你成为一名心理咨询师，而是要手把手地教会你，将心理咨询的理念和技巧，合理、恰当地运用到奇妙的人际沟通中去，让你的人际关系变得更加和谐，生活也由此变得更加精彩！1', 1, 0, '2018-12-24 19:33:09', '9357593e-02dc-47ab-b304-910e3411a897', 13, 0);
INSERT INTO `coursereplytb` VALUES (52, 1, 0, '人际沟通能力非常重要，也是您事业成功的基础。', 0, 51, '2018-12-24 19:33:12', '9357593e-02dc-47ab-b304-910e3411a897', 13, 0);
INSERT INTO `coursereplytb` VALUES (53, 1, 0, '我也报了这门课，一起来学习吧！ ', 0, 51, '2018-12-24 19:33:13', '9357593e-02dc-47ab-b304-910e3411a897', 13, 0);
INSERT INTO `coursereplytb` VALUES (54, 1, 0, '开始学习了！', 0, 51, '2018-12-24 19:33:15', '9357593e-02dc-47ab-b304-910e3411a897', 13, 0);
INSERT INTO `coursereplytb` VALUES (55, 1, 11, '文老师：有的消费者在日常生活中经常犯这样错误：废弃冰箱等旧家电（市场价格在50—100元）舍不得卖掉，但是房屋价格相当昂贵，一平米在一万至两万间。在这样很昂贵的房间中，一平米、两平米都是摆着这些废旧家电，昂贵的房间没有得到很好利用。这时正确的做法应该是，按照市场价格，哪怕是只有一、二百元也要卖掉旧家电，甚至花钱也要处理掉。腾出昂贵的房屋空间，让它用到最有价值的地方去。这就是《微观经济学》对我们日常生活的具体指导。\r\n\r\n  起初看到《微观经济学》这门课程感到很恐惧，迟迟不敢下手选课。但是听了文建东老师开门见山式的讲解，突然觉得这门课程好亲近。工作生活中，处处都可得到经济学的指导。文老师还告诉我们，这门课程是经济学原理的微观部分，致力于训练学习者建立一个经济学的思维方式，用以解释我们周围世界，指导我们日常决策。\r\n\r\n  这就是武汉大学文建东老师教学团队呈现给我们的《微观经济学》课程，感兴趣的同学抓紧选课吧！', 0, 0, '2018-12-24 19:33:17', '9357593e-02dc-47ab-b304-910e3411a897', 14, 0);
INSERT INTO `coursereplytb` VALUES (56, 1, 0, '腾出的家电空间，自己仍没有收到任何利益上的涨幅', 0, 55, '2018-12-24 19:33:20', '9357593e-02dc-47ab-b304-910e3411a897', 14, 0);
INSERT INTO `coursereplytb` VALUES (57, 1, 0, '很多学科都需要自己的思维，例如法律思维，医学思维，心理学思维……经济学思维很诱人，可惜自己真没有……', 0, 55, '2018-12-24 19:33:21', '9357593e-02dc-47ab-b304-910e3411a897', 14, 0);
INSERT INTO `coursereplytb` VALUES (58, 1, 0, '哦……这种思维模式真的很新鲜。', 0, 55, '2018-12-24 19:33:24', '9357593e-02dc-47ab-b304-910e3411a897', 14, 0);
INSERT INTO `coursereplytb` VALUES (59, 1, 0, '学习学习', 0, 55, '2018-12-24 19:33:26', '9357593e-02dc-47ab-b304-910e3411a897', 14, 0);
INSERT INTO `coursereplytb` VALUES (60, 1, 0, '加油', 0, 56, '2018-12-24 19:34:19', '9357593e-02dc-47ab-b304-910e3411a897', 14, 0);
INSERT INTO `coursereplytb` VALUES (72, 1, 0, '呵呵', 0, 1, '2018-12-27 16:28:33', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 0);
INSERT INTO `coursereplytb` VALUES (73, 1, 0, '呵呵呵', 0, 1, '2018-12-27 17:29:14', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 0);
INSERT INTO `coursereplytb` VALUES (75, 1, 0, '水水水水<br>', 0, 1, '2018-12-27 17:54:07', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 0);
INSERT INTO `coursereplytb` VALUES (83, 2, 0, '我不是很明白我们国家和别的国家互联网如何联通，比如我们的电脑接入移动联通电信，然后访问国内任何网站服务器，那么我访问外国网站是如何实现的？', 0, 0, '2019-01-06 23:08:34', '27a1026f-be4d-4651-9245-578e31d1728a', 45, 0);
INSERT INTO `coursereplytb` VALUES (84, 2, 1, '这个对于计算机三级网络技术学习有帮助么？\r\n', 0, 0, '2019-01-06 23:09:53', '27a1026f-be4d-4651-9245-578e31d1728a', 46, 0);
INSERT INTO `coursereplytb` VALUES (85, 2, 1, '是没有基础的', 1, 0, '2019-01-06 23:11:43', '27a1026f-be4d-4651-9245-578e31d1728a', 47, 0);
INSERT INTO `coursereplytb` VALUES (86, 1, 0, 'edfs', 0, 55, '2019-01-07 11:38:06', '27a1026f-be4d-4651-9245-578e31d1728a', 14, 0);
INSERT INTO `coursereplytb` VALUES (87, 1, 0, 'fgdf', 0, 60, '2019-01-07 11:38:28', '27a1026f-be4d-4651-9245-578e31d1728a', 14, 0);

-- ----------------------------
-- Table structure for coursereporttb
-- ----------------------------
DROP TABLE IF EXISTS `coursereporttb`;
CREATE TABLE `coursereporttb`  (
  `report_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `report_reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:举报理由',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:用户id',
  `reply_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`report_id`) USING BTREE,
  INDEX `FKqj739ciyo20xi083102ilvxsj`(`reply_id`) USING BTREE,
  CONSTRAINT `FKqj739ciyo20xi083102ilvxsj` FOREIGN KEY (`reply_id`) REFERENCES `coursereplytb` (`reply_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coursetypetb
-- ----------------------------
DROP TABLE IF EXISTS `coursetypetb`;
CREATE TABLE `coursetypetb`  (
  `type_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `type_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注:类型描述',
  `type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:类型名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coursetypetb
-- ----------------------------
INSERT INTO `coursetypetb` VALUES (1, '发表关于作业、测试、课件内容希望能够得到老师回答的疑问。', '教师答疑区');
INSERT INTO `coursetypetb` VALUES (2, '这里呈现的是在课件中作为教学内容的讨论', '课堂交流区');
INSERT INTO `coursetypetb` VALUES (3, '发表任何想与大家分享的经验及想法！关于本课程、学习、工作、生活等一般性话题', '综合讨论区');

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
INSERT INTO `hibernate_sequence` VALUES (51);
INSERT INTO `hibernate_sequence` VALUES (51);
INSERT INTO `hibernate_sequence` VALUES (51);
INSERT INTO `hibernate_sequence` VALUES (51);
INSERT INTO `hibernate_sequence` VALUES (51);
INSERT INTO `hibernate_sequence` VALUES (51);

-- ----------------------------
-- Table structure for liketb
-- ----------------------------
DROP TABLE IF EXISTS `liketb`;
CREATE TABLE `liketb`  (
  `like_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:用户id',
  `reply_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`like_id`) USING BTREE,
  INDEX `FKdrbqjt8672ode7jqauyflgay8`(`reply_id`) USING BTREE,
  CONSTRAINT `FKdrbqjt8672ode7jqauyflgay8` FOREIGN KEY (`reply_id`) REFERENCES `replytb` (`reply_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 184 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liketb
-- ----------------------------
INSERT INTO `liketb` VALUES (2, '9357593e-02dc-47ab-b304-910e3411a897', 2);
INSERT INTO `liketb` VALUES (8, '9357593e-02dc-47ab-b304-910e3411a897', 5);
INSERT INTO `liketb` VALUES (12, '9357593e-02dc-47ab-b304-910e3411a897', 13);
INSERT INTO `liketb` VALUES (13, '9357593e-02dc-47ab-b304-910e3411a897', 16);
INSERT INTO `liketb` VALUES (14, '27a1026f-be4d-4651-9245-578e31d1728a', 19);
INSERT INTO `liketb` VALUES (15, '9357593e-02dc-47ab-b304-910e3411a897', 23);
INSERT INTO `liketb` VALUES (17, '27a1026f-be4d-4651-9245-578e31d1728a', 34);
INSERT INTO `liketb` VALUES (18, '9357593e-02dc-47ab-b304-910e3411a897', 39);
INSERT INTO `liketb` VALUES (48, '9357593e-02dc-47ab-b304-910e3411a897', 6);
INSERT INTO `liketb` VALUES (49, '9357593e-02dc-47ab-b304-910e3411a897', 4);
INSERT INTO `liketb` VALUES (65, '9357593e-02dc-47ab-b304-910e3411a897', 123);
INSERT INTO `liketb` VALUES (66, '27a1026f-be4d-4651-9245-578e31d1728a', 37);
INSERT INTO `liketb` VALUES (68, '9357593e-02dc-47ab-b304-910e3411a897', 25);
INSERT INTO `liketb` VALUES (69, '27a1026f-be4d-4651-9245-578e31d1728a', 18);
INSERT INTO `liketb` VALUES (72, '9357593e-02dc-47ab-b304-910e3411a897', 10);
INSERT INTO `liketb` VALUES (77, '9357593e-02dc-47ab-b304-910e3411a897', 12);
INSERT INTO `liketb` VALUES (147, '9357593e-02dc-47ab-b304-910e3411a897', 46);
INSERT INTO `liketb` VALUES (151, '27a1026f-be4d-4651-9245-578e31d1728a', 122);
INSERT INTO `liketb` VALUES (152, '27a1026f-be4d-4651-9245-578e31d1728a', 1);
INSERT INTO `liketb` VALUES (155, '27a1026f-be4d-4651-9245-578e31d1728a', 44);
INSERT INTO `liketb` VALUES (158, '27a1026f-be4d-4651-9245-578e31d1728a', 7);
INSERT INTO `liketb` VALUES (164, '27a1026f-be4d-4651-9245-578e31d1728a', 16);
INSERT INTO `liketb` VALUES (168, '27a1026f-be4d-4651-9245-578e31d1728a', 10);
INSERT INTO `liketb` VALUES (170, '27a1026f-be4d-4651-9245-578e31d1728a', 12);
INSERT INTO `liketb` VALUES (174, '27a1026f-be4d-4651-9245-578e31d1728a', 9);
INSERT INTO `liketb` VALUES (175, '27a1026f-be4d-4651-9245-578e31d1728a', 2);
INSERT INTO `liketb` VALUES (178, '27a1026f-be4d-4651-9245-578e31d1728a', 11);
INSERT INTO `liketb` VALUES (179, '27a1026f-be4d-4651-9245-578e31d1728a', 144);
INSERT INTO `liketb` VALUES (180, '27a1026f-be4d-4651-9245-578e31d1728a', 46);
INSERT INTO `liketb` VALUES (182, '27a1026f-be4d-4651-9245-578e31d1728a', 8);
INSERT INTO `liketb` VALUES (183, '27a1026f-be4d-4651-9245-578e31d1728a', 8);

-- ----------------------------
-- Table structure for posttb
-- ----------------------------
DROP TABLE IF EXISTS `posttb`;
CREATE TABLE `posttb`  (
  `post_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `post_isstick` tinyint(1) NOT NULL DEFAULT 0 COMMENT '备注:是否置顶',
  `post_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:帖子标题',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posttb
-- ----------------------------
INSERT INTO `posttb` VALUES (1, 0, '大家春节期间一定免不了被问到“你是什么专业的？”');
INSERT INTO `posttb` VALUES (2, 1, '一个大学的好坏是否真的可以影响到学生的未来? ');
INSERT INTO `posttb` VALUES (3, 0, '读书是追求简而精，还是多而杂呢？ ');
INSERT INTO `posttb` VALUES (4, 1, '五个值得推荐的英语学习网站，不可错过哦！ ');
INSERT INTO `posttb` VALUES (5, 0, '张爱玲眼中的月亮长什么样？');
INSERT INTO `posttb` VALUES (6, 0, '你不是迷茫，你只是浮躁');
INSERT INTO `posttb` VALUES (7, 0, '慕课可以取代普通高校的存在了吗？ ');
INSERT INTO `posttb` VALUES (8, 0, '如何才能有一段完美的大学生活？');
INSERT INTO `posttb` VALUES (9, 0, '怎样学习才有效率？');
INSERT INTO `posttb` VALUES (10, 0, '你坚持的意义是什么？');
INSERT INTO `posttb` VALUES (11, 0, '学会知识管理，减少盲目选课的痛苦 ');
INSERT INTO `posttb` VALUES (12, 0, '聊一聊选过最神奇的课程');
INSERT INTO `posttb` VALUES (13, 0, '大家推荐一些自己喜欢的课程吧 ');
INSERT INTO `posttb` VALUES (14, 0, '我推荐中国茶道这门课 ');
INSERT INTO `posttb` VALUES (15, 0, '情商究竟体现在什么地方？ ');
INSERT INTO `posttb` VALUES (16, 0, '学习是为了梦想而学，还是为了职业需要而学或是为了获得资金？');
INSERT INTO `posttb` VALUES (17, 0, '如何进一步提高一个人的经济学素养');
INSERT INTO `posttb` VALUES (18, 0, '决定你人生的并非想法 而是原则 ');
INSERT INTO `posttb` VALUES (19, 0, '其实，不合群的你真的很酷 ');
INSERT INTO `posttb` VALUES (20, 0, '《我的慕课故事》你现在可以调侃我。但是，十年后呢？ ');
INSERT INTO `posttb` VALUES (48, 0, 'aa');
INSERT INTO `posttb` VALUES (49, 0, 'ssss');
INSERT INTO `posttb` VALUES (50, 0, 'gfds');

-- ----------------------------
-- Table structure for posttypetb
-- ----------------------------
DROP TABLE IF EXISTS `posttypetb`;
CREATE TABLE `posttypetb`  (
  `pt_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `post_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  `type_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`pt_id`) USING BTREE,
  INDEX `FKjvaw1pv8baitg1002egdphber`(`post_id`) USING BTREE,
  INDEX `FKnydg2ykwqlrtpeo5bi4lul8np`(`type_id`) USING BTREE,
  CONSTRAINT `FKjvaw1pv8baitg1002egdphber` FOREIGN KEY (`post_id`) REFERENCES `posttb` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKnydg2ykwqlrtpeo5bi4lul8np` FOREIGN KEY (`type_id`) REFERENCES `typetb` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posttypetb
-- ----------------------------
INSERT INTO `posttypetb` VALUES (1, 1, 1);
INSERT INTO `posttypetb` VALUES (2, 2, 1);
INSERT INTO `posttypetb` VALUES (3, 5, 1);
INSERT INTO `posttypetb` VALUES (5, 4, 1);
INSERT INTO `posttypetb` VALUES (6, 6, 1);
INSERT INTO `posttypetb` VALUES (7, 7, 1);
INSERT INTO `posttypetb` VALUES (8, 8, 5);
INSERT INTO `posttypetb` VALUES (9, 9, 5);
INSERT INTO `posttypetb` VALUES (10, 10, 5);
INSERT INTO `posttypetb` VALUES (11, 11, 2);
INSERT INTO `posttypetb` VALUES (12, 12, 3);
INSERT INTO `posttypetb` VALUES (13, 13, 3);
INSERT INTO `posttypetb` VALUES (14, 14, 3);
INSERT INTO `posttypetb` VALUES (15, 15, 4);
INSERT INTO `posttypetb` VALUES (16, 16, 4);
INSERT INTO `posttypetb` VALUES (17, 17, 2);
INSERT INTO `posttypetb` VALUES (18, 18, 2);
INSERT INTO `posttypetb` VALUES (19, 19, 2);
INSERT INTO `posttypetb` VALUES (20, 20, 4);
INSERT INTO `posttypetb` VALUES (52, 3, 1);
INSERT INTO `posttypetb` VALUES (53, 3, 2);

-- ----------------------------
-- Table structure for replytb
-- ----------------------------
DROP TABLE IF EXISTS `replytb`;
CREATE TABLE `replytb`  (
  `reply_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `reply_browse` int(11) NOT NULL DEFAULT 0 COMMENT '备注:浏览数',
  `reply_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:回复内容',
  `reply_parentid` int(11) NOT NULL COMMENT '备注:回复的评论id',
  `reply_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:回复人id',
  `post_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  `reply_likenum` int(11) NULL DEFAULT 0 COMMENT '备注:点赞数',
  `reply_reportnum` int(11) NULL DEFAULT 0 COMMENT '备注:举报数',
  `is_delete` tinyint(4) NULL DEFAULT 0 COMMENT '备注:是否被删除',
  `reply_num` int(11) NULL DEFAULT 0 COMMENT '备注:回复数',
  PRIMARY KEY (`reply_id`) USING BTREE,
  INDEX `FK92ig0rv8jv1co1uyekuijl0wg`(`post_id`) USING BTREE,
  CONSTRAINT `FK92ig0rv8jv1co1uyekuijl0wg` FOREIGN KEY (`post_id`) REFERENCES `posttb` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 155 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replytb
-- ----------------------------
INSERT INTO `replytb` VALUES (1, 55, '大家春节期间一定免不了被问到“你是什么专业的？你的专业是干什么的？”\r\n对于很多同学来说，其实是挺难回答的，那么大家都是如何回答的呢？过程中有没有发生有趣的对话分享一下呢？', 0, '2018-12-20 22:22:35', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 1, 1, 0, 9);
INSERT INTO `replytb` VALUES (2, 2, '材料科学，搬砖的TAT', 1, '2018-12-16 23:28:52', '9357593e-02dc-47ab-b304-910e3411a897', 1, 2, 0, 0, 9);
INSERT INTO `replytb` VALUES (3, 3, '通信工程，就是接网线的', 1, '2018-12-16 23:28:53', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (4, 4, '学电子的，就是，就是修手机，修洗衣机的 ', 1, '2018-12-16 23:28:54', '9357593e-02dc-47ab-b304-910e3411a897', 1, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (5, 8, '同材料科学与工程', 2, '2018-12-16 23:28:54', '27a1026f-be4d-4651-9245-578e31d1728a', 1, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (6, 15, '第一个黑的就是接网线的   很尴尬', 3, '2018-12-16 23:28:55', '9357593e-02dc-47ab-b304-910e3411a897', 1, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (7, 11, '需要贷款吗', 4, '2018-12-16 23:28:56', '9357593e-02dc-47ab-b304-910e3411a897', 1, 1, 2, 0, 0);
INSERT INTO `replytb` VALUES (8, 53, '大一那会儿经常听老师说，大学是否是重点不重要，关键看你自己是否努力，努力了，再差的大学也能出人才；自甘堕落的话，清华北大毕业照样找不到工作。一开始我是认同这个观点的，也看了覃彪喜老师的《读大学，究竟读什么》那本书里所言“大学读的不是建筑，不是图书馆的大小……”所以虽然我学校是个普通的一本院校，我一直默默的努力。\r\n\r\n暑假转了一趟云南呈贡大学城，发觉那里的学校都好大。图书馆也特别大，就拿云南中医学院来说，图书馆里二楼的布置特别文艺，四人桌，或者真皮沙发，在里面读书真的是种特别享受的事情。学习氛围也特别好。他们书多，真的很多，呈贡那些大学的图书馆都有很多藏书。而且几个学校相隔不远，消息交流很方便，就像一个人同时上着几个大学的感觉。作为重点学校，就不乏优秀校友和优秀学生，在这样的学校里学习，多多少少也会耳目渲染。\r\n\r\n在这样的环境中，一个人的眼光，格局都会有很大的提高吧。而我们学校，图书馆不大，想看的书也不经常找的到，而且同学们去图书馆一般都是自习，很少是为阅读去的。不过学习的氛围倒也很好的。\r\n\r\n比较之后，我感觉一个大学的好坏，其实对学生的未来有着很大的影响。我知道，我学校也不差，但比起全国的很多高校还是有很大差距。纵然如此，我依旧会坚持努力，起点就比别人低了，如果后天再不努力，真的怕再无逆袭之日了。', 0, '2018-12-21 12:25:18', '9357593e-02dc-47ab-b304-910e3411a897', 2, 2, 2, 0, 14);
INSERT INTO `replytb` VALUES (9, 0, '我觉得就那么一点点影响吧，毕竟师傅领进门修行看个人！', 8, '2018-12-16 23:28:58', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 1, 0, 0, 10);
INSERT INTO `replytb` VALUES (10, 0, '自己是最关键的', 8, '2018-12-16 23:28:59', '9357593e-02dc-47ab-b304-910e3411a897', 2, 2, 0, 0, 0);
INSERT INTO `replytb` VALUES (11, 0, '看到这个题目，不想看里面具体内容了。我坚决我认为，没有关系。', 8, '2018-12-18 12:17:44', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (12, 0, '最重要还是看自己，但是如果所处的环境对自己不利，就一定要想办法给自己找到一个更有利于我们发展的环境。当然这与自己的努力程度一定是有很大关系的。', 8, '2018-12-16 23:29:00', '9357593e-02dc-47ab-b304-910e3411a897', 2, 2, 0, 0, 0);
INSERT INTO `replytb` VALUES (13, 0, '话是这样说没错，不过身边的环境也是非常的重要.', 9, '2018-12-16 23:28:19', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (14, 0, '所以我觉得不是那么重要呢', 9, '2018-12-16 23:28:20', '9357593e-02dc-47ab-b304-910e3411a897', 2, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (15, 0, '办证找我', 9, '2018-12-16 23:28:21', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 0, 1, 0, 0);
INSERT INTO `replytb` VALUES (16, 0, '我很同意你的看法', 10, '2018-12-16 23:28:22', '9357593e-02dc-47ab-b304-910e3411a897', 2, 2, 0, 0, 0);
INSERT INTO `replytb` VALUES (17, 0, '确实是的，没有关系', 11, '2018-12-16 23:28:33', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (18, 4, '读到老，学到老；但读书是追求简而精，还是多而杂呢？', 0, '2018-12-19 19:47:05', '27a1026f-be4d-4651-9245-578e31d1728a', 3, 1, 1, 0, 7);
INSERT INTO `replytb` VALUES (19, 0, '我觉得读书的广泛涉猎是多读书多读好书并且不是功利性的读书，这些都是潜移默化的，那么这个角度出发书读的杂和多没有什么问题，而简而精是从你的核心竞争力角度出发，多度与你专业相关与你职业发展相关的书，要精度要细读要深入阅读。', 18, '2018-12-18 12:17:47', '27a1026f-be4d-4651-9245-578e31d1728a', 3, 1, 0, 0, 7);
INSERT INTO `replytb` VALUES (20, 0, '后者，会让你阅历更丰富，但是专业书的话就是前者啦！', 18, '2018-12-18 12:17:50', '9357593e-02dc-47ab-b304-910e3411a897', 3, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (21, 0, '精读和泛读是可以并存的，但我一般都习惯精读了。', 18, '2018-12-18 12:17:49', '27a1026f-be4d-4651-9245-578e31d1728a', 3, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (22, 0, '问题来了，什么样的书才是好书呢？多读想读的书就行吧', 19, '2018-12-18 12:17:53', '9357593e-02dc-47ab-b304-910e3411a897', 3, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (23, 0, '有些人觉得鸡汤文的书是烂书，就如有些人觉得有些电影是烂片，但是烂片有些人看了还是会笑，还是会感动，就如鸡汤文有些人看了会励志，会安慰，这没有绝对好与坏的区分，关键还是得你自己怎么去看待。', 19, '2018-12-18 12:17:54', '27a1026f-be4d-4651-9245-578e31d1728a', 3, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (24, 0, '你是煞笔吗，跟专业有什么关系', 19, '2018-12-18 12:17:55', '9357593e-02dc-47ab-b304-910e3411a897', 3, 0, 2, 0, 0);
INSERT INTO `replytb` VALUES (25, 0, '我阅历丰富可以说就是靠后者还有中央台。哈哈哈哈', 20, '2018-12-18 12:17:58', '27a1026f-be4d-4651-9245-578e31d1728a', 3, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (26, 3, '1.练习口语   \r\n   \r\n在线英语： https://dwz.cn/1XHGmL\r\n（免费在线口语课领取，外教一对一交流互动~）  \r\n2、练习听力   \r\n   \r\n美国国家公共广播电台NPR：https://www.npr.org/  \r\n3、练习发音   \r\n   \r\n韦伯字典：https://www.m-w.com/   \r\n4、记忆单词   \r\n   \r\n我要模考网词汇练习：https://www.51mokao.com/index.html \r\n5、练习阅读   \r\n路透社：https://www.reuters.com/ ', 0, '2018-12-18 12:17:57', '27a1026f-be4d-4651-9245-578e31d1728a', 4, 0, 0, 0, 4);
INSERT INTO `replytb` VALUES (27, 0, '哇 妈妈再也不用担心的我英语了', 26, '2018-12-18 12:18:01', '27a1026f-be4d-4651-9245-578e31d1728a', 4, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (28, 0, '很不错 赞', 26, '2018-12-18 12:18:02', '9357593e-02dc-47ab-b304-910e3411a897', 4, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (29, 0, '收下了  收下了', 28, '2018-12-18 12:18:03', '27a1026f-be4d-4651-9245-578e31d1728a', 4, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (30, 0, '月亮，是张爱玲很喜欢运用的一个意象。在中国传统文化之中，月升月落、月缺月圆，无不体现着人世的变化无常，人生的悲欢离合，这种由月亮带来的苍苍茫茫之感，很符合张爱玲在文章中体现的“苍凉”的审美情趣。\r\n\r\n\r\n月的形象在张爱玲的文本中不胜枚举：“今天晚上有月亮，稍带长圆形的，像一颗白净的莲子似的月亮，四周白蒙蒙地发出一圈光雾。”“莲子”似的月亮，是《半生缘》中恋爱的少女眼中的月亮；“薇龙向东走，越走，那月亮越白，越晶亮，仿佛是一头肥胸脯的白凤凰，栖在路的转弯处，在树桠叉里做了窠……”“白凤凰”似的月亮，是《沉香屑 第一炉香》里行夜路的葛薇龙眼中的月亮；还有诸如“赤金的脸盆”、“玉色缎子上刺绣时弹落了一点灰色”、“冰破处的银灿灿的一汪水”等等别出心裁的比喻不一而足。这些月亮有着分明不同的形态、颜色、质感与温度，被点缀在了张爱玲不同文本的夜空之中，恰如其分的照亮了不同故事主人公的面庞与身影。', 0, '2018-12-18 12:18:04', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0, 0, 0, 4);
INSERT INTO `replytb` VALUES (31, 0, '楼主读的真细啊！简直就是一篇好论文。', 30, '2018-12-18 12:18:05', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (32, 0, '姨母，我喜欢林徽因，感觉张爱玲有点苦，林徽因才是幸福滴...但是看不懂她...', 30, '2018-12-18 12:18:29', '27a1026f-be4d-4651-9245-578e31d1728a', 5, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (33, 0, '林太太的客厅确实很令人向往呢~', 32, '2018-12-18 12:18:05', '9357593e-02dc-47ab-b304-910e3411a897', 5, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (34, 0, '看了这帖子搞得我想起看张爱玲的书了', 32, '2018-12-18 12:18:39', '27a1026f-be4d-4651-9245-578e31d1728a', 5, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (35, 0, '到底从哪天开始的，迷茫成了一个时髦的词了？\r\n尤其是大学生。\r\n大一的时候，不喜欢这个学校，我很迷茫。\r\n大二的时候，不喜欢这个专业，我很迷茫。\r\n大三的时候，换专业来不及了，我很迷茫。\r\n大四的时候，不知道找什么工作，我很迷茫。\r\n流行的说法是，谁的青春不迷茫。\r\n我告诉你谁的青春不迷茫，牛逼的人不迷茫。\r\n因为他们很早就明白自己要什么，然后义无反顾去执行了。\r\n因为人家把你浪费在迷茫上的时间，拿去全力以赴地努力了。\r\n而你，没有全身心去投入一件事，做每一件事都患得患失，生怕付出了没有回报，于是，你花了好几年来迷茫，以及炫耀自己的迷茫。\r\n恕我直言，特么你迷茫你还好意思了，你还了不起了？\r\n迷茫只是你不努力、不上进、不坚定的借口。', 0, '2018-12-18 12:18:40', '9357593e-02dc-47ab-b304-910e3411a897', 6, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (36, 0, '代考吗', 35, '2018-12-18 12:18:41', '9357593e-02dc-47ab-b304-910e3411a897', 6, 0, 1, 0, 0);
INSERT INTO `replytb` VALUES (37, 0, '说的不错，值得思考！', 35, '2018-12-18 12:18:42', '27a1026f-be4d-4651-9245-578e31d1728a', 6, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (38, 0, '慕课可以取代普通高校的存在了吗？ ', 0, '2018-12-18 12:18:44', '9357593e-02dc-47ab-b304-910e3411a897', 7, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (39, 0, '可以，慕课是个很棒的网站', 38, '2018-12-18 12:18:45', '27a1026f-be4d-4651-9245-578e31d1728a', 7, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (40, 0, '不可以，学校能让你明白更多的道理，为人处事方面等等', 38, '2018-12-18 12:18:47', '9357593e-02dc-47ab-b304-910e3411a897', 7, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (41, 0, '人人都向往大学，当真正变成了一名大学生却发现大学和自己想象的不一样，如何能融入大学生活，并且在几年大学生活不留遗憾呢', 0, '2018-12-18 12:18:47', '9357593e-02dc-47ab-b304-910e3411a897', 8, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (42, 0, '明确自己的目标，记得时时做权衡，就可以了。', 41, '2018-12-18 12:18:49', '27a1026f-be4d-4651-9245-578e31d1728a', 8, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (43, 0, '低调做人，高调做事', 41, '2018-12-18 12:18:50', '9357593e-02dc-47ab-b304-910e3411a897', 8, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (44, 9, ' 一件事情的成功有三个条件:方向，方法，行动。学习也是一样，我们来慕课学习，怎样才能提高效率呢？希望大家可以说说适合自己的高效方法，或许能帮到和你一样的人。', 0, '2018-12-21 12:21:43', '9357593e-02dc-47ab-b304-910e3411a897', 9, 1, 0, 0, 3);
INSERT INTO `replytb` VALUES (45, 0, '高效学习法有书专门介绍，也有工具，比如思维导图', 44, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 9, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (46, 3, '坚持，二字，说来容易，做起来难。但有时候，我们却没有退路，只能闷头向前，因为逼迫我们向前走的不是前方梦想的万丈光芒，而是身后现实的万丈深渊。生活就像这张照片，累么，累！ 为什么不放手… 这特么的能放手么？\r\n我想这就是我坚持的意义吧，你坚持的意义又是什么呢？\r\n\r\n\r\n', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 10, 2, 0, 0, 4);
INSERT INTO `replytb` VALUES (47, 0, '为了成为更好的自己', 46, '2018-12-19 23:12:49', '27a1026f-be4d-4651-9245-578e31d1728a', 10, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (48, 0, '让自己变的更加优秀', 47, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 10, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (50, 0, '选修过神奇的选修课不计其数：\r\n\r\n\r\n大一的时候选了一门植物鉴赏，因为自己分到的种子总是不发芽，最后差点不及格……〒▽〒这么任性的考评也是没有谁了！\r\n\r\n\r\n', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 12, 0, 0, 0, 2);
INSERT INTO `replytb` VALUES (51, 0, '《中医与美容》我选了还没开课，不过我已看完视频', 50, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 12, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (52, 0, '这门课很适合轻松休闲的时候看呢~', 51, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 12, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (53, 3, '每次选择电影的时候，总是习惯性地看看豆瓣电影对此片的评分及评论，所以，我想我们在选择慕课的时候，都会先选择自己熟悉的或者喜欢的，而对于陌生的领域，如果有人可以推荐一下，会让我有一种预热或者提前了解的感觉。所以，希望大家可以推荐一下你们喜欢的课程，作为后续课程选择的参考。谢谢大家了！', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 13, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (54, 0, '心理学', 53, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 13, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (55, 0, '我参加过《心理学与生活》，以及《沟通心理学》感觉都还不错。', 54, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 13, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (56, 2, '中国茶道，这门课，学习难度高，但在课程中可以学会很多东西，比如修养，修身，礼仪，同时还能更好的提高我们对美学的认识，还有其他的学课都可以，不仅学到了有关茶的知识还学到了美的知识', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 14, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (57, 0, '情商高的体现有时候是心机 厚黑的表现 ', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 15, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (58, 0, '在生活中与其他人发生矛盾时，情商高的人可以处理得很好，让大家都觉得有所得而开心。', 57, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 15, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (59, 0, '都说：“读到老，学到老”，而现实生活中有几个从心底里真正喜欢学习的。不知道什么时候，总觉得学习是我生活的一项任务，看书没有最初的那种乐趣，学习似乎也不是为了小时候天真的梦想，我们都在逼着自己做着不是那么喜欢的事。今天我想请问一下大家，学习为什么而学的状态是最好的呢？', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 16, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (60, 0, '目标性太强的学习不太好，这样真正吸收到的东西很少', 59, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 16, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (61, 0, '因为喜欢而学习，尝试从学习中获取乐趣。我觉得大多数学科，大多数知识都是有趣。', 59, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 16, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (62, 0, '都有啊，一个是客观上要求，一个是主观上想学', 59, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 16, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (63, 0, ' 在刚为适合经济学零基础人群的推荐读物【我最喜欢的一本书】《生活中的经济学》这个帖子中，我从贝克尔的学术经历和这本书以理论结合实例这种双管齐下的方式所讲授的经济学知识中学到的一点是，要想提高自己的经济学素养，在证书通胀这一与他人进行生死竞速的比赛中不被淘汰，光读一本好书是不够的。读好书仅仅可以让人勉强生存，在社交时别人提到和经济学有关的东西的时候，和他人至少有一点谈资。而通过对好书提到的知识点进行拓展延伸则可以让一个人很好的生存，丰富一个人的视野，提高一个人的求知欲，更新自己的技能储备。俗话说：“天干三年，饿不死手艺人”，艺多不压身。下面我就谈谈如何利用网上的好资源以提高个人的经济学素养。', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 17, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (64, 0, 'tephen R. Covey博士曾说过：“你无法决定你人生最终会变成什么样子，你无法决定别人如何对待你，你无法决定自己的健康状况，你同样也无法决定自己可以赚多少钱，但是系统可以。”\r\n\r\n\r\n', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 18, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (65, 0, '学生时代，每个班级都会有那么几个人，人缘好到爆，不管去哪都能拉上一群人，班级活动，他们永远是最活跃的。\r\n\r\n \r\n\r\n他们性格开朗，能说会道，可以和老师称兄道弟，可以和同学勾肩搭背。酒桌上，懂得说漂亮的敬酒词；活动上，懂得如何活跃气氛。他们似乎认识很多人，很多人也认识他们，他们总能在路上和各种形形色色的、我见过没见过的人热情地打招呼。他们似乎有接不完的电话、回不完的信息。\r\n\r\n \r\n\r\n我曾经特别渴望成为他们这种人，和周围的人打成一片，照顾身边每一个人的情绪，对所有的求助都会回应，即使遭受误解也能一笑而过，跟所有人都有话聊，不把喜怒伤悲表现在脸上。\r\n\r\n \r\n\r\n我羡慕他们的八面玲珑，我羡慕他们的“滥好人”。我想，他们是不会孤独的吧，他们不会找不到人一起吃饭，他们生病不会找不到人陪，他们遇到困难不会找不到人帮忙，他们节假日不会有“不知道去哪”的惆怅…… \r\n\r\n\r\n于是，我也试图做一个这样的人，讨好身边的每一个人，努力迎合别人的期待，活跃在课堂上聚会上，尽力解决身边人的大事小事。\r\n\r\n \r\n\r\n为了在她们聊天时我能插上一两句话，看她们看的小说，追她们追的韩剧综艺，我以为这是存在感。\r\n\r\n \r\n\r\n舍友去逛街、去游乐场需要陪伴，我都会放下手中的事情，舍命相陪，我以为这是讲义气。酒桌上学会察言观色，强颜欢笑，推杯换盏，我以为这是攒人脉。\r\n\r\n \r\n\r\n别人指着你的痛处短板打趣，只能尴尬地附和着，连生气的勇气都没有，因为怕别人说我开不起玩笑。\r\n\r\n \r\n\r\n别人玩某一款游戏、吃某一种零食、买哪一类衣服，我也要跟着，因为怕别人说我不懂潮流。明明笑话不好笑，我也要跟着哈哈大笑，因为怕别人说我笑点高扫大家的兴。\r\n\r\n \r\n\r\n宁可牺牲自己，也要对他人友善，换来所谓的好人缘。身边的确开始围绕一些人，有人陪着吃喝玩乐，有人陪着上课下课，可是却没有一个能说心里话的。\r\n\r\n \r\n\r\n有些事藏在心里是莫大的委屈，话到嘴边又觉得无足挂齿不值一提。每到夜深人静的时候，孤独感依然无孔不入。\r\n\r\n \r\n\r\n原来努力合群的我一点都不快乐。 \r\n\r\n那天看到余华写的一段话：“我不再装模作样地拥有很多朋友，而是回到孤单之中，以真正的我开始了独自的生活。有时我也会因为寂寞，而难以忍受空虚的折磨，但我宁愿以这样的方式来维护自己的自尊，也不愿以耻辱为代价去换取那种表面的朋友。”\r\n\r\n \r\n\r\n我终于明白，消耗大量时间精力换来的“你人真好”，这样的群，合而无用，只是在浪费生命罢了。任何一段关系都不应该是雪中送炭，而是锦上添花。\r\n\r\n 人脉从来不是靠酒桌上的故意迎合说大话而来的，志同道合的朋友都是吸引来的。丰富自己比取悦别人更重要。\r\n\r\n \r\n\r\n不要去追一匹马，用追马的时间种草，待到春暖花开时，就会有一批骏马任你挑选。\r\n\r\n 融入不了别人没什么，不合群也不可怕，可怕的是没有自己的想法，人云亦云，随波逐流。鲁迅说：牛羊才成群结队，猛兽都是独行。\r\n\r\n 又何尝不是这样呢？孤独从来不会毁了一个人，更多的人因孤独而优秀。\r\n\r\n 苏东坡是孤独的，所以才有了后来的大江东去的千古名作；司马迁是孤独的，所以才有了 “史家之绝唱，无韵之离骚”之称的《史记》；爱因斯坦是孤独的，所以才有了相对论的产生……\r\n\r\n当我不再为了合群而合群，不再为了迎合别人而委屈自己，不再为了陪伴别人而牺牲自己，我有了更多的时间做自己喜欢的事情，看书、写作、旅行，一切都按照自己的节奏进行。我发现这样不合群的自己反而更充实更快乐。\r\n\r\n 我不在意她们异样的眼光，我不在意她们活动不叫我，每个人都有选择自己生活的权利，每个人都有适合自己的生活频率，只是恰好我的频率跟她们不一样。\r\n\r\n岩井俊二说：“以前想要的，现在全都不想要了。要是三年前你问我想成为什么样的人， 我一定不假思索地说，我想成为与所有人都能打成一片的人。要是你今天再问我同一个题，我肯定说，我还是维持现在清高冷傲的现状就好了。这样没有人来打扰我，省掉了许多麻烦。唯一需要克服的，就是得耐得住寂寞。”\r\n\r\n \r\n\r\n我们都是孤独的行路人，与星辰做伴，与虫鸟相依，只有凭借自己的力量走过一段又一段漆黑的路，度过一段又一段连自己都会被感动的日子，你才会拥有柳暗花明的豁达与乐观。\r\n\r\n \r\n\r\n当我独自走了很长一段路后，回过头看那些踏过的深深浅浅的足迹，每一步都扎实有力，而那些我曾经无数次想融入却没融入的圈子早已被我甩在了后面，迎接我的是更好的自己、更大的舞台。\r\n\r\n \r\n\r\n就像《生活大爆炸》里面说的：“或许你在学校格格不入，或许你在学校最矮最胖，或许你没有任何朋友，但其实都无所谓。那些你独自一人度过的时间，比如组装电脑，或者练习大提琴，会让你变得更加有趣。等到有一天，别人终于注意到你的时候，他们会发现一个比他们想象中更酷的人。”\r\n\r\n \r\n\r\n其实，不合群的你真的很酷。', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 19, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (66, 0, '“别人笑我太疯癫，我笑他人看不穿。不见五陵豪杰墓，无花无酒锄做田。”\r\n\r\n很多人会疑惑，我为什么要以这样的一首诗作为开始，而我同样疑惑为什么会有那么多人对于我在慕课的学习、我的努力满是戏虐之词。难道工作了之后就不该学习了么？还是觉得我已然35岁了？亦或是觉得，我只是一个司机，我再努力又有何用？\r\n\r\n诚然，82年出生的我35岁了，从小对于学习这件事简直视若瘟神，避之惟恐不及，勉强的在“野鸡”学校混了个中专的毕业证书，19岁便踏足社会。我做过服务生、保安、开过出租车，没有目标，没有方向。那时候我的梦想只是有朝一日可以得到上天的眷顾，从而出人头地。然而，那终究只是一个梦而已。2009年我和爱人结婚了，我很庆幸那样的自己在当今社会竟然没有被剩下，还有人愿意“解救”我。刚结婚的第一年，我依然开着出租车，爱人在幼儿园打工。起初，我并没有觉得这样的生活有什么不好，毕竟身边的很多朋友也是如此。但随着时间的推移，当我看到身边有些朋友已经开始在各行各业崭露头角的时候，我开始重新审视自己的生活。我会经常问自己，我难道甘心一辈子如此么？这就是我想过的人生么？这时候我才真正的意识到，我错失了很多东西，我不能再这样继续下去，我需要为今后的生活而努力。\r\n\r\n机缘巧合，我得到了一个可以到我们当地知名企业工作的机会，但学无所成的我只能继续从事我的老本行“司机”。但是我并没有如其他司机一样安守本分，我开始利用闲暇时间养成阅读的习惯，当我真正把阅读当作乐趣的时候，我才体会到自己是多么的无知。我努力着，坚持着。令人兴奋的是，这一切都没有白费，入职的第四年，我被任命为集团公司董事长的司机。面对流言蜚语，我常报以微笑。你们永远只看到别人光鲜的一面，而忽略别人的努力。你们永远都不知道，当你们打游戏的时候，我在做什么。当你们闲侃胡吹的时候，我在做什么。当你们躺在床上看电视的时候，我在做什么。是的，在公司里作为司机这个工种，我已然做到了极致。但这不是我的目标，我不能做一辈子司机，我需要转型。虽然，我起步阶段比其他人慢了几拍，但这不能成为我不去努力的理由。我依然会努力并坚持。\r\n\r\n前不久，我在下载某云课堂的时候，无意中安装了慕课软件，这简直给我开辟了另一条道路。我一口气报了7.8门课程，市场营销学，互联网+管理学，老子的智慧......我恨不得把我从前缺失的知识，一口气补回来。每天仔细的听讲，抄录课件，觉得自己的生活又充实了好多。由于我和别人共用一个办公室，所以相对比较开放，每天很多人进进出出。有一部分人会比较尊重你，但更多的则是戏谑、调侃。可能在你们看来，像我这样的人很难有所成就，或者我这样的学习方法根本不会取得什么结果，我只是做做样子而别人看而已。我只能继续以微笑待之，“燕雀焉知鸿鹄之志”。\r\n\r\n常听人提起“二八定律”，我们每个人都想成为那百分之二十，但又有多少人真的去了解过，他们是如何达到那个高度的呢？“临渊羡鱼，不如退而结网。”不要只羡慕别人的成就，更应该看到别人的付出。你现在可以戏虐我，调侃我。那么，十年后呢？\r\n\r\n很喜欢知乎上的一句话“种一棵树最好的时机，是十年前。其次，便是现在。”', 0, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 20, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (67, 0, '努力就不会晚', 66, '2018-12-19 23:12:49', '9357593e-02dc-47ab-b304-910e3411a897', 20, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (122, 0, 'asfadfadfadf', 1, '2018-12-18 11:34:26', '9357593e-02dc-47ab-b304-910e3411a897', 1, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (123, 0, '<img src=\"http://localhost/ieppage/bbs/layui/images/face/4.gif\" alt=\"[可怜]\">', 1, '2018-12-18 11:45:01', '9357593e-02dc-47ab-b304-910e3411a897', 1, 1, 0, 0, 0);
INSERT INTO `replytb` VALUES (129, 0, 'aaa', 11, '2018-12-20 21:16:46', '9357593e-02dc-47ab-b304-910e3411a897', 2, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (130, 0, 'aaa', 45, '2018-12-21 12:22:17', '9357593e-02dc-47ab-b304-910e3411a897', 9, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (131, 0, 'aaaa', 44, '2018-12-21 12:22:40', '9357593e-02dc-47ab-b304-910e3411a897', 9, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (144, 3, 'aa', 0, '2019-01-06 11:21:36', '27a1026f-be4d-4651-9245-578e31d1728a', 48, 1, 0, 1, 6);
INSERT INTO `replytb` VALUES (145, 0, '哈哈哈', 8, '2019-01-06 11:42:31', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 0, 0, 0, 1);
INSERT INTO `replytb` VALUES (146, 0, '呵呵呵呵', 145, '2019-01-06 11:43:14', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (147, 0, 'aaaaa', 144, '2019-01-06 14:18:07', '27a1026f-be4d-4651-9245-578e31d1728a', 48, 0, 0, 1, 0);
INSERT INTO `replytb` VALUES (148, 0, '<img src=\"http://localhost/bbs/layui/images/face/27.gif\" alt=\"[疑问]\">', 8, '2019-01-06 17:20:50', '27a1026f-be4d-4651-9245-578e31d1728a', 2, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (150, 0, '<img src=\"http://localhost/bbs/layui/images/face/40.gif\" alt=\"[晕]\">', 144, '2019-01-06 20:50:05', '27a1026f-be4d-4651-9245-578e31d1728a', 48, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (151, 0, '呵呵呵<br>', 144, '2019-01-06 23:57:47', '27a1026f-be4d-4651-9245-578e31d1728a', 48, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (152, 0, '啥啥啥<br>', 46, '2019-01-07 00:00:43', '27a1026f-be4d-4651-9245-578e31d1728a', 10, 0, 0, 0, 1);
INSERT INTO `replytb` VALUES (153, 0, '啊啊啊', 152, '2019-01-07 00:01:04', '27a1026f-be4d-4651-9245-578e31d1728a', 10, 0, 0, 0, 0);
INSERT INTO `replytb` VALUES (154, 0, '<img src=\"http://127.0.0.1/bbs/layui/images/face/0.gif\" alt=\"[微笑]\">gfgh', 0, '2019-01-07 11:41:37', '27a1026f-be4d-4651-9245-578e31d1728a', 50, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for reporttb
-- ----------------------------
DROP TABLE IF EXISTS `reporttb`;
CREATE TABLE `reporttb`  (
  `report_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `report_reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:举报理由',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:用户id',
  `reply_id` int(10) UNSIGNED NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`report_id`) USING BTREE,
  INDEX `FKl6ptbyf9t0vbchrn35w1a5s4g`(`reply_id`) USING BTREE,
  CONSTRAINT `FKl6ptbyf9t0vbchrn35w1a5s4g` FOREIGN KEY (`reply_id`) REFERENCES `replytb` (`reply_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reporttb
-- ----------------------------
INSERT INTO `reporttb` VALUES (2, '有诱导信息', '9357593e-02dc-47ab-b304-910e3411a897', 36);
INSERT INTO `reporttb` VALUES (3, '敏感词汇', '9357593e-02dc-47ab-b304-910e3411a897', 24);
INSERT INTO `reporttb` VALUES (4, '诈骗信息', '9357593e-02dc-47ab-b304-910e3411a897', 15);
INSERT INTO `reporttb` VALUES (19, '单方事故', '9357593e-02dc-47ab-b304-910e3411a897', 17);
INSERT INTO `reporttb` VALUES (20, '是大法官', '9357593e-02dc-47ab-b304-910e3411a897', 19);
INSERT INTO `reporttb` VALUES (25, '答复', '9357593e-02dc-47ab-b304-910e3411a897', 18);
INSERT INTO `reporttb` VALUES (27, 'asd', '9357593e-02dc-47ab-b304-910e3411a897', 11);
INSERT INTO `reporttb` VALUES (28, 'asd', '9357593e-02dc-47ab-b304-910e3411a897', 8);
INSERT INTO `reporttb` VALUES (29, 'meiyong', '9357593e-02dc-47ab-b304-910e3411a897', 1);
INSERT INTO `reporttb` VALUES (30, '垃圾', '27a1026f-be4d-4651-9245-578e31d1728a', 122);
INSERT INTO `reporttb` VALUES (31, 'asd', '27a1026f-be4d-4651-9245-578e31d1728a', 8);
INSERT INTO `reporttb` VALUES (32, 'asdasd', '27a1026f-be4d-4651-9245-578e31d1728a', 24);

-- ----------------------------
-- Table structure for typetb
-- ----------------------------
DROP TABLE IF EXISTS `typetb`;
CREATE TABLE `typetb`  (
  `type_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `type_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注:类型描述',
  `type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注:类型名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of typetb
-- ----------------------------
INSERT INTO `typetb` VALUES (1, '非常好的帖子', '精选');
INSERT INTO `typetb` VALUES (2, '非常好的帖子', '课程问答');
INSERT INTO `typetb` VALUES (3, '非常好的帖子', '交流讨论');
INSERT INTO `typetb` VALUES (4, '非常好的帖子', '技术分享');
INSERT INTO `typetb` VALUES (5, '非常好的帖子', '实验报告');
INSERT INTO `typetb` VALUES (6, '非常好的帖子', '站内公告');

SET FOREIGN_KEY_CHECKS = 1;
