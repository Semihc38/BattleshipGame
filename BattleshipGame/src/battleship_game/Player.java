package battleship_game;

import java.util.Scanner;

public class Player {
    Scanner scan=new Scanner(System.in);

    private int damage,health,money,defaultHealth;
    private String name, charName;
    private Inventory inventory;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int charMenu(){
        System.out.println("----------------CHARACTERS-------------------------");
        System.out.println("1- Samurai  Damage: 5 Health: 21 Money: 15");
        System.out.println("2- Archery  Damage: 7 Health: 18 Money: 20");
        System.out.println("3- Knight   Damage: 8 Health: 24 Money: 5");
        System.out.print("\nYour selection: ");
        int charId=scan.nextInt();

        while(charId < 1 || charId > 3){
            System.out.print("Please select a valid character");
            charId=scan.nextInt();
        }

        return charId;

    }
    public void selectChar(){
        switch (charMenu()){

            case 1:
                player("Samurai",5,21,15);
                break;

            case 2:
                player("Archery",7,18,20);
                break;

            case 3:
                player("Knight",8,24,5);
                break;
        }
        System.out.print("Fighter: "+getCharName()+"\t Damage:"+getDamage()+"\t Health:"+getHealth()+"\t Money:"+getMoney());
    }
    public int getTotalDamage(){
        return this.getDamage()+this.getInventory().getDamage();


    }
    public void player(String name,int damage,int health,int money){
        setCharName(name);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setDefaultHealth(health);
    }
    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


}
