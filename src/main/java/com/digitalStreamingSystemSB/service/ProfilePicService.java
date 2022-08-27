package com.digitalStreamingSystemSB.service;

import com.digitalStreamingSystemSB.entity.ProfilePic;
import org.springframework.web.multipart.MultipartFile;

public interface ProfilePicService {
    ProfilePic saveProfilePic(MultipartFile file) throws Exception;

    ProfilePic getProfilePic(String fileId) throws Exception;
}
