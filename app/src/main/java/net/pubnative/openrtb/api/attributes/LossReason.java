package net.pubnative.openrtb.api.attributes;

public final class LossReason {
    public static final int BID_WON = 0;
    public static final int INTERNAL_ERROR = 1;
    public static final int IMPRESSION_OPPORTUNITY_EXPIRED = 2;
    public static final int INVALID_BID_RESPONSE = 3;
    public static final int INVALID_DEAL_ID = 4;
    public static final int INVALID_AUCTION_ID = 5;
    public static final int INVALID_ADVERTISER_DOMAIN = 6;
    public static final int MISSING_MARKUP = 7;
    public static final int MISSING_CREATIVE_ID = 8;
    public static final int MISSING_BID_PRICE = 9;
    public static final int MISSING_MINIMUM_CREATIVE_APPROVAL_DATA = 10;

    public static final int BID_BELOW_AUCTION_FLOOR = 100;
    public static final int BID_BELOW_DEAL_FLOOR = 101;
    public static final int LOSS_TO_HIGHER_BID = 102;
    public static final int LOST_TO_BID_FOR_PMP_DEAL = 103;
    public static final int BUYER_SEAT_BLOCKED = 104;

    // Creative filtered
    public static final int GENERAL = 200;
    public static final int PENDING_PROCESSING_BY_EXCHANGE = 201;
    public static final int DISAPPROVED_BY_EXCHANGE = 202;
    public static final int SIZE_NOT_ALLOWED = 203;
    public static final int INCORRECT_CREATIVE_FORMAT = 204;
    public static final int ADVERTISER_EXCLUSIONS = 205;
    public static final int APP_BUNDLE_EXCLUSIONS = 206;
    public static final int NOT_SECURE = 207;
    public static final int LANGUAGUE_EXCLUSIONS = 208;
    public static final int CATEGORY_EXCLUSIONS = 209;
    public static final int CREATIVE_ATTRIBUTE_EXCLUSIONS = 210;
    public static final int AD_TYPE_EXCLUSIONS = 211;
    public static final int ANIMATION_TOO_LONG = 212;
    public static final int NOT_ALLOWED_IN_PMP_DEAL = 213;

    // Any value above 1000 is exchange specific and not included on the standard spec
}
