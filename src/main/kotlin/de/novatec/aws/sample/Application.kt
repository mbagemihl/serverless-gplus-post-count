package de.novatec.aws.sample


class Application{

    fun handler(): String {
        return "<html><head><title>HTML from API Gateway/Lambda</title></head>" +
                "<body>" +
                "<h1>HTML from API Gateway/Lambda</h1>" +
                "<image src='https://travis-ci.org/nt-ca-aqe/serverless-poc.svg?branch=master' />" +
                "</body>" +
                "</html>";
    }
}
