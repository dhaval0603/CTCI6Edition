###Checks if the string has unique characters

import re as regex

#Check for uniqueness
def isUnique(string):
    chars = []
    for char in string:
        if char in chars:
            return "Not Unique"
        chars.append(char)
    return "Unique"

#Strip all the spaces and check for uniqueness
def isUniqueIgnoreSpaces(string):
    chars = []
    newString = string.replace(" ","")
    for char in newString:
        if char in chars:
            return "Not Unique"
        chars.append(char)
    return "Unique"

#Strip all the special chars and check for uniqueness
def isUniqueIgnoreSpecial(string):
    chars = []

    newString = regex.sub('[^A-Za-z0-9 ]','',string)
    print newString

    for char in newString:
        if char in chars:
            return "Not Unique"
        chars.append(char)
    return "Unique"

def Main():
    userString = raw_input("Please enter the string\n")
    print "Is unique without ignoring - " + isUnique(userString)
    print "Is unique ignoring only spaces - " + isUniqueIgnoreSpaces(userString)
    print "Is unique ignoring only special characters - " + isUniqueIgnoreSpecial(userString)

if __name__== "__main__":
    Main()