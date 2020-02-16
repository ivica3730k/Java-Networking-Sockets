if [[ "$*" == *-r* ]]
then
	#find old class files and delete them
	#preventing output to terminal
	find *.class -delete  > /dev/null 2>&1
	echo "Rebuilding all"
fi

find *.java > build.txt
javac @build.txt
rm build.txt
echo "Done"
