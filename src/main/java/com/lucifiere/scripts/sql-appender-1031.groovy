package com.lucifiere.scripts

def str = new File(System.getProperty("user.dir") + "/src/main/java/20181031.csv").getText()

def chongzhi = []
def kaika = []
def xianshang = []
def pos = []
def zhuce = []
def n = []
def choujiang = []
int i = 1
str.split("\r\n").each {
    def cols = it.split(",")
    if (cols.length == 1) {
        if (cols[0] == '0') {
            i++
            return
        }
        if (i == 1) {
            chongzhi << cols[0]
        }
        if (i == 2) {
            kaika << cols[0]
        }
        if (i == 3) {
            xianshang << cols[0]
        }
        if (i == 4) {
            pos << cols[0]
        }
        if (i == 5) {
            zhuce << cols[0]
        }
        if (i == 6) {
            n << cols[0]
        }
        if (i == 7) {
            choujiang << cols[0]
        }
    }
}

def id = ""

n.stream().forEach {
    id = id + "'" + it + "',"
}

println("select count(*) from coupon_couponinfo where source_code in (${id.substring(0, id.length() - 1)})")


