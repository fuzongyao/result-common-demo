package cn.fuzongyao.demo.result.constant;

import cn.fuzongyao.result.result.CodeMessageInterface;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-07-20 11:28
 * @since 1.0
 */
public enum UserCodeMessageEnum implements CodeMessageInterface {
    /**
     * 1000,user not exist
     */
    USER_NOT_EXIST(1000, "user not exist"),
    /**
     * 1001，phone number is registered
     */
    PHONE_IS_REGISTERED(1001, "phone number is registered"),
    /**
     * 1002,user not exist or password wrong
     */
    USER_NOT_EXIST_OR_PASSWORD_WRONG(1002, "user not exist or password wrong"),
    /**
     * 1003,not login
     */
    NOT_LOGIN(1003, "user not login");

    private int code;
    private String message;

    UserCodeMessageEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码
     *
     * @return
     */
    @Override
    public int getCode() {
        return this.code;
    }

    /**
     * 消息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}

