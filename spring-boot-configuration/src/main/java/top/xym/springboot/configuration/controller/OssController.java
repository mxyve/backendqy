package top.xym.springboot.configuration.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.xym.springboot.configuration.util.OssUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/oss")
public class OssController {

    @Resource
    private OssUtil ossUtil;

    /**
     * 上传文件接口
     *
     * @param file 文件
     * @return 返回 文件的URL
     */
    @PostMapping("/upload")
    public Map<String, Object> uploadFile(@RequestParam("file")MultipartFile file) {
        String fileUrl = ossUtil.uploadFile(file);
        Map<String, Object> response = new HashMap<>();
        response.put("fileUrl", fileUrl);
        return response;
    }
}
