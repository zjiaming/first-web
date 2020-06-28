package com.zouwei.firstweb.service;

import com.zouwei.firstweb.model.entity.Video;
import com.zouwei.firstweb.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findVideoDetailById(int videoId);
}
