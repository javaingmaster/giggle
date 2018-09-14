package script.db

databaseChangeLog(logicalFilePath: 'history.groovy'){
    changeSet(id: '2018-09-14-history', author: 'zty'){
        createTable(tableName: "giggle_history"){
            column(name: 'history_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'user_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'video_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'watch_time', type: 'DATE'){

            }
            column(name: 'is_collection', type: 'TINYINT'){

            }
        }
    }
}