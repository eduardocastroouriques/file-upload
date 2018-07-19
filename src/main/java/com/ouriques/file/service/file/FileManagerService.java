package com.ouriques.file.service.file;

import com.ouriques.file.common.BusinessException;
import com.ouriques.file.common.FileProperties;
import com.ouriques.file.model.Response.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileManagerService {


    @Autowired
    private FileProcessingService fileProcessingService;

    private final Path fileLocation;

    @Autowired
    public FileManagerService(FileProperties fileProperties) {
        this.fileLocation = Paths.get(fileProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileLocation);
        } catch (Exception ex) {
            throw new BusinessException("ERRO AO CRIAR DIRETORIO PARA ARMAZENAR ARQUIVO.", ex);
        }
    }

    public FileResponse saveAndProccess(MultipartFile file){

        // Save local file
        String fileName = this.storeFile(file);

        // Process file
        fileProcessingService.processFile(fileName);

        return new FileResponse(file.getName(), file.getOriginalFilename(), file.getContentType(), file.getSize());
    }

    public void store(String data, String fileName) {

        try {
            File statText = new File("/home/eduardo-ouriques/git_repository/file-upload/out/" + fileName);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(data);
            w.close();
        } catch (IOException e) {
            System.err.println("Failed to save file");
        }
    }

    public String storeFile(File file) {

        String fileName = StringUtils.cleanPath(file.getAbsolutePath());

        try {

            InputStream inputStream = new FileInputStream(file.getAbsolutePath());
            Path targetLocation = this.fileLocation.resolve(fileName);
            Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;

        } catch (IOException ex) {
            throw new BusinessException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public String storeFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {

            Path targetLocation = this.fileLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;

        } catch (IOException ex) {
            throw new BusinessException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new BusinessException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new BusinessException("File not found " + fileName, ex);
        }
    }

}
