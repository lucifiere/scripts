package com.lucifiere.scripts

def config = [
        schema: "http",
        host  : ":11.160.81.137",
        path  : "marketing/rule/freeCoupon/oper/list",
        token : "3CB6BDE78DD6B749772AA6B6A931BDE2"
]

def param = [:]

param.activityCode = ""
param.activityCode = ""
param.activityName = ""
param.activityIntro = ""
param.activityTag = ""
param.activityDesc = ""
param.cinemaLinkIds = ""
param.channelCodes = ""
param.startTime = ""
param.endTime = ""
param.auditFlag = ""

def url = config.schema + "://" +
        config.host + "/" +
        config.path + "?" +
        "access_token=" +
        config.token +
        "&"

def query = ""
param.each {
    query = query + it.key + "=" + it.value + "&"
}

println(url + query.substring(0, query.length() - 1))