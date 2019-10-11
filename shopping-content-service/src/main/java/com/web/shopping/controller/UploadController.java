package com.web.shopping.controller;
import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.shopping.pojo.Result;


@RestController
@CrossOrigin
public class UploadController {
	
	
	@RequestMapping("/uploadFile")
	public Result uploadFile(MultipartFile file){
		try {
			//设置虚拟的映射路径 ---> F:/file
			String path="E:/file";
			String url = "";
			if (file!=null && file.getSize()>0) {
				//移到本地目录
				file.transferTo(new File(path, file.getOriginalFilename()));
				url = "http://localhost:8083/upload/"+file.getOriginalFilename();
			}
			return new Result(true, url);
		} catch (IOException e) {
			e.printStackTrace();
			return new Result(false, "上传失败");
		}
		
	}

	
}
