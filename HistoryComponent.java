// === HistoryComponent.java ===
import java.util.*;

public class HistoryComponent implements HistoryService {
    private List<String> history = new ArrayList<>();
    private Map<String, Integer> stats = new HashMap<>();

    public void addToHistory(String input, String category) {
        history.add("Sampah: " + input + " -> Kategori: " + category);
        stats.put(category, stats.getOrDefault(category, 0) + 1);
    }

    public List<String> getHistory() {
        return history;
    }

    public void showHistory() {
        System.out.println("\n=== RIWAYAT SORTING ===");
        if (history.isEmpty()) {
            System.out.println("(Kosong)");
        } else {
            history.forEach(System.out::println);
        }
    }

    public void searchHistory(String keyword) {
        System.out.println("\nHasil pencarian untuk: " + keyword);
        boolean found = false;
        for (String h : history) {
            if (h.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(h);
                found = true;
            }
        }
        if (!found) System.out.println("Tidak ditemukan.");
    }

    public void clearHistory() {
        history.clear();
        stats.clear();
    }

    public void showStats() {
        System.out.println("\n=== STATISTIK PEMILAHAN ===");
        if (stats.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }
        stats.forEach((cat, count) -> System.out.println(cat + ": " + count + " item"));
    }

    public void exportHistoryToFile() {
        System.out.println("\n(Simulasi) Menyimpan riwayat ke file teks...");
        history.forEach(System.out::println);
        System.out.println("(Export selesai.)");
    }
}
