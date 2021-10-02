package cypher.helloworld.controller

import cypher.helloworld.entity.Reply
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloworldController {
    @GetMapping("/")
    fun helloworld(
        @RequestParam name: String,
    ): Reply = Reply(message = "Hello, $name")
}
