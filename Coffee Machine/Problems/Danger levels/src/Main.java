enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);
    int num;
    DangerLevel(int num) {
        this.num = num;
    }

    public int getLevel(){
        return num;
    }
}