import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Team {
    private Set<Player> players;

    public Team() {
        players = new HashSet<>();
    }

    public Team(Collection<Player> players) {
        players = new HashSet<>();
        boolean result = true;
        for(Player player: players) {
            result = result & addPlayer(player);
        }
        if(!result) {
            // throw runtime exception maybe
            players.clear();
        }
    }
    public abstract boolean addPlayer(Player player);

    public abstract boolean isValidTeam();
}
