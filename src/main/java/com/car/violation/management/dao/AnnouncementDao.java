package com.car.violation.management.dao;

import com.car.violation.management.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementDao {

    /**
     * 查找所有公告
     *
     * @return 公告集合
     */
    List<Announcement> findAll();

    /**
     * 根据 ID 查找公告
     *
     * @param id 公告 ID
     * @return 公告信息
     */
    Announcement findByID(String id);

    /**
     * 保存公告信息
     *
     * @param announcement 公告信息
     */
    void save(Announcement announcement);

    /**
     * 更新公告信息
     *
     * @param announcement 公告信息
     */
    void update(Announcement announcement);

    /**
     * 删除公告信息
     *
     * @param id 公告 ID
     */
    void delete(String id);
}
