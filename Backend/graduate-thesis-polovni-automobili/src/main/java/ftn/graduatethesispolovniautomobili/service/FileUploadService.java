package ftn.graduatethesispolovniautomobili.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileUploadService {

    List<String> saveFile(String uploadDir, MultipartFile[] multipartFile) throws IOException;
}
