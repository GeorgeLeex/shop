package xyz.northsky.shop.entity;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class Syscode  implements Serializable {
    private Integer id;

    private String type;

    private String proName;

    private Integer proValue;

    private Integer fId;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Integer getProValue() {
        return proValue;
    }

    public void setProValue(Integer proValue) {
        this.proValue = proValue;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}