package com.other;

/**
 * Created by XD.Wang on 2018/1/31.
 * for test
 */
public class Pojo {

    private Long id;

    private String filed1;

    private Integer filed2;

    private Float filed3;

    private Pojo filed4;

    /**
     * test
     *
     * @param id     id
     * @param filed1 filed1
     * @param filed2 filed2
     * @param filed3 filed3
     */
    public Pojo(Long id, String filed1, Integer filed2, Float filed3) {
        this.id = id;
        this.filed1 = filed1;
        this.filed2 = filed2;
        this.filed3 = filed3;
        this.filed4 = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    public Integer getFiled2() {
        return filed2;
    }

    public void setFiled2(Integer filed2) {
        this.filed2 = filed2;
    }

    public Float getFiled3() {
        return filed3;
    }

    public void setFiled3(Float filed3) {
        this.filed3 = filed3;
    }

    public Pojo getFiled4() {
        return filed4;
    }

    public void setFiled4(Pojo filed4) {
        this.filed4 = filed4;
    }
}
