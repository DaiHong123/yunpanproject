package cn.qst.pojo;

import java.util.Date;

public class TbShare {
    private String sid;

    private String fids;

    private Date sharetime;

    private String uid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getFids() {
        return fids;
    }

    public void setFids(String fids) {
        this.fids = fids == null ? null : fids.trim();
    }

    public Date getSharetime() {
        return sharetime;
    }

    public void setSharetime(Date sharetime) {
        this.sharetime = sharetime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}