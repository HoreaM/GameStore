package com.soa.gamesws.model;


//import java.math.BigDecimal;

public class Game {
    private int id;
    private String name;
    private String developer;
    private int userscore;
    //    private String initialprice;
    private int initialprice;
    private int discount;
    //    private String price;
    private int price;
    private String genre;
    private int positivereviews;
    private int negativereviews;


    public Game() {
        super();
    }

    public Game(int id, String name, String developer, int userscore, int initialprice, int discount,
                int price) {
        super();
        this.id = id;
        this.name = name.replace(",", "");
        this.developer = developer.replace(",", "");
        this.userscore = userscore;
        this.initialprice = initialprice;
//        this.initialprice = new BigDecimal(initialprice).movePointLeft(2).toString();
        this.discount = discount;
//        this.price = new BigDecimal(price).movePointLeft(2).toString();
        this.price = price;
    }

    public Game(int id, String name, String developer, int userscore, int initialprice, int discount,
                int price, String genre, int positivereviews, int negativereviews) {
        super();
        this.id = id;
        this.name = name.replace(",", "");
        this.developer = developer.replace(",", "");
        this.userscore = userscore;
        this.initialprice = initialprice;
        this.discount = discount;
        this.price = price;
        this.genre = genre.replace(",", " -");
        this.positivereviews = positivereviews;
        this.negativereviews = negativereviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.replace(",", "");
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer.replace(",", "");
    }

    public int getUserscore() {
        return userscore;
    }

    public void setUserscore(int userscore) {
        this.userscore = userscore;
    }

    public int getInitialprice() {
//    public String getInitialprice() {
        return initialprice;
    }

    public void setInitialprice(int initialprice) {
//        this.initialprice = new BigDecimal(initialprice).movePointLeft(2).toString();
        this.initialprice = initialprice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPrice() {
//    public String getPrice() {
        return price;
    }

    public void setPrice(int price) {
//        this.price = new BigDecimal(price).movePointLeft(2).toString();
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        result = prime * result + price;
//        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((developer == null) ? 0 : developer.hashCode());
        result = prime * result + discount;
        result = prime * result + initialprice;
//        result = prime * result + ((initialprice == null) ? 0 : initialprice.hashCode());
        result = prime * result + userscore;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id != other.id)
            return false;
//        if (!price.equals(other.price))
        if (price != other.price)
            return false;
        if (developer == null) {
            if (other.developer != null)
                return false;
        } else if (!developer.equals(other.developer))
            return false;
        if (discount != other.discount)
            return false;
        if (initialprice != other.initialprice)
//        if (!initialprice.equals(other.initialprice))
            return false;
        return userscore == other.userscore;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + developer + "," + userscore
                + "," + initialprice + "," + discount + ","
                + price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPositivereviews() {
        return positivereviews;
    }

    public void setPositivereviews(int positivereviews) {
        this.positivereviews = positivereviews;
    }

    public int getNegativereviews() {
        return negativereviews;
    }

    public void setNegativereviews(int negativereviews) {
        this.negativereviews = negativereviews;
    }
}

