# 🗂️ Trash Sorter

**Sistem Pemilahan Sampah Cerdas berbasis Java Console Application**

Trash Sorter adalah aplikasi console Java yang membantu pengguna dalam memilah sampah berdasarkan kategori: Organik, Non-Organik, dan B3 (Bahan Berbahaya dan Beracun). Aplikasi ini dilengkapi dengan fitur edukasi, riwayat pemilahan, dan statistik untuk mendukung pengelolaan sampah yang lebih baik.

## ✨ Fitur Utama

### 👤 Mode User
- **Pemilahan Sampah**: Pilih dari daftar atau input manual
- **Smart Sort**: Algoritma pemilahan otomatis berdasarkan kata kunci
- **Edukasi**: Informasi tentang jenis-jenis sampah dan pengolahannya
- **Riwayat Pemilahan**: Melihat history sorting yang telah dilakukan
- **Pencarian**: Cari sampah tertentu dalam riwayat
- **Rekomendasi**: Tips pengolahan berdasarkan kategori sampah

### 👨‍💼 Mode Admin
- **Manajemen Riwayat**: Lihat semua riwayat pengguna
- **Statistik**: Analisis data pemilahan sampah
- **Reset Data**: Hapus semua riwayat pemilahan
- **Export**: Simpan riwayat ke file .txt dengan timestamp
- **Pencarian Admin**: Cari data sampah dalam sistem

### 🎨 Fitur Tambahan
- **ANSI Color Coding**: Output berwarna untuk kategori sampah
- **File Export**: Export riwayat dengan format terstruktur
- **Interface Interaktif**: Menu yang user-friendly

## 🛠️ Teknologi

- **Java**: JDK 17+ (menggunakan Switch Expressions)
- **Standard Library**: 
  - `java.util.*` - Collections dan data structures
  - `java.io.*` - File I/O operations
  - `java.time.*` - Date and time handling

## 📁 Struktur Project

```
trash-sorter/
├── src/
│   ├── TrashSorter.java           # Main class dan menu utama
│   ├── components/
│   │   ├── SorterComponent.java   # Logic pemilahan sampah
│   │   ├── InputComponent.java    # Input handling
│   │   ├── HistoryComponent.java  # Manajemen riwayat
│   │   └── EducationComponent.java # Konten edukasi
│   ├── services/
│   │   ├── SortingService.java    # Interface untuk sorting
│   │   ├── WasteInputService.java # Interface untuk input
│   │   └── HistoryService.java    # Interface untuk history
│   └── utils/
│       └── ANSI.java              # Color constants
├── README.md
└── .gitignore
```

## 🚀 Instalasi

### Prasyarat
- Java Development Kit (JDK) 17 atau lebih baru
- Terminal/Command Prompt
- Git (optional)

### Langkah Instalasi

1. **Clone repository**
   ```bash
   git clone https://github.com/username/trash-sorter.git
   cd trash-sorter
   ```

2. **Compile semua file Java**
   ```bash
   javac *.java
   ```

3. **Jalankan aplikasi**
   ```bash
   java TrashSorter
   ```

## 💻 Cara Penggunaan

### Menjalankan Aplikasi

1. **Jalankan program**
   ```bash
   java TrashSorter
   ```

2. **Pilih role**
   ```
   === SELAMAT DATANG DI TRASH SORTER ===
   Masuk sebagai [user/admin/exit]: user
   ```
   
## 🗂️ Kategori Sampah

### 🟢 Organik
- **Contoh**: Sisa makanan, daun, kulit buah, sayur busuk, nasi basi
- **Pengolahan**: Kompos, pupuk organik
- **Warna Output**: Hijau

### 🟡 Non-Organik  
- **Contoh**: Plastik, botol, kertas, kaca
- **Pengolahan**: Daur ulang, bank sampah
- **Warna Output**: Kuning

### 🔴 B3 (Bahan Berbahaya dan Beracun)
- **Contoh**: Baterai, lampu neon, obat kadaluarsa  
- **Pengolahan**: TPS B3 khusus
- **Warna Output**: Merah

### Menu Utama
```
=== SELAMAT DATANG DI TRASH SORTER ===
Masuk sebagai [user/admin/exit]: 
```

### Hasil Pemilahan
```
=== HASIL SORTING ===
Kategori: Organik
Tips: Sampah organik bisa dijadikan kompos.
```

### Statistik Admin
```
=== STATISTIK PEMILAHAN ===
Organik: 12 item
Non-Organik: 8 item
B3: 3 item
```

## 🔧 Kustomisasi

### Menambah Kategori Baru
1. Edit `SorterComponent.java`
2. Tambahkan kondisi baru dalam method `sort()`
3. Tambahkan warna ANSI baru di `ANSI.java`

### Menambah Jenis Sampah
1. Edit `InputComponent.java` 
2. Tambahkan opsi baru dalam `getWasteInputFromList()`
3. Update algoritma sorting di `SorterComponent.java`

## 🤝 Kontribusi

Kontribusi sangat diterima! Untuk berkontribusi:

1. **Fork** repository ini
2. **Buat branch** untuk fitur baru (`git checkout -b fitur-baru`)
3. **Commit** perubahan (`git commit -am 'Menambah fitur baru'`)
4. **Push** ke branch (`git push origin fitur-baru`)  
5. **Buat Pull Request**

## 📝 Changelog

### v1.0.0 (Current)
- ✅ Pemilahan sampah 3 kategori
- ✅ Mode User dan Admin
- ✅ Riwayat dan statistik
- ✅ Export ke file .txt
- ✅ ANSI color support
- ✅ Edukasi sampah

---

⭐ **Jika project ini bermanfaat, jangan lupa berikan star!** ⭐
