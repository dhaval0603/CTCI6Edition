###Checks if two strings are permutations of each other

def isPermutation(string1,string2):
    #Check for length of the two strings
    if len(string1) != len(string2):
        return "Strings are not permutations of each other"
    else:
        chars = {}

        #If lengths match, count occurences of characters in first string
        for char in string1:
            if char in chars:
                chars[char] += 1
            else:
                chars[char] = 1

        #For second string, reduce the character count by 1 for every occurence
        #If character does not exist, Strings are not permutations
        for char in string2:
            if char in chars:
                chars[char] -= 1
            else:
                return "Strings are not permutations of each other"

        for char in chars:
            if chars[char] != 0:
                return "Strings are not permutations of each other"

        return "Permutations"


def Main():
    string1 = raw_input("Enter 1st String \n")
    string2 = raw_input("Enter 2st String \n")

    print isPermutation(string1,string2)

if __name__ == '__main__':
    Main()