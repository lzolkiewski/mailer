package com.mailer.cass.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Integer magicNumber) {
        super("No records with given magic number: " + magicNumber);
    }

    public EntityNotFoundException(String email) {
        super("No messages found from: " + email);
    }
}
