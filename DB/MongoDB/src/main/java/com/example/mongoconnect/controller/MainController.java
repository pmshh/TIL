package com.example.mongoconnect.controller;

import com.example.mongoconnect.document.Table1Document;
import com.example.mongoconnect.repository.Table1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final Table1Repository table1Repository;

    @GetMapping("/")
    public String mainP(Model model) {

        model.addAttribute("dataList", table1Repository.findAll());

        return "index";
    }

    @PostMapping("/save")
    public String saveData(
            @RequestParam("data") String data,
            @RequestParam("name") String name,
            @RequestParam("city") String city,
            @RequestParam("age") int age) {

        // 새로 입력받은 데이터 저장
        Table1Document newDocument = new Table1Document();
        newDocument.setData(data);

        // 추가적인 데이터 설정
        Table1Document.AdditionalData additionalData = new Table1Document.AdditionalData();
        additionalData.setName(name);
        additionalData.setAge(age);

        // 주소 설정
        Table1Document.AdditionalData.Address address = new Table1Document.AdditionalData.Address();
        address.setCity(city);
        additionalData.setAddress(address);

        newDocument.setAdditionalData(additionalData);

        // MongoDB에 저장
        table1Repository.save(newDocument);

        return "redirect:/";  // 저장 후 목록 페이지로 리다이렉트
    }
}

