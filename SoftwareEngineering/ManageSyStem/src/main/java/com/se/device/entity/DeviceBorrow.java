package com.se.device.entity;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device_borrow")
@EntityListeners(AuditingEntityListener.class)
public class DeviceBorrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "device_id")
    private Integer device_id;

    @Column(name = "device_name")
    private String device_name;

    @Column(name = "dp_id")
    private Integer dp_id;

    @Column(name = "dp_name")
    private String dp_name;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "user_name")
    private String user_name;

    //申请设备的批准人员
    @Column(name = "authorize_id")
    private Integer authorize_id;

    @Column(name = "authorize_name")
    private String authorize_name;


    @Column(name = "authorize_result")
    private String authorize_result = "等待审核";

    @Column(name = "do_what", length = 600)
    private String do_what;

    //管理人员同意设备转借的时间
    @Temporal(TemporalType.DATE)
    @Column(name = "start_time")
    private Date start_time;

    @Temporal(TemporalType.DATE)
    @Column(name = "back_time")
    private Date back_time;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_time")
    private Date return_time;


    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "backup")
    private String backup;

    
    public DeviceBorrow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }

    public Integer getDp_id() {
        return dp_id;
    }

    public void setDp_id(Integer dp_id) {
        this.dp_id = dp_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDo_what() {
        return do_what;
    }

    public void setDo_what(String do_what) {
        this.do_what = do_what;
    }

    public Date getBack_time() {
        return back_time;
    }

    public void setBack_time(Date back_time) {
        this.back_time = back_time;
    }

    public Date getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Date return_time) {
        this.return_time = return_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDp_name() {
        return dp_name;
    }

    public void setDp_name(String dp_name) {
        this.dp_name = dp_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Integer getAuthorize_id() {
        return authorize_id;
    }

    public void setAuthorize_id(Integer authorize_id) {
        this.authorize_id = authorize_id;
    }

    public String getAuthorize_name() {
        return authorize_name;
    }

    public void setAuthorize_name(String authorize_name) {
        this.authorize_name = authorize_name;
    }

    public String getAuthorize_result() {
        return authorize_result;
    }

    public void setAuthorize_result(String authorize_result) {
        this.authorize_result = authorize_result;
    }

    @Override
    public String toString() {
        return "DeviceBorrow{" +
                "id=" + id +
                ", device_id=" + device_id +
                ", device_name='" + device_name + '\'' +
                ", dp_id=" + dp_id +
                ", dp_name='" + dp_name + '\'' +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", do_what='" + do_what + '\'' +
                ", back_time=" + back_time +
                ", return_time=" + return_time +
                ", create_time=" + create_time +
                ", backup='" + backup + '\'' +
                '}';
    }


}
