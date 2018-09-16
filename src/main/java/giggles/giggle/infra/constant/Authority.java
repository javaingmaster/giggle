package giggles.giggle.infra.constant;

/**
 * @author zty
 *
 * <p>authority</p>
 */
public class Authority {
    /**
     * <p>authority instruction as follow: </p>
     * <p>the v1 version of this project has an incomplete authority system which includes three roles.
     * there are public, user and admin.
     * and you only have the public authority if you do not login.
     * besides, if the developer want to add other roles with higher authority into the project like vip user... ,
     * the easy way to processing the authority of the interfaces is to add a column named user_level in giggle_user table,
     * and the column will be checked before visiting an interface</p>
     */
    public static final int PUBLIC = 1;
    public static final int USER = 2;
    public static final int ADMIN = 3;

    public static final String SECRET = "Secret_zty_1997";
}
