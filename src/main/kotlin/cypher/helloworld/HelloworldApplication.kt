package cypher.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloworldApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) { runApplication<HelloworldApplication> (*args) }
