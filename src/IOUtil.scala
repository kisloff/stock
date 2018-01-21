import java.io.FileWriter

import model.{Account, Order}

import scala.collection.mutable
import scala.io.Source

/**
  * Created by kv on 20.01.2018.
  */
object IOUtil {

  def setUp (accounts: mutable.HashSet[Account], orders : mutable.Queue[Order]) : Unit = {
    fillClientAccounts(accounts)
    fillOrders(orders)
  }

  def fillClientAccounts (accounts: mutable.HashSet[Account]) : Unit = {
    val filename = "/Users/kv/ConsoleProjects/Maven/stock/resources/clients.txt"
    println("accounts")
    for (line <- Source.fromFile(filename).getLines) {
      println(line)

      val tmp: Array[String] = line.split("\t")

      val tmpClient = new Account(tmp(0), tmp(1).toInt, tmp(2).toInt, tmp(3).toInt, tmp(4).toInt, tmp(5).toInt)

      accounts += tmpClient
    }
  }

  def fillOrders (orders : mutable.Queue[Order]) : Unit = {
    val filename = "/Users/kv/ConsoleProjects/Maven/stock/resources/orders.txt"
    println("orders")
    for (line <- Source.fromFile(filename).getLines) {

      println(line)
      val tmp: Array[String] = line.split("\t")

      val tmpPrice = tmp(3).toInt
      val tmpQty = tmp(4).toInt

      val tmpOrderLine = new Order(tmp(0), tmp(1), tmp(2), tmpPrice, tmpQty)
      orders += tmpOrderLine
    }
  }


  def writeResultsToFile (accounts: mutable.HashSet[Account]) : Unit = {
    val fw = new FileWriter("result.txt", true)

    val accList = accounts.toList

    for (elem <- accList) {
      try {
        fw.write(elem.toString + "\n")
      }
    }
    fw.close()
  }

}
