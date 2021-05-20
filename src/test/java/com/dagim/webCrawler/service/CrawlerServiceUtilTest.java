package com.dagim.webCrawler.service;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dagim.webcrawler.service.CrawlerServiceUtil;



@SpringBootTest
public class CrawlerServiceUtilTest {

	
	private final String testUrl = "https://wiprodigital.com";
	CrawlerServiceUtil crawlerServiceUtil = new CrawlerServiceUtil();
	

	@Test
	@DisplayName("should return a completable future")
	public void testGetWebPageUrl() {
		String testUrl2 = "https://foo.bar.net";
		CompletableFuture<Set<String>> completedFuture = 
						crawlerServiceUtil.getWebPageUrls(testUrl2);
	    Assertions.assertTrue(completedFuture.isDone());
	}

	@Test
	@DisplayName("Web Page URL must be valid and should return true")
	public void testValidateUrl() {
		Assertions.assertTrue(crawlerServiceUtil.validateUrl(testUrl));
	}


}
