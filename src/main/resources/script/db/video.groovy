package script.db

databaseChangeLog(logicalFilePath: 'video.groovy'){
    changeSet(id: '2018-09-16-video', author: 'zty'){
        createTable(tableName: "giggle_video"){
            column(name: 'file_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'file_name', type: 'VARCHAR(20)'){
                constraints(nullable: false)
            }
            column(name: 'file_publisher', type: 'VARCHAR(20)'){
                constraints(nullable: false)
            }
            column(name: 'file_description', type: 'VARCHAR(100)'){
            }
            column(name: 'file_upload_time', type: 'DATE'){
            }
            column(name: 'file_path', type: 'VARCHAR(100)'){}
            column(name: 'file_check', type: 'TINYINT',defaultValue: 0){}
            column(name: 'video_like', type: 'INT',defaultValue: 0){}
            column(name: 'video_collection', type: 'INT',defaultValue: 0){}
            column(name: 'video_play', type: 'INT',defaultValue: 0){}

            column(name: 'last_update', type: 'DATE')
            column(name: 'last_update_by', type: 'VARCHAR(20)')
            column(name: 'user_version', type: 'INT'){
                constraints(nullable: false)
            }
        }
    }
}