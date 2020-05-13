package org.imageprocessing.conversions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import org.apache.tomcat.util.http.fileupload.FileItem;

public class ConvertToBase64 {

	public static String encoder(FileItem file) {
		System.out.println("entered encoder"+file);
		 String base64Image = "";
	try {
	      // Reading a Image file from file system
		 byte imageData[] = new byte[(int) file.getSize()];	  
	      file.getInputStream().read(imageData);
	      base64Image = Base64.getEncoder().encodeToString(imageData);
			System.out.println("entered encoder base64Image"+base64Image);

	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	return base64Image;
	}
	 
	 
	  
	  public static String encodePassword(String password) {
		  System.out.println("entered pswd encoder");
		  return Base64.getEncoder().encodeToString(password.getBytes()); 
	  }
	
}
