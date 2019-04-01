package com.lzx.mongodemo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IMongoAPI {
    List<String> upload(@RequestParam(value = "image") MultipartFile file);
    void download(@PathVariable("id")String id, HttpServletResponse response) throws IOException;
}
