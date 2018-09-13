package script.db

//databaseChangeLog(logicalFilePath: 'comment.groovy'){
//    changeSet(id: '2018-09-10-user', author: 'zty'){
//        createTable(tableName: "giggle_user"){
//            column(name: 'user_id', type: 'BIGINT UNSIGNED', remarks: 'userid', autoIncrement: true){
//                constraints(nullable: false, primaryKey: true)
//            }
//            column(name: 'user_name', type: 'VARCHAR(20)', remarks: 'username'){
//                constraints(nullable: false)
//            }
//            column(name: 'user_gender', type: 'INT(1)',remarks: 'gender'){
//                constraints(nullable: false)
//            }
//            column(name: 'email', type: 'VARCHAR(20)',remarks: 'email'){
//                constraints(nullable: false)
//            }
//            column(name: 'birthday', type: 'DATE',remarks: 'birthday'){
//                constraints(nullable: false)
//            }
//            column(name: 'user_password', type: 'VARCHAR(100)',remarks: 'password'){
//                constraints(nullable: false)
//            }
//            column(name: 'phone', type: 'VARCHAR(15)',remarks: 'phone')
//            column(name: 'user_location', type: 'VARCHAR(30)',remarks: 'location')
//            column(name: 'avator_path', type: 'VARCHAR(50)',remarks: 'avator picture')
//            column(name: 'user_authority', type: 'TINYINT',remarks: 'authority value'){
//                constraints(nullable: false)
//            }
//            column(name: 'last_update', type: 'DATE',remarks: 'time of last update')
//            column(name: 'last_update_by', type: 'VARCHAR(20)',remarks: 'people who change the table at last')
//            column(name: 'user_version', type: 'INT',remarks: 'version for table'){
//                constraints(nullable: false)
//            }
//        }
//    }
//}