package ua.com.pb.showcase.model.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFilter {
    private List<Long> categoriesId;
    private List<Long> producerId;
    private BigDecimal priceFrom = BigDecimal.valueOf(0.0);
    private BigDecimal priceTo = BigDecimal.valueOf(Double.MAX_VALUE);
    private List<Boolean> onlyAvailable = Arrays.asList(Boolean.FALSE, Boolean.TRUE);

    public List<Long> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(List<Long> categoriesId) {
        this.categoriesId = categoriesId;
    }

    public List<Long> getProducerId() {
        return producerId;
    }

    public void setProducerId(List<Long> producerId) {
        this.producerId = producerId;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(BigDecimal priceTo) {
        this.priceTo = priceTo;
    }

    public List<Boolean> getOnlyAvailable() {
        return onlyAvailable;
    }

    public void setOnlyAvailable(List<Boolean> onlyAvailable) {
        this.onlyAvailable = onlyAvailable;
    }
}
