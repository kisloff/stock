package model
/**
  * Created by kv on 16.01.2018.
  */
class Order (val clientName : String,
             val operation : String,
             val currency : String,
             val price : Int,
             val qty : Int) {

  override def toString: String =
    clientName + "\t"  + operation + "\t" + currency + "\t"+ price + "\t"+ qty
}
