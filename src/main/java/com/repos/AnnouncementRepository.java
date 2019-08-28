package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, String> {

}
