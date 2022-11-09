package ie.setu.config

import mu.KotlinLogging
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.name

class DbConfig{

    private val logger = KotlinLogging.logger {}

    //NOTE: you need the ?sslmode=require otherwise you get an error complaining about the ssl certificate
    fun getDbConnection() :Database{

        logger.info{"Starting DB Connection..."}

//        val dbConfig = Database.connect(
//            "jdbc:postgresql://ec2-44-210-36-247.compute-1.amazonaws.com:5432/ddjlssefdo9c85?sslmode=require",
//            driver = "org.postgresql.Driver",
//            user = "ergddswteehqpd",
//            password = "296121113cd1f3a63132b8ffbb8cd13a68ed291d3ad4e25c2b7a2cabba3d9dee")

        val logger = KotlinLogging.logger {}
        logger.info{"Starting DB Connection..."}

        val PGUSER = "yrketawb"
        val PGPASSWORD = "Nx2-stuK0ZudpI6HoLZgxpZb0P9TAbdr"
        val PGHOST = "jelani.db.elephantsql.com"
        val PGPORT = "5432"
        val PGDATABASE = "yrketawb"

        //url format should be jdbc:postgresql://host:port/database
        val url = "jdbc:postgresql://$PGHOST:$PGPORT/$PGDATABASE"

        val dbConfig = Database.connect(url,
            driver="org.postgresql.Driver",
            user = PGUSER,
            password = PGPASSWORD
        )

        logger.info{"db url - connection: " + dbConfig.url}

        return dbConfig


        logger.info{"DbConfig name = " + dbConfig.name}
        logger.info{"DbConfig url = " + dbConfig.url}

        return dbConfig
    }

}