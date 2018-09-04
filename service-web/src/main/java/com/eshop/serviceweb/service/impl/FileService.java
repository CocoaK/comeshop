package com.eshop.serviceweb.service.impl;

import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.service.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService implements IFileService {
	
	@Value("${file.upload.path}")
	private String uploadPath;
	@Value("${file.upload.format}")
	private String format;

	@Override
	public ResultEntity<String> upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {
		ResultEntity<String> re = new ResultEntity<String>();
		String realName = "";
		String url = "";
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length());
			// 生成实际存储的真实文件名
			realName = UUID.randomUUID().toString() + fileNameExtension;
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath+realName)));
				buffStream.write(bytes);
				buffStream.close();
				url = realName;
				re.setCode(ResultEntity.SUCCESS);
				re.setMsg(ResultEntity.MSG_SUCCESS);
				re.setData(url);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public ResultEntity<String> upload(HttpServletRequest request, HttpServletResponse response, MultipartFile[] files) {
		ResultEntity<String> re = new ResultEntity<String>();
		String realName = "";
		String url = "";
		String realPath = "";
		if (files != null && files.length >0){
			for(MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				//文件扩展名
				String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length());
				if(format!=null && !"".equals(format)){
					String[] exts = format.split(",");
					List<String> list = Arrays.asList(exts);
					if(!list.contains(fileNameExtension.toLowerCase())){
						re.setMsg("format not support");
						return re;
					}
					if(isvideo){
						realPath = uploadPath + "/video/";
					}else{
						realPath = uploadPath + "/image/";
					}
				}
				// 生成实际存储的真实文件名
				realName = UUID.randomUUID().toString() + fileNameExtension;
				try {
					byte[] bytes = file.getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(realPath + realName)));
					buffStream.write(bytes);
					buffStream.close();
					if(StringUtils.isEmpty(url)){
						url = realName;
					}else{
						url = url + "," + realName;
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
					return re;
				} catch (IOException e) {
					e.printStackTrace();
					return re;
				}
			}
			re.setCode(ResultEntity.SUCCESS);
			re.setMsg(ResultEntity.MSG_SUCCESS);
			re.setData(url);
		}
		return re;
	}

	private InputStream downLoadFile(HttpServletResponse response, String fileName) {
		//文件名
		String _fileName = null;
		//文件格式
		String fileFormat = null;
		//文件大小
		String fileSize = null;
		//默认下载结果
		String downLoadResult = "failed";
		//输入流
		InputStream inputStream = null;
		//文件全路径
		String fileFullPath = null;
		try {
			if (fileName != null) {
				int index = fileName.lastIndexOf(".");// 获得文件格式
				//文件格式
				fileFormat = fileName.substring(index + 1);
				//文件名
				_fileName = fileName.substring(0, index);
				//验证格式，并获得保路径
				//String[] validResult = this.validFileFormate(fileFormat, kind);
				String saveFilepath = "";
				String uploadFileRootPath = uploadPath;
				if (saveFilepath != null && uploadFileRootPath != null) {
					//全路径
					fileFullPath = uploadFileRootPath + saveFilepath + "/" + fileName;
					File downLoadFile = new File(fileFullPath);
					// 判断该文件是否存在
					if (downLoadFile.exists()) {
						//大小
						fileSize = downLoadFile.length() + "";
						//将文件长度封装到response头部
						response.addHeader("Content-Length", downLoadFile.length() + "");
						//输入流
						inputStream = new FileInputStream(fileFullPath);
						//下载结果
						downLoadResult = "success";
					} else {
					}
				}
			}
		} catch (Exception e) {//异常
			e.printStackTrace();
			downLoadResult = "exception";
		}
		return inputStream;
	}

	@Override
	public void downLoad(HttpServletResponse response, String fileName) {
		//输出流
		OutputStream outputStream = null;
		//输入流
		InputStream inputStream = null;
		inputStream = this.downLoadFile(response, fileName);
		if (inputStream == null) {return;}
		try {
			// 清空response
			response.reset();
			response.setContentType("application/octec-stream");
			String _fileName=URLEncoder.encode(fileName.trim().replace(" ",""), "UTF-8");
			response.setHeader("content-disposition",
					"attachment;filename=" + _fileName);
			response.setContentType("application/octet-stream");
			outputStream = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) !=-1) {
				outputStream.write(buffer, 0, i);	//写数据
			}
			//流关闭操作
			inputStream.close();
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// 关闭流
			try {
				// 关闭输入流
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
