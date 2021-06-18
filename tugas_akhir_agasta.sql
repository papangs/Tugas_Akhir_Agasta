/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 100418
 Source Host           : localhost:3306
 Source Schema         : tugas_akhir_agasta

 Target Server Type    : MySQL
 Target Server Version : 100418
 File Encoding         : 65001

 Date: 18/06/2021 20:36:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alternatif
-- ----------------------------
DROP TABLE IF EXISTS `alternatif`;
CREATE TABLE `alternatif`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `alternatif_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `kategori_seq` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fkkategoriseq`(`kategori_seq`) USING BTREE,
  CONSTRAINT `fkkategoriseq` FOREIGN KEY (`kategori_seq`) REFERENCES `kategori_alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of alternatif
-- ----------------------------
INSERT INTO `alternatif` VALUES (1, 'NVIDIA RTX 3090', 3);
INSERT INTO `alternatif` VALUES (2, 'NVDIA RTX 3080', 1);
INSERT INTO `alternatif` VALUES (3, 'NVIDIA RTX 3070', 3);
INSERT INTO `alternatif` VALUES (4, 'NVIDIA RTX3060 TI', 1);
INSERT INTO `alternatif` VALUES (5, 'NVIDIA RTX 2080', 1);
INSERT INTO `alternatif` VALUES (6, 'NVIDIA RTX 2070 Super', 1);
INSERT INTO `alternatif` VALUES (7, 'NVIDIA RTX 2060 Super', 3);
INSERT INTO `alternatif` VALUES (8, 'NVIDIA RTX 2060', 1);
INSERT INTO `alternatif` VALUES (9, 'NVIDIA GTX1660 Super', 1);
INSERT INTO `alternatif` VALUES (10, 'NVIDIA GTX 1660 TI', 1);
INSERT INTO `alternatif` VALUES (11, 'NVIDIA GTX 1650 Super', 3);
INSERT INTO `alternatif` VALUES (12, 'NVIDIA GTX 1060', 2);
INSERT INTO `alternatif` VALUES (13, 'NVIDIA GTX 1050 TI', 1);
INSERT INTO `alternatif` VALUES (14, 'NVIDIA GT 1030', 2);
INSERT INTO `alternatif` VALUES (15, 'NVIDIA GT 710', 2);
INSERT INTO `alternatif` VALUES (16, 'AMD RX 460', 2);
INSERT INTO `alternatif` VALUES (17, 'AMD RX 470', 2);
INSERT INTO `alternatif` VALUES (18, 'AMD RX 480', 2);
INSERT INTO `alternatif` VALUES (19, 'AMD RX 560', 2);
INSERT INTO `alternatif` VALUES (20, 'AMD RX 570', 2);
INSERT INTO `alternatif` VALUES (21, 'AMD RX 580', 3);
INSERT INTO `alternatif` VALUES (22, 'AMD RX VEGA 56', 3);
INSERT INTO `alternatif` VALUES (23, 'AMD RX VEGA 64', 3);

-- ----------------------------
-- Table structure for alternatif_kriteria
-- ----------------------------
DROP TABLE IF EXISTS `alternatif_kriteria`;
CREATE TABLE `alternatif_kriteria`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `kriteria_seq` int(11) NULL DEFAULT NULL,
  `alternatif_seq` int(11) NULL DEFAULT NULL,
  `content_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fkkriteria`(`kriteria_seq`) USING BTREE,
  INDEX `fkalternatif`(`alternatif_seq`) USING BTREE,
  CONSTRAINT `fkalternatif` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkkriteria` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alternatif_kriteria
-- ----------------------------
INSERT INTO `alternatif_kriteria` VALUES (1, 1, 1, '1.40GHz');
INSERT INTO `alternatif_kriteria` VALUES (2, 2, 1, '1.70Ghz');
INSERT INTO `alternatif_kriteria` VALUES (3, 3, 1, '24GB');
INSERT INTO `alternatif_kriteria` VALUES (4, 4, 1, '1.28Ghz');
INSERT INTO `alternatif_kriteria` VALUES (5, 5, 1, '350W');
INSERT INTO `alternatif_kriteria` VALUES (6, 6, 1, 'Rp25,628,000');
INSERT INTO `alternatif_kriteria` VALUES (7, 1, 2, '1.44Ghz');
INSERT INTO `alternatif_kriteria` VALUES (8, 2, 2, '1.73Ghz');
INSERT INTO `alternatif_kriteria` VALUES (9, 3, 2, '10GB');
INSERT INTO `alternatif_kriteria` VALUES (10, 4, 2, '1.14Ghz');
INSERT INTO `alternatif_kriteria` VALUES (11, 5, 2, '320W');
INSERT INTO `alternatif_kriteria` VALUES (12, 6, 2, 'Rp13,532,000');
INSERT INTO `alternatif_kriteria` VALUES (13, 1, 3, '1.50Ghz');
INSERT INTO `alternatif_kriteria` VALUES (14, 2, 3, '1.72Ghz');
INSERT INTO `alternatif_kriteria` VALUES (15, 3, 3, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (16, 4, 3, '1.68Ghz');
INSERT INTO `alternatif_kriteria` VALUES (17, 5, 3, '220W');
INSERT INTO `alternatif_kriteria` VALUES (18, 6, 3, 'Rp9,800,000');
INSERT INTO `alternatif_kriteria` VALUES (19, 1, 4, '1.40Ghz');
INSERT INTO `alternatif_kriteria` VALUES (20, 2, 4, '1.66Ghz');
INSERT INTO `alternatif_kriteria` VALUES (21, 3, 4, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (22, 4, 4, '1.66Ghz');
INSERT INTO `alternatif_kriteria` VALUES (23, 5, 4, '200W');
INSERT INTO `alternatif_kriteria` VALUES (24, 6, 4, 'Rp7,100,000');
INSERT INTO `alternatif_kriteria` VALUES (25, 1, 5, '1.51Ghz');
INSERT INTO `alternatif_kriteria` VALUES (26, 2, 5, '1.71Ghz');
INSERT INTO `alternatif_kriteria` VALUES (27, 3, 5, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (28, 4, 5, '1.78Ghz');
INSERT INTO `alternatif_kriteria` VALUES (29, 5, 5, '215W');
INSERT INTO `alternatif_kriteria` VALUES (30, 6, 5, 'Rp10,000,000');
INSERT INTO `alternatif_kriteria` VALUES (31, 1, 6, '1.60Ghz');
INSERT INTO `alternatif_kriteria` VALUES (32, 2, 6, '1.77Ghz');
INSERT INTO `alternatif_kriteria` VALUES (33, 3, 6, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (34, 4, 6, '1.75Ghz');
INSERT INTO `alternatif_kriteria` VALUES (35, 5, 6, '215W');
INSERT INTO `alternatif_kriteria` VALUES (36, 6, 6, 'Rp8,700,000');
INSERT INTO `alternatif_kriteria` VALUES (37, 1, 7, '1.47Ghz');
INSERT INTO `alternatif_kriteria` VALUES (38, 2, 7, '1.65Ghz');
INSERT INTO `alternatif_kriteria` VALUES (39, 3, 7, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (40, 4, 7, '1.75Ghz');
INSERT INTO `alternatif_kriteria` VALUES (41, 5, 7, '175W');
INSERT INTO `alternatif_kriteria` VALUES (42, 6, 7, 'Rp7,800,000');
INSERT INTO `alternatif_kriteria` VALUES (43, 1, 8, '1.36Ghz');
INSERT INTO `alternatif_kriteria` VALUES (44, 2, 8, '1.68Ghz');
INSERT INTO `alternatif_kriteria` VALUES (45, 3, 8, '6GB');
INSERT INTO `alternatif_kriteria` VALUES (46, 4, 8, '1.75Ghz');
INSERT INTO `alternatif_kriteria` VALUES (47, 5, 8, '160W');
INSERT INTO `alternatif_kriteria` VALUES (48, 6, 8, 'Rp5,100,000');
INSERT INTO `alternatif_kriteria` VALUES (49, 1, 9, '1.53Ghz');
INSERT INTO `alternatif_kriteria` VALUES (50, 2, 9, '1.75Ghz');
INSERT INTO `alternatif_kriteria` VALUES (51, 3, 9, '6GB');
INSERT INTO `alternatif_kriteria` VALUES (52, 4, 9, '1.7Ghz');
INSERT INTO `alternatif_kriteria` VALUES (53, 5, 9, '125W');
INSERT INTO `alternatif_kriteria` VALUES (54, 6, 9, 'Rp3,700,000');
INSERT INTO `alternatif_kriteria` VALUES (55, 1, 10, '1.50Ghz');
INSERT INTO `alternatif_kriteria` VALUES (56, 2, 10, '1.77Ghz');
INSERT INTO `alternatif_kriteria` VALUES (57, 3, 10, '6GB');
INSERT INTO `alternatif_kriteria` VALUES (58, 4, 10, '1.5Ghz');
INSERT INTO `alternatif_kriteria` VALUES (59, 5, 10, '120W');
INSERT INTO `alternatif_kriteria` VALUES (60, 6, 10, 'Rp4,200,000');
INSERT INTO `alternatif_kriteria` VALUES (61, 1, 11, '1.53Ghz');
INSERT INTO `alternatif_kriteria` VALUES (62, 2, 11, '1.72Ghz');
INSERT INTO `alternatif_kriteria` VALUES (63, 3, 11, '4GB');
INSERT INTO `alternatif_kriteria` VALUES (64, 4, 11, '1.5Ghz');
INSERT INTO `alternatif_kriteria` VALUES (65, 5, 11, '100W');
INSERT INTO `alternatif_kriteria` VALUES (66, 6, 11, 'Rp2,950,000');
INSERT INTO `alternatif_kriteria` VALUES (67, 1, 12, '1.50Ghz');
INSERT INTO `alternatif_kriteria` VALUES (68, 2, 12, '1.70Ghz');
INSERT INTO `alternatif_kriteria` VALUES (69, 3, 12, '6GB');
INSERT INTO `alternatif_kriteria` VALUES (70, 4, 12, '2.0GHz');
INSERT INTO `alternatif_kriteria` VALUES (71, 5, 12, '120W');
INSERT INTO `alternatif_kriteria` VALUES (72, 6, 12, 'Rp2,400,000');
INSERT INTO `alternatif_kriteria` VALUES (73, 1, 13, '1.29Ghz');
INSERT INTO `alternatif_kriteria` VALUES (74, 2, 13, '1.39Ghz');
INSERT INTO `alternatif_kriteria` VALUES (75, 3, 13, '4GB');
INSERT INTO `alternatif_kriteria` VALUES (76, 4, 13, '1.7Ghz');
INSERT INTO `alternatif_kriteria` VALUES (77, 5, 13, '75W');
INSERT INTO `alternatif_kriteria` VALUES (78, 6, 13, 'Rp2,000,000');
INSERT INTO `alternatif_kriteria` VALUES (79, 1, 14, '1.22Ghz');
INSERT INTO `alternatif_kriteria` VALUES (80, 2, 14, '1.4Ghz');
INSERT INTO `alternatif_kriteria` VALUES (81, 3, 14, '2GB');
INSERT INTO `alternatif_kriteria` VALUES (82, 4, 14, '1.5Ghz');
INSERT INTO `alternatif_kriteria` VALUES (83, 5, 14, '30W');
INSERT INTO `alternatif_kriteria` VALUES (84, 6, 14, 'Rp1,121,000');
INSERT INTO `alternatif_kriteria` VALUES (85, 1, 15, '0.95Ghz');
INSERT INTO `alternatif_kriteria` VALUES (86, 2, 15, '0.90Ghz');
INSERT INTO `alternatif_kriteria` VALUES (87, 3, 15, '2GB');
INSERT INTO `alternatif_kriteria` VALUES (88, 4, 15, '0.90Ghz');
INSERT INTO `alternatif_kriteria` VALUES (89, 5, 15, '19W');
INSERT INTO `alternatif_kriteria` VALUES (90, 6, 15, 'Rp580,000');
INSERT INTO `alternatif_kriteria` VALUES (91, 1, 16, '1.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (92, 2, 16, '1.22Ghz');
INSERT INTO `alternatif_kriteria` VALUES (93, 3, 16, '2GB');
INSERT INTO `alternatif_kriteria` VALUES (94, 4, 16, '1.74Ghz');
INSERT INTO `alternatif_kriteria` VALUES (95, 5, 16, '48W');
INSERT INTO `alternatif_kriteria` VALUES (96, 6, 16, 'Rp1,000,000');
INSERT INTO `alternatif_kriteria` VALUES (97, 1, 17, '1.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (98, 2, 17, '1.25Ghz');
INSERT INTO `alternatif_kriteria` VALUES (99, 3, 17, '4GB');
INSERT INTO `alternatif_kriteria` VALUES (100, 4, 17, '1.65Ghz');
INSERT INTO `alternatif_kriteria` VALUES (101, 5, 17, '85W');
INSERT INTO `alternatif_kriteria` VALUES (102, 6, 17, 'Rp1,400,000');
INSERT INTO `alternatif_kriteria` VALUES (103, 1, 18, '1.12Ghz');
INSERT INTO `alternatif_kriteria` VALUES (104, 2, 18, '1.30Ghz');
INSERT INTO `alternatif_kriteria` VALUES (105, 3, 18, '4GB');
INSERT INTO `alternatif_kriteria` VALUES (106, 4, 18, '1.75Ghz');
INSERT INTO `alternatif_kriteria` VALUES (107, 5, 18, '110W');
INSERT INTO `alternatif_kriteria` VALUES (108, 6, 18, 'Rp1,700,000');
INSERT INTO `alternatif_kriteria` VALUES (109, 1, 19, '1.35Ghz');
INSERT INTO `alternatif_kriteria` VALUES (110, 2, 19, '1.50Ghz');
INSERT INTO `alternatif_kriteria` VALUES (111, 3, 19, '4GB');
INSERT INTO `alternatif_kriteria` VALUES (112, 4, 19, '1.75Ghz');
INSERT INTO `alternatif_kriteria` VALUES (113, 5, 19, '42W');
INSERT INTO `alternatif_kriteria` VALUES (114, 6, 19, 'Rp1,680,000');
INSERT INTO `alternatif_kriteria` VALUES (115, 1, 20, '1.35Ghz');
INSERT INTO `alternatif_kriteria` VALUES (116, 2, 20, '1.75Ghz');
INSERT INTO `alternatif_kriteria` VALUES (117, 3, 20, '4GB');
INSERT INTO `alternatif_kriteria` VALUES (118, 4, 20, '2.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (119, 5, 20, '120W');
INSERT INTO `alternatif_kriteria` VALUES (120, 6, 20, 'Rp2,200,000');
INSERT INTO `alternatif_kriteria` VALUES (121, 1, 21, '1.45Ghz');
INSERT INTO `alternatif_kriteria` VALUES (122, 2, 21, '2.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (123, 3, 21, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (124, 4, 21, '2.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (125, 5, 21, '145W');
INSERT INTO `alternatif_kriteria` VALUES (126, 6, 21, 'Rp3,000,000');
INSERT INTO `alternatif_kriteria` VALUES (127, 1, 22, '1.56Ghz');
INSERT INTO `alternatif_kriteria` VALUES (128, 2, 22, '2.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (129, 3, 22, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (130, 4, 22, '2.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (131, 5, 22, '260W');
INSERT INTO `alternatif_kriteria` VALUES (132, 6, 22, 'Rp4,200,000');
INSERT INTO `alternatif_kriteria` VALUES (133, 1, 23, '1.60Ghz');
INSERT INTO `alternatif_kriteria` VALUES (134, 2, 23, '2.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (135, 3, 23, '8GB');
INSERT INTO `alternatif_kriteria` VALUES (136, 4, 23, '2.00Ghz');
INSERT INTO `alternatif_kriteria` VALUES (137, 5, 23, '240W');
INSERT INTO `alternatif_kriteria` VALUES (138, 6, 23, 'Rp5,200,000');

-- ----------------------------
-- Table structure for eigen_alternatif
-- ----------------------------
DROP TABLE IF EXISTS `eigen_alternatif`;
CREATE TABLE `eigen_alternatif`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `eigen_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `alternatif_seq` int(11) NULL DEFAULT NULL,
  `kategori_seq` int(11) NULL DEFAULT NULL,
  `kriteria_seq` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fkkriteria_seq`(`alternatif_seq`) USING BTREE,
  INDEX `fkkategoriseq1`(`kategori_seq`) USING BTREE,
  INDEX `fkkriteriaseq`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `fkalternatifseq` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkkategoriseq1` FOREIGN KEY (`kategori_seq`) REFERENCES `kategori_alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkkriteriaseq` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 395 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eigen_alternatif
-- ----------------------------
INSERT INTO `eigen_alternatif` VALUES (234, '0.125', '2021-05-02', 12, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (235, '0.125', '2021-05-02', 14, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (236, '0.125', '2021-05-02', 15, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (237, '0.125', '2021-05-02', 16, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (238, '0.125', '2021-05-02', 17, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (239, '0.125', '2021-05-02', 18, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (240, '0.125', '2021-05-02', 19, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (241, '0.125', '2021-05-02', 20, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (242, '0.143', '2021-05-02', 1, 3, 1);
INSERT INTO `eigen_alternatif` VALUES (243, '0.143', '2021-05-02', 3, 3, 1);
INSERT INTO `eigen_alternatif` VALUES (244, '0.143', '2021-05-02', 7, 3, 1);
INSERT INTO `eigen_alternatif` VALUES (245, '0.143', '2021-05-02', 11, 3, 1);
INSERT INTO `eigen_alternatif` VALUES (246, '0.143', '2021-05-02', 21, 3, 1);
INSERT INTO `eigen_alternatif` VALUES (247, '0.143', '2021-05-02', 22, 3, 1);
INSERT INTO `eigen_alternatif` VALUES (248, '0.143', '2021-05-02', 23, 3, 1);
INSERT INTO `eigen_alternatif` VALUES (249, '0.155', '2021-05-02', 2, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (250, '0.127', '2021-05-02', 4, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (251, '0.138', '2021-05-02', 5, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (252, '0.114', '2021-05-02', 6, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (253, '0.113', '2021-05-02', 8, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (254, '0.121', '2021-05-02', 9, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (255, '0.113', '2021-05-02', 10, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (256, '0.121', '2021-05-02', 13, 1, 2);
INSERT INTO `eigen_alternatif` VALUES (257, '0.125', '2021-05-02', 12, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (258, '0.125', '2021-05-02', 14, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (259, '0.125', '2021-05-02', 15, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (260, '0.125', '2021-05-02', 16, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (261, '0.125', '2021-05-02', 17, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (262, '0.125', '2021-05-02', 18, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (263, '0.125', '2021-05-02', 19, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (264, '0.125', '2021-05-02', 20, 2, 2);
INSERT INTO `eigen_alternatif` VALUES (265, '0.143', '2021-05-02', 1, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (266, '0.143', '2021-05-02', 3, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (267, '0.143', '2021-05-02', 7, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (268, '0.143', '2021-05-02', 11, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (269, '0.143', '2021-05-02', 21, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (270, '0.143', '2021-05-02', 22, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (271, '0.143', '2021-05-02', 23, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (295, '0.107', '2021-05-02', 2, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (296, '0.136', '2021-05-02', 4, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (297, '0.136', '2021-05-02', 5, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (298, '0.124', '2021-05-02', 6, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (299, '0.124', '2021-05-02', 8, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (300, '0.124', '2021-05-02', 9, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (301, '0.124', '2021-05-02', 10, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (302, '0.124', '2021-05-02', 13, 1, 3);
INSERT INTO `eigen_alternatif` VALUES (303, '0.125', '2021-05-02', 12, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (304, '0.125', '2021-05-02', 14, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (305, '0.125', '2021-05-02', 15, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (306, '0.125', '2021-05-02', 16, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (307, '0.125', '2021-05-02', 17, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (308, '0.125', '2021-05-02', 18, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (309, '0.125', '2021-05-02', 19, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (310, '0.125', '2021-05-02', 20, 2, 3);
INSERT INTO `eigen_alternatif` VALUES (311, '0.143', '2021-05-02', 1, 3, 3);
INSERT INTO `eigen_alternatif` VALUES (312, '0.143', '2021-05-02', 3, 3, 3);
INSERT INTO `eigen_alternatif` VALUES (313, '0.143', '2021-05-02', 7, 3, 3);
INSERT INTO `eigen_alternatif` VALUES (314, '0.143', '2021-05-02', 11, 3, 3);
INSERT INTO `eigen_alternatif` VALUES (315, '0.143', '2021-05-02', 21, 3, 3);
INSERT INTO `eigen_alternatif` VALUES (316, '0.143', '2021-05-02', 22, 3, 3);
INSERT INTO `eigen_alternatif` VALUES (317, '0.143', '2021-05-02', 23, 3, 3);
INSERT INTO `eigen_alternatif` VALUES (318, '0.151', '2021-05-02', 2, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (319, '0.115', '2021-05-02', 4, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (320, '0.115', '2021-05-02', 5, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (321, '0.124', '2021-05-02', 6, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (322, '0.124', '2021-05-02', 8, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (323, '0.124', '2021-05-02', 9, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (324, '0.124', '2021-05-02', 10, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (325, '0.124', '2021-05-02', 13, 1, 4);
INSERT INTO `eigen_alternatif` VALUES (326, '0.125', '2021-05-02', 12, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (327, '0.125', '2021-05-02', 14, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (328, '0.125', '2021-05-02', 15, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (329, '0.125', '2021-05-02', 16, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (330, '0.125', '2021-05-02', 17, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (331, '0.125', '2021-05-02', 18, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (332, '0.125', '2021-05-02', 19, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (333, '0.125', '2021-05-02', 20, 2, 4);
INSERT INTO `eigen_alternatif` VALUES (334, '0.143', '2021-05-02', 1, 3, 4);
INSERT INTO `eigen_alternatif` VALUES (335, '0.143', '2021-05-02', 3, 3, 4);
INSERT INTO `eigen_alternatif` VALUES (336, '0.143', '2021-05-02', 7, 3, 4);
INSERT INTO `eigen_alternatif` VALUES (337, '0.143', '2021-05-02', 11, 3, 4);
INSERT INTO `eigen_alternatif` VALUES (338, '0.143', '2021-05-02', 21, 3, 4);
INSERT INTO `eigen_alternatif` VALUES (339, '0.143', '2021-05-02', 22, 3, 4);
INSERT INTO `eigen_alternatif` VALUES (340, '0.143', '2021-05-02', 23, 3, 4);
INSERT INTO `eigen_alternatif` VALUES (341, '0.107', '2021-05-02', 2, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (342, '0.136', '2021-05-02', 4, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (343, '0.136', '2021-05-02', 5, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (344, '0.124', '2021-05-02', 6, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (345, '0.124', '2021-05-02', 8, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (346, '0.124', '2021-05-02', 9, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (347, '0.124', '2021-05-02', 10, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (348, '0.124', '2021-05-02', 13, 1, 5);
INSERT INTO `eigen_alternatif` VALUES (349, '0.125', '2021-05-02', 12, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (350, '0.125', '2021-05-02', 14, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (351, '0.125', '2021-05-02', 15, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (352, '0.125', '2021-05-02', 16, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (353, '0.125', '2021-05-02', 17, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (354, '0.125', '2021-05-02', 18, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (355, '0.125', '2021-05-02', 19, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (356, '0.125', '2021-05-02', 20, 2, 5);
INSERT INTO `eigen_alternatif` VALUES (357, '0.143', '2021-05-02', 1, 3, 5);
INSERT INTO `eigen_alternatif` VALUES (358, '0.143', '2021-05-02', 3, 3, 5);
INSERT INTO `eigen_alternatif` VALUES (359, '0.143', '2021-05-02', 7, 3, 5);
INSERT INTO `eigen_alternatif` VALUES (360, '0.143', '2021-05-02', 11, 3, 5);
INSERT INTO `eigen_alternatif` VALUES (361, '0.143', '2021-05-02', 21, 3, 5);
INSERT INTO `eigen_alternatif` VALUES (362, '0.143', '2021-05-02', 22, 3, 5);
INSERT INTO `eigen_alternatif` VALUES (363, '0.143', '2021-05-02', 23, 3, 5);
INSERT INTO `eigen_alternatif` VALUES (364, '0.151', '2021-05-02', 2, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (365, '0.115', '2021-05-02', 4, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (366, '0.115', '2021-05-02', 5, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (367, '0.124', '2021-05-02', 6, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (368, '0.124', '2021-05-02', 8, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (369, '0.124', '2021-05-02', 9, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (370, '0.124', '2021-05-02', 10, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (371, '0.124', '2021-05-02', 13, 1, 6);
INSERT INTO `eigen_alternatif` VALUES (372, '0.125', '2021-05-02', 12, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (373, '0.125', '2021-05-02', 14, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (374, '0.125', '2021-05-02', 15, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (375, '0.125', '2021-05-02', 16, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (376, '0.125', '2021-05-02', 17, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (377, '0.125', '2021-05-02', 18, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (378, '0.125', '2021-05-02', 19, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (379, '0.125', '2021-05-02', 20, 2, 6);
INSERT INTO `eigen_alternatif` VALUES (380, '0.143', '2021-05-02', 1, 3, 6);
INSERT INTO `eigen_alternatif` VALUES (381, '0.143', '2021-05-02', 3, 3, 6);
INSERT INTO `eigen_alternatif` VALUES (382, '0.143', '2021-05-02', 7, 3, 6);
INSERT INTO `eigen_alternatif` VALUES (383, '0.143', '2021-05-02', 11, 3, 6);
INSERT INTO `eigen_alternatif` VALUES (384, '0.143', '2021-05-02', 21, 3, 6);
INSERT INTO `eigen_alternatif` VALUES (385, '0.143', '2021-05-02', 22, 3, 6);
INSERT INTO `eigen_alternatif` VALUES (386, '0.143', '2021-05-02', 23, 3, 6);
INSERT INTO `eigen_alternatif` VALUES (387, '0.107', '2021-05-04', 2, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (388, '0.136', '2021-05-04', 4, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (389, '0.136', '2021-05-04', 5, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (390, '0.124', '2021-05-04', 6, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (391, '0.124', '2021-05-04', 8, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (392, '0.124', '2021-05-04', 9, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (393, '0.124', '2021-05-04', 10, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (394, '0.124', '2021-05-04', 13, 1, 1);

-- ----------------------------
-- Table structure for eigen_kriteria
-- ----------------------------
DROP TABLE IF EXISTS `eigen_kriteria`;
CREATE TABLE `eigen_kriteria`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `eigen_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `kriteria_seq` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fkkriteria_seq`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `fkkriteria_seq` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eigen_kriteria
-- ----------------------------
INSERT INTO `eigen_kriteria` VALUES (1, '0.206', '2021-05-02', 1);
INSERT INTO `eigen_kriteria` VALUES (2, '0.138', '2021-05-02', 2);
INSERT INTO `eigen_kriteria` VALUES (3, '0.225', '2021-05-02', 3);
INSERT INTO `eigen_kriteria` VALUES (4, '0.109', '2021-05-02', 4);
INSERT INTO `eigen_kriteria` VALUES (5, '0.196', '2021-05-02', 5);
INSERT INTO `eigen_kriteria` VALUES (6, '0.126', '2021-05-02', 6);

-- ----------------------------
-- Table structure for hasil_rangking
-- ----------------------------
DROP TABLE IF EXISTS `hasil_rangking`;
CREATE TABLE `hasil_rangking`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `alternatif_seq` int(11) NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `rangking` int(11) NULL DEFAULT NULL,
  `kategori_seq` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fk_alter`(`alternatif_seq`) USING BTREE,
  INDEX `fkkategori`(`kategori_seq`) USING BTREE,
  CONSTRAINT `fk_alter` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkkategori` FOREIGN KEY (`kategori_seq`) REFERENCES `kategori_alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hasil_rangking
-- ----------------------------
INSERT INTO `hasil_rangking` VALUES (40, 12, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (41, 14, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (42, 15, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (43, 16, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (44, 17, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (45, 18, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (46, 19, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (47, 20, '0.125', 1, 2);
INSERT INTO `hasil_rangking` VALUES (48, 1, '0.143', 1, 3);
INSERT INTO `hasil_rangking` VALUES (49, 3, '0.143', 1, 3);
INSERT INTO `hasil_rangking` VALUES (50, 7, '0.143', 1, 3);
INSERT INTO `hasil_rangking` VALUES (51, 11, '0.143', 1, 3);
INSERT INTO `hasil_rangking` VALUES (52, 21, '0.143', 1, 3);
INSERT INTO `hasil_rangking` VALUES (53, 22, '0.143', 1, 3);
INSERT INTO `hasil_rangking` VALUES (54, 23, '0.143', 1, 3);
INSERT INTO `hasil_rangking` VALUES (55, 2, '0.124', 3, 1);
INSERT INTO `hasil_rangking` VALUES (56, 4, '0.13', 2, 1);
INSERT INTO `hasil_rangking` VALUES (57, 5, '0.131', 1, 1);
INSERT INTO `hasil_rangking` VALUES (58, 6, '0.123', 6, 1);
INSERT INTO `hasil_rangking` VALUES (59, 8, '0.122', 7, 1);
INSERT INTO `hasil_rangking` VALUES (60, 9, '0.124', 3, 1);
INSERT INTO `hasil_rangking` VALUES (61, 10, '0.122', 7, 1);
INSERT INTO `hasil_rangking` VALUES (62, 13, '0.124', 3, 1);

-- ----------------------------
-- Table structure for kategori_alternatif
-- ----------------------------
DROP TABLE IF EXISTS `kategori_alternatif`;
CREATE TABLE `kategori_alternatif`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kategori_alternatif
-- ----------------------------
INSERT INTO `kategori_alternatif` VALUES (1, 'Medium');
INSERT INTO `kategori_alternatif` VALUES (2, 'High End');
INSERT INTO `kategori_alternatif` VALUES (3, 'Low End');

-- ----------------------------
-- Table structure for kriteria
-- ----------------------------
DROP TABLE IF EXISTS `kriteria`;
CREATE TABLE `kriteria`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `kriteria_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kriteria
-- ----------------------------
INSERT INTO `kriteria` VALUES (1, 'Base Clock');
INSERT INTO `kriteria` VALUES (2, 'Boost Clock');
INSERT INTO `kriteria` VALUES (3, 'Memory');
INSERT INTO `kriteria` VALUES (4, 'Memory Clock');
INSERT INTO `kriteria` VALUES (5, 'TDP');
INSERT INTO `kriteria` VALUES (6, 'Harga');

-- ----------------------------
-- Table structure for perbandingan_alternatif
-- ----------------------------
DROP TABLE IF EXISTS `perbandingan_alternatif`;
CREATE TABLE `perbandingan_alternatif`  (
  `seq` int(255) NOT NULL AUTO_INCREMENT,
  `alternatif1_seq` int(11) NULL DEFAULT NULL,
  `alternatif2_seq` int(11) NULL DEFAULT NULL,
  `kategori_seq` int(11) NULL DEFAULT NULL,
  `pilihan_alternatif_seq` int(11) NULL DEFAULT NULL,
  `kriteria_seq` int(11) NULL DEFAULT NULL,
  `nilai` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2132 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of perbandingan_alternatif
-- ----------------------------
INSERT INTO `perbandingan_alternatif` VALUES (1593, 12, 14, 2, 12, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1594, 12, 15, 2, 12, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1595, 12, 16, 2, 16, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1596, 12, 17, 2, 17, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1597, 12, 18, 2, 18, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1598, 12, 19, 2, 19, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1599, 12, 20, 2, 12, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1600, 14, 15, 2, 15, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1601, 14, 16, 2, 14, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1602, 14, 17, 2, 14, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1603, 14, 18, 2, 14, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1604, 14, 19, 2, 19, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1605, 14, 20, 2, 20, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1606, 15, 16, 2, 15, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1607, 15, 17, 2, 15, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1608, 15, 18, 2, 15, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1609, 15, 19, 2, 15, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1610, 15, 20, 2, 15, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1611, 16, 17, 2, 16, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1612, 16, 18, 2, 16, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1613, 16, 19, 2, 19, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1614, 16, 20, 2, 20, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1615, 17, 18, 2, 17, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1616, 17, 19, 2, 17, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1617, 17, 20, 2, 20, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1618, 18, 19, 2, 18, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1619, 18, 20, 2, 20, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1620, 19, 20, 2, 20, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1621, 1, 3, 3, 3, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1622, 1, 7, 3, 7, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1623, 1, 11, 3, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1624, 1, 21, 3, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1625, 1, 22, 3, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1626, 1, 23, 3, 23, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1627, 3, 7, 3, 7, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1628, 3, 11, 3, 3, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1629, 3, 21, 3, 3, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1630, 3, 22, 3, 3, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1631, 3, 23, 3, 3, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1632, 7, 11, 3, 11, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1633, 7, 21, 3, 21, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1634, 7, 22, 3, 22, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1635, 7, 23, 3, 23, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1636, 11, 21, 3, 11, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1637, 11, 22, 3, 22, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1638, 11, 23, 3, 23, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1639, 21, 22, 3, 21, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1640, 21, 23, 3, 23, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1641, 22, 23, 3, 23, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1642, 2, 4, 1, 2, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1643, 2, 5, 1, 5, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1644, 2, 6, 1, 6, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1645, 2, 8, 1, 2, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1646, 2, 9, 1, 2, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1647, 2, 10, 1, 2, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1648, 2, 13, 1, 13, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1649, 4, 5, 1, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1650, 4, 6, 1, 4, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1651, 4, 8, 1, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1652, 4, 9, 1, 9, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1653, 4, 10, 1, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1654, 4, 13, 1, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1655, 5, 6, 1, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1656, 5, 8, 1, 8, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1657, 5, 9, 1, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1658, 5, 10, 1, 10, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1659, 5, 13, 1, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1660, 6, 8, 1, 6, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1661, 6, 9, 1, 9, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1662, 6, 10, 1, 10, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1663, 6, 13, 1, 6, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1664, 8, 9, 1, 8, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1665, 8, 10, 1, 10, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1666, 8, 13, 1, 8, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1667, 9, 10, 1, 10, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1668, 9, 13, 1, 13, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1669, 10, 13, 1, 10, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1670, 12, 14, 2, 12, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1671, 12, 15, 2, 15, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1672, 12, 16, 2, 16, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1673, 12, 17, 2, 17, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1674, 12, 18, 2, 12, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1675, 12, 19, 2, 19, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1676, 12, 20, 2, 12, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1677, 14, 15, 2, 15, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1678, 14, 16, 2, 16, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1679, 14, 17, 2, 17, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1680, 14, 18, 2, 14, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1681, 14, 19, 2, 19, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1682, 14, 20, 2, 20, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1683, 15, 16, 2, 16, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1684, 15, 17, 2, 17, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1685, 15, 18, 2, 18, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1686, 15, 19, 2, 15, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1687, 15, 20, 2, 15, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1688, 16, 17, 2, 17, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1689, 16, 18, 2, 18, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1690, 16, 19, 2, 16, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1691, 16, 20, 2, 20, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1692, 17, 18, 2, 18, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1693, 17, 19, 2, 19, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1694, 17, 20, 2, 17, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1695, 18, 19, 2, 18, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1696, 18, 20, 2, 20, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1697, 19, 20, 2, 19, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1698, 1, 3, 3, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1699, 1, 7, 3, 7, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1700, 1, 11, 3, 11, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1701, 1, 21, 3, 21, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1702, 1, 22, 3, 22, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1703, 1, 23, 3, 1, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1704, 3, 7, 3, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1705, 3, 11, 3, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1706, 3, 21, 3, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1707, 3, 22, 3, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1708, 3, 23, 3, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1709, 7, 11, 3, 7, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1710, 7, 21, 3, 7, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1711, 7, 22, 3, 7, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1712, 7, 23, 3, 23, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1713, 11, 21, 3, 21, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1714, 11, 22, 3, 11, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1715, 11, 23, 3, 11, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1716, 21, 22, 3, 21, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1717, 21, 23, 3, 23, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1718, 22, 23, 3, 22, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1796, 2, 4, 1, 4, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1797, 2, 5, 1, 5, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1798, 2, 6, 1, 2, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1799, 2, 8, 1, 2, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1800, 2, 9, 1, 2, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1801, 2, 10, 1, 10, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1802, 2, 13, 1, 13, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1803, 4, 5, 1, 5, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1804, 4, 6, 1, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1805, 4, 8, 1, 4, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1806, 4, 9, 1, 4, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1807, 4, 10, 1, 4, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1808, 4, 13, 1, 13, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1809, 5, 6, 1, 5, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1810, 5, 8, 1, 5, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1811, 5, 9, 1, 9, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1812, 5, 10, 1, 5, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1813, 5, 13, 1, 5, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1814, 6, 8, 1, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1815, 6, 9, 1, 9, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1816, 6, 10, 1, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1817, 6, 13, 1, 13, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1818, 8, 9, 1, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1819, 8, 10, 1, 10, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1820, 8, 13, 1, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1821, 9, 10, 1, 9, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1822, 9, 13, 1, 13, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1823, 10, 13, 1, 13, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1824, 12, 14, 2, 14, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1825, 12, 15, 2, 15, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1826, 12, 16, 2, 16, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1827, 12, 17, 2, 17, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1828, 12, 18, 2, 18, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1829, 12, 19, 2, 12, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1830, 12, 20, 2, 12, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1831, 14, 15, 2, 14, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1832, 14, 16, 2, 14, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1833, 14, 17, 2, 14, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1834, 14, 18, 2, 18, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1835, 14, 19, 2, 14, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1836, 14, 20, 2, 14, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1837, 15, 16, 2, 16, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1838, 15, 17, 2, 15, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1839, 15, 18, 2, 15, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1840, 15, 19, 2, 19, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1841, 15, 20, 2, 15, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1842, 16, 17, 2, 17, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1843, 16, 18, 2, 16, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1844, 16, 19, 2, 16, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1845, 16, 20, 2, 20, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1846, 17, 18, 2, 18, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1847, 17, 19, 2, 17, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1848, 17, 20, 2, 17, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1849, 18, 19, 2, 18, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1850, 18, 20, 2, 20, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1851, 19, 20, 2, 20, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1852, 1, 3, 3, 1, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1853, 1, 7, 3, 1, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1854, 1, 11, 3, 11, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1855, 1, 21, 3, 1, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1856, 1, 22, 3, 1, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1857, 1, 23, 3, 23, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1858, 3, 7, 3, 3, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1859, 3, 11, 3, 3, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1860, 3, 21, 3, 3, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1861, 3, 22, 3, 3, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1862, 3, 23, 3, 3, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1863, 7, 11, 3, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1864, 7, 21, 3, 21, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1865, 7, 22, 3, 22, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1866, 7, 23, 3, 23, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1867, 11, 21, 3, 11, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1868, 11, 22, 3, 11, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1869, 11, 23, 3, 23, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1870, 21, 22, 3, 22, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1871, 21, 23, 3, 21, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1872, 22, 23, 3, 22, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1873, 2, 4, 1, 2, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1874, 2, 5, 1, 2, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1875, 2, 6, 1, 6, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1876, 2, 8, 1, 2, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1877, 2, 9, 1, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1878, 2, 10, 1, 2, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1879, 2, 13, 1, 2, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1880, 4, 5, 1, 4, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1881, 4, 6, 1, 4, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1882, 4, 8, 1, 4, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1883, 4, 9, 1, 4, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1884, 4, 10, 1, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1885, 4, 13, 1, 13, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1886, 5, 6, 1, 6, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1887, 5, 8, 1, 8, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1888, 5, 9, 1, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1889, 5, 10, 1, 5, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1890, 5, 13, 1, 5, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1891, 6, 8, 1, 8, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1892, 6, 9, 1, 6, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1893, 6, 10, 1, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1894, 6, 13, 1, 6, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1895, 8, 9, 1, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1896, 8, 10, 1, 8, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1897, 8, 13, 1, 13, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1898, 9, 10, 1, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1899, 9, 13, 1, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1900, 10, 13, 1, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1901, 12, 14, 2, 14, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1902, 12, 15, 2, 12, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1903, 12, 16, 2, 12, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1904, 12, 17, 2, 17, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1905, 12, 18, 2, 12, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1906, 12, 19, 2, 19, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1907, 12, 20, 2, 20, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1908, 14, 15, 2, 14, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1909, 14, 16, 2, 14, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1910, 14, 17, 2, 17, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1911, 14, 18, 2, 18, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1912, 14, 19, 2, 19, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1913, 14, 20, 2, 14, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1914, 15, 16, 2, 15, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1915, 15, 17, 2, 15, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1916, 15, 18, 2, 18, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1917, 15, 19, 2, 19, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1918, 15, 20, 2, 20, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1919, 16, 17, 2, 16, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1920, 16, 18, 2, 18, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1921, 16, 19, 2, 19, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1922, 16, 20, 2, 20, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1923, 17, 18, 2, 18, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1924, 17, 19, 2, 19, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1925, 17, 20, 2, 17, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1926, 18, 19, 2, 18, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1927, 18, 20, 2, 18, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1928, 19, 20, 2, 19, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1929, 1, 3, 3, 1, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1930, 1, 7, 3, 7, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1931, 1, 11, 3, 11, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1932, 1, 21, 3, 1, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1933, 1, 22, 3, 22, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1934, 1, 23, 3, 1, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1935, 3, 7, 3, 7, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1936, 3, 11, 3, 11, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1937, 3, 21, 3, 21, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1938, 3, 22, 3, 22, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1939, 3, 23, 3, 23, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1940, 7, 11, 3, 11, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1941, 7, 21, 3, 21, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1942, 7, 22, 3, 22, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1943, 7, 23, 3, 23, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1944, 11, 21, 3, 21, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1945, 11, 22, 3, 11, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1946, 11, 23, 3, 23, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1947, 21, 22, 3, 22, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1948, 21, 23, 3, 23, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1949, 22, 23, 3, 23, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1950, 2, 4, 1, 4, 5, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1951, 2, 5, 1, 5, 5, '2');
INSERT INTO `perbandingan_alternatif` VALUES (1952, 2, 6, 1, 6, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1953, 2, 8, 1, 2, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1954, 2, 9, 1, 2, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1955, 2, 10, 1, 2, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1956, 2, 13, 1, 2, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1957, 4, 5, 1, 5, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1958, 4, 6, 1, 4, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1959, 4, 8, 1, 4, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1960, 4, 9, 1, 9, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1961, 4, 10, 1, 4, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1962, 4, 13, 1, 13, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1963, 5, 6, 1, 6, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1964, 5, 8, 1, 5, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1965, 5, 9, 1, 9, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1966, 5, 10, 1, 5, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1967, 5, 13, 1, 5, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1968, 6, 8, 1, 6, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1969, 6, 9, 1, 9, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1970, 6, 10, 1, 6, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1971, 6, 13, 1, 13, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1972, 8, 9, 1, 8, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1973, 8, 10, 1, 8, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1974, 8, 13, 1, 8, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1975, 9, 10, 1, 10, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1976, 9, 13, 1, 13, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1977, 10, 13, 1, 13, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1978, 12, 14, 2, 12, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1979, 12, 15, 2, 12, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1980, 12, 16, 2, 16, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1981, 12, 17, 2, 12, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1982, 12, 18, 2, 18, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1983, 12, 19, 2, 19, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1984, 12, 20, 2, 20, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1985, 14, 15, 2, 14, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1986, 14, 16, 2, 14, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1987, 14, 17, 2, 17, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1988, 14, 18, 2, 18, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1989, 14, 19, 2, 14, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1990, 14, 20, 2, 14, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1991, 15, 16, 2, 15, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1992, 15, 17, 2, 17, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1993, 15, 18, 2, 15, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1994, 15, 19, 2, 15, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1995, 15, 20, 2, 15, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1996, 16, 17, 2, 17, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1997, 16, 18, 2, 18, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1998, 16, 19, 2, 16, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (1999, 16, 20, 2, 16, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2000, 17, 18, 2, 17, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2001, 17, 19, 2, 17, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2002, 17, 20, 2, 17, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2003, 18, 19, 2, 19, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2004, 18, 20, 2, 18, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2005, 19, 20, 2, 19, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2006, 1, 3, 3, 1, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2007, 1, 7, 3, 7, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2008, 1, 11, 3, 1, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2009, 1, 21, 3, 21, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2010, 1, 22, 3, 22, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2011, 1, 23, 3, 1, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2012, 3, 7, 3, 3, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2013, 3, 11, 3, 11, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2014, 3, 21, 3, 21, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2015, 3, 22, 3, 22, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2016, 3, 23, 3, 3, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2017, 7, 11, 3, 11, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2018, 7, 21, 3, 7, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2019, 7, 22, 3, 22, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2020, 7, 23, 3, 7, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2021, 11, 21, 3, 21, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2022, 11, 22, 3, 11, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2023, 11, 23, 3, 23, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2024, 21, 22, 3, 21, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2025, 21, 23, 3, 23, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2026, 22, 23, 3, 23, 5, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2027, 2, 4, 1, 2, 6, '2');
INSERT INTO `perbandingan_alternatif` VALUES (2028, 2, 5, 1, 2, 6, '2');
INSERT INTO `perbandingan_alternatif` VALUES (2029, 2, 6, 1, 2, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2030, 2, 8, 1, 2, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2031, 2, 9, 1, 2, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2032, 2, 10, 1, 2, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2033, 2, 13, 1, 2, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2034, 4, 5, 1, 5, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2035, 4, 6, 1, 6, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2036, 4, 8, 1, 8, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2037, 4, 9, 1, 4, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2038, 4, 10, 1, 10, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2039, 4, 13, 1, 4, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2040, 5, 6, 1, 5, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2041, 5, 8, 1, 5, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2042, 5, 9, 1, 9, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2043, 5, 10, 1, 5, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2044, 5, 13, 1, 5, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2045, 6, 8, 1, 6, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2046, 6, 9, 1, 9, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2047, 6, 10, 1, 10, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2048, 6, 13, 1, 6, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2049, 8, 9, 1, 9, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2050, 8, 10, 1, 8, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2051, 8, 13, 1, 8, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2052, 9, 10, 1, 9, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2053, 9, 13, 1, 13, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2054, 10, 13, 1, 10, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2055, 12, 14, 2, 12, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2056, 12, 15, 2, 15, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2057, 12, 16, 2, 16, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2058, 12, 17, 2, 12, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2059, 12, 18, 2, 18, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2060, 12, 19, 2, 19, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2061, 12, 20, 2, 12, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2062, 14, 15, 2, 15, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2063, 14, 16, 2, 16, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2064, 14, 17, 2, 17, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2065, 14, 18, 2, 18, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2066, 14, 19, 2, 14, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2067, 14, 20, 2, 20, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2068, 15, 16, 2, 15, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2069, 15, 17, 2, 17, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2070, 15, 18, 2, 18, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2071, 15, 19, 2, 15, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2072, 15, 20, 2, 20, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2073, 16, 17, 2, 17, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2074, 16, 18, 2, 18, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2075, 16, 19, 2, 19, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2076, 16, 20, 2, 20, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2077, 17, 18, 2, 18, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2078, 17, 19, 2, 17, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2079, 17, 20, 2, 17, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2080, 18, 19, 2, 18, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2081, 18, 20, 2, 18, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2082, 19, 20, 2, 19, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2083, 1, 3, 3, 1, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2084, 1, 7, 3, 1, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2085, 1, 11, 3, 11, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2086, 1, 21, 3, 1, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2087, 1, 22, 3, 1, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2088, 1, 23, 3, 23, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2089, 3, 7, 3, 3, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2090, 3, 11, 3, 11, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2091, 3, 21, 3, 3, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2092, 3, 22, 3, 22, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2093, 3, 23, 3, 3, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2094, 7, 11, 3, 7, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2095, 7, 21, 3, 7, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2096, 7, 22, 3, 7, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2097, 7, 23, 3, 7, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2098, 11, 21, 3, 11, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2099, 11, 22, 3, 22, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2100, 11, 23, 3, 23, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2101, 21, 22, 3, 21, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2102, 21, 23, 3, 23, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2103, 22, 23, 3, 22, 6, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2104, 2, 4, 1, 4, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (2105, 2, 5, 1, 5, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (2106, 2, 6, 1, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2107, 2, 8, 1, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2108, 2, 9, 1, 9, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2109, 2, 10, 1, 10, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2110, 2, 13, 1, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2111, 4, 5, 1, 5, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2112, 4, 6, 1, 6, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2113, 4, 8, 1, 8, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2114, 4, 9, 1, 4, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2115, 4, 10, 1, 4, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2116, 4, 13, 1, 13, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2117, 5, 6, 1, 6, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2118, 5, 8, 1, 5, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2119, 5, 9, 1, 9, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2120, 5, 10, 1, 5, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2121, 5, 13, 1, 5, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2122, 6, 8, 1, 8, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2123, 6, 9, 1, 9, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2124, 6, 10, 1, 6, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2125, 6, 13, 1, 6, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2126, 8, 9, 1, 9, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2127, 8, 10, 1, 10, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2128, 8, 13, 1, 13, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2129, 9, 10, 1, 9, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2130, 9, 13, 1, 9, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (2131, 10, 13, 1, 13, 1, '1');

-- ----------------------------
-- Table structure for perbandingan_kriteria
-- ----------------------------
DROP TABLE IF EXISTS `perbandingan_kriteria`;
CREATE TABLE `perbandingan_kriteria`  (
  `seq` int(255) NOT NULL AUTO_INCREMENT,
  `kriteria1_seq` int(11) NULL DEFAULT NULL,
  `kriteria2_seq` int(11) NULL DEFAULT NULL,
  `pilihan_kriteria_seq` int(11) NULL DEFAULT NULL,
  `nilai` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of perbandingan_kriteria
-- ----------------------------
INSERT INTO `perbandingan_kriteria` VALUES (1, 1, 2, 2, '1');
INSERT INTO `perbandingan_kriteria` VALUES (2, 1, 3, 3, '5');
INSERT INTO `perbandingan_kriteria` VALUES (3, 1, 4, 1, '8');
INSERT INTO `perbandingan_kriteria` VALUES (4, 1, 5, 1, '6');
INSERT INTO `perbandingan_kriteria` VALUES (5, 1, 6, 6, '1');
INSERT INTO `perbandingan_kriteria` VALUES (6, 2, 3, 2, '2');
INSERT INTO `perbandingan_kriteria` VALUES (7, 2, 4, 4, '3');
INSERT INTO `perbandingan_kriteria` VALUES (8, 2, 5, 2, '1');
INSERT INTO `perbandingan_kriteria` VALUES (9, 2, 6, 2, '9');
INSERT INTO `perbandingan_kriteria` VALUES (10, 3, 4, 3, '9');
INSERT INTO `perbandingan_kriteria` VALUES (11, 3, 5, 3, '2');
INSERT INTO `perbandingan_kriteria` VALUES (12, 3, 6, 6, '2');
INSERT INTO `perbandingan_kriteria` VALUES (13, 4, 5, 5, '5');
INSERT INTO `perbandingan_kriteria` VALUES (14, 4, 6, 4, '7');
INSERT INTO `perbandingan_kriteria` VALUES (15, 5, 6, 6, '3');

-- ----------------------------
-- Table structure for random_index
-- ----------------------------
DROP TABLE IF EXISTS `random_index`;
CREATE TABLE `random_index`  (
  `seq` int(200) NOT NULL AUTO_INCREMENT,
  `size_matrics` int(200) NOT NULL,
  `random_consistency` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  UNIQUE INDEX `Ukuran_Matriks`(`size_matrics`) USING BTREE,
  UNIQUE INDEX `Ukuran_Matriks_2`(`size_matrics`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of random_index
-- ----------------------------
INSERT INTO `random_index` VALUES (1, 1, '0.00');
INSERT INTO `random_index` VALUES (2, 2, '0.00');
INSERT INTO `random_index` VALUES (4, 3, '0.58');
INSERT INTO `random_index` VALUES (5, 4, '0.90');
INSERT INTO `random_index` VALUES (6, 5, '1.12');
INSERT INTO `random_index` VALUES (7, 6, '1.24');
INSERT INTO `random_index` VALUES (8, 7, '1.32');
INSERT INTO `random_index` VALUES (9, 8, '1.41');
INSERT INTO `random_index` VALUES (10, 9, '1.45');
INSERT INTO `random_index` VALUES (11, 10, '1.49');
INSERT INTO `random_index` VALUES (12, 11, '1.51');
INSERT INTO `random_index` VALUES (13, 12, '1.48');
INSERT INTO `random_index` VALUES (14, 13, '1.56');
INSERT INTO `random_index` VALUES (15, 14, '1.57');
INSERT INTO `random_index` VALUES (16, 15, '1.59');

-- ----------------------------
-- Table structure for skala_saaty
-- ----------------------------
DROP TABLE IF EXISTS `skala_saaty`;
CREATE TABLE `skala_saaty`  (
  `id_saaty` int(20) NOT NULL AUTO_INCREMENT,
  `Intensitas_Kepentingan` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `Definisi` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `Penjelasan` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  PRIMARY KEY (`id_saaty`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of skala_saaty
-- ----------------------------
INSERT INTO `skala_saaty` VALUES (1, '1', 'Pentingnya sama', 'Dua elemen mempunyai pengaruh yang sama besar \nterhadap tujuan');
INSERT INTO `skala_saaty` VALUES (2, '2', 'Lemah atau sedikit', '');
INSERT INTO `skala_saaty` VALUES (3, '3', 'Sedang penting', 'Pengalaman dan penilaian sedikit menyokong \nsatu elemen dibandingkan elemen yang lainnya');
INSERT INTO `skala_saaty` VALUES (4, '4', 'Sedang lebih penting', '');
INSERT INTO `skala_saaty` VALUES (5, '5', 'Kuat penting', 'Pengalaman dan penilaian sangat kuat menyokong \nsatu elemen dibandingkan elemen yang lainnya');
INSERT INTO `skala_saaty` VALUES (6, '6', 'Tambah kuat', '');
INSERT INTO `skala_saaty` VALUES (7, '7', 'Sangat kuat atau menunjukkan pentingnya', 'Satu elemen yang kuat di sokong dan dominan terlihat \ndalam praktek');
INSERT INTO `skala_saaty` VALUES (8, '8', 'Sangat, sangat kuat', '');
INSERT INTO `skala_saaty` VALUES (9, '9', 'Ekstrim pentingnya', 'Bukti yang mendukung elemen yang satu \nterhadap elemen lain memiliki tingkat penegasan tertinggi \nyang mungkin menguatkan');
INSERT INTO `skala_saaty` VALUES (10, 'Kebalikan di atas\n', 'Jika aktifitas i mendapat satu angka dibanding aktifitas j, maka j mempunyai nilai kebalikkannya dibanding dengan i', 'Nilai ini diberikan bila ada dua kompromi diantara 2 pilihan');
INSERT INTO `skala_saaty` VALUES (11, '1.1-1.9', 'Jika kegiatan yang sangat dekat', 'Mungkin sulit untuk menetapkan nilai terbaik tapi bila dibandingkan dengan kegiatan lain yang kontras ukuran angka kecil tidak akan terlalu\r\nterlihat, namun mereka masih bisa menunjukkan\r\nrelatif pentingnya kegiatan.\r\n');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_seq` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `akses` enum('Admin','User','Superadmin') CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'YWRtaW4=', 'Admin');
INSERT INTO `user` VALUES (2, 'tes', 'dXNlcg==', 'User');
INSERT INTO `user` VALUES (5, 'as', 'YXM=', 'Superadmin');

SET FOREIGN_KEY_CHECKS = 1;
