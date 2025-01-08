package com.dagim.webcrawler.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dagim.webcrawler.model.MessageResponse;



@Service
public class WebCrawlerService {
	
	private CrawlerServiceUtil crawlerServiceUtil;

	
	
	public WebCrawlerService(CrawlerServiceUtil crawlerServiceUtil) {

		this.crawlerServiceUtil = crawlerServiceUtil;
	}
	
	public ResponseEntity<MessageResponse> acceptWebPageUrl(String rootUrlString){
		
		if(crawlerServiceUtil.validateUrl(rootUrlString)) {
			
	    	crawlerServiceUtil.getWebPageUrls(rootUrlString);
			return new ResponseEntity<>(new MessageResponse("Crawling Page, results are being written to file ./webCrawlerPageLinks.txt"), HttpStatus.CREATED);

		}else {
			return new ResponseEntity<>(new MessageResponse("Url Passed is not valid !"), HttpStatus.BAD_REQUEST);
		}			
		
	}
	


}
