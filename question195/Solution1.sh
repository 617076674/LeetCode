cnt=0
while read line && [ $cnt -le 10 ] 
do
  let cnt++
  if [ $cnt -eq 10 ] 
  then
    echo $line
    exit 0
  fi
done < file.txt