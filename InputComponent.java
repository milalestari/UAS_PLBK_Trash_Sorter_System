// === InputComponent.java ===
import java.util.Scanner;

public class InputComponent implements WasteInputService {
    private Scanner scanner = new Scanner(System.in);

    public String getWasteInputFromList() {
        System.out.println("\nPilih jenis sampah:");
        System.out.println("1. Sisa makanan");
        System.out.println("2. Daun kering");
        System.out.println("3. Botol plastik");
        System.out.println("4. Kertas");
        System.out.println("5. Baterai bekas");
        System.out.println("6. Lampu rusak");
        System.out.print("Pilihan Anda (1-6): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return switch (choice) {
            case 1 -> "sisa makanan";
            case 2 -> "daun kering";
            case 3 -> "botol plastik";
            case 4 -> "kertas";
            case 5 -> "baterai";
            case 6 -> "lampu";
            default -> "";
        };
    }

    public String getCustomWasteInput() {
        System.out.print("Masukkan jenis sampah secara manual: ");
        return scanner.nextLine().toLowerCase().trim();
    }
}