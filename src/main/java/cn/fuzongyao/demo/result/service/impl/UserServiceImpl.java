package cn.fuzongyao.demo.result.service.impl;

import cn.fuzongyao.demo.result.constant.UserCodeMessageEnum;
import cn.fuzongyao.demo.result.model.User;
import cn.fuzongyao.demo.result.model.UserRegisterDTO;
import cn.fuzongyao.demo.result.model.UserVO;
import cn.fuzongyao.demo.result.service.IUserService;
import cn.fuzongyao.demo.result.util.StringUtil;
import cn.fuzongyao.result.exception.BizException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-07-20 12:20
 * @since 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    private static Set<User> users = new HashSet<>();
    private static long id;

    /**
     * <p>根据手机号精确查找用户，只有在用户的手机号和数据库的完全匹配才可以查询出来</p>
     * 如果没有该手机号则返回null
     *
     * @param phone 手机号
     * @return User，当数据库没有匹配该手机号则返回null
     */
    @Override
    public User findByPhone(String phone) {
        Optional<User> userOptional = users.stream().filter(user -> Objects.equals(phone, user.getPhone())).findFirst();
        return userOptional.orElse(null);
    }

    /**
     * <p>往数据库里面新增一条用户数据，前提是该手机号没被注册。如果手机号已被注册，会抛出一个BizExcetion</p>
     *
     * @param userRegisterDTO 用户注册请求参数DTO
     * @return User，包含自动生成id、gmtCreate、gmtModified、deleted，注册失败则返回null
     */
    @Override
    public User register(UserRegisterDTO userRegisterDTO) {
        // 先判断手机号是否已被注册
        if (findByPhone(userRegisterDTO.getPhone()) != null) {
            throw new BizException(UserCodeMessageEnum.PHONE_IS_REGISTERED);
        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setId(++id).setDeleted(Boolean.FALSE).setGmtCreate(LocalDateTime.now()).setGmtModified(LocalDateTime.now());
        users.add(user);
        return user;
    }

    /**
     * <p>根据用户 ID 查询</p>
     *
     * @param id 用户 ID
     * @return UserVO，当 ID 不存在时返回 null
     */
    @Override
    public UserVO info(Long id) {
        Optional<User> userOptional = users.stream().filter(user -> Objects.equals(id, user.getId())).findFirst();
        if (!userOptional.isPresent()) {
            return null;
        }

        User user = userOptional.get();
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setPhone(StringUtil.replacePhone(userVO.getPhone()));
        return userVO;
    }

}
