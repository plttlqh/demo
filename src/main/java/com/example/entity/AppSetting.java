package com.example.entity;


import com.example.constant.AppSettingType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(
        name = "app_setting"
)
public class AppSetting implements Serializable {
    private static final long serialVersionUID = 5403297650326654854L;
    @Id
    @Column(
            name = "id"
    )
    private String id;
    @Column(
            name = "key_app"
    )
    private AppSettingType keyApp;
    @Column(
            name = "value_app"
    )
    private String valueApp;
    @Column(
            name = "description"
    )
    private String description;

    public AppSetting() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AppSettingType getKeyApp() {
        return this.keyApp;
    }

    public void setKeyApp(AppSettingType keyApp) {
        this.keyApp = keyApp;
    }

    public String getValueApp() {
        return this.valueApp;
    }

    public void setValueApp(String valueApp) {
        this.valueApp = valueApp;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
