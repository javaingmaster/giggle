package giggles.giggle.infra.tkMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zty
 *
 * <p>通用mapper继承类</p>
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
