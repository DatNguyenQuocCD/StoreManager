import java.util.*;


public class Method {
    Scanner sc=new Scanner(System.in);
    ArrayList <Items> listItems= new ArrayList<Items>();
    ArrayList <Customer> listCustomers= new ArrayList<Customer>();
    ArrayList <Company> listCompany= new ArrayList<Company>();
    ArrayList <Float> listTotalMoney=new ArrayList<>();
    ArrayList <Float> listPayment= new ArrayList<>();
    ArrayList <Float> listExpense= new ArrayList<>();
    float percent=0;
    float turnover=0;
    int idCustomer=1;
    String phone;
    String name;
    String email;
    int id;
    int number;
    int amount;
    float importPrice;
    float saleprice;
    public void errorTry_Catch(){
        System.out.println("Error...! Please choose again");
    }
    public void error(){
        System.out.println("Does not exist!");
    }
    public void println(){
        System.out.println("\n");
    }
    public int checkIdItems(){
        while(true){
            try {
                System.out.print("Enter ID: ");
                id =Integer.parseInt(sc.nextLine());
                int a=searchIdItems(id);
                if(id>0 && a==-1){
                    return id;
                }
                errorTry_Catch();
            } catch (Exception e) {
                errorTry_Catch();
            }
        }
    }
    public int checkIdCompany(){
        while(true){
            try {
                System.out.print("Enter the Company ID: ");
                id =Integer.parseInt(sc.nextLine());
                int a=searchCompanyId(id);
                if(id>0 && a==-1){
                    return id;
                }
                errorTry_Catch();
            } catch (Exception e) {
                errorTry_Catch();
            }
        }
    }
    public void inputCompany(){
        System.out.print("Enter the Company ID: ");
        id=Check.checkInt();
        int i=searchCompanyId(id);
        if(i!=-1){
            System.out.print("Enter the number of items you want to buy: ");
            number=Check.checkInt();
            int key=1;
            while (key<=number){
                System.out.println("-------------Enter item information "+key+"---------------");
                System.out.print("Enter the Item ID: ");
                id= Check.checkInt();
                int j=searchItemsIdOfCompany(i, id);
                if(j!=-1){
                    System.out.print("Enter the Item amount: ");
                    amount=Check.checkInt();
                    percent=Check.precent(amount);
                    Items items= listCompany.get(i).getListItems().get(j);
                    items.setAmount(listCompany.get(i).getListItems().get(j).getAmount()+amount);
                    items.setTotalAmountAfterPromotison(items.getTotalAmountAfterPromotion()+items.getImportPrice()*amount-items.getImportPrice()*amount/100*percent);
                    items.setTotalMoney(items.totalMoney());
                    key=key+1;
                }
                else{
                    System.out.print("Enter the Item name: ");
                    name=Check.isName();
                    System.out.print("Enter the Item amount: ");
                    amount=Check.checkInt();
                    System.out.print("Enter the item import Price: ");
                    importPrice=Check.checkFloat();
                    System.out.print("Enter the item sale price: ");
                    saleprice=Check.checkFloat();
                    float totalMoney= 0;
                    float totalAmountAfterPromotion=0;
                    Items items=new Items(id, name, amount, importPrice, saleprice,totalMoney,totalAmountAfterPromotion);
                    percent=Check.precent(amount);
                    items.setTotalMoney(items.totalMoney());
                    items.setTotalAmountAfterPromotison(items.totalMoney(percent));
                    listCompany.get(i).getListItems().add(items);
                    listItems.add(items);
                    key+=1;
                }
            }
        }
        else{
            System.out.print("Enter Company name: ");
            name=Check.isName();
            System.out.print("Enter the Company address: ");
            String address=sc.nextLine();
            System.out.print("Enter the Company email: ");
            email=Check.isEmail();
            System.out.print("Enter the Company phone: ");
            phone=Check.isPhone();
            Company company =new Company(id, name, address, email, phone);
            System.out.print("Enter the number of items you want to buy: ");
            number=Check.checkInt();
            int key=1;
            while (key<=number){
                System.out.println("-------------Enter item information "+key+"---------------");
                id=checkIdItems();
                System.out.print("Enter item name: ");
                name=Check.isName();
                System.out.print("Enter the item amount: ");
                amount=Check.checkInt();
                System.out.print("Enter the item import Price: ");
                importPrice=Check.checkFloat();
                System.out.print("Enter the item sale price: ");
                saleprice=Check.checkFloat();
                float totalMoney= 0;
                float totalAmountAfterPromotion=0;
                Items items=new Items(id, name, amount, importPrice, saleprice,totalMoney,totalAmountAfterPromotion);
                percent=Check.precent(amount);
                items.setTotalMoney(items.totalMoney());
                items.setTotalAmountAfterPromotison(items.totalMoney(percent));
                company.getListItems().add(items);
                listItems.add(items);
                key+=1;
            }
        listCompany.add(company);
        }
    }
    public void importGoods(){
        System.out.println("---------------------Impor Goods--------------------");
        System.out.print("Enter the number of suppliers: ");
        int number1 = Check.checkInt();
        for(int i=1;i<=number1;i++){
            System.out.println("------------Enter order information "+i+"---------------");
            inputCompany();
        }
        System.out.println("----------------------------------------------------");
    }
    public void billWithCompany(){
        for(Company company: listCompany){
            System.out.println("--------------------------------------------------------Bill With Company---------------------------------------------------------");
            System.out.printf("\n %3s %14s %14s %20s %12s","ID","Name","Address","Email","Phone");
            System.out.printf("\n %3s %14s %14s %20s %12s",company.getId(),company.getNameCompany(),company.getAddress(),company.getEmail(),company.getPhone());
            System.out.println("\n------------------------------------------------------------Items-----------------------------------------------------------------");
            System.out.printf("\n %8s %14s %8s %18s %18s %18s %35s","ID Item","Name Item"," Amount","Import Price(VNĐ)","Sale Prive(VNĐ)","total money(VNĐ)","total amount after promotion(VNĐ)");
            float payment=0;
            for (Items items : company.getListItems()) {
                System.out.printf("\n %8d %14s %8d %18.1f %18.1f %18.1f %35.1f",items.getId(),items.getName(),items.getAmount(),items.getImportPrice(),items.getSaleprice(),items.getTotalMoney(),items.getTotalAmountAfterPromotion());
                payment=payment+items.getTotalAmountAfterPromotion();
            }
            println();
            System.out.println("payment(VNĐ): "+ payment);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    public void showCompany(){
        System.out.println("----------------------------------------------Show Company-----------------------------------------------");
        int i=1;
        for(Company company: listCompany){
            println();
            System.out.println("------------------------------------------------Company "+i+"------------------------------------------------");
            System.out.printf("\n %3s %14s %14s %20s %12s","ID","Name","Address","Email","Phone");
            System.out.printf("\n %3s %14s %14s %20s %12s",company.getId(),company.getNameCompany(),company.getAddress(),company.getEmail(),company.getPhone());
            println();
            System.out.println("-------------------------------------------------Items---------------------------------------------------");
            for (Items items : company.getListItems()){
                System.out.println("\n");
                System.out.printf("\n %5s %10s %7s %18s %18s","ID Items","name Items","amount","import Price(VNĐ)","sale Price(VNĐ)");
                System.out.printf("\n %5s %10s %7s %18.1f %18.1f",items.getId(),items.getName(),items.getAmount(),items.getImportPrice(),items.getSaleprice());
            }
            i+=1;
        }
        println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
    public void showItems(){
        System.out.println("-------------------------------------------------SHOW ITEMS-------------------------------------------------");
        System.out.printf("\n %5s %10s %7s %17s %16s %16s %30s","ID","name","amount","importPrice(VNĐ)","saleprice(VNĐ)","total money(VNĐ)", "total amount after promotion");
        for(Items i: listItems){
            System.out.printf("\n %5d %10s %7d %17.1f %16.1f %16.1f %30.1f",i.getId(),i.getName(),i.getAmount(),i.getImportPrice(),i.getSaleprice(),i.getTotalMoney(),i.getTotalAmountAfterPromotion());
            listTotalMoney.add(i.totalMoney(percent));
        }
        println();
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

    public int searchIdItems(int id){
        for (Company company : listCompany) {
            for(Items items: company.getListItems()){
                if(items.getId()==id){
                    return company.getListItems().indexOf(items);
                }
            }
        }
         return(-1);
    }
    public int searchIdCompany(int id){
        for (Company company : listCompany) {
            for(Items items: company.getListItems()){
                if(items.getId()==id){
                    return listCompany.indexOf(company);
                }
            }
        }
        return(-1);
    }
    public int searchNameItems(String name){
        for(Company company: listCompany){
            for(Items items: company.getListItems()){
                if(name.equals(items.getName())){
                    return company.getListItems().indexOf(items);
                }
            }
        }
        return(-1);
    }
    public int searchNameCompany(String name){
        for(Company company: listCompany){
            for(Items items: company.getListItems()){
                if(name.equals(items.getName())){
                    return listCompany.indexOf(company);
                }
            }
        }
        return(-1);
    }
    public int searchCompanyId(int id){
        for (Company company : listCompany) {
            if(id==company.getId()){
                return listCompany.indexOf(company);
            }
        }
        return(-1);
    }
    public int searchCompanyName(String name){
        for(Company company: listCompany){
            if(name.equals(company.getNameCompany())){
                return listCompany.indexOf(company);
            }
        }
        return(-1);
    }
    public int searchItemsIdOfCompany(int i, int id){
        for(Items items:listCompany.get(i).getListItems()){
            if(id==items.getId()){
                return listCompany.get(i).getListItems().indexOf(items);
            }
        }
        return -1;
    }
    public int searchItemsByName(String name){
        for(Items items: listItems){
            if(name.equals(items.getName())){
                return listItems.indexOf(items);
            }
        }
        return(-1);
    }
    public void showSearchItems(int i, int j){
        if (i!=-1){
            System.out.println("-----------------------------------------ITEMS-----------------------------------------------");
            System.out.printf("\n %8s %14s %8s %18s %18s %20s","ID Item","Name Item"," Amount","Import Price(VNĐ)","Sale Prive(VNĐ)","Name Company");
            System.out.printf("\n %8d %14s %8d %18.1f %18.1f %20s",listCompany.get(j).getListItems().get(i).getId(),listCompany.get(j).getListItems().get(i).getName(),listCompany.get(j).getListItems().get(i).getAmount(),listCompany.get(j).getListItems().get(i).getImportPrice(),listCompany.get(j).getListItems().get(i).getSaleprice(),listCompany.get(j).getNameCompany());
        }
        else
        error();
        println();
    }
    public void showSearchCompany(int i){
        if (i!=-1){
            System.out.println("--------------------------------COMPANY---------------------------------");
            System.out.printf("\n %3s %14s %14s %20s %12s","ID","Name","Address","Email","Phone");
            System.out.printf("\n %3s %14s %14s %20s %12s",listCompany.get(i).getId(),listCompany.get(i).getNameCompany(),listCompany.get(i).getAddress(),listCompany.get(i).getEmail(),listCompany.get(i).getPhone());
            println();
            System.out.println("---------------------------------ITEMS----------------------------------");
            System.out.printf("\n %8s %14s %8s %18s %18s","ID Item","Name Item"," Amount","Import Price(VNĐ)","Sale Prive(VNĐ)");
            for (Items items:listCompany.get(i).getListItems()){
                System.out.printf("\n  %8s %14s %8s %18s %18s",items.getId(),items.getName(),items.getAmount(),items.getImportPrice(),items.getSaleprice());
            }
        }
        else
        error();
        println();
    }
    public void searchingByIdItems(){
        System.out.println("---------------------------------SEARCHING BY ID ITEMS---------------------------------------");
        System.out.println("");
        System.out.print("Enter the ID of the Items to be search: ");
        id=Check.checkInt();
        int j=searchIdCompany(id);
        int i=searchIdItems(id);
        showSearchItems(i, j);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    public void searchingByNameItems(){
        System.out.println("--------------------------------SEARCHING BY NAME ITEMS--------------------------------------");
        System.out.print("Enter the Name Items of the item to be search: ");
        name=Check.isName();
        int j=searchNameCompany(name);
        int i=searchNameItems(name);
        showSearchItems(i, j);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    public void searchingByIdCompany(){
        System.out.println("------------------------SEARCHING BY ID COMPANY-------------------------");
        System.out.print("Enter the ID of the Company to be search: ");
        id=Check.checkInt();
        int i=searchCompanyId(id);
        showSearchCompany(i);
        System.out.println("------------------------------------------------------------------------");
    }
    public void searchingByNameCompany(){
        System.out.println("-----------------------SEARCHING BY NAME COMPANY------------------------");
        System.out.print("Enter the name of the company you want to search for: ");
        name=Check.isName();
        int i=searchCompanyName(name);
        showSearchCompany(i);
        System.out.println("------------------------------------------------------------------------");
    }
    public void sortItemsByID(){
        Items items;
        for(int i=0;i<listItems.size()-1;i++){
            for(int j=i;j<listItems.size();j++){
                if(listItems.get(i).getId()>listItems.get(j).getId()){
                    items=listItems.get(i);
                    listItems.set(i,listItems.get(j));
                    listItems.set(j,items);
                }
            }
        }
    }
    public void sortItemsByName(){
        Items items;
        for (int i = 0; i < listItems.size(); i++){
            for (int j =listItems.size() - 1; j > i; j--){
                if(listItems.get(j).getName().compareTo(listItems.get(j-1).getName()) < 0 ){
                    items = listItems.get(j);
                    listItems.set(j, listItems.get(j - 1));
                    listItems.set(j - 1, items);
                }
            }
        }
    }
    public void sortItemsByImportPrice(){
        Items items;
        for(int i=0;i<listItems.size()-1;i++){
            for(int j=i;j<listItems.size();j++){
                if(listItems.get(i).getImportPrice()<listItems.get(j).getImportPrice()){
                    items=listItems.get(i);
                    listItems.set(i,listItems.get(j));
                    listItems.set(j,items);
                }
            }
        }
    }
    public void sortCompanyById(){
        Company company;
        for(int i=0;i<listCompany.size()-1;i++){
            for(int j=i;j<listCompany.size();j++){
                if(listCompany.get(i).getId()>listCompany.get(j).getId()){
                    company=listCompany.get(i);
                    listCompany.set(i,listCompany.get(j));
                    listCompany.set(j,company);
                }
            }
        }
    }
    public void sortCompanyByName(){
        Company company;
        for(int i=0;i<listCompany.size();i++){
            for(int j=listCompany.size()-1;j>i;j--){
                if(listCompany.get(j).getNameCompany().compareTo(listCompany.get(j-1).getNameCompany()) < 0 ){
                    company=listCompany.get(j);
                    listCompany.set(j,listCompany.get(j-1));
                    listCompany.set(j-1,company);
                }
            }
        }
    }
    public void updateCompany(int i){
      
        if(i!=-1){
            Company company=listCompany.get(i);
            id=checkIdCompany();
            System.out.print("Enter the Company name: ");
            name=Check.isName();
            System.out.print("Enter the Company address: ");
            String address=sc.nextLine();
            System.out.print("Enter the Company email: ");
            email=Check.isEmail();
            System.out.print("Enter the Company phone: ");
            phone=Check.isPhone();
            company.setId(id);
            company.setNameCompany(name);
            company.setAddress(address);
            company.setEmail(email);
            company.setPhone(phone);
        }
        else
        error();
        println();
    }
    public void updateItems(int i, int j){
        if(i!=-1){
            id=checkIdItems();
            System.out.print("Enter the item name: ");
            name=Check.isName();
            System.out.print("Enter the item amount: ");
            amount=Check.checkInt();
            System.out.print("Enter the item import Price: ");
            importPrice=Check.checkFloat();
            System.out.print("Enter the item sale price: ");
            saleprice=Check.checkFloat();
            Items items= listCompany.get(j).getListItems().get(i);
            if(amount<20){
                percent=0;
            }
            else if(amount<50){
                percent=1;
            }
            else if(amount<=100){
                percent=5;
            }
            else{
                percent=10;
            }
            items.setId(id);
            items.setName(name);
            items.setAmount(amount);
            items.setImportPrice(importPrice);
            items.setSaleprice(saleprice);
            items.setTotalMoney(items.totalMoney());
            items.setTotalAmountAfterPromotison(items.totalMoney(percent));
        }
        else
        error();
        println();
    }
    public void updateCompanyById(){
        System.out.println("-----------------UPDATE COMPANY BY ID------------------");
        System.out.print("Enter the company id you want to update: ");
        id=Check.checkInt();
        int i=this.searchCompanyId(id);
        updateCompany(i);
        System.out.println("-------------------------------------------------------");
    }
    public void updateCompanyByName(){
        System.out.println("----------------UPDATE COMPANY BY NAME-----------------");
        System.out.print("Enter the company name you want to update: ");
        name=Check.isName();
        int i=searchCompanyName(name);
        updateCompany(i);
    }
    public void updateItemsById(){
        System.out.println("------------------UPDATE ITEMS BY ID-------------------");
        System.out.print("Enter the items id you want to update: ");
        id=Check.checkInt();
        int i=searchIdItems(id);
        int j=searchIdCompany(id);
        updateItems(i,j);
        System.out.println("-------------------------------------------------------");
    }
    public void updateItemsByName(){
        System.out.println("-----------------UPDATE ITEMS BY NAME------------------");
        System.out.print("Enter the items name you want to update: ");
        name=Check.isName();
        int i=searchNameItems(name);
        int j=searchNameCompany(name);
        updateItems(i, j);
        System.out.println("-------------------------------------------------------");
    }
    public void removeCompany(int i){
        if (i!=-1){
            for(Items items: listCompany.get(i).getListItems()){
                for (int j=0;j<listItems.size();j++) {
                    if(items.getId()==listItems.get(j).getId()){
                        listItems.remove(j);
                    }
                }
            }
            listCompany.remove(i);
            System.out.println("DELETE DONE");
        }
        else
        error();
        println();
    }
    public void removeItems(int i, int j){
        if(i!=-1){
            for (int k=0;k<listItems.size();k++) {
                if(listCompany.get(j).getListItems().get(i).getId()==listItems.get(k).getId()){
                    listItems.remove(k);
                }
            }
            listCompany.get(j).getListItems().remove(i);
            System.out.println("DELETE DONE");
        }
        else
        error();
        println();
    }
    public void removeCompanyByID(){
        System.out.println("----------------REMOVE COMPANY BY ID----------------");
        System.out.print("Enter the ID of the Company to be remove: ");
        id=Check.checkInt();
        int i=searchCompanyId(id);
        removeCompany(i);
        System.out.println("----------------------------------------------------");
    }
    public void removeCompanyByName(){
        System.out.println("---------------REMOVE COMPANY BY NAME---------------");
        System.out.print("Enter the Name of the Company to be remove: ");
        name=Check.isName();
        int i=searchCompanyName(name);
        removeCompany(i);
        System.out.println("----------------------------------------------------");
    }
    public void removeItemsByID(){
        System.out.println("-----------------REMOVE ITEMS BY ID-----------------");
        System.out.print("Enter the ID of the Items to be remove: ");
        id=Check.checkInt();
        int i=searchIdItems(id);
        int j=searchIdCompany(id);
        removeItems(i, j);
        System.out.println("----------------------------------------------------");
    }
    public void removeItemsByName(){
        System.out.println("----------------REMOVE ITEMS BY NAME----------------");
        System.out.print("Enter the Name of the Items to be remove: ");
        name=Check.isName();
        int i=searchNameItems(name);
        int j=searchNameCompany(name);
        removeItems(i, j);
        System.out.println("----------------------------------------------------");
    }
    public void order(){
        System.out.println("---------------------Order----------------------");
        int checkItems= listItems.size();
        if(checkItems==0){
            System.out.println("The store is currently out of stock");
            return;
        }
        System.out.print("Enter customer name: ");
        name=Check.isName();
        System.out.print("Enter customer phone: ");
        phone=Check.isPhone();
        System.out.print("Enter purchase date: ");
        String date=Check.isDate();
        Customer customer = new Customer(idCustomer,name, phone,date);
        idCustomer+=1;
        System.out.print("Enter the number of items you want to buy: ");
        number=Check.checkInt();
        int key=1;
        float payment=0;
        while(key<=number){
            while(true){
                System.out.print("Enter item name: ");
                name=Check.isName();
                if (searchItemsByName(name) != -1) break;//lỗi chưa sửa
                errorTry_Catch();
            }
            int j = searchItemsByName(name);
            if (listItems.get(j).getAmount()==0){
                System.out.println("Item is out of stock! Please choose to buy another item");
            }
            else{
                while(true){
                    try {
                        System.out.print("Enter item amount: ");
                        amount=Integer.parseInt(sc.nextLine());
                        if( amount>0 && amount<=listItems.get(j).getAmount()){
                            listItems.get(j).setAmount(listItems.get(j).getAmount()-amount);
                            break;
                        }
                        errorTry_Catch();
                    } catch (Exception e) {
                        errorTry_Catch();
                    }
                }
                Float totalMoney = listItems.get(j).getSaleprice()*amount;
                Order order= new Order(name, amount, totalMoney);
                customer.getListOrder().add(order);
                key+=1;
                payment=payment+totalMoney;
            }
        }
        listCustomers.add(customer);
        listPayment.add(payment);
    }
    public void bill(){
        for (Customer customer : listCustomers) {
            System.out.println("---------------------Bill----------------------");
            System.out.printf("\n %3s %10s %14s %14s ","ID","name","phone","purchase date" );
            System.out.printf("\n %3s %10s %14s %14s ",customer.getId(),customer.getCustomerName(),customer.getPhone(),customer.getPurchaseDate());
            System.out.printf("\n %4s %10s %8s %14s ","STT","name Item","amount","total Money");
            int i=0;
            float payment=0;
            for (Order order : customer.getListOrder()) {
                i+=1;
                System.out.printf("\n %4S %10s %8s %14s ",i,order.getName(),order.getAmount(),order.getTotalMoney());
                payment=payment+order.getTotalMoney();
            }
            println();
            System.out.println("Payment: "+payment);
            System.out.println("-----------------------------------------------");
        }
    }
    public void inventory(){
        System.out.println("---------------------Inventory----------------------");
        System.out.printf("\n %3s %10s %10s","ID","Name","Amount");
        for(Items i: listItems){
            System.out.printf("\n %3d %10s %10d", i.getId(),i.getName(),i.getAmount());
        }
        println();
        System.out.println("----------------------------------------------------");
    }
    public void turnover(){
        System.out.println("---------------------Turnover----------------------");
        turnover=0;
        for (float i : listPayment){
            turnover=turnover+i;
        }
        System.out.println("Turnover(VNĐ): "+turnover);
        System.out.println("----------------------------------------------------");
    }
    public void profit(){
        float totalExpense=0;
        for (Customer customer : listCustomers){
            float expense;
            for (Order order : customer.getListOrder()){
                int j=searchItemsByName(order.getName());
                expense = order.getAmount()* listItems.get(j).getImportPrice();
                listExpense.add(expense);
            }
        }
        for(float x: listExpense){
            totalExpense=totalExpense+x;
        }
        // for(float i: listPayment){
        //     turnover=turnover+i;
        // }
        float profit=turnover-totalExpense;
        System.out.println("---------------------Profit----------------------");
        System.out.println("Profit(VNĐ): "+profit);
        System.out.println("-------------------------------------------------");
    }
}

