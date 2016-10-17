package com.niitconnect.model;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePicChange {
	
private	MultipartFile file;

public MultipartFile getFile() {
	return file;
}

public void setFile(MultipartFile file) {
	this.file = file;
}

}
