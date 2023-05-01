package com.sysmap.api.model.embedded;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private Author author;
    private String text;
    public Comment(Author author, String text) {
        this.author = author;
        this.text = text;
    }
    public Comment() {}
}
