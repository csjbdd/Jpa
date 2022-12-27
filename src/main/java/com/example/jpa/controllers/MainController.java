package com.example.jpa.controllers;

import com.example.jpa.entities.Board;
import com.example.jpa.entities.BoardRepository;
import com.example.jpa.services.CommonServiceImpl;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    CommonServiceImpl commonService;
    BoardRepository boardRepository;

    @Autowired
    public MainController(CommonServiceImpl commonService,BoardRepository boardRepository) {
        this.commonService = commonService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/")
    public String login() {
        Board params = Board.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("도뎡이")
                .hits(0)
                .deleteYn('N')
                .build();

        // 2. 게시글 저장
        boardRepository.save(params);

        // 3. 1번 게시글 정보 조회
        Board entity = boardRepository.findById((long) 1).get();
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/main")
    public String main() throws Exception {
        Map<String,Object> list = new HashMap<>();
        list.put("id","1115");
        list.put("password","1115");
        commonService.insert("MainMapper.Main",list);
        System.out.println("ttt");
        return "main";
    }
}
