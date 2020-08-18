package com.changgou.file.controller;

import com.changgou.file.entity.FastDFSFile;
import com.changgou.file.service.FastDFSClient;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件相关controller
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/13 13:51
 * @since 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {

  @Autowired
  private FastDFSClient fastDFSClient;

  /**
   * 删除文件
   *
   * @param filePath
   * @return
   * @author yanglin
   * @time 2020/8/13 16:13
   **/
  @PostMapping("delete")
  public void deleteFile(@RequestParam("file") String filePath) throws Exception {
    fastDFSClient.deleteFile(filePath);
  }

  @GetMapping("download")
  public void downLoadFile(@RequestParam("file") String filePath, HttpServletResponse response) throws Exception {
    String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
    String ext = filePath.substring(filePath.lastIndexOf(".") + 1);
    InputStream inputStream = fastDFSClient.downFile(filePath);
    byte[] buffer = new byte[inputStream.available()];
    inputStream.read(buffer);
    inputStream.close();
    // 清空response
    response.reset();
    // 设置response的Header
    response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
    response.addHeader("Content-Length", "" + buffer.length);
    OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
    response.setContentType("application/octet-stream");
    toClient.write(buffer);
    toClient.flush();
    toClient.close();

  }

  @GetMapping("/info")
  public FileInfo fileInfo(@RequestParam("file") String file) throws Exception {
    FileInfo fileInfo = fastDFSClient.getFileInfo(file);
    return fileInfo;
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws Exception {
    //封装DfsCFile
    String filename = multipartFile.getOriginalFilename();
    Assert.notNull(filename, "文件名称不能为空");
    String ext = filename.substring(filename.lastIndexOf("."));
    FastDFSFile fastDFSFile = FastDFSFile.of(multipartFile.getBytes(), ext, filename);
    String filePath = fastDFSClient.uploadFile(fastDFSFile);
    return fastDFSClient.getTrackerUrl() + "/" + filePath;
  }


}

