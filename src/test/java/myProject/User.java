package myProject;

public class User {
    private String  user;
    private String   date;
    private String  message;




    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", date='" + date + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}