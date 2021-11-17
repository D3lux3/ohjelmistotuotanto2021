
package ohtu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Comparable<Player> {

    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return name + "\t \t" + team + "\t" + goals + " + " + assists + " = " + this.sumOfPoints();
    }

    public int sumOfPoints() {
        return this.goals + this.assists;
    }

    @Override
    public int compareTo(Player p) {
        if (this.sumOfPoints() > p.sumOfPoints()) {
            return -1;
        } else if (this.sumOfPoints() == p.sumOfPoints()) {
            return 0;
        }
        return 1;
    }

}
