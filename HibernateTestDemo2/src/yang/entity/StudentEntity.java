package yang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "hibernate", catalog = "")
public class StudentEntity implements Serializable{
    private int sid;
    private String sname;
    private String sex;
    private Integer fkGid;

    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @ManyToOne
    @JoinColumn(name = "fk_gid",referencedColumnName = "gid")
    public Integer getFkGid() {
        return fkGid;
    }

    public void setFkGid(Integer fkGid) {
        this.fkGid = fkGid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return sid == that.sid &&
                Objects.equals(sname, that.sname) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(fkGid, that.fkGid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid, sname, sex, fkGid);
    }

}
