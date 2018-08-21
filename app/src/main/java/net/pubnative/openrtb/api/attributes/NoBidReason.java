package net.pubnative.openrtb.api.attributes;

public final class NoBidReason {
    public static final int UNKNOWN_ERROR = 0;
    public static final int TECHNICAL_ERROR = 1;
    public static final int INVALID_REQUEST = 2;
    public static final int KNOWN_WEB_SPIDER = 3;
    public static final int SUSPECTED_NON_HUMAN_TRAFFIC = 4;
    public static final int CLOUD_DATA_CENTER_PROXY_IP = 5;
    public static final int UNSUPPORTED_DEVICE = 6;
    public static final int BLOCKED_PUBLISHER = 7;
    public static final int UNMATCHED_USER = 8;
    public static final int DAILY_READER_CAP_MET = 9;
    public static final int DAILY_DOMAIN_CAP_MET = 10;
}
