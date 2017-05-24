package ua.com.pb.showcase.dao.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class Category {
    private long id;
    private String name;
    private MainCategory mainCategory;

    public Category(long id, String name, MainCategory mainCategory) {
        this.id = id;
        this.name = name;
        this.mainCategory = mainCategory;
    }

    public Category(String name, MainCategory mainCategory) {
        this.name = name;
        this.mainCategory = mainCategory;
    }

    public Category() {
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

    public MainCategory getMainCategory() {
        return mainCategory;
    }

    @XmlElement
    public void setMainCategory(MainCategory mainCategory) {
        this.mainCategory = mainCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (!mainCategory.equals(category.mainCategory)) return false;
        if (!name.equals(category.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + mainCategory.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainCategory=" + mainCategory +
                '}';
    }
}
