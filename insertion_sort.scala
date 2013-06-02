def insertion_sort(array : Array[Int]){
	for(insert_index <- 1 to array.length - 1){
		val insert_num = array(insert_index)
		var i = insert_index - 1
		while(i >= 0 && array(i) > insert_num){
			array(i+1) = array(i)
			i = i -1
		}
		array(i+1) = insert_num
	}
}

val test = Array(1, 0, 11, 2, -1, 100, 99, 23, 101, 56, -10, 7)
println("Original array is [" + test.mkString(", ") + "]")
insertion_sort(test)
println("Sorted array is [" + test.mkString(", ") + "]")