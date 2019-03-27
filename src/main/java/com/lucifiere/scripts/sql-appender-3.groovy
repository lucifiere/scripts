package com.lucifiere.scripts

import java.text.NumberFormat

NumberFormat nf = NumberFormat.getInstance()

def out = new File("sql-0525-2.txt").newPrintWriter()

//200.times {
//    def id = 7204674 + it
//    def no = 76800061217 + it
//    nf.setGroupingUsed(false)
//    nf.setMaximumIntegerDigits(12)
//    nf.setMinimumIntegerDigits(12)
//    def noStr = nf.format(no)
//    out.write("""update coupon_couponinfo set index_no = '${noStr}' where id=${id};
//""")
//}

420.times {
    def id = 7204254 + it
    def no = 76800060797 + it
    nf.setGroupingUsed(false)
    nf.setMaximumIntegerDigits(12)
    nf.setMinimumIntegerDigits(12)
    def noStr = nf.format(no)
    out.write("""update coupon_couponinfo set index_no = '${noStr}' where id=${id};
""")
}

out.flush()



