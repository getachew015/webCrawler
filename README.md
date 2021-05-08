# webCrawler

A Simple Web Crawler fetching url links from a root domain and writes it to a file.

I. About

   This simple web crawler app accepts a web page address from user through an Api made available
   at http://localhost:5000/swagger-ui/ via swagger-ui or using API development client tools like Postman at http://localhost:5000/crawl-api/fetchLinks.
   User must send a POST request at the end point mentioned above with a request body of { "url": "url address of interest" } e.g {"url": "https://wiprodigital.com"} and expect a 2XX sucess message.
   It is written in java-8 and used springboot with jsoup a web crawling tool. Extracrted links will be written to a *.txt file that is going to be created at the root directory of the project.

II. Download, Build, Test and Run

   Source code is available on a github repository with the link https://github.com/getachew015/webCrawler.git and please download and use maven to build the project.
   There are test cases written to perform unit tests and application runs on port 5000 at localhost. The steps should be as below 
   
      1. Download source code and unzip folder to favorite location
      2. Cd to the unzipped project folder and execute a "mvn clean install"; test should pass and project should compile.
      3. Cd to the /target folder and locate the jar file webCrawler-0.0.1-SNAPSHOT.jar.
      4. run application with java -jar webCrawler-0.0.1-SNAPSHOT.jar and should be up and running on port 5000
      5. Test with a web page url of interest and the web crawling happens on a separate thread but user must recieve a success message.
      6. Up on completion there will be "******** End of Crawling *******" message at the bottom of the file to indicate the threads have finished processing. 
