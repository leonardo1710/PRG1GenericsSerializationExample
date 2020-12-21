package ac.at.fhcampuswien.characters;

/**
 * Die kleinste Art der Orks wurde Snagas genannt und ist die am meisten
 * verbreitete Ork-Art. Die Orks der Nebelgebirge gehörten dieser Rasse an.
 */
public class Snaga extends Orc {

    public Snaga() {
        super("Nebelgebirge");
        this.location = "Nebelgebirge";

        this.eat();
    }
}
