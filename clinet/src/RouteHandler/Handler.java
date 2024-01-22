package RouteHandler;

import com.google.gson.Gson;
import model.UsersDTO;

public class Handler {

    private static Gson json = new Gson();
    private static String route;
    private static String msg;

    public static void connSwitch(String route, String msg) {
        Handler.route = route;
        Handler.msg = msg;
        switch (route) {
            case "login":
                UsersDTO data = login();
                break;
            default:
                break;
        }
    }

    public static UsersDTO login() {
        UsersDTO myData = json.fromJson(msg, UsersDTO.class);
        return myData;
    }
}
