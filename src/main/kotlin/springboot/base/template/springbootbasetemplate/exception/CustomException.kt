package springboot.base.template.springbootbasetemplate.exception

import org.springframework.http.HttpStatus

class CustomException(
    val errorCode: Int,               // 비즈니스 오류 코드 ex) 1001, 2002
    override val message: String,    // 오류 메시지
    val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR // 실제 응답용 HTTP 상태 코드
) : RuntimeException(message)
