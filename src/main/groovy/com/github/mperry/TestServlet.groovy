package com.github.mperry

import groovy.servlet.GroovyServlet
import groovy.transform.TypeChecked

import javax.servlet.ServletConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// Output some meaningless data after a random delay in order to generate some interesting test data
@TypeChecked
class TestServlet extends GroovyServlet {
    void init(ServletConfig config) {

    }

    static int count = 0

    void service(HttpServletRequest request, HttpServletResponse response) {
        Thread.sleep(new Random().nextInt(1000))
        count++
        println("New request i: $count request: ${request}")
        response.getWriter().write('<h1>hello world</h1>')
    }
}