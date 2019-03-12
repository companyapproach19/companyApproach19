package company;

public class ActorBBDD {

    private String nombreUsuario;
    private String passwordPlana;
    private String passwordSalt = null;
    private String email = null;
    private String usuarioPrevio = null;
    private int tipoActor = 0;

    public ActorBBDD(String nombreUsuario, String passwordSalt, String email,String usuarioPrevio, int tipoActor){
        this.nombreUsuario = nombreUsuario;
        this.passwordSalt = passwordSalt;
        this.email = email;
        this.usuarioPrevio = usuarioPrevio;
        this.tipoActor = tipoActor;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordPlana() {
        return passwordPlana;
    }

    public void setPasswordPlana(String passwordPlana) {
        this.passwordPlana = passwordPlana;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuarioPrevio() {
        return usuarioPrevio;
    }

    public void setUsuarioPrevio(String usuarioPrevio) {
        this.usuarioPrevio = usuarioPrevio;
    }

    public int getTipoActor() {
        return tipoActor;
    }

    public void setTipoActor(int tipoActor) {
        this.tipoActor = tipoActor;
    }
}
