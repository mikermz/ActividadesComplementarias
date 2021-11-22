package app.model;

public class ActividadComp {

    private int claveActividad;
    private int claveAlumno;
    private int claveDocente;
    private String nombreActividad;
    private String tipoActividad;
    private String fechaRealizacion;
    private String nombreAlumno;
    private String nombreDocente;
    private int semestre;
    private String carrera;

    @Override
    public String toString() {
        return "ActividadComp{" + "claveActividad=" + claveActividad + ", claveAlumno=" + claveAlumno + ", claveDocente=" + claveDocente + ", nombreActividad=" + nombreActividad + ", tipoActividad=" + tipoActividad + ", fechaRealizacion=" + fechaRealizacion + '}';
    }


    public ActividadComp( int claveAlumno, int claveDocente, String nombreActividad, String tipoActividad, String fechaRealizacion) {
        this.claveAlumno = claveAlumno;
        this.claveDocente = claveDocente;
        this.nombreActividad = nombreActividad;
        this.tipoActividad = tipoActividad;
        this.fechaRealizacion = fechaRealizacion;
    }

    public ActividadComp(int claveActividad, int claveAlumno, int claveDocente, String nombreActividad, String tipoActividad, String fechaRealizacion) {
        this.claveActividad = claveActividad;
        this.claveAlumno = claveAlumno;
        this.claveDocente = claveDocente;
        this.nombreActividad = nombreActividad;
        this.tipoActividad = tipoActividad;
        this.fechaRealizacion = fechaRealizacion;
    }

    public ActividadComp() {
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }



    public int getClaveActividad() {
        return claveActividad;
    }

    public void setClaveActividad(int claveActividad) {
        this.claveActividad = claveActividad;
    }

    public int getClaveAlumno() {
        return claveAlumno;
    }

    public void setClaveAlumno(int claveAlumno) {
        this.claveAlumno = claveAlumno;
    }

    public int getClaveDocente() {
        return claveDocente;
    }

    public void setClaveDocente(int claveDocente) {
        this.claveDocente = claveDocente;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


}
