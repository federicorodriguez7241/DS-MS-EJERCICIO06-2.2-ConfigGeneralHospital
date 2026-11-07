import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        ConfiguracionHospital recepcion = ConfiguracionHospital.getInstancia();
        ConfiguracionHospital consultorios = ConfiguracionHospital.getInstancia();

        // verificamos que sea exactamente el mismo objeto en memoria
        if (recepcion == consultorios) {
            System.out.println("Comprobacion exitosa: Ambas variables comparten la misma instancia.\n");
        }

        recepcion.setNombreHospital("Hospital Central San Martín");
        recepcion.setDuracionTurno(-15); // esto deberia tirar error
        recepcion.setDuracionTurno(20);

        recepcion.setHorarios(LocalTime.of(18, 0), LocalTime.of(10, 0)); // error de logica
        recepcion.setHorarios(LocalTime.of(7, 0), LocalTime.of(22, 0));

        System.out.println("\n--- Datos desde el módulo de consultorios ---");
        System.out.println("Nombre: " + consultorios.getNombreHospital());
        System.out.println("Horario: " + consultorios.getHorarioApertura() + " a " + consultorios.getHorarioCierre());
        System.out.println("Duración de turnos: " + consultorios.getDuracionTurno() + " minutos.");
    }
}