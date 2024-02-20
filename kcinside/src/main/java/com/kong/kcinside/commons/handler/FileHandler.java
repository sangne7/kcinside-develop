//package com.kong.kcinside.commons.handler;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.solvit.cryptoserver.deploy.dto.DeployDTO;
//
//@Component
//public class FileHandler {
//
//	public String deployUpload(MultipartFile uploadFile, DeployDTO deploy) throws IllegalStateException, IOException {
//				
//		String fileUploadDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\deploy\\"
//									+ deploy.getDevice().getDeviceCategory().getCategory_name() + "\\" + deploy.getDevice().getName() + "\\" + deploy.getVersion();
//				
//		File file = new File(fileUploadDirectory);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//        
//        String originFileName = uploadFile.getOriginalFilename();
//        uploadFile.transferTo(new File(fileUploadDirectory + "/" + originFileName));
//        
//        String filePath = fileUploadDirectory + "\\" + originFileName;
//                
//        return filePath;
//	}
//}
