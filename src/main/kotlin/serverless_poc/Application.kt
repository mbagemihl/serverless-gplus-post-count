package serverless_poc

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class Application : RequestHandler<String,String> {
    override fun handleRequest(name: String, context: Context) = "Hello World!"
}