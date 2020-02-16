package com.zwq.lock;

/**
 * @author zwq  wenqiang.zheng@jdxiaokang.cn
 * @project: settleservice
 * @description:  redis相关key
 * @date 2020/1/2
 */
public class RedisKeys {

    private static final String SERVICE = "settleService:";
    private static final String BUILD_DATA = "buildData:";
    private static final String REWARD = "reward:";
    private static final String RECHARGE = "recharge:";
    private static final String PURCHASE = "purchase:";
    private static final String ORDER_AFTER_SALES = "afterSales:";

    /**
     * 统计每天成交货款的key
     * @param year 年
     * @param month 月
     * @param day 日
     */
    public static String buildPaymentDayKey(int year, int month, int day) {
        return SERVICE + BUILD_DATA + "payment:" + year + "_" + month + "_" + day;
    }

    /**
     * 账单结算的key，根据账单号，账单号唯一，为结算日时间
     * @param companyId 公司ID
     * @param billNumber 账期
     */
    public static String buildSettleBillKey(long companyId,int billNumber) {
        return SERVICE + BUILD_DATA + "settleBill:" + companyId+":"+billNumber;
    }
    /**
     * 每天统计供应商当前待结算数据的key
     * @param supplierId 供应商id
     */
    public static String buildUnSettleAmountKey(long supplierId) {
        return SERVICE + BUILD_DATA + "unsettleAmount:" + supplierId;
    }
    /**
     * 每天统计供应商当前待结算数据的key
     * @param companyId 供应商id
     */
    public static String buildBuyerAmountKey(long companyId) {
        return SERVICE + BUILD_DATA + "buyerAmount:" + companyId;
    }
    /**
     * 生成促销函的key
     * @param activityId 活动id  一个活动只能对应一个促销函
     */
    public static String buildSettlePromotionKey(String activityId) {
        return SERVICE + BUILD_DATA + "settlePromotion:" + activityId;
    }
    /**
     * 生成促销函明细的key
     * @param orderId 产生奖励明细的订单ID， 一个订单只能一个
     */
    public static String buildSettlePromotionItemKey(String orderId) {
        return SERVICE + BUILD_DATA + "settlePromotionItem:" + orderId;
    }

    /**
     * 生成结算单其他费用明细的key
     * @param relationId 关联业务编号，一个业务编号同一个类型只能一条记录
     */
    public static String buildSettleOtherItemKey(String relationId,int type) {
        return SERVICE + BUILD_DATA + "settleOtherItem:" + relationId + "type:" + type;
    }

    /**
     * 创建供应商结算信息
     * @param companyId 公司主体ID
     */
    public static String buildSettleSupplierKey(long companyId) {
        return SERVICE + BUILD_DATA + "settleSupplier:" + companyId;
    }

    /**
     * 促销函发放奖励的key
     * @param promotionId 促销函ID
     */
    public static String rewardPromotionKey(String promotionId) {
        return SERVICE + REWARD + "promotion:" + promotionId;
    }
    /**
     * 促销明细发放奖励的key
     * @param itemId 促销明细主键ID
     */
    public static String rewardPromotionItemKey(long itemId) {
        return SERVICE + REWARD + "promotionItem:" + itemId;
    }

    /**
     * 用户充值的key
     * @param userId 用户id
     */
    public static String rechargeKey(long userId) {
        return SERVICE + RECHARGE + "user:" + userId;
    }
    /**
     * 用户充值的key
     * @param orderId 充值单编号
     */
    public static String rechargeResultKey(String orderId) {
        return SERVICE + RECHARGE + "result:" + orderId;
    }
    /**
     * 公司批量采购订单支付过程key
     * @param companyId 公司主体id
     */
    public static String purchaseOrdersPayKey(long companyId) {
        return SERVICE + PURCHASE + "company:" + companyId;
    }
    /**
     * 采购单关联充值的key
     * @param purchaseId 采购单ID
     */
    public static String purchaseOrderRechargeKey(String purchaseId) {
        return SERVICE + PURCHASE + "purchaseOrderRecharge:" + purchaseId;
    }

    /**
     * 采购单处理的key,不能重复处理
     * @param purchaseId 采购单BID
     */
    public static String processPurchaseKey(String purchaseId) {
        return SERVICE + PURCHASE + "processPurchase:" + purchaseId;
    }
    /**
     * 采购单处理明细的key，订单重复支付的话要退钱
     * @param orderId 订单ID
     */
    public static String processPurchaseItemKey(String orderId) {
        return SERVICE + PURCHASE + "order:" + orderId;
    }
    /**
     * 存储公司当前正在批量采购的订单id列表
     * @param companyId 公司主体id
     */
    public static String currentPurchaseOrdersKey(long companyId) {
        return SERVICE + PURCHASE + "currentPay:company:" + companyId;
    }
    /**
     * 订单售后所需的key
     * @param orderId 订单ID 一个订单同时只能处理一个售后
     */
    public static String orderAfterSalesKey(String orderId) {
        return SERVICE + ORDER_AFTER_SALES + "order:" + orderId;
    }

    /**
     * 售后过程中，需要对供应商加锁，比如售后产生运费，需要串行等前一个售后单完结后才能实时计算待结算物流费用。
     * @param supplierId 供应商id
     */
    public static String supplierAfterSalesKey(long supplierId) {
        return SERVICE + ORDER_AFTER_SALES + "supplier:" + supplierId;
    }

}

