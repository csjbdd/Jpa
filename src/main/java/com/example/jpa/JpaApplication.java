package com.example.jpa;

import com.example.jpa.crawling.WebDriverUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.handler.timeout.TimeoutException;
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

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(JpaApplication.class, args);
        try {
            //공지사항 URL
            String noticeURL = "https://doosan.sen.es.kr/10105/subMenu.do";
            //가정통신문 URL
            String familyCorrespondenceUrl = "https://doosan.sen.es.kr/10106/subMenu.do";
            //급식 URL
            String cafeteriaUrl = "https://gasan.sen.es.kr/18745/subMenu.do";
            //공지사항 크롤링
            //noticeSelenium(noticeURL);
            //가정통신문 크롤링
            //familyCorrespondenceSelenium(familyCorrespondenceUrl);
            //급식 크롤링
            //cafeteriaSelenium(cafeteriaUrl);
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
        try {
            // 웹페이지 요청 10초대기
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(URL);
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


        } catch ( TimeoutException e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

        driver.quit();
    }
    private static void familyCorrespondenceSelenium(String URL) throws Exception {
        System.out.println("#### START ####");

        // WebDriver 경로 설정
        Path path = Paths.get("D:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());

        // WebDriver 객체 생성
        WebDriver driver = new ChromeDriver();
        try {
            // 웹페이지 요청 10초대기
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(URL);
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
}
