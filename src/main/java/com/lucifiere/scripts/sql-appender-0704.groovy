package com.lucifiere.scripts

def str = new File(System.getProperty("user.dir") + "/src/main/java/201807.csv").getText()

def lists = []
str.split("\r").each {
    def cols = it.split(";")
    if(cols.length>3)
    lists << cols[2]
}

def id = ""

lists.stream().forEach {
    id = id + it + ","
}


println("select account_id,coupon_name,coupon_code,start_time,end_time from coupon_couponinfo where account_id in (${id.substring(0, id.length() - 1)})")


