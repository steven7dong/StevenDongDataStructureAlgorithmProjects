public class FinancialEntity {
    private String id;
    private String creditRating;
    private String type;


    public FinancialEntity(String id, String creditRating, String type){
        this.id = id;
        this.creditRating = creditRating;
        this.type = type;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FinancialEntity{" +
                "id='" + getId() + '\'' +
                ", creditRating='" + getCreditRating() + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
