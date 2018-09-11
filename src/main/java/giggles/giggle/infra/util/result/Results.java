package giggles.giggle.infra.util.result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author zty
 * <>结果返回类</p>
 */
public class Results {
    public Results() {
    }

    /**
     * <p>请求成功返回200</p>
     *
     * @param data 相应数据
     * @param <T>
     * @return 相应对象
     */
    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }

    /**
     * <p>请求成功返回200，但是不返回数据</p>
     *
     * @param <T> 相应数据
     * @return 无数据提示
     */
    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<T>(HttpStatus.OK);
    }

    /**
     * <p>请求成功返回201</p>
     *
     * @param data 相应数据
     * @param <T>
     * @return 相应对象
     */
    public static <T> ResponseEntity<T> created(T data) {
        return new ResponseEntity<T>(data, HttpStatus.CREATED);
    }

    /**
     * <p>请求成功返回204</p>
     *
     * @param data 相应数据
     * @param <T>
     * @return 相应对象
     */
    public static <T> ResponseEntity<T> deleted(T data) {
        return new ResponseEntity<T>(data, HttpStatus.NO_CONTENT);
    }

    /**
     * <p>请求错误400</p>
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> invalid(T data) {
        return new ResponseEntity<T>(data, HttpStatus.BAD_REQUEST);
    }

    /**
     * <p>请求错误400，无数据返回</p>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> invalid() {
        return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
    }

    /**
     * <P>请求未授权401</P>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> unauthorized() {
        return new ResponseEntity<T>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * <p>请求禁止访问403/p>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> forbidden() {
        return new ResponseEntity<T>(HttpStatus.FORBIDDEN);
    }

    /**
     * <p>服务器错误，返回500</p>
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> error(T data) {
        return new ResponseEntity<T>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * <p>服务器错误返回500，无数据返回</p>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> error() {
        return new ResponseEntity<T>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
