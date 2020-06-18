package com.zouwei.firstweb.service.impl;

import com.zouwei.firstweb.domain.Video;
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
}
