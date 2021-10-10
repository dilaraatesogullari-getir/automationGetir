package Week4;

public class Client {

        String name = null;
        String username = null;
        String password=null;
        String address=null;
        String phoneNumber=null;

        public Client()
        {
            this.username = username;
            this.name = name;
            this.password = password;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }


        public Client(String username, String name, String password, String address,String phoneNumber)
        {
            this.username = username;
            this.name = name;
            this.password = password;
            this.address = address;
            this.phoneNumber=phoneNumber;
        }
        public void printClientInfo() {
            System.out.println("Client Name:" + this.name + " Client Username:" + this.username +  " Client Address:" + this.address + " Client  Phone Number:" + this.phoneNumber + " Client  Password:" + this.password);
        }

}
