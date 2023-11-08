package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries(value = {
        @NamedQuery(name = "Product.findAll", query = "select p from Product p where p.status = ?1"),
        @NamedQuery(name = "Product.findById", query = "select p from Product p where p.product_id = ?1")
        //,...1
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_id;
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Lob
    @Column(name = "description",  columnDefinition = "text", nullable = false)
    private String description;
    @Column(name = "unit", length = 25, nullable = false)
    private String unit;
    @Column(name = "manufacturer_name", length = 100, nullable = false)
    private String manufacturer;

    @Column(name = "status")
    private ProductStatus status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImageList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductPrice> productPrices = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long id) {
        this.product_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                '}';
    }


}
