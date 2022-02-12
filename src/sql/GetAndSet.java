package sql;

/**
 *
 * @author neury-dev
 */
public class GetAndSet {
    private static int id;
    private static String usuario;
    private static String codigo;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        GetAndSet.id = id;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        GetAndSet.usuario = usuario;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        GetAndSet.codigo = codigo;
    }
}
