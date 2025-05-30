// === EducationComponent.java ===
public class EducationComponent {
    public void showEducation() {
        System.out.println("\n=== EDUKASI JENIS SAMPAH ===");
        System.out.println("\nORGANIK:");
        System.out.println("Contoh: sisa makanan, daun, kulit buah, sayur busuk, nasi basi");
        System.out.println("Tips: Bisa dijadikan kompos.");

        System.out.println("\nNON-ORGANIK:");
        System.out.println("Contoh: plastik, botol, kertas, kaca");
        System.out.println("Tips: Pisahkan dan kirim ke tempat daur ulang.");

        System.out.println("\nB3:");
        System.out.println("Contoh: baterai, lampu neon, obat kadaluarsa");
        System.out.println("Tips: Buang di TPS B3 khusus.");
    }

    public void showTipsByCategory(String category) {
        System.out.println("\nRekomendasi Pengolahan untuk " + category + ":");
        switch (category.toLowerCase()) {
            case "organik" -> System.out.println("Gunakan komposter atau pengolahan pupuk organik.");
            case "non-organik" -> System.out.println("Cuci bersih dan kirim ke bank sampah.");
            case "b3" -> System.out.println("Kumpulkan dalam wadah tertutup dan serahkan ke TPS khusus.");
            default -> System.out.println("Kategori tidak dikenali.");
        }
    }
}