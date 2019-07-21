package cn.fuzongyao.demo.result.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * <p>user</p>
 *
 * @author fuzongyao
 * @date 2019-07-20 10:57
 * @since 1.0
 */
@ApiModel(value = "User", description = "User")
public class User {
    /**
     * id
     */
    @ApiModelProperty(name = "id", value = "id")
    private Long id;
    /**
     * create time
     */
    @ApiModelProperty(name = "gmtCreate", value = "create time")
    private LocalDateTime gmtCreate;
    /**
     * last modified time
     */
    @ApiModelProperty(name = "gmtModified", value = "last modified time")
    private LocalDateTime gmtModified;
    /**
     * is deleted,0:not delete;1:deleted.
     */
    @ApiModelProperty(name = "deleted", value = "is deleted,0:not delete;1:deleted.")
    private Boolean deleted;
    /**
     * phone
     */
    @ApiModelProperty(name = "phone", value = "phone")
    private String phone;
    /**
     * password
     */
    @ApiModelProperty(name = "password", value = "password")
    private String password;
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

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public User setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public User setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public User setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", deleted=" + deleted +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
