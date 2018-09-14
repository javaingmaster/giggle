package script.db

databaseChangeLog(logicalFilePath: 'report_video.groovy'){
    changeSet(id: '2018-09-14-report_video', author: 'zty'){
        createTable(tableName: "giggle_report_video"){
            column(name: 'report_video_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'user_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'video_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'report_video_time', type: 'DATE'){

            }

        }
    }
}