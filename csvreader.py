import csv
def reader(filename):
    myReader = []
    i = 0
    with open (filename, newline = '') as csvfile:
        linereader = csv.reader(csvfile, delimiter = ' ', quotechar = '|')
        while i < 20:
            for row in linereader:
                a = ', '.join(row)
                myReader.append(a)
            i += 1
    return(myReader[1:])
            

def readInDick(filename):
    Dick = dict()
    myList = reader(filename)
    for i in myList:
        Dick[i[0:11]] = i[13:]
    return (Dick)
