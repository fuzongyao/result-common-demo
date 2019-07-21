package cn.fuzongyao.demo.result.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * <p>用户注册请求参数DTO</p>
 *
 * @author fuzongyao
 * @date 2019-07-20 12:00
 * @since 1.0
 */
@ApiModel(value = "UserRegisterDTO", description = "用户注册请求参数DTO")
public class UserRegisterDTO {
    /**
     * phone
     */
    @ApiModelProperty(name = "phone", value = "<b>必填</b>，手机号", example = "13888888888")
    @NotBlank(message = "phone number can not be blank")
    private String phone;
    /**
     * password
     */
    @ApiModelProperty(name = "password", value = "<b>必填</b>，密码", example = "123456")
    @NotBlank(message = "password can not be blank")
    private String password;
    /**
     * name
     */
    @ApiModelProperty(name = "name", value = "<b>必填</b>，姓名")
    @NotBlank(message = "name can not be blank")
    private String name;
    /**
     * age
     */
    @ApiModelProperty(name = "age", value = "选填，0~200")
    @Min(0)
    @Max(200)
    private Integer age;

    public String getPhone() {
        return phone;
    }

    public UserRegisterDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserRegisterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
