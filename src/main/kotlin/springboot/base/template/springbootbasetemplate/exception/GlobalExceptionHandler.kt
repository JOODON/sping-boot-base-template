package springboot.base.template.springbootbasetemplate.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import springboot.base.template.springbootbasetemplate.utils.ErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(ex: CustomException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = ex.message,
            errorCode = ex.errorCode
        )
        return ResponseEntity(errorResponse, ex.httpStatus)
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneralException(ex: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = ex.message ?: "예기치 않은 오류가 발생했습니다.",  // 예외 메시지를 포함하거나 기본 메시지 사용
            errorCode = 500,  // 기본 에러 코드
            status = "ERROR"  // 고정된 오류 상태
        )
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)  // HTTP 500
    }
}
