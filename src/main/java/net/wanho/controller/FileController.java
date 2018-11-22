package net.wanho.controller;

import net.wanho.dto.FileDto;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
@SessionAttributes(value = "abspath")
public class FileController {


    @ModelAttribute
    public void init(Map<String,String> map)
    {
        if(!map.containsKey("abspath"))
        {
            map.put("abspath","D:/");
        }

    }

    @RequestMapping("/fetch")
    public ModelAndView fetchFiles(Map<String,String> map)
    {

        String abspath = map.get("abspath");
        List<FileDto> list = Utils.getFiles(abspath);

        ModelAndView modelAndView = new ModelAndView("showfile");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @RequestMapping("/open")
    public ModelAndView openFile(FileDto fileDto,Map<String,String> map,HttpServletRequest request,HttpServletResponse response)
    {
        if(fileDto.getIsFile())
        {
            try {
                request.getRequestDispatcher("DownloadFile?path="+map.get("abspath")+"&name="+fileDto.getName()).forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            map.put("abspath",map.get("abspath")+"/"+fileDto.getName());
            List<FileDto> list = Utils.getFiles(map.get("abspath"));
            ModelAndView modelAndView = new ModelAndView("showfile");
            modelAndView.addObject("list",list);
            return modelAndView;
        }
        return null;
    }


    @RequestMapping(value = "/testFileUpload",method = RequestMethod.POST)
    public String testFileUpload(HttpServletRequest request,Map<String,String> map,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("OriginalFilename: " + file.getOriginalFilename());
        System.out.println("InputStream: " + file.getInputStream());
        String filePath = map.get("abspath")+"/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return "forward:fetch";
    }

    @RequestMapping(value = "/DownloadFile")
    public ResponseEntity<byte[]> DownloadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  接受的是UTF-8
        req.setCharacterEncoding("utf-8");
        //获取项目根目录
        String path = req.getParameter("path");
        //获取文件名
        String filename = req.getParameter("name");
        File file = null;
        HttpHeaders headers = null;

        try {

            System.out.println(filename);//myfiles

            file = new File(path+"/"+filename);

            //请求头

            headers = new HttpHeaders();

            String fileName1 = new String(filename.getBytes("UTF-8"), "iso-8859-1");//解决文件名乱码

            //通知浏览器以attachment（下载方式）打开图片
            headers.setContentDispositionFormData("attachment", fileName1);

            //application/octet-stream二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

}

class Utils{
    public static List<FileDto> getFiles(String path)
    {
        List<FileDto> ret = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        ret.add(new FileDto("..",new Date(),0,false));
        for(File f:files)
        {
            System.out.println(f.getAbsoluteFile().getAbsolutePath());
            ret.add(new FileDto(f.getName(),new Date(f.lastModified()),(int)f.getUsableSpace(),f.isFile()));
        }


        return ret;

    }
}
