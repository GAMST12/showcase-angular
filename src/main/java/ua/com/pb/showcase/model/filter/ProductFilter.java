package ua.com.pb.showcase.model.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFilter {
    private BigDecimal priceFrom = BigDecimal.valueOf(0.0);
    private BigDecimal priceTo = BigDecimal.valueOf(Double.MAX_VALUE);

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

/*
    private List<String> categoriesId;
    private List<String> producersId;
    private BigDecimal priceFrom = BigDecimal.valueOf(0.0);
    private BigDecimal priceTo = BigDecimal.valueOf(Double.MAX_VALUE);
    private List<Boolean> availabilities = Arrays.asList(Boolean.FALSE, Boolean.TRUE);

    public List<String> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(List<String> categoriesId) {
        this.categoriesId = categoriesId;
    }

    public List<String> getProducersId() {
        return producersId;
    }

    public void setProducersId(List<String> producersId) {
        this.producersId = producersId;
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

    public List<Boolean> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Boolean> availabilities) {
        this.availabilities = availabilities;
    }
*/
}
