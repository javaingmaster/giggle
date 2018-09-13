package script.db

databaseChangeLog(logicalFilePath: 'video.groovy'){
    changeSet(id: '2018-09-13-video', author: 'zty'){
        createTable(tableName: "giggle_video"){
            column(name: 'video_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'video_name', type: 'VARCHAR(20)'){
                constraints(nullable: false)
            }
            column(name: 'video_description', type: 'VARCHAR(100)'){
            }
            column(name: 'video_upload_time', type: 'DATE'){
            }
            column(name: 'video_path', type: 'VARCHAR(100)',defaultValue: 'giggle/videos'){}
            column(name: 'video_check', type: 'TINYINT',defaultValue: 0){}
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