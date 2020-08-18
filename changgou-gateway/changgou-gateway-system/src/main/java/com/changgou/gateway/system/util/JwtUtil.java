package com.changgou.gateway.system.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * jwt工具类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/17 17:50
 * @since 1.0
 */

public class JwtUtil {

  //设置秘钥明文
  public static final String JWT_KEY = "changgou";
  //有效期为
  public static final Long JWT_TTL = 3600000L;// 60 * 60 *1000  一个小时

  /**
   * 解析token
   *
   * @param jwt
   * @return
   * @throws Exception
   */
  public static Claims parseJWT(String jwt) throws Exception {
    SecretKey secretKey = generalKey();
    return Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(jwt)
        .getBody();
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

