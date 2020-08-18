package com.changgou.system.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * jwt工具类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/14 18:05
 * @since 1.0
 */

public class JwtUtil {

  //设置秘钥明文
  public static final String JWT_KEY = "changgou";
  //有效期为
  public static final Long JWT_TTL = 3600000L;// 60 * 60 *1000  一个小时

  /**
   * 创建token
   *
   * @param id
   * @param subject
   * @param ttlMillis
   * @return
   */
  public static String createJWT(String id, String subject, Long ttlMillis) {

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);
    if (ttlMillis == null) {
      ttlMillis = JwtUtil.JWT_TTL;
    }
    long expMillis = nowMillis + ttlMillis;
    Date expDate = new Date(expMillis);
    SecretKey secretKey = generalKey();

    JwtBuilder builder = Jwts.builder()
        .setId(id)              //唯一的ID
        .setSubject(subject)   // 主题  可以是JSON数据
        .setIssuer("admin")     // 签发者
        .setIssuedAt(now)      // 签发时间
        .signWith(signatureAlgorithm, secretKey) //使用HS256对称加密算法签名, 第二个参数为秘钥
        .setExpiration(expDate);// 设置过期时间
    return builder.compact();
  }

  /**
   * 生成加密后的秘钥 secretKey
   *
   * @return
   */
  public static SecretKey generalKey() {
    byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    return key;
  }
}

