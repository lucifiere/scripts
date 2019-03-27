package com.lucifiere.scripts

import com.sun.xml.internal.ws.util.StringUtils

/**
 * Created by XD.Wang on 2017/12/27.
 * vo生成器
 */

def ddl = """
"""

def sys = "t_rct"
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
    outSELECT << it.col + " AS " + it.filed + ","
}

outSELECT.each {
    println(it)
}

println("\nIII. 生成UPDATE列---------------->\n")

def outUPDATE = []

outUPDATE << "<dynamic prepend=\"set\">\n"
bean.col.each {
    outUPDATE << """\t<isNotEmpty property="${it.filed}" prepend="," >"""
    outUPDATE << """\t\t${it.col}=#${it.filed}#""" << "\t</isNotEmpty>\n"
}
outUPDATE << "</dynamic>"

outUPDATE.each {
    println(it)
}

println("\nIV. 生成WHERE列---------------->\n")

def outWHERE = []

bean.col.each {
    outWHERE << """<isNotEmpty property="${it.filed}" prepend="and" >"""
    outWHERE << """\t${it.col}=#${it.filed}#""" << "</isNotEmpty>\n"
}

outWHERE.each {
    println(it)
}

println("\nV. 生成INSERT列---------------->\n")

def outINSERT = []

bean.col.each {
    outINSERT << """\t${it.col}=#${it.filed}#"""
}

outINSERT.each {
    println(it)
}




