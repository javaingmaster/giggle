package giggles.giggle.infra.util.jwt;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import giggles.giggle.infra.constant.Authority;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author zty
 *
 * <p>jwt util</p>
 */
public class JwtUtil {

    /**
     * @return create token
     */
    public static String createToken() {
        Date iatDate = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.DATE, 10);
        Date expiresDate = nowTime.getTime();

        Claims claims = Jwts.claims();
        claims.put("name", "Tom");
        claims.put("userId", "886");
        claims.setAudience("any");
        claims.setIssuer("zty");

        return Jwts.builder().setClaims(claims).setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS512, Authority.SECRET)
                .compact();
    }

    /**
     * @param token token
     * @return an instance after parsing token
     */
    public static TokenMessage parseToken(String token) {
        TokenMessage tokenMessage = new TokenMessage();
        Jws<Claims> jws = Jwts.parser().setSigningKey(Authority.SECRET).parseClaimsJws(token);

        Map<String, String> header = jws.getHeader();
        Claims claims = jws.getBody();
        String signature = jws.getSignature();

        //todo 获取token所需数据

        return tokenMessage;
    }
}
