package com.shaker;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
	  StockItem temp = new StockItem("bread", 0.89, 100);
      stockList.addStock(temp);

      temp = new StockItem("gari",0.50, 14);
      stockList.addStock(temp);

        temp = new StockItem("shito",10.00, 32);
        stockList.addStock(temp);

        temp = new StockItem("rice",1.50, 20);
        stockList.addStock(temp);

        temp = new StockItem("soap",4.50, 58);
        stockList.addStock(temp);

        temp = new StockItem("ice cream",2.40, 40);
        stockList.addStock(temp);

        temp = new StockItem("guinness",5.50, 500);
        stockList.addStock(temp);

        temp = new StockItem("palm wine",3.70, 10);
        stockList.addStock(temp);

        temp = new StockItem("pasta",1.50, 51);
        stockList.addStock(temp);
      temp = new StockItem("hennessy",55.00, 20);
      stockList.addStock(temp);

      temp = new StockItem("phone",100, 4);
      stockList.addStock(temp);

      temp = new StockItem("candle",15.00, 20);
      stockList.addStock(temp);

      temp = new StockItem("candle",12.00, 7);
      stockList.addStock(temp);

      temp = new StockItem("headphone",300, 1);
      stockList.addStock(temp);

      temp = new StockItem("apple",15.00, 60);
      stockList.addStock(temp);

      System.out.println(stockList);

      for(String s: stockList.Items().keySet()){
        System.out.println(s);
      }
      Basket emmanuelsBasket = new Basket("Emmanuel");
      sellItem(emmanuelsBasket, "phone", 2);
      System.out.println( emmanuelsBasket);

      sellItem(emmanuelsBasket, "headphone", 1);
      System.out.println( emmanuelsBasket);

      if(sellItem(emmanuelsBasket,"headphone", 1 ) != 1){
        System.out.println("There no more headphones in stock ");
      }
      sellItem(emmanuelsBasket, "soda", 2);
      System.out.println(emmanuelsBasket);


      sellItem(emmanuelsBasket, "soap", 4);
      sellItem(emmanuelsBasket, "bread", 3);
      sellItem(emmanuelsBasket, "guinness", 4);
      System.out.println( emmanuelsBasket);

      System.out.println(stockList);

//      temp = new StockItem("Calculator", 20.50);
//      stockList.Items().put(temp.getName(), temp);
      stockList.Items().get("guinness").adjustStock(500);
      stockList.get("guinness").adjustStock(-200);
      System.out.println(stockList);

      for(Map.Entry<String, Double> price : stockList.PriceList().entrySet()){
        System.out.println(price.getKey() + " cost " + price.getValue());
      }

    }

      public static int sellItem(Basket basket, String item, int quantity){
      // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
          System.out.println("We don't sell " + item) ;
          return 0;

        }
        if(stockList.sellStock(item, quantity) !=0){
          basket.addToBasket(stockItem, quantity);
          return quantity;
        }
        return 0;
      }


}
