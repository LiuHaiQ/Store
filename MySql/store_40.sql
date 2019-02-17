/*
Navicat MySQL Data Transfer

Source Server         : 1111
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : store_40

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-02-17 21:19:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` varchar(32) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '手机数码');
INSERT INTO `category` VALUES ('2', '电脑办公');
INSERT INTO `category` VALUES ('3', '家具家居');
INSERT INTO `category` VALUES ('4', '鞋靴箱包');
INSERT INTO `category` VALUES ('5', '图书音像');
INSERT INTO `category` VALUES ('afdba41a139b4320a74904485bdb7719', '汽车用品');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `oid` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('74B0878570F84533AF782735B3B6BD0E', '1', '1398', '7', 'AACDBD0727F34B70AC5E81B3BEFABED5');
INSERT INTO `orderitem` VALUES ('A71059E33B364F6584134F922B40E22C', '2', '4596', '11', 'AACDBD0727F34B70AC5E81B3BEFABED5');
INSERT INTO `orderitem` VALUES ('A60683FA2F27420EAC62D08A33991226', '3', '7797', '10', '9E0D71A90F4E4874B969F4F763C7E443');
INSERT INTO `orderitem` VALUES ('CFD606D0FFF04FFBBBE5F840002424D9', '2', '6598', '37', '9E0D71A90F4E4874B969F4F763C7E443');
INSERT INTO `orderitem` VALUES ('4B11AEE8B3424FB99165282A57A418A7', '2', '4596', '11', '9E0D71A90F4E4874B969F4F763C7E443');
INSERT INTO `orderitem` VALUES ('CAE69EC85A364AE58E290C367C890EA3', '2', '2598', '1', '9E0D71A90F4E4874B969F4F763C7E443');
INSERT INTO `orderitem` VALUES ('8C12386314DF40CFA5775E01D56E4059', '4', '5592', '7', '1C6DA0EDCBFA43C288EC24F61C559FD8');
INSERT INTO `orderitem` VALUES ('D5970B5FB5B54BEC93D38AC44791FB68', '2', '4596', '11', 'AC7F96E723ED4278A7D2F9A8338197E8');
INSERT INTO `orderitem` VALUES ('80BB2A6AC88B44CA999C60913AB6372D', '1', '2299', '50', '768EB13433984CBABF9881452B8C8FEB');
INSERT INTO `orderitem` VALUES ('44B804BCAAB241B084C6181306771D96', '1', '2599', '10', '26742421C2A84DB6A78C819A7EA257A8');
INSERT INTO `orderitem` VALUES ('8BEA6C9D38424074832463997ECD8D70', '11', '19789', '12', '59A04DB979264D878637F60C2238ECB6');
INSERT INTO `orderitem` VALUES ('78238FFD4F4B41879E2FCB20C3C7EE46', '1', '1299', '1', '59A04DB979264D878637F60C2238ECB6');
INSERT INTO `orderitem` VALUES ('AB44EB9C284C4A29B1E581B5DA2203AB', '1', '2599', '14', '129C2CDBA2174ED99DE265765B2D2972');
INSERT INTO `orderitem` VALUES ('828021F710F54E6ABC8607B103F63D3A', '1', '2599', '10', '97F250AB127443E9953BE6C279D77365');
INSERT INTO `orderitem` VALUES ('1331A168F19A4A71A485C5E68B810EFC', '4', '16796', '33', '97F250AB127443E9953BE6C279D77365');
INSERT INTO `orderitem` VALUES ('06C3841145C8471383B0632C9C03EDCB', '1', '4087', '16', '0541841390104DE9B27476A518AECBAB');
INSERT INTO `orderitem` VALUES ('0D94F134C1434B0D9632C53D1ED7B3B5', '1', '1699', '23', '0541841390104DE9B27476A518AECBAB');
INSERT INTO `orderitem` VALUES ('DDB01C9BF19541C084F712B6AE6A70BA', '4', '5592', '7', '35D5E4990F634EB292B55F9E95E11B01');
INSERT INTO `orderitem` VALUES ('1108BD54B870402DA11DC1D5532FFF65', '4', '5592', '7', '3894EE2EEDAB443E9588F9EE1B5330EA');
INSERT INTO `orderitem` VALUES ('1B3EFCA548934445B0D7650AB7DE5752', '4', '9196', '50', 'EF55B1F0C0494FF5ACBF6DAE80F213D8');
INSERT INTO `orderitem` VALUES ('66B845FC70CA4405AE014A422012756D', '5', '20435', '16', 'B8BE68F98B924B65A54945166D69CBE4');
INSERT INTO `orderitem` VALUES ('6556283DAEED44A6B0204D6F19E5AF4B', '4', '5592', '7', '2C2122A8473E4AC79DA46D1ADC7AF8DB');
INSERT INTO `orderitem` VALUES ('EEA6C5B66A4D4C5698D5DB3CC45E4C2D', '2', '4598', '50', '8BDDB50E73FE4DC39C027ADFDC7942CC');
INSERT INTO `orderitem` VALUES ('AB52C1E3F5B74B558AD14F6D83E9DB51', '1', '2299', '50', 'FEA1489D27C84B00A09F4F0A9FBBD2F6');
INSERT INTO `orderitem` VALUES ('930043EAF7A140A3B005441317F9C2D5', '4', '9196', '50', '41C1872C997B405B92F12A3E5B1A6D01');
INSERT INTO `orderitem` VALUES ('E6082F1B02EC4EB0AF94278C181084BC', '4', '5196', '1', '41C1872C997B405B92F12A3E5B1A6D01');
INSERT INTO `orderitem` VALUES ('22F9423067584455B6991F1B5D497535', '4', '6796', '23', '98A79687A50B443B8F8341940345FB90');
INSERT INTO `orderitem` VALUES ('C300CD4AD25641C1BD32898BDE173934', '4', '9196', '50', '094013608F2B47F3898B8297383F3C0C');
INSERT INTO `orderitem` VALUES ('1DA9DB8C3FE748E4B098620FF0B669ED', '1', '6688', '32', '30A54626713F49BBAB8C054C14409F04');
INSERT INTO `orderitem` VALUES ('91CCD4FCEC8F4EF584CE2BDD5F819E5A', '4', '10796', '2', '30A54626713F49BBAB8C054C14409F04');
INSERT INTO `orderitem` VALUES ('E79F674D656E45F1956F82143E08F662', '4', '7196', '6', '30A54626713F49BBAB8C054C14409F04');
INSERT INTO `orderitem` VALUES ('696C88DA074540A2AE84DAACCA6A7D61', '4', '17996', '34', '30A54626713F49BBAB8C054C14409F04');
INSERT INTO `orderitem` VALUES ('381F32C99B4D4651B9BDD13130F8B4C3', '5', '20435', '16', '4D0A301C41BA4E01B6E44ED596A3913D');
INSERT INTO `orderitem` VALUES ('70E77E6E0FFF4B19A52018656A37725F', '2', '5398', '2', '4D0A301C41BA4E01B6E44ED596A3913D');
INSERT INTO `orderitem` VALUES ('41AB46A789724FD3AD2603B9EDF3D743', '1', '4199', '33', '4D0A301C41BA4E01B6E44ED596A3913D');
INSERT INTO `orderitem` VALUES ('261BEEB12B64440E9586368E4F55A575', '2', '2796', '7', '5C53EF8108044A78BA326ED3557C4761');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `order_fk_0001` (`uid`),
  CONSTRAINT `order_fk_0001` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('094013608F2B47F3898B8297383F3C0C', '2019-02-16 23:45:38', '2796', '1', '广东', '张三', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('1C6DA0EDCBFA43C288EC24F61C559FD8', '2019-02-16 23:45:38', '2796', '2', '杭州', '尚思', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('231313C914EB41419FB7E541C9B0E6C6', '2019-02-16 23:45:38', '2796', '3', '会昌', '尚格参', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('26742421C2A84DB6A78C819A7EA257A8', '2019-02-16 23:45:38', '2796', '4', '江西', '尚四弟', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('2C2122A8473E4AC79DA46D1ADC7AF8DB', '2019-02-16 23:45:38', '2796', '1', '江西省', '张德山', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('30A54626713F49BBAB8C054C14409F04', '2019-02-16 23:45:38', '2796', '1', '广东省', '张丽', '110', 'c95b15a864334adab3d5bb6604c6e1fc');
INSERT INTO `orders` VALUES ('35D5E4990F634EB292B55F9E95E11B01', '2019-02-16 23:45:38', '2796', '1', '广西省', '王权', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('3894EE2EEDAB443E9588F9EE1B5330EA', '2019-02-16 23:45:38', '2796', '1', '杭州市', '李斌', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('41C1872C997B405B92F12A3E5B1A6D01', '2019-02-16 23:45:38', '2796', '3', '深圳市', '李友', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('479B608F5C704CDF9BA6BF44CE7C881B', '2019-02-16 23:45:38', '2796', '3', '潮州', '李黑', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('4D0A301C41BA4E01B6E44ED596A3913D', '2019-02-16 23:45:38', '2796', '2', '扬州', '王董', '110', '624A00FE076D4381BBA38BD4978CB8B7');
INSERT INTO `orders` VALUES ('59A04DB979264D878637F60C2238ECB6', '2019-02-16 23:45:38', '2796', '1', '惠州', '金耀', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('5C53EF8108044A78BA326ED3557C4761', '2019-02-16 23:45:38', '2796', '2', '江西赣州', '姚强', '110', 'c95b15a864334adab3d5bb6604c6e1fc');
INSERT INTO `orders` VALUES ('768EB13433984CBABF9881452B8C8FEB', '2019-02-16 23:45:38', '2796', '2', '江西赣州会昌', '野比', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('8BDDB50E73FE4DC39C027ADFDC7942CC', '2019-02-16 23:45:38', '2796', '4', '杭州', '刘商', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('97F250AB127443E9953BE6C279D77365', '2019-02-16 23:45:38', '2796', '3', '惠州', '大黄', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('98A79687A50B443B8F8341940345FB90', '2019-02-16 23:45:38', '2796', '4', '扬州', '刘海清', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('9E0D71A90F4E4874B969F4F763C7E443', '2019-02-16 23:45:38', '2796', '4', '深圳', '赵四', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('AACDBD0727F34B70AC5E81B3BEFABED5', '2019-02-16 23:45:38', '2796', '3', '深圳', '王五', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('AC7F96E723ED4278A7D2F9A8338197E8', '2019-02-16 23:45:38', '2796', '2', '深圳', '李九', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('B8BE68F98B924B65A54945166D69CBE4', '2019-02-16 23:45:38', '2796', '2', '惠州', '康雅', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('EF55B1F0C0494FF5ACBF6DAE80F213D8', '2019-02-16 23:45:38', '2796', '2', '汕头', '李广', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('F30D82B6479241D8928A84AB4DCB6BC0', '2019-02-16 23:45:38', '2796', '1', '深圳', '逍遥', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');
INSERT INTO `orders` VALUES ('FEA1489D27C84B00A09F4F0A9FBBD2F6', '2019-02-16 23:45:38', '2796', '1', '东莞', '肖鸣', '110', '62145f6e66ea4f5cbe7b6f6b954917d3');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` varchar(32) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `pimage` varchar(200) DEFAULT NULL,
  `pdate` date DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pflag` int(11) DEFAULT '0',
  `cid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `product_fk_0001` (`cid`),
  KEY `pid` (`pid`),
  CONSTRAINT `product_fk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '适用小米note m4小米4c小米3手机屏幕总成寄修维修单独换外屏触摸', '1399', '1299', 'products/1/c_0001.jpg', '2015-11-09', '1', '小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待', '1', '1');
INSERT INTO `product` VALUES ('10', '华为 Ascend Mate7', '2699', '2599', 'products/1/c_0010.jpg', '2015-11-02', '1', '华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！!选择下方“移动老用户4G飞享合约”，无需换号，还有话费每月返还！', '1', '1');
INSERT INTO `product` VALUES ('11', 'vivo X5Pro', '2399', '2298', 'products/1/c_0014.jpg', '2015-11-02', '1', '移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术', '1', '1');
INSERT INTO `product` VALUES ('12', '努比亚（nubia）My 布拉格', '1899', '1799', 'products/1/c_0013.jpg', '2015-11-02', '0', '努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！', '1', '1');
INSERT INTO `product` VALUES ('13', '华为 麦芒4', '2599', '2499', 'products/1/c_0012.jpg', '2015-11-02', '1', '华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖', '1', '1');
INSERT INTO `product` VALUES ('14', 'vivo X5M', '1899', '1799', 'products/1/c_0011.jpg', '2015-11-02', '0', 'vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV', '1', '1');
INSERT INTO `product` VALUES ('15', 'Apple iPhone 6 (A1586)', '4399', '4288', 'products/1/c_0015.jpg', '2015-11-02', '1', 'Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！', '1', '1');
INSERT INTO `product` VALUES ('16', '华为 HUAWEI Mate S 臻享版', '4200', '4087', 'products/1/c_0016.jpg', '2015-11-03', '0', '华为 HUAWEI Mate S 臻享版 手机 极昼金 移动联通双4G(高配)满星评价即返30元话费啦；买就送电源+清水套+创意手机支架；优雅弧屏，mate7升级版', '1', '1');
INSERT INTO `product` VALUES ('17', '索尼(SONY) E6533 Z3+', '4099', '3999', 'products/1/c_0017.jpg', '2015-11-02', '0', '索尼(SONY) E6533 Z3+ 双卡双4G手机 防水防尘 涧湖绿索尼z3专业防水 2070万像素 移动联通双4G', '1', '1');
INSERT INTO `product` VALUES ('18', 'HTC One M9+', '3599', '3499', 'products/1/c_0018.jpg', '2015-11-02', '0', 'HTC One M9+（M9pw） 金银汇 移动联通双4G手机5.2英寸，8核CPU，指纹识别，UltraPixel超像素前置相机+2000万/200万后置双镜头相机！降价特卖，惊喜不断！', '1', '1');
INSERT INTO `product` VALUES ('19', 'HTC Desire 826d 32G 臻珠白', '1599', '1469', 'products/1/c_0020.jpg', '2015-11-02', '1', '后置1300万+UltraPixel超像素前置摄像头+【双】前置扬声器+5.5英寸【1080p】大屏！', '1', '1');
INSERT INTO `product` VALUES ('2', '中兴 AXON', '2899', '2699', 'products/1/c_0002.jpg', '2015-11-05', '1', '中兴 AXON 天机 mini 压力屏版 B2015 华尔金 移动联通电信4G 双卡双待', '1', '1');
INSERT INTO `product` VALUES ('20', '小米 红米2A 增强版 白色', '649', '549', 'products/1/c_0019.jpg', '2015-11-02', '0', '新增至2GB 内存+16GB容量！4G双卡双待，联芯 4 核 1.5GHz 处理器！', '1', '1');
INSERT INTO `product` VALUES ('21', '魅族 魅蓝note2 16GB 白色', '1099', '999', 'products/1/c_0021.jpg', '2015-11-02', '0', '现货速抢，抢完即止！5.5英寸1080P分辨率屏幕，64位八核1.3GHz处理器，1300万像素摄像头，双色温双闪光灯！', '1', '1');
INSERT INTO `product` VALUES ('22', '三星 Galaxy S5 (G9008W) 闪耀白', '2099', '1999', 'products/1/c_0022.jpg', '2015-11-02', '1', '5.1英寸全高清炫丽屏，2.5GHz四核处理器，1600万像素', '1', '1');
INSERT INTO `product` VALUES ('23', 'sonim XP7700 4G手机', '1799', '1699', 'products/1/c_0023.jpg', '2015-11-09', '1', '三防智能手机 移动/联通双4G 安全 黑黄色 双4G美国军工IP69 30天长待机 3米防水防摔 北斗', '1', '1');
INSERT INTO `product` VALUES ('24', '努比亚（nubia）Z9精英版 金色', '3988', '3888', 'products/1/c_0024.jpg', '2015-11-02', '1', '移动联通电信4G手机 双卡双待真正的无边框！金色尊贵版！4GB+64GB大内存！', '1', '1');
INSERT INTO `product` VALUES ('25', 'Apple iPhone 6 Plus (A1524) 16GB 金色', '5188', '4988', 'products/1/c_0025.jpg', '2015-11-02', '0', 'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力', '1', '1');
INSERT INTO `product` VALUES ('26', 'Apple iPhone 6s (A1700) 64G 玫瑰金色', '6388', '6088', 'products/1/c_0026.jpg', '2015-11-02', '0', 'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力', '1', '1');
INSERT INTO `product` VALUES ('27', '三星 Galaxy Note5（N9200）32G版', '5588', '5388', 'products/1/c_0027.jpg', '2015-11-02', '0', '旗舰机型！5.7英寸大屏，4+32G内存！不一样的SPen更优化的浮窗指令！赠无线充电板！', '1', '1');
INSERT INTO `product` VALUES ('28', '三星 Galaxy S6 Edge+（G9280）32G版 铂光金', '5999', '5888', 'products/1/c_0028.jpg', '2015-11-02', '0', '赠移动电源+自拍杆+三星OTG金属U盘+无线充电器+透明保护壳', '1', '1');
INSERT INTO `product` VALUES ('29', 'LG G4（H818）陶瓷白 国际版', '3018', '2978', 'products/1/c_0029.jpg', '2015-11-02', '0', '李敏镐代言，F1.8大光圈1600万后置摄像头，5.5英寸2K屏，3G+32G内存，LG年度旗舰机！', '1', '1');
INSERT INTO `product` VALUES ('3', '华为荣耀6', '1599', '1499', 'products/1/c_0003.jpg', '2015-11-02', '0', '荣耀 6 (H60-L01) 3GB内存标准版 黑色 移动4G手机', '1', '1');
INSERT INTO `product` VALUES ('30', '微软(Microsoft) Lumia 640 LTE DS (RM-1113)', '1099', '999', 'products/1/c_0030.jpg', '2015-11-02', '0', '微软首款双网双卡双4G手机，5.0英寸高清大屏，双网双卡双4G！', '1', '1');
INSERT INTO `product` VALUES ('31', '宏碁（acer）ATC705-N50 台式电脑', '2399', '2299', 'products/1/c_0031.jpg', '2015-11-02', '0', '爆款直降，满千减百，品质宏碁，特惠来袭，何必苦等11.11，早买早便宜！', '1', '2');
INSERT INTO `product` VALUES ('32', 'Apple MacBook Air MJVE2CH/A 13.3英寸', '6788', '6688', 'products/1/c_0032.jpg', '2015-11-02', '0', '宽屏笔记本电脑 128GB 闪存', '1', '2');
INSERT INTO `product` VALUES ('33', '联想（ThinkPad） 轻薄系列E450C(20EH0001CD)', '4399', '4199', 'products/1/c_0033.jpg', '2015-11-02', '0', '联想（ThinkPad） 轻薄系列E450C(20EH0001CD)14英寸笔记本电脑(i5-4210U 4G 500G 2G独显 Win8.1)', '1', '2');
INSERT INTO `product` VALUES ('34', '联想（Lenovo）小新V3000经典版', '4599', '4499', 'products/1/c_0034.jpg', '2015-11-02', '0', '14英寸超薄笔记本电脑（i7-5500U 4G 500G+8G SSHD 2G独显 全高清屏）黑色满1000減100，狂减！火力全开，横扫3天！', '1', '2');
INSERT INTO `product` VALUES ('35', '华硕（ASUS）经典系列R557LI', '3799', '3699', 'products/1/c_0035.jpg', '2015-11-02', '0', '15.6英寸笔记本电脑（i5-5200U 4G 7200转500G 2G独显 D刻 蓝牙 Win8.1 黑色）', '1', '2');
INSERT INTO `product` VALUES ('36', '华硕（ASUS）X450J', '4599', '4399', 'products/1/c_0036.jpg', '2015-11-02', '0', '14英寸笔记本电脑 （i5-4200H 4G 1TB GT940M 2G独显 蓝牙4.0 D刻 Win8.1 黑色）', '1', '2');
INSERT INTO `product` VALUES ('37', '戴尔（DELL）灵越 飞匣3000系列', '3399', '3299', 'products/1/c_0037.jpg', '2015-11-03', '0', ' Ins14C-4528B 14英寸笔记本（i5-5200U 4G 500G GT820M 2G独显 Win8）黑', '1', '2');
INSERT INTO `product` VALUES ('38', '惠普(HP)WASD 暗影精灵', '5699', '5499', 'products/1/c_0038.jpg', '2015-11-02', '0', '15.6英寸游戏笔记本电脑(i5-6300HQ 4G 1TB+128G SSD GTX950M 4G独显 Win10)', '1', '2');
INSERT INTO `product` VALUES ('39', 'Apple 配备 Retina 显示屏的 MacBook', '11299', '10288', 'products/1/c_0039.jpg', '2015-11-02', '0', 'Pro MF840CH/A 13.3英寸宽屏笔记本电脑 256GB 闪存', '1', '2');
INSERT INTO `product` VALUES ('4', '联想 P1', '2199', '1999', 'products/1/c_0004.jpg', '2015-11-02', '0', '联想 P1 16G 伯爵金 移动联通4G手机充电5分钟，通话3小时！科技源于超越！品质源于沉淀！5000mAh大电池！高端商务佳配！', '1', '1');
INSERT INTO `product` VALUES ('40', '机械革命（MECHREVO）MR X6S-M', '6799', '6599', 'products/1/c_0040.jpg', '2015-11-02', '0', '15.6英寸游戏本(I7-4710MQ 8G 64GSSD+1T GTX960M 2G独显 IPS屏 WIN7)黑色', '1', '2');
INSERT INTO `product` VALUES ('41', '神舟（HASEE） 战神K660D-i7D2', '5699', '5499', 'products/1/c_0041.jpg', '2015-11-02', '0', '15.6英寸游戏本(i7-4710MQ 8G 1TB GTX960M 2G独显 1080P)黑色', '1', '2');
INSERT INTO `product` VALUES ('42', '微星（MSI）GE62 2QC-264XCN', '6199', '5999', 'products/1/c_0042.jpg', '2015-11-02', '0', '15.6英寸游戏笔记本电脑（i5-4210H 8G 1T GTX960MG DDR5 2G 背光键盘）黑色', '1', '2');
INSERT INTO `product` VALUES ('43', '雷神（ThundeRobot）G150S', '5699', '5499', 'products/1/c_0043.jpg', '2015-11-02', '0', '15.6英寸游戏本 ( i7-4710MQ 4G 500G GTX950M 2G独显 包无亮点全高清屏) 金', '1', '2');
INSERT INTO `product` VALUES ('44', '惠普（HP）轻薄系列 HP', '3199', '3099', 'products/1/c_0044.jpg', '2015-11-02', '0', '15-r239TX 15.6英寸笔记本电脑（i5-5200U 4G 500G GT820M 2G独显 win8.1）金属灰', '1', '2');
INSERT INTO `product` VALUES ('45', '未来人类（Terrans Force）T5', '10999', '9899', 'products/1/c_0045.jpg', '2015-11-02', '0', '15.6英寸游戏本（i7-5700HQ 16G 120G固态+1TB GTX970M 3G GDDR5独显）黑', '1', '2');
INSERT INTO `product` VALUES ('46', '戴尔（DELL）Vostro 3800-R6308 台式电脑', '3299', '3199', 'products/1/c_0046.jpg', '2015-11-02', '0', '（i3-4170 4G 500G DVD 三年上门服务 Win7）黑', '1', '2');
INSERT INTO `product` VALUES ('47', '联想（Lenovo）H3050 台式电脑', '5099', '4899', 'products/1/c_0047.jpg', '2015-11-11', '0', '（i5-4460 4G 500G GT720 1G独显 DVD 千兆网卡 Win10）23英寸', '1', '2');
INSERT INTO `product` VALUES ('48', 'Apple iPad mini 2 ME279CH/A', '2088', '1888', 'products/1/c_0048.jpg', '2015-11-02', '0', '（配备 Retina 显示屏 7.9英寸 16G WLAN 机型 银色）', '1', '2');
INSERT INTO `product` VALUES ('49', '小米（MI）7.9英寸平板', '1399', '1299', 'products/1/c_0049.jpg', '2015-11-02', '0', 'WIFI 64GB（NVIDIA Tegra K1 2.2GHz 2G 64G 2048*1536视网膜屏 800W）白色', '1', '2');
INSERT INTO `product` VALUES ('5', '摩托罗拉 moto x（x+1）', '1799', '1699', 'products/1/c_0005.jpg', '2015-11-01', '0', '摩托罗拉 moto x（x+1）(XT1085) 32GB 天然竹 全网通4G手机11月11天！MOTO X震撼特惠来袭！1699元！带你玩转黑科技！天然材质，原生流畅系统！', '1', '1');
INSERT INTO `product` VALUES ('50', 'Apple iPad Air 2 MGLW2CH/A', '2399', '2299', 'products/1/c_0050.jpg', '2015-11-12', '0', '（9.7英寸 16G WLAN 机型 银色）', '1', '2');
INSERT INTO `product` VALUES ('6', '魅族 MX5 16GB 银黑色', '1899', '1799', 'products/1/c_0006.jpg', '2015-11-02', '0', '魅族 MX5 16GB 银黑色 移动联通双4G手机 双卡双待送原厂钢化膜+保护壳+耳机！5.5英寸大屏幕，3G运行内存，2070万+500万像素摄像头！长期省才是真的省！', '1', '1');
INSERT INTO `product` VALUES ('7', '三星 Galaxy On7', '1499', '1398', 'products/1/c_0007.jpg', '2015-11-14', '0', '三星 Galaxy On7（G6000）昂小七 金色 全网通4G手机 双卡双待新品火爆抢购中！京东尊享千元良机！5.5英寸高清大屏！1300+500W像素！评价赢30元话费券！', '1', '1');
INSERT INTO `product` VALUES ('9', '乐视（Letv）乐1pro（X800）', '2399', '2299', 'products/1/c_0009.jpg', '2015-11-02', '0', '乐视（Letv）乐1pro（X800）64GB 金色 移动联通4G手机 双卡双待乐视生态UI+5.5英寸2K屏+高通8核处理器+4GB运行内存+64GB存储+1300万摄像头！', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('084C72126E31481792E0766F4BDDF587', '111111', '11', '晓东', '1454530949@qq.com', '17679072513', '2222-11-11', ' 男', '0', '28AE6A771F874C19BAC1300749554999');
INSERT INTO `user` VALUES ('0D4E90AD83484B2AA856CA155F582A9C', '111111', '11', '李斌', '145453030949@qq.com', '17679072513', '2222-11-11', ' 男', '0', '29FE223FCF06485593442DD4BF1B3F61');
INSERT INTO `user` VALUES ('17C72EED98B04608A184303FB12A53FC', '111111', '11', '李四', '145453030949@qq.com', '17679072513', '2222-11-11', ' 男', '0', '76433428A7454941BC8D44A904969C14');
INSERT INTO `user` VALUES ('2BF5D6420E8A4C9A8FFB1DB68A255789', '??', '123', '王超', '1066165692@qq.com', '110', '2019-02-18', '女', '0', 'A65D2DCDE6224A0D82F31853FEBD9DAC');
INSERT INTO `user` VALUES ('3406F9FCCE4A450D9256496CCFBD76B2', '11', '11', '李瑶', '1454530949@qq.com', '15970763850', '1111-11-11', ' 男', '0', 'AA9A17EC3FFB4AD9914A75052BE29E5A');
INSERT INTO `user` VALUES ('502837B6281948B3A7238080DE13FCE1', '111111', '11', '李涛', '145453030949@qq.com', '17679072513', '2222-11-11', ' 男', '0', '0063245BDDD04B58B7A4F635796B545E');
INSERT INTO `user` VALUES ('62145f6e66ea4f5cbe7b6f6b954917d3', 'cc', 'cc', '张三', 'bbb@store.com', '15723689921', '2015-11-03', '男', '1', '19f100aa81184c03951c4b840a725b6a98097aa1106a4a38ba1c29f1a496c231');
INSERT INTO `user` VALUES ('624A00FE076D4381BBA38BD4978CB8B7', '111', '111', '丽水', 'ccc@store', '111111', '1111-11-11', '男', '1', 'DC4C1F3F5B91492E8198F34250491559');
INSERT INTO `user` VALUES ('6544EB96DD09448FA184514C75759F46', '111111', '11111', '李煜', '1454530949@qq.com', '17679072513', '2222-11-11', ' 男', '0', '99F190BCDA014E7794D077FF620148A7');
INSERT INTO `user` VALUES ('6788A3852B0D4C15896D73B6BC97894F', '111111', '111', '李瑶', '1454530949@qq.com', '17679072513', '2222-11-11', ' 男', '0', 'B8FEA71424834DC49E1261E54DF5FB80');
INSERT INTO `user` VALUES ('9021B318B83A4DA886FC75B677567700', '11111', '11', '小路', '1454530949@qq.com', '11', '1111-11-11', '  男', '0', 'F9F43E6525E347B5AE4650041EE0DD6D');
INSERT INTO `user` VALUES ('A196AF0D77164014A3DB9F1DCD8E35E0', '11111', '1111', '李旺', '1111@qq.com', '111', '1111-11-11', ' 男', '0', '273BE9F45E094C7FBA1BB32D6B18E8DA');
INSERT INTO `user` VALUES ('A2023E61E2F647ACAC9591A92028F172', '11', '11', '老李', '111@qq.com', '111', '1111-11-11', '  男', '0', '6B60F9BAA9CA44498C2C0386C35A39D0');
INSERT INTO `user` VALUES ('A56B472B85624D0491003575F09D517A', '11111', '222', '李四', '1454530949@qq.com', '11', '1111-11-11', ' 男', '0', '6E76E6AE47E64FD19728762BE08472C0');
INSERT INTO `user` VALUES ('BE4ED369C85F4D4899821D67A6A156A1', '111111', '1111111', '张涛', '145453030949@qq.com', '17679072513', '2222-11-11', ' 男', '0', 'F6A5C386695D48E6B469D3A11F7DC6C1');
INSERT INTO `user` VALUES ('C47304F09B014493986C7A362B44D093', '???', '17679072513', '张思', '1454530949@qq', '17679072512', '2000-12-21', '女', '0', '4ECCA60D39394D5496DEA0E9A44D833F');
INSERT INTO `user` VALUES ('c95b15a864334adab3d5bb6604c6e1fc', 'bbb', 'bbb', '老王', 'bbb@store.com', '15712344823', '2000-02-01', '男', '1', '71a3a933353347a4bcacff699e6baa9c950a02f6b84e4f6fb8404ca06febfd6f');
INSERT INTO `user` VALUES ('D868FDAF03504AA3A7B54963CA4F06DD', '111111', '11111', '李鹏', '1454530949@qq.com', '17679072513', '2222-11-11', ' 男', '0', '');
INSERT INTO `user` VALUES ('DB2AC8BA550C407586313AD6AC61F9FA', '111aaa', '111', '李琥', '111@qq.com', null, '1111-11-01', ' 男', '0', '2F1480F56CED43478F53F879EE6E3DB0');
INSERT INTO `user` VALUES ('E18444B45BD547D187B6135560E17369', '444', '4444', '瑶瑶', '1454530949@qq.com', '111', '1111-11-11', ' 男', '0', '');
INSERT INTO `user` VALUES ('F4847EAAE3734B379D85E98D7AC13E5D', '星海', '123', '刘海清', '1066165692@qq.com', '110', '2019-02-17', '女', '0', '580A3DF9CDC54F6A97901E825B729D61');
