package com.changgou.file.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.changgou.file.config.DFSConfig;
import com.changgou.file.entity.FastDFSFile;
import com.changgou.file.entity.FilePath;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;

/**
 * fast dfs 客户端
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/13 11:27
 * @since 1.0
 */
@Slf4j
@Service
public class FastDFSClient {

  @Autowired
  private DFSConfig dfsConfig;

  public void deleteFile(String filePath) throws Exception {
    StorageClient storeClient = getStoreClient();
    FilePath path = parseFilePath(filePath);
    int status = storeClient.delete_file(path.getGroup(), path.getRemotePath());
    Assert.isTrue(0 == status, "删除失败");
  }

  /**
   * 下载文件
   *
   * @param filePath
   * @return
   * @throws IOException
   */
  public InputStream downFile(String filePath) throws Exception {
    StorageClient storeClient = getStoreClient();
    FilePath path = parseFilePath(filePath);
    byte[] bytes = storeClient.download_file(path.getGroup(), path.getRemotePath());
    return new ByteArrayInputStream(bytes);
  }

  /**
   * 获取文件信息
   *
   * @param filePath group+"/"+remotePath
   * @return
   * @throws Exception
   */
  public FileInfo getFileInfo(String filePath) throws Exception {
    FilePath path = parseFilePath(filePath);
    StorageClient storeClient = getStoreClient();
    FileInfo fileInfo = storeClient.get_file_info(path.getGroup(), path.getRemotePath());
    return fileInfo;
  }

  private FilePath parseFilePath(String filePath) {
    String group = filePath.substring(0, filePath.indexOf("/"));
    String remoteFile = filePath.substring(filePath.indexOf("/") + 1);
    return new FilePath(group, remoteFile);
  }

  /**
   * 获取storage client
   *
   * @return org.csource.fastdfs.StorageClient
   * @author yanglin
   * @time 2020/8/13 14:42
   **/
  private StorageClient getStoreClient() throws IOException {
    //获取tracker client信息
    TrackerClient trackerClient = new TrackerClient();
    //通过tracker client 获取tracker server连接信息
    TrackerServer trackerServer = trackerClient.getConnection();
    //通过tracker server信息获取storage client
    StorageClient storageClient = new StorageClient(trackerServer, null);
    return storageClient;
  }

  /**
   * 获取文件扩展信息
   *
   * @return
   */
  public NameValuePair[] getFileMateList(String filePath) throws Exception {
    FilePath path = parseFilePath(filePath);
    StorageClient storeClient = getStoreClient();
    return storeClient.get_metadata(path.getGroup(), path.getRemotePath());
  }

  /**
   * 初始化全局的tracker server信息
   */
  @PostConstruct
  public void initTrackerServer() {
    ClientGlobal.setG_charset(dfsConfig.getCharset());
    ClientGlobal.setG_connect_timeout(dfsConfig.getConnectTimeout());
    ClientGlobal.setG_network_timeout(dfsConfig.getNetworkTimeout());
    ClientGlobal.setG_tracker_http_port(dfsConfig.getTrackerHttpPort());
    InetSocketAddress[] groups = new InetSocketAddress[dfsConfig.getTrackerServer().length];
    for (int i = 0; i < dfsConfig.getTrackerServer().length; i++) {
      String[] serverInfo = dfsConfig.getTrackerServer()[0].split(":");
      groups[0] = new InetSocketAddress(serverInfo[0], Integer.parseInt(serverInfo[1]));
    }
    ClientGlobal.setG_tracker_group(new TrackerGroup(groups));
  }

  /**
   * 上传文件
   *
   * @param fastDFSFile
   * @return java.lang.String[]
   * @author yanglin
   * @time 2020/8/13 12:00
   **/
  public String uploadFile(FastDFSFile fastDFSFile) throws Exception {
    StorageClient storageClient = getStoreClient();
    //封装扩展信息
    NameValuePair[] nameValuePairs = null;
    if (CollUtil.isNotEmpty(fastDFSFile.getExtParams())) {
      nameValuePairs = new NameValuePair[fastDFSFile.getExtParams().size()];
      for (String key : fastDFSFile.getExtParams().keySet()) {
        new NameValuePair(key, fastDFSFile.getExtParams().get(key));
      }
    }
    //通过storage client进行上传文件
    //返回值:[0]组名，[1]文件名和路径
    String[] result = storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), nameValuePairs);
    Assert.isTrue(BeanUtil.isEmpty(result) || 2 != result.length, "文件上传失败");
    return result[0] + "/" + result[1];
  }

  /**
   * 获取查看文件的完整路径
   *
   * @param filePath
   * @return
   */
  public String viewFile(String filePath) throws IOException {
    return getTrackerUrl() + "/" + filePath;
  }

  /**
   * 获取tracker连接信息
   *
   * @return java.lang.String
   * @author yanglin
   * @time 2020/8/13 14:15
   **/
  public String getTrackerUrl() throws IOException {
    TrackerClient trackerClient = new TrackerClient();
    TrackerServer trackerServer = trackerClient.getConnection();
    String hostString = trackerServer.getInetSocketAddress().getHostString();
    Integer httpPort = dfsConfig.getTrackerHttpPort();
    return "http://" + hostString + ":" + httpPort;
  }


}

