def scramble(s1, s2):
    dictS2 = {}
    for char in set(s2):
        dictS2[char] = {"count": s2.count(char), "enought": False }
    for char in s1:
        if char in dictS2.keys():
            s1Count = s1.count(char)
            object = dictS2[char]
            if object["count"] > s1Count:
                return False
            else:
                object["enought"] = True
                alreadyAchieved = True
                for value in dictS2.values():
                    if value["enought"] == False:
                        alreadyAchieved = False
                        break
                if alreadyAchieved == True:
                    return True
    return False