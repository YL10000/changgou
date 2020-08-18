package com.changgou.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * fast dfs 文件实体
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/13 11:16
 * @since 1.0
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class FastDFSFile implements Serializable {

  //文件创建作者
  private String author;
  //文件内容
  @NonNull
  private byte[] content;
  //文件扩展名
  @NonNull
  private String ext;
  //文件扩展信息
  private Map<String, String> extParams;
  //文件MD5摘要值
  private String md5;
  //文件名字
  @NonNull
  private String name;
}

