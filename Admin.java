class Admin {
    private String username = "safwa";
    private int password = 1234;

    public boolean login(String enteredUsername, int enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword == password;
    }
}