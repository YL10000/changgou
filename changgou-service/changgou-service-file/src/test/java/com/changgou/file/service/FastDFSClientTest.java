package com.changgou.file.service;

import com.changgou.file.controller.FileController;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.FileInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * fast dfs client测试类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/13 14:44
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSClientTest {
  @Autowired
  private FastDFSClient fastDFSClient;

  @Test
  public void getFileInfoTest() throws Exception {
    FileInfo fileInfo = fastDFSClient.getFileInfo("group01/M00/00/00/wKgKbF8vJOqAJ9XrAADUUsrQhz850..png");
    System.out.println(fileInfo);
  }

  @Test
  public void getFileMetaListTest() throws Exception {
    NameValuePair[] mateList = fastDFSClient.getFileMateList("group01/M00/00/00/wKgKbF8vJOqAJ9XrAADUUsrQhz850..png");
    System.out.println(mateList);
  }

}

