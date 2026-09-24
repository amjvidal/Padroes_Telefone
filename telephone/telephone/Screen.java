/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen implements PhoneObserver {
    private final PhoneModel model;

    public Screen(PhoneModel model) {
        this.model = model;
        this.model.addObserver(this);
    }

    @Override
    public void update(int newDigit) {
        System.out.println("Pressionando: " + newDigit);
        if (model.getDigits().size() == 12) {
            System.out.print("Agora discando ");
            for (int d : model.getDigits()) {
                System.out.print(d);
            }
            System.out.println("...");
        }
    }
}
