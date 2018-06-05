package xyz.northsky.shop.utils;

import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class WebUtil {


    public static Map<String, String> convertRequestMessage(HttpServletRequest request) throws Exception{
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        return params;
    }

    public String uploadImgToLocal(MultipartFile image) {
        String fileExtension = Files.getFileExtension(image.getOriginalFilename());
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + fileExtension;
        try {
            //File path = new File(ResourceUtils.getURL("static/images/").getPath());
            Files.write(image.getBytes(), new File("D:/uploaded_files/images", fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

}
