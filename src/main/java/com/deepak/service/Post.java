package com.deepak.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Post {
    
    Integer userId;
    
    Integer id;
    
    String title;
    
    String body;
}
