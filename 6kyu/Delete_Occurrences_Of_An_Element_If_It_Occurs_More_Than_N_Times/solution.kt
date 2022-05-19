object EnoughIsEnough {
  fun deleteNth(elements:IntArray, maxOcurrences:Int):IntArray {
        val newList = mutableListOf<Int>()
        val ocurrenceMap = hashMapOf<Int,Int>()
        if(elements.size == 0 || maxOcurrences == 0) return intArrayOf()
        for (index in elements.indices) {
            val element = elements.get(index)
            val numberOfOcurrences = ocurrenceMap.get(element)?: 1
            if(!ocurrenceMap.contains(element)) {
                ocurrenceMap.put(element, 1)
                newList.add(element)
            } else if(numberOfOcurrences < maxOcurrences) {
                ocurrenceMap.put(element, numberOfOcurrences + 1)
                newList.add(element)
            }
        }
      
    return newList.toIntArray();
  }
}