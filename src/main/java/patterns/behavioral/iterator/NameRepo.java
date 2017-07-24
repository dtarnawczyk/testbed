package patterns.behavioral.iterator;

public class NameRepo implements Container {
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator<Number> getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<Number> {

        int index;

        @Override
        public boolean hasNext() {

            return index < names.length;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
