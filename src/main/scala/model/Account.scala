package model

/**
  * Created by kv on 16.01.2018.
  */
class Account (val clientName : String,
               var dollarBalance : Int,
               var aBalance : Int,
               var bBalance : Int,
               var cBalance : Int,
               var dBalance : Int
              ){

  override def toString: String = {
    clientName + "\t" + dollarBalance + "\t" + aBalance + "\t" + bBalance + "\t" + cBalance + "\t" + dBalance
  }

}
