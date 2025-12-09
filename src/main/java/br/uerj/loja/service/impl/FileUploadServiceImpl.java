package br.uerj.loja.service.impl;

import br.uerj.loja.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {
    
    @Value("${aws.bucketName:default-bucket}")
    private String bucketName;

    private final S3Client s3Client;
    
    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String filenameExtension = file.getOriginalFilename()
                    .substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            String key = UUID.randomUUID().toString() + "." + filenameExtension;
            
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();
            
            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
            return "https://" + bucketName + ".s3.amazonaws.com/" + key;
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer upload do arquivo", e);
        }
    }

    @Override
    public boolean deleteFile(String fileUrl) {
        try {
            String filename = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
            
            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(filename)
                    .build();
            
            s3Client.deleteObject(deleteObjectRequest);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
