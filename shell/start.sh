\#!/bin/bash


pid=`ps -ef |grep $NAME |grep -v "grep" |awk '{print $2}'`

if [ $pid ]; then

​    echo "$NAME  is  running  and pid=$pid"

else

   echo "Start success to start $NAME-$VERSION.jar ..."

   java -jar $NAME-$VERSION.jar &

fi