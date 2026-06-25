package com.shopwise.model;

public class User {
    public enum Tier {GOLD, SILVER, PLATINUM}

    private String id;
    private String username;
    private String email;
    private Tier tier;
    private boolean active;

    public User() {}

    public User(String id, String username, String email, Tier tier, boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.tier = tier;
        this.active = active;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Tier getTier() { return tier; }
    public void setTier(Tier tier) { this.tier = tier; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
