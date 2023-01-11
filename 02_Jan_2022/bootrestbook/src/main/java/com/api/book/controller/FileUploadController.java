package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper helper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

		try {
			// System.out.println(file.getName());
			// System.out.println(file.getSize());
			System.out.println(file.getContentType());
			// System.out.println(file.getOriginalFilename());
			// System.out.println();
			// System.out.println();

			if (file.isEmpty()) {
				System.out.println();
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request must contain file");
			}

			if (!file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Only PNG File is acceptable !!");
			}
			
			
			boolean uploadfile = helper.uploadfile(file);
			
			if(uploadfile)
			{
//				 return ResponseEntity.ok("File Uploaded Successfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
			else
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try Again after some time");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return ResponseEntity.ok("Working");

	}

}
