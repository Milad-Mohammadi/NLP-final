with open("TEP.en-fa.en", "r") as en:
    english = en.read().splitlines()

with open("TEP.en-fa.fa", "r") as fa:
    farsi = fa.read().splitlines()

merged = []
for index, en_line in enumerate(english):
    merged_line = en_line + farsi[index]
    merged.append(merged_line)

file = open("en_fa.txt", "w")
for line in merged:
    file.write(line + '\n')
file.close()