package com.example.util;

import com.example.constant.AppSettingType;
import com.example.repository.AppSettingRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSettingUtil {

    @Autowired
    private AppSettingRepository appSettingRepository;

    private String cryptoClientKeyName;

    public String getCryptoClientKeyName() {
        if (StringUtils.isBlank(cryptoClientKeyName)) {
            cryptoClientKeyName = getAppSettingByKey(AppSettingType.CRYPTO_KEY_CLIENT);
        }
        return cryptoClientKeyName;
    }


    private String getAppSettingByKey(AppSettingType appSettingType) {
        String appSetting = appSettingRepository.findByKeyApp(appSettingType).getValueApp();
        if(StringUtils.isEmpty(appSetting)) {
            throw new RuntimeException(appSettingType.name());
        }
        return appSetting;
    }

}
