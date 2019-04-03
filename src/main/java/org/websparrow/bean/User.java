package org.websparrow.bean;

public class User {

    //UNAME,UEMAIL,UPASS,UDEG

    private String userName;
    private String userEmail;
    private String userPassword;
    private String message;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
            "userName='" + userName + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
