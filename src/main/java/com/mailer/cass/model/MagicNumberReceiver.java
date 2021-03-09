package com.mailer.cass.model;

public class MagicNumberReceiver {
    private Integer magic_number;

    public Integer getMagicNumber() {
        return magic_number;
    }

    public void setMagicNumber(Integer magic_number) {
        this.magic_number = magic_number;
    }

    @Override
    public String toString() {
        return "MagicNumberReceiver{" +
                "magic_number=" + magic_number +
                '}';
    }
}
