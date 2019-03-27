-- 按时间格式进行搜索
SELECT * FROM t WHERE date_format(end_time, '%Y-%m-%d %H:%i:%S') like '%00:00:00%';

/******************************************/
/*   数据库全名 = mo_   */
/*   表名称 = paper_inbound   */
/******************************************/
CREATE TABLE `paper_inbound` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `inbound_no` varchar(50) DEFAULT NULL COMMENT '出库单号 todo：业务是否需要',
  `source_type` tinyint(4) NOT NULL COMMENT '入库来源（发货、入库）todo：名字最好改成XXX_TYPE',
  `paper_apply_count` int(10) NOT NULL COMMENT '申请入库票纸数量',
  `paper_acutal_count` int(10) DEFAULT NULL COMMENT '实际入库票纸数量',
  `paper_apply_type` tinyint(4) NOT NULL COMMENT '票版申请类：票纸、防伪贴',
  `paper_format_type` tinyint(4) NOT NULL COMMENT '板式类型：普通板式、通用板式',
  `paper_format_id` bigint(20) NOT NULL COMMENT '票版ID',
  `inbound_type` tinyint(4) DEFAULT NULL COMMENT '入库方式：印刷入库、空白票退票入库、废票入库',
  `consumer_type` tinyint(4) DEFAULT NULL COMMENT '使用方：（系统部、票务部、商家、自助换票机）',
  `bpms_instance_id` varchar(50)  COMMENT 'BPMS示例ID',
  `print_id` bigint(20) DEFAULT NULL COMMENT '印刷单ID',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID（分公司）',
  `consumer_id` bigint(20) DEFAULT NULL COMMENT '使用方ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '管理项目ID',
  `logistics_no` varchar(50) DEFAULT NULL COMMENT '物流单号',
  `remark` varchar(4000) DEFAULT NULL COMMENT '入库说明',
  `logistics_company_id` SMALLINT(8) DEFAULT NULL COMMENT '物流公司ID',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `extension` varchar(5000) DEFAULT NULL COMMENT '（额外信息：工作流记录）',
  `gmt_create` datetime NOT NULL COMMENT '创建时间（申请时间）',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator_id` varchar(60) NOT NULL COMMENT '申请人',
  `modifier_id` varchar(60) COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_inbound_no` (`inbound_no`),
  KEY `idx_warehouse_id` (`warehouse_id`),
  KEY `idx_gmt_create` (`gmt_create`)
) DEFAULT CHARSET=utf8 COMMENT='入库';

/******************************************/
/*   数据库全名 = mo_   */
/*   表名称 = paper_outbound   */
/******************************************/
CREATE TABLE `paper_outbound` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `outbound_no` varchar(50) NOT NULL COMMENT '入库单号',
  `paper_acutal_count` int(10) NOT NULL COMMENT '实际出库票纸数量',
  `latest_consume_date` datetime NOT NULL COMMENT '最迟申领时间',
  `actual_consume_date` datetime DEFAULT NULL COMMENT '实际申领时间',
  `paper_apply_type` tinyint(4) NOT NULL COMMENT '票版申请类：票纸、防伪贴',
  `paper_format_type` tinyint(4) NOT NULL COMMENT '板式类型：普通板式、通用板式、普通贴、芯片贴',
  `paper_format_id` bigint(20) NOT NULL COMMENT '票版ID',
  `consumer_type` tinyint(4) NOT NULL COMMENT '使用方：（系统部、票务部、商家、自助换票机）',
  `bpms_instance_id` varchar(50) COMMENT 'BPMS示例ID',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `consumer_id` bigint(20) DEFAULT NULL COMMENT '使用方ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '管理项目ID',
  `remark` varchar(4000) DEFAULT NULL COMMENT '出库说明',
  `apporve_remark` varchar(4000) DEFAULT NULL COMMENT '出库审批',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `extension` varchar(5000) DEFAULT NULL COMMENT '（额外信息：工作流记录）',
  `gmt_create` datetime NOT NULL COMMENT '创建时间（申请时间）',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '申请人',
  `modifier_id` varchar(60)COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_outbound_no` (`outbound_no`),
  KEY `idx_warehouse_id` (`warehouse_id`),
  KEY `idx_gmt_create` (`gmt_create`)
) DEFAULT CHARSET=utf8 COMMENT='出库';

/******************************************/
/*   数据库全名 = mo_   */
/*   表名称 = paper_branch_company   */
/******************************************/
CREATE TABLE `paper_branch_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_id` bigint(20) NOT NULL COMMENT '大区',
  `administrator_id` bigint(20) NOT NULL COMMENT '管理员ID',
  `name` varchar(50) COMMENT  '分公司名称',
  `administrator_mobile` varchar(50) COMMENT  '管理员电话',
  `address` varchar(50) COMMENT  '分公司地址',
  `gmt_create` datetime NOT NULL COMMENT '创建时间（申请时间）',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '申请人',
  `modifier_id` varchar(60)COMMENT '修改人',
  PRIMARY KEY (`id`),
  KEY `idx_area_id` (`area_id`)
) DEFAULT CHARSET=utf8 COMMENT='分公司';

/******************************************/
/*   数据库全名 = mo_   */
/*   表名称 = paper_user   */
/******************************************/
CREATE TABLE `paper_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '用户的角色ID',
  `company_id` bigint(20) NOT NULL COMMENT '用户的公司ID',
  `gmt_create` datetime NOT NULL COMMENT '创建时间（申请时间）',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator_id` varchar(60) NOT NULL COMMENT '申请人',
  `modifier_id` varchar(60) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/******************************************/
/*   数据库全名 = mo_   */
/*   表名称 = paper_bound_flow   */
/******************************************/
CREATE TABLE `paper_bound_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source_id` bigint(20) NOT NULL COMMENT '来源ID',
  `source_type` bigint(20) NOT NULL COMMENT '来源类型（调拨单、发货单、入库单、出库单）',
  `paper_no_prefix` varchar(60) DEFAULT NULL COMMENT '票号前缀',
  `paper_no_begin` bigint(20) NOT NULL COMMENT '票号起始',
  `paper_no_end` bigint(20) NOT NULL COMMENT '票号结束',
  `gmt_create` datetime NOT NULL COMMENT '创建时间（申请时间）',
  PRIMARY KEY (`id`),
  KEY `idx_source_id` (`source_id`)
) DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/******************************************/
/*   数据库全名 = mo_   */
/*   表名称 = paper_outbound   */
/******************************************/
CREATE TABLE `paper_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `transfer_no` varchar(50) NOT NULL COMMENT '调拨单号',
  `paper_acutal_count` int(10) NOT NULL COMMENT '实际调拨票纸数量',
  `expected_transfer_date` datetime NOT NULL COMMENT '期望调拨日期',
  `paper_apply_type` tinyint(4) NOT NULL COMMENT '票版申请类：票纸、防伪贴',
  `paper_format_type` tinyint(4) NOT NULL COMMENT '板式类型：普通板式、通用板式',
  `paper_format_id` bigint(20) NOT NULL COMMENT '票版ID',
  `bpms_instance_id` varchar(50) COMMENT 'BPMS示例ID',
  `from_warehouse_id` bigint(20) DEFAULT NULL COMMENT '被调拨仓库ID',
  `to_warehouse_id` bigint(20) DEFAULT NULL COMMENT '当前仓库ID',
  `remark` varchar(4000) DEFAULT NULL COMMENT '调拨说明',
  `apporve_remark` varchar(4000) DEFAULT NULL COMMENT '调拨审批意见',
  `extra_remark` varchar(4000) DEFAULT NULL COMMENT '其他说明',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `extension` varchar(5000) DEFAULT NULL COMMENT '（额外信息：工作流记录）',
  `gmt_create` datetime NOT NULL COMMENT '创建时间（申请时间）',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '申请人',
  `modifier_id` varchar(60)COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_transfer_no` (`transfer_no`),
  KEY `idx_gmt_create` (`gmt_create`)
) DEFAULT CHARSET=utf8 COMMENT='调拨';