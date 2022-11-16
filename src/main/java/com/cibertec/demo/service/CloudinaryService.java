/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cibertec.demo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author CESAR
 */

@Service
public class CloudinaryService {

    Cloudinary cloudinary;

    private final Map<String,String> valuesMap = new HashMap<>();


    public CloudinaryService() {
        valuesMap.put("cloud_name", "dl1mbt9jb");
        valuesMap.put("api_key", "736878356982619");
        valuesMap.put("api_secret", "TBvFtL4x8hC3A-y0R-wIKIiFR08");
        cloudinary  = new Cloudinary(valuesMap);
    }

    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;


    }

    public Map delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fops = new FileOutputStream(file);
        fops.write(multipartFile.getBytes());
        fops.close();
        return file;


    }

}
