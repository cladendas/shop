package ru;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenADDOneProduct() {
        Tracker tracker = new Tracker();
        Product potato = new Product("картошка", 1,2);
        tracker.addProduct(potato);
        Product resultProduct = tracker.products[0];
        assertThat(resultProduct, is(potato));
    }
    @Test
    public void whenADDTwoProduct() {
        Tracker tracker = new Tracker();
        Product potato = new Product("картошка", 1,2);
        tracker.addProduct(potato);
        Product apple = new Product("яблоко", 25,444);
        tracker.addProduct(apple);
        Product resultProduct = tracker.products[1];
        assertThat(resultProduct, is(apple));
    }
    @Test
    public void whenREMOVEOneProduct() {
        Tracker tracker = new Tracker();
        Product potato = new Product("картошка", 1,2);
        Product prodNULL = null;
        tracker.addProduct(potato);
        tracker.removeProduct(potato.getName(),potato.getId());
        Product resultProduct = tracker.products[0];
        assertThat(resultProduct, is(prodNULL));
    }
    @Test
    public void whenREMOVETwoProduct() {
        Tracker tracker = new Tracker();
        Product potato = new Product("картошка", 1,2);
        Product apple = new Product("яблоко", 25,444);
        Product prodNULL = null;
        tracker.addProduct(potato);
        tracker.addProduct(apple);
        tracker.removeProduct(potato.getName(),potato.getId());
        tracker.removeProduct(apple.getName(),apple.getId());
        Product resultProductFirst = tracker.products[0];
        Product resultProductSecond = tracker.products[1];
        assertThat(resultProductFirst, is(prodNULL));
        assertThat(resultProductSecond, is(prodNULL));
    }
    @Test
    public void whenFINDProductTRUE() {
        Tracker tracker = new Tracker();
        Product potato = new Product("картошка", 1,2);
        tracker.addProduct(potato);
        Boolean resultProduct = tracker.findProduct(potato.getName(), potato.getId());

        assertThat(resultProduct, is(true));
    }
    @Test
    public void whenFINDProductFALSE() {
        Tracker tracker = new Tracker();
        Product potato = new Product("картошка", 1,2);
        Product apple = new Product("яблоко", 25,444);
        tracker.addProduct(potato);
        tracker.addProduct(apple);
        Boolean resultProduct = tracker.findProduct("броколи", 4);

        assertThat(resultProduct, is(false));
    }

}
