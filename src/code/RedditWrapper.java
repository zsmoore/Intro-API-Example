package code;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.util.ArrayList;

public class RedditWrapper {

    private static final String popularURL = "https://www.reddit.com/subreddits/popular.json";

    public static JsonObject getPopular() {
        return Json.parse(HTTPRequests.getRequest(popularURL)).asObject();
    }

    public static ArrayList<String> allSubredditNames() {
        ArrayList<String> subredditNames = new ArrayList<>();
        JsonObject popular = getPopular();
        JsonArray children = popular.get("data").asObject().get("children").asArray();
        for (JsonValue child : children) {
            JsonObject base = child.asObject();
            JsonObject data = base.get("data").asObject();
            subredditNames.add(data.get("display_name_prefixed").asString());
        }
        return subredditNames;
    }
}
