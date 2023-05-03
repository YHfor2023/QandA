package com.yhy.huaman.entity;

public class A_User extends BaseEntity {
    /**
     * 用户id
     * 用户账号名称
     * 用户盐值
     * 用户密码
     * 用户真实名字
     * 用户头像
     * 用户类型
     * 用户性别0-女生 1-男生
     * 逻辑删除
     * 日志-创建人
     * 日志-创建时间
     * 日志-最后修改执行人
     * 日志-最后修改时间
     * */
    private Integer user_id;
    private String user_account;
    private String user_salt;
    private String user_password;
    private String user_name;
    private String user_avartar;
    private Integer user_type;
    private Integer user_gender;

    @Override
    public String toString() {
        return "A_User{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_salt='" + user_salt + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_avartar='" + user_avartar + '\'' +
                ", user_type=" + user_type +
                ", user_gender=" + user_gender +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_salt() {
        return user_salt;
    }

    public void setUser_salt(String user_salt) {
        this.user_salt = user_salt;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avartar() {
        return user_avartar;
    }

    public void setUser_avartar(String user_avartar) {
        this.user_avartar = user_avartar;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Integer getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Integer user_gender) {
        this.user_gender = user_gender;
    }
}

