package serverless_poc.hello;

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloEndpoint {

    @GetMapping("/hello")
    fun hello() = "Hello World!"

}