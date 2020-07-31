package com.train

import java.util.*

fun main() {
    var numTotal = 0
    var numRoundTrip=0
    println("Please enter number of tickets: ")
    numTotal = Scanner(System.`in`).nextInt()
    println("How many round-trip tickets: ")
    numRoundTrip=Scanner(System.`in`).nextInt()
    val trainTickets = TrainTickets(numTotal, numRoundTrip)
    if(trainTickets.checkOk()) {
        println("Total tickets: ${trainTickets.getTotalTickets()}")
        println("Round-trip: ${trainTickets.getRoundTripTotal()}")
        println("Total: ${trainTickets.getTotalPrice()}")
    }
}

class TrainTickets(private val totalTickets:Int, private val roundTripTotal:Int) {
      fun checkOk():Boolean {
          if(totalTickets<0 ) {
              println("Total tickets cannot be less than zero !!")
              return false
          }
          if(roundTripTotal<0) {
              println("Total roundTrip tickets cannot be less than zero !!")
              return false
          }
          if(totalTickets<roundTripTotal) {
              println("RoundTrip tickets cannot be more than Total tickets !!")
              return false
          }
          return true
      }
      fun getTotalTickets()=this.totalTickets
      fun getRoundTripTotal()=this.roundTripTotal
      fun getTotalPrice()=(this.totalTickets-this.roundTripTotal)*1000+
                           this.roundTripTotal*2000*0.9

}