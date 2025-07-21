# TEAM ASSIGNMENTS

## DATA STRUCTURES AND ALGORITHM ANALYSIS

---

### Mengimplementasikan Dan Menganalisis Kinerja Linked List, Stack, dan Queue Dalam Konteks Aplikasi Nyata

**Kelas:** AOCA – LAB  
**Group:** 4

| Nama                          | NIM        |
|-------------------------------|------------|
| HORAS MAROLOP AMSAL SIREGAR   | 2802608864 |
| ALFINA BALQIS NURZAHARANI     | 2802582152 |
| EGI NUGRAHA                   | 2802597854 |

**BINUS UNIVERSITY**  
Semester Ganjil 2024/2025

---

## LAPORAN PRAKTIKUM 2

Praktikum ini bertujuan untuk mengimplementasikan dan menganalisis kinerja Linked List, Stack, dan Queue dalam konteks aplikasi nyata. Tugas ini dibagi menjadi tiga bagian utama:
- Membuat sistem manajemen antrean menggunakan Queue
- Mengembangkan fitur undo/redo dalam editor teks menggunakan Stack
- Menggunakan Linked List untuk mengelola data mahasiswa dalam sistem akademik

Repository Praktikum: [https://github.com/alfinabalqis/Tugas-Praktikum-2](https://github.com/alfinabalqis/Tugas-Praktikum-2)

---

## Cara Menjalankan Program

```bash
# Compile semua file
javac *.java

# Jalankan CustomerServiceQueue
java CustomerServiceQueue

# Jalankan TextEditor 
java TextEditor

# Jalankan MahasiswaLinkedList
java MahasiswaLinkedList
```

---

## Implementasi Program

### 1. Sistem Manajemen Antrean (Queue)
File: `CustomerServiceQueue.java`

- Menggunakan `Queue<String>` berbasis `LinkedList` untuk menyimpan antrean pelanggan.
- Fitur: tambah pelanggan, layani pelanggan, tampilkan antrean.
- Terdapat pengujian performa untuk 100.000 operasi penambahan dan penghapusan pelanggan menggunakan `System.nanoTime()`.

**Contoh Output Program:**
```
--- Pengukuran Performa Queue ---
Waktu untuk 100000 operasi 'addCustomer': 17704875 ns (17.704875 ms)
Waktu untuk 100000 operasi 'serveCustomer': 3364083 ns (3.364083 ms)

--- Antrian Pelanggan ---
Andi telah ditambahkan ke antrean.
Budi telah ditambahkan ke antrean.
Siti telah ditambahkan ke antrean.
Pelanggan dalam antrean:
1. Andi
2. Budi
3. Siti

Melayani pelanggan: Andi

Pelanggan dalam antrean:
1. Budi
2. Siti

Melayani pelanggan: Budi

Pelanggan dalam antrean:
1. Siti

Melayani pelanggan: Siti
Antrean kosong, tidak ada pelanggan untuk dilayani.
Pelanggan dalam antrean: Kosong
```

### 2. Fitur Undo/Redo dalam Editor Teks (Stack)
File: `TextEditor.java`

- Menggunakan dua buah stack (`undoStack` dan `redoStack`) untuk menyimpan state teks sebelum dan sesudah perubahan.
- Fitur: ketik teks, undo, redo, tampilkan teks, performance test.
- Terdapat pengujian performa untuk operasi type, undo, redo, dan operasi campuran menggunakan `System.nanoTime()`.

**Contoh Penggunaan:**
```
> type Halo
> show
Teks saat ini: Halo
> type Dunia
> show
Teks saat ini: HaloDunia
> undo
> show
Teks saat ini: Halo
> redo
> show
Teks saat ini: HaloDunia
> performance
=== PERFORMANCE TEST TEXT EDITOR ===
Program ini akan menguji performa operasi TextEditor
1. Type operations
2. Undo operations
3. Redo operations
4. Mixed operations
5. Semua test
Pilih test yang ingin dijalankan (1-5):
```

**Contoh Output Performance Test:**
```
=== PERFORMANCE TEST TEXT EDITOR ===
--- Pengukuran Performa TextEditor Type ---
Waktu untuk 10000 operasi 'type': 11659917 ns (11.659917 ms)
Rata-rata waktu per operasi: 1165.99 ns

--- Pengukuran Performa TextEditor Undo ---
Waktu untuk 10000 operasi 'undo': 4926500 ns (4.926500 ms)
Rata-rata waktu per operasi: 492.65 ns

--- Pengukuran Performa TextEditor Redo ---
Waktu untuk 10000 operasi 'redo': 1297708 ns (1.297708 ms)
Rata-rata waktu per operasi: 129.77 ns

--- Pengukuran Performa TextEditor Mixed Operations ---
Waktu untuk 10000 operasi campuran (type/undo/redo): 7229750 ns (7.229750 ms)
Rata-rata waktu per operasi: 722.98 ns
```

### 3. Manajemen Data Mahasiswa dengan Linked List
File: `MahasiswaLinkedList.java`

- Program Manajemen Data Mahasiswa menggunakan `Double Linked List`.
- Fitur: tambah, update, tampilkan dan hapus data mahasiswa.
- Terdapat pengujian performa untuk 100.000 operasi penambahan, update, traversal dan penghapusan data mahasiswa menggunakan `System.nanoTime()`.

**Contoh Output Program:**
```
Menambahkan 100.000 mahasiswa.
Penambahan selesai dalam 36133355417,00 ns
```

---

## Analisis Perbandingan dan Efisiensi Operasi
Bagian ini membandingkan efisiensi operasi pada Queue, Stack, dan Linked List berdasarkan pengukuran waktu eksekusi menggunakan `System.nanoTime()`.

Pengukuran dilakukan dengan mencatat waktu sebelum dan sesudah setiap blok operasi, lalu menghitung selisihnya. Output konsol dinonaktifkan selama pengukuran untuk menghindari overhead.

| Jenis  | Method         | Jumlah Operasi | Waktu Eksekusi      | Analisis                                                                 |
|--------|---------------|----------------|---------------------|--------------------------------------------------------------------------|
| Queue  | addCustomer   | 100.000        | 17.704.875 ns       | Sangat efisien, penambahan selalu di akhir antrean. Rata-rata 177 ns/op. |
| Queue  | serveCustomer | 100.000        | 3.364.083 ns        | Sangat efisien, penghapusan di awal antrean. Rata-rata 33,6 ns/op.       |
| Stack  | type          | 10.000         | 11.659.917 ns       | Operasi push ke stack efisien, rata-rata 1.165,99 ns/op.                 |
| Stack  | undo          | 10.000         | 4.926.500 ns        | Operasi pop dari stack cepat, rata-rata 492,65 ns/op.                   |
| Stack  | redo          | 10.000         | 1.297.708 ns        | Operasi pop dari redo stack sangat efisien, rata-rata 129,77 ns/op.      |
| Stack  | mixed ops     | 10.000         | 7.229.750 ns        | Operasi campuran memerlukan overhead, rata-rata 722,98 ns/op.            |
| Linked List | testPerformaTambahMahasiswa     | 100.000 | 36.133.355.417 ns   | Operasi tambah masih efisien, rata-rata 361.334 ns/op.                     |
| Linked List | testPerformaUpdateMahasiswa     | 100.000 | 14.940.892.292 ns   | Update relatif cepat, rata-rata 149.409 ns/ops.                             |
| Linked List | testPerformaTampilkanMahasiswa  | 100.000 | 3.339.125 ns        | Menampilkan sangat cepat, hanya traversal satu arah, rata-rata 33,39 ns/op.  |
| Linked List | testPerformaHapusMahasiswa      | 100.000 | 62.616.667 ns       | Hapus membutuhkan traversal dan penggeseran pointer, agak lebih lambat. Rata-rata 626,17 ns/op.|

---

## Kesimpulan

Berdasarkan pengujian performa yang telah dilakukan pada ketiga struktur data (Queue, Stack, dan Linked List), dapat ditarik beberapa kesimpulan:

### 1. **Queue Performance (Customer Service)**
- Operasi `addCustomer` (enqueue) sangat efisien dengan rata-rata 177 ns/op
- Operasi `serveCustomer` (dequeue) bahkan lebih cepat dengan rata-rata 33,6 ns/op
- Queue berbasis LinkedList menunjukkan performa yang sangat baik untuk operasi FIFO

### 2. **Stack Performance (TextEditor)**
- Operasi `type` (push ke undoStack) efisien dengan rata-rata 1.165,99 ns/op
- Operasi `undo` (pop dari undoStack) cepat dengan rata-rata 492,65 ns/op
- Operasi `redo` (pop dari redoStack) sangat efisien dengan rata-rata 129,77 ns/op
- Operasi campuran memerlukan overhead lebih tinggi (722,98 ns/op) karena switching antar stack

### 3. **Linked List Performance (Mahasiswa)**
- Operasi traversal (`tampilkanMahasiswa`) sangat cepat dengan rata-rata 33,39 ns/op
- Operasi tambah dan update relatif efisien
- Operasi hapus memerlukan waktu lebih lama karena perlu traversal dan penggeseran pointer

### 4. **Perbandingan Umum**
- **Queue** dan **Stack** menunjukkan performa yang sangat baik untuk operasi dasar mereka
- **Linked List** efisien untuk traversal tetapi memerlukan waktu lebih untuk operasi yang membutuhkan pencarian
- Implementasi undo/redo menggunakan Stack sangat efektif dan cepat
- Semua struktur data menunjukkan kompleksitas waktu O(1) untuk operasi utama mereka

Implementasi ini berhasil mendemonstrasikan efisiensi dan kegunaan struktur data dalam konteks aplikasi nyata.