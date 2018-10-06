import csv
def reader(filename):
    with open (filename, newline = '') as csvfile:
        linereader = csv.reader(csvfile, delimeter = ' ', quotechar = '|')
        i = 0
        for row in linereader:
            print(', '.join(row))

