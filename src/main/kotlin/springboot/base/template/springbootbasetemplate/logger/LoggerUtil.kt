package springboot.base.template.springbootbasetemplate.logger

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class LoggerUtil {

    private val logger: org.slf4j.Logger = LoggerFactory.getLogger(LoggerUtil::class.java)

    // 기본 로그 출력 (INFO)
    fun logInfo(message: String) {
        logger.info(message)
    }

    // 경고 로그 출력 (WARN)
    fun logWarn(message: String) {
        logger.warn(message)
    }

    // 에러 로그 출력 (ERROR)
    fun logError(message: String, throwable: Throwable? = null) {
        logger.error(message, throwable)
    }

    // 디버그 로그 출력 (DEBUG)
    fun logDebug(message: String) {
        logger.debug(message)
    }

}