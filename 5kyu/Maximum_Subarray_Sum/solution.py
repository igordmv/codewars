def max_sequence(arr):
    if arr == []:
        return 0
    elif haveOnlyNegativeNumbers(arr):
        return 0
    elif haveOnlyPositiveNumbers(arr):
        return sum(arr)
    else:
        max = 0
        for i in range(0, len(arr)):
            actual = getMaxSumForIndex(arr, i)
            if actual > max:
                max = actual
        return max
    
def getMaxSumForIndex(arr, index):
    sum = 0
    max = 0
    for i in range(index, len(arr)):
        if i + 1 < len(arr):
            print(str(arr[i]) + " " + str(arr[i+1]) + " " )
            if sum == 0:
                sum = arr[i] + arr[i+1]
            else:
                sum += arr[i+1]
                
            if sum > max:
                max = sum
        else:
             break
    return max

def haveOnlyPositiveNumbers(arr):
    for integer in arr:
        if integer < 0:
            return False
    return True
    
def haveOnlyNegativeNumbers(arr):
    for integer in arr:
        if integer > 0:
            return False
    return True