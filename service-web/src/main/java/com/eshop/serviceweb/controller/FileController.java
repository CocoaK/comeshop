package com.eshop.serviceweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/file")
public class FileController {
	@Autowired 
    private IFileService fileService;

	@RequestMapping(value ="/upload",method=RequestMethod.POST)
	@ResponseBody
	public ResultEntity<String> upLoad(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile[] files) {
		return fileService.upload(request,response,files);
	}
 
    @RequestMapping(value ="/download",method=RequestMethod.GET)
    @ResponseBody
    public void download(HttpServletResponse response, String fileName) {
		fileService.downLoad(response,fileName);
    }
	
}