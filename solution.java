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
}