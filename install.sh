#!/bin/sh

sudo /opt/tomcat9/bin/catalina.sh stop
sudo rm -rf /opt/tomcat9/webapps/ROOT
sudo cp war/payment-reminder.war /opt/tomcat9/webapps/ROOT.war
sudo /opt/tomcat9/bin/catalina.sh start
