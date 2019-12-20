public class Example {
    public static void main(String[] args) {
        
        System.out.println("Pez dispenser");
        
        System.out.printf("There are %d PEZ allowed in every dispenser %n",
            PezDispenser.MAX_PEZ);
        
        PezDispenser dispenser = new PezDispenser("Yoda");
        
        System.out.printf("The dispenser name %s %n",
            dispenser.getCharacterName());

        if (dispenser.isEmpty()) System.out.println("Dispenser is empty");
        
        System.out.println("Filling dispenser with delicious PEZ");
        
        dispenser.fill();
        
        if (!dispenser.isEmpty()) System.out.println("Dispenser is not empty");

        while (dispenser.dispense()) System.out.println("Chomp!");

        if (dispenser.isEmpty()) System.out.println("Ate all the PEZ");

        dispenser.fill(2);

        dispenser.fill(4);

        while (dispenser.dispense()) System.out.println("Chomp!");

        try {
            dispenser.fill(400);
            System.out.println("This will neve happen");    
        } catch (IllegalArgumentException iae) {
            System.out.printf("Error message: %s",
                iae.getMessage());
        }
        
    }
}