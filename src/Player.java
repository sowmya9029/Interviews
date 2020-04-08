import java.util.Comparator;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    public String position;
    private double points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public int compareTo(Player player) {
        return Double.compare(points,player.points);
    }

    public static class PlayerComparator implements Comparator<Player>
    {
        @Override
        public int compare(Player o1, Player o2) {
            return Double.compare(o1.getPoints(),o2.getPoints());
        }
    }
}
