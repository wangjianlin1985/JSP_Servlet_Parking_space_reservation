/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : jsp_tccg

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-01-08 22:47:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `t_chewei`
-- ----------------------------
DROP TABLE IF EXISTS `t_chewei`;
CREATE TABLE `t_chewei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) DEFAULT NULL,
  `quyu` varchar(50) DEFAULT NULL,
  `zt` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_chewei
-- ----------------------------
INSERT INTO `t_chewei` VALUES ('15', '001', 'A区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('16', '002', 'A区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('17', '003', 'A区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('18', '004', 'A区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('19', '005', 'B区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('20', '006', 'B区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('21', '007', 'C区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('27', '008', 'C区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('28', '009', 'C区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('29', '010', 'D区', '空闲中', 'no');
INSERT INTO `t_chewei` VALUES ('30', '011', 'D区', '空闲中', 'no');

-- ----------------------------
-- Table structure for `t_liuyan`
-- ----------------------------
DROP TABLE IF EXISTS `t_liuyan`;
CREATE TABLE `t_liuyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `neirong` varchar(200) DEFAULT NULL,
  `liuyanshi` varchar(2000) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `huifu` varchar(50) DEFAULT NULL,
  `huifushi` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_liuyan
-- ----------------------------
INSERT INTO `t_liuyan` VALUES ('12', 'v让大家说测试阿测试', '2019-02-14 16:13', '1341738056235', '', '');
INSERT INTO `t_liuyan` VALUES ('13', '你好，我是测试', '2019-09-26 11:54', '1341738056235', '', '');

-- ----------------------------
-- Table structure for `t_ting`
-- ----------------------------
DROP TABLE IF EXISTS `t_ting`;
CREATE TABLE `t_ting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chewei_id` int(11) DEFAULT NULL,
  `chexing` varchar(50) DEFAULT NULL,
  `chepai` varchar(50) DEFAULT NULL,
  `kaishishijian` varchar(50) DEFAULT NULL,
  `jieshushijian` varchar(50) DEFAULT NULL,
  `feiyong` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ting
-- ----------------------------
INSERT INTO `t_ting` VALUES ('8', '15', '小型', '京123456', '2019-02-15 21:40', '2019-02-15 21:40', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(50) NOT NULL,
  `loginname` varchar(50) DEFAULT NULL,
  `loginpw` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `zhuzhi` varchar(255) DEFAULT NULL,
  `dianhua` varchar(255) DEFAULT NULL,
  `dengji` varchar(255) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1341738056235', 'xiaoli', '123456', '刘三', '海尔路', '13555555555', '普通会员', 'no');
INSERT INTO `t_user` VALUES ('1349561912254', 'liqian', '000000', '李强', '山东路', '13666666666', '普通会员', 'no');

-- ----------------------------
-- Table structure for `t_yuding`
-- ----------------------------
DROP TABLE IF EXISTS `t_yuding`;
CREATE TABLE `t_yuding` (
  `id` varchar(50) NOT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `dianhua` varchar(8000) DEFAULT NULL,
  `daodashi` varchar(50) DEFAULT NULL,
  `chewei_id` int(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `zt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yuding
-- ----------------------------
INSERT INTO `t_yuding` VALUES ('1487165997496', '刘三', '13222222222', '2019-02-15 22:30', '15', '1341738056235', '已受理');
INSERT INTO `t_yuding` VALUES ('1569470091519', '小李', '13022502404', '2019-09-26 12:24', '17', '1341738056235', '已受理');

-- ----------------------------
-- Table structure for `t_zhengce`
-- ----------------------------
DROP TABLE IF EXISTS `t_zhengce`;
CREATE TABLE `t_zhengce` (
  `id` varchar(50) NOT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(8000) DEFAULT NULL,
  `fujian` varchar(50) DEFAULT NULL,
  `shijian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zhengce
-- ----------------------------
INSERT INTO `t_zhengce` VALUES ('1486966835743', '测试阿测试测试阿测试测试阿测试测试阿测试', '测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试测试阿测试', '/images/zanwu.jpg', '2019-02-13');
INSERT INTO `t_zhengce` VALUES ('1486967039387', '唐山火车站：市民开车接送站可以这样进出停车了', '<p>近日，记者跟随市公安交警支队八大队民警及铁路唐山站有关人员来到火车站西广场，对接送旅客车辆进出站及停车问题进行实地走访竹安路和辅路禁止停车<br />\r\n&nbsp;<br />\r\n唐山火车站西广场位于竹安路(南新道与北新道路段中间)，去西广场的车辆可经由南新道、北新道驶入竹安路前往。记者在竹安路(火车站西广场段)看到，交警八大队民警正对部分停放在道路两侧的出租车及社会车辆进行治理：驾驶人在车上的被告知此处禁止停车并将其劝离；驾驶人不在的贴单罚款。交警八大队民警告诉记者：此处有禁停标志，禁止停车。<br />\r\n&nbsp;<br />\r\n记者在火车站西广场看到该广场设有南北辅路。南辅路设有&ldquo;商业货运&rdquo;&ldquo;出租车&rdquo;&ldquo;地下停车场&rdquo;和2条&ldquo;火车站进站口&rdquo;等多条进入广场的车道。记者在广场南辅路看到有数辆社会车辆停在路边，经询问，这些车辆大部分因距离旅客下车时间短而不愿进入地下停车场，所以在此等候。交警八大队民警随即将这些车辆劝离，指挥其前往地下停车场停车。<br />\r\n&nbsp;</p>', '/images/zanwu.jpg', '2019-02-13');
INSERT INTO `t_zhengce` VALUES ('1486967092768', '火车站西广场20日投入使用 交警告诉你该咋走', '<p>记者在现场看到，车辆由竹安路与火车站西广场西南侧入口进入后，由绿化带隔离出双向8条车道：绿化带以南由西向东方向5条车道是进站车道；绿化带以北由东向西方向3条车道是出站车道。所有进站车辆都需由进站通道驶入；除火车站地上二层以外的车辆都需由出站通道驶出。5条进站通道自南向北分别标注为&ldquo;商业货运、&rdquo;&ldquo;出租车&rdquo;&ldquo;地下停车场&rdquo;和&ldquo;火车站入口&rdquo;(其中&ldquo;火车站入口&rdquo;为2条车道)。&ldquo;商业货运&rdquo;车道专供商业用车使用，其他车辆禁止通行；出租车专用车道只供出租车通行，该车道直接通往地下一层停车场(地下一层停车场东南区域为出租车专用区域)；&ldquo;地下停车场&rdquo;车道供社会车辆通行，接送乘客的社会车辆可由此车道驶入地下2层停车场；乘客可在地下一层或二层停车场下车后乘电梯或步行走楼梯到达火车站二楼；&ldquo;火车站入口&rdquo;2条车道供车辆驶上火车站二楼送客平台，在二楼平台上临时预设有4条车道，接送乘客车辆需沿指示行驶到车站北侧出站通道进入竹安路。沿&ldquo;商业货运、&rdquo;&ldquo;出租车&rdquo;&ldquo;地下停车场&rdquo;车道行驶的车辆需按指示由绿化带以北3条出站车道驶出。</p>\r\n<p>在西北出入口，由绿化带隔离出南3、北4共7条出、入车道。绿化带以南为3条进站车道，车辆由西向东驶入50米后需右转进入地下停车<br />\r\n&nbsp;</p>', '/images/zanwu.jpg', '2019-02-13');
