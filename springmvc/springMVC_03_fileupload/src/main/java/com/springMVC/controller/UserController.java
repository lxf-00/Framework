package com.springMVC.controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest req) throws Exception {
        // 使用fileupload组件进行文件上传
        // 上传位置
        String path = req.getSession().getServletContext().getRealPath("/uploads");
        // 判断该路径是否存在
        File file= new File(path);

        if(! file.exists()){
            // 创建文件夹
            file.mkdir();
        }

        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(req);
        // 遍历
        for (FileItem item : items) {
            // 判断，该item项是否是上传文件项
            if(item.isFormField()){
                // 普通表单项
            }else{
                // 上传文件项
                // 获取上传文件名
                String filename = item.getName();
                // 把文件名设为唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + filename;
                // 完成文件上传
                item.write(new File(path, filename));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * 文件上传：springMVC
     * @param req
     * @param upload1
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest req, MultipartFile upload1) throws Exception {
        System.out.println("上传中。。。。。");
        // 使用fileupload组件进行文件上传
        // 上传位置
        String path = req.getSession().getServletContext().getRealPath("/uploads");
        // 判断该路径是否存在
        File file= new File(path);

        if(! file.exists()){
            // 创建文件夹
            file.mkdir();
        }

        // 上传文件项
        // 获取上传文件名
        String filename = upload1.getOriginalFilename();
        System.out.println(filename);
        // 把文件名设为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + filename;
        // 完成文件上传
        upload1.transferTo(new File(path, filename));
        return "success";
    }

    /**
     * 跨服务文件上传
     * @param upload1
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload1) throws Exception {
        System.out.println("跨服务器上传中。。。。。");
        // 图片服务器地址
        String path = "http://localhost:8081/uploads/";
        // 上传文件项
        // 获取上传文件名
        String filename = upload1.getOriginalFilename();
        // 把文件名设为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + filename;
        // 创建客户端的对象
        Client client = Client.create();
        // 和图片服务器连接
        WebResource resource = client.resource(path + filename);
        // 上传文件
        resource.put(upload1.getBytes());
        return "success";
    }
}
