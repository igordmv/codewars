fun inArray(array1: Array<String>, array2: Array<String>): Array<String> {
    val hashMap = hashMapOf<String, Int>()
    for(stringAtArray1 in array1) {
        for(stringAtArray2 in array2) {
          if(stringAtArray2.contains(stringAtArray1)) {
                hashMap.put(stringAtArray1, 1)
                break
            }  
        }
    }
    val result = hashMap.keys.toMutableList()
    result.sort()
    return result.toTypedArray()
}