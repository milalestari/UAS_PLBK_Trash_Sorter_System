// === HistoryService.java ===
import java.util.List;

public interface HistoryService {
    void addToHistory(String input, String category);
    List<String> getHistory();
    void showHistory();
    void searchHistory(String keyword);
    void clearHistory();
    void showStats();
    void exportHistoryToFile();
}
