package cn.fuzongyao.demo.result.service;

import cn.fuzongyao.demo.result.model.User;
import cn.fuzongyao.demo.result.model.UserRegisterDTO;
import cn.fuzongyao.demo.result.model.UserVO;

/**
 * <p>user service interface</p>
 *
 * @author fuzongyao
 * @date 2019-07-20 11:38
 * @since 1.0
 */
public interface IUserService {
    /**
     * <p>根据手机号精确查找用户，只有在用户的手机号和数据库的完全匹配才可以查询出来</p>
     * 如果没有该手机号则返回null
     *
     * @param phone 手机号
     * @return User，当数据库没有匹配该手机号则返回null
     */
    User findByPhone(String phone);

    /**
     * <p>往数据库里面新增一条用户数据，前提是该手机号没被注册。如果手机号已被注册，会抛出一个BizExcetion</p>
     *
     * @param userRegisterDTO 用户注册请求参数DTO
     * @return User，包含自动生成id、gmtCreate、gmtModified、deleted，注册失败则返回null
     */
    User register(UserRegisterDTO userRegisterDTO);

    /**
     * <p>根据用户 ID 查询</p>
     *
     * @param id 用户 ID
     * @return UserVO，当 ID 不存在时返回 null
     */
    UserVO info(Long id);
}
