package com.example.buoi8.service;

import com.example.buoi8.dto.UserDTO;
import com.example.buoi8.model.User;
import com.example.buoi8.repo.UserRepository;
import com.example.buoi8.utils.UploadFileCloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UploadFileCloudinary uploadFileCloudinary;
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    public User create(String name,String address, MultipartFile image) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setPhoto(imagePath.resolve(image.getOriginalFilename()).toString());
        return userRepository.save(user);
    }

    public User create2(UserDTO userDTO) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(userDTO.getMultipartFile().getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(userDTO.getMultipartFile().getBytes());
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoto(imagePath.resolve(userDTO.getMultipartFile().getOriginalFilename()).toString());
        return userRepository.save(user);
    }

    public User create3(String name,String address, MultipartFile multipartFile) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setAddress(address);
        try {
            String urlImage = uploadFileCloudinary.getUrlFromFile(multipartFile);
            newUser.setPhoto(urlImage);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  userRepository.save(newUser);
    }
    public String deleteImgaeByUrl(String imageUrl) throws Exception {
        return uploadFileCloudinary.removeFileByUrl(imageUrl);
    }
}
