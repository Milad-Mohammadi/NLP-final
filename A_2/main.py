import csv
import re


def read_file():
    with open("Hamshahri-Corpus.txt", "r") as dataText:
        return dataText.read()


def split_on_empty_lines(s):
    blank_line_regex = '\n{2,}\.'
    return re.split(blank_line_regex, s.strip())


def split_each_element_to_parts(text_parts):
    array = []
    for part in text_parts:
        part_array = part.split("\n")
        cat = re.sub('.Cat|\t', '', part_array[2])
        text = ''.join([str(line) for line in part_array[3:]])
        array.append([cat, text])
    return array


def write_csv(file_name, data):
    csv_data = [["Cat", "Text"]]
    for element in data:
        csv_data.append(element)
    with open(file_name, 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerows(csv_data)


print("Converting...")
dataset = read_file()
txtParts = split_on_empty_lines(dataset)
element_parts = split_each_element_to_parts(txtParts)
write_csv("hamshahri.csv", element_parts)
print("Done.")
