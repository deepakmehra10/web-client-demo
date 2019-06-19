package com.deepak;

import com.deepak.service.ContentServiceImpl;
import com.deepak.service.Post;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class ContentServiceImplTest {
    
    private final MockWebServer mockWebServer = new MockWebServer();
    
    private final ContentServiceImpl contentServiceImpl = new ContentServiceImpl(mockWebServer.url("/").toString());
    
    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }
    
    @Test
    public void shouldReturnPost() {
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody("{\"userId\": 1,\"id\": 1, \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\", \"body\": \"quia et suscipit\"}"));
        
        Post response = contentServiceImpl.getPost(1).block();
        assertThat(response.getId(), is(equalTo(1)));
        assertThat(response.getUserId(), is(equalTo(1)));
        assertThat(response.getTitle(), is(equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
        System.out.println(response);
        assertThat(response.getBody(), is(equalTo("quia et suscipit")));
    }
}