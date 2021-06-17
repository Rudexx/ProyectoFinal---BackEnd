package resources.pojos;

public class PetCasePOJO {
    private String created_ad;
    private String type;
    private String description;
    private String pet_id;

    public PetCasePOJO(String created_ad, String type, String description, String pet_id) {
        this.created_ad = created_ad;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
    }

    public PetCasePOJO() {
    }

    public String getCreated_ad() {
        return created_ad;
    }

    public void setCreated_ad(String created_ad) {
        this.created_ad = created_ad;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }
}
