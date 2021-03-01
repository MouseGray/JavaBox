import org.junit.Assert;
import org.junit.Test;

public class BoxTest {
    @Test
    public void createTest(){
        Box<Integer> box = new Box<>(0);

        Assert.assertEquals(0, box.size());

        Assert.assertFalse(box.put(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeSizeTest(){
        Box<Integer> box = new Box<>(-1);
    }

    @Test(expected = OutOfMemoryError.class)
    public void bigSizeTest(){
        Box<Integer> box = new Box<>(Integer.MAX_VALUE - 10000);
    }

    @Test
    public void putAndGet() {
        Box<Integer> box = new Box<>(1);
        box.put(12);
        Assert.assertEquals(new Integer(12), box.get());
    }

    @Test
    public void overflow() {
        Box<Integer> box = new Box<>(1);
        Assert.assertTrue(box.put(12));
        Assert.assertFalse(box.put(13));
        Assert.assertEquals(1, box.size());
    }

    @Test
    public void putAndRemove() {
        Box<Integer> box = new Box<>(2);
        box.put(12);
        box.put(13);
        Assert.assertEquals(2, box.size());

        box.remove(12);
        Assert.assertEquals(1, box.size());
        Assert.assertEquals(new Integer(13), box.get());
    }
}
