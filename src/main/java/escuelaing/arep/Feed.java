package escuelaing.arep;

import java.util.List;

import static spark.Spark.port;
import static spark.Spark.get;

public class Feed {

    private static List<String> feed;

    public static void main(String[] args) {
        port(getPort());
        get("/Feed",(req, res) ->{
            List<String> output=getFeed();
            return output;
        });
    }

    public static List<String> getFeed(){
        return feed;
    }

    public static void setFeed(List<String> newFeed){
        feed=newFeed;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 7654; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
