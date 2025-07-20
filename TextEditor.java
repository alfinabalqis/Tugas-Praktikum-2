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

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Editor Teks Sederhana dengan Undo/Redo");
        System.out.println("Perintah: type <teks>, undo, redo, show, exit");
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
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Perintah tidak dikenal.");
            }
        }
        scanner.close();
    }
}