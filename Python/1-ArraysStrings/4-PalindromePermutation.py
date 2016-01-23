###Return if one string is a permutation of a palindrome

#Calculate occurences of characters in string (should be even)
#If string length is odd, atmost one character can have count=1 (center of the palindrome)
def permPalindrome(string):

    #Strip spaces and convert to lowercase
    string = string.replace(" ","").lower()

    #Calculate occurences of characters
    chars = {}
    for char in string:
        if char in chars:
            chars[char] += 1
        else:
            chars[char] = 1

    #Count odd counts
    oddNumbers = 0
    for char in chars:
        if chars[char] % 2 != 0:
            oddNumbers += 1

    #More than one characters have odd counts
    if (len(string)%2 == 1 and oddNumbers > 1) or (len(string)%2 == 0 and oddNumbers > 0):
        return False

    return True

def Main():
    string = raw_input("Enter String \n")
    print permPalindrome(string)

if __name__ == '__main__':
    Main()