package com.osinka.scalate.classloading.demo.app

import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.builder.RouteBuilder

object CamelMain {
  def main(args: Array[String]) {
    val context = initCamel
    val template = context.createProducerTemplate
    println(template.requestBody("direct:start", "world"))
    context.stop
  }
  
  def initCamel = {
    val context = new DefaultCamelContext
    context.disableJMX
    context.addRoutes(routeBuilder)
    context.start
    context
  }

  object routeBuilder extends RouteBuilder {
    override def configure {
      from("direct:start").setHeader("name").body().to("scalate:templates/sample.ssp")
    }
  }
}