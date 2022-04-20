package escuelaing.arep;

import java.util.Date;

public class Comment {
    public String user;
    public String body;
    public Comment(){}

    public void setUser(String user) {
        this.user = user;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }
}
