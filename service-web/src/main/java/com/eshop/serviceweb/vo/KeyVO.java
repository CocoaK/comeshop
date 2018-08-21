package com.eshop.serviceweb.vo;

import javax.validation.constraints.NotNull;

public class KeyVO {
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
