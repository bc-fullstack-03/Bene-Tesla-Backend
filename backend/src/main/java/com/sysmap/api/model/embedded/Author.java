package com.sysmap.api.model.embedded;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;

import org.springframework.data.annotation.Id;

@Getter
@Data
public class Author {

  @Id
  private UUID id;
  private String name;
  private boolean image = false;

  private String urlImage;

  public Author() {}

  public Author(Author author) {
    this.id = UUID.randomUUID();
    this.name = author.name;
    this.image = author.image;
    this.urlImage = author.urlImage;    
  }
}  
  

