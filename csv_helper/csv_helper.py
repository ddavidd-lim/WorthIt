import csv
import pandas as pd
import csv_gui

filename = 'businessCard.csv'

def csv_editor(window):
    # Take input from user and update the CSV to include one of the following tags
    buttons = ["O", "B-FOOD", "I-FOOD", "B-CALORIES", "I-CALORIES", "B-PRICE", "I-PRICE"]

    df = pd.read_csv(filename, encoding='ansi')


    for index, rows in df.iterrows():
        window['output_text'].update(f"Line {index+2}:\n{df.iloc[index]}")
        tag_index = csv_gui.buttonInput(window)
        if tag_index == "exit":
            break
        df.at[index, 'tag'] = buttons[tag_index]
        df.to_csv(filename, index=False, encoding='utf-8')

def run():
    window = csv_gui.create_window()
    csv_editor(window)
    csv_gui.close_window(window)

# def reset():
#     df = pd.read_csv(filename, encoding='ansi')

#     for index, rows in df.iterrows():
#         df.at[index, 'tag'] = 'XX'

#     df.to_csv(filename, index=False, encoding='utf-8')


if __name__ == '__main__':
    run()