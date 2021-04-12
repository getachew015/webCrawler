package com.dagim.webCrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dagim.webCrawler.model.MessageResponse;



@Service
public class WebCrawlerService {
	
	@Autowired
	private CrawlerServiceUtil crawlerServiceUtil;

	
	
	public WebCrawlerService() {

	}
	
	public ResponseEntity<?> acceptWebPageUrl(String rootUrlString){
		
		if(crawlerServiceUtil.validateUrl(rootUrlString)) {
			
	    	crawlerServiceUtil.getWebPageUrls(rootUrlString);
			return new ResponseEntity<>(new MessageResponse("Crawling Page, results are being written to file ./webCrawlerPageLinks.txt"), HttpStatus.CREATED);

		}else {
			return new ResponseEntity<>(new MessageResponse("Url Passed is not valid !"), HttpStatus.BAD_REQUEST);
		}			
		
	}
	


}
