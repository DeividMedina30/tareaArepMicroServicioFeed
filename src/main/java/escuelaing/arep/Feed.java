package escuelaing.arep;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class Feed {

    private static List<Comment> feed=new ArrayList<Comment>();


    public static void main(String[] args) {
        port(getPort());
        get("/Feed",(req, res) ->{
            Gson gson= new Gson();
            return gson.toJson(getFeed());
        });
        post("/Feed",(req, res) ->{
            String commentString = req.body();
            Gson gson= new Gson();
            Comment comment=gson.fromJson(commentString,Comment.class);
            if (comment==null){
                res.status(400);
                return "Comment couldnt be added";
            }
            feed.add(comment);
            return gson.toJson(getFeed());
        });
    }

    public static List<Comment> getFeed(){
        return feed;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 7654; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
