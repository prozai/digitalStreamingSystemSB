package com.digitalStreamingSystemSB.repository;

import com.digitalStreamingSystemSB.entity.ProfilePic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfilePicRepository extends JpaRepository<ProfilePic, String> {
//    List<ProfilePic> findByProfpicId(String profpicId);
//    ProfilePic findByProfpicIdAndFileName(String profpicId, String fileName);
}

