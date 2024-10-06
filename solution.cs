Here is a simple implementation of a text editor that supports undo and redo operations using C#:

```C#
using System;
using System.Collections.Generic;

public class TextEditor
{
    private string text = "";
    private Stack<string> undoStack = new Stack<string>();
    private Stack<string> redoStack = new Stack<string>();

    public void Type(string newText)
    {
        undoStack.Push(text);
        text += newText;
        redoStack.Clear();
    }

    public void Undo()
    {
        if (undoStack.Count > 0)
        {
            redoStack.Push(text);
            text = undoStack.Pop();
        }
    }

    public void Redo()
    {
        if (redoStack.Count > 0)
        {
            undoStack.Push(text);
            text = redoStack.Pop();
        }
    }

    public void Print()
    {
        Console.WriteLine(text);
    }
}

class Program
{
    static void Main(string[] args)
    {
        TextEditor editor = new TextEditor();
        editor.Type("Hello");
        editor.Print(); // prints: Hello
        editor.Type(" World");
        editor.Print(); // prints: Hello World
        editor.Undo();
        editor.Print(); // prints: Hello
        editor.Redo();
        editor.Print(); // prints: Hello World
    }
}
```

This program creates a `TextEditor` class that maintains the current text and two stacks for undo and redo operations. When you type new text, it pushes the current text onto the undo stack and appends the new text. When you undo, it pushes the current text onto the redo stack and pops the last text from the undo stack. When you redo, it does the opposite. The `Print` method prints the current text. The `Main` method demonstrates these operations.