import com.alibaba.fastjson.JSON

def more = """
[{"name":"luckymarketing.appConfig.getOrderForAnotherConfig","beanId":"appConfigRemoteService","descipt":"获取再来一杯表示","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getOrderForAnotherConfig"},{"name":"luckymarketing.activity.sendCouponByMemberAct","beanId":"activityRemoteService","descipt":"拉新活动发券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"sendCouponByMemberAct"},{"name":"luckymarketing.activity.getActivityMemberByParams","beanId":"activityRemoteService","descipt":"获取拉新活动信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getActivityMemberByParams"},{"name":"luckymarketing.activity.getNewMemberRewardAct","beanId":"activityRemoteService","descipt":"根据方案获取所含券的数量","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getNewMemberRewardAct"},{"name":"luckymarketing.activity.getActivityMemberByChannel","beanId":"activityRemoteService","descipt":"获取会员拉新奖励","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getActivityMemberByChannel"},{"name":"luckymarketing.coffeeStore.getBuyCouponConfirmInfo","beanId":"coffeeStoreRemoteService","descipt":"校验组合买券结果并计算分摊金额","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getBuyCouponConfirmInfo"},{"name":"luckymarketing.coffeeStore.getGivenCouponSign","beanId":"appConfigRemoteService","descipt":"获取赠券标识","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getGivenCouponSign"},{"name":"luckymarketing.coffeeStore.checkCoffeeStoreLimitNum","beanId":"coffeeStoreRemoteService","descipt":"检查咖啡库券限制数量","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"checkCoffeeStoreLimitNum"},{"name":"luckymarketing.appConfig.getInvitationCopyWritingByChannel","beanId":"appConfigRemoteService","descipt":"获取所有可用的分享渠道根据渠道获取邀请好友分享文案配置","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getInvitationCopyWritingByChannel"},{"name":"luckymarketing.appConfig.getValidShareChannel","beanId":"appConfigRemoteService","descipt":"获取所有可用的分享渠道","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getValidShareChannel"},{"name":"luckymarketing.appConfig.getAppPopupConfig","beanId":"appConfigRemoteService","descipt":"获取弹窗配置信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getAppPopupConfig"},{"name":"luckymarketing.appConfig.getAppInvitationBannerConfig","beanId":"appConfigRemoteService","descipt":"获取邀请好友的banner的相关信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getAppInvitationBannerConfig"},{"name":"luckymarketing.appConfig.getSupplyCouponConfig","beanId":"appConfigRemoteService","descipt":"获取“补充杯券”标识的相关信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getSupplyCouponConfig"},{"name":"luckymarketing.coffeeStore.getBuyCouponPreferenceDesc","beanId":"coffeeStoreRemoteService","descipt":"获取优惠提示信息和赠送的券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getBuyCouponPreferenceDesc"},{"name":"luckymarketing.activity.sendCouponByInvitationCode","beanId":"activityRemoteService","descipt":"根据营销邀请码发放券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"sendCouponByInvitationCode"},{"name":"luckymarketing.invitation.checkInvitationCodeOfMKT","beanId":"invitationRemoteService","descipt":"校验公司营销邀请码","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"checkInvitationCodeOfMKT"},{"name":"luckymarketing.activity.sendCouponByAct","beanId":"activityRemoteService","descipt":"根据活动编号给多个会员批量发券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"sendCouponByAct"},{"name":"luckymarketing.coupon.getMemberCenterCoffeeStoreTwoLevelList","beanId":"coffeeStoreRemoteService","descipt":"会员中心获取咖啡库二级列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCenterCoffeeStoreTwoLevelList"},{"name":"luckymarketing.coupon.getMemberCenterCoffeeStoreOneLevelList","beanId":"coffeeStoreRemoteService","descipt":"会员中心获取咖啡库一级列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCenterCoffeeStoreOneLevelList"},{"name":"luckymarketing.coupon.backMemberCoffeeStoreStatus","beanId":"coffeeStoreRemoteService","descipt":"回退会员优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"backMemberCoffeeStoreStatus"},{"name":"luckymarketing.coupon.changeMemberCoffeeStoreStatus","beanId":"coffeeStoreRemoteService","descipt":"更改会员优惠券状态","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeMemberCoffeeStoreStatus"},{"name":"luckymarketing.coupon.getMemberCenterCoffeeStoreList","beanId":"coffeeStoreRemoteService","descipt":"获取会员中心咖啡库列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCenterCoffeeStoreList"},{"name":"luckymarketing.coffeeStoreCoupon.getRecordList","beanId":"coffeeStoreRemoteService","descipt":"获取咖啡库券分页列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreRecordList"},{"name":"luckymarketing.coffeeStore.getAllCoffeeStoreLevel","beanId":"coffeeStoreRemoteService","descipt":"获取所有咖啡库券券级别","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getAllCoffeeStoreLevel"},{"name":"luckymarketing.coupon.backMemberCouponStatus","beanId":"couponOfMemberRemoteService","descipt":"订单回调","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"backMemberCouponStatus"},{"name":"luckymarketing.coffeeStore.matchCoffeeStoreProposal","beanId":"coffeeStoreRemoteService","descipt":"商品匹配最优买券方案","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"matchCoffeeStoreProposal"},{"name":"luckymarketing.receiptRemoteService.getReceipt","beanId":"receiptRemoteService","descipt":"获取提示语","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getReceipt"},{"name":"luckymarketing.exhibition.getCarouselFigureByPosition","beanId":"exhibitionRemoteService","descipt":"app轮播图","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCarouselFigureByPosition"},{"name":"luckymarketing.coupon.getCoffeeStoreExpireType","beanId":"coffeeStoreRemoteService","descipt":"获取咖啡库券到期类型","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreExpireType"},{"name":"luckymarketing.coupon.financeDeleteRefundOrder","beanId":"coffeeStoreRemoteService","descipt":"财务删除退款单","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeDeleteRefundOrder"},{"name":"luckymarketing.coupon.financeRefundCallback","beanId":"coffeeStoreRemoteService","descipt":"财务新建退款单回调","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeRefundCallback"},{"name":"luckymarketing.coupon.financeCreateRefundOrder","beanId":"coffeeStoreRemoteService","descipt":"财务新建退款单","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeCreateRefundOrder"},{"name":"luckymarketing.coupon.financeRedDashedInvoice","beanId":"coffeeStoreRemoteService","descipt":"财务红冲发票","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeRedDashedInvoice"},{"name":"luckymarketing.coupon.financeInvoiceCallback","beanId":"coffeeStoreRemoteService","descipt":"财务发票回调","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeInvoiceCallback"},{"name":"luckymarketing.coupon.financeCreateInvoice","beanId":"coffeeStoreRemoteService","descipt":"财务新建发票","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeCreateInvoice"},{"name":"luckymarketing.coffeeStoreRemoteService.createCoffeeStore","beanId":"coffeeStoreRemoteService","descipt":"保存优惠券领用记录","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"createCoffeeStore"},{"name":"luckymarketing.coupon.getBuyCouponConfirmInfo","beanId":"coffeeStoreRemoteService","descipt":"获取买券确认页信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getBuyCouponConfirmInfo"},{"name":"luckymarketing.coupon.getCoffeeStoreListByIds","beanId":"coffeeStoreRemoteService","descipt":"通过咖啡库id查询咖啡库券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreListByIds"},{"name":"luckymarketing.coupon.getCoffeeStoreListByCommodity","beanId":"coffeeStoreRemoteService","descipt":"通过商品查询咖啡库券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreListByCommodity"},{"name":"luckymarketing.coupon.getCoffeeStoreListByOrderId","beanId":"coffeeStoreRemoteService","descipt":"通过订单查询咖啡库券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreListByOrderId"},{"name":"luckymarketing.coupon.getMemberCoffeeStoreList","beanId":"coffeeStoreRemoteService","descipt":"获取会员咖啡库列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCoffeeStoreList"},{"name":"luckymarketing.activity.loadActivityBuyDetailList","beanId":"activityRemoteService","descipt":"获取 买券活动详情列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"loadActivityBuyDetailList"},{"name":"luckymarketing.activity.getActivitiesBuy","beanId":"activityRemoteService","descipt":"获取 买券活动列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getActivitiesBuy"},{"name":"luckymarketing.activity.changeActivityTimes2","beanId":"activityRemoteService","descipt":"减次数版本2","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeActivityTimes2"},{"name":"luckymarketing.coupon.sendCouponForNewMember","beanId":"couponRemoteService","descipt":"新会员注册发券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"sendCoupon4NewMember"},{"name":"luckymarketing.activity.planPriority","beanId":"activityRemoteService","descipt":"方案优先级列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"planPriority"},{"name":"luckymarketing.activity.changeActivityTimes","beanId":"activityRemoteService","descipt":"修改活动可用次数","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeActivityTimes"},{"name":"luckymarketing.job.disableCoupon","beanId":"sendRecordRemoteService","descipt":"优惠券失效","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"disableCoupon"},{"name":"luckymarketing.job.disabledSendRecord","beanId":"sendRecordRemoteService","descipt":"优惠券失效","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"disabledSendRecord"},{"name":"luckymarketing.invitation.createActivityMember","beanId":"invitationRemoteService","descipt":"营销活动拉新","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"createActivityMember"},{"name":"luckymarketing.invitation.updateStatus","beanId":"invitationRemoteService","descipt":"修改邀请码状态","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"updateStatus"},{"name":"luckymarketing.coupon.getRecordList","beanId":"couponOfMemberRemoteService","descipt":"领用记录查询","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getRecordList"},{"name":"luckymarketing.invitation.getSourceNo","beanId":"invitationRemoteService","descipt":"营销码","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getSourceNo"},{"name":"luckymarketing.invitation.getMemberInvitationCode","beanId":"invitationRemoteService","descipt":"生成会员邀请码","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberInvitationCode"},{"name":"luckymarketing.activity.checkActivity","beanId":"activityRemoteService","descipt":"检查订单适用优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"checkActivity"},{"name":"luckymarketing.exhibition.getCarouselFigureByTerminal","beanId":"exhibitionRemoteService","descipt":"加载轮播图","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCarouselFigureByTerminal"},{"name":"luckymarketing.tag.getTagByCommodity","beanId":"tagRemoteService","descipt":"加载商品tag","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getTagByCommodity"},{"name":"luckymarketing.activity.getActivities","beanId":"activityRemoteService","descipt":"获取营销活动信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getActivities"},{"name":"luckymarketing.coupon.changeMemberCouponStatus","beanId":"couponOfMemberRemoteService","descipt":"更改会员优惠券状态","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeMemberCouponStatus"},{"name":"luckymarketing.coupon.getCouponOfFreeCount","beanId":"couponRemoteService","descipt":"咖啡库数量，及其他数量","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponOfFreeCount"},{"name":"luckymarketing.coupon.getCouponOfFree","beanId":"couponRemoteService","descipt":"咖啡库，即免费商品的优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponOfFree"},{"name":"luckymarketing.coupon.getCashOneDiscountOneCoupon","beanId":"couponRemoteService","descipt":"立减，立折优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCashOneDiscountOneCoupon"},{"name":"luckymarketing.coupon.getCouponByIds","beanId":"couponRemoteService","descipt":"优惠券列表获取优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByIds"},{"name":"luckymarketing.coupon.getCouponByMemberId","beanId":"couponRemoteService","descipt":"通过会员ID获取优惠券，分页","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByMemberId"},{"name":"luckymarketing.coupon.checkCoupon","beanId":"couponRemoteService","descipt":"检查优惠券是否可用","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"checkCoupon"},{"name":"luckymarketing.coupon.getCouponByMemberIdCouponId","beanId":"couponRemoteService","descipt":"通过会员ID，优惠券ID加载优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByMemberIdCouponId"},{"name":"luckymarketing.coupon.getCouponByCommodity","beanId":"couponRemoteService","descipt":"通过商品加载优惠券信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByCommodity"}]
"""

def less = """
[{"name":"luckymarketing.invitation.checkInvitationCodeOfMKT","beanId":"invitationRemoteService","descipt":"校验公司营销邀请码","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"checkInvitationCodeOfMKT"},{"name":"luckymarketing.activity.sendCouponByInvitationCode","beanId":"activityRemoteService","descipt":"根据营销邀请码发放券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"sendCouponByInvitationCode"},{"name":"luckymarketing.coupon.getMemberCenterCoffeeStoreOneLevelList","beanId":"coffeeStoreRemoteService","descipt":"会员中心获取咖啡库一级列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCenterCoffeeStoreOneLevelList"},{"name":"luckymarketing.coupon.getMemberCenterCoffeeStoreTwoLevelList","beanId":"coffeeStoreRemoteService","descipt":"会员中心获取咖啡库二级列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCenterCoffeeStoreTwoLevelList"},{"name":"luckymarketing.activity.sendCouponByAct","beanId":"activityRemoteService","descipt":"根据活动编号给会员发券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"sendCouponByAct"},{"name":"luckymarketing.coupon.getCashOneDiscountOneCoupon","beanId":"couponRemoteService","descipt":"立减，立折优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCashOneDiscountOneCoupon"},{"name":"luckymarketing.coupon.getMemberCoffeeStoreList","beanId":"coffeeStoreRemoteService","descipt":"获取会员咖啡库列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCoffeeStoreList"},{"name":"luckymarketing.coupon.getCoffeeStoreListByOrderId","beanId":"coffeeStoreRemoteService","descipt":"通过订单查询咖啡库券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreListByOrderId"},{"name":"luckymarketing.coupon.getCoffeeStoreListByCommodity","beanId":"coffeeStoreRemoteService","descipt":"通过商品查询咖啡库券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreListByCommodity"},{"name":"luckymarketing.coupon.getCoffeeStoreListByIds","beanId":"coffeeStoreRemoteService","descipt":"通过咖啡库id查询咖啡库券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreListByIds"},{"name":"luckymarketing.coupon.getCoffeeStoreAmountByPlan","beanId":"coffeeStoreRemoteService","descipt":"通过方案查询咖啡库信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreAmountByPlan"},{"name":"luckymarketing.coffeeStoreRemoteService.createCoffeeStore","beanId":"coffeeStoreRemoteService","descipt":"保存优惠券领用记录","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"createCoffeeStore"},{"name":"luckymarketing.coupon.financeCreateInvoice","beanId":"coffeeStoreRemoteService","descipt":"财务新建发票","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeCreateInvoice"},{"name":"luckymarketing.coupon.financeInvoiceCallback","beanId":"coffeeStoreRemoteService","descipt":"财务发票回调","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeInvoiceCallback"},{"name":"luckymarketing.coupon.financeRedDashedInvoice","beanId":"coffeeStoreRemoteService","descipt":"财务红冲发票","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeRedDashedInvoice"},{"name":"luckymarketing.coupon.financeCreateRefundOrder","beanId":"coffeeStoreRemoteService","descipt":"财务新建退款单","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeCreateRefundOrder"},{"name":"luckymarketing.coupon.financeRefundCallback","beanId":"coffeeStoreRemoteService","descipt":"财务新建退款单回调","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeRefundCallback"},{"name":"luckymarketing.coupon.financeDeleteRefundOrder","beanId":"coffeeStoreRemoteService","descipt":"财务删除退款单","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"financeDeleteRefundOrder"},{"name":"luckymarketing.coupon.getCoffeeStoreExpireType","beanId":"coffeeStoreRemoteService","descipt":"获取咖啡库券到期类型","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreExpireType"},{"name":"luckymarketing.exhibition.getCarouselFigureByPosition","beanId":"exhibitionRemoteService","descipt":"app轮播图","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCarouselFigureByPosition"},{"name":"luckymarketing.receiptRemoteService.getReceipt","beanId":"receiptRemoteService","descipt":"获取提示语","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getReceipt"},{"name":"luckymarketing.coffeeStore.matchCoffeeStoreProposal","beanId":"coffeeStoreRemoteService","descipt":"商品匹配最优买券方案","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"matchCoffeeStoreProposal"},{"name":"luckymarketing.coupon.backMemberCouponStatus","beanId":"couponOfMemberRemoteService","descipt":"订单回调","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"backMemberCouponStatus"},{"name":"luckymarketing.coffeeStore.getAllCoffeeStoreLevel","beanId":"coffeeStoreRemoteService","descipt":"获取所有咖啡库券券级别","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getAllCoffeeStoreLevel"},{"name":"luckymarketing.coffeeStoreCoupon.getRecordList","beanId":"coffeeStoreRemoteService","descipt":"获取咖啡库券分页列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCoffeeStoreRecordList"},{"name":"luckymarketing.coupon.getMemberCenterCoffeeStoreList","beanId":"coffeeStoreRemoteService","descipt":"获取会员中心咖啡库列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberCenterCoffeeStoreList"},{"name":"luckymarketing.coupon.changeMemberCoffeeStoreStatus","beanId":"coffeeStoreRemoteService","descipt":"更改会员优惠券状态","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeMemberCoffeeStoreStatus"},{"name":"luckymarketing.coupon.backMemberCoffeeStoreStatus","beanId":"coffeeStoreRemoteService","descipt":"回退会员优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"backMemberCoffeeStoreStatus"},{"name":"luckymarketing.activity.getActivitiesBuy","beanId":"activityRemoteService","descipt":"获取 买券活动列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getActivitiesBuy"},{"name":"luckymarketing.activity.loadActivityBuyDetailList","beanId":"activityRemoteService","descipt":"获取 买券活动详情列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"loadActivityBuyDetailList"},{"name":"luckymarketing.activity.changeActivityTimes2","beanId":"activityRemoteService","descipt":"减次数版本2","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeActivityTimes2"},{"name":"luckymarketing.coupon.sendCouponForNewMember","beanId":"couponRemoteService","descipt":"新会员注册发券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"sendCoupon4NewMember"},{"name":"luckymarketing.coupon.getCouponByMemberId","beanId":"couponRemoteService","descipt":"通过会员ID获取优惠券，分页","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByMemberId"},{"name":"luckymarketing.activity.planPriority","beanId":"activityRemoteService","descipt":"方案优先级列表","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"planPriority"},{"name":"luckymarketing.tag.getTagByCommodity","beanId":"tagRemoteService","descipt":"加载商品tag","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getTagByCommodity"},{"name":"luckymarketing.activity.getActivities","beanId":"activityRemoteService","descipt":"获取营销活动信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getActivities"},{"name":"luckymarketing.coupon.changeMemberCouponStatus","beanId":"couponOfMemberRemoteService","descipt":"更改会员优惠券状态","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeMemberCouponStatus"},{"name":"luckymarketing.coupon.getCouponOfFreeCount","beanId":"couponRemoteService","descipt":"咖啡库数量，及其他数量","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponOfFreeCount"},{"name":"luckymarketing.coupon.getCouponOfFree","beanId":"couponRemoteService","descipt":"咖啡库，即免费商品的优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponOfFree"},{"name":"luckymarketing.coupon.getCouponByIds","beanId":"couponRemoteService","descipt":"优惠券列表获取优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByIds"},{"name":"luckymarketing.coupon.checkCoupon","beanId":"couponRemoteService","descipt":"检查优惠券是否可用","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"checkCoupon"},{"name":"luckymarketing.coupon.getCouponByMemberIdCouponId","beanId":"couponRemoteService","descipt":"通过会员ID，优惠券ID加载优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByMemberIdCouponId"},{"name":"luckymarketing.coupon.getCouponByCommodity","beanId":"couponRemoteService","descipt":"通过商品加载优惠券信息","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCouponByCommodity"},{"name":"luckymarketing.activity.changeActivityTimes","beanId":"activityRemoteService","descipt":"修改活动可用次数","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"changeActivityTimes"},{"name":"luckymarketing.job.disableCoupon","beanId":"sendRecordRemoteService","descipt":"优惠券失效","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"disableCoupon"},{"name":"luckymarketing.job.disabledSendRecord","beanId":"sendRecordRemoteService","descipt":"优惠券失效","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"disabledSendRecord"},{"name":"luckymarketing.invitation.createActivityMember","beanId":"invitationRemoteService","descipt":"营销活动拉新","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"createActivityMember"},{"name":"luckymarketing.invitation.updateStatus","beanId":"invitationRemoteService","descipt":"修改邀请码状态","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"updateStatus"},{"name":"luckymarketing.coupon.getRecordList","beanId":"couponOfMemberRemoteService","descipt":"领用记录查询","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getRecordList"},{"name":"luckymarketing.invitation.getSourceNo","beanId":"invitationRemoteService","descipt":"营销码","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getSourceNo"},{"name":"luckymarketing.invitation.getMemberInvitationCode","beanId":"invitationRemoteService","descipt":"生成会员邀请码","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getMemberInvitationCode"},{"name":"luckymarketing.activity.checkActivity","beanId":"activityRemoteService","descipt":"检查订单适用优惠券","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"checkActivity"},{"name":"luckymarketing.exhibition.getCarouselFigureByTerminal","beanId":"exhibitionRemoteService","descipt":"加载轮播图","connectionTimeOut":-1,"readTimeOut":-1,"needResult":1,"methodName":"getCarouselFigureByTerminal"}]
"""

more = JSON.parseArray(more, Service.class)
less = JSON.parseArray(less, Service.class)

more.removeAll(less)

println(JSON.toJSONString(more))

class Service {

    String name
    String beanId
    String descipt
    Integer connectionTimeOut
    Integer readTimeOut
    Integer needResult
    String methodName

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getBeanId() {
        return beanId
    }

    void setBeanId(String beanId) {
        this.beanId = beanId
    }

    String getDescipt() {
        return descipt
    }

    void setDescipt(String descipt) {
        this.descipt = descipt
    }

    Integer getConnectionTimeOut() {
        return connectionTimeOut
    }

    void setConnectionTimeOut(Integer connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut
    }

    Integer getReadTimeOut() {
        return readTimeOut
    }

    void setReadTimeOut(Integer readTimeOut) {
        this.readTimeOut = readTimeOut
    }

    Integer getNeedResult() {
        return needResult
    }

    void setNeedResult(Integer needResult) {
        this.needResult = needResult
    }

    String getMethodName() {
        return methodName
    }

    void setMethodName(String methodName) {
        this.methodName = methodName
    }

    @Override
    boolean equals(Object obj) {
        return obj instanceof Service && this.name == (obj as Service).name
    }

}
