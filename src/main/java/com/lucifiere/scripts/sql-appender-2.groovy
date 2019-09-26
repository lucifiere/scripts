package com.lucifiere.scripts

def str = new File(System.getProperty("user.dir") + "/biz.log").getText()

def lists = []
str.split("\n").each {
    if (it.contains("性能测试"))
        lists << it
}

def sku_rt = []
lists.each {
    if ((it as String).contains("的场景域处理总耗时为")) {
        sku_rt << it
    }
}

println sku_rt.size()



