class Test {

    public static void main(String[] args) {
        new Programmer(1);
    }

    public static class TeamLead {
        private int numTeamLead = 1;

        public TeamLead(int numTeamLead) {
            this.numTeamLead = numTeamLead;
            employ2();
        }

        protected void employ2() {
            System.out.println(numTeamLead + " teamlead");
        }

    }

    public static class Programmer extends TeamLead {
        private int numProgrammer;

        public Programmer(int numProgrammer) {
            super(numProgrammer);
            this.numProgrammer = numProgrammer;
            employ();

        }

        protected void employ() {
            System.out.println(numProgrammer + " programmer");
        }
    }
}