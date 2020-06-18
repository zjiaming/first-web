package com.zouwei.firstweb.mapper;

import com.zouwei.firstweb.domain.Video;

import java.util.List;

/**
 * 注意这里是 interface
 */
public interface VideoMapper {
    /**
     * 查询所有视频列表，目前没有做分页功能
     */
     List<Video> listVideo();



}
