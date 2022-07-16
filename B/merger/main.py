with open("TEP.en-fa.en", "r") as en:
    english = en.read().splitlines()

with open("TEP.en-fa.fa", "r") as fa:
    farsi = fa.read().splitlines()


def create_en2fa_dataset():
    merged = []
    for index, en_line in enumerate(english):
        merged_line = en_line[:-2] + ' -> ' + farsi[index][:-2]
        merged.append(merged_line)

    file = open("en_fa.txt", "w")
    for line in merged:
        file.write(line + '\n')
    file.close()


def create_fa2en_dataset():
    merged = []
    for index, fa_line in enumerate(farsi):
        merged_line = fa_line[:-2] + ' -> ' + english[index][:-2]
        merged.append(merged_line)

    file = open("fa_en.txt", "w")
    for line in merged:
        file.write(line + '\n')
    file.close()


create_fa2en_dataset()
create_en2fa_dataset()
