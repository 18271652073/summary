package com.test.summary.common.utils;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.*;
import java.util.Enumeration;

/**
 * @author Administrator
 * @date 2020/4/27.
 */
public class ZipUtils {

    static String path = "D:/deli/dockerdata/tmp/images/";//用来判断文件是否删除成功

    //解压文件  sourceFilesPath 源文件路径 afterDirectory 解压缩后文件存放的目录
    @SuppressWarnings("unchecked")
    public static void unzip(File sourceFiles, String afterDirectory) throws IOException {
        ZipFile readfile = null;
        try {
            readfile = new ZipFile(sourceFiles);
            Enumeration takeentrie = readfile.getEntries();
            ZipEntry zipEntry = null;
            File credirectory = new File(afterDirectory);
            credirectory.mkdirs();
            while (takeentrie.hasMoreElements()) {
                zipEntry = (ZipEntry) takeentrie.nextElement();
                String entryName = zipEntry.getName();
                InputStream in = null;
                FileOutputStream out = null;
                try {
                    if (zipEntry.isDirectory()) {
                        String name = zipEntry.getName();
                        name = name.substring(0, name.length() - 1);
                        File createDirectory = new File(afterDirectory + File.separator + name);
                        createDirectory.mkdirs();
                    } else {
                        int index = entryName.lastIndexOf("\\");
                        if (index != -1) {
                            File createDirectory = new File(afterDirectory + File.separator + entryName.substring(0, index));
                            createDirectory.mkdirs();
                        }
                        index = entryName.lastIndexOf("/");
                        if (index != -1) {
                            File createDirectory = new File(afterDirectory + File.separator + entryName.substring(0, index));
                            createDirectory.mkdirs();
                        }
                        File unpackfile = new File(afterDirectory + File.separator + zipEntry.getName());
                        in = readfile.getInputStream(zipEntry);
                        out = new FileOutputStream(unpackfile);
                        int c;
                        byte[] by = new byte[1024];
                        while ((c = in.read(by)) != -1) {
                            out.write(by, 0, c);
                        }
                        out.flush();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    throw new IOException("解压失败：" + ex.toString());
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException ex) {

                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    in = null;
                    out = null;
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new IOException("解压失败：" + ex.toString());
        } finally {
            if (readfile != null) {
                try {
                    readfile.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    throw new IOException("解压失败：" + ex.toString());
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        //解压文件
//        File sourceFiles = new File("D:/202004021825.zip");//输入要删除文件目录的绝对路径
//        unzip(sourceFiles, path);

        //删除一个文件夹下的所有文件(包括子目录内的文件)
        File file = new File(path);//输入要删除文件目录的绝对路径
        deleteFile(file);
    }

    //遍历删除文件
    public static void deleteFile(File file) throws Exception {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            throw new Exception("文件删除失败,请检查文件路径是否正确");
        }
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //打印文件名
            //String name = file.getName();
            //System.out.println(name);
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                deleteFile(f);
            } else {
                f.delete();
            }
        }
        //删除空文件夹  for循环已经把上一层节点的目录清空。
        file.delete();
    }


}