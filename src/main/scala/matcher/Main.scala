package matcher

import model.{Account, Order}

import scala.collection.mutable

/**
  * Created by kv on 16.01.2018.
  */
object Main extends App {

  var accounts = mutable.HashMap[String, Account]()
  var orders = new mutable.Queue[Order]()

  IOUtil.setUp(accounts, orders)

  Matcher.processOrders(accounts, orders)

  IOUtil.writeResultsToFile(accounts)

}