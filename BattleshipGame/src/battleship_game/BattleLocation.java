package battleship_game;

public abstract class BattleLocation extends Location {
   protected Obstacle obstacle;
   protected String award;
    BattleLocation(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;

    }
    @Override
    public boolean getLocation(){
        int obsCount = obstacle.obstacleCount();
        System.out.println("You are now at "+ this.getName());
        System.out.println("Be careful! There are "+ obsCount+" " +obstacle.getName()+"(s) live in here!");
        System.out.println("<F>ight or <R>un away");
        String selectCase=scan.nextLine();
        selectCase=selectCase.toUpperCase();
        if(selectCase.equals("F")){
            if(combat(obsCount)){
                System.out.println("You killed your enemy at "+ this.getName());
                if(this.award.equals("Food") && player.getInventory().isFood()==false){
                    System.out.println("You are rewarded with "+this.award);
                    player.getInventory().setFood(true);
                }else if(this.award.equals("Water") && player.getInventory().isWater()==false){
                    System.out.println("You are rewarded with "+this.award);
                    player.getInventory().setWater(true);
                }else if(this.award.equals("Firewood") && player.getInventory().isFirewood()==false) {
                    System.out.println("You are rewarded with " + this.award);
                    player.getInventory().setFirewood(true);
                }
                return true;
            }if(player.getHealth()<=0){
                System.out.println("You died :(");
                return false;
            }
        }

        return true;
    }
    public boolean combat(int obsCount){
    int defaultObstacleHealth=obstacle.getHealth();

        for(int i =0;i <obsCount; i++){
            playerStatus();
            enemyStatus();
            while (player.getHealth()>0 && obstacle.getHealth()>0){
                System.out.println("--<A>ttack or <R>un-- ");
                String selectCase=scan.nextLine();
                selectCase=selectCase.toUpperCase();
                if(selectCase.equals("A")){
                    System.out.println("You attacked your enemy!!!");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealth()>0)
                    System.out.println();
                    System.out.println("Your enemy attacked you!");
                    player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInventory().getArmor()));
                    afterHit();

                }else {
                    return false;
                }
            }
            if (obstacle.getHealth()< player.getHealth()){
                System.out.println("You killed your enemy!");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Your current money: "+ player.getMoney());
                obstacle.setHealth(defaultObstacleHealth);
            }else {
                return false;
            }
            System.out.println("--------------------------------------");
        }
        return true;

    }
    public void playerStatus(){
        System.out.println("Player status\n-----------");
        System.out.println("Health: "+ player.getHealth());
        System.out.println("Damage: "+ player.getDamage());
        System.out.println("Money: "+ player.getMoney());
        if(player.getInventory().getDamage()>0){
            System.out.println("Weapon: "+ player.getInventory().getWeaponName());
        }if(player.getInventory().getArmor()>0){
            System.out.println("Armor: "+ player.getInventory().getArmorName());
        }
    }
    public void enemyStatus(){
        System.out.println("\n"+obstacle.getName()+"'s Status\n-----------");
        System.out.println("Health: "+ obstacle.getHealth());
        System.out.println("Damage: "+ obstacle.getDamage());
        System.out.println("Reward: "+ obstacle.getAward());
    }
    public void afterHit(){
        System.out.println("Player's Health: "+player.getHealth());
        System.out.println(obstacle.getName()+"'s Health:"+ obstacle.getHealth());
        System.out.println();
    }


}
