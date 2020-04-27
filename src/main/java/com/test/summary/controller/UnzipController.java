package com.test.summary.controller;

import com.test.summary.common.constants.ResultEntity;
import com.test.summary.common.utils.MultipartFileToFile;
import com.test.summary.common.utils.ZipUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;

/**
 * @author Administrator
 * @date 2020/4/27.
 */
@Slf4j
@Controller
@RequestMapping(value = "/unzip")
public class UnzipController {

    @ResponseBody
    @ApiOperation(value = "unzip", notes = "unzip")
    @RequestMapping(value = "/unzip", method = RequestMethod.POST)
    public ResultEntity login(@ApiParam("压缩包文件") @NotNull(message = "压缩包文件必填！") @RequestParam("file") MultipartFile imgFile) throws Exception {
        long begin = System.currentTimeMillis();
        String path = "D:/deli/dockerdata/tmp/images/";
        ZipUtils.deleteFile(new File(path));
        File file = MultipartFileToFile.multipartFileToFile(imgFile);
        ZipUtils.unzip(file, path);
        MultipartFileToFile.delteTempFile(file);
        return ResultEntity.ok("压缩包文件成功,用时" + (System.currentTimeMillis() - begin) + "ms");
    }
}
