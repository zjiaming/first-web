package com.zouwei.firstweb.controller;

import com.zouwei.firstweb.domain.Video;
import com.zouwei.firstweb.service.VideoService;
import com.zouwei.firstweb.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * api 路径的定义   pub不需要登录就可以访问，pri需要登录菜能访问
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 没有限定请求方法
     *
     * @return
     */
    @RequestMapping("list")
    public JsonData listVideo() {
        return JsonData.buildSuccess(videoService.listVideo());
    }

    /**
     * 首页banner
     *
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner() {
        return JsonData.buildSuccess(videoService.listBanner());
    }

    /**
     * 通过视频id查询视频
     *
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findVideoDetailById(
            @RequestParam(value = "video_id", required = true)
                    int videoId) {
        Video video = videoService.findVideoDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
