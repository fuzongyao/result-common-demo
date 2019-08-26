package cn.fuzongyao.demo.result.controller;

import cn.fuzongyao.demo.result.constant.UserCodeMessageEnum;
import cn.fuzongyao.demo.result.model.User;
import cn.fuzongyao.demo.result.model.UserRegisterDTO;
import cn.fuzongyao.demo.result.model.UserVO;
import cn.fuzongyao.demo.result.service.IUserService;
import cn.fuzongyao.result.result.GlobalCodeMessageEnum;
import cn.fuzongyao.result.result.ObjectResult;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

/**
 * <p>用户管理</p>
 * 用户注册、登录、修改信息、获取个人信息
 *
 * @author fuzongyao
 * @date 2019-07-20 11:09
 * @since 1.0
 */
@Api(tags = {"user manage (用户管理)"})
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final static String USER_SESSION_KEY = "userId";
    @Autowired
    private IUserService userService;

    @PostMapping(value = "register")
    public ObjectResult<Boolean> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        // 参数校验已经交给框架去做，@Valid 会根据 UserRegisterDTO 定义的规则进行校验

        // 注册的逻辑直接交给service来做，这里不多参与
        User user = userService.register(userRegisterDTO);
        if (user == null) {
            return ObjectResult.fail(GlobalCodeMessageEnum.ERROR);
        }

        return ObjectResult.succeed(Boolean.TRUE);
    }

    @PostMapping(value = "login")
    public ObjectResult<Boolean> login(@RequestParam String phone, @RequestParam String password) {
        // 先做参数校验，手机号和密码都不能为空
        if (StringUtils.isAnyBlank(phone, password)) {
            return ObjectResult.fail(GlobalCodeMessageEnum.PARAMENTER_NOT_VALID);
        }

        // 根据手机号查询用户，判断用户是否存在
        User user = userService.findByPhone(phone);
        // 用户不存在或者密码不匹配，都返回"用户不存在或密码错误"
        if (user == null || !Objects.equals(password, user.getPassword())) {
            return ObjectResult.fail(UserCodeMessageEnum.USER_NOT_EXIST_OR_PASSWORD_WRONG);
        }

        // 往 session 里面写userId，表示已登录
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession(true).setAttribute(USER_SESSION_KEY, user.getId());

        return ObjectResult.succeed(Boolean.TRUE);
    }

    @GetMapping(value = "info")
    public ObjectResult<UserVO> info() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 先判断有没有登录，从 session 取userId，然后用这里 userId 去查询数据库
        Long userId = (Long) request.getSession().getAttribute(USER_SESSION_KEY);
        if (userId == null) {
            return ObjectResult.fail(UserCodeMessageEnum.NOT_LOGIN);
        }

        UserVO userVO = userService.info(userId);
        return ObjectResult.succeed(userVO);
    }

}
