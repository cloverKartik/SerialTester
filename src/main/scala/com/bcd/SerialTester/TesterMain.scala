package com.bcd.SerialTester
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorRef
import akka.actor.ActorSystem

import Terminal._
import akka.actor.Props


object TesterMain extends App {
  val system = ActorSystem( "flow" )
  val terminal = system.actorOf( Props[Terminal], "Terminal" )
  system.registerOnTermination( println ("System Exited" ) )
  
}