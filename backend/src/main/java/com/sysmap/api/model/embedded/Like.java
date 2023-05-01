package com.sysmap.api.model.embedded;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Like {
    private Author author;
    private boolean liked;
    public Like(Author author, boolean liked) {
        this.author = author;
        this.liked = liked;
    }    
}
