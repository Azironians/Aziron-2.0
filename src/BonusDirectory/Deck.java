package BonusDirectory;

import java.util.List;

public class Deck {
    private List<Bonus> collection;
    private String collectionName;
    private int priority;

    public Deck(String collectionName, int priority, List<Bonus> collection) {
        this.collection = collection;
        this.collectionName = collectionName;
        this.priority = priority;
    }

    public List<Bonus> getCollection() {
        return collection;
    }

    public void setCollection(List<Bonus> collection) {
        this.collection = collection;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deck that = (Deck) o;

        return priority == that.priority && collection.equals(that.collection) &&
                collectionName.equals(that.collectionName);
    }

    @Override
    public int hashCode() {
        int result = collection.hashCode();
        result = 31 * result + collectionName.hashCode();
        result = 31 * result + priority;
        return result;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "collection=" + collection +
                ", collectionName='" + collectionName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
