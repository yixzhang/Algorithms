def insertion_sort array
  if not array.is_a?(Array) or array.length <= 1
    return
  end
  
  (1..array.length-1).each do |insert_index|
    insert_elem = array[insert_index]
    i = insert_index -1
    while i >= 0 and array[i] > insert_elem
      array[i+1] = array[i]
      i = i -1
    end
    array[i+1] = insert_elem
  end
end

def print_sort(array)
  puts 'Original array is ' + array.to_s
  yield array
  puts 'Sorted array is ' + array.to_s
end

normal_case = [1, 0, 11, 2, -1, 100, 99, 23, 101, 56, -10, 7]
print_sort(normal_case){|array| insertion_sort array}

one_elem = [1]
print_sort(one_elem){|array| insertion_sort array}

no_elem = []
print_sort(no_elem){|array| insertion_sort array}
