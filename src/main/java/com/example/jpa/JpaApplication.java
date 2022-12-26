package com.example.jpa;

import com.example.jpa.crawling.WebDriverUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.handler.timeout.TimeoutException;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
        try {
            //공지사항 URL
            String noticeURL = "https://gasan.sen.es.kr/53560/subMenu.do";
            //가정통신문 URL
            String familyCorrespondenceUrl = "https://gasan.sen.es.kr/18744/subMenu.do";
            //급식 URL
            String cafeteriaUrl = "https://gasan.sen.es.kr/57397/subMenu.do";
            //공지사항 크롤링
            noticeSelenium(noticeURL);
            //가정통신문 크롤링
            familyCorrespondenceSelenium(familyCorrespondenceUrl);
            //급식 크롤링
            cafeteriaSelenium(cafeteriaUrl);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void noticeSelenium(String URL) throws Exception {
        System.out.println("#### START ####");

        // WebDriver 경로 설정
        Path path = Paths.get("D:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());

        // WebDriver 객체 생성
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        try {
            // 웹페이지 요청 10초대기
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(URL);
            Elements noticeTable = Jsoup.parse(driver.getPageSource()).select("table > tbody >tr >.subject> a[href][onclick][title]");
            //공지사항제목
            List<WebElement> noticeTitles = driver.findElements(By.className("subject"));
            //공지사항번호
            List<WebElement> noticeNumbers = driver.findElements(By.cssSelector("tr > td"));

            //공지사항제목 출력
            for (WebElement notice : noticeTitles) {
                System.out.println("공지사항 제목:" + notice.getText());
            }
            //공지사항번호 출력
            for (int j = 0; j < noticeNumbers.size(); j+=5) {
                String noticeNo = noticeNumbers.get(j).getText();
                System.out.println("공지사항 번호 " + noticeNo);
            }


            try {
                for(Element ele : noticeTable) {
                    javascriptExecutor.executeScript(ele.attr("onclick"));
                    selectBoardDetail(driver.getPageSource(), driver);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }





        } catch ( TimeoutException e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally{
            if(driver != null){
                try{
                    driver.quit();
                }catch(Exception e){
                    //logger
                    e.printStackTrace();
                }
            }

        }


    }
    private static void familyCorrespondenceSelenium(String URL) throws Exception {
        System.out.println("#### START ####");

        // WebDriver 경로 설정
        Path path = Paths.get("D:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());

        // WebDriver 객체 생성
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        try {
            // 웹페이지 요청 10초대기
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(URL);
            Elements familyCorrespondenceTable = Jsoup.parse(driver.getPageSource()).select("table > tbody >tr >.subject> a[href][onclick][title]");
            //가정통신문 제목
            List<WebElement> familyCorrespondenceTitles = driver.findElements(By.className("subject"));
            //가정통신문 글번호
            List<WebElement> familyCorrespondenceNumbers = driver.findElements(By.cssSelector("tr > td"));
            //가정통신문 제목 출력
            for (WebElement notice : familyCorrespondenceTitles) {
                System.out.println("가정통신문 제목:" + notice.getText());
            }
            //가정통신문 번호 출력
            for (int j = 0; j < familyCorrespondenceNumbers.size(); j+=5) {
                String familyCorrespondenceNo = familyCorrespondenceNumbers.get(j).getText();
                System.out.println("가정통신문 번호 " + familyCorrespondenceNo);
            }



            try {
                for(Element ele : familyCorrespondenceTable) {
                    javascriptExecutor.executeScript(ele.attr("onclick"));
                    selectBoardDetail(driver.getPageSource(), driver);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }



        } catch ( TimeoutException e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

        driver.quit();
    }
    private static void cafeteriaSelenium(String URL) throws Exception {
        System.out.println("#### START ####");

        // WebDriver 경로 설정
        Path path = Paths.get("D:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());

        // WebDriver 객체 생성
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        ArrayList<Object> result = new ArrayList<>();
        int page = 1;


        try {
            // 웹페이지 요청 10초대기
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(URL);
            //식단 목록형
            js.executeScript("fnTypeSearch('list')");
            List<WebElement> cafeteriaNo = driver.findElements(By.cssSelector("td > a"));
            List<WebElement> boardPages = driver.findElements(By.cssSelector("div.board_type01_pagenate > a"));
            List<WebElement> cafeteriaImg = null;

            for(int i=0; i < boardPages.size(); i++) {
                cafeteriaNo = driver.findElements(By.cssSelector("td > a"));
                for(int j=0; j < cafeteriaNo.size(); j++) {
                    JSONObject resultObj = new JSONObject();
                    cafeteriaNo.get(j).click();
                    List<WebElement> cafeteriaText= driver.findElements(By.cssSelector("td.ta_l"));
                    if(cafeteriaText.size() > 5) {
                        cafeteriaImg = cafeteriaText.get(5).findElements(By.tagName("img"));
                        resultObj.put("date",cafeteriaText.get(1).getText());
                        resultObj.put("title",cafeteriaText.get(3).getText());
                        resultObj.put("src",cafeteriaImg.get(0).getAttribute("src"));
                    } else {
                        resultObj.put("date",cafeteriaText.get(1).getText());
                        resultObj.put("title",cafeteriaText.get(3).getText());
                    }
                    result.add(resultObj);
                    js.executeScript("fnLayerPopupClose()");
                }
                if(page != boardPages.size()) {
                    page++;
                }
                js.executeScript("fnSearchPage("+page+")");

            }

        } catch ( TimeoutException e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        //출력
        for (int i=0; i < result.size();i++) {
            System.out.println(result.get(i));
        }
        driver.quit();

    }

    private static void selectBoardDetail(String html, WebDriver driver) throws Exception{
        String title = null;
        String date = null;
        String author = null;
        String content = null;

        Document doc = Jsoup.parse(html);
        Elements contentElements = doc.select(".board_type01_tb_readform > tbody  > tr > th");
        Elements inputElements = doc.select("input[type=hidden][name]");
        for(Element e : contentElements) {
            System.out.println("---------------------------------------------------------------------------");
            switch (e.text()) {
                case "제목": {
                    title = e.nextElementSibling().text();
                    System.out.println("+ title : " + title);
                    //검증
                    if(StringUtils.isBlank(title)) {
                        throw new Exception("게시물이 제대로 파싱되지 않음");
                    }
                    break;
                }
                case "등록일": {
                    date = e.nextElementSibling().text();
                    System.out.println("+ date : " + date);
                    //검증
                    if(StringUtils.isBlank(date)) {
                        throw new Exception("게시물이 제대로 파싱되지 않음");
                    }
                    break;
                }
                case "이름": {
                    author = e.nextElementSibling().text();
                    System.out.println("+ author : " + author);
                    //검증
                    if(StringUtils.isBlank(author)) {
                        throw new Exception("게시물이 제대로 파싱되지 않음");
                    }
                    break;
                }
                case "내용": {

                    content = e.nextElementSibling().html();
                    System.out.println("+ content : "+ content.length());
                    //검증
                    if(StringUtils.isBlank(content)) {
                        throw new Exception("게시물이 제대로 파싱되지 않음");
                    }

                    break;
                }

            }
            break;
        }
        Elements fileInfoElements = inputElements.select("input[name=fileListCnt]");
        Pattern p = Pattern.compile("^((https[s]?):\\/)?\\/?([^:\\/\\s]+)(?=\\/)");
        Matcher m = p.matcher(driver.getCurrentUrl());
        String origin = m.find() ? m.group() : null;

        if(fileInfoElements.size() > 0) {
            String fileListCnt = fileInfoElements.first().val();
            int fireListCntInt = Integer.parseInt(fileListCnt);
            String atchFileId = inputElements.select("input[name=atchFileId]").first().val();
            System.out.println("+ attachFilesCount : " + fireListCntInt);
            String downloadURL = null;
            for(int i = 0; i < fireListCntInt; i++) {
                downloadURL = origin + "/dggb/board/boardFile/downFile.do?atchFileId="+atchFileId+"&fileSn="+i;
                System.out.println(downloadURL);
            }
        }



    }

}
