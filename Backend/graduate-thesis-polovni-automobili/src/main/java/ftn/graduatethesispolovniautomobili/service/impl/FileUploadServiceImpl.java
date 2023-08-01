package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public List<String> saveFile(String uploadDir, MultipartFile[] multipartFile) throws IOException {

        Path uploadPath = Paths.get(uploadDir);
        List<String> filesNames = new ArrayList<>();

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        for (MultipartFile photo : multipartFile) {

            String fileName = StringUtils.cleanPath(String.valueOf(System.currentTimeMillis()));

            try (InputStream inputStream = photo.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

                filesNames.add(fileName);

            } catch (IOException ioe) {
                throw new IOException("Could not save image file: " + fileName, ioe);
            }
        }

        return filesNames;
    }
}
