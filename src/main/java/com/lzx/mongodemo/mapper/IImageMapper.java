package com.lzx.mongodemo.mapper;

import com.lzx.mongodemo.po.ImagePO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IImageMapper {
    int insertImage(ImagePO imagePO);
    ImagePO queryImage(Long id);
}
