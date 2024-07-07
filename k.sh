if [ "$1" = "1" ]
then
    rm temp_for_kotlin.txt
    exit 0
fi

files=$(find . -name "*.kt")

i=0

for x in $files; do
    echo "$(( $i + 1 ))) " " $x"
    i=$(( $i + 1 ))
done

num=-1
read num
if [ "$num" = "" ]
then
    file=$(<temp_for_kotlin.txt)
    
else
    file=""
    i=0
    for x in $files; 
    do
        if [ $(( $i + 1 )) -eq $num ]
        then
            file=$x
        fi
        i=$(( $i + 1 ))
    done
fi

echo "$file" > temp_for_kotlin.txt
echo "kotlin не си ждём компиляцию..."
kotlinc "$file" -include-runtime -d go.jar
echo "ГОТОВО"
java -jar go.jar
find . -name "*.jar" -delete
