import java.util.HashMap;

public class algoritm_Deykstry {

    public static void main(String[] args) {

        // создание взвешенного графа
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

        HashMap<String, Integer> startNode = new HashMap<>();
        startNode.put("a", 6);
        startNode.put("b", 2);

        graph.put("start", startNode);

        HashMap<String, Integer> aNode = new HashMap<>();
        aNode.put("fin", 1);
        graph.put("a", aNode);

        HashMap<String, Integer> bNode = new HashMap<>();
        bNode.put("a", 3);
        bNode.put("fin", 5);
        graph.put("b", bNode);

        Map<String, Integer> finNode = new HashMap<>();
        graph.put("fin", finNode);

        // создание таблицы стоимостей
        float infinity = Float.POSITIVE_INFINITY;
        HashMap<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", infinity);

        // создание таблиц родителей
        HashMap<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin");

        String node = findLowestCostNode(costs, new HashSet<>());
        while (node != null) {
            float cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            for (Map.Entry<String, Integer> entry : neighbors.entrySet()) {
                String n = entry.getKey();
                int newCost = (int) (cost + entry.getValue());
                if (costs.get(n) > newCost) {
                    costs.put(n, (float) newCost);
                    parents.put(n, node);
                }
            }
            costs.remove(node);
            node = findLowestCostNode(costs, new HashSet<>(parents.values()));
        }
    }

    private static String findLowestCostNode(Map<String, Float> costs, Set<String> processed) {
        float lowestCost = Float.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for (Map.Entry<String, Float> entry : costs.entrySet()) {
            if (entry.getValue() < lowestCost && !processed.contains(entry.getKey())) {
                lowestCost = entry.getValue();
                lowestCostNode = entry.getKey();
            }
        }
        return lowestCostNode;
    }

}