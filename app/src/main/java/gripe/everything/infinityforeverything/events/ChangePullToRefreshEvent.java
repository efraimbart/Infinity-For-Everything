package gripe.everything.infinityforeverything.events;

public class ChangePullToRefreshEvent {
    public boolean pullToRefresh;

    public ChangePullToRefreshEvent(boolean pullToRefresh) {
        this.pullToRefresh = pullToRefresh;
    }
}
