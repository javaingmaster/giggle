package script.db

databaseChangeLog(logicalFilePath: 'report_comment.groovy'){
    changeSet(id: '2018-09-14-report_comment', author: 'zty'){
        createTable(tableName: "giggle_report_comment"){
            column(name: 'report_comment_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'user_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'comment_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'report_comment_time', type: 'DATE'){

            }

        }
    }
}