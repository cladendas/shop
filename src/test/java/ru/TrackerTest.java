package ru;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenUserWantADD() {
        Tracker tracker = new Tracker();
        Product prod = new Product("картошка", 1,2);
        Product pot = new Product("карка", 2,3);
        tracker.addProduct(prod);

        Product resultProduct = tracker.products[0];

        assertThat(resultProduct, is(prod));
    }


}
