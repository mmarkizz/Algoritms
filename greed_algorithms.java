import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class greed_algorithms {

    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                return (i2.value * 1.0 / i2.weight) - (i1.value * 1.0 / i1.weight) > 0 ? 1 : -1; // Сравнение по соотношению ценности к весу
            }
        });

        double totalValue = 0;

        for (Item item : items) {
            if (capacity - item.weight >= 0) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double) capacity / item.weight); // берем оставшуюся часть
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Максимальная ценность: " + maxValue);
    }
}