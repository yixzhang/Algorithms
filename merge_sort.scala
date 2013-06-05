def merge(array : Array[Int], start : Int, half : Int, end : Int){
	if(array.length == 1 || start > half || start >= end || half > end) return
	val a1 = array.slice(start, half + 1) :+ Int.MaxValue
	val a2 = array.slice(half + 1, end + 1) :+ Int.MaxValue

	var i = 0
	var j = 0
	for(k <- start to end){
		if(a1(i) <= a2(j)) {
			array(k)  = a1(i); 
			i = i + 1
		}
		else{
			array(k) = a2(j)
			j = j + 1;
		}
	}	
}

def merge_sort(array : Array[Int], start : Int, end : Int){
	if(start >= end) return
	val half = Math.round((start + end) / 2) 
	merge_sort(array, start, half)
	merge_sort(array, half+1, end)
	merge(array, start, half, end)
}


val a = Array(1, 0, 11, 2, -1, 100, 99, 23, 101, 56, -10, 7)
merge_sort(a, 0, a.length-1)
println("Result is [" + a.mkString(", ") + "]")
