package ua.com.pb.showcase.model.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFilter {
    private long categoryId;
    private long producerId;
    private BigDecimal priceFrom = BigDecimal.valueOf(0.0);
    private BigDecimal priceTo = BigDecimal.valueOf(Double.MAX_VALUE);
    private boolean onlyAvailable = false;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getProducerId() {
        return producerId;
    }

    public void setProducerId(long producerId) {
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

    public boolean isOnlyAvailable() {
        return onlyAvailable;
    }

    public void setOnlyAvailable(boolean onlyAvailable) {
        this.onlyAvailable = onlyAvailable;
    }

    @Override
    public String toString() {
        return "ProductFilter{" +
                "categoryId=" + categoryId +
                ", producerId=" + producerId +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                ", onlyAvailable=" + onlyAvailable +
                '}';
    }
}
