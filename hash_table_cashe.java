import java.util.HashMap;
import java.util.Map;

public class hash_table_cashe {
    private static Map<String, String> cache = new HashMap<>();

    public static String getPage(String url) {
        if (cache.containsKey(url)) {
            return cache.get(url);
        } else {
            String data = getDataFromServer(url);
            cache.put(url, data);
            return data;
        }
    }

    private static String getDataFromServer(String url) {
        // Здесь вы должны реализовать логику для получения данных с сервера
        // Это может включать в себя HTTP-запрос, чтение файла и т.д.
        return "Data for URL: " + url;
    }

    public static void main(String[] args) {
        String url1 = "https://example.com/page1";
        String url2 = "https://example.com/page2";

        System.out.println(getPage(url1)); // Выведет "Data for URL: https://example.com/page1"
        System.out.println(getPage(url1)); // Выведет "Data for URL: https://example.com/page1" (из кэша)
        System.out.println(getPage(url2)); // Выведет "Data for URL: https://example.com/page2"
    }

}
