package ohtuesimerkki;

import org.junit.*;

import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics statistics;

    public StatisticsTest() {
        statistics = new Statistics(readerStub);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPlayerSearch() {
        Player p = new Player("Semenko", "EDM", 4, 12);
        assertEquals(statistics.search("Semenko").getName(), p.getName());
        assertNull(statistics.search("Matti"));
    }

    @Test
    public void testTeamSearchWithUnknownName() {
        assertEquals(new ArrayList<>(), statistics.team("kumpula"));
    }

    @Test
    public void testTeamSearchWithKnownName() {
        List<Player> lista = statistics.team("EDM");
        assertEquals(3, lista.size());
    }

    @Test
    public void topScoresAreCorrect() {
        List<Player> lista = statistics.topScorers(3);
        assertEquals("Gretzky", lista.get(0).getName());
        assertEquals("Lemieux", lista.get(1).getName());
    }

}