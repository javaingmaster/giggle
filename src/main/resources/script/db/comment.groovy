package script.db

databaseChangeLog(logicalFilePath: 'comment.groovy'){
    changeSet(id: '2018-09-13-comment', author: 'zty'){
        createTable(tableName: "giggle_comment"){
            column(name: 'comment_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'user_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'video_id', type: 'BIGINT UNSIGNED'){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'comment_content', type: 'VARCHAR(200)'){
                constraints(nullable: false)
            }
            column(name: 'comment_time', type: 'DATE'){
                constraints(nullable: false)
            }
            column(name: 'comment_parent', type: 'BIGINT UNSIGNED',defaultValue: 0){}
            column(name: 'comment_child', type: 'BIGINT UNSIGNED',defaultValue: 0){}
        }
    }
}