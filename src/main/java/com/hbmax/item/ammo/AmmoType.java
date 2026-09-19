package com.hbmax.item.ammo;

public enum AmmoType {
    KINETIC("kinetic"),
    MM5("5mm"),
    BMG50("50bmg"),
    BULLET("bullet"),
    MM9("9mm"),
    R44("44"),
    GAUGE12("12gauge"),
    GAUGE20("20gauge"),
    LR22("22lr"),
    AE50("50ae"),
    BOLT75("75bolt"),
    D357("357"),
    M556("556"),
    GAUGE4("4gauge");
    private final String id;

    AmmoType(String id) { this.id = id; }
    public String getId() { return id; }

    public static AmmoType fromId(String id) {
        for (AmmoType type : values()) {
            if (type.id.equals(id)) return type;
        }
        return KINETIC;
    }
}