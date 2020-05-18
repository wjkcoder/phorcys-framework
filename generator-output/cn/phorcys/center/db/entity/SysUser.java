package cn.phorcys.center.db.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wonder
 * @since 2020-05-15
 */
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID=1L;

    /**
     * 创建人
     */
      @TableField(value = "CREATED_BY", fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * 创建时间
     */
      @TableField(value = "CREATION_DATE", fill = FieldFill.INSERT)
    private LocalDateTime creationDate;

    /**
     * 最后更新人
     */
      @TableField(value = "LAST_UPDATED_BY", fill = FieldFill.INSERT_UPDATE)
    private Long lastUpdatedBy;

    /**
     * 最后更新时间
     */
      @TableField(value = "LAST_UPDATE_DATE", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateDate;

    /**
     * 最后更新时登录ID
     */
      @TableField(value = "LAST_UPDATE_LOGIN", fill = FieldFill.INSERT_UPDATE)
    private Long lastUpdateLogin;

    /**
     * 用户ID，由系统自动生成，保证全局唯一
     */
      @TableId("USER_ID")
    private String userId;

    /**
     * 关联SYS_TENANT表中的主键ID
     */
    @TableField("TENANT_ID")
    private Long tenantId;

    /**
     * 用户类型
     */
    @TableField("USER_TYPE")
    private String userType;

    /**
     * 用户名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 用户描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * 密码，加密后密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 昵称
     */
    @TableField("NICK_NAME")
    private String nickName;

    /**
     * 名
     */
    @TableField("FIRST_NAME")
    private String firstName;

    /**
     * 姓
     */
    @TableField("LAST_NAME")
    private String lastName;

    /**
     * 电话
     */
    @TableField("PHONE_NUMBER")
    private String phoneNumber;

    /**
     * 电话区号
     */
    @TableField("PHONE_AREA_CODE")
    private String phoneAreaCode;

    /**
     * 地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 工号
     */
    @TableField("EMPLOYEE_NUMBER")
    private String employeeNumber;

    /**
     * 部门
     */
    @TableField("DEPARTMENT")
    private String department;

    /**
     * 图片链接ID
     */
    @TableField("PICTURE_ID")
    private Long pictureId;

    /**
     * ID证件类型
     */
    @TableField("ID_TYPE")
    private String idType;

    /**
     * ID证件号
     */
    @TableField("ID_CARD")
    private String idCard;

    /**
     * 上次密码设置日期
     */
    @TableField("LAST_PASSWORD_DATE")
    private LocalDateTime lastPasswordDate;

    /**
     * 密码有效时长，以天为单位
     */
    @TableField("PASSWORD_EXPIRATION")
    private Integer passwordExpiration;

    /**
     * 登录有效时间，以天为单位
     */
    @TableField("LOGIN_EXPIRATION")
    private Integer loginExpiration;

    /**
     * 活动有效时间，以天为单位
     */
    @TableField("ACTIVE_EXPIRATION")
    private Integer activeExpiration;

    /**
     * 最后登录日期
     */
    @TableField("LAST_LOGIN_DATE")
    private LocalDateTime lastLoginDate;

    /**
     * 密码错误次数
     */
    @TableField("PASSWORD_ERROR_TIMES")
    private Integer passwordErrorTimes;

    /**
     * 密码重置标记
     */
    @TableField("PASSWORD_RESET_FLAG")
    private String passwordResetFlag;

    /**
     * 登入次数
     */
    @TableField("LOGIN_COUNT")
    private Long loginCount;

    /**
     * 登录自动启动项
     */
    @TableField("AUTO_START_MENU_ID")
    private Long autoStartMenuId;

    /**
     * 生效日期
     */
    @TableField("START_DATE")
    private LocalDate startDate;

    /**
     * 失效日期
     */
    @TableField("END_DATE")
    private LocalDate endDate;

    /**
     * 逻辑删除标记
     */
    @TableField("DELETE_FLAG")
    @TableLogic
    private Boolean deleteFlag;


    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public LocalDateTime getLastPasswordDate() {
        return lastPasswordDate;
    }

    public void setLastPasswordDate(LocalDateTime lastPasswordDate) {
        this.lastPasswordDate = lastPasswordDate;
    }

    public Integer getPasswordExpiration() {
        return passwordExpiration;
    }

    public void setPasswordExpiration(Integer passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }

    public Integer getLoginExpiration() {
        return loginExpiration;
    }

    public void setLoginExpiration(Integer loginExpiration) {
        this.loginExpiration = loginExpiration;
    }

    public Integer getActiveExpiration() {
        return activeExpiration;
    }

    public void setActiveExpiration(Integer activeExpiration) {
        this.activeExpiration = activeExpiration;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getPasswordErrorTimes() {
        return passwordErrorTimes;
    }

    public void setPasswordErrorTimes(Integer passwordErrorTimes) {
        this.passwordErrorTimes = passwordErrorTimes;
    }

    public String getPasswordResetFlag() {
        return passwordResetFlag;
    }

    public void setPasswordResetFlag(String passwordResetFlag) {
        this.passwordResetFlag = passwordResetFlag;
    }

    public Long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    public Long getAutoStartMenuId() {
        return autoStartMenuId;
    }

    public void setAutoStartMenuId(Long autoStartMenuId) {
        this.autoStartMenuId = autoStartMenuId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "createdBy=" + createdBy +
        ", creationDate=" + creationDate +
        ", lastUpdatedBy=" + lastUpdatedBy +
        ", lastUpdateDate=" + lastUpdateDate +
        ", lastUpdateLogin=" + lastUpdateLogin +
        ", userId=" + userId +
        ", tenantId=" + tenantId +
        ", userType=" + userType +
        ", userName=" + userName +
        ", description=" + description +
        ", password=" + password +
        ", nickName=" + nickName +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", phoneNumber=" + phoneNumber +
        ", phoneAreaCode=" + phoneAreaCode +
        ", address=" + address +
        ", email=" + email +
        ", employeeNumber=" + employeeNumber +
        ", department=" + department +
        ", pictureId=" + pictureId +
        ", idType=" + idType +
        ", idCard=" + idCard +
        ", lastPasswordDate=" + lastPasswordDate +
        ", passwordExpiration=" + passwordExpiration +
        ", loginExpiration=" + loginExpiration +
        ", activeExpiration=" + activeExpiration +
        ", lastLoginDate=" + lastLoginDate +
        ", passwordErrorTimes=" + passwordErrorTimes +
        ", passwordResetFlag=" + passwordResetFlag +
        ", loginCount=" + loginCount +
        ", autoStartMenuId=" + autoStartMenuId +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
