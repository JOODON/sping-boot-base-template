package springboot.base.template.springbootbasetemplate.utils

data class ErrorResponse(
    override val status: String = "ERROR",    // 실패 상태
    override val message: String,             // 실패 메시지
    val errorCode: Int = 500                  // 실패 코드
) : CommonResponse