###URLify : Replace spaces in a string with %20

def urlify(string):
    return string.replace(' ','%20')

def Main():
    string = raw_input("Enter String \n")
    url = urlify(string)
    print "URL String : ", url

if __name__ == '__main__':
    Main()