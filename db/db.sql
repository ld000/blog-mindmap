create database blog_mindmap;
use blog_mindmap;
-- set sql_mode='';
CREATE TABLE `mindmap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mindmap_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '脑图Id',
  `content` text COLLATE utf8_bin NOT NULL COMMENT '脑图',
  `selections` text COLLATE utf8_bin NOT NULL COMMENT '已选节点',
  `version_no` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '版本号',
  `head_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '当前版本',
  `create_time` datetime NOT NULL DEFAULT '1001-01-01 00:00:00',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='脑图';

ALTER TABLE mindmap ADD INDEX idx_mindmap_id (`mindmap_id`);