package com.mona.makeup.controller;

import com.alibaba.fastjson.JSONObject;
import com.mona.makeup.utils.UserTools;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//显示图片
@Controller
public class UploadController {

    private  String picpath=System.getProperties().getProperty("user.home")+"/Pictures";

    @RequestMapping(value = "upload.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String upload(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        System.out.println("开始");
        String path = picpath;
        FileItem fileItem = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(3*1024*1024);//设置上传文件限制大小,-1无上限
        try {
            List<FileItem> list = upload.parseRequest(request);
             fileItem=list.get(0);
        } catch (FileUploadException e) {
            Map<String,Object> map=new HashMap<>();
            map.put("message","图片过大，请您上传3M大小一下图片");
            map.put("success",false);
            e.printStackTrace();
            return JSONObject.toJSONString(map);

        }
        String oldfileName=fileItem.getName();
        String prefix=oldfileName.substring(oldfileName.lastIndexOf("."));
        String fileName= UserTools.getUUID()+prefix;
        //
        File targetFile = new File(path, fileName);
       
        String absolutePath = targetFile.getAbsolutePath();
        session.setAttribute("absolutePath",absolutePath);
        System.out.println(absolutePath);
        //保存
        try {
            fileItem.write(targetFile);
            //uploadFile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("imagePath","/download?filename="+fileName);
        map.put("success",true);
        return JSONObject.toJSONString(map);
    }
    @RequestMapping("/download")
    public String download(String filename, HttpServletRequest request,
                           HttpServletResponse response) {
        String path = picpath;
        path=path+File.separator+filename;
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + path);
        try {
            InputStream inputStream = new FileInputStream(path);

            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }

}