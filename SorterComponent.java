// === SorterComponent.java ===
public class SorterComponent implements SortingService {
    private HistoryService historyService;

    public SorterComponent(HistoryService historyService) {
        this.historyService = historyService;
    }

    public void sort(String waste) {
        System.out.println("\n=== HASIL SORTING ===");
        if (waste.contains("makanan") || waste.contains("daun")) {
            System.out.println(ANSI.GREEN + "Kategori: Organik" + ANSI.RESET);
            System.out.println("Tips: Sampah organik bisa dijadikan kompos.");
            historyService.addToHistory(waste, "Organik");
        } else if (waste.contains("plastik") || waste.contains("kertas") || waste.contains("botol")) {
            System.out.println(ANSI.YELLOW + "Kategori: Non-Organik" + ANSI.RESET);
            System.out.println("Tips: Sampah non-organik bisa didaur ulang.");
            historyService.addToHistory(waste, "Non-Organik");
        } else if (waste.contains("baterai") || waste.contains("lampu") || waste.contains("obat")) {
            System.out.println(ANSI.RED + "Kategori: B3" + ANSI.RESET);
            System.out.println("Tips: Harus dibuang ke TPS khusus B3.");
            historyService.addToHistory(waste, "B3");
        } else {
            System.out.println(ANSI.PURPLE + "Kategori: Tidak diketahui" + ANSI.RESET);
            System.out.println("Tips: Gunakan kata kunci yang lebih spesifik.");
            historyService.addToHistory(waste, "Tidak diketahui");
        }
    }
}