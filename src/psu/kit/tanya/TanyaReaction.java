package psu.kit.tanya;

public class TanyaReaction {
    private int yayCount;
    private int whoopsCount;

    public TanyaReaction(int yayCount, int whoopsCount) {
        this.yayCount = yayCount;
        this.whoopsCount = whoopsCount;
    }

    public int getYayCount() {
        return yayCount;
    }

    public int getWhoopsCount() {
        return whoopsCount;
    }
}
