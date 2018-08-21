package com.eshop.serviceweb.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BaseModel implements Serializable {
    @NotNull
    private String currentUser;

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}