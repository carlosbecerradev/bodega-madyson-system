package bean;

public class Empleado {
    
    private String nombEmp; //nombre + apePat + apeMat
    private String cargoEmp;
    private String dni;
    private String usuario;
    private String contrasenia;
    private String generoEmp;
    private int estadoEmp;

    public Empleado(String nombEmp, String cargoEmp, String dni, String usuario, String contrasenia, String generoEmp, int estadoEmp) {
        this.nombEmp = nombEmp;
        this.cargoEmp = cargoEmp;
        this.dni = dni;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.generoEmp = generoEmp;
        this.estadoEmp = estadoEmp;
    }

    public Empleado(String usuario, String contrasenia, String cargoEmp, int estadoEmp) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cargoEmp = cargoEmp;
        this.estadoEmp = estadoEmp;
    }

    public String getNombEmp() {
        return nombEmp;
    }

    public void setNombEmp(String nombEmp) {
        this.nombEmp = nombEmp;
    }

    public String getCargoEmp() {
        return cargoEmp;
    }

    public void setCargoEmp(String cargoEmp) {
        this.cargoEmp = cargoEmp;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getGeneroEmp() {
        return generoEmp;
    }

    public void setGeneroEmp(String generoEmp) {
        this.generoEmp = generoEmp;
    }

    public int getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(int estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    
    
}
