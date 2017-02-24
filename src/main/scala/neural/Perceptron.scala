package neural

import scala.math._

class Perceptron(val inputs: Array[Array[Int]]) {
  var i = inputs;
  var o = Array(0);
  
  var cell1 = Array.ofDim[Int](16,14);
  var cell2 = Array.ofDim[Int](16,14);
  var cell3 = Array.ofDim[Int](16,14);
  var cell4 = Array.ofDim[Int](16,14);
  var cell5 = Array.ofDim[Int](16,14);
  var cell6 = Array.ofDim[Int](16,14);
  
  for (k <- 0 to 31) {
    for (j <- 0 to 41) {
      if (k<16 && j<14) {
        cell1(k)(j) = i(k)(j);
      } else if (k<16 && j<28) {
        cell3(k)(j-14) = i(k)(j);
      } else if (k<16) {
        cell5(k)(j-28) = i(k)(j);
      } else if (j<14) {
        cell2(k-16)(j) = i(k)(j);
      } else if (j<28) {
        cell4(k-16)(j-14) = i(k)(j);
      } else {
        cell6(k-16)(j-28) = i(k)(j);
      }
    }
  }
  
  
  def backPropagation() = {
    println("back");
  }
  
  def frontPropagation() : Array[Int] = {
    
    cell1 = multiplicator(cell1);
    cell2 = multiplicator(cell2);
    cell3 = multiplicator(cell3);
    cell4 = multiplicator(cell4);
    cell5 = multiplicator(cell5);
    cell6 = multiplicator(cell6);
    
    
    var result = sum(Array(cell1, cell2, cell3, cell4, cell5, cell6));
    result = sigmoid(result);

    return result;
  }
  
  private def sigmoid(x: Array[Int]): Array[Int] = {
    val result = Array.ofDim[Int](6);
    for (i <- 0 to 5) {
      if (x(i) < 5) {
        result(i) = 0
      } else {
        result(i) = 1;
      }
    }
    return result;
  }
  
  private def multiplicator(array: Array[Array[Int]]) : Array[Array[Int]] = {
    val result = array.map(value => multiplicate(value));
    return result
  }
  
  private def multiplicate(array: Array[Int]) : Array[Int] = {
    val result = array.map(value => value*1);
    return result;
  }
  
  private def sum(array: Array[Array[Array[Int]]]) : Array[Int] = {
    var result = Array.ofDim[Int](6);
    
    for (i <- 0 to 5) {
      for (j <- 0 to 14) {
        result(i) += array(i)(j).sum;
      }
    }
    return result;
  }
  
}