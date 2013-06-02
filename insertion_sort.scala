def insertion_sort[T <: Int](array : Array[T]){
	if(array.length <= 1)
		return
	//start from the second element of the array
	for(insert_index <- 1 to array.length - 1){
		val insert_num = array(insert_index)
		var i = insert_index - 1
		//move the element right if it's smaller than the insert element
		while(i >= 0 && array(i) > insert_num){
			array(i+1) = array(i)
			i = i -1
		}
		array(i+1) = insert_num
	}
}

def print_sort_result[T <: Int](array: Array[T])(sort: Array[T] => Unit){
	println("Original array is [" + array.mkString(", ") + "]")
	sort(array)
	println("Sorted array is [" + array.mkString(", ") + "]")
}

val normal_case = Array(1, 0, 11, 2, -1, 100, 99, 23, 101, 56, -10, 7)
print_sort_result(normal_case){ normal_case => insertion_sort(normal_case)}

val one_element = Array(1)
print_sort_result(one_element){ one_element => insertion_sort(one_element)}


