package com.digitalStreamingSystemSB.service;

import com.digitalStreamingSystemSB.controller.AdminControllerDb;
import com.digitalStreamingSystemSB.entity.Admin;
import com.digitalStreamingSystemSB.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin saveAdmin(Admin admin) {
        // SECURE THE PASSWORD AND STORE IN DB
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(admin.getPassword().getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            String hashedPassword = sb.toString();
            admin.setPassword(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm...");
        }
        Admin savedRegistration = adminRepository.save(admin);
        return savedRegistration;
    }

    @Override
    public Admin findByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Boolean isValidUser(String email, String password) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            String hashedPassword = sb.toString();
            // UUID uuid = UUID.randomUUID();
            // System.out.println("UUID=" + uuid.toString() );
            Admin registration = findByEmailAndPassword(email, hashedPassword);
//			Registration registration = findByEmail(email);
            if (registration != null)
                return true;
            else
                return false;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm...");
        }
        return false;
    }
}
