package com.zouwei.firstweb.service.impl;

import com.zouwei.firstweb.model.entity.Video;
import com.zouwei.firstweb.model.entity.VideoBanner;
import com.zouwei.firstweb.mapper.VideoMapper;
import com.zouwei.firstweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }

    @Override
    public List<VideoBanner> listBanner() {
        return videoMapper.listVideoBanner();
    }

    @Override
    public Video findVideoDetailById(int videoId) {
        return videoMapper.findVideoDetailById(videoId);
    }

    @Override
    public Video selectById(int videoId) {
        return videoMapper.selectById( videoId);
    }
}
