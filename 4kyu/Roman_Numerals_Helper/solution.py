class RomanNumerals:
    romanDict = { "I" : 1, "V" : 5, "X" : 10, "L" : 50, "C" : 100, "D" : 500, "M" : 1000 }
    
    @classmethod
    def to_roman(self, val): 
        resultString = ""

        mCount = int(val / RomanNumerals.romanDict["M"])
        for i in range(0,mCount):
            resultString += "M"
        val = val % RomanNumerals.romanDict["M"]

        val, resultString = RomanNumerals.to_roman_helper(val, 900, "CM", "D", resultString)
        val, resultString = RomanNumerals.to_roman_helper(val, 400, "CD", "C", resultString)
        val, resultString = RomanNumerals.to_roman_helper(val, 90, "XC", "L", resultString)
        val, resultString = RomanNumerals.to_roman_helper(val, 40, "XL", "X", resultString)
        val, resultString = RomanNumerals.to_roman_helper(val, 9, "IX", "V", resultString)
        val, resultString = RomanNumerals.to_roman_helper(val, 4, "IV", "I", resultString)
        
        return resultString
    
    @classmethod
    def from_roman(self, roman_num):
        result = 0
        willReduce = False
        for i in range(0, len(roman_num)):
            if i + 1 < len(roman_num):
                if willReduce:
                    willReduce = False
                else:
                    first = roman_num[i]
                    second = roman_num[i + 1]
                    if RomanNumerals.romanDict[first] < RomanNumerals.romanDict[second]:
                        willReduce = True
                        result += (RomanNumerals.romanDict[second] - RomanNumerals.romanDict[first])
                    else:
                        willReduce = False
                        result += RomanNumerals.romanDict[first]

            elif willReduce == False: 
                result += RomanNumerals.romanDict[roman_num[i]]
        return result
        
    @classmethod
    def to_roman_helper(self, val, checkValue, checkValueReducer, step, resultString):
        if val >= checkValue:
            resultString += checkValueReducer
            val = val % checkValue
        else:
            vCount = int(val / RomanNumerals.romanDict[step])
            for i in range(0,vCount):
                resultString += step
            val = val % RomanNumerals.romanDict[step]
        return val, resultString
    
print(RomanNumerals.to_roman(1990))
print(RomanNumerals.to_roman(1999))
print(RomanNumerals.to_roman(1899))
print(RomanNumerals.to_roman(1449))
print(RomanNumerals.to_roman(1444))
print(RomanNumerals.to_roman(1333))
print(RomanNumerals.to_roman(3333))
print(RomanNumerals.to_roman(3999))
print(RomanNumerals.to_roman(1440))

print(RomanNumerals.from_roman(RomanNumerals.to_roman(1990)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(1999)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(1899)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(1449)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(1444)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(1333)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(3333)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(3999)))
print(RomanNumerals.from_roman(RomanNumerals.to_roman(1440)))