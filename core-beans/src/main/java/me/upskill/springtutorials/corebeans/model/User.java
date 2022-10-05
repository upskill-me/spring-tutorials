package me.upskill.springtutorials.corebeans.model;

/**
 * Represents a user in the system
 */
public class User {

    /**
     * This property represents the email of user
     * lets make these final as they won't change
     */
    private final String email;

    /**
     * Represents the mobile number of the user
     */
    private final String mobileNumber;

    /**
     * Create an instance of user with given email and mobile number
     *
     * @param email        the provided email
     * @param mobileNumber the provided mobile number
     */
    public User(String email, String mobileNumber) {
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    // getters and setters

    /**
     * Gets the value of email property
     *
     * @return the value of email property
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the value of mobileNumber property
     *
     * @return the value of mobileNumber property
     */
    public String getMobileNumber() {
        return mobileNumber;
    }
}
