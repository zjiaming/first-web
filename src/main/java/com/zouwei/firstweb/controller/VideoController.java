package com.zouwei.firstweb.controller;

import com.zouwei.firstweb.domain.Video;
import com.zouwei.firstweb.service.VideoService;
import com.zouwei.firstweb.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("list")
    public JsonData listVideo() {
        return JsonData.buildSuccess(videoService.listVideo());
    }
}
