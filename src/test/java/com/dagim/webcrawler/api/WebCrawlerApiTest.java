package com.dagim.webcrawler.api;

import com.dagim.webcrawler.model.UrlRequest;
import com.dagim.webcrawler.service.WebCrawlerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(controllers = WebCrawlerApi.class)
public class WebCrawlerApiTest {

    @MockBean
    private WebCrawlerService crawlerService;
    public static final String testUrl = "https://wiprodigital.com";
    @Autowired
    private MockMvc mockMvc;

    public WebCrawlerApiTest() {
    }


    @Test
    @DisplayName("should return a Response Entity with success Http Status")
    public void testAcceptWebPageUrl() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/crawl-api/fetchLinks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(new UrlRequest(testUrl))))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }


    @Test
    void acceptWebPageUrl() {


    }
}
