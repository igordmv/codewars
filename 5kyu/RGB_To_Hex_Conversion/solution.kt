fun rgb(r: Int, g: Int, b: Int): String {
    var red = r
    var green = g
    var blue = b
    var resultHexa = ""
    if(red<0) red = 0
    if(green<0) green = 0
    if(blue<0) blue = 0
    
    if(red>255) red = 255
    if(green>255) green = 255
    if(blue>255) blue = 255
    
    var rHex = Integer.toHexString(red)
    if (rHex.length == 1 ) rHex = "0$rHex"
    
    var gHex = Integer.toHexString(green)
    if (gHex.length == 1) gHex = "0$gHex"
    
    var bHex = Integer.toHexString(blue)
    if (bHex.length == 1) bHex = "0$bHex"
    
    resultHexa += rHex + gHex + bHex
    return resultHexa.uppercase()
}