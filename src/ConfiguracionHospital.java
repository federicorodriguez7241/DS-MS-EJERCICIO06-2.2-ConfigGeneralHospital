import java.time.LocalTime;

public class ConfiguracionHospital {

    // unica instancia del singleton
    private static ConfiguracionHospital instancia;

    private String nombreHospital;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private int duracionTurno;

    private ConfiguracionHospital() {
        this.nombreHospital = "Hospital General";
        this.horarioApertura = LocalTime.of(8, 0);
        this.horarioCierre = LocalTime.of(20, 0);
        this.duracionTurno = 30;
    }

    public static ConfiguracionHospital getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionHospital(); // se crea solo la primera vez
        }
        return instancia;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        if (nombreHospital == null || nombreHospital.isBlank()) {
            System.out.println("Error: El nombre no puede estar vacío.");
        } else {
            this.nombreHospital = nombreHospital;
        }
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarios(LocalTime apertura, LocalTime cierre) {
        // comprobamos que el cierre no sea antes de la apertura
        if (cierre.isAfter(apertura)) {
            this.horarioApertura = apertura;
            this.horarioCierre = cierre;
        } else {
            System.out.println("Error: El cierre debe ser posterior a la apertura.");
        }
    }

    public int getDuracionTurno() {
        return duracionTurno;
    }

    public void setDuracionTurno(int duracionTurno) {
        if (duracionTurno > 0) {
            this.duracionTurno = duracionTurno;
        } else {
            System.out.println("Error: La duración debe ser positiva.");
        }
    }
}