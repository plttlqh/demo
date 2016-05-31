package com.example.constant;

public enum AppSettingType {
    CRYPTO_KEY_CLIENT,
    FACE_MATCH,
    SMART_SERVICES_USER,
    SMART_SERVICES_PASSWORD,
    SMART_SERVICES_TERMINAL_ID,
    CRYPTO_KEY_SERVER,
    CLIENT_CORE_KEY,
    EXPIRY_DATE_RANGE_OF_YEAR,
    CRYPTO_KEY_AES_CLIENT,
    CRYPTO_KEY_AES_SERVER,
    TENANT_NAME,
    CURRENCY_CODE,
    COUNTRY_CODE,
    KYC_LIGHT_USERNAME,
    KYC_LIGHT_PASSWORD;

    private AppSettingType() {
    }

    public static AppSettingType fromOrdinal(int key) {
        AppSettingType[] values = values();
        return values[key];
    }

    public static AppSettingType fromOrdinal(String key) {
        int keyInt = Integer.valueOf(key).intValue();
        AppSettingType[] values = values();
        return values[keyInt];
    }

    public String getKeyAsString() {
        return String.valueOf(this.ordinal());
    }
}
