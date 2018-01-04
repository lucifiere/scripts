import com.sun.xml.internal.ws.util.StringUtils

/**
 * Created by XD.Wang on 2017/12/27.
 * vo生成器
 */

def ddl = """
CREATE TABLE `t_rct_recruit` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `name` varchar(20) NOT NULL COMMENT '申请姓名',
  `phone_no` varchar(11) NOT NULL COMMENT '手机号',
  `city_id` tinyint(4) DEFAULT NULL COMMENT '应聘城市id',
  `city_name` varchar(20) NOT NULL COMMENT '应聘城市名称',
  `job_id` tinyint(4) DEFAULT NULL COMMENT '申请岗位id',
  `job_name` varchar(20) NOT NULL COMMENT '申请岗位名称',
  `create_emp` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_emp` int(11) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应聘信息表';


"""

def sys = "t_mkt"
def bean = [:]
bean.col = []

def rows = ddl.split("\n")
rows = rows.grep {
    it != ""
}

def nameMat = rows[0] =~ /`\S+`/

def beanName = nameMat.find() ? nameMat.group().replace('`', "") : ""
String camelBeanName = beanName.replaceAll(sys, "").toLowerCase().split('_').collect { cc -> StringUtils.capitalize(cc as String) }.join('')
bean.name = camelBeanName[0].toUpperCase() + camelBeanName[1..-1] + "VO"

rows = rows[1..rows.size() - 1]

rows.each {
    if (it.trim().startsWith("`")) {
        def col = [:]

        def colMat = it =~ /`\S+`/
        def colName = colMat.find() ? colMat.group().replace('`', "") : ""
        col.col = colName
        String camelColName = colName.toLowerCase().split('_').collect { cc -> StringUtils.capitalize(cc as String) }.join('')
        col.filed = camelColName[0].toLowerCase() + camelColName[1..-1]

        def desMat = it =~ /(?<=COMMENT ')\S.*(?=')/
        col.des = desMat.find() ? desMat.group().replace('`', "") : ""

        if (it.contains("varchar")) col.type = "String"
        if (it.contains("tinyint") || it.contains("smallint") || it.contains("int")) col.type = "Integer"
        if (it.contains("bigint")) col.type = "Long"
        if (it.contains("decimal") || it.contains("decimal")) col.type = "Double"
        if (it.contains("datetime")) col.type = "Date"
        bean.col << col
    }
}

def outVO = []
outVO << "class ${bean.name} {\n"

bean.col.each {
    outVO << """\t/**
\t  * ${it.des}
\t **/""" << "\t" + "private" + " " + (it.type as String) + " " + (it.filed as String) + ";\n"
}

outVO << "}\n"

println("\nI. 生成VO---------------->\n")
outVO.each {
    println(it)
}

println("\nII. 生成SELECT列---------------->\n")

def outSELECT = []

bean.col.each {
    outSELECT << it.col + " AS " + it.filed
}

outSELECT.each {
    println(it)
}




