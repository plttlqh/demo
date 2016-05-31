package com.example.repository;

import com.example.constant.AppSettingType;
import com.example.entity.AppSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSettingRepository extends JpaRepository<AppSetting, String> {
    AppSetting findByKeyApp(AppSettingType appSettingType);
}
