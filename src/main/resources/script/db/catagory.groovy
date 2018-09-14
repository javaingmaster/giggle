package script.db

databaseChangeLog(logicalFilePath: 'catagroy.groovy'){
    changeSet(id: '2018-09-14-catagroy', author: 'zty'){
        createTable(tableName: "giggle_catagroy"){
            column(name: 'catagroy_id', type: 'BIGINT UNSIGNED', autoIncrement: true){
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'catagroy_name', type: 'VARCHAR(20)'){
                constraints(nullable: false)
            }
        }
    }
}