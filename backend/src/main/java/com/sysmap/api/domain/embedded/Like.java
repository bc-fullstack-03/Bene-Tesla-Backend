package com.sysmap.api.domain.embedded;


import com.sysmap.api.domain.model.User;

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
