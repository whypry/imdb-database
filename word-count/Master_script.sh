#!/bin/bash
### Master file
## usage: master.sh filename
## Assign variable: filename, current folder, subfile size
HERE=`pwd`
SIZE=1000000
TBD=TBD
PF=temp_
echo I made it here
## if there is no file to process, exit
if [ "$#" -ne 1 ]
then
    echo "You have to assign a big-size file !!"
    exit
fi


FN=$1
## create a temp folder
# if [ -d $TBD ]; then
#     rm -rf $TBD
# fi
# mkdir -p $TBD
# ## split the file into the temp folder
# split  -l $SIZE $FN $TBD/$PF
# echo I made it here


for i in `ls $TBD/$PF*`
do 
java op1avg $i &
done

wait
# merge all the out files in temp folder
cat $TBD/$PF*.out > $TBD/temp_all
timestamp=$(date +%s)

# analyze the out file
java op2avg $TBD/temp_all > $HERE/out-$timestamp
# remove the temp folder
#rm -rf $TBD
