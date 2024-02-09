Dir.chdir 'C:\Users\Danny\Desktop'
file_names = Dir['C:\Users\Danny\Downloads.{png,PNG,jpg,JPG}']
puts 'what wuld you like to name this batch'
batch_name = gets.chomp
puts
print "moveing #{file_names.length} files: "
file_number = 1
file_names.each do |name|
 print '.'
 new_name = if pic_number < 10
  "#{batch_name}0#{pic_number}"
 else
  "#{batch_name}#{pic_number}"
end
file.rename name, new_name
file_number = file_number + 1
end
puts
puts 'done!'