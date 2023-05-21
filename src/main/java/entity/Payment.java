package entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Payment {
    @SerializedName("id")
    private String id;
    @SerializedName("userId")
    private int userId;
    @SerializedName("sum")
    private int sum;

    public Payment() {

    }

    public Payment(String id, int userId, int sum) {
        this.id = id;
        this.userId = userId;
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + this.userId;
        hash = 97 * hash + this.sum;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Payment other = (Payment) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.sum, other.sum)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}