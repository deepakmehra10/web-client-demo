package com.deepak.service;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Post {
    Integer userId;
    
    Integer id;
    
    String title;
    
    String body;
}
