import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class search_in_width {
    public static boolean search(String name, Map<String, List<String>> graph) {
        Deque<String> searchQueue = new LinkedList<>(graph.get(name));
        List<String> searched = new ArrayList<>();

        while (!searchQueue.isEmpty()) { // пока очередь не пустая
            String person = searchQueue.pollFirst(); // берём первого из очереди
            if (!searched.contains(person)) { // и если этот человек не был просмотрен раннее
                if (personIsSeller(person)) { // и если его имя оканчивается на m
                    System.out.println(person + " is a mango seller"); // то это продавец манго
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person)); // если нет добавляем друзей выбранного человека в очередь
                    searched.add(person);// а самого человека отмечаем как проверенного
                }
            }
        }

        return false;
    }

    private static boolean personIsSeller(String name) {
        return name.endsWith("m");
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("you", new ArrayList<>(Arrays.asList("alice", "bob", "claire")));
        graph.put("bob", new ArrayList<>(Arrays.asList("anuj", "peggy")));
        graph.put("alice", new ArrayList<>(Arrays.asList("peggy")));
        graph.put("claire", new ArrayList<>(Arrays.asList("thom", "jonny")));
        graph.put("anuj", new ArrayList<>());
        graph.put("peggy", new ArrayList<>());
        graph.put("thom", new ArrayList<>());
        graph.put("jonny", new ArrayList<>());

        search("you", graph);
    }
}
