package battleship_game;

public class ToolStore extends NormalLocation {
    ToolStore(Player player) {
        super(player, "Store");
    }
    public boolean getLocation(){
        System.out.println("Money: $"+ player.getMoney());
        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("3- Exit");
        System.out.print("Your Selection: ");
        int selectTool=scan.nextInt();
        int selectItemId;
        switch (selectTool){
            case 1:
                selectItemId=weaponMenu();
                buyWeapon(selectItemId);
                break;
            case 2: selectItemId=armorMenu();
            buyArmor(selectItemId);
            break;



        }

        return true;
    }
    public int armorMenu(){
                                //
        System.out.println("1-  Small  ->Money: $15 - Damage: ->1");
        System.out.println("2-  Medium ->Money: $25 - Damage: ->3");
        System.out.println("3-  Heavy  ->Money: $40 - Damage: ->7");
        System.out.println("4-  Exit");
        System.out.print("Please select a weapon: ");
        int selectArmorId=scan.nextInt();
        return selectArmorId;

    }
    public void buyArmor(int itemId){

        int avoid=0,itemPrice=0;
        String armorName=null;
        switch (itemId){
            case 1:
                avoid = 1;
                armorName = "Level 1";
                itemPrice = 15;
                break;
            case 2:
                avoid = 3;
                armorName = "Level 2";
                itemPrice = 25;
                break;
            case 3:
                avoid=5;
                armorName="Level 3";
                itemPrice=40;
                break;
            case 4:
                System.out.println("Exiting!!!");
                break;
            default:
                System.out.println("Invalid entry!");
                break;
        }
        if(itemPrice>0){
            if(player.getMoney()>=itemPrice ) {
                player.getInventory().setArmor(avoid);
                player.getInventory().setArmorName(armorName);
                player.setMoney(player.getMoney()-itemPrice);
                System.out.println("You bought "+ armorName+". prevented damage: "+  player.getInventory().getArmor());
                System.out.println("Change: $" +player.getMoney());
            }else{
                System.out.println("Insufficient amount");
            }

        }


    }

    public int weaponMenu(){
        System.out.println("1-  Gun   <Money: $25 - Damage: 2>");
        System.out.println("2-  Sword <Money: $35 - Damage: 3>");
        System.out.println("3-  Rifle <Money: $45 - Damage: 7>");
        System.out.println("4-  Exit");
        System.out.print("Please select a weapon: ");
        int selectWeaponId=scan.nextInt();
        return selectWeaponId;


    }
    public void buyWeapon(int itemId){
        int damage=0,itemPrice=0;
        String weaponName=null;
        switch (itemId){
            case 1:
                damage=2;
                weaponName="Gun";
                itemPrice=25;
                break;
            case 2:
                damage=3;
                weaponName="Sword";
                itemPrice=35;
                break;
            case 3:
                damage=7;
                weaponName="Rifle";
                itemPrice=45;
                break;
            case 4:
                System.out.println("Exiting!!!");
                break;
            default:
                System.out.println("Invalid entry!");
                break;
        }
        if(itemPrice>0){
            if(player.getMoney()>=itemPrice ) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney()-itemPrice);
                System.out.println("You bought a new weapon: "+weaponName+ ", previous damage: "+ player.getDamage()+", new damage: "
                       + player.getTotalDamage());
                System.out.println("Change: $" +player.getMoney());
            }else{
                System.out.println("Insufficient amount");
            }

        }
    }
}
