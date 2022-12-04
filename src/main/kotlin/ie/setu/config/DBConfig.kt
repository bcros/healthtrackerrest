package ie.setu.config

import org.jetbrains.exposed.sql.Database
import mu.KotlinLogging

/**
 * Definition of the dbConfig Class
 */
class DbConfig{

    /**
     * Defintion of the dbconnection function, including connection parameters
     */
    fun getDbConnection() :Database{

        val logger = KotlinLogging.logger {}

        logger.info{"Starting DB Connection..."}

        val PGHOST = "jelani.db.elephantsql.com"
        val PGPORT = "5432"

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