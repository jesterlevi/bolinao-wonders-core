package com.example

import org.jetbrains.exposed.sql.Database

object DatabaseFactory {
    private val host = "ec2-52-200-5-135.compute-1.amazonaws.com"
    private val port = 5432
    private val dbName = "dbnj7lfcsuchsq"
    private val dbUser = "xtzvyganoeumxu"
    private val dbPassword = "954304b31579a3671563165a365f285d85431d096dc424be07a4f08eb98534e4"
    //establish database connection
    fun connect() = Database.connect(
        url = "jdbc:postgresql://$host:$port/$dbName",
        driver = "org.postgresql.Driver",
        user = dbUser,
        password = dbPassword,
    )

}