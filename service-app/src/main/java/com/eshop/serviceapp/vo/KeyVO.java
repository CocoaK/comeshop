package com.eshop.serviceapp.vo;

import javax.validation.constraints.NotNull;

public class KeyVO {
    @NotNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
