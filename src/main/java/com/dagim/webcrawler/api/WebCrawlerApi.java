package com.dagim.webcrawler.api;

import com.dagim.webcrawler.model.MessageResponse;
import com.dagim.webcrawler.model.UrlRequest;
import com.dagim.webcrawler.service.WebCrawlerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/crawl-api")
public class WebCrawlerApi {

	
	private WebCrawlerService crawlerService;

	public WebCrawlerApi(WebCrawlerService crawlerService) {
		this.crawlerService = crawlerService;
	}


	@PostMapping(path = "/fetchLinks", consumes = "application/json")	
	public ResponseEntity<MessageResponse> acceptWebPageUrl(@RequestBody UrlRequest url){
		
		
		return crawlerService.acceptWebPageUrl(url.getUrl());
	}
	
	
}
