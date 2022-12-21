package com.example.jpa;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(JpaApplication.class, args);
        final String paramUrl = "https://gasan.sen.es.kr/dggb/module/board/selectBoardListAjax.do";
        Connection conn = Jsoup.connect(paramUrl);
        Document doc = null;
        Document doc1 = null;
        Document doc2 = null;
        Document doc3 = null;
        Document doc4 = null;
        try {
            //쿠키얻기
            Connection.Response getCookies = Jsoup.connect("https://gasan.sen.es.kr/53560/subMenu.do")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .method(Connection.Method.GET)
                    .execute();

            Map<String, String> resultCookies = getCookies.cookies();
            //쿠키셋팅
            doc = Jsoup.connect(paramUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .cookies(resultCookies)
                    .data("bbsId", "BBSMSTR_000000006044")
                    .post();
            //쿠키셋팅
            doc1 = Jsoup.connect(paramUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .cookies(resultCookies)
                    .data("bbsId", "BBSMSTR_000000006045")
                    .post();
            //쿠키셋팅

            // 전송할 폼 데이터
            Map<String, String> data = new HashMap<>();
            data.put("viewType", "list");
            data.put("srhMlsvYear","2022");
            data.put("srhMlsvMonth","12");
            data.put("pageIndex","1");

            doc2 = Jsoup.connect("https://gasan.sen.es.kr/18745/subMenu.do")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .cookies(resultCookies)
                    .data(data)
                    .post();

            data.put("pageIndex","2");
            doc3 = Jsoup.connect("https://gasan.sen.es.kr/18745/subMenu.do")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .cookies(resultCookies)
                    .data(data)
                    .post();
            data.put("pageIndex","3");
            doc4 = Jsoup.connect("https://gasan.sen.es.kr/18745/subMenu.do")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .cookies(resultCookies)
                    .data(data)
                    .post();



            Elements noticeElements = doc.getElementsByClass("board_type01_tb_list");
            Elements titleElements = noticeElements.select("a");
            Elements titleNumbers = noticeElements.select("td");
            Elements noticeElements1 = doc1.getElementsByClass("board_type01_tb_list");
            Elements titleElements1 = noticeElements1.select("a");
            Elements titleNumbers1 = noticeElements1.select("td");
            Elements noticeElements2 = doc2.getElementsByClass("board_type01_tb_list");
            Elements titleNumbers2 = noticeElements2.select("td");
            Elements noticeElements3 = doc3.getElementsByClass("board_type01_tb_list");
            Elements titleNumbers3 = noticeElements3.select("td");
            Elements noticeElements4 = doc4.getElementsByClass("board_type01_tb_list");
            Elements titleNumbers4 = noticeElements4.select("td");
            //팝업
            Elements test = doc2.getElementsByClass("popup_contents");

            for (int j = 0; j < titleElements.size(); j++) {
                String title = titleElements.get(j).text();
                System.out.println("공지 제목: " + title);
            }
            for (int j = 0; j < titleNumbers.size(); j+=5) {
                String number = titleNumbers.get(j).text();
                number = number.replaceAll("글번호","");
                System.out.println("공지글번호 " + number );
            }
            for (int j = 0; j < titleElements1.size(); j++) {
                String title1 = titleElements1.get(j).text();
                System.out.println("가정통신문 제목: " + title1);
            }
            for (int j = 0; j < titleNumbers1.size(); j+=5) {
                String number1 = titleNumbers1.get(j).text();
                number1 = number1.replaceAll("글번호","");
                System.out.println("가정통신문 번호 " + number1 );
            }
            for (int j = 0; j < titleNumbers2.size(); j+=5) {
                String number1 = titleNumbers2.get(j).text();
                System.out.println("식단날짜 " + number1 );
            }
            for (int j = 3; j < titleNumbers2.size(); j+=5) {
                String number1 = titleNumbers2.get(j).text();
                System.out.println("식단명 " + number1 );
            }
            for (int j = 0; j < titleNumbers3.size(); j+=5) {
                String number1 = titleNumbers3.get(j).text();
                System.out.println("식단날짜 " + number1 );
            }
            for (int j = 3; j < titleNumbers3.size(); j+=5) {
                String number1 = titleNumbers3.get(j).text();
                System.out.println("식단명 " + number1 );
            }
            for (int j = 0; j < titleNumbers4.size(); j+=5) {
                String number1 = titleNumbers4.get(j).text();
                System.out.println("식단날짜 " + number1 );
            }
            for (int j = 3; j < titleNumbers4.size(); j+=5) {
                String number1 = titleNumbers4.get(j).text();
                System.out.println("식단명 " + number1 );
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
