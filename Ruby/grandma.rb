#def geandma she does not respond unles you tybe what yuou say in all caps
say=''
while say != 'BYE'
say=gets.chomp.to_s
if say != say.upcase
  puts 'HUH?! SPEAK UP SONNY!'
end

if say == say.upcase && say != 'BYE'
  puts 'NOT SINCE ' + (rand(20) + 1930).to_s
end
if say == 'BYE'
  puts 'GOODBYE'
end
end