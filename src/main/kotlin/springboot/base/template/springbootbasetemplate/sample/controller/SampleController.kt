package springboot.base.template.springbootbasetemplate.sample.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import springboot.base.template.springbootbasetemplate.environment.EnvironmentUtils
import springboot.base.template.springbootbasetemplate.exception.CustomException
import springboot.base.template.springbootbasetemplate.logger.LoggerUtil
import springboot.base.template.springbootbasetemplate.sample.dto.Sample
import springboot.base.template.springbootbasetemplate.utils.CommonResponse
import springboot.base.template.springbootbasetemplate.utils.ErrorResponse
import springboot.base.template.springbootbasetemplate.utils.SuccessResponse

@RestController
@RequestMapping("/sample")
class SampleController(
    private val environment: EnvironmentUtils,
    private val loggerUtil: LoggerUtil
) {

    // GET 요청 처리: 특정 데이터를 조회
    @GetMapping("/{id}")
    fun sampleDetails(@PathVariable id: Long): ResponseEntity<String> {
        // id에 해당하는 샘플 데이터를 조회하고 반환
        loggerUtil.logInfo("sampleDetails 호출 현재 Env 상태 : [${environment.getEnvironment()}]")

        return ResponseEntity.ok("샘플 데이터 ID: $id")
    }

    // POST 요청 처리: 새로운 데이터 생성
    @PostMapping
    fun sampleSave(@RequestBody sample: Sample): ResponseEntity<String> {
        // 전달된 sample 객체를 처리 (DB 저장 등)
        return ResponseEntity.status(201).body("샘플 데이터가 생성되었습니다.")
    }

    // PUT 요청 처리: 기존 데이터 업데이트
    @PutMapping("/{id}")
    fun sampleModify(@PathVariable id: Long, @RequestBody sample: Sample): ResponseEntity<String> {
        // 전달된 sample 객체로 기존 데이터를 업데이트
        return ResponseEntity.ok("샘플 데이터 ID: $id 가 업데이트되었습니다.")
    }

    // DELETE 요청 처리: 특정 데이터 삭제
    @DeleteMapping("/{id}")
    fun sampleRemove(@PathVariable id: Long): ResponseEntity<String> {
        // 해당 ID에 해당하는 샘플 데이터를 삭제
        return ResponseEntity.ok("샘플 데이터 ID: $id 가 삭제되었습니다.")
    }

    // 전체 데이터 조회 (옵션)
    @GetMapping
    fun sampleList(): ResponseEntity<List<Sample>> {
        // 모든 샘플 데이터를 조회하여 반환
        val samples = listOf(Sample(1, "샘플 1"), Sample(2, "샘플 2"))
        return ResponseEntity.ok(samples)
    }

    @GetMapping("/success")
    fun successResponse(): ResponseEntity<CommonResponse> {
        val successResponse = SuccessResponse(
            message = "성공적으로 처리되었습니다.",
            successCode = 200,
            data = "성공 데이터"
        )
        return ResponseEntity.ok(successResponse)
    }

    @GetMapping("/error")
    fun errorResponse(): ResponseEntity<CommonResponse> {
        val errorResponse = ErrorResponse(
            message = "처리 중 오류가 발생했습니다.",
            errorCode = 500
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse)
    }

    @GetMapping("/exception")
    fun throwException(): String {
        // 예외를 강제로 발생시킴

        // 1. NullPointerException
        // throw NullPointerException("널 포인터 예외가 발생했습니다.")

        // 2. IllegalArgumentException
        // throw IllegalArgumentException("잘못된 인자값입니다.")

        // 3. ArrayIndexOutOfBoundsException
        // throw ArrayIndexOutOfBoundsException("배열 인덱스 초과 예외입니다.")

        // 4. ArithmeticException
        // throw ArithmeticException("수학적 오류가 발생했습니다. (예: 0으로 나누기)")

        // 5. ClassNotFoundException
        // throw ClassNotFoundException("클래스를 찾을 수 없습니다.")

        // 6. FileNotFoundException
        // throw FileNotFoundException("파일을 찾을 수 없습니다.")

        // 7. SQLException
        // throw SQLException("SQL 오류가 발생했습니다.")

        // 8. NumberFormatException
        // throw NumberFormatException("숫자 형식이 잘못되었습니다.")

        // 9. IOException
        // throw IOException("입출력 오류가 발생했습니다.")

        // 10. UnsupportedOperationException
        throw UnsupportedOperationException("지원되지 않는 작업입니다.")

        // 정상적인 응답
        // return "정상 처리되었습니다."
    }
    @GetMapping("/custom-exception")
    fun throwCustomException(): String {
        throw CustomException(
            errorCode = 1001,
            message = "존재하지 않는 사용자입니다.",
            httpStatus = HttpStatus.NOT_FOUND
        )
    }

}