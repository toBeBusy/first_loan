#!/bin/sh

set -e

export host_ip=$(curl --retry 2 --retry-delay 3 'http://rancher-metadata.rancher.internal/2015-12-19/self/host/agent_ip')

java $JAVA_OPTS $REMOTE_DEBUG -Djava.security.egd=file:/dev/./urandom -jar omega.jar
