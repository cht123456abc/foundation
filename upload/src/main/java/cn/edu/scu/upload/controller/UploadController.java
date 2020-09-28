package cn.edu.scu.upload.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;
 
@Controller
public class UploadController {
 
    @Value("${resource.path}")
    private String resourcePath;
    @Value("${resource.url}")
    private String resourceUrl;
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
 
 
    @RequestMapping(value = "/uploadPage")
    public String uploadPage(){
        return "uploadPage";
    }
 
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file") MultipartFile file){
        try {
            Calendar cal = Calendar.getInstance();
            Integer year = cal.get(Calendar.YEAR);
            Integer month = cal.get(Calendar.MONTH)+1;
            Integer day = cal.get(Calendar.DAY_OF_MONTH);
 
            String destPath = resourcePath + File.separator + year + File.separator + month + File.separator + day + File.separator;
            String destUrl = resourceUrl + "/" + year + "/" + month + "/" + day + "/";
 
            logger.info("目标路径："+destPath);
            File destFile = new File(destPath);
            if(!destFile.exists()){
                logger.info("目标路径不存在，去创建");
                destFile.mkdirs();
            }
 
            //获取文件后缀
            String sourceFileName=file.getOriginalFilename();
            String suffix=sourceFileName.substring(sourceFileName.lastIndexOf("."),sourceFileName.length());
            logger.info("上传文件名称："+sourceFileName);
 
            //写入目的文件
            String destFileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
            file.transferTo(new File(destPath + destFileName));
 
            return destUrl + destFileName;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
 
    @RequestMapping(value = "/uploadStatus")
    @ResponseBody
    public Integer uploadStatus(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object percent = session.getAttribute("upload_percent");
        return null != percent ? (Integer) percent : 0;
    }
}