

import tkinter as tk

# Function to perform calculations
def evaluate_expression():
    try:
        result.set(str(eval(entry.get()))
    except:
        result.set("Error")

# Create the main application window
app = tk.Tk()
app.title("Simple Calculator")

# Create and configure the Entry widget for user input
entry = tk.Entry(app, font=('Arial', 20), bd=10, insertwidth=4, width=14, justify='right')
entry.grid(row=0, column=0, columnspan=4)

# Create a StringVar to store the result
result = tk.StringVar()

# Create and configure the Label widget to display the result
result_label = tk.Label(app, textvariable=result, font=('Arial', 20), bd=10, width=14, anchor='e')
result_label.grid(row=1, column=0, columnspan=4)

# Create buttons for digits and operations
buttons = [
    '7', '8', '9', '/',
    '4', '5', '6', '*',
    '1', '2', '3', '-',
    '0', '.', '=', '+'
]

# Function to add a character to the input
def add_character(char):
    current = entry.get()
    entry.delete(0, tk.END)
    entry.insert(0, current + str(char))

# Create and configure the buttons
row_val = 2
col_val = 0
for button in buttons:
    tk.Button(app, text=button, padx=20, pady=20, font=('Arial', 20), command=lambda b=button: add_character(b)).grid(row=row_val, column=col_val)
    col_val += 1
    if col_val > 3:
        col_val = 0
        row_val += 1

# Create and configure the clear button
def clear():
    entry.delete(0, tk.END)

tk.Button(app, text="C", padx=20, pady=20, font=('Arial', 20), command=clear).grid(row=row_val, column=col_val)

# Create and configure the equals button
tk.Button(app, text="=", padx=20, pady=20, font=('Arial', 20), command=evaluate_expression).grid(row=row_val, column=col_val)

# Start the main loop
app.mainloop()

