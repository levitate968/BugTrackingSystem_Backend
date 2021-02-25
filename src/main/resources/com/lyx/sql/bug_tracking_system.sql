/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : bug_tracking_system

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-02-25 15:53:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_bug_ticket
-- ----------------------------
DROP TABLE IF EXISTS `t_bug_ticket`;
CREATE TABLE `t_bug_ticket` (
  `bug_id` varchar(255) NOT NULL,
  `team_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status_code` varchar(255) DEFAULT NULL,
  `status_name` varchar(255) DEFAULT NULL,
  `bug_level` varchar(255) DEFAULT NULL,
  `create_id` varchar(255) DEFAULT NULL,
  `create_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `submit_id` varchar(255) DEFAULT NULL,
  `submit_name` varchar(255) DEFAULT NULL,
  `submit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `check_id` varchar(255) DEFAULT NULL,
  `check_name` varchar(255) DEFAULT NULL,
  `check_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deal_id` varchar(255) DEFAULT NULL,
  `deal_name` varchar(255) DEFAULT NULL,
  `deal_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `test_id` varchar(255) DEFAULT NULL,
  `test_name` varchar(255) DEFAULT NULL,
  `test_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `space_1` varchar(255) DEFAULT NULL,
  `space_2` varchar(255) DEFAULT NULL,
  `space_3` varchar(255) DEFAULT NULL,
  `space_4` varchar(255) DEFAULT NULL,
  `space_5` varchar(255) DEFAULT NULL,
  `space_6` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_bug_ticket_line
-- ----------------------------
DROP TABLE IF EXISTS `t_bug_ticket_line`;
CREATE TABLE `t_bug_ticket_line` (
  `bug_line_id` varchar(255) NOT NULL,
  `bug_id` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `add_id` varchar(255) DEFAULT NULL,
  `add_name` varchar(255) DEFAULT NULL,
  `add_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `team_id` varchar(255) DEFAULT NULL,
  `space_1` varchar(255) DEFAULT NULL,
  `space_2` varchar(255) DEFAULT NULL,
  `space_3` varchar(255) DEFAULT NULL,
  `space_4` varchar(255) DEFAULT NULL,
  `space_5` varchar(255) DEFAULT NULL,
  `space_6` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bug_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `emp_id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `team_id` varchar(255) DEFAULT NULL,
  `space_1` varchar(255) DEFAULT NULL,
  `space_2` varchar(255) DEFAULT NULL,
  `space_3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_team
-- ----------------------------
DROP TABLE IF EXISTS `t_team`;
CREATE TABLE `t_team` (
  `team_id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `space_1` varchar(255) DEFAULT NULL,
  `space_2` varchar(255) DEFAULT NULL,
  `space_3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
