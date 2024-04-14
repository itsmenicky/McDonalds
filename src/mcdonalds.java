import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mcdonalds {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        sandwichesMenu[] sandwiches = new sandwichesMenu[5];
        drinksMenu[] drinks = new drinksMenu[2];
        List<order> orders = new ArrayList<>();
        sandwiches[0] = new sandwichesMenu("Big Mac", 22.90);
        sandwiches[1] = new sandwichesMenu("Duplo Quarterao", 23.00);
        sandwiches[2] = new sandwichesMenu("Quarterao com Queijo", 23.00);
        sandwiches[3] = new sandwichesMenu("Mcnifico Bacon", 23.00);
        sandwiches[4] = new sandwichesMenu("Duplo Cheddar Mcmelt", 23.00);
        drinks[0] = new drinksMenu("Coca Cola", 6.00);
        drinks[1] = new drinksMenu("Guarana", 6.00);
        int orderCod = 0;

        while(true){
            apagartela();
            System.out.println(red + "||*************************||" + reset);
            System.out.println(red + "||" + yellow + "Bem vindo ao McDonald's!!" + red + "||" + reset);
            System.out.println(red + "||*************************||" + reset);
            mclogo();
            System.out.println("\nOque podemos fazer por você?");
            System.out.println("\n1 - Fazer pedido\n2 - Ver pedidos na fila\n3 - Encerrar sessão");
            int menuOption = input.nextInt();
            switch(menuOption){
                case 1:
                    while(true){
                        apagartela();
                        mclogo();
                        apagartela();
                        showSandwiches(sandwiches);
                        showDrinks(drinks);
                        System.out.println(yellow + "\n\n+---Escolha seu lanche!! (Digite o numero correspondente ao respectivo lanche) -->" + reset);
                        int sandwichChoose = input.nextInt();
                        System.out.println(yellow + "\n\n+---Escolha sua bebida!! (Digite o numero correspondente a respectiva bebida) -->" + reset);
                        int drinkChoose = input.nextInt();
                        input.nextLine();
                        order customerOrder = new order(sandwiches[sandwichChoose], drinks[drinkChoose]);
                        orders.add(customerOrder);
                        System.out.println(green + "+----------PEDIDO----------+" + reset);
                        System.out.println("                              ");
                        System.out.println("                              ");
                        System.out.println("     " + orders.get(orderCod).getSandwich().getSandwich() + " - R$" + orders.get(orderCod).getSandwich().getPrice() + "     ");
                        System.out.println("     " + orders.get(orderCod).getDrink().getDrink() + " - R$" + orders.get(orderCod).getDrink().getPrice() + "     ");
                        System.out.println("                              ");
                        System.out.println("                              ");
                        System.out.println(green + "+--------------------------+" + reset);
                        System.out.println(green + "   Total a pagar: R$" + (orders.get(orderCod).getSandwich().getPrice() + orders.get(orderCod).getDrink().getPrice()) + reset);
                        System.out.println("CONFIRMAR PEDIDO? (s/n) -> ");
                        String option = input.nextLine();
        
                        if(option.equals("s")){
                            System.out.println(yellow + "\n\nPedido realizado com sucesso!! Número do pedido --> " + orderCod + reset);
                            orderCod++;
                            break;
                        } else if(option.equals("n")){
                            orders.remove(orderCod);
                            System.out.println("Pedido cancelado.");
                            continue;
                        }else{
                            System.out.println("Opção inválida! Retornando ao menu principal...");
                            break;
                        }
                    }
                    break;
                case 2:
                   apagartela();
                   System.out.println("+----------PEDIDOS----------+");
                   System.out.println("N°     Lanche          Bebida");
                   for(int i = 0; i < orders.size(); i++){
                       System.out.println(i + "   " + orders.get(i).getSandwich().getSandwich() + "   " + orders.get(i).getDrink().getDrink());
                   }
                   Thread.sleep(5000);
                   continue;

                case 3:
                   input.close();
                   System.exit(0);

                default:
                   System.out.println("Opção inválida!!");
                   Thread.sleep(2000);
                   continue;
            }
        }
    }

    public static class sandwichesMenu {
        private String sandwich;
        private double price;

        public sandwichesMenu(String sandwich, double price) {
            this.sandwich = sandwich;
            this.price = price;
        }

        public String getSandwich() {
            return sandwich;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class drinksMenu {
        private String drink;
        private double price;

        public drinksMenu(String drink, double price) {
            this.drink = drink;
            this.price = price;
        }

        public String getDrink() {
            return drink;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class order{
        private sandwichesMenu sandwich;
        private drinksMenu drink;

        public order(sandwichesMenu sandwich, drinksMenu drink){
            this.sandwich = sandwich;
            this.drink = drink;
        }

        public sandwichesMenu getSandwich(){
            return this.sandwich;
        }

        public drinksMenu getDrink(){
            return this.drink;
        }
    }

    public static void mclogo() throws InterruptedException {
        Thread.sleep(150);
        System.out.println(yellow + "       ||           ||");
        Thread.sleep(150);
        System.out.println(yellow + "       ||||       ||||");
        Thread.sleep(150);
        System.out.println(yellow + "       ||||       ||||");
        Thread.sleep(150);
        System.out.println(yellow + "     |||  ||_____||  |||");
        Thread.sleep(150);
        System.out.println(yellow + "     |||   |     |   |||");
        Thread.sleep(150);
        System.out.println(yellow + "     |||    |   |    |||");
        Thread.sleep(150);
        System.out.println(yellow + "     |||     | |     |||");
        Thread.sleep(150);
        System.out.println(yellow + "    ||||     | |     ||||");
        Thread.sleep(150);
        System.out.println(yellow + "    ||||     | |     ||||");
        Thread.sleep(150);
        System.out.println(yellow + "    ||||     | |     |||| ");
        Thread.sleep(150);
        System.out.println(yellow + "    ||||     |_|     |||| ");
        Thread.sleep(150);
        System.out.println(yellow + "    ||||             |||| ");
        Thread.sleep(150);
        System.out.println(yellow + "    ||||             |||| " + reset);
    }

    private static void showSandwiches(sandwichesMenu[] sandwiches){
        System.out.println(red + "\n\n     +------------LANCHES------------+" + reset);
        for(int i=0;i < sandwiches.length;i++){
            System.out.print("\n\n        " + i + " - " + sandwiches[i].sandwich);
        }
    }

    private static void showDrinks(drinksMenu[] drinks){
        System.out.println(red + "\n\n     +------------BEBIDAS------------+" + reset);
        for(int i = 0; i < drinks.length;i++){
            System.out.print("\n\n        " + i + " - " + drinks[i].drink);
        }
    }

    public static void apagartela() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static final String red = "\u001b[31m";
    public static final String yellow = "\u001b[33m";
    public static final String reset = "\u001b[0m";
    public static final String green = "\u001b[32m";
}
