package com.dagim.webCrawler.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dagim.webCrawler.model.UrlRequest;
import com.dagim.webCrawler.service.WebCrawlerService;



@RestController
@RequestMapping("/crawl-api")
public class WebCrawlerApi {

	
	@Autowired
	private WebCrawlerService crawlerService;

	
	@PostMapping(path = "/fetchLinks", consumes = "application/json")	
	public ResponseEntity<?> acceptWebPageUrl(@RequestBody UrlRequest url){
		
		
		return crawlerService.acceptWebPageUrl(url.getUrl());
	}
	
	
}
