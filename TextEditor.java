import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private String text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        text = "";
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void type(String newText) {
        undoStack.push(text);
        text += newText;
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text);
            text = undoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text);
            text = redoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-redo.");
        }
    }

    public void show() {
        System.out.println("Teks saat ini: " + text);
    }

    // Performance test methods
    public static void testPerformaType(TextEditor editor, int jumlahOperasi) {
        System.out.println("--- Pengukuran Performa TextEditor Type ---");
        long startTime = System.nanoTime();

        for (int i = 0; i < jumlahOperasi; i++) {
            editor.type("a");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.printf("Waktu untuk %d operasi 'type': %d ns (%.6f ms)%n",
                jumlahOperasi, duration, duration / 1_000_000.0);
        System.out.printf("Rata-rata waktu per operasi: %.2f ns%n",
                (double) duration / jumlahOperasi);
    }

    public static void testPerformaUndo(TextEditor editor, int jumlahOperasi) {
        System.out.println("\n--- Pengukuran Performa TextEditor Undo ---");

        // Prepare editor with enough states to undo
        for (int i = 0; i < jumlahOperasi; i++) {
            editor.type("a");
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < jumlahOperasi; i++) {
            editor.undo();
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.printf("Waktu untuk %d operasi 'undo': %d ns (%.6f ms)%n",
                jumlahOperasi, duration, duration / 1_000_000.0);
        System.out.printf("Rata-rata waktu per operasi: %.2f ns%n",
                (double) duration / jumlahOperasi);
    }

    public static void testPerformaRedo(TextEditor editor, int jumlahOperasi) {
        System.out.println("\n--- Pengukuran Performa TextEditor Redo ---");

        // Prepare editor with enough states to undo and redo
        for (int i = 0; i < jumlahOperasi; i++) {
            editor.type("a");
        }

        // Undo all operations first
        for (int i = 0; i < jumlahOperasi; i++) {
            editor.undo();
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < jumlahOperasi; i++) {
            editor.redo();
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.printf("Waktu untuk %d operasi 'redo': %d ns (%.6f ms)%n",
                jumlahOperasi, duration, duration / 1_000_000.0);
        System.out.printf("Rata-rata waktu per operasi: %.2f ns%n",
                (double) duration / jumlahOperasi);
    }

    public static void testPerformaMixedOperations(TextEditor editor, int jumlahOperasi) {
        System.out.println("\n--- Pengukuran Performa TextEditor Mixed Operations ---");
        long startTime = System.nanoTime();

        for (int i = 0; i < jumlahOperasi; i++) {
            if (i % 3 == 0) {
                editor.type("a");
            } else if (i % 3 == 1) {
                editor.undo();
            } else {
                editor.redo();
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.printf("Waktu untuk %d operasi campuran (type/undo/redo): %d ns (%.6f ms)%n",
                jumlahOperasi, duration, duration / 1_000_000.0);
        System.out.printf("Rata-rata waktu per operasi: %.2f ns%n",
                (double) duration / jumlahOperasi);
    }

    public static void runPerformanceTests() {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PERFORMANCE TEST TEXT EDITOR ===");
        System.out.println("Program ini akan menguji performa operasi TextEditor");
        System.out.println("1. Type operations");
        System.out.println("2. Undo operations");
        System.out.println("3. Redo operations");
        System.out.println("4. Mixed operations");
        System.out.println("5. Semua test");
        System.out.print("Pilih test yang ingin dijalankan (1-5): ");

        int choice = scanner.nextInt();
        System.out.print("Masukkan jumlah operasi untuk test (default: 10000): ");
        int jumlahOperasi = scanner.nextInt();

        if (jumlahOperasi <= 0) {
            jumlahOperasi = 10000;
        }

        switch (choice) {
            case 1:
                testPerformaType(editor, jumlahOperasi);
                break;
            case 2:
                testPerformaUndo(editor, jumlahOperasi);
                break;
            case 3:
                testPerformaRedo(editor, jumlahOperasi);
                break;
            case 4:
                testPerformaMixedOperations(editor, jumlahOperasi);
                break;
            case 5:
                testPerformaType(editor, jumlahOperasi);
                testPerformaUndo(editor, jumlahOperasi);
                testPerformaRedo(editor, jumlahOperasi);
                testPerformaMixedOperations(editor, jumlahOperasi);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }

        System.out.println("\n=== TEST SELESAI ===");
        scanner.close();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Editor Teks Sederhana dengan Undo/Redo");
        System.out.println("Perintah: type <teks>, undo, redo, show, performance, exit");
        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();
            if (command.startsWith("type ")) {
                String toType = command.substring(5);
                editor.type(toType);
            } else if (command.equals("undo")) {
                editor.undo();
            } else if (command.equals("redo")) {
                editor.redo();
            } else if (command.equals("show")) {
                editor.show();
            } else if (command.equals("performance")) {
                runPerformanceTests();
                break;
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Perintah tidak dikenal.");
            }
        }
        scanner.close();
    }
}