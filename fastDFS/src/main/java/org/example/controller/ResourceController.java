package org.example.controller;

import org.example.bean.ResourceBean;
import org.example.constants.ResourcesConstants;
import org.example.utils.FastDFSClientUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/resources/")
public class ResourceController {

    @RequestMapping(value={"/upload"}, method= RequestMethod.POST)
    @ResponseBody
    public ResourceBean upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String extName = "";
        String fileName = "";
        String originalFilename = file.getOriginalFilename();
        if(originalFilename.contains(".")) {
            //拆分文件路径
            String[] fileArray = originalFilename.split("\\.");
            //获取文件扩展名
            extName = fileArray[1];
            //获取文件名
            fileName = fileArray[0];
        }else {
            fileName = originalFilename;
        }
        byte[] bytes = null;
        try {
            bytes = file.getBytes(); //将文件转换成字节流形式
        } catch (IOException e) {
            e.printStackTrace();
        }
        //调用上传文件的具体方法
        String fileId= FastDFSClientUtils.upload(bytes,extName);
        return new ResourceBean(ResourcesConstants.getResourcesUrl(fileId), fileName);
    }
}
