package com.lzx.mongodemo.web;

import com.google.common.collect.Lists;
import com.lzx.mongodemo.annotation.CustomAnno;
import com.lzx.mongodemo.service.MongoService;
import com.lzx.mongodemo.test.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoController implements IMongoAPI{
    @Autowired
    private MongoService mongoService;

    @Autowired
    private List<Car> cars;

    @PostMapping("/upload")
    @CustomAnno
    public List<String> upload(@RequestParam(value = "image") MultipartFile file){
        System.out.println("upload");
        mongoService.upload(file);
        return Lists.newArrayList("success");
    }

    @GetMapping("/{id}")
    public void download(@PathVariable("id")String id, HttpServletResponse response) throws IOException {
        mongoService.download(id,response);
    }
}
