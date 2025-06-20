package model;

/**
 * Clase que representa una persona suscrita al sistema Gamerly.
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private boolean playstation;
    private boolean xbox;
    private boolean nintendo;
    private boolean pc;
    private boolean esports;
    private String region;

    /**
     * Constructor completo para crear una persona con todos los atributos.
     * 
     * @param nombre      Nombre de la persona.
     * @param apellido    Apellido de la persona.
     * @param correo      Correo electrónico de la persona.
     * @param telefono    Número de teléfono de la persona.
     * @param playstation Indica si la persona tiene PlayStation.
     * @param xbox        Indica si la persona tiene Xbox.
     * @param nintendo    Indica si la persona tiene Nintendo.
     * @param pc          Indica si la persona tiene PC.
     * @param esports     Indica si la persona está interesada en e-sports.
     * @param region      Región de interés para e-sports.
     */
    public Persona(String nombre, String apellido, String correo, String telefono, boolean playstation, boolean xbox, boolean nintendo,
            boolean pc, boolean esports, String region) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.playstation = playstation;
        this.xbox = xbox;
        this.nintendo = nintendo;
        this.pc = pc;
        this.esports = esports;
        this.region = region;
    }

    /**
     * Constructor vacío.
     */
    public Persona() {
    }

    /**
     * Obtiene el nombre de la persona.
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre Nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * @return Apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     * @param apellido Apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * @return Correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     * @param correo Correo electrónico a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     * @return Número de teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     * @param telefono Número de teléfono a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Indica si la persona tiene PlayStation.
     * @return true si tiene PlayStation, false en caso contrario.
     */
    public boolean isPlaystation() {
        return playstation;
    }

    /**
     * Establece si la persona tiene PlayStation.
     * @param playstation true si tiene PlayStation, false en caso contrario.
     */
    public void setPlaystation(boolean playstation) {
        this.playstation = playstation;
    }

    /**
     * Indica si la persona tiene Xbox.
     * @return true si tiene Xbox, false en caso contrario.
     */
    public boolean isXbox() {
        return xbox;
    }

    /**
     * Establece si la persona tiene Xbox.
     * @param xbox true si tiene Xbox, false en caso contrario.
     */
    public void setXbox(boolean xbox) {
        this.xbox = xbox;
    }

    /**
     * Indica si la persona tiene Nintendo.
     * @return true si tiene Nintendo, false en caso contrario.
     */
    public boolean isNintendo() {
        return nintendo;
    }

    /**
     * Establece si la persona tiene Nintendo.
     * @param nintendo true si tiene Nintendo, false en caso contrario.
     */
    public void setNintendo(boolean nintendo) {
        this.nintendo = nintendo;
    }

    /**
     * Indica si la persona tiene PC.
     * @return true si tiene PC, false en caso contrario.
     */
    public boolean isPc() {
        return pc;
    }

    /**
     * Establece si la persona tiene PC.
     * @param pc true si tiene PC, false en caso contrario.
     */
    public void setPc(boolean pc) {
        this.pc = pc;
    }

    /**
     * Obtiene la región de interés para e-sports.
     * @return Región de e-sports.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Establece la región de interés para e-sports.
     * @param region Región a establecer.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Indica si la persona está interesada en e-sports.
     * @return true si está interesada en e-sports, false en caso contrario.
     */
    public boolean isEsports() {
        return esports;
    }

    /**
     * Establece si la persona está interesada en e-sports.
     * @param esports true si está interesada en e-sports, false en caso contrario.
     */
    public void setEsports(boolean esports) {
        this.esports = esports;
    }
}
