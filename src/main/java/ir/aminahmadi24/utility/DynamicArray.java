package ir.aminahmadi24.utility;

public class DynamicArray {
    private Object[] items;
    private int size;
    private final String className;

    public DynamicArray(String className){
        items = new Object[10];
        size = 0;
        this.className = className;
    }

    public boolean add(Object item){
        if(!item.getClass().getSimpleName().equals(className))
            return false;
        if(size == items.length){
            resize();
        }
        items[size] = item;
        size++;
        return true;
    }

    public boolean remove(int index) {
        if(index >= size)
            return false;
        if(items[index] != null && index == size - 1){
            items[index] = null;
            return true;
        }
        if(items[index] != null && items[index + 1] == null){
            items[index] = null;
            return true;
        }
        if(items[index] != null && items[index + 1] != null){
            for (int i = index; i < size; i++) {
                items[i] = null;
                items[i] = items[i+1];
                items[i+1] = null;
            }
            return true;
        }
        return false;
    }

    public Object getByIndex(int index){
        if(index >= 0 && index < items.length)
            return items[index];
        return null;
    }
    private void resize() {
        Object[] newItems = new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }
    public int getSize() {
        return size;
    }
    public void clear(){
        items = new Object[10];
        size = 0;
    }
    public boolean contains(Object item){
        if(!item.getClass().getSimpleName().equals(className))
            return false;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item))
                return true;
        }
        return false;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
