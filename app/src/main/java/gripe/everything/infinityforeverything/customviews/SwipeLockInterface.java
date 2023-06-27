package gripe.everything.infinityforeverything.customviews;

public interface SwipeLockInterface {
    void lockSwipe();
    void unlockSwipe();
    default void setSwipeLocked(boolean swipeLocked) {}
}
