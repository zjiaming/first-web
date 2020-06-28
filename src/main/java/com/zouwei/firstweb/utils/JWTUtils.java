package com.zouwei.firstweb.utils;

import com.zouwei.firstweb.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt 工具类
 * 1.后端根据一些信息来生成token,把生成的token给到前端
 * 2.前端每次访问的时候带上token,后端对token进行校验
 *
 * 注意点：
 * 1.生成的token，是可以通过base64进行解密出明文信息
 * 2.base64进行解密出明文信息，修改在进行编码，则会解密失败
 * 3.无法作废已颁布的token,除非修改秘钥 {#SECRET}
 */
public class JWTUtils {

    /**
     * 过期时间吗，一周
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 7;

    /**
     * 加密密钥
     */
    private static final String SECRET = "xdclass.net168";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "xdclass";

    /**
     * 发布令牌的人
     */
    private static final String SUBJECT = "xdclass";

    /**
     * 根据用户信息，生成令牌
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg()) //可以根据业务需求来设置需要的参数
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())  //令牌下发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE)) //设置过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET)  //设置签名方式，和密钥
                .compact();

        //拼接前缀，可以不用拼接
        token = TOKEN_PREFIX + token;

        return token;
    }

    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJwt(String token) {
        //解析的时候有可能失败，比如过期了，信息修改了，返回null就表示校验失败了
        try {
            //使用 final 防止篡改
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    //因为生成的token添加了前缀，所以这里需要先替换在校验
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}
