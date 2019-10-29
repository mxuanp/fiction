#!/bin/bash

#安装需要的环境

apt-get install update
apt-get install upgrade -y

#install mysql
wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.14-1_all.deb
dpkg -i mysql-apt-config_0.8.14-1_all.deb
apt-get install update
apt-get install upgrade -y
apt-get install mysql-server


apt-get install python3-pip

pip3 install BeautifulSoup4
pip3 install apscheduler
pip3 install lxml
pip3 install pymysql
pip3 install configparser
pip3 install DBUtils
