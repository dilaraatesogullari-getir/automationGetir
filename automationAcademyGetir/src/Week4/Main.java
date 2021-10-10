package Week4;

import java.util.*;
public class Main {
    public static double totalPrice = 0.0;
    public static double basket = 0.0;
    public static boolean flag=false;
    public static String password;
    public static String username;
    public static ArrayList basketSummary = new ArrayList();

    public static void main(String[] args) {
        login();
    }

    public static void mainMenu() {
        ArrayList menu = new ArrayList();
        menu.add("1.Ana Menü");
        menu.add("2.Arama");
        menu.add("3.Profil");
        menu.add("4.Sepet");

        System.out.println("Menü:  " + menu);
        System.out.println("İstediğiniz seçeneğin numarasını giriniz: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case (1): {
                mainCategory();
                break;
            }
            case (2): {
                ArrayList searchResult = new ArrayList();
                searchResult.addAll(search());
                for (int i = 0; i < searchResult.size(); i++) {
                    System.out.println(i + ". " + searchResult.get(i).toString() + " ");

                }

                System.out.println("Seçmek istediğiniz product'ın numarasını girin:  ");
                Scanner scan = new Scanner(System.in);
                int productOption = scan.nextInt();
                if (productOption == productOption) {
                    getProductDetail(searchResult.get(productOption).toString());
                }
                break;
            }
            case (3): {
                Client client = userCheck(username, password);
                client.printClientInfo();
                System.out.println("Kullanıcı değiştirmek  için 1'e , Ana Menü'ye dönmek için 2 ye basınız.");
                Scanner scan = new Scanner(System.in);
                int selectPage = scan.nextInt();
                if (selectPage == 1) {
                    login();
                }

                if (selectPage == 2) {
                    mainMenu();
                }
                break;
            }
            case (4): {
                getBasket(0.0);
                showBasket();
                break;
            }
        }
    }

    public static void mainCategory() {

        ArrayList arr = new ArrayList();
        arr.add("Meyve & Sebze");
        arr.add("Atıştırmalık");
        arr.add("Kahvaltılık");
        arr.add("Sepet");
        arr.add("Arama");

        System.out.println(arr);

        System.out.println("İstediğiniz seçeneğin numarasını girinizzzzz: ");
        Scanner scanner = new Scanner(System.in);
        int suboption = scanner.nextInt();
        subCategory(suboption);
    }

    public static void subCategory(int suboption) {

        switch (suboption) {
            case (1): {
                System.out.println("Meyve");
                System.out.println("Sebze");
                break;
            }
            case (2): {
                System.out.println("Cips");
                System.out.println("Çikolata");
                break;
            }
            case (3): {
                System.out.println("Süt");
                System.out.println("Şarküteri");
                break;
            }
            case (4): {
                getBasket(0.0);
                break;
            }
            case (5): {
                search();
                break;
            }
        }
        if (suboption <= 3) {
            System.out.println("İstediğiniz seçeneğin ismini giriniz: ");
            Scanner scanner = new Scanner(System.in);
            String productOption = scanner.next().toLowerCase();
            getProduct(productOption);
        }

    }

    public static void getProduct(String productOption) {

        switch (productOption) {
            case ("meyve"): {
                System.out.println("Elma");
                System.out.println("Armut");
                System.out.println("Üzüm");
                break;
            }
            case ("sebze"): {
                System.out.println("Domates");
                System.out.println("Biber");
                System.out.println("Patlıcan");
                break;
            }
            case ("cips"): {
                System.out.println("Lays");
                System.out.println("Doritos");
                System.out.println("Ruffles");
                break;
            }
            case ("çikolata"): {
                System.out.println("Tadelle");
                System.out.println("Albeni");
                System.out.println("Metro");
                System.out.println("Hobby");
                break;
            }
            case ("süt"): {
                System.out.println("Tam Yağlı");
                System.out.println("Az Yağlı");
                System.out.println("Laktozsuz");
                break;
            }
            case ("şarküteri"): {
                System.out.println("Kaşar");
                System.out.println("Peynir");
                System.out.println("Salam");
                System.out.println("Sucuk");
                System.out.println("Zeytin");
                break;
            }
            case ("Sepet"): {
                getBasket(0.0);
                showBasket();
                break;
            }
        }
        System.out.println("İstediğiniz ürünün ismini giriniz: ");
        Scanner scan = new Scanner(System.in);
        String productDetail = scan.next().toLowerCase();
        getProductDetail(productDetail);
    }

    public static void getBasket(double newAddedPrice) {
        basket = basket + newAddedPrice;
        System.out.println("Sepet Tutarı: " + basket);

    }

    public static ArrayList search() {
        ArrayList productList = new ArrayList();
        Collections.addAll(productList, "Elma", "Armut", "Üzüm", "Domates", "Biber", "Patlıcan",
                "Lays", "Doritos", "Ruffles", "Tadelle", "Albeni", "Metro", "Hobby", "Tam Yağlı", "Az Yağlı",
                "Laktozsuz", "Kaşar", "Peynir", "Salam", "Zeytin");
        ArrayList searchResult = new ArrayList();

        System.out.println("Aramak istediğniz kelimeyi giriniz: ");

        Scanner scan = new Scanner(System.in);
        String searchKey = scan.next().toLowerCase();
        int wordSize = searchKey.length();

        if (wordSize >= 3) {
            for (int i = 0; i < productList.size(); i++) {
                String productSearch = productList.get(i).toString();
                if (productSearch.toLowerCase().contains(searchKey)) {
                    searchResult.add(productSearch);
                }
            }
        } else {
            System.out.println("Arama kelimesi 3 karakterden fazla olmalı.");
            search();
        }
        return (searchResult);
    }

    public static void getProductDetail(String name) {
        Double price = getPrice();
        Double discountedPrice = getDiscountedPrice(price);
        Product product = new Product(name, name, price, discountedPrice);
        product.printProduct();

        basketSummary.add(product);

        System.out.println("Eklemek istediğiniz adeti girin:");
        Scanner scan = new Scanner(System.in);
        int productDetail = scan.nextInt();
        addProduct(productDetail, product);

    }

    public static double getPrice() {
        Random random = new Random();
        double generatedDouble = random.nextInt(100) + 1;
        return (generatedDouble);

    }

    public static double getDiscountedPrice(double price) {

        int value = (int) price;
        Random random = new Random();
        double generatedDouble = random.nextInt(value - 1) + 1;
        return (generatedDouble);

    }

    public static void addProduct(int amount, Product product) {

        Double price = product.discountedPrice;
        totalPrice = price * amount;

        if (totalPrice<100)
        {
            System.out.println("Sepet tutarı 100 TL altında olduğundan dolayı 5TL getirme ücreti eklenmiştir.");
            totalPrice=totalPrice+5;
        }
        else
        {
            System.out.println("Sepet tutarı 100 TL üstünde olduğundan dolayı getirme ücreti alınmayacaktır.");

        }
        System.out.println("Total Amount: " + totalPrice);

        System.out.println("Sepet görüntülemek için 1'e , Ana Menü'ye dönmek için 2 ye basınız.");
        Scanner scan = new Scanner(System.in);
        int selectPage = scan.nextInt();
        if (selectPage == 1) {
            getBasket(totalPrice);
            showBasket();
        }

        if (selectPage == 2) {
            mainMenu();
        }
    }

    public static void login() {
        System.out.println("Kullanıcı Adını Giriniz: ");
        Scanner name = new Scanner(System.in);
        username = name.next();

        System.out.println("Kullanıcı Şifresini Giriniz: ");
        Scanner pwd = new Scanner(System.in);
        password = pwd.next();

        Client client = userCheck(username, password);

        if (flag == true) {
            mainMenu();
        } else {
            System.out.println("Yanlış username yada şifre yeniden tekrar deneyiniz.");
            login();
        }
    }

    public static Client userCheck(String username, String pwd) {
        ArrayList nameList = new ArrayList();
        nameList.add("Ahmet");
        nameList.add("Mehmet");
        nameList.add("Ayse");
        nameList.add("Fatma");
        nameList.add("Hayriye");

        ArrayList usernameList = new ArrayList();
        usernameList.add("ahmet");
        usernameList.add("mehmet");
        usernameList.add("ayse");
        usernameList.add("fatma");
        usernameList.add("hayriye");

        ArrayList passwordList = new ArrayList();
        passwordList.add("1234");
        passwordList.add("1234+");
        passwordList.add("12345");
        passwordList.add("A12345+");
        passwordList.add("1234");

        ArrayList phoneList = new ArrayList();
        phoneList.add("05552909999");
        phoneList.add("05552909998");
        phoneList.add("02121682898");
        phoneList.add("01111111111");
        phoneList.add("09999999999");

        ArrayList addressList = new ArrayList();
        addressList.add("İstanbul /Avcılar");
        addressList.add("Kocaeli / Gebze");
        addressList.add("Konya /Selçuklu");
        addressList.add("Ordu / Ünye");
        addressList.add("Samsun /Çarşamba");

        for (int i = 0; i < nameList.size(); i++) {
            if (username.equals(usernameList.get(i).toString()) && pwd.equals(passwordList.get(i).toString())) {
                Client client = new Client(usernameList.get(i).toString(), nameList.get(i).toString(),
                        passwordList.get(i).toString(), addressList.get(i).toString(), phoneList.get(i).toString());
                flag=true;
                return client;
            }
        }
        return null;
    }

    public static void showBasket()
    {
        System.out.println("Basket Detail: " );
        for(int k=0;k<basketSummary.size();k++)
        {
            new Product();
            Product item = (Product) basketSummary.get(k);
            item.printProduct();
        }
    }
}
