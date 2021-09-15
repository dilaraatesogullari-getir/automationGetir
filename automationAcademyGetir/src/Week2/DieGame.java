package Week2;

import java.util.Random;

public class DieGame {

    public static void main(String[] args) {

        Random random = new Random();
        int die= 0;
        boolean flag=true;
        int earning=0;

        while (flag==true) {
            die = random.nextInt(6) + 1;
            System.out.println("Die Result:" + die);
                switch (die){
                    case (1):
                    case (2):
                    {
                        System.out.println("Die is "+die+" Game Over");
                        flag=false;
                        break;
                    }
                    case (3):
                    {
                        System.out.println("You did not earn money. But you can roll dice again.");
                        flag=true;
                        break;
                    }
                    case (4):
                    {
                        earning = earning+4;
                        System.out.println("You earn "+earning+ ". You can roll dice again.");
                        if(earning<50)
                        {
                            flag=true;
                        }
                        else
                        {
                            System.out.println("You earn "+earning+ ". You reach maximum amount.");
                            flag=false;
                        }
                        break;
                    }
                    case (5):
                    {
                        earning = earning+5;
                        System.out.println("You earn "+earning+ ". You can roll dice again.");
                        if(earning<50)
                        {
                            flag=true;
                        }
                        else
                        {
                            System.out.println("You earn "+earning+ ". You reach maximum amount.");
                            flag=false;
                        }
                        break;
                    }
                    case (6):
                    {
                        earning = earning+6;
                        System.out.println("You earn "+earning+ ". You can roll dice again.");
                        if(earning<50)
                        {
                            flag=true;
                        }
                        else
                        {
                            System.out.println("You earn "+earning+ ". You reach maximum amount.");
                            flag=false;
                        }
                        break;
                    }
                }

        }
    }
}



