import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Request;
import spark.Response;
import spark.servlet.SparkApplication;

import java.text.MessageFormat;

import static spark.Spark.*;

/**
 * @author Joseph Moore (joseph_moore@byu.edu)
 */
public class Service /*implements SparkApplication*/ {
//    public static void main(String... args) {
//        get("/", Service::sayHello);
//    }

    public static String makeGreeting(String lang, String name) {
        if (lang == null) {
            lang = "en";
        }
        if (name == null) {
            name = "World";
        }

        String format = greetingFormat(lang);
        return gson.toJson(new Greeting(MessageFormat.format(format, name), lang));
    }

//    private static String sayHello(Request req, Response res) throws Exception {
//        String lang = req.queryParams("lang");
//        String name = req.queryParams("name");
//
//        res.header("Content-Type", "application/json");
//        return makeGreeting(lang, name);
//    }

    private static String greetingFormat(String lang) {
        switch (lang) {
            case "en":
                return "Hello, {0}!";
            case "it":
                return "Ciao, {0}!";
            case "fr":
                return "Bonjour, {0}!";
            case "es":
                return "¡Hola, {0}!";
            case "eo":
                return "Saluton, {0}!";
            default:
                return "I don't speak your language, {0}!";
        }
    }

    private static final Gson gson = new GsonBuilder()
            .create();

//    @Override
//    public void init() {
//        get("/", Service::sayHello);
//    }
//
//    @Override
//    public void destroy() {
//
//    }

    private static final class Greeting {
        private final String greeting;
        private final String lang;

        private Greeting(String greeting, String lang) {
            this.greeting = greeting;
            this.lang = lang;
        }
    }
}
