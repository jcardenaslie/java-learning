class PezDispenser {

    public static final int MAX_PEZ = 12; // quiero que sea accesible siempre desde la clase y no sea modificable
    final private String characterName; // final: can be initialized once
    private int pezCount;

    public PezDispenser(String characterName){
        this.characterName = characterName;
        pezCount = 0;
    }

    public boolean isEmpty(){
        return pezCount == 0;
    }

    public void fill(){
        fill(MAX_PEZ);
    }

    public void fill(int pezAmount){
        int newAmount = pezCount + pezAmount;
        if (newAmount > MAX_PEZ){
            throw new IllegalArgumentException("Too many PEZ!!");
        }
        pezCount = newAmount;
    }
    
    public String getCharacterName(){
        return this.characterName;
    }

    public boolean dispense(){
        boolean wasDispensed = false;
        if (!isEmpty()){
            pezCount--;
            wasDispensed = true;
        }
        return wasDispensed;
    }
}