package per.ymm.weixiubao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import per.ymm.weixiubao.utils.ReturnMessage;
import per.ymm.weixiubao.utils.SaveFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;


/*@Controller
@RequestMapping(value = "/file")
public class FileController {
    //本地磁盘路径
    final static String FILE_PATH = "D://pic//";
    //能上传的视频图片后缀名
    final static String FILE_SUFFIX = "bmp jpg jpeg png gif wmv asf asx rm  rmvb mpg mpeg mpe 3gp mov mp4 m4v avi dat mkv flv vob";

    //上传图片到服务器，回显到前端
    @ResponseBody
    @RequestMapping("upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile[] mf) throws IOException {
    }
}*/


