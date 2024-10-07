```C#
using System;
using System.Collections.Generic;

public class TextEditor
{
    private string text = "";
    private Stack<string> undoStack = new Stack<string>();
    private Stack<string> redoStack = new Stack<string>();
}
```