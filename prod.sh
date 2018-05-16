#!/bin/sh

export JAVA_HOME=/usr/lib/jvm/java-8-oracle
mvn clean package
scp target/payment-reminder.war $PAYMENT_REMINDER_PROD
ssh $PAYMENT_REMINDER_SSH 'sudo ./install.sh'

