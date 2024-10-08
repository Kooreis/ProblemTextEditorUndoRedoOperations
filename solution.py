def insert(self, input_text):
        self.stack.append(self.text)
        self.text += input_text
        self.redo_stack = []