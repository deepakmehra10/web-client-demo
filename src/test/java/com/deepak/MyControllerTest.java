package com.deepak;

import com.deepak.controller.MyController;
import com.deepak.service.ContentService;
import com.deepak.service.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class MyControllerTest {
    
    @Mock
    ContentService contentService;
    
    @InjectMocks
    private MyController myController;
    
    @Test
    public void shouldReturnPost() {
        Mono<Post> postMono = Mono.just(Post.builder().id(1).title("title").body("body").userId(1).build());
        Mockito.when(contentService.getPost(1)).thenReturn(postMono);
        Post post = myController.getPost(1).block();
        
        assertThat(post.getId(), is(equalTo(1)));
        assertThat(post.getBody(), is(equalTo("body")));
        assertThat(post.getTitle(), is(equalTo("title")));
        assertThat(post.getUserId(), is(equalTo(1)));
    }
}
