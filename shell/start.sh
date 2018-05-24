#!/bin/bash

pid=`ps -ef |grep $NAME |grep -v "grep" |awk '{print $2}'`

if [ $pid ]; then

​    echo "$NAME 服务运行在 pid=$pid"

else

   echo "正在开启 $NAME-$VERSION.jar 中"

   java -jar /opt/$NAME-$VERSION.jar &

fi