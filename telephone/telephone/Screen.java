/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen {
    private final PhoneModel model;

    public Screen(PhoneModel model) {
        this.model = model;
        this.model.addObserver(new PhoneObserver() {
            @Override 
            public void update(int newDigit) {
                System.out.println("Pressionando: " + newDigit);
                System.out.println(newDigit);
            }
        });

        this.model.addObserver(new PhoneObserver() {
            @Override 
            public void update(int newDigit){
                if (Screen.this.model.getDigits().size() == 12){
                    System.out.print("Agora discando ");
                    for (int d : Screen.this.model.getDigits()){
                        System.out.print(d);
                    }
                    System.out.println("...");
                }
            }

        });






    }
}
