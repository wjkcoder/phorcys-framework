package cn.phorcys.framework.database;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/15 3:28 下午
 */
public class BaseModel extends Model{
    /**
     * 创建人
     */
    @TableField(value = "CREATED_BY",fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "CREATION_DATE",fill = FieldFill.INSERT)
    private LocalDateTime creationDate;

    /**
     * 最后更新人
     */
    @TableField(value = "LAST_UPDATED_BY",fill = FieldFill.INSERT_UPDATE)
    private Long lastUpdatedBy;

    /**
     * 最后更新时间
     */
    @TableField(value = "LAST_UPDATE_DATE",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateDate;

    /**
     * 最后更新时登录ID
     */
    @TableField(value = "LAST_UPDATE_LOGIN",fill = FieldFill.INSERT_UPDATE)
    private Long lastUpdateLogin;

}
