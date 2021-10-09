package cypher.helloworld.controller

import cypher.helloworld.entity.Reply
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Size

@Validated
@RestController
class HelloworldController {
    @GetMapping("/")
    fun helloworld(
        @Value(value = "\${helloworld.text}") text: String,
        @RequestParam @Size(min = NAME_MINIMUM_LENGTH, max = NAME_MAXIMUM_LENGTH) name: String,
    ): Reply {
        logger.debug("Request name is $name")
        return Reply(message = "Hello, $text, $name")
    }

    companion object {
        private const val NAME_MINIMUM_LENGTH = 3
        private const val NAME_MAXIMUM_LENGTH = 10
        private val logger = KotlinLogging.logger {}
    }
}
