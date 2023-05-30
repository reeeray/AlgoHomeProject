package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.05.2023
 **/
public class MyHashSet {

    private final int BUCKET;
    private final int BUCKET_ITEM;
    private final boolean[][] STORAGE;

    public MyHashSet(final int bucket, final int bucketItem) {
        this.BUCKET = bucket;
        this.BUCKET_ITEM = bucketItem;
        this.STORAGE = new boolean[BUCKET][];
    }

    public void add(final int key) {
        final int bucket = getBucket(key);
        final int bucketItem = getBucketItem(key);

        if(STORAGE[bucket] == null) {
            STORAGE[bucket] = new boolean[BUCKET_ITEM];
        }
        STORAGE[bucket][bucketItem] = true;
    }

    public boolean contains(final int key) {
        final int bucket = getBucket(key);
        final int bucketItem = getBucketItem(key);

        if(STORAGE[bucket] != null) {
            return STORAGE[bucket][bucketItem];
        }
        return false;
    }

    public void remove(final int key) {
        final int bucket = getBucket(key);
        final int bucketItem = getBucketItem(key);

        if(STORAGE[bucket] != null) {
            STORAGE[bucket][bucketItem] = false;
        }
    }

    private int getBucket(final int key) {
        return key/BUCKET;
    }

    private int getBucketItem(final int key) {
        return key%BUCKET_ITEM;
    }
}
