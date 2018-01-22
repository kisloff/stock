package matcher

import java.io.FileWriter

import model.{Account, Order}

import scala.collection.immutable.ListMap
import scala.collection.mutable
import scala.io.Source

/**
  * Created by kv on 20.01.2018.
  */
object IOUtil {

  def setUp (accounts: mutable.HashMap[String, Account], orders : mutable.Queue[Order]) : Unit = {
    fillClientAccounts(accounts)
    fillOrders(orders)
  }

  def fillClientAccounts (accounts: mutable.HashMap[String, Account]) : Unit = {

    //val filename = "clients.txt"
    val filename = getClass.getClassLoader.getResource("clients.txt").getPath

    for (line <- Source.fromFile(filename).getLines) {

      val tmp: Array[String] = line.split("\t")

      val tmpClient = new Account(tmp(0), tmp(1).toInt, tmp(2).toInt, tmp(3).toInt, tmp(4).toInt, tmp(5).toInt)

      accounts.put(tmp(0), tmpClient)
    }
  }

  def fillOrders (orders : mutable.Queue[Order]) : Unit = {

    //val filename = "orders.txt"
    val filename = getClass.getClassLoader.getResource("orders.txt").getPath

    for (line <- Source.fromFile(filename).getLines) {

      val tmp: Array[String] = line.split("\t")

      val tmpPrice = tmp(3).toInt
      val tmpQty = tmp(4).toInt

      val tmpOrderLine = new Order(tmp(0), tmp(1), tmp(2), tmpPrice, tmpQty)
      orders += tmpOrderLine
    }
  }

  def writeResultsToFile (accounts: mutable.HashMap[String, Account]) : Unit = {
    val filename = "result.txt"

    val fw = new FileWriter(filename, true)

    for (elem <- ListMap(accounts.toSeq.sortBy(_._1):_*).values) {
        fw.write(elem.toString + "\n")
    }
    fw.close()
  }

}
