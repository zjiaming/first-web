package com.zouwei.firstweb.mapper;

import com.zouwei.firstweb.domain.Video;
import com.zouwei.firstweb.domain.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 注意这里是 interface
 */
public interface VideoMapper {
    /**
     * 查询所有视频列表，目前没有做分页功能
     */
    List<Video> listVideo();

    /**
     * 首页轮播数据
     *
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 通过视频Id获取视频数据
     */
    Video findVideoDetailById(@Param("video_id") int videoId);
}
