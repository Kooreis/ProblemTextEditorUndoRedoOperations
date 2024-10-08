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