package io.coding.me.protoc.uml

import protocbridge.frontend.PluginFrontend
import protocbridge.ExtraEnv

/** Main entry point when using compiler as protoc plugin */
object Main extends App {

  val plugin   = ProtocUMLGenerator()
  var env = new ExtraEnv("") 
  val response = PluginFrontend.runWithInputStream(plugin, System.in, env)

  System.out.write(response)
}
