def merge(array, start, half, ending)
  left = array[start .. half]
  right = array[half + 1 .. ending]
  
  i = left.length - 1
  j = right.length - 1
  
  (start..ending).reverse_each do |k|
    if i < 0
      array[k] = right[j]
      j = j - 1
    elsif j < 0
      array[k] = left[i]
      i = i - 1
    elsif left[i] >= right[j]
      array[k] = left[i]
      i = i -1
    else
      array[k] = right[j]
      j = j -1
    end
  end 
end

def merge_sort(array, start, ending)
  if not array.is_a?(Array) or array.length == 1 or start >= ending
    return
  end
  
  half = ((start + ending)/2).round(0)
  
  merge_sort(array, start, half)
  merge_sort(array, half+1, ending)
  merge(array, start, half, ending)
end

a = [1, 0, 11, 2, -1, 100, 99, 23, 101, 56, -10, 7]
merge_sort(a, 0, a.length - 1)
puts a.to_s