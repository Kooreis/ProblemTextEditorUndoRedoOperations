Here is a simple console-based text editor in Python that supports undo and redo operations:

```python
class TextEditor:
    def __init__(self):
        self.text = ""
        self.stack = []
        self.redo_stack = []

    def insert(self, input_text):
        self.stack.append(self.text)
        self.text += input_text
        self.redo_stack = []

    def undo(self):
        if len(self.stack) > 0:
            self.redo_stack.append(self.text)
            self.text = self.stack.pop()

    def redo(self):
        if len(self.redo_stack) > 0:
            self.stack.append(self.text)
            self.text = self.redo_stack.pop()

    def print_text(self):
        print(self.text)


def main():
    editor = TextEditor()
    while True:
        print("\n1. Insert Text")
        print("2. Undo")
        print("3. Redo")
        print("4. Print Text")
        print("5. Exit")
        choice = int(input("Enter your choice: "))
        if choice == 1:
            text = input("Enter text to insert: ")
            editor.insert(text)
        elif choice == 2:
            editor.undo()
        elif choice == 3:
            editor.redo()
        elif choice == 4:
            editor.print_text()
        elif choice == 5:
            break
        else:
            print("Invalid choice. Please try again.")


if __name__ == "__main__":
    main()
```

This program creates a simple text editor that supports undo and redo operations. The text editor uses two stacks to keep track of the changes made to the text. When a new text is inserted, the current state of the text is pushed onto the stack. When undo is called, the current state of the text is pushed onto the redo stack and the previous state of the text is popped from the stack. When redo is called, the current state of the text is pushed back onto the stack and the state of the text before the undo operation is popped from the redo stack.