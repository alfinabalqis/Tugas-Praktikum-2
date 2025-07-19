import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceQueue {
    // Deklarasi Queue
    private Queue<String> customerQueue;

    public CustomerServiceQueue() {
        // Inisialisasi Queue menggunakan LinkedList
        this.customerQueue = new LinkedList<>();
    }

    // Metode untuk menambah pelanggan baru ke antrean
    public void addCustomer(String customerName, boolean showOutput) {
        customerQueue.offer(customerName);
        if (showOutput) {
            System.out.println(customerName + " telah ditambahkan ke antrean.");
        }
    }

    // Metode untuk melayani pelanggan (menghapus dari antrean)
    public void serveCustomer(boolean showOutput) {
        if (!customerQueue.isEmpty()) {
            String servedCustomer = customerQueue.poll();
            if (showOutput) {
                System.out.println("Melayani pelanggan: " + servedCustomer);
            }
        } else {
            if (showOutput) { // Hanya tampilkan pesan ini jika showOutput true
                System.out.println("Antrean kosong, tidak ada pelanggan untuk dilayani.");
            }
        }
    }

    // Metode untuk menampilkan daftar pelanggan dalam antrean
    public void displayCustomers() {
        if (customerQueue.isEmpty()) {
            System.out.println("Pelanggan dalam antrean: Kosong");
        } else {
            System.out.println("Pelanggan dalam antrean:");
            int i = 1;
            for (String customer : customerQueue) {
                System.out.println(i + ". " + customer);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        CustomerServiceQueue customerQueue = new CustomerServiceQueue();
        int numberOfOperations = 100000; // Menggunakan angka yang lebih besar untuk pengujian performa

        System.out.println("--- Pengukuran Performa Queue ---");

        // --- Mengukur waktu untuk operasi 'addCustomer' (enqueue) ---
        long startTimeAdd = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            customerQueue.addCustomer("Pelanggan_" + i, false);
        }
        long endTimeAdd = System.nanoTime();
        long durationAdd = (endTimeAdd - startTimeAdd);
        double durationAddMs = (double) durationAdd / 1_000_000.0;
        System.out.println("Waktu untuk " + numberOfOperations + " operasi 'addCustomer': " + durationAdd + " ns ("
                + durationAddMs + " ms)");

        // --- Mengukur waktu untuk operasi 'serveCustomer' (dequeue) ---
        long startTimeServe = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            customerQueue.serveCustomer(false);
        }
        long endTimeServe = System.nanoTime();
        long durationServe = (endTimeServe - startTimeServe);
        double durationServeMs = (double) durationServe / 1_000_000.0;
        System.out.println("Waktu untuk " + numberOfOperations + " operasi 'serveCustomer': " + durationServe + " ns ("
                + durationServeMs + " ms)");

        System.out.println("\n--- Antrian Pelanggan ---");

        // Reset antrean untuk contoh penggunaan normal
        customerQueue = new CustomerServiceQueue(); 
        
        customerQueue.addCustomer("Andi", true);
        customerQueue.addCustomer("Budi", true);
        customerQueue.addCustomer("Siti", true);
        
        customerQueue.displayCustomers();
        System.out.println();
        
        customerQueue.serveCustomer(true);
        System.out.println();
        
        customerQueue.displayCustomers();
        System.out.println();
        
        customerQueue.serveCustomer(true);
        System.out.println();
        
        customerQueue.displayCustomers();
        
        customerQueue.serveCustomer(true);
        customerQueue.serveCustomer(true);
        customerQueue.displayCustomers();
    }
}