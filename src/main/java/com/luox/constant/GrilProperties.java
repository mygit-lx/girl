package com.luox.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by luox on 2017/5/23.
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GrilProperties {

    private String cupSize;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
