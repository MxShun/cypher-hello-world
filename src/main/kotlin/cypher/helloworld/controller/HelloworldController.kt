package cypher.helloworld.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloworldController {
    @GetMapping("/")
    fun helloworld(): String = "Hello World"
}
