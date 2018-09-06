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
	@Value("${file.upload.imageFormat}")
	private String imageFormat;
	@Value("${file.upload.videoFormat}")
	private String videoFormat;

	@Override
	public ResultEntity<String> upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {
		ResultEntity<String> re = new ResultEntity<String>();
		String realName = "";
		String url = "";
        String realPath = null;
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String fileNameExtension = fileName.substring(fileName.indexOf(".")+1, fileName.length());
            realPath = checkFileExtName(fileNameExtension);
            if(null == realPath){
                re.setMsg("format not support");
                return re;
            }
			// 生成实际存储的真实文件名
			realName = UUID.randomUUID().toString() + "." + fileNameExtension;
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
				String fileNameExtension = fileName.substring(fileName.indexOf(".")+1, fileName.length());
                realPath = checkFileExtName(fileName);
                if(null == realPath){
                    re.setMsg("format not support");
                    return re;
                }
				// 生成实际存储的真实文件名
				realName = UUID.randomUUID().toString() + "." + fileNameExtension;
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
		//输入流
		InputStream inputStream = null;
		//文件全路径
		String fileFullPath = null;
		try {
			if (fileName != null) {
                //文件扩展名
                String fileNameExtension = fileName.substring(fileName.indexOf(".")+1, fileName.length());
				String realPath  = checkFileExtName(fileNameExtension);
				if (realPath != null) {
					//全路径
					fileFullPath = realPath + "/" + fileName;
					File downLoadFile = new File(fileFullPath);
					// 判断该文件是否存在
					if (downLoadFile.exists()) {
						//大小
//						fileSize = downLoadFile.length() + "";
						//将文件长度封装到response头部
						response.addHeader("Content-Length", downLoadFile.length() + "");
						//输入流
						inputStream = new FileInputStream(fileFullPath);
					}
				}
			}
		} catch (Exception e) {//异常
			e.printStackTrace();
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

    /**
     *  检查文件扩展名
     * @param fileExtName
     * @return
     */
	private String checkFileExtName(String fileExtName){
	    String realPath = null;
        if(imageFormat!=null && !"".equals(imageFormat)){
            String[] exts = imageFormat.split(",");
            List<String> list = Arrays.asList(exts);
            if(list.contains(fileExtName.toLowerCase())){
                realPath = uploadPath + "/image/";
            }else if(list.contains(fileExtName.toLowerCase())){
                realPath = uploadPath + "/video/";
            }
        }
        return realPath;
    }
}
