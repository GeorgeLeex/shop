package xyz.northsky.shop.dto;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class LabelValueBean implements Serializable {

    private String label;
    private String value;

    public LabelValueBean() {
    }

    public LabelValueBean(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
