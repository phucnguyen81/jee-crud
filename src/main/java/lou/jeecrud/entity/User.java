package lou.jeecrud.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "app_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
        name = "User.findAll",
        query = "SELECT u FROM User u"),
    @NamedQuery(
        name = "User.findByUname",
        query = "SELECT u FROM User u WHERE u.uname = :uname"),
    @NamedQuery(
        name = "User.findByEmail",
        query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(
        name = "User.findByPass",
        query = "SELECT u FROM User u WHERE u.pass = :pass"),
    @NamedQuery(
        name = "User.findByRegdate",
        query = "SELECT u FROM User u WHERE u.regdate = :regdate"),
    @NamedQuery(
        name = "User.findByFname",
        query = "SELECT u FROM User u WHERE u.fname = :fname"),
    @NamedQuery(
        name = "User.findByLname",
        query = "SELECT u FROM User u WHERE u.lname = :lname"),
    @NamedQuery(
        name = "User.findById",
        query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(
        name = "User.findByDob",
        query = "SELECT u FROM User u WHERE u.dob = :dob"),
    @NamedQuery(
        name = "User.findBySecurityQuestion",
        query = "SELECT u FROM User u WHERE u.securityQuestion = :securityQuestion"),
    @NamedQuery(
        name = "User.findBySecurityAnswer",
        query = "SELECT u FROM User u WHERE u.securityAnswer = :securityAnswer") })
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "uname")
    private String uname;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "pass")
    private String pass;

    @Basic(optional = false)
    @NotNull
    @Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fname")
    private String fname;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lname")
    private String lname;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "security_question")
    private String securityQuestion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "security_answer")
    private String securityAnswer;

    public User() {}

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id,
        String uname,
        String email,
        String pass, Date regdate,
        String fname,
        String lname, Date dob,
        String securityQuestion,
        String securityAnswer) {
        this.id = id;
        this.uname = uname;
        this.email = email;
        this.pass = pass;
        this.regdate = regdate;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in
        // the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) ||
            (this.id != null &&
                !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mano.entity.User[ id=" + id + " ]";
    }
}