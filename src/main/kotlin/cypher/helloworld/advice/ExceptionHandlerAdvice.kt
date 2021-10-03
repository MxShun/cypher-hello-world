package cypher.helloworld.advice

import cypher.helloworld.entity.ErrorInformation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNoHandlerFoundException(): ErrorInformation = ErrorInformation(reason = "no handler found")
}
