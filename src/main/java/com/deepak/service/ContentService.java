package com.deepak.service;

import reactor.core.publisher.Mono;

public interface ContentService {
    public Mono<Post> getPost(int id);
}
