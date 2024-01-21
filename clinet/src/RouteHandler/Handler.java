package RouteHandler;

import com.google.gson.Gson;
import model.User;

public class Handler {

    private static Gson json = new Gson();
    private static String route;
    private static String msg;

    public static void connSwitch(String route, String msg) {
        Handler.route = route;
        Handler.msg = msg;
        switch (route) {
            case "login":
                User data = login();
                break;
            
            default:
                break;
        }
    }

    public static User login() {
        User myData = json.fromJson(msg, User.class);
        return myData;
    }

   
}
