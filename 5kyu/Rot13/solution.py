def rot13(message):
    alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m',
                     'n','o','p','q','r','s','t','u','v','w','x','y','z']
    upperAlphabet = toUpper(alphabet)
    resultMessage = ""
    for character in message:
        if character in alphabet:
            index = (alphabet.index(character) + 13 )%len(alphabet)
            resultMessage += alphabet[index]
        elif character in upperAlphabet:
            index = (upperAlphabet.index(character) + 13 )%len(upperAlphabet)
            resultMessage += upperAlphabet[index]
        else:
            resultMessage += character
            
    return resultMessage            

def toUpper(lst):
    alphabet = []
    for character in lst:
        alphabet.append(character.upper())
    return alphabet