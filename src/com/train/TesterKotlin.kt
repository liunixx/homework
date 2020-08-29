package com.train

import java.util.*

fun main() {
    var numTotal = 0
    var numRoundTrip = 0
    // numTotal = Scanner(System.`in`).nextInt()
    try {
          while(numTotal != -1) {
              println("Enter number of total tickets: ")
              numTotal = readLine()!!.toInt()
              var trainTickets = TrainTickets(numTotal, 0)
              if(trainTickets.checkOk()) {
                  println("How many round-trip tickets: ")
//            numRoundTrip = Scanner(System.`in`).nextInt()
                  numRoundTrip = readLine()!!.toInt()
                  trainTickets.setRoundTripTotal(numRoundTrip)
                  if (trainTickets.checkOk()) {
                      println("Total tickets: ${trainTickets.getTotalTickets()}")
                      println("Round-trip: ${trainTickets.getRoundTripTotal()}")
                      println("Total: ${trainTickets.getTotalPrice()}")
                  }
              }

          }
//        while (true) {
//            println("\nEnter number of total tickets: ")
//            numTotal = readLine()!!.toInt()
//            if (numTotal == -1) {
//                println("Bye !!")
//                break
//            }
//            println("How many round-trip tickets: ")
//            // numRoundTrip = Scanner(System.`in`).nextInt()
//            numRoundTrip = readLine()!!.toInt()
//            val trainTickets = TrainTickets(numTotal, numRoundTrip)
//            if (trainTickets.checkOk()) {
//                println("Total tickets: ${trainTickets.getTotalTickets()}")
//                println("Round-trip: ${trainTickets.getRoundTripTotal()}")
//                println("Total: ${trainTickets.getTotalPrice()}")
//            }
//        }
    } catch (e:Exception) {
        println("Error input , Exit !!")
    }
}

class TrainTickets(private var totalTickets:Int, private var roundTripTotal:Int) {
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
      fun setTotalTickets(_totalTickets:Int) {
          this.totalTickets = _totalTickets
      }
      fun setRoundTripTotal(_roundTripTotal:Int) {
          this.roundTripTotal = _roundTripTotal
      }
      fun getTotalTickets()=this.totalTickets
      fun getRoundTripTotal()=this.roundTripTotal
      fun getTotalPrice()=(this.totalTickets-this.roundTripTotal)*1000+
                           this.roundTripTotal*2000*0.9

}