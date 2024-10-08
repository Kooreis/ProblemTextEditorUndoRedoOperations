```C#
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
```