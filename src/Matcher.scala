import model.{Account, Order}

import scala.collection.mutable


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


}
