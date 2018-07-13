export escapedQuery=$(sed -e 's:":\\\\":g' initsql.txt)
#echo EscapedQuery is $escapedQuery 
#sed "s/\$MYQUERY/$escapedQuery/" patch.txt
eval $(sed -e "s/\$MYQUERY/$escapedQuery/" patch.txt)

