package ua.com.pb.showcase.dao.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
public class Product {

    private long id;
    private String name;
    private Producer producer;
    private Category category;
    private String description;
    private BigDecimal price;
    private boolean available;

    public Product()
    {    }

    public Product(String name, Producer producer, Category category, String description, BigDecimal price, boolean available) {
        this.name = name;
        this.producer = producer;
        this.category = category;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public Product(long id, String name, Producer producer, Category category, String description, BigDecimal price, boolean available) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.category = category;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducer() {
        return producer;
    }

    @XmlElement
    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Category getCategory() {
        return category;
    }

    @XmlElement
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    @XmlElement
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (available != product.available) return false;
        if (id != product.id) return false;
        if (!category.equals(product.category)) return false;
        if (!description.equals(product.description)) return false;
        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        if (!producer.equals(product.producer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + (available ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer=" + producer +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
