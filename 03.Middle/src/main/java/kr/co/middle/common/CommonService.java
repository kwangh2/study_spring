package kr.co.middle.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {
	
	public String fileUpload(String category , MultipartFile file , HttpServletRequest request) {
		String upload = "d://app/upload/" + category + new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		//폴더가 있는지 확인후 없으면 폴더 만들기
		File folder = new File(upload);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		
		//확장자 따오기
		String ext = StringUtils.getFilenameExtension( file.getOriginalFilename());
		
		//업로드하는 파일명을 고유한 아이디로 저장하기
		String filename= UUID.randomUUID().toString() + "." + ext; //fda214h-asdj12h.jpg
		
		
		try {
			file.transferTo( new File(upload, filename ));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		return upload.replace("d://app/upload", fileURL(request)) + filename;
	}
	
	public String fileURL(HttpServletRequest request) {
		StringBuffer url =  new StringBuffer();
		url.append( request.getServerName()).append(":") //http://localhost:
		.append(request.getServerPort()).append("/file"); // 80/file
		
		return url.toString();
	}
}
