import PySimpleGUI as sg

buttons = ["O", "B-FOOD", "I-FOOD", "B-CALORIES", "I-CALORIES", "B-PRICE", "I-PRICE"]
def create_window():
    layout = [[sg.Text("LINE 0", key="output_text")],
              [sg.Button(f'{buttons[i]}') for i in range(len(buttons))],
              [sg.Button('Exit')]]

    window = sg.Window('Button Window', layout, finalize=True)

    return window


def buttonSearch(name):
    for n in range(len(buttons)):
        if buttons[n] == name:
            return n

# Change the number of buttons as needed
def buttonInput(window):
    while True:
        event, values = window.read()

        if event == sg.WIN_CLOSED or event == 'Exit':
            return "exit"
        elif event.startswith('Button'):
            button_number = int(buttonSearch(event.split()[-1]))
            return button_number

def close_window(window):
    window.close()
    
if __name__ == "__main__":
    window = create_window()
    buttonInput(window)
    close_window(window)