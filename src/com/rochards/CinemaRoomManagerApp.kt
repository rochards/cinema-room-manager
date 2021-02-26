package com.rochards

fun initCinema(rows: Int, seats: Int): Array<CharArray> {
    val cinema = Array(rows + 1) { CharArray(seats + 1) {'S'} }
    cinema[0][0] = ' '
    for (i in 1..seats) {
        cinema[0][i] = i.toString().first()
    }
    for (j in 1..rows) {
        cinema[j][0] = j.toString().first()
    }

    return cinema
}

fun showTheSeats(cinema: Array<CharArray>) {
    println("Cinema:")
    for (row in cinema) {
        println(row.joinToString(" "))
    }
}

fun showMenu() {
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")
}

fun ticketPrice(rows: Int, seats: Int, rowNumber: Int): Int {
    val numbersOfSeats = rows * seats
    return if (numbersOfSeats <= 60 || rowNumber <= rows / 2) 10 else 8
}

fun purchaseTicket(cinema: Array<CharArray>, rows: Int, seats: Int): Int {

    var ticketPrice = 0

    do {
        println("Enter a row number:")
        val rowNumber = readLine()!!.toInt()
        println("Enter a seat number in that row:")
        val seatNumber = readLine()!!.toInt()

        val availableSeat = if (rowNumber > rows || seatNumber > seats) {
            println("Wrong input!")
            false
        } else if (cinema[rowNumber][seatNumber] == 'B') {
            println("That ticket has already been purchased!")
            false
        } else {
            cinema[rowNumber][seatNumber] = 'B'

            ticketPrice = ticketPrice(rows, seats, rowNumber)
            println("Ticket price: \$$ticketPrice")

            true
        }
    } while (!availableSeat)

    return ticketPrice
}

fun statistics(numberOfPurchasedTickets: Int, rows: Int, seats: Int, currentIncome: Int) {

    val numbersOfSeats = rows * seats
    val percentageOfPurchasedTickets = 100.0 * numberOfPurchasedTickets / numbersOfSeats
    val totalIncome = if (numbersOfSeats <= 60) {
        numbersOfSeats * 10
    } else {
        seats * 10 * (rows / 2) + seats * 8 * (rows / 2 + rows % 2)
    }

    println("Number of purchased tickets: $numberOfPurchasedTickets")
    println("Percentage: %.2f".format(percentageOfPurchasedTickets) + "%")
    println("Current income: \$$currentIncome")
    println("Total income: \$$totalIncome")
}

fun main() {

    var numberOfPurchasedTickets = 0
    var currentIncome = 0

    println("Enter the number of rows:")
    val rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val seats = readLine()!!.toInt()

    val cinema = initCinema(rows, seats)

    do {
        showMenu()
        val opt = readLine()!!.toInt()

        when (opt) {
            1 -> showTheSeats(cinema)
            2 -> {
                currentIncome += purchaseTicket(cinema, rows, seats)
                numberOfPurchasedTickets++
            }
            3 -> statistics(numberOfPurchasedTickets, rows, seats, currentIncome)
        }
    } while (opt != 0)
}