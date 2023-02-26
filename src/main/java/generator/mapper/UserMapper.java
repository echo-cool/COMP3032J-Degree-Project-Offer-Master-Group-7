package generator.mapper;

import generator.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yuyangwang
* @description 针对表【User】的数据库操作Mapper
* @createDate 2023-02-26 19:18:22
* @Entity generator.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

}




