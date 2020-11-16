package battleship_game;

public class SafeHouse extends NormalLocation {
    SafeHouse(Player player) {
        super(player,"Safe House" );
    }



    @Override
    public boolean getLocation() {
        player.setHealth(player.getDefaultHealth());
        System.out.println("You are in safe House!");
        System.out.println("Your health is healed!");
        return true;
    }
}
