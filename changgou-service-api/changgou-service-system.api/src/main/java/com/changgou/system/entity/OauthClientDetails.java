package com.changgou.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (OauthClientDetails)实体类
 *
 * @author makejava
 * @since 2020-08-14 14:36:50
 */
@Data
@TableName("oauth_client_details")
public class OauthClientDetails implements Serializable {

  private Integer accessTokenValidity;
  private String additionalInformation;
  private String authorities;
  private String authorizedGrantTypes;
  private String autoapprove;
  @TableId(type = IdType.AUTO)
  private String clientId;
  private String clientSecret;
  private Integer refreshTokenValidity;
  private String resourceIds;
  private String scope;
  private String webServerRedirectUri;
}