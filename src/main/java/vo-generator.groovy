import com.sun.xml.internal.ws.util.StringUtils

/**
 * Created by XD.Wang on 2017/12/27.
 * vo生成器
 */

def ddl = """
CREATE TABLE `t_mkt_activity` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `activity_no` varchar(20) NOT NULL COMMENT '活动编号',
  `activity_name` varchar(20) NOT NULL COMMENT '活动名称',
  `description` varchar(400) DEFAULT NULL COMMENT '活动描述',
  `area_desc` varchar(600) DEFAULT NULL COMMENT '买券活动区域描述',
  `fixed_start_date` datetime DEFAULT NULL COMMENT '活动开始时间',
  `fixed_end_date` datetime DEFAULT NULL COMMENT '活动结束时间',
  `partake_total` int(11) DEFAULT NULL COMMENT '参与总次数,0、不限，不为零时代表限定次数',
  `partaked_times` int(11) DEFAULT '0' COMMENT '已经参与次数',
  `remain_times` int(11) DEFAULT NULL COMMENT '剩余次数',
  `frequency_pre_person` int(11) DEFAULT NULL COMMENT '每人限参与频次',
  `oper_status` tinyint(4) DEFAULT '0' COMMENT '操作状态(0:已新建 1:已上线 2:已下线)',
  `activity_type` tinyint(4) DEFAULT '0' COMMENT '活动类型1:营销活动 2:发券活动 3:买券活动',
  `proposal_id` varchar(100) DEFAULT NULL,
  `area_relation` tinyint(4) DEFAULT NULL COMMENT '区域间关系（1：按优先级匹配其一）',
  `apply_city` tinyint(4) DEFAULT NULL COMMENT '适用城市(0:不限 1:限制)-买券活动',
  `photo_url` varchar(200) DEFAULT NULL COMMENT '活动图片url（安卓）',
  `second_photo_url` varchar(200) DEFAULT NULL COMMENT '活动图片url（IOS）',
  `show_priority` tinyint(4) DEFAULT NULL COMMENT '展示优先级',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态(0:无效 1:有效)',
  `config_status` tinyint(4) DEFAULT '0' COMMENT '配置状态(0:未配置 1:已配置)',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `create_emp` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp` int(11) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `index_activity_no` (`activity_no`),
  KEY `index_proposal_id` (`proposal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=262 DEFAULT CHARSET=utf8 COMMENT='营销活动信息';
"""

static def camel(s) {

}

def bean = [:]
bean.col = []

def rows = ddl.split("\n")
rows = rows.grep {
    it != ""
}

def nameMat = rows[0] =~ /`\S+`/

def beanName = nameMat.find() ? nameMat.group().replace('`', "") : ""
String camelBeanName = beanName.replaceAll("t_mkt", "").toLowerCase().split('_').collect { cc -> StringUtils.capitalize(cc as String) }.join('')
bean.name = camelBeanName[0].toLowerCase() + camelBeanName[1..-1] + "VO"

rows = rows[1..rows.size() - 1]

rows.each {
    if (it.trim().startsWith("`")) {
        def col = [:]

        def colMat = it =~ /`\S+`/
        def colName = colMat.find() ? colMat.group().replace('`', "") : ""
        String camelColName = colName.toLowerCase().split('_').collect { cc -> StringUtils.capitalize(cc as String) }.join('')
        col.colName = camelColName[0].toLowerCase() + camelColName[1..-1]

        def desMat = it =~ /(?<=COMMENT ')\S.*(?=')/
        col.des = desMat.find() ? desMat.group().replace('`', "") : ""

        if (it.contains("varchar")) col.type = "String"
        if (it.contains("bigint")) col.type = "Long"
        if (it.contains("tinyint") || it.contains("smallint") || it.contains("int")) col.type = "Integer"
        if (it.contains("decimal") || it.contains("decimal")) col.type = "Double"
        if (it.contains("datetime")) col.type = "Date"
        bean.col << col
    }
}

def out = []
out << "class ${bean.name} {\n"

bean.col.each {
    out << """\t/**
\t  * ${it.des}
\t **/""" << "\t" + "private" + " " + it.type + " " + it.colName + ";\n"
}

out << "}\n"

out.each {
    println(it)
}
