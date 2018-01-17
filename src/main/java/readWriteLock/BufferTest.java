package readWriteLock;

public class BufferTest {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);
        buffer.putItem("pierwszy");
        getBufferInfo(buffer);
        buffer.putItem("drugi");
        getBufferInfo(buffer);
        buffer.putItem("trzeci");
        getBufferInfo(buffer);
        buffer.putItem("czwarty");
        getBufferInfo(buffer);
        buffer.putItem("piąty");
        getBufferInfo(buffer);

    }

    private static void getBufferInfo(Buffer buffer){
        System.out.printf("Discarted count: %d \n", buffer.getDiscardedCount());
        System.out.printf("Recent count: %s \n", buffer.getRecent());
        System.out.printf("Total count: %d \n", buffer.getTotal());
    }
}
