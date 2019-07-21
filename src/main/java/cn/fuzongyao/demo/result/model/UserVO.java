package cn.fuzongyao.demo.result.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>UserVO</p>
 *
 * @author fuzongyao
 * @date 2019-07-20 12:33
 * @since 1.0
 */
@ApiModel(value = "UserVO", description = "UserVO")
public class UserVO {
    /**
     * id
     */
    @ApiModelProperty(name = "id", value = "id")
    private Long id;
    /**
     * phone
     */
    @ApiModelProperty(name = "phone", value = "phone")
    private String phone;
    /**
     * name
     */
    @ApiModelProperty(name = "name", value = "name")
    private String name;
    /**
     * age
     */
    @ApiModelProperty(name = "age", value = "age")
    private Integer age;

    public Long getId() {
        return id;
    }

    public UserVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserVO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserVO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserVO setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
