package be.mc.maxgaj.stockex.cli;

import be.mc.maxgaj.stockex.api.StockExchangeController;

public class MyCli {
    public static void main(String[] args) {
        System.out.println("Welcome to stock Exchange");
        if (args.length > 0) {
            StockExchangeController controller = new StockExchangeController();
            System.out.println(controller.getStock(args[0]));
        }
    }
}
