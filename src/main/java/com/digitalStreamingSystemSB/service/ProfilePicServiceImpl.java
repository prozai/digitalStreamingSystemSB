package com.digitalStreamingSystemSB.service;

import com.digitalStreamingSystemSB.entity.ProfilePic;
import com.digitalStreamingSystemSB.repository.ProfilePicRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfilePicServiceImpl implements ProfilePicService {
    private ProfilePicRepository profilePicRepository;

    public ProfilePicServiceImpl(ProfilePicRepository profilePicRepository) {
        this.profilePicRepository = profilePicRepository;
    }
    @Override
    public ProfilePic saveProfilePic(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }
            ProfilePic profilePic = new ProfilePic(fileName, file.getContentType(), file.getBytes());
            return profilePicRepository.save(profilePic);
        }catch (Exception e){
            throw new Exception("Sorry could not save File" + fileName, e);
        }
    }

    @Override
    public ProfilePic getProfilePic(String fileId) throws Exception {
        return profilePicRepository
                .findById(fileId)
                .orElseThrow(() -> new Exception("File not found with id " + fileId));
    }

}
