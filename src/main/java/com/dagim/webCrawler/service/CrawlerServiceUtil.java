package com.dagim.webCrawler.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class CrawlerServiceUtil {
	
	
	private String rootUrlString;
	private String rootUrlHost;
	private Set<String> crawledUrls;
	private PrintWriter printWriter = null;
	private FileWriter fileWriter = null;
	private Logger logger = LoggerFactory.getLogger(WebCrawlerService.class);
	
	

	public CrawlerServiceUtil() {
		super();
	}
	
	@Async
	public CompletableFuture<Set<String>> getWebPageUrls(String url){
		
		/*
		 * This needs to be a non-blocking code and hence runs on a multi-threaded environment
		 * can be tested with any url like https://wiprodigital.com
		 */
		crawledUrls = new HashSet<String>();
	    try {
			fileWriter = new FileWriter("./webCrawlerPageLinks.txt");
    	    printWriter = new PrintWriter(fileWriter);
    	    this.rootUrlString = url;
    	    fetchLinksOnPage(url);
    	    printWriter.println("************ End Of Crawling *************");
    		printWriter.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
			logger.debug(e.getMessage());
			printWriter.close();
		}
	    
	    return CompletableFuture.completedFuture(crawledUrls);
		
	}
	
	private void fetchLinksOnPage(String url){
		/*
		 * crawl and fetch recursively
		 * fetch only links with the same domain name
		 */
		String crawledUrlHost = null;
        if (!crawledUrls.contains(url)) {

        	try {
            	URL rootUrl = new URL(rootUrlString);
            	rootUrlHost = rootUrl.getHost();
            	URL crawledUrl = new URL(url);
            	crawledUrlHost = crawledUrl.getHost();

            	if(crawledUrlHost.contains(rootUrlHost)) {
            		crawledUrls.add(url);
            		printWriter.println(url);
            		printWriter.flush();
            	}else 
            		return;
            	
            	Document document = Jsoup.connect(url).ignoreContentType(true)
            										  .ignoreHttpErrors(true).get();
                Elements linksOnPage = document.select("a[href]");
                linksOnPage.forEach(page -> fetchLinksOnPage(page.attr("abs:href")));

            } catch (IOException e) {
    			e.printStackTrace();
    			logger.debug(e.getMessage());
            }
        	
        }
		
	}
	
	public boolean validateUrl(String url) {
		
		//check if url passed is a valid url
		try {
			new URL(url);
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
		
	}


}
