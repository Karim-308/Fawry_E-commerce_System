import java.util.*;

public class ShippingService {
    public static void ship(List<Deliverable> items) {
        if (items == null || items.isEmpty()) return;
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        Map<String, Integer> nameToCount = new LinkedHashMap<>();
        Map<String, Double> nameToWeight = new HashMap<>();
        for (Deliverable item : items) {
            nameToCount.put(item.getItemName(), nameToCount.getOrDefault(item.getItemName(), 0) + 1);
            nameToWeight.put(item.getItemName(), item.getItemWeight());
            totalWeight += item.getItemWeight();
        }
        for (String name : nameToCount.keySet()) {
            int count = nameToCount.get(name);
            double weight = nameToWeight.get(name);
            System.out.printf("%dx %-12s %.0fg\n", count, name, weight);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000.0);
    }
} 