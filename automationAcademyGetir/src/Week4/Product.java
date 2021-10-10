package Week4;

public class Product {


        String name = null;
        String decription = null;
        double price=0.0;
        double discountedPrice=0.0;

        public Product()
        {
            this.decription = decription;
            this.name = name;
            this.price = price;
            this.discountedPrice = discountedPrice;
        }


        public Product(String decription, String name, double price, double discountedPrice)
        {
            this.decription = decription;
            this.name = name;
            this.price = price;
            this.discountedPrice = discountedPrice;
        }
        public void printProduct() {
            System.out.println("Product Name:" + this.name + " Description:" + this.decription +  " Price:" + this.price + " Discounted Price:" + this.discountedPrice );
        }

}
