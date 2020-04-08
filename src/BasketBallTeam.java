import java.util.HashSet;
import java.util.Set;

public class BasketBallTeam extends Team {

    public static class BBTProps {
        int centerThresh;
        int guardthresh;
    }

    private static final int CENTER_THRESHOLD = 3;
    Set<Player> centerPlayers;
    Set<Player> guardPlayers;
    Set<Player> fwdPlayers;

    // formed team is in format "i-i-i"
    public BasketBallTeam(String formation) {
        super();
        centerPlayers = new HashSet<>();
        guardPlayers = new HashSet<>();
        fwdPlayers = new HashSet<>();
    }

    @Override
    public boolean addPlayer(Player player) {
        addToPosition(player);
        if(!isValidTeam()) {
            // undo team add for player
            //remove from position
        }
        return false;
    }

    private void addToPosition(Player player) {
        switch (player.position) {
            case "C":
                if(centerPlayers.size() < CENTER_THRESHOLD) {
                    centerPlayers.add(player);
                }
                break;
            case "G":
                break;
            case "F" :
                break;
            default :
                break;
        }
    }

    @Override
    public boolean isValidTeam() {
        return false;
    }
}
