package com.bcd.SerialTester
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorRef
import com.github.jodersky.flow._
import com.github.jodersky.flow.Serial._
import akka.io.IO
import akka.util.ByteString

object Terminal {
  case class Send( data: String )
  case class Recvd( data: String )
  
}
class Terminal extends Actor with ActorLogging {
  import Terminal._
  val port = "/dev/cu.usbserial-FTH0YJ3G"
  val settings = SerialSettings( baud = 115200, characterSize = 8, twoStopBits = false, parity = Parity.None )
  val startPattern: Int = 0xDEAD
  
  import context.system
  IO(Serial) ! Serial.Open( port, settings )
  
  def initial: Receive = 
  {
    case CommandFailed(cmd: Open, reason: AccessDeniedException ) => println( "Port Access Denied" ); context.stop(self);
    case CommandFailed(cmd: Open, reason: Exception ) => println( "Couldn't open because " + reason ); context.stop( self );
    case Opened( settings ) => {
      context.become( connected( sender ) )
    }
  }
  
  def connected( operator: ActorRef ): Receive = {
    case Send( data ) => operator ! Write( ByteString( startPattern ) ++ ByteString( data.size )++  ByteString( data ) )
    case Recvd( data ) => {
      var header = data.take(2).toInt
      var size = data.slice( 2, 4 ).toInt
      var string = data.drop( 4 ).toString
      println( s"Got: Header ${header.toHexString}, Size: $size, String: $string" )
    }
  } 
  def receive = initial
}