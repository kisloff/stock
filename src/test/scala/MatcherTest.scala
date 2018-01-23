import matcher.Matcher
import model.Account
import org.scalatest.FlatSpec

import scala.collection.mutable

/**
  * Created by kv on 23.01.2018.
  */
class MatcherTest extends FlatSpec{
  it should "updateBuyerAccount correctly" in {

    val clientName = "someone"

    var tmpClient = new Account(clientName, 1000, 100, 50, 80, 40)

    var  map = new mutable.HashMap[String, Account]
    map.put(clientName, tmpClient)

    Matcher.updateBuyerAccount(map, clientName, 100, 20, "A")

    val updated = map(clientName)

    assert(updated.dollarBalance === 900)
    assert(updated.aBalance === 120)
  }

  it should "updateSellerAccount correctly" in{
    val clientName = "someone"

    var tmpClient = new Account(clientName, 1000, 100, 50, 80, 40)

    var  map = new mutable.HashMap[String, Account]
    map.put(clientName, tmpClient)

    Matcher.updateSellerAccount(map, clientName, 100, 20, "A")

    val updated = map(clientName)

    assert(updated.dollarBalance === 1100)
    assert(updated.aBalance === 80)
  }
}
