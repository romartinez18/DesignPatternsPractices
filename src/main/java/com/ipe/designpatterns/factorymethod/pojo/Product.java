package com.ipe.designpatterns.factorymethod.pojo;

/**
 *
 * @author Ronald
 */
public class Product {
    private String code;
    private String name;
    private String category;
Product() {}
    /**
     *
     * @param code
     * @param name
     * @param category
     */
    public Product(String code, String name, String category) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", category=" + category + '}';
    }
}
