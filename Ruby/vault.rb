def pin pinnum
if pinnum == 1243
  var=puts 'correct! deposit or withdraw?'
  var
  dorw=gets.chomp.to_s
  if dorw == 'deposit'
  puts 'how much'
  d=gets.chomp.to_s
  puts d + '$ deposited'
end
  if dorw == 'withdraw'
  puts 'how mutch'
  w=gets.chomp.to_s
  puts w + '$ withdrawn'
end
else
if pinnum == 4352
 var=puts 'correct! deposit or withdraw?'
  var
  dorw=gets.chomp.to_s
  if dorw == 'deposit'
  puts 'how much'
  d=gets.chomp.to_s
  puts d + '$ deposited'
end
  if dorw == 'withdraw'
  puts 'how mutch'
  w=gets.chomp.to_s
  puts w + '$ withdrawn'
end
end
end
end




puts 'enter pin'
num=gets.chomp.to_i

pin num
puts '                        <--press enter to continue-->'
gets

