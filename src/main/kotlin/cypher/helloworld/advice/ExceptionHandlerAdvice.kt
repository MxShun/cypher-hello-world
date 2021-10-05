package cypher.helloworld.advice

import cypher.helloworld.entity.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleNoHandlerFoundException(): ErrorResponse = ErrorResponse(reason = "no handler found")

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleConstraintViolationException(exception: ConstraintViolationException): ErrorResponse =
        ErrorResponse(reason = "invalid parameter: detail: [${exception.message}]")

    @ExceptionHandler(Exception::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(): ErrorResponse = ErrorResponse(reason = "something wrong ;-(")
}
