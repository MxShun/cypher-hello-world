package cypher.helloworld.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloworldController {
    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/")
    fun helloworld(): String = "Hello World"
}
