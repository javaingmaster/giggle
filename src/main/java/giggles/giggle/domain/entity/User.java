package giggles.giggle.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

import giggles.giggle.infra.constant.CheckPattern;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zty
 *
 * <p>用户实体类</p>
 */
@Table(name = "giggle_user")
public class User extends AuditDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Pattern(regexp = CheckPattern.REGEX_USERNAME)
    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Column(name = "user_gender")
    @NotNull
    private Integer userGender;

    @Pattern(regexp = CheckPattern.REGEX_EMAIL)
    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "birthday")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "user_password")
    @NotNull
    private String userPassword;

    @Column(name = "phone")
    @Pattern(regexp = CheckPattern.REGEX_MOBILE)
    private String phone;

    @Column(name = "user_location")
    private String userLocation;

    @Column(name = "avator_path")
    private String avatorPath;

    @Column(name = "user_authority")
    @NotNull
    private Integer userAuthority;

    private List<User> follow;

    private List<History> histories;

    private List<Integer> reportComments;

    private List<Integer> reportVideos;

    public User() {
    }

    public User(@NotNull String userName, @NotNull Integer userGender, @Pattern(regexp = CheckPattern.REGEX_EMAIL) @NotNull String email, @NotNull Date birthday, @NotNull String userPassword, @NotNull Integer userAuthority, Date lastUpdate, String lastUpdateBy, @NotNull Integer userVersion) {
        this.userName = userName;
        this.userGender = userGender;
        this.email = email;
        this.birthday = birthday;
        this.userPassword = userPassword;
        this.userAuthority = userAuthority;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
        this.userVersion = userVersion;
    }

    public User(@NotNull String userName, @NotNull Integer userGender, @Pattern(regexp = CheckPattern.REGEX_EMAIL) @NotNull String email, @NotNull Date birthday, @NotNull String userPassword, Date lastUpdate, String lastUpdateBy) {
        this.userName = userName;
        this.userGender = userGender;
        this.birthday = birthday;
        this.userPassword = userPassword;
        this.email = email;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getAvatorPath() {
        return avatorPath;
    }

    public void setAvatorPath(String avatorPath) {
        this.avatorPath = avatorPath;
    }

    public Integer getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(Integer userAuthority) {
        this.userAuthority = userAuthority;
    }

    public List<User> getFollow() {
        return follow;
    }

    public void setFollow(List<User> follow) {
        this.follow = follow;
    }

    public List<History> getHistories() {
        return histories;
    }

    public List<Integer> getReportComments() {
        return reportComments;
    }

    public void setReportComments(List<Integer> reportComments) {
        this.reportComments = reportComments;
    }

    public List<Integer> getReportVideos() {
        return reportVideos;
    }

    public void setReportVideos(List<Integer> reportVideos) {
        this.reportVideos = reportVideos;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                '}';
    }
}
