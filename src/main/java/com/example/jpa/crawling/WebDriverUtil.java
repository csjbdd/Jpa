package com.example.jpa.crawling;

import io.netty.handler.timeout.TimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WebDriverUtil {
    private void runSelenium(String URL) throws Exception {
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
            List<WebElement> noticeNumbers = driver.findElements(By.cssSelector("tr > td"));
            //공지사항제목 출력
            for (WebElement notice : noticeTitles) {
                System.out.println("공지사항 제목:" + notice.getText());
            }
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
}
