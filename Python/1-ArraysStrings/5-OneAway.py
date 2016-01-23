###Check if two string are one/zero edits away from each other.
###Insert/Replace/Delete is allowed as an edit


def isOneAway(string1,string2):
    maxlength = len(string1) if len(string1)>len(string2) else len(string2)

    #Max difference in length allowed for One Away is 1. If more than one difference, there are multiple edits
    if abs(len(string1) - len(string2)) > 1:
        return False
    else:
        return isEdit(string1,string2)

def isEdit(string1,string2):
    difference = False
    index1 = 0
    index2 = 0
    while(index1 < len(string1) and index2 < len(string2)):
        #If difference found, increment the pointer of the larger string. (To account for Insert/Delete
        #If strings of same length, increment both pointers. (To account for Replace)
        if string1[index1] != string2[index2]:
            #If difference is already found, this is the second edit. Exit
            if difference:
                return False
            difference=True

            if len(string1) > len(string2):
                index1+=1
            elif len(string1) < len(string2):
                index2+=1
            else:
                index1+=1
                index2+=1
        else:
            index1+=1
            index2+=1
    return True

def Main():
    string1 = raw_input("Enter 1st String \n")
    string2 = raw_input("Enter 2nd String \n")
    print isOneAway(string1,string2)

if __name__ == '__main__':
    Main()