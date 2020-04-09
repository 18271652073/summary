package com.test.summary.common.utils;


import com.test.summary.common.constants.ApiConstant;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Dukaixiang
 * @date 2019/7/10.
 * @Version 1.0
 */
public class TurnFile {


    public static void multipartFileToFile(MultipartFile file, String fileNewName) throws IOException {
        String fileRealName = file.getOriginalFilename();//获得原始文件名;
        int pointIndex = fileRealName.lastIndexOf(".");//点号的位置
        String fileSuffix = fileRealName.substring(pointIndex);//截取文件后缀
//        String fileNewName = String.valueOf(System.currentTimeMillis());//新文件名称
        String saveFileName = fileNewName.concat(fileSuffix);//新文件完整名（含后缀）
//        String saveFileName = fileNewName.concat(ApiConstant.EXCEL_SUFFIX);//新文件完整名（含后缀）
        String filePath = ApiConstant.EXCEL_PATH;
        File path = new File(filePath); //判断文件路径下的文件夹是否存在，不存在则创建
        if (!path.exists()) {
            path.mkdirs();
        }
        File savedFile = new File(filePath);
//        boolean isCreateSuccess = savedFile.createNewFile(); // 是否创建文件成功
        boolean isCreateSuccess = true;
        if (isCreateSuccess) {      //将文件写入
            //第一种
//            file.transferTo(savedFile);
            //第二种
            savedFile = new File(filePath, saveFileName);
            // 使用下面的jar包
            FileUtils.copyInputStreamToFile(file.getInputStream(), savedFile);
        }
    }

    public static void main(String[] args) {

    }
}
