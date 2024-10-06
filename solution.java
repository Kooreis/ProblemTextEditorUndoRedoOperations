Here is a simple implementation of a text editor that supports undo and redo operations using two stacks in Java:

```java
import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private String text;

    public TextEditor() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        text = "";
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
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text);
            text = redoStack.pop();
        }
    }

    public String getText() {
        return text;
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Enter command (type, undo, redo, exit):");
            command = scanner.nextLine();
            switch (command) {
                case "type":
                    System.out.println("Enter text:");
                    editor.type(scanner.nextLine());
                    break;
                case "undo":
                    editor.undo();
                    break;
                case "redo":
                    editor.redo();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid command");
            }
            System.out.println("Text: " + editor.getText());
        }
    }
}
```

This console application will prompt the user to enter a command. The user can type "type" to add text, "undo" to undo the last operation, "redo" to redo the last operation, or "exit" to exit the application. The current text is displayed after each operation.