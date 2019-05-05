public class Movie {
    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;
    private String title;
    private Price price;

    Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    private void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    String getTitle() {
        return title;
    }
}
