package com.lzx.mongodemo.service;

import com.lzx.mongodemo.mapper.IImageMapper;
import com.lzx.mongodemo.po.ImagePO;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFSDBFile;
import javafx.scene.media.Media;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class MongoService {
    @Autowired
    private GridFsTemplate template;
    @Autowired
    private IImageMapper imageMapper;
    @Autowired
    private MongoDbFactory mongoDbFactory;

    public void upload(MultipartFile file){
        try {
            ObjectId objectId = template.store(file.getInputStream(),file.getOriginalFilename(),MediaType.IMAGE_PNG);
            ImagePO imagePO = new ImagePO();
            imagePO.setObjectId(objectId.toString());
            imageMapper.insertImage(imagePO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void download(String id,HttpServletResponse response) throws IOException {
        ImagePO imagePO = imageMapper.queryImage(Long.parseLong(id));
        GridFSFile file = template.findOne(new Query(Criteria.where("_id").is(new ObjectId(imagePO.getObjectId()))));
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        GridFSBucket bucket = GridFSBuckets.create(mongoDbFactory.getDb());
        // 获取Mongodb中文件的缓存输出流
        bucket.downloadToStream(file.getObjectId(), response.getOutputStream());
    }
}
