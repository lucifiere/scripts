/**
 * Created by XD.Wang on 2018/1/9.
 *
 */

def sql = []

1000.times {
    it = it + 101
    if ((it as String).length() == 1) it = "00" + it
    if ((it as String).length() == 2) it = "0" + it
    sql << """INSERT INTO `t_mkt_invitation_code`(`invitation_code`,`invitation_type`,`source_no`,`source_name`,`status`,`create_emp`,`create_time`,`modify_emp`,`modify_time`,`delete_time`,`source_id`,`use_status`) VALUES ('MK20180109${it}', '1', 'CA201710160001', '新人免费赠饮1杯咖啡', '1', '497', NOW(), '497', NOW(), null, '17', '0');"""
}

sql.each {
    println(it)
}