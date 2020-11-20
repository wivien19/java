class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName != null){
            this.firstName = firstName;
        }
        else {
            this.firstName = "";
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            this.lastName = "";
        }
    }

    public String getFullName() {
        if (firstName.equals("") && lastName.equals("")) return "Unknown";
        else if (firstName.equals("")) return lastName;
        else if (lastName.equals("")) return firstName;
        else return firstName + " " + lastName; // write your code here
    }
    public static void main(String[] args) {
        User tim = new User();
        tim.setFirstName(null);
        tim.setLastName(null);
        System.out.println(tim.getFullName());
    }
}

