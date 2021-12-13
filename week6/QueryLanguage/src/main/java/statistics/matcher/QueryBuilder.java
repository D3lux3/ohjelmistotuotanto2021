package statistics.matcher;

public class QueryBuilder {

    Matcher m;

    public QueryBuilder() {
        this.m = new All();
    }

    public Matcher build() {
        return this.m;
    }

    public QueryBuilder playsIn(String team) {
        this.m = new And(this.m, new PlaysIn(team));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.m = new Or(matchers);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(this.m, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(new HasFewerThan(value, category), m);
        return this;
    }
}
