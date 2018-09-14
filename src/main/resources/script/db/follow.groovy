package script.db

databaseChangeLog(logicalFilePath: 'follow.groovy'){
    changeSet(id: '2018-09-14-follow', author: 'zty'){
        createTable(tableName: "giggle_follow"){
            column(name: 'follow_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'user_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false)
            }
            column(name: 'follower_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false)
            }
        }
    }
}