package readWriteLock;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Buffer {
    private final int capacity;
    private final Deque<String> recent;
    private int discarded;
    private final FunctionalReadWriteLock guard;

    public Buffer(int capacity) {
        this.capacity = capacity;
        recent = new ArrayDeque<>(capacity);
        guard = new FunctionalReadWriteLock();
    }

    public void putItem(String item){
        guard.write(() -> {
            while (recent.size() >= capacity){
                recent.removeFirst();
                ++discarded;
            }
            recent.addLast(item);
        });
    }

    public int getDiscardedCount() {
        return guard.read(() -> discarded);
    }

    public int getTotal() {
        return guard.read(() -> discarded + recent.size());
    }

    public void flush() {
        guard.write(() -> {
            discarded += recent.size();
            recent.clear();
        });
    }

    public List<String> getRecent() {
        return guard.read(this::defensiveCopyOfRecent);
    }

    private List<String> defensiveCopyOfRecent() {
        return recent.stream().collect(toList());
    }
}
