package indi.gd.pcmw.dao;

import indi.gd.pcmw.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    /**
     * 保存用户
     */
    @Insert("insert into pcmw_user values(#{id},#{loginName},#{password},#{gender},#{age},#{address},#{qualification},#{qualType})")
    int save(User user);

    @Select("select count(*) from pcmw_user where login_name = #{loginName} and password = #{password}")
    int loginValidate(@Param("loginName") String loginName,@Param("password") String password);

    @Select("select * from pcmw_user where login_name = #{loginName}")
    User getUserByLoginName(String loginName);
}
