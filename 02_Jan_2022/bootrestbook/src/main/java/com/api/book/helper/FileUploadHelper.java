package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR = "D:\\Spring Boot Practise\\02_Jan_2022\\bootrestbook\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
	
	public FileUploadHelper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



	public boolean uploadfile(MultipartFile file)
	{
		boolean f = false;
		try {
//			InputStream inputStream = file.getInputStream();
//			byte data[] = new byte[inputStream.available()];
//			
////			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			
//			fos.close();
			
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			
			f=true;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
}
