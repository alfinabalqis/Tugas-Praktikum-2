import java.util.Scanner;

public class MahasiswaLinkedList {
    class Node {
        String nim;
        String nama;
        double nilai;
        Node prev, next;

        Node(String nim, String nama, double nilai) {
            this.nim = nim;
            this.nama = nama;
            this.nilai = nilai;
        }
    }

    private Node head = null;

    // Metode untuk menambah mahasiswa baru
    public void tambahMahasiswa(String nim, String nama, double nilai) {
        Node newNode = new Node(nim, nama, nilai);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Metodode untuk menghapus mahasiswa berdasarkan NIM
    public void hapusMahasiswa(String nim) {
        Node temp = head;
        while (temp != null && !temp.nim.equals(nim))
            temp = temp.next;

        if (temp == null) {
            return;
        }

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    // Metode untuk mengupdate nilai mahasiswa berdasarkan NIM
    public void updateNilai(String nim, double nilaiBaru) {
        Node temp = head;
        while (temp != null && !temp.nim.equals(nim))
            temp = temp.next;

        if (temp != null) {
            temp.nilai = nilaiBaru;
        }
    }

    // Metode untuk menampilkan daftar mahasiswa
    public void tampilkanDaftarMahasiswa() {
        if (head == null) {
            System.out.println("Daftar mahasiswa kosong.");
            return;
        }

        Node temp = head;
        int count = 1;
        System.out.println("\n=== Daftar Mahasiswa ===");
        while (temp != null) {
            System.out.printf("%d. NIM: %s, Nama: %s, Nilai: %.2f\n",
                    count, temp.nim, temp.nama, temp.nilai);
            temp = temp.next;
            count++;
        }
    }

    // Metode untuk mengukur performa penambahan mahasiswa
    public void testPerformaTambahMahasiswa() {
        System.out.println("Menambahkan 100.000 mahasiswa.");
        long startTime = System.nanoTime();

        for (int i = 1; i <= 100000; i++) {
            String nim = "NIM" + String.format("%04d", i);
            String nama = "Mahasiswa" + i;
            double nilai = Math.random() * 100;
            tambahMahasiswa(nim, nama, nilai);
        }

        long endTime = System.nanoTime();
        double durationNano = endTime - startTime;
        System.out.printf("Penambahan selesai dalam %.2f ns\n", durationNano);
    }

    // Metode untuk mengukur performa update nilai mahasiswa
    public void testPerformaUpdateMahasiswa() {
        System.out.println("Mengupdate nilai untuk 100.000 mahasiswa.");
        long startTime = System.nanoTime();

        for (int i = 1; i <= 100000; i++) {
            String nim = "NIM" + String.format("%04d", i);
            double nilaiBaru = 100.0;
            updateNilai(nim, nilaiBaru);
        }

        long endTime = System.nanoTime();
        double durationNano = endTime - startTime;
        System.out.printf("Update selesai dalam %.2f ns\n", durationNano);
    }

    // Metode untuk mengukur performa penghapusan mahasiswa
    public void testPerformaHapusMahasiswa() {
        System.out.println("Menghapus 100.000 mahasiswa.");
        long startTime = System.nanoTime();

        for (int i = 1; i <= 100000; i++) {
            String nim = "NIM" + String.format("%04d", i);
            hapusMahasiswa(nim);
        }

        long endTime = System.nanoTime();
        double durationNano = endTime - startTime;
        System.out.printf("Penghapusan selesai dalam %.2f ns\n", durationNano);
    }

    // Metode untuk mengukur performa penampilan daftar mahasiswa
    public void testPerformaTampilkanMahasiswa() {
        System.out.println("Menampilkan seluruh mahasiswa.");
        long startTime = System.nanoTime();

        Node temp = head;
        while (temp != null) {
            temp = temp.next;
        }

        long endTime = System.nanoTime();
        double durationNano = endTime - startTime;
        System.out.printf("Traversal selesai dalam %.2f ns\n", durationNano);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MahasiswaLinkedList daftar = new MahasiswaLinkedList();
        int pilihan;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Test Performa Tambah Mahasiswa");
            System.out.println("2. Test Performa Update Mahasiswa");
            System.out.println("3. Test Performa Hapus Mahasiswa");
            System.out.println("4. Test Performa Tampilkan Mahasiswa");
            System.out.println("5. Tambah Mahasiswa Baru");
            System.out.println("6. Hapus Mahasiswa");
            System.out.println("7. Update Nilai Mahasiswa");
            System.out.println("8. Tampilkan Daftar Mahasiswa");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    daftar.testPerformaTambahMahasiswa();
                    break;
                case 2:
                    daftar.testPerformaUpdateMahasiswa();
                    break;
                case 3:
                    daftar.testPerformaHapusMahasiswa();
                    break;
                case 4:
                    daftar.testPerformaTampilkanMahasiswa();
                    break;
                case 5:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    double nilai = scanner.nextDouble();
                    daftar.tambahMahasiswa(nim, nama, nilai);
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    break;
                case 6:
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    daftar.hapusMahasiswa(nimHapus);
                    System.out.println("Mahasiswa berhasil dihapus.");
                    break;
                case 7:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimUpdate = scanner.nextLine();
                    System.out.print("Masukkan nilai baru: ");
                    double nilaiBaru = scanner.nextDouble();
                    daftar.updateNilai(nimUpdate, nilaiBaru);
                    System.out.println("Nilai mahasiswa berhasil diupdate.");
                    break;
                case 8:
                    daftar.tampilkanDaftarMahasiswa();
                    break;
                case 9:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 9);

        scanner.close();
    }
}
