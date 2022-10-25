package ie.setu.config

import ie.setu.controllers.HealthTrackerController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*


package io.javalin.example.kotlin

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.example.kotlin.user.UserController
import io.javalin.openapi.plugin.OpenApiConfiguration
import io.javalin.openapi.plugin.OpenApiPlugin
import io.javalin.openapi.plugin.redoc.ReDocConfiguration
import io.javalin.openapi.plugin.redoc.ReDocPlugin
import io.javalin.openapi.plugin.swagger.SwaggerConfiguration
import io.javalin.openapi.plugin.swagger.SwaggerPlugin

fun javalin_main() {

    Javalin.create { config ->
        config.plugins.register(OpenApiPlugin(OpenApiConfiguration().apply {
            info.title = "Javalin OpenAIP example"
        }))
        config.plugins.register(SwaggerPlugin(SwaggerConfiguration()))
        config.plugins.register(ReDocPlugin(ReDocConfiguration()))
    }.routes {
        path("users") {
            get(UserController::getAll)
            post(UserController::create)
            path("{userId}") {
                get(UserController::getOne)
                patch(UserController::update)
                delete(UserController::delete)
            }
        }
    }.start(7001)

    println("Check out ReDoc docs at http://localhost:7001/redoc")
    println("Check out Swagger UI docs at http://localhost:7001/swagger")

}

class JavalinConfig {


    fun startJavalinService(): Javalin {

        val app = Javalin.create().apply {
            exception(Exception::class.java) { e, _ -> e.printStackTrace() }
            error(404) { ctx -> ctx.json("404 - Not Found") }
        }.start(getHerokuAssignedPort())

        registerRoutes(app)
        return app
    }
    private fun registerRoutes(app: Javalin) {
        app.routes {
            path("/api/users") {
                get(HealthTrackerController::getAllUsers)
                post(HealthTrackerController::addUser)
                path("{user-id}"){
                    get(HealthTrackerController::getUserByUserId)
                    delete(HealthTrackerController::delete)
                    patch(HealthTrackerController::updateUser)
                }
                path("email/{email}") {
                    get(HealthTrackerController::getUserByEmail)
                }
            }
        }
    }
    private fun getHerokuAssignedPort(): Int {
        val herokuPort = System.getenv("PORT")
        return if (herokuPort != null) {
            Integer.parseInt(herokuPort)
        } else 7000
    }
}
