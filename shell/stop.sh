#!/bin/bash

pid=`ps -ef |grep $NAME |grep -v "grep" |awk '{print $2}'`


if [ $pid ]; then

​    echo "$NAME 运行在 pid=$pid"

​    kill -9 $pid

​    if [[ $? -eq 0 ]]; then

​       echo "$NAME 服务已经关闭 "

​    else

​       echo "f$NAME 服务关闭失败 "

​     fi

fi