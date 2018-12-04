package com.scripts

def str = new File(System.getProperty("user.dir") + "/src/main/java/codes2.csv").getText()

def lists = []
str.split("\r").each {
    def cols = it.split(";")
    def list = []
    list << cols[0]
    cols[3..-1].each {
        list << it
    }
    lists << list
}

def out = new File("sql-2.txt").newPrintWriter()

lists[1..-1].each {
    def codes = ""
    it[1..-1].each {
        codes = codes + "'" + it + "'" + ","
    }
    out.write("""update coupon_couponinfo set issuer='${it[0]}' where coupon_code in (${codes.substring(0, codes.length() - 1)});""")
}
out.flush()



