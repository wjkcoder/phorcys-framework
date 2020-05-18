package cn.phorcys.center.db.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wonder
 * @since 2020-05-09
 */
public class SapItemRecord extends Model<SapItemRecord> {

    private static final long serialVersionUID=1L;

      private Integer id;

    private Integer batchId;

    private String itemCode;

    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SapItemRecord{" +
        "id=" + id +
        ", batchId=" + batchId +
        ", itemCode=" + itemCode +
        ", description=" + description +
        "}";
    }
}
