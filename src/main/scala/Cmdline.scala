package com.osinka.scalate.classloading.demo.app

import collection.JavaConversions.asJavaMap
import java.io.StringWriter
import java.io.PrintWriter
import org.fusesource.scalate._

object CmdlineMain {
  def main(args: Array[String]) {
    val engine = new TemplateEngine
    println( engine.layout("templates/sample.ssp", Map("headers" -> asJavaMap(Map("name" -> "world"))) ) )
  }
}
