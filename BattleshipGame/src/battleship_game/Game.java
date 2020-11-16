package battleship_game;

import java.util.Scanner;
public class Game {

        Player player;
        Location location;
        Scanner scan=new Scanner(System.in);

        public void login(){
            Scanner scan=new Scanner(System.in);
            System.out.println("Welcome to Survival Game!");
            System.out.print("Please Enter Your Name : ");
            String playerName=scan.nextLine();
            player =new Player(playerName);
            player.selectChar();
            start();
        }
        public void start(){
            while(true){

                System.out.println();
                System.out.println();
                System.out.println("-----------------LOCATIONS------------------------");
                System.out.println("Please Select your location:");
                System.out.println("1- Safe house --> Safe location, no enemy!");
                System.out.println("2- Cave       --> You may encounter a zombi!");
                System.out.println("3- Jungle     --> You may encounter a vampire!");
                System.out.println("4- River      --> You may encounter a bear!"   );
                System.out.println("5- Store      --> You can buy a weapon or an armor!"  );
                System.out.println("Please select a location:");
                int selectLocation=scan.nextInt();
                while(selectLocation < 0||selectLocation > 5){
                    System.out.println("Please select a valid location!");
                    selectLocation=scan.nextInt();
                }
                switch (selectLocation){
                    case 1:
                        location=new SafeHouse(player);
                        break;
                    case 2:
                        location= new Cave(player);
                        break;
                    case 3:
                        location=new Forest(player);
                        break;
                    case 4:
                        location=new River(player);
                        break;
                    case 5:
                        location = new ToolStore(player);
                        break;
                    default:
                        location=new SafeHouse(player);

                }
                if(location.getClass().getName().equals("Safe House")){
                    if(player.getInventory().isFirewood()&& player.getInventory().isFood()&&player.getInventory().isWater()){
                        System.out.println("CONGRATULATIONS, YOU WON THE GAME!!!");
                        break;
                    }

                }
                if(!location.getLocation()){
                    System.out.println("Game over!");
                    break;
                }
            }
        }
    }


