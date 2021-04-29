/*
 Navicat Premium Data Transfer

 Source Server         : PAPANK
 Source Server Type    : MySQL
 Source Server Version : 100136
 Source Host           : localhost:3306
 Source Schema         : tugas_akhir_agasta

 Target Server Type    : MySQL
 Target Server Version : 100136
 File Encoding         : 65001

 Date: 29/04/2021 06:51:33
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
  `seq` int(255) NOT NULL AUTO_INCREMENT,
  `kriteria_seq` int(255) NULL DEFAULT NULL,
  `alternatif_seq` int(255) NULL DEFAULT NULL,
  `content_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `alternatif_seq`(`alternatif_seq`) USING BTREE,
  INDEX `kriteria_seq`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `alternatif_seq` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `kriteria_seq` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

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
-- Table structure for bobot_alternatif_kriteria
-- ----------------------------
DROP TABLE IF EXISTS `bobot_alternatif_kriteria`;
CREATE TABLE `bobot_alternatif_kriteria`  (
  `seq` int(255) NOT NULL AUTO_INCREMENT,
  `akternatif_kriteria_seq` int(255) NULL DEFAULT NULL,
  `nilai` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `akternatif_kriteria_seq`(`akternatif_kriteria_seq`) USING BTREE,
  CONSTRAINT `akternatif_kriteria_seq` FOREIGN KEY (`akternatif_kriteria_seq`) REFERENCES `alternatif_kriteria` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for eigen
-- ----------------------------
DROP TABLE IF EXISTS `eigen`;
CREATE TABLE `eigen`  (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `eigen_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `kriteria_seq` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fkkriteria_seq`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `fkkriteria_seq` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eigen
-- ----------------------------
INSERT INTO `eigen` VALUES (1, '0.202', '2021-04-25', 1);
INSERT INTO `eigen` VALUES (2, '0.207', '2021-04-25', 2);
INSERT INTO `eigen` VALUES (3, '0.185', '2021-04-25', 3);
INSERT INTO `eigen` VALUES (4, '0.128', '2021-04-25', 4);
INSERT INTO `eigen` VALUES (5, '0.148', '2021-04-25', 5);
INSERT INTO `eigen` VALUES (6, '0.131', '2021-04-25', 6);

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_seq` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

SET FOREIGN_KEY_CHECKS = 1;
