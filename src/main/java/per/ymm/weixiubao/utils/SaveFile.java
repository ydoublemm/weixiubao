package per.ymm.weixiubao.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: ymm
 * @Date: 2018/6/12 15:45
 * @Description:
 */
public class SaveFile {
    //本地磁盘路径
    final static String FILE_PATH = "D://pic//";
    //能上传的视频图片后缀名
    final static String FILE_SUFFIX = "bmp jpg jpeg png gif wmv asf asx rm  rmvb mpg mpeg mpe 3gp mov mp4 m4v avi dat mkv flv vob";

    public static String save(MultipartFile[] mf) throws IOException {
        //存图片的名字
        StringBuilder sb = new StringBuilder();
        for (MultipartFile file : mf) {
            String fileName = file.getOriginalFilename();
            String path = null;
            //图片后缀
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;


            //判断图片是否合法,合法之后上传
            if (type != null && FILE_SUFFIX.indexOf(type) != -1) {
                // 自定义的文件新名称
                String newFileName = UUID.randomUUID().toString().replace("-", "") + "." + type;
                //存文件名
                sb.append(newFileName + ",");
                // 设置存放图片文件的路径
                path = FILE_PATH + newFileName;
                file.transferTo(new File(path));
            } else {
                //失败之后
                throw  new RuntimeException("图片类型不符");
            }
        }

        //删除最后一个“,”
        sb.deleteCharAt(sb.lastIndexOf(","));

        return sb.toString();
    }

}
