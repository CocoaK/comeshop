package com.eshop.serviceweb.service;

import com.eshop.serviceweb.common.model.ResultEntity;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFileService {

    ResultEntity<String> upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file);

    ResultEntity<String> upload(HttpServletRequest request, HttpServletResponse response, MultipartFile[] files);

    void downLoad(HttpServletResponse response, String fileName);
}
