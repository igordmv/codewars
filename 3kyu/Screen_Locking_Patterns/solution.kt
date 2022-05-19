package solution

data class Point(
    var name : String,
    var canAccess : MutableList<String>
)

fun solver(currentPoint: String,
          length: Int,
          currentLength: Int,
          accessedList: MutableList<String>,
          counter: MutableList<String>) {
    
    val screenLockingPoints = listOf(
        Point("A", mutableListOf("B","E","F","H","D")),
        Point("B", mutableListOf("C","A","D","E","F","G","I")),
        Point("C", mutableListOf("B","D","E","F","H")),
        Point("D", mutableListOf("A","B","C","E","G","H","I")),
        Point("E", mutableListOf("A","B","C","D","F","G","H","I")),
        Point("F", mutableListOf("A","B","C","E","G","H","I")),
        Point("G", mutableListOf("B","D","E","F","H")),
        Point("H", mutableListOf("A","C","D","E","F","G","I")),
        Point("I", mutableListOf("B","D","E","F","H"))
    )

    if(accessedList.contains("B")) {             
       val pointA = screenLockingPoints.find { it.name == "A" }
       pointA!!.canAccess.add("C")
       val pointC = screenLockingPoints.find { it.name == "C" }
       pointC!!.canAccess.add("A")
    }         
    if(accessedList.contains("D")) {             
        val pointA = screenLockingPoints.find { it.name == "A" }
        pointA!!.canAccess.add("G")
        val pointG = screenLockingPoints.find { it.name == "G" }
        pointG!!.canAccess.add("A")
    }
    
    if(accessedList.contains("E")) {             
        val pointA = screenLockingPoints.find { it.name == "A" }
        pointA!!.canAccess.add("I")
        val pointI = screenLockingPoints.find { it.name == "I" }
        pointI!!.canAccess.add("A")
            
        val pointB = screenLockingPoints.find { it.name == "B" }
        pointB!!.canAccess.add("H")
        val pointH = screenLockingPoints.find { it.name == "H" }
        pointH!!.canAccess.add("B")
        
            
        val pointC = screenLockingPoints.find { it.name == "C" }
        pointC!!.canAccess.add("G")
        val pointG = screenLockingPoints.find { it.name == "G" }
        pointG!!.canAccess.add("C")
        
        
        val pointD = screenLockingPoints.find { it.name == "D" }
        pointD!!.canAccess.add("F")
        val pointF = screenLockingPoints.find { it.name == "F" }
        pointF!!.canAccess.add("D")
        
    }
    
    if(accessedList.contains("F")) {             
        val pointC = screenLockingPoints.find { it.name == "C" }
        pointC!!.canAccess.add("I")
        val pointI = screenLockingPoints.find { it.name == "I" }
        pointI!!.canAccess.add("C")
        
    }
    
    if(accessedList.contains("H")) {             
        val pointG = screenLockingPoints.find { it.name == "G" }
        pointG!!.canAccess.add("I")
        val pointI = screenLockingPoints.find { it.name == "I" }
        pointI!!.canAccess.add("G")
        
    }
            
    if(length == currentLength) {
        counter.add("0")
        return
    } else {
        val point = screenLockingPoints.find { it.name == currentPoint }

        point!!.canAccess.forEach { newPoint ->
            if(accessedList.contains(newPoint).not()) {
                val newList = mutableListOf<String>(newPoint)
                accessedList.forEach {
                    newList.add(it)
                }
                solver(newPoint, length, currentLength + 1, newList, counter)
            }
        }
    }
}

fun countPatternsFrom(firstPoint: String, length: Int): Int {
    if(length < 1 || length > 9) return 0
    
    var counter = mutableListOf<String>()
    solver(firstPoint, length, 1, mutableListOf(firstPoint), counter)
    return counter.size
}