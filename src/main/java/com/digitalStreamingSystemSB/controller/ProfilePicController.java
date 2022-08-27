package com.digitalStreamingSystemSB.controller;

import com.digitalStreamingSystemSB.entity.ProfilePic;
import com.digitalStreamingSystemSB.model.ResponseData;
import com.digitalStreamingSystemSB.service.ProfilePicService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfilePicController {
    private ProfilePicService profilePicService;

    public ProfilePicController(ProfilePicService profilePicService) {
        this.profilePicService = profilePicService;
    }
    // upload profile pic to server injecting multipart file with post method
    @PostMapping("/actor/thumbnail")
    public ResponseData uploadProfilePic(@RequestParam("file") MultipartFile file) throws Exception {
        ProfilePic profilePic = null;
        profilePic = profilePicService.saveProfilePic(file);
        // creating download url from file name using profilePicId
        String dowloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("download/").path(profilePic.getProfpicId()).toUriString();

        return new ResponseData(profilePic.getFileName(), file.getContentType(), dowloadUrl, file.getSize());
    }
    // download profile pic from server injecting file name with get method
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        ProfilePic profilePic = null;
        profilePic = profilePicService.getProfilePic(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType
                .parseMediaType(profilePic.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "profilePic; filename=\"", profilePic.getFileName()
                + "\"")
                .body(new ByteArrayResource(profilePic.getData()));
    }
}
