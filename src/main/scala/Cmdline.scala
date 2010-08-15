package com.osinka.scalate.classloading.demo.app

import java.io.StringWriter
import java.io.PrintWriter
import org.fusesource.scalate._

object CmdlineMain {
  def main(args: Array[String]) {
    val engine = new TemplateEngine
    val template = engine.load("templates/sample.ssp")

    val buffer = new StringWriter()
    val context = new DefaultRenderContext(engine, new PrintWriter(buffer))
    context.attributes("name") = "world";
    template.render(context)
    println(buffer.toString)
  }
}
