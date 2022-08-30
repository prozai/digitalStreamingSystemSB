package com.digitalStreamingSystemSB.service;

import com.digitalStreamingSystemSB.entity.Admin;

public interface AdminService {
    Admin saveAdmin(Admin admin);
    Admin findByEmailAndPassword(String email, String password);
    Admin findByEmail(String email);
    Boolean isValidUser(String email, String password);
}
