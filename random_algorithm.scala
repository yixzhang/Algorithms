def random1(array: Array[Int]){
  val n  = array.length
  val priorityArray = (for(i <- 0 to n - 1) yield  (scala.math.random*n*n*n).toInt -1  ).toArray
  println("[" + priorityArray.mkString(", ") + "]")
  insert_sort_array_by_priority_array(array, priorityArray)
}

def random2(array: Array[Int]){
	val n = array.length
	for(i <- 0 to n - 1){
		val swap_index = (scala.math.random * (n - i)).toInt + i
		if(i != swap_index){
			val v = array(i)
			array(i) = array(swap_index)
			array(swap_index) = v
		}
	}
}

def insert_sort_array_by_priority_array(array: Array[Int], priorityArray: Array[Int]){
  if(array.length >= 1){
    for(index <- 0 to array.length -1){
      val pValue = priorityArray(index)
      val value = array(index)
      var pre = index - 1
      while( pre >= 0 && priorityArray(pre) > pValue){
        array(pre + 1) = array(pre)
        pre = pre -1
      }
      array(pre+1) = value
    }
  }
}

def print_array_transform(array: Array[Int])(transform: Array[Int] => Unit){
	println("Original array is [" + array.mkString(", ") + "]")
	transform(array)
	println("Sorted array is [" + array.mkString(", ") + "]")
}

val array = Array(1,2,3,4,5,6,7)
print_array_transform(array){ array => random1(array)}
print_array_transform(array){ array => random2(array)}
