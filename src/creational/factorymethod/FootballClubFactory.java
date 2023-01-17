package creational.factorymethod;

public class FootballClubFactory {
    private FootballClubFactory() {

    }

    public static FootballClub getFootballClub(FCType fcType) throws Exception {
        switch (fcType) {
            case CHELSEA:
                return new Chelsea();
            case BARCELONA:
                return new Barcelona();
            default:
                throw new Exception("Not found instance...");
        }
    }
}
