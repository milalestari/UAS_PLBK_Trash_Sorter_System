import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrashSorter {
    private static final HistoryComponent sharedHistory = new HistoryComponent();
    private static final WasteInputService input = new InputComponent();
    private static final SortingService sorter = new SorterComponent(sharedHistory);
    private static final EducationComponent edu = new EducationComponent();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== SELAMAT DATANG DI TRASH SORTER ===");
            System.out.print("Masuk sebagai [user/admin/exit]: ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("admin")) {
                runAdminMenu(scanner);
            } else if (role.equals("user")) {
                runUserMenu(scanner);
            } else if (role.equals("exit")) {
                System.out.println("Terima kasih telah menggunakan Trash Sorter!");
                break;
            } else {
                System.out.println("Role tidak dikenali.");
            }
        }

        scanner.close();
    }

    private static void runUserMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n\033[1;36m=== TRASH SORTER USER MENU ===\033[0m");
            System.out.println("1. Pilih Jenis Sampah");
            System.out.println("2. Smart Sort (Input Manual)");
            System.out.println("3. Edukasi Jenis Sampah");
            System.out.println("4. Lihat Riwayat");
            System.out.println("5. Cari Sampah dalam Riwayat");
            System.out.println("6. Rekomendasi Pengolahan Berdasarkan Kategori");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> sorter.sort(input.getWasteInputFromList());
                case "2" -> sorter.sort(input.getCustomWasteInput());
                case "3" -> edu.showEducation();
                case "4" -> sharedHistory.showHistory();
                case "5" -> {
                    System.out.print("Masukkan kata kunci pencarian: ");
                    sharedHistory.searchHistory(scanner.nextLine());
                }
                case "6" -> {
                    System.out.print("Masukkan kategori (Organik/Non-Organik/B3): ");
                    edu.showTipsByCategory(scanner.nextLine());
                }
                case "0" -> {
                    running = false;
                    System.out.println("\nKeluar dari mode user.");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void runAdminMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n\033[1;33m=== TRASH SORTER ADMIN MENU ===\033[0m");
            System.out.println("1. Lihat Semua Riwayat Pengguna");
            System.out.println("2. Statistik Sampah");
            System.out.println("3. Reset Semua Riwayat");
            System.out.println("4. Cari Sampah Tertentu dalam Riwayat");
            System.out.println("5. Export Riwayat ke File Teks (.txt)");
            System.out.println("0. Logout");
            System.out.print("Pilihan Anda: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> sharedHistory.showHistory();
                case "2" -> sharedHistory.showStats();
                case "3" -> {
                    sharedHistory.clearHistory();
                    System.out.println("Riwayat berhasil dihapus.");
                }
                case "4" -> {
                    System.out.print("Masukkan kata kunci: ");
                    sharedHistory.searchHistory(scanner.nextLine());
                }
                case "5" -> exportHistoryToFile();
                case "0" -> {
                    running = false;
                    System.out.println("Logout berhasil.");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void exportHistoryToFile() {
        String filename = "riwayat_sampah.txt";
        List<String> historyList = sharedHistory.getHistory();
        Map<String, Integer> stats = new HashMap<>();

        for (String line : historyList) {
            if (line.contains("Kategori: ")) {
                String kategori = line.substring(line.indexOf("Kategori: ") + 10).trim();
                stats.put(kategori, stats.getOrDefault(kategori, 0) + 1);
            }
        }

        try (FileWriter writer = new FileWriter(filename)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);

            writer.write("=== EXPORT RIWAYAT SAMPAH ===\n");
            writer.write("Waktu Export: " + timestamp + "\n\n");

            writer.write("-- Statistik Sampah --\n");
            if (stats.isEmpty()) {
                writer.write("Tidak ada statistik.\n");
            } else {
                for (Map.Entry<String, Integer> entry : stats.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }

            writer.write("\n-- Riwayat Pemilahan --\n");
            if (historyList == null || historyList.isEmpty()) {
                writer.write("Tidak ada data riwayat.\n");
            } else {
                for (String line : historyList) {
                    writer.write(line + System.lineSeparator());
                }
            }

            System.out.println("\nRiwayat dan statistik berhasil disimpan ke file: " + filename);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }
}
