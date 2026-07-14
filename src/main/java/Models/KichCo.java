package Models;

public class KichCo {
    private int maSize;

    private String tenSize;

    public KichCo() {
    }

    public KichCo(int maSize, String tenSize) {
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }
}
