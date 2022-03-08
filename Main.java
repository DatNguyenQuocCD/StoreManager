
import java.util.*;

public class Main {
    static Method object = new Method();
    static Scanner sc = new Scanner(System.in);
    public static void error(){
        System.out.println("Error...! Please choose again");
    }
    public static void menu(){
        System.out.println("----------MENU----------");
        System.out.println("|1. Input              |");
        System.out.println("|2. Show               |");
        System.out.println("|3. Search             |");
        System.out.println("|4. Sort               |");
        System.out.println("|5. Update             |");
        System.out.println("|6. Remove             |");
        System.out.println("|7. Statistical        |");
        System.out.println("|8. Exit               |");
        System.out.println("------------------------");
        int choose;
        int number;
        choose=Check.choose(9);
        switch (choose){
            case 1->{
                System.out.println("----------INPUT----------");
                System.out.println("|1. Import goods        |");
                System.out.println("|2. Order               |");
                System.out.println("|3. Back to menu        |");
                System.out.println("-------------------------");
                number=Check.choose(4);
                switch (number){
                    case 1->{object.importGoods();}
                    case 2->{object.order();}
                    case 3->{break;}
                }
            }
            case 2->{
                System.out.println("-------------SHOW-------------");
                System.out.println("|1. Show Company             |");
                System.out.println("|2. Show Items               |");
                System.out.println("|3. Show Bill With Company   |");
                System.out.println("|4. Show Bill With Customer  |");
                System.out.println("|5. Back to menu             |");
                System.out.println("------------------------------");
                number=Check.choose(6);
                switch (number){
                    case 1->{object.showCompany();}
                    case 2->{object.showItems();}
                    case 3->{object.billWithCompany();}
                    case 4->{object.bill();}
                    case 5->{break;}
                }
            }
            case 3->{
                System.out.println("------------SEACHING------------");
                System.out.println("|1. Seaching Company By ID     |");
                System.out.println("|2. Searching Company By Name  |");
                System.out.println("|3. Searching Items By ID      |");
                System.out.println("|4. Searching Items By Name    |");
                System.out.println("|5. Back to menu               |");
                System.out.println("--------------------------------");
                number=Check.choose(6);
                switch (number){
                    case 1->{object.searchingByIdCompany();}
                    case 2->{object.searchingByNameCompany();}
                    case 3->{object.searchingByIdItems();}
                    case 4->{object.searchingByNameItems();}
                    case 5->{break;}
                }
            }
            case 4->{
                System.out.println("--------------SORT--------------");
                System.out.println("|1. Sort Company By ID         |");
                System.out.println("|2. Sort Company By Name       |");
                System.out.println("|3. Sort Items By ID           |");
                System.out.println("|4. Sort Items By Name         |");
                System.out.println("|5. Sort Items By Import Price |");
                System.out.println("|6. Back to menu               |");
                System.out.println("--------------------------------");
                number=Check.choose(7);
                switch (number){
                    case 1->{object.sortCompanyById();}
                    case 2->{object.sortCompanyByName();}
                    case 3->{object.sortItemsByID();}
                    case 4->{object.sortItemsByName();}
                    case 5->{object.sortItemsByImportPrice();}
                    case 6->{break;}
                }
            }
            case 5->{
                System.out.println("------------UPDATE------------");
                System.out.println("|1. Update Company By ID     |");
                System.out.println("|2. Update Company By Name   |");
                System.out.println("|3. Update Items By ID       |");
                System.out.println("|4. Update Items By Name     |");
                System.out.println("|5. Back to menu             |");
                System.out.println("------------------------------");
                number=Check.choose(6);
                switch (number){
                    case 1->{object.updateCompanyById();}
                    case 2->{object.updateCompanyByName();}
                    case 3->{object.updateItemsById();}
                    case 4->{object.updateItemsByName();}
                    case 5->{break;}
                }
            }
            case 6->{
                System.out.println("------------REMOVE------------");
                System.out.println("|1. Remove Company By ID     |");
                System.out.println("|2. Remove Company By Name   |");
                System.out.println("|3. Remove Items By ID       |");
                System.out.println("|4. Remove Items By Name     |");
                System.out.println("|5. Back to menu             |");
                System.out.println("------------------------------");
                number=Check.choose(6);
                switch (number){
                    case 1->{object.removeCompanyByID();}
                    case 2->{object.removeCompanyByName();}
                    case 3->{object.removeItemsByID();}
                    case 4->{object.removeItemsByName();}
                    case 5->{break;}
                }
            }
            case 7->{
                System.out.println("--------STATISTICAL--------");
                System.out.println("|1. Inventory             |");
                System.out.println("|2. Turnover              |");
                System.out.println("|3. Profit                |");
                System.out.println("|4. Back to menu          |");
                System.out.println("---------------------------");
                number=Check.choose(5);
                switch (number){
                    case 1->{object.inventory();}
                    case 2->{object.turnover();}
                    case 3->{object.profit();}
                    case 4->{break;}
                }
            }
            case 8->{System.out.println("thank you! you have exited the program"); return;}
        }
        menu();
    }
    public static void main(String[] args) {
        menu();
    }
}

