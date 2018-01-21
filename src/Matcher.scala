import model.{Account, Order}

import scala.collection.mutable
import util.control.Breaks.{break, breakable}


/**
  * Created by kv on 20.01.2018.
  */
object Matcher {

  var bidA = new mutable.Queue[Order]()
  var askA = new mutable.Queue[Order]()

  var bidB = new mutable.Queue[Order]()
  var askB = new mutable.Queue[Order]()

  var bidC = new mutable.Queue[Order]()
  var askC = new mutable.Queue[Order]()

  var bidD = new mutable.Queue[Order]()
  var askD = new mutable.Queue[Order]()

  def processOrders (accounts: mutable.HashSet[Account], orders : mutable.Queue[Order]): Unit ={
    fillQueues(orders)

    matchOrders(bidA, askA, accounts)
    matchOrders(bidB, askB, accounts)
    matchOrders(bidC, askC, accounts)
    matchOrders(bidD, askD, accounts)

  }

  def fillQueues(orders : mutable.Queue[Order]) = {
    for(order <- orders){
      order.currency match {
        case "A" => order.operation match {
          case "b" => bidA.enqueue(order) case "s" => askA.enqueue(order)
        }
        case "B" => order.operation match {
          case "b" => bidB.enqueue(order) case "s" => askB.enqueue(order)
        }
        case "C" => order.operation match {
          case "b" => bidC.enqueue(order) case "s" => askC.enqueue(order)
        }
        case "D" => order.operation match {
          case "b" => bidD.enqueue(order) case "s" => askD.enqueue(order)
        }
      }
    }
  }

  def matchOrders(buy : mutable.Queue[Order], sell : mutable.Queue[Order], accounts : mutable.HashSet[Account]) = {
    for(orderBuy <- buy){
      for(orderSell <- sell){
        breakable {if(orderBuy == orderSell) break}
        if(orderBuy.price == orderSell.price && orderBuy.qty == orderSell.qty){
          val dollar = orderBuy.price
          val qty = orderBuy.qty

          val seller = orderSell.clientName
          val buyer = orderBuy.clientName

          updateAccounts(accounts, seller, dollar, qty)
          updateAccounts(accounts, seller, dollar, qty)

          buy.dequeue();
          sell.dequeue();
        }
      }
    }
  }

  def updateAccounts (account : mutable.HashSet[Account], trader : String, dollar : Int, qty : Int): Unit = {

  }

  def areOrdersEqual(bidOrder : Order, askOrder : Order) : Boolean = {
    if (bidOrder.equals(askOrder)) true else false
  }
}
