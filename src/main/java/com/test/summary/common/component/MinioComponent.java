package com.test.summary.common.component;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2020/5/28.
 */
@Component
public class MinioComponent {

    @Value("${spring.minio.url}")
    private String url;
    @Value("${spring.minio.bucket}")
    private String bucket;
    @Value("${spring.minio.access-key}")
    private String accessKey;
    @Value("${spring.minio.secret-key}")
    private String secretKey;

    public void save() throws Exception {
        // 参数为：minio服务器路径，账号，密码
        MinioClient minioClient = new MinioClient("http://119.45.120.9:9000", "admin", "123456789");
//        MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
        // 检查文件夹是否已经存在
        boolean isExist = minioClient.bucketExists("managertest");
        if (isExist) {
            System.out.println("文件夹已经存在了");
        } else {
            // 创建一个名为managertest的文件夹
            System.out.println("文件夹还没存在");
            minioClient.makeBucket("managertest");
        }
        // 使用putObject上传一个文件到文件夹中。
        //参数为：managertest:文件夹，1.png:文件存储的名字;要存的文件路径
        minioClient.putObject("managertest", "2.rar", "E:\\2.rar");
        System.out.println("成功了");
        //使用getObject获取一个文件
        // 调用statObject()来判断对象是否存在。
        ObjectStat a = minioClient.statObject("managertest", "1.png");
        // 获取1.png的流并保存到photo.png文件中。
        //参数为：文件夹，要获得的文件，要写入的文件
        minioClient.getObject("managertest", "2.rar", "E:/3.rar");
    }

    public static void main(String[] args) throws Exception {
        MinioComponent minioComponent = new MinioComponent();
        minioComponent.save();
    }
}
