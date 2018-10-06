import csv
def reader(filename):
    myReader = []
    i = -1
    with open (filename, newline = '') as csvfile:
        linereader = csv.reader(csvfile, delimiter = ' ', quotechar = '|')
        while i < 5:
            i += 1
            for row in linereader:
                a = ', '.join(row)
                myReader.append(a.split(","))
    return(myReader[1:])
#    myReader = []
#    i = -1
#    with open (filename, newline = '') as csvfile:
#        linereader = csv.reader(csvfile, delimiter = ' ', quotechar = '|')
#        while i < 5:
#            i += 1
#            for row in linereader:
#                a = ', '.join(row)
#                myReader.append(a.split(",")
#    return(myReader[1:])

def readInDick(filename):
    Dick = dict()
    myList = reader(filename)
    for i in myList:
        string = ''.join(i[1:])
        Dick[i[0]] = string
    return (Dick)
