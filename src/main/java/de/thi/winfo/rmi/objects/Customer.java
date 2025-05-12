package de.thi.winfo.rmi.objects;

import java.io.Serial;
import java.io.Serializable;

public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(Long id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer no. " + id + " named " + firstName + " " + lastName + " has email " + email;
    }
}
