package ie.setu.config

import org.jetbrains.exposed.sql.Database
import mu.KotlinLogging

class DbConfig{

    fun getDbConnection() :Database{

        val logger = KotlinLogging.logger {}

        logger.info{"Starting DB Connection..."}

        val PGHOST = "jelani.db.elephantsql.com"
        val PGPORT = "5432"

        //Test database created using handcoded SQL and Insert Statements
        //val PGUSER = "kuwsemue"
        //val PGPASSWORD = "zWmiFoHcieiOZIPOf-bIxWDnkzYZRl91"
        //val PGDATABASE = "kuwsemue"

        //Test database created using generated SQL and Insert Statements from Heroku
        val PGUSER = "yrketawb"
        val PGPASSWORD = "Nx2-stuK0ZudpI6HoLZgxpZb0P9TAbdr"
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
    }

}