package com.car.violation.management.service;

import com.car.violation.management.dao.AnnouncementDao;
import com.car.violation.management.entity.Announcement;
import com.car.violation.management.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public List<Announcement> findAll() {
        return announcementDao.findAll();
    }

    @Override
    public Announcement findByID(String id) {
        return announcementDao.findByID(id);
    }

    @Override
    public void save(Announcement announcement) {
        announcementDao.save(announcement);
    }

    @Override
    public void update(Announcement announcement) {
        announcementDao.update(announcement);
    }

    @Override
    public void delete(String id) {
        announcementDao.delete(id);
    }

    @Override
    public String getAnnouncementID(String userAccount) {
        return userAccount + DateHelper.ANNOUNCEMENT_ID_FORMAT.format(new Date(System.currentTimeMillis()));
    }
}
