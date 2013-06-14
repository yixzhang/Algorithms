def find_max_crossing_sub_array(array, low, mid, high)
  left_sum = -1
  sum = 0
  max_left = mid
  (low..mid).reverse_each do |i|
    sum = sum + array[i]
    if sum > left_sum
      left_sum = sum
      max_left = i
    end
  end

  right_sum = -1
  sum = 0
  max_right = mid + 1
  (mid + 1 .. high).each do |j|
    sum = sum + array[j]
    if sum > right_sum
      right_sum = sum
      max_right = j
    end
  end

  return max_left, max_right, left_sum + right_sum
end

def find_max_sub_array(array, low, high)
  if not array.is_a?(Array) or array.length == 1 or low > high
    raise ArgumentError.new("Input is incorrect")
  end
  if low == high
    return low, high, array[low]
  else
    mid = ((low + high)/2).round(0)
    left_low, left_high, left_sum = find_max_sub_array(array, low, mid)
    cross_low, cross_high, cross_sum = find_max_crossing_sub_array(array, low, mid, high)
    right_low, right_high, right_sum = find_max_sub_array(array, mid+1, high)
    if left_sum >= right_sum and left_sum >= cross_sum
      return left_low, left_high, left_sum
    elsif right_sum >= left_sum and right_sum >= cross_sum
      return right_low, right_high, right_sum
    else
      return cross_low, cross_high, cross_sum
    end
  end
end

a = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]
#a = [-3, -2, -7, -9, -1, 6, 3, -2, 5]
low, high, sum = find_max_sub_array(a, 0, a.length-1)
puts low, high, sum