#!/bin/bash
mkdir -p bin
if [ ! -f bin/tool-liquibase.jar ]
then
    curl https://oss.sonatype.org/content/groups/public/io/choerodon/choerodon-tool-liquibase/0.5.2.RELEASE/choerodon-tool-liquibase-0.5.2.RELEASE.jar -o ./bin/tool-liquibase.jar
fi
java -Dspring.datasource.url="jdbc:mysql://192.168.99.100:3306/giggle?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=root \
 -Ddata.drop=false -Ddata.init=true \
 -Ddata.dir=./src/main/resources/script \
 -jar ./bin/tool-liquibase.jar