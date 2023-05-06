package com.sysmap.api.service.embedded;

import com.sysmap.api.model.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Like {
    private User  user;
    public Like(User user) {
        this.user = user;    
    }   
}
