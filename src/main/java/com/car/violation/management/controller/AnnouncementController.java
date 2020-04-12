package com.car.violation.management.controller;

import com.car.violation.management.entity.Announcement;
import com.car.violation.management.service.AnnouncementService;
import com.car.violation.management.service.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class AnnouncementController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private Announcement announcement;

    @RequestMapping("/announcement")
    public ModelAndView announcement(@RequestParam String userName) {
        ModelAndView announcement = new ModelAndView("announcement");
        announcement.addObject("announcementList", announcementService.findAll());
        announcement.addObject("user", userService.findById(userName));
        return announcement;
    }

    @RequestMapping("/announcement_edit")
    public ModelAndView announcementEdit(@RequestParam String userName, @RequestParam String ID) {
        ModelAndView announcement = new ModelAndView("announcement_info");
        announcement.addObject("announcement", announcementService.findByID(ID));
        announcement.addObject("user", userService.findById(userName));
        announcement.addObject("operateType", "edit");
        return announcement;
    }

    @RequestMapping("/to_announcement_new")
    public ModelAndView AnnouncementNew(@RequestParam String userName) {
        ModelAndView announcement = new ModelAndView("announcement_info");
        announcement.addObject("user", userService.findById(userName));
        announcement.addObject("operateType", "new");
        return announcement;
    }

    @RequestMapping("/announcement_new")
    public ModelAndView save(@RequestParam String userName,@RequestParam String title,@RequestParam String content,@RequestParam String keywords) {
        ModelAndView view = new ModelAndView("announcement");
        announcement.setID(announcementService.getAnnouncementID(userName));
        announcement.setTitle(title);
        announcement.setKeywords(keywords);
        announcement.setContent(content);
        announcement.setFounder(userService.findById(userName).getName());
        announcement.setFounderAccount(userName);
        announcement.setCreateDate(new Date(System.currentTimeMillis()));
        announcementService.save(announcement);
        view.addObject("user", userService.findById(userName));
        view.addObject("announcementList", announcementService.findAll());
        return view;
    }

    @RequestMapping("/announcement_upd")
    public ModelAndView update(@RequestParam String userName,@RequestParam String title,@RequestParam String content,@RequestParam String keywords,@RequestParam String ID) {
        ModelAndView view = new ModelAndView("announcement");
        Announcement announcement = announcementService.findByID(ID);
        announcement.setTitle(title);
        announcement.setKeywords(keywords);
        announcement.setContent(content);
        announcement.setFounder(userService.findById(userName).getName());
        announcement.setFounderAccount(userName);
        announcement.setUpdateDate(new Date(System.currentTimeMillis()));
        announcementService.update(announcement);
        view.addObject("user", userService.findById(userName));
        view.addObject("announcementList", announcementService.findAll());
        return view;
    }

    @RequestMapping("/announcement_del")
    public ModelAndView update(@RequestParam String ID,@RequestParam String userName) {
        ModelAndView view = new ModelAndView("announcement");
        announcementService.delete(ID);
        view.addObject("user", userService.findById(userName));
        view.addObject("announcementList", announcementService.findAll());
        return view;
    }
}
