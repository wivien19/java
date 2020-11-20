class Siblings {

    public static boolean areSiblings(java.io.File f1, java.io.File f2) {
        // implement me
        if (f1.getParentFile().equals(f2.getParentFile())){
            return true;
        }
        else return false;
    }
}