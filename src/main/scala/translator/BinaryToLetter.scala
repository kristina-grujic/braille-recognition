package translator

import collection.mutable.HashMap

class BinaryToLetter() {
  val map = new HashMap[Int, String]()
  map += (
    1 -> "a", // binary key for Array(1,0,0,0,0,0)
    5 -> "b", // Array(1,0,1,0,0,0)
    3 -> "c", // Array(1,1,0,0,0,0)
    11 -> "d", // Array(1,1,0,1,0,0)
    9 -> "e", // Array(1,0,0,1,0,0)
    7 -> "f", // Array(1,1,1,0,0,0)
    15 -> "g", // Array(1,1,1,1,0,0)
    13 -> "h", // Array(1,0,1,1,0,0)
    6 -> "i", // Array(0,1,1,0,0,0)
    14 -> "j", // Array(0,1,1,1,0,0)
    17 -> "k", // Array(1,0,0,0,1,0)
    21 -> "l", // Array(1,0,1,0,1,0)
    19 -> "m", // Array(1,1,0,0,1,0)
    27 -> "n", // Array(1,1,0,1,1,0)
    25 -> "o", // Array(1,0,0,1,1,0)
    23 -> "p", // Array(1,1,1,0,1,0)
    31 -> "q", // Array(1,1,1,1,1,0)
    29 -> "r", // Array(1,0,1,1,1,0)
    22 -> "s", // Array(0,1,1,0,1,0)
    30 -> "t", // Array(0,1,1,1,1,0)
    49 -> "u", // Array(1,0,0,0,1,1)
    53 -> "v", // Array(1,0,1,0,1,1)
    46 -> "w", // Array(0,1,1,1,0,1)
    51 -> "x", // Array(1,1,0,0,1,1)
    59 -> "y", // Array(1,1,0,1,1,1)
    57 -> "z" // Array(1,0,0,1,1,1)
  )
  
  def getLetter(binary: Array[Int]) : String = {
    var key = 0;
    for ((element, index) <- binary.zipWithIndex) {
      key += (element * scala.math.pow(2,index).toInt);
    }
    return map.getOrElse(key, "none");
  }
}