package org.teamway.model;

import java.util.Objects;

/**
 * <p>
 *
 * @author Wangc
 * @Date: 2019/1/3 0003 09:46
 * @Description:
 */
public class User {
    private int id;
    private String password ;
    private String userName;
    private String userAge;
    private String userAddress;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserAge() {
        return userAge;
    }
    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(password, user.password) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userAge, user.userAge) &&
                Objects.equals(userAddress, user.userAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, password, userName, userAge, userAddress);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
