package springboot.base.template.springbootbasetemplate.utils

data class SuccessResponse<T>(
    override val status: String = "SUCCESS",  // 성공 상태
    override val message: String,             // 성공 메시지
    val successCode: Int = 200,               // 성공 코드
    val data: T                               // 실제 데이터
) : CommonResponse