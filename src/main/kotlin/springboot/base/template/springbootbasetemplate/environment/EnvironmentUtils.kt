package springboot.base.template.springbootbasetemplate.environment

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EnvironmentUtils {

    @Value("\${app.environment}")
    lateinit var appEnvironment: String

    fun getEnvironment(): String {
        return appEnvironment
    }

    fun isProd(): Boolean {
        return appEnvironment.equals("prod", ignoreCase = true)
    }

    fun isDev(): Boolean {
        return appEnvironment.equals("dev", ignoreCase = true)
    }

    fun isTest(): Boolean {
        return appEnvironment.equals("test", ignoreCase = true)
    }
}