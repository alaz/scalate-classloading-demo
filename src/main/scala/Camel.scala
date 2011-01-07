package com.osinka.scalate.classloading.demo.app

import collection.JavaConversions.asJavaMap
import org.apache.camel.CamelContext
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

    // will not work without this:
    initScalate(context)

    context.start
    context
  }

  def initScalate(context: CamelContext) {
    import org.fusesource.scalate.camel.ScalateComponent
    import org.fusesource.scalate.util.FileResourceLoader

    Option( context.getComponent("scalate") ) foreach {
      case scalateComponent: ScalateComponent =>
        scalateComponent.templateEngine.allowReload = false
        scalateComponent.templateEngine.resourceLoader = FileResourceLoader()
    }
  }

  object routeBuilder extends RouteBuilder {
    override def configure {
      from("direct:start").setHeader("name",body()).to("scalate:templates/sample.ssp")
    }
  }
}
