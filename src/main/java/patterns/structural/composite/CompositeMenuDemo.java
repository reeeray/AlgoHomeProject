package patterns.structural.composite;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public class CompositeMenuDemo {

    public static void main(String[] args) {
        final Menu mainMenu = new Menu("Main", "/main");
        final MenuItem safetyMenu = new MenuItem("Safety", "/safety");

        mainMenu.add(safetyMenu);

        final Menu claimsSubMenu = new Menu("Claims", "/claims");

        mainMenu.add(claimsSubMenu);

        final MenuItem personalClaimsMenu = new MenuItem("Personal Claim", "/personalClaims");
        claimsSubMenu.add(personalClaimsMenu);

        System.out.println(mainMenu.toString());

    }
}
