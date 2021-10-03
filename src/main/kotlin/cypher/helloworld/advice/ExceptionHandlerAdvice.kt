package cypher.helloworld.advice

import cypher.helloworld.entity.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleNoHandlerFoundException(): ErrorResponse = ErrorResponse(reason = "no handler found")

    @ExceptionHandler(Exception::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(): ErrorResponse = ErrorResponse(reason = "something wrong ;-(")
}
