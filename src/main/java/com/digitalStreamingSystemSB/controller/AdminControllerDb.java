package com.digitalStreamingSystemSB.controller;

import com.digitalStreamingSystemSB.entity.Admin;
import com.digitalStreamingSystemSB.repository.AdminRepository;
import com.digitalStreamingSystemSB.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminControllerDb {
    // Dependency Injection (spring framework creates the Repository internally and injects the instance into your app
//    @Autowired
//    private AdminRepository adminRepository;

    //  get all admins
//    @GetMapping("admin")
//    public List getAdminList() {
//        List<Admin> adminList = adminRepository.findAll();
//        return adminList;
//    }
    //	/api/admin/:id get admin by finding the repository by id
//    @GetMapping("admin/{id}")
//    public Admin getAdminById(@PathVariable(value="id") Integer id) {
//        Admin existingAdmin = adminRepository.findById(id).get();//java 8 to use .get() method
//        return existingAdmin;
//    }
    // Authenticate admin by login credentials
//    @GetMapping("/admin/{loginId}/{pass}")
//    public Admin authenticate(@PathVariable(value="loginId") String email, @PathVariable(value="pass")String pass) {
//        System.out.print(email+ " "+ pass);
//        Admin authenticatedAdmin = adminRepository.findByEmailAndPassword(email,pass);
//        return  authenticatedAdmin;
//    }
    // Authenticate admin by login credentials
//    @GetMapping("/admin/{loginId}/{pass}")
//    public Admin authenticate(@PathVariable(value="loginId") String email, @PathVariable(value="pass")String pass) {
//        System.out.print(email+ " "+ pass);
//        Admin authenticatedAdmin = adminRepository.findByEmailAndPassword(email,pass);
//        if(authenticatedAdmin != null) {
//            authenticatedAdmin.setPassword(null);
//            return authenticatedAdmin;
//        }else {
//            return authenticatedAdmin;
//        }
//    }



    //	/api/admin post admin details
//    @PostMapping("/admin")
//    public Admin createAdmin(@RequestBody Admin admin) {
//        Admin savedAdmin = adminRepository.save(admin);
//        return savedAdmin;
//    }
    // create admin

    //	/api/admin/:id put admin by fetching the admin id
//    @PutMapping("/admin/{id}")
//    public Admin updateAdmin(@PathVariable(value="id") Integer id, @RequestBody Admin admin) {
//        // fetch the employee
//        Admin existingAdmin = adminRepository.findById(id).get();
//        existingAdmin.setAdmin_id(id);
//        existingAdmin.setName(admin.getName());
//        existingAdmin.setPassword(admin.getPassword());
//        Admin savedAdmin = adminRepository.save(admin);
//        return savedAdmin;
//    }
    //   /api/admin/:id delete admin by fetching the admin id
//    @DeleteMapping("/admin/{id}")
//    public Map<String, Boolean> deleteAdminById(@PathVariable(value="id") Integer id) {
//        Admin existingAdmin = adminRepository.findById(id).get();//java 8 to use .get() method
//        adminRepository.delete(existingAdmin);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

//    ===========================================================================================
    @Autowired
    private AdminService adminService;
    @PostMapping("/admin")
    public Admin createRegistration(@RequestBody Admin adminRegistration) {
        System.out.println("Registration : " + adminRegistration);
        Admin savedRegistration = adminService.saveAdmin(adminRegistration);
        return savedRegistration;
    }
    @GetMapping("/admin/{loginId}/{pass}")
    public Admin authenticate(@PathVariable(value="loginId") String email, @PathVariable(value="pass")String pass) {
        System.out.print(email+ " "+ pass);
        Admin authenticatedAdmin = adminService.findByEmailAndPassword(email,pass);
        if(authenticatedAdmin != null) {
            authenticatedAdmin.setPassword(null);
            return authenticatedAdmin;
        }else {
            return authenticatedAdmin;
        }
    }


}
