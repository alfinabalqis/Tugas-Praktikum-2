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
- Fitur: ketik teks, undo, redo, tampilkan teks.

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
```

### 3. Manajemen Data Mahasiswa dengan Linked List
- (Silakan tambahkan file dan implementasi sesuai kebutuhan tugas)
- Contoh aplikasi: menambah, menghapus, dan memperbarui data mahasiswa dalam sistem akademik.

---

## Analisis Perbandingan dan Efisiensi Operasi
Bagian ini membandingkan efisiensi operasi pada Queue, Stack, dan Linked List berdasarkan pengukuran waktu eksekusi menggunakan `System.nanoTime()`.

Pengukuran dilakukan dengan mencatat waktu sebelum dan sesudah setiap blok operasi, lalu menghitung selisihnya. Output konsol dinonaktifkan selama pengukuran untuk menghindari overhead.

| Jenis  | Method         | Jumlah Operasi | Waktu Eksekusi      | Analisis                                                                 |
|--------|---------------|----------------|---------------------|--------------------------------------------------------------------------|
| Queue  | addCustomer   | 100.000        | 17.704.875 ns       | Sangat efisien, penambahan selalu di akhir antrean. Rata-rata 177 ns/op. |
| Queue  | serveCustomer | 100.000        | 3.364.083 ns        | Sangat efisien, penghapusan di awal antrean. Rata-rata 33,6 ns/op.       |
| Stack  | (to be filled)| (to be filled) | (to be filled)      | (to be filled)                                                          |
| Linked List | (to be filled) | (to be filled) | (to be filled) | (to be filled)                                                          |

---

## Kesimpulan

(Analisis dan kesimpulan dapat diisi setelah seluruh pengujian dan implementasi selesai)